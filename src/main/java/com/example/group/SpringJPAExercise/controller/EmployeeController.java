package com.example.group.SpringJPAExercise.controller;

import com.example.group.SpringJPAExercise.model.Employee;
import com.example.group.SpringJPAExercise.repo.AddressRepository;
import com.example.group.SpringJPAExercise.repo.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Resource
    EmployeeRepository employeeRepo;
    @Resource
    AddressRepository addressRepo;

    @RequestMapping("")
    public String AddEmployee(Model modelAdd, Model modelEmp){
       modelAdd.addAttribute("addresses",addressRepo.findAll());
       modelEmp.addAttribute("employees",employeeRepo.findAll());
        return "employees";
    }

    @GetMapping("/{id}")
    public String displaySingleEmployee(Model model, @PathVariable Long id){
        model.addAttribute("employee",employeeRepo.findById(id).get());
        return "single-employee";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@RequestParam String firstName,
                              @RequestParam String middleName, @RequestParam String lastName,
                              @RequestParam String suffix, @RequestParam Long addressId){
        //Long id = Long.parseLong(employeeId);
        //Employee employeeAddress = employeeRepo.findById(id).get();
        Employee employeeToAdd = new Employee(firstName, middleName, lastName, suffix, addressRepo.findById(addressId).get());
        employeeRepo.save(employeeToAdd);
        //employeeAddress.addEmployee(employeeToAdd);
        //employeeRepo.save(employeeToAdd);
        return "redirect:/employees";

    }

}
