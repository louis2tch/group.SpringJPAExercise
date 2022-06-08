package com.example.group.SpringJPAExercise.controller;

import com.example.group.SpringJPAExercise.model.Employee;
import com.example.group.SpringJPAExercise.repo.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Controller
public class HomeController {
    @Resource
    private EmployeeRepository employeeRepo;

    @GetMapping("/")
    public String displayHomePage(Model model){
        model.addAttribute("employees",employeeRepo.findAll());
        return "home";
    }

}
