package org.launchcode.IndigenoUS_Seed_Exchange_Network.controllers;

import jakarta.validation.Valid;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.data.SeedRepository;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.models.Seed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@Controller
public class DataBaseController {
    @Autowired
    private SeedRepository seedRepository;

    @GetMapping ({"/dataBase"})
    public String dataBase(Model model) {
        model.addAttribute("seeds", seedRepository.findAll());
        return "dataBase";
    }

    @GetMapping("/dataBase/add")
    public String displayAddSeedForm(Model model) {
        model.addAttribute("seed", "Add Seed");
        model.addAttribute(new Seed());
        model.addAttribute("seed", seedRepository.findAll());
        return "add";
    }

    @GetMapping("/add")
    public String processAddSeedForm(@ModelAttribute @Valid Seed newSeed,
                                    Errors errors, Model model, @PathVariable int id) {

        if (errors.hasErrors()) {
            model.addAttribute("seed", "Add Seed");
            return "add";
        }

        Seed botanicalName = seedRepository.findById(id).orElse(new Seed());
        newSeed.setBotanicalName(String.valueOf(botanicalName));

        Seed commonName = seedRepository.findById(id).orElse(new Seed());
        newSeed.setCommonName(String.valueOf(commonName));

        Seed seedQuantity = seedRepository.findById(id).orElse(new Seed());
        newSeed.setSeedQuantity(Integer.valueOf(String.valueOf(seedQuantity)));

        Seed plantHardinessZone = seedRepository.findById(id).orElse(new Seed());
        newSeed.setPlantHardinessZone(new String[]{String.valueOf(plantHardinessZone)});

        Seed isEndangered = seedRepository.findById(id).orElse(new Seed());
        newSeed.setEndangered(Boolean.valueOf(String.valueOf(isEndangered)));

        Seed isIndigenous = seedRepository.findById(id).orElse(new Seed());
        newSeed.setSourceIsIndigenous(Boolean.valueOf(String.valueOf(isIndigenous)));

        return "redirect:";
    }

    @GetMapping("/seed/{seedId}")
    public String displayViewSeed(Model model, Seed seed, @PathVariable int seedId) {
        Optional optSeed = seedRepository.findById(seedId);
        if (optSeed.isPresent()) {
            seed = (Seed) optSeed.get();
            model.addAttribute("seed", seed);
            return "view";
        } else {
            return "redirect:../";
        }
    }
}
