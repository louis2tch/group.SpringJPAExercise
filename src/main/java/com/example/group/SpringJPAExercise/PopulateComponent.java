package com.example.group.SpringJPAExercise;

import com.example.group.SpringJPAExercise.model.Address;
import com.example.group.SpringJPAExercise.model.Employee;
import com.example.group.SpringJPAExercise.model.Project;
import com.example.group.SpringJPAExercise.repo.AddressRepository;
import com.example.group.SpringJPAExercise.repo.EmployeeRepository;
import com.example.group.SpringJPAExercise.repo.ProjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

//Populator

@Component
public class PopulateComponent implements CommandLineRunner {
    @Resource
    private EmployeeRepository employeeStorage;
    @Resource
    private AddressRepository addressStorage;
    @Resource
    private ProjectRepository projectStorage;

    @Override
    public void run(String... args) throws Exception {



        Address address1 = new Address("1234 Hiddenburg Lane", "N/A", "4B",
                "Nashville", "TN", "1234", "0000", "Hamilton", "USA");
       // address1.setId();
        addressStorage.save(address1);
        Address address2 = new Address("567 Left St.", "N/A", "001",
                "Cleveland", "OH", "1234", "0000", "Lake", "USA");
        addressStorage.save(address2);

        Employee employee1 = new Employee("Joe", "Rob", "Smucker",
                "Jr.", address1 );
        employeeStorage.save(employee1);
        Employee employee2 = new Employee("Sarah", "Jay", "Holland",
                "Dr.", address2 );
        employeeStorage.save(employee2);
        Employee employee3 = new Employee("Luke", "Tom", "Bell",
                "Sr.", address2 );
        employeeStorage.save(employee3);
        Employee employee4 = new Employee("Bob", "Rob", "Johnson",
                "Mr.", address2 );
        employeeStorage.save(employee4);
        Employee employee5 = new Employee("Henry", "Nick", "Pete",
                "Sr.", address1 );
        employeeStorage.save(employee5);
        Employee employee6 = new Employee("Roger", "N.", "King",
                "Mr.", address1 );
        employeeStorage.save(employee6);
        Employee employee7 = new Employee("He", "ick", "GI Joe",
                "mr.", address1 );
        employeeStorage.save(employee7);

        Project project1 = new Project("Manhattan Project", employee1, employee2, employee4,
                employee6);
        projectStorage.save(project1);
        Project project2 = new Project("Not The Manhattan Project", employee1, employee3,
                employee5, employee7);
        projectStorage.save(project2);

    }




}
