package com.example.group.SpringJPAExercise.controller;

import com.example.group.SpringJPAExercise.model.Address;
import com.example.group.SpringJPAExercise.repo.AddressRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("/addresses")
public class AddressController {

    @Resource
    private AddressRepository addressRepo;

    @GetMapping("")
    public String addAddress(Model model){
        model.addAttribute("addresses", addressRepo.findAll());
        return "addresses";
    }

    @GetMapping("/{id}")
    public String displayEmployeeAddress(Model model, @PathVariable Long id){
        model.addAttribute("address", addressRepo.findById(id).get());
        return "single-address";
    }

    @PostMapping("/addAddress")
    public String addAddress(@RequestParam String addressOne,
                             @RequestParam String addressTwo, @RequestParam String aptNum,
                             @RequestParam String city,
                             @RequestParam String state, @RequestParam String zip,
                             @RequestParam String zipFour, @RequestParam String county,
                             @RequestParam String country){
        Address addressToAdd = new Address(addressOne, addressTwo, aptNum, city, state,
                zip, zipFour, county, country);
        addressRepo.save(addressToAdd);
        return "redirect:/addresses";
    }

}
