package org.launchcode.IndigenoUS_Seed_Exchange_Network.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;


@Controller
public class BlogController {

    private Map<String, String> titleStore = new HashMap<>();

@GetMapping
    public String blog(Model model) {
    Object attributeName;
    model.addAttribute("title", "ISEN Blog");
    model.addAttribute("titles", titleStore);
        return "blog";

    }
@GetMapping("/new-post")
    public String newPostForm(){
        return "newPost";
        }

@PostMapping("/new-post")
    public String handlePostForm(Model model, @RequestParam String title, String author){
    model.addAttribute("title", title);
    model.addAttribute("author", author);
    titleStore.put(title, author);
    return "displayPost";
}
}



