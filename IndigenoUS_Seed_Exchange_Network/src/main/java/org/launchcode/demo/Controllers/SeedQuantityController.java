package org.launchcode.demo.controllers;

import jakarta.validation.Valid;
import org.launchcode.demo.models.SeedQuantity;
import org.launchcode.demo.models.data.SeedQuantityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("seedQuantities")
public class SeedQuantityController {

    @Autowired
    private SeedQuantityRepository seedQuantityRepository;

    @GetMapping ({"/", ""})
    public String index(Model model) {
        model.addAttribute("seedQuantities", seedQuantityRepository.findAll());
        return "index";
    }

    @GetMapping("add")
    public String displayAddSeedQuantityForm(Model model) {
        model.addAttribute(new SeedQuantity());
        model.addAttribute("seedQuantities", seedQuantityRepository.findAll());
        return "seedQuantities/add";
    }

    @PostMapping("add")
    public String processAddSeedQuantityForm(@ModelAttribute @Valid SeedQuantity newSeedQuantity,
                                      Errors errors, Model model) {
        if (errors.hasErrors()) {
        model.addAttribute("title", "Add Seed Quantities");
            return "seedQuantities/add";
        }
        seedQuantityRepository.save(newSeedQuantity);
        return "redirect:";
    }

    @GetMapping("view/{seedQuantitiesId}")
    public String displayViewSeedQuantity(Model model, @PathVariable int seedQuantitiesId) {

        Optional optSeedQuantities = seedQuantityRepository.findById(seedQuantitiesId);
        if (optSeedQuantities.isPresent()) {
            SeedQuantity seedQuantity = (SeedQuantity) optSeedQuantities.get();
            model.addAttribute("seedQuantity", seedQuantity);
            return "seedQuantities/view";
        } else {
            return "redirect:../";
        }

    }
}
