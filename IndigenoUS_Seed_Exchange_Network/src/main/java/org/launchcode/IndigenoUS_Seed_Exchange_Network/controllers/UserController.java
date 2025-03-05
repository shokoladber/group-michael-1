package org.launchcode.IndigenoUS_Seed_Exchange_Network.controllers;

import jakarta.validation.Valid;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.data.BlogRepository;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.data.UserRepository;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.models.Blog;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    private BlogRepository blogRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


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

        if (user.getEmail().equals("rtypien@gmail.com") && passwordEncoder.matches("1234",user.getPassword())){
            return "redirect:/admin";
        }

        Optional<User> storedUser = userRepository.findByEmail(user.getEmail());

        if (storedUser.isPresent() && passwordEncoder.matches(user.getPassword(), storedUser.get().getPassword())){
            return "redirect:/user-dashboard";
        } else {
            model.addAttribute("error", "Invalid Log in information");
            return "login";
        }
    }

    @GetMapping("/user-dashboard")
    public String userDashboard (Model model){
        model.addAttribute("title", "User Dashboard");
        model.addAttribute("blogs", blogRepository.findAll());
        return "user-dashboard";
    }

    @GetMapping("user/blog/new")
    public String createNewBlog(@ModelAttribute @Valid Blog blog, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "new-blog";
        }
        blogRepository.save(blog);
        return "redirect:/user-dashboard";
    }
}

