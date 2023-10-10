package com.symplifica.demouser.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


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

    @NotNull(message = "Last Name is required ")
    @Size(min=1, message = "Last Name is required ")
    @Column (name = "last_Name")
    private String lastName;

    @NotNull(message = "Email is required ")
    @Size(min=1, message = "Email is required ")
    @Column (name = "email")
    private String email;

    @Min(value = 999999999, message = "telephone number cannot contain more or less than 10 digits")
    //@Max(value = 999999999, message = "telephone number cannot contain more or less than 10 digits")
    @Column (name = "phone_number")
    private long phone_number=0;

    @NotNull(message = "Password is required ")
    @Size(min=1, message = "Password is required ")
    @Column (name = "password")
    private String password;




    // define all constructors

    public User() {
    }

    public User(String firstName, String lastName, String email, int phone_number,String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone_number = phone_number;
        this.password = password;
    }
    //define getters and setter

    public String getPassword() {
        return password;
    }

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

    public void setPassword(String password) {
        this.password = password;
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

    public long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(long phone_number) {
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
                ", password='" + password + '\'' +
                '}';
    }
}
