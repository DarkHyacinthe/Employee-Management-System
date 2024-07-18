package com.Hyacinthe.EmployeeManagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emID" , nullable = false)
    private Long id;
    @NotEmpty(message = "First name is required")
    @Size(min =2, message = "First name should have at least 2 characters")
    private String firstName;
    @NotEmpty(message = "First name is required")
    @Size(min =2, message = "Last name should have at least 2 characters")
    private String lastName;
    @NotEmpty(message = "Email is required")
    @Size(min =2, message = "Email should be valid and have @ in it")
    private String email;

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
