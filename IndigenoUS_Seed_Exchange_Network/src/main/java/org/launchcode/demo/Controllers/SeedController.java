package org.launchcode.demo.controllers;

import org.launchcode.demo.data.SeedData;
import org.launchcode.demo.models.Seed;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SeedController {

    private SeedData seedData = new SeedData();

    @GetMapping
    public String home(Model model){
        model.addAttribute("title", "IndigenoUS Seed Exchange Network");
        model.addAttribute("statuses", SeedData.getAll());
        return "home";
    }

    @GetMapping("/new-seed")
    public String newSeedForm() {return "newSeed";}

    @PostMapping("/new-seed")
    public String handleSeedForm(Model model, @ModelAttribute Seed seed){
        model.addAttribute("seed", seed);
        seedData.add(seed);
        return "displaySeed";
    }
}
