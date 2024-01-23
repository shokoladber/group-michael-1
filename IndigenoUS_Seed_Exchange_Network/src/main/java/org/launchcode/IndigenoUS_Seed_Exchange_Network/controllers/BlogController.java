package org.launchcode.IndigenoUS_Seed_Exchange_Network.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class BlogController {


@GetMapping

    public String blog(Model model) {
    Object attributeName;
    model.addAttribute("title", "ISEN Blog");
        return "blog";

    }
@GetMapping("/new-post")
    public String newPostForm(){
        return "newPost";
}
}
