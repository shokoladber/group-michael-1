package org.launchcode.IndigenoUS_Seed_Exchange_Network.controllers;

import org.launchcode.IndigenoUS_Seed_Exchange_Network.models.Admin;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.data.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    AdminRepository adminRepository;

    @GetMapping
    public String addNewAdmin(Model model) {
        model.addAttribute(new Admin());
        return "admin/new";
    }

    @PostMapping
    public String handleNewAdmin(Model model, @ModelAttribute Admin admin) {
        model.addAttribute("admin", admin);
        adminRepository.save(admin);
        return "admin/added";
    }
}
