package com.coffee.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
// SQL table name
@Table(name = "users")
public class User {

    // Creates a user table with id, userName, email, and password columns
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userName;

    // Creates a unique constraint on the email column
    @Column (unique = true)
    private String email;

    // The property may only be written (set) as part of deserialization
    // but will not be read (get) for serialization. Value is not included in
    // serialization
    @Column
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    // Default constructor
    public User() {
    }

    // Constructor
    public User(Long id, String userName, String email, String password) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    // gets the user id
    public Long getId() {
        return id;
    }

    // sets the user id
    public void setId(Long id) {
        this.id = id;
    }

    // gets the user's username
    public String getUserName() {
        return userName;
    }

    // sets the user's username
    public void setUserName(String userName) {
        this.userName = userName;
    }

    // gets the user's email
    public String getEmail() {
        return email;
    }

    // sets the user's email
    public void setEmail(String email) {
        this.email = email;
    }

    // gets the user's password
    public String getPassword() {
        return password;
    }

    // sets the user's password
    public void setPassword(String password) {
        this.password = password;
    }

    // returns string representation
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}