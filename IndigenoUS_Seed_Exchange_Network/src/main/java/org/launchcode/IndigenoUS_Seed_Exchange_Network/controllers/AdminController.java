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
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BlogRepository blogRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @GetMapping("")
    public String displayAdminDashboard(Model model) {
        List<User> users = (List<User>) userRepository.findAll();
        model.addAttribute("users", users);
        model.addAttribute("user", new User());
        return "admin/dashboard";
    }

    @PostMapping("/addUser")
    public String processAddUser(@ModelAttribute User user, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/dashboard";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
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
    public String processEditUser(@PathVariable int id, @ModelAttribute User updatedUser, BindingResult result) {
        if (result.hasErrors()){
            return "admin/editUser";
        }
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setEmail(updatedUser.getEmail());
            user.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
            userRepository.save(user);
        }
        return "redirect:/admin";
    }

    @PostMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
        return "redirect:/admin";
    }

//    @GetMapping("/blog")
//    public String blog(Model model) {
//        Object attributeName;
//        model.addAttribute("title", "ISEN Blog");
//        model.addAttribute("blogs",blogRepository.findAll());
//
//        return "blog";
//
//    }
//
//    @GetMapping("singleblog/{id}")
//    public String getSingleBlog(Model model, Blog blog, @PathVariable int id) {
//        Optional optBlog = blogRepository.findById(id);
//        if (optBlog.isPresent()) {
//            blog = (Blog) optBlog.get();
//            model.addAttribute("blog", blog);
//            return "singleblog";
//        } else {
//            return "404";
//        }
//    }
//
//    @GetMapping("/blog/{id}/edit")
//    public String editForm(Model model, Blog blog, @PathVariable int id) {
//        Optional optBlog = blogRepository.findById(id);
//        if (optBlog.isPresent()) {
//            blog = (Blog) optBlog.get();
//            model.addAttribute("blog", blog);
//            return "edit";
//        } else {
//            return "404";
//        }
//    }
//
//    @PostMapping("/blog/{id}/edit")
//    public String updateExistingBlog(Model model, @PathVariable int id, Blog blog) {
//
//        Optional<Blog> optBlog = blogRepository.findById(id);
//        if (optBlog.isPresent()) {
//            Blog existingBlog = optBlog.get();
//            // Update the existing blog with the new data
//            existingBlog.setTitle(blog.getTitle());
//            existingBlog.setAuthor(blog.getAuthor());
//            existingBlog.setContent(blog.getContent());
//            // Save the updated blog
//            blogRepository.save(existingBlog);
//            model.addAttribute("blogs", blogRepository.findAll());
//            return "blog";
//        } else {
//            return "404";
//        }
//    }
//
//    @GetMapping("/blog/{id}/delete")
//    public String deleteByPostById(@PathVariable int id) {
//        blogRepository.deleteById(id);
//
//        return "delete";
//    }
//
//
//
//
//    @GetMapping("/new-post")
//    public String newPostForm(Model model){
//        model.addAttribute("blog", new Blog());
//
//        return "newPost";
//    }
//
//
//
//    @PostMapping("/new-post")
//    public String handlePostForm(Model model, @ModelAttribute @Valid Blog blog, Errors errors){
//        model.addAttribute("blog", blog);
//        if(errors.hasErrors()){
//            return "newPost";
//        }
//
//        blogRepository.save(blog);
//        model.addAttribute("blogs", blogRepository.findAll());
//        return "blog";
//    }
}
