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

    @GetMapping("/edit/{id}")
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

    @PostMapping("/edit/{id}")
    public String updateExistingPost(Model model, @PathVariable int id, Blog blog) {

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

  //  @GetMapping("/delete/{id}")


    @GetMapping("/new-post")
    public String newPostForm(Model model){
    model.addAttribute("blog", new Blog());

        return "newPost";
        }

 //   @GetMapping("/imageFilePath")
 //   public String getListImages(Model model) {


//        return "images";
//    }

@PostMapping("/new-post")
    public String handlePostForm(Model model, @ModelAttribute @Valid Blog blog, Errors errors){//,@RequestParam("filename") MultipartFile file) throws IOException {
   // StringBuilder fileNames = new StringBuilder();
//Path fileNameAndPath = Paths.get("./src/uploads", file.getOriginalFilename());
//    fileNames.append(file.getOriginalFilename());
 //   Files.write(fileNameAndPath, file.getBytes());
//    blog.setImage(fileNameAndPath.toString());
    model.addAttribute("blog", blog);
    //model.addAttribute("admins", adminRepository.findAll());
    if(errors.hasErrors()){
        return "newPost";
    }

 blogRepository.save(blog);
    return "displayPost";
}
}

//push

//this syntax blogData.add is mocking how database work, but is exactly how to save something in a database
//Review video maybe STL Women + WebDev Unit 2, Class 11, starting at 24:09/54:51 if confused. good info