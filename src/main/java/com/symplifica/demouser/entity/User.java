package com.symplifica.demouser.entity;

import jakarta.persistence.*;

@Entity
@Table (name="user")
public class User {

    // define all fields
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;
    @Column (name = "first_Name")
    private String firstName;

    @Column (name = "last_Name")
    private String lastName;

    @Column (name = "email")
    private String email;
    @Column (name = "phone_number")
    private int phone_number;



    // define all constructors

    public User() {
    }

    public User(String firstName, String lastName, String email, int phone_number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone_number = phone_number;
    }
    //define getters and setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }


    // define toString

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone_number=" + phone_number +
                '}';
    }
}
