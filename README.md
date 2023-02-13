# spring-boot-unit-test

# Unit Testing:

A mock object is a proxy interface to hide an underlying dependency with cannot be tested in a test environment e.g. database, network locations etc.

# @Mock

This annotation creates mocks and @InjectMocks creates actual objects and injects mocked dependencies into it.

# @InjectMocks
-Use @InjectMocks when actual method body needs to be executed for a given class.
-Use @InjectMocks when we need all or few internal dependencies initialized with mock objects to work method correctly.
-Use @Mock to create mocks that are needed to support the testing of SUT(System under test)

# @SpringBootTest
With the @SpringBootTest annotation, Spring Boot provides a convenient way to start up an application context to be used in a tests. The @SpringBootTest annotation loads the complete Spring application context.

# @WebMvcTest
The @WebMvcTest test slice annotation will set up our application context with just enough components and configurations required to test our web controller layer. For instance, it will set up our @Controller’s, @ControllerAdvice’s, a MockMvc bean, and some other auto configuration.
–The @WebMvcTest annotation is used for Spring MVC tests. It disables full auto-configuration and instead applies only configuration relevant to MVC tests.

# @Mock / Mockito.Mock()
The Mockito.mock() method allows us to create a mock object of a class or an interface.
This annotation is a shorthand for the Mockito.mock() method. It's important to note that we should only use it in a test class

# @MockBean
We can use the @MockBean to add mock objects to the Spring application context. The mock will replace any existing bean of the same type in the application context. If no bean of the same type is defined, a new one will be added.
This annotation is useful in integration tests where a particular bean, like an external service, needs to be mocked. To use this annotation, we have to use SpringRunner to run the test

# @MockMvc
Use Spring MockMVC to perform integration testing of REST controllers.
The MockMVC class is part of the Spring test framework and helps in testing the controllers by explicitly starting a Servlet container.

# @AutoConfigureMockMvc
The @AutoConfigureMockMvc annotation will automatically configure the MockMvc object when used in combination with @SpringBootTest.

# Example:
this.mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk())
.andExpect(content().string(containsString("Hello, Mock")));

# References:
https://github.com/Java-Techie-jt/spring-boot-mockito

https://github.com/Java-Techie-jt/spring-mockito-example

https://www.geeksforgeeks.org/spring-boot-mockmvc-example/

https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockmvc-example/

https://www.youtube.com/watch?v=kXhYu939_5s&t=877s

https://www.youtube.com/watch?v=fN8VAdYfJB8&t=1559s

https://www.youtube.com/watch?v=RbZvXCAtMus&t=479s


