package com.example.group.SpringJPAExercise.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class Employee {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;
    @ManyToMany
    private Collection<Address> addresses;
    @ManyToMany
    private Collection<Employee> employees;
    @ManyToMany
    private Collection<Project> projects;


    public Employee(String firstName, String middleName, String lastName, String suffix, Address... addresses) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.addresses = List.of(addresses);
    }

    public Employee(){

    }

    public void addEmployee( Employee employee){
       employees.add(employee);
    }

    public void addProjects(Project project) {
        projects.add(project);
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSuffix() {
        return suffix;
    }

//    public Collection<Project> getProjects(){
//        return projects;
//    }
//
//    public Collection<Employee> getEmployees(){
//        return employees;
//    }
//
//    public void setEmployees(Employee employee){
//        employees.add(employee);
//    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName=" + middleName +
                ", lastName='" + lastName + '\'' +
                ", suffix='" + suffix + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(firstName, employee.firstName) &&
                Objects.equals(middleName, employee.middleName) && Objects.equals(lastName, employee.middleName) &&
                Objects.equals(suffix, employee.suffix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, middleName, lastName, suffix);
    }

}

