package com.employee.EmployeeApplication.entity;

import javax.persistence.*;

@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int employeeId;
    //Checking columns of database
    @Column(name = "full_name")
    String fullName;
    @Column(name = "city")
    String city;
    @Column(name = "email")
    String email;

    public Employee() {

    }

    public Employee(int employeeId, String fullName, String city, String email) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.city = city;
        this.email = email;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
