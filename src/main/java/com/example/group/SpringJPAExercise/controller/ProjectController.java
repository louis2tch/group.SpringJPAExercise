package com.example.group.SpringJPAExercise.controller;

import com.example.group.SpringJPAExercise.model.Employee;
import com.example.group.SpringJPAExercise.model.Project;
import com.example.group.SpringJPAExercise.repo.AddressRepository;
import com.example.group.SpringJPAExercise.repo.EmployeeRepository;
import com.example.group.SpringJPAExercise.repo.ProjectRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;



@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Resource
    private ProjectRepository projectRepo;

    @Resource
    private EmployeeRepository employeeRepo;


    @RequestMapping("")
    public String AddProject(Model modelProj, Model modelEmp){

        modelProj.addAttribute("projects",projectRepo.findAll());
        modelEmp.addAttribute("employees",employeeRepo.findAll());
        //modelEmp.addAttribute("employees",employeeRepo.findAllById());
        return "projects";
    }

    @GetMapping("/{id}")
    public String displaySingleProject(Model model, @PathVariable Long id){
        model.addAttribute("project", projectRepo.findById(id).get());
        return "single-project";
    }

    @PostMapping("/addProject")
    public String addProject(@RequestParam String projectName, @RequestParam String employeesId){

        ArrayList<Employee> employeeList = new ArrayList<>();
        Project projectToAdd = new Project(projectName);//new Project();

        String[] employeeS = employeesId.split(",");


       for(String empIdString : employeeS){
           Long employeeId = Long.parseLong(empIdString);
           employeeList.add(employeeRepo.findById(employeeId).get());
//           projectToAdd.addEmployee(employeeRepo.findById(employeeId).get());
          }
        //projectToAdd = new Project(projectName,projectToAdd.addEmployee((Employee) projectToAdd.getEmployees());
       //Iterator<Employee> emp = employeeList.iterator();

        //System.out.println(Arrays.toString(projectToAdd.getEmployees().toArray()));

       if(employeeS.length == 1)
            projectToAdd = new Project(projectName, employeeList.get(0));
        if(employeeS.length == 2)
            projectToAdd = new Project(projectName, employeeList.get(0), employeeList.get(1));
        if(employeeS.length == 3)
            projectToAdd = new Project(projectName, employeeList.get(0), employeeList.get(1), employeeList.get(2));
        if(employeeS.length == 4)
            projectToAdd = new Project(projectName, employeeList.get(0), employeeList.get(1), employeeList.get(2), employeeList.get(3));
        if(employeeS.length == 5)
            projectToAdd = new Project(projectName, employeeList.get(0), employeeList.get(1), employeeList.get(2), employeeList.get(3), employeeList.get(4));
//            for(int i=0;i<employeeList.size();i++){
//                projectToAdd.addEmployee(employeeList.get(i));
//            }
        projectRepo.save(projectToAdd);
        return "redirect:/projects";//+ employeesId+'#'+employeeS.length+"#"+employeeList.get(0).getFirstName()
    }

}
