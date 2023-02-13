package com.rupesh.springboot.unittest.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity( name = "company_user")
@Table(name = "company_user")
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @Column(name="email",unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    public User() {
    }
    public User(Long id, String name, String email, UserType userType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.userType = userType;
    }

    public User(String name, String email, UserType userType) {
        this.name = name;
        this.email = email;
        this.userType = userType;
    }
}
