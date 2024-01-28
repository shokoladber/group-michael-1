package org.launchcode.IndigenoUS_Seed_Exchange_Network.controllers;

import org.launchcode.IndigenoUS_Seed_Exchange_Network.data.BlogData;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.models.Blog;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;


@Controller
public class BlogController {

    private BlogData blogData = new BlogData();

@GetMapping
    public String blog(Model model) {
    Object attributeName;
    model.addAttribute("title", "ISEN Blog");
    model.addAttribute("blogs", BlogData.getAll());

        return "blog";

    }

@GetMapping("/new-post")
    public String newPostForm(){
        return "newPost";
        }

@PostMapping("/new-post")
    public String handlePostForm(Model model, @ModelAttribute Blog blog){
 model.addAttribute("blog", blog);
 blogData.add(blog);
    return "displayPost";
}
}



//this syntax blogData.add is mocking how database work, but is exactly how to save something in a database
//Review video maybe STL Women + WebDev Unit 2, Class 11, starting at 24:09/54:51 if confused. good info