package org.launchcode.IndigenoUS_Seed_Exchange_Network.controllers;

import jakarta.validation.Valid;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.models.Seed;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.data.SeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/dataBase")
public class DataBaseController {

    @Autowired
    private SeedRepository seedRepository;

    @GetMapping ({"/", ""})
    public String index(Model model) {
        model.addAttribute("seeds", seedRepository.findAll());
        return "dataBase";
    }

    @GetMapping("add")
    public String displayAddSeedForm(Model model) {
        model.addAttribute("title", "Add Seed");
//        model.addAttribute(new Seed());
        model.addAttribute("seed", seedRepository.findAll());
        return "add";
    }

    @PostMapping("add")
    public String processAddSeedForm(@ModelAttribute @Valid Seed newSeed,
                                    Errors errors, Model model, @RequestParam int seedId, @RequestParam List<Integer> seeds) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Seed");
            return "add";
        }
//        Seed = seeds.findById(seedId).orElse(new Seed());
//        newSeed.setSeed(seeds);

        return "redirect:";
    }

    @GetMapping("/seeds/{seedId}")
    public String displayViewSeed(Model model, @PathVariable int seedId) {
        Optional optSeed = seedRepository.findById(seedId);
        if (optSeed.isPresent()) {
            Seed seeds = (Seed) optSeed.get();
            model.addAttribute("seeds", seeds);
            return "seeds";
        } else {
            return "redirect:../";
        }
    }
}
