package com.example.group.SpringJPAExercise.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class Project {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String projectName;
    @ManyToMany(mappedBy = "projects")
    private Collection<Employee> employees;


    public Project(String projectName, Employee... employees) {
        this.projectName = projectName;
        this.employees = List.of(employees);
    }

    public Project(){

    }

    public void addEmployee(Employee employee){

            employees.add(employee);

    }



    public Long getId() {
        return id;
    }

    public String getProjectName() {
        return projectName;
    }

    public Collection<Employee> getEmployees(){
        return employees;
    }
//
//    public void setEmployees(Employee employee){
//        employees.add(employee);
//    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;
       // return Objects.equals(id, project.id) && Objects.equals(projectName, project.projectName);

        if (id != null ? !id.equals(project.id) : project.id != null) return false;
        return projectName != null ? projectName.equals(project.projectName) : project.projectName == null;

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectName);
    }

}
