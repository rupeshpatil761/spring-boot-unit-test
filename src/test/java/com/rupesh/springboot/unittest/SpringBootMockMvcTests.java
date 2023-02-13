package com.rupesh.springboot.unittest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rupesh.springboot.unittest.model.User;
import com.rupesh.springboot.unittest.model.UserType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
//@WebMvcTest(controllers = UserController.class)
@AutoConfigureMockMvc
public class SpringBootMockMvcTests {

    @Autowired
    private MockMvc mockMvc;

    ObjectMapper om = new ObjectMapper();

    @Test
    public void testGetSpecificUser() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/users/1").
                content(MediaType.APPLICATION_JSON_VALUE)).
                //andDo(MockMvcResultHandlers.print()).
                andExpect(MockMvcResultMatchers.status().isOk()).
                andReturn();

        String resultContent = result.getResponse().getContentAsString();
        User response = om.readValue(resultContent, User.class);
        Assert.assertTrue(response.getId() == 1l);
    }

    @Test
    public void addUserTest() throws Exception {
        User user = new User("Amol2","Amol2@test.com", UserType.USER);
        String jsonRequest = om.writeValueAsString(user);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/users").content(jsonRequest)
                .contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        String resultContent = result.getResponse().getContentAsString();
        User response = om.readValue(resultContent, User.class);
        Assert.assertTrue(response.getId() == 5l);
    }
}
