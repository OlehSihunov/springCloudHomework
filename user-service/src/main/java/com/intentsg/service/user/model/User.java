package com.intentsg.service.user.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name ="users")
@Component
@Scope("prototype")
public class User {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userId;
    @Column(name ="first_name")
    String name;
    @Column(name = "last_name")
    String lastName;

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

