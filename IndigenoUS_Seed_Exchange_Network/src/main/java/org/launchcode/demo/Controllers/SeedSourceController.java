package org.launchcode.demo.controllers;

import jakarta.validation.Valid;
import org.launchcode.demo.models.SeedSource;
import org.launchcode.demo.models.data.SeedSourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

public class SeedSourceController {
    @Autowired
    private SeedSourceRepository seedSourceRepository;

    @GetMapping ({"/", ""})
    public String index(Model model) {
        model.addAttribute("seedSources", seedSourceRepository.findAll());
        return "index";
    }

    @GetMapping("add")
    public String displayAddSeedSourceForm(Model model) {
        model.addAttribute(new SeedSource());
        model.addAttribute("seedSources", seedSourceRepository.findAll());
        return "seedSources/add";
    }

    @PostMapping("add")
    public String processAddSeedSourceForm(@ModelAttribute @Valid SeedSource newSeedSource,
                                      Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Seed Sources");
            return "seedSources/add";
        }
        seedSourceRepository.save(newSeedSource);
        return "redirect:";
    }

    @GetMapping("view/{seedSourcesId}")
    public String displayViewSeedSource(Model model, @PathVariable int seedSourcesId) {

        Optional optSeedSources = seedSourceRepository.findById(seedSourcesId);
        if (optSeedSources.isPresent()) {
            SeedSource seedSource = (SeedSource) optSeedSources.get();
            model.addAttribute("seedSource", seedSource);
            return "seedSources/view";
        } else {
            return "redirect:../";
        }

    }
}
