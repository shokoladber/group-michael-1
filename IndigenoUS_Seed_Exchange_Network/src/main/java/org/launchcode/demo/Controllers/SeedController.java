package org.launchcode.demo.controllers;

import jakarta.validation.Valid;
import org.launchcode.demo.models.Seed;
import org.launchcode.demo.models.data.SeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("seeds")
public class SeedController {

    @Autowired
    private SeedRepository seedRepository;
    private static List<String> seeds = new ArrayList<>();

    @GetMapping ("/")
    public String index(Model model) {
        model.addAttribute("seeds", seedRepository.findAll());
        return "index";
    }

    @GetMapping("add")
    public String displayAddSeedForm(Model model) {
        model.addAttribute(new Seed());
        model.addAttribute("employers", seedRepository.findAll());
        return "seeds/add";
    }

    @PostMapping("add")
    public String processAddSeedForm(@ModelAttribute @Valid Seed newSeed,
                                         Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Seeds");
            return "seeds/add";
        }
        seedRepository.save(newSeed);
        return "redirect:";
    }

    @GetMapping("view/{seedId}")
    public String displayViewSeed(Model model, @PathVariable int seedId) {

        Optional optSeed = seedRepository.findById(seedId);
        if (optSeed.isPresent()) {
            Seed seed = (Seed) optSeed.get();
            model.addAttribute("seed", seed);
            return "seeds/view";
        } else {
            return "redirect:../";
        }

    }
}
