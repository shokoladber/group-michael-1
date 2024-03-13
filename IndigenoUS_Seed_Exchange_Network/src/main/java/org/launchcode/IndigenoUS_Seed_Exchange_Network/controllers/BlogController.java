package org.launchcode.IndigenoUS_Seed_Exchange_Network.controllers;

import jakarta.validation.Valid;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.data.AdminRepository;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.data.BlogData;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.data.BlogRepository;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.models.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.nio.file.Files;



@Controller
public class BlogController {

    @Autowired
    BlogRepository blogRepository;

    public static final String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";



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
    @GetMapping("/uploads/{fileName:.+}")
    @ResponseBody
    public ResponseEntity<byte[]> serveFile(@PathVariable String fileName) throws IOException {
        Resource file = new FileSystemResource(UPLOAD_DIRECTORY + File.separator + fileName);
        if (file.exists() && file.isReadable()) {
            byte[] data = Files.readAllBytes(file.getFile().toPath());
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            headers.setContentDisposition(ContentDisposition.builder("inline").filename(fileName).build());
            return new ResponseEntity<>(data, headers, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/new-post")
    public String handlePostForm(Model model, @ModelAttribute Blog blog, @RequestParam(value = "image", required = false) MultipartFile image) throws IOException {
        if (image != null && !image.isEmpty()) {
            String fileName = image.getOriginalFilename();
            File uploadedFile = new File(UPLOAD_DIRECTORY + File.separator + fileName);
            image.transferTo(uploadedFile);
            blog.setImageUrl("/uploads/" + fileName);
        }

        blogRepository.save(blog);
        model.addAttribute("blogs", blogRepository.findAll());
        return "blog";
    }
}

//push

//this syntax blogData.add is mocking how database work, but is exactly how to save something in a database
//Review video maybe STL Women + WebDev Unit 2, Class 11, starting at 24:09/54:51 if confused. good info