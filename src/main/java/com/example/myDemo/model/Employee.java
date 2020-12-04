package com.example.myDemo.model;

import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter@Getter@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    public Employee(String firstName,String lastName, String email) {
        this.firstName = firstName;
        this.email = email;
        this.lastName = lastName;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;
}
