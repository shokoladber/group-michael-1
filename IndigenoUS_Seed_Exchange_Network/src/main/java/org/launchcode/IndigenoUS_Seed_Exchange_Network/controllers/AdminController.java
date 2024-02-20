package org.launchcode.IndigenoUS_Seed_Exchange_Network.controllers;

import org.launchcode.IndigenoUS_Seed_Exchange_Network.data.UserRepository;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public String displayAdminDashboard(Model model) {
        List<User> users = (List<User>) userRepository.findAll();
        model.addAttribute("users", users);
        model.addAttribute("user", new User());
        return "admin/dashboard";
    }

    @PostMapping("/addUser")
    public String processAddUser(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/admin";
    }

    @GetMapping("/editUser/{id}")
    public String displayEditUserForm(@PathVariable int id, Model model) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            model.addAttribute("user", userOptional.get());
            return "admin/editUser";
        } else {
            return "redirect:/admin";
        }
    }

    @PostMapping("/editUser/{id}")
    public String processEditUser(@PathVariable int id, @ModelAttribute User updatedUser) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            userRepository.save(user);
        }
        return "redirect:/admin";
    }

    @PostMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
        return "redirect:/admin";
    }
}
