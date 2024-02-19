package org.launchcode.IndigenoUS_Seed_Exchange_Network.controllers;

import jakarta.validation.Valid;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.data.AdminRepository;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.data.UserRepository;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.models.Admin;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/login")
    public String showLoginForm (Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute @Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "login";
        }

        Optional<Admin> admin = adminRepository.findByEmail(user.getEmail());
        if (admin.isPresent()) {
            return "redirect:/admin/dashboard";
        }

        Optional<User> storedUser = userRepository.findByEmail(user.getEmail());

        if (storedUser.isPresent() && storedUser.get().getPassword().equals(user.getPassword())){
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Invalid Log in information");
            return "login";
        }
    }
}

