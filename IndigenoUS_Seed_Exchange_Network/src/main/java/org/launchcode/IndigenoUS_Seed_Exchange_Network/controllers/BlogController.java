package org.launchcode.IndigenoUS_Seed_Exchange_Network.controllers;

import jakarta.validation.Valid;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.data.AdminRepository;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.data.BlogData;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.data.BlogRepository;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.models.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.util.Optional;

@Controller
public class BlogController {
@Autowired
BlogRepository blogRepository;
@Autowired
AdminRepository adminRepository;

@GetMapping("/blog")
    public String blog(Model model) {
    Object attributeName;
    model.addAttribute("title", "ISEN Blog");
    model.addAttribute("blogs",blogRepository.findAll());

        return "blog";

    }

    @GetMapping("singleblog/{id}")
    public String getSingleBlog(Model model, Blog blog, @PathVariable int id) {
        Optional optBlog = blogRepository.findById(id);
        if (optBlog.isPresent()) {
            blog = (Blog) optBlog.get();
            model.addAttribute("blog", blog);
            return "singleblog";
        } else {
            return "404";
        }
    }

       @GetMapping("/blog/{id}/edit")
       public String editForm(Model model, Blog blog, @PathVariable int id) {
       Optional optBlog = blogRepository.findById(id);
           if (optBlog.isPresent()) {
               blog = (Blog) optBlog.get();
               model.addAttribute("blog", blog);
               return "edit";
           } else {
               return "404";
           }
       }

      @PostMapping("/blog/{id}/edit")
       public String updateExistingBlog(Model model, @PathVariable int id, Blog blog) {

           Optional<Blog> optBlog = blogRepository.findById(id);
           if (optBlog.isPresent()) {
               Blog existingBlog = optBlog.get();
               // Update the existing blog with the new data
               existingBlog.setTitle(blog.getTitle());
               existingBlog.setAuthor(blog.getAuthor());
               existingBlog.setContent(blog.getContent());
               // Save the updated blog
               blogRepository.save(existingBlog);
               model.addAttribute("blogs", blogRepository.findAll());
               return "blog";
           } else {
               return "404";
           }
       }

       @GetMapping("/blog/{id}/delete")
       public String deleteByPostById(@PathVariable int id) {
           blogRepository.deleteById(id);

               return "delete";
           }




    @GetMapping("/new-post")
    public String newPostForm(Model model){
    model.addAttribute("blog", new Blog());

        return "newPost";
        }



    @PostMapping("/new-post")
    public String handlePostForm(Model model, @ModelAttribute @Valid Blog blog, Errors errors){
        model.addAttribute("blog", blog);
        if(errors.hasErrors()){
            return "newPost";
        }

        blogRepository.save(blog);
        model.addAttribute("blogs", blogRepository.findAll());
        return "blog";
    }
}

//push

//this syntax blogData.add is mocking how database work, but is exactly how to save something in a database
//Review video maybe STL Women + WebDev Unit 2, Class 11, starting at 24:09/54:51 if confused. good info