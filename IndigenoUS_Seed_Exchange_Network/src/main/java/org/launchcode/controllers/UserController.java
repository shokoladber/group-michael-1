package org.launchcode.controllers;

import jakarta.validation.Valid;
import org.launchcode.model.User;
import org.launchcode.model.data.UserRepository;
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
        Optional<User> storedUser = userRepository.findByEmail(user.getEmail());

        if (storedUser.isPresent() && storedUser.get().getPassword().equals(user.getPassword())){
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Invalid Log in information");
            return "login";
        }
    }
}

