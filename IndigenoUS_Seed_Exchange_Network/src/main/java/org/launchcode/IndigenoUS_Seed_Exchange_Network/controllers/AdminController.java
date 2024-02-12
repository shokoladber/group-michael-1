package org.launchcode.IndigenoUS_Seed_Exchange_Network.controllers;


import org.launchcode.IndigenoUS_Seed_Exchange_Network.data.UserRepository;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.data.AdminRepository;
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
    private AdminRepository adminRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public String displayAllUsers(Model model){
        List<User> users = (List<User>) userRepository.findAll();
        model.addAttribute("users", users);
        return "admin/dashboard";
    }

    @GetMapping("/users/{id}/edit")
    public String displayEditUserForm(@PathVariable int id, Model model){
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            model.addAttribute("user", userOptional.get());
            return "admin/editUser";
        } else {
            return "redirect:/admin/users";
        }
    }

    @PostMapping("/users/{id}/edit")
    public String processEditUser(@PathVariable int id, @ModelAttribute User updatedUser){
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()){
            User user = userOptional.get();
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            userRepository.save(user);
        }
        return "redirect:/admin/users";
    }

    @GetMapping("/addUser")
    public String displayAddUserForm(Model model) {
        model.addAttribute("title", "Add User");
        model.addAttribute("user", new User());
        return "admin/addUser";
    }

    @PostMapping("/addUser")
    public String processAddUser(Model model, @ModelAttribute User user){
        userRepository.save(user);
        return "redirect:/admin/users";
    }

    @PostMapping("/users/{id}/delete")
    public String deleteUser (@PathVariable int id){
        userRepository.deleteById(id);
        return "redirect:/admin/users";
    }
}

