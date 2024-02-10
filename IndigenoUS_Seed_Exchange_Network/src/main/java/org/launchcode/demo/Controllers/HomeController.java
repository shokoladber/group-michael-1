package org.launchcode.demo.controllers;

import jakarta.validation.Valid;
import org.launchcode.demo.models.Seed;
import org.launchcode.demo.models.data.BotanicalNameRepository;
import org.launchcode.demo.models.data.CommonNameRepository;
import org.launchcode.demo.models.data.EndangeredStatusRepository;
import org.launchcode.demo.models.data.PlantHardinessZoneRepository;
import org.launchcode.demo.models.data.SeedQuantityRepository;
import org.launchcode.demo.models.data.SeedRepository;
import org.launchcode.demo.models.data.SeedSourceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private BotanicalNameRepository botanicalNameRepository;
    @Autowired
    private CommonNameRepository commonNameRepository;
    @Autowired
    private EndangeredStatusRepository endangeredStatusRepository;
    @Autowired
    private PlantHardinessZoneRepository plantHardinessZoneRepository;
    @Autowired
    private SeedQuantityRepository seedQuantityRepository;
    @Autowired
    private SeedRepository seedRepository;
    @Autowired
    private SeedSourceRepository seedSourceRepository;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("seeds", seedRepository.findAll());
        return "index";
    }

    @GetMapping("add")
    public String displayAddSeedForm(Model model) {
        model.addAttribute("title", "Add Seed");
        model.addAttribute(new Seed());
        model.addAttribute("botanicalName", botanicalNameRepository.findAll());
        model.addAttribute("commonName", commonNameRepository.findAll());
        model.addAttribute("endangeredStatus", endangeredStatusRepository.findAll());
        model.addAttribute("plantHardinessZone", plantHardinessZoneRepository.findAll());
        model.addAttribute("seedQuantity", seedQuantityRepository.findAll());
        model.addAttribute("seedSource", seedSourceRepository.findAll());
        return "add";
    }

    @PostMapping("add")
    public String processAddSeedForm(@ModelAttribute @Valid Seed newSeed,
                                    Errors errors, Model model, @RequestParam int seedId, @RequestParam List<Integer> seedQuantity) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Seed");
            return "add";
        }
        BotanicalName botanicalName = botanicalNameRepository.findById(botanicalNameId).orElse(new BotanicalName());
        newSeed.setBotanicalName(botanicalName);

        List<SeedQuantity> seedQuantityObjs = (List<seedQuantity>) seedQuantityRepository.findAllById(seedQuantity);
        newSeed.setSeedQuanity(seedQuantityObjs);
        seedQuantityRepository.save(newSeed);

        return "redirect:";
    }

    @GetMapping("view/{seedId}")
    public String displayViewSeed(Model model, @PathVariable int seedId) {
        Optional optSeed = seedRepository.findById(seedId);
        if (optSeed.isPresent()) {
            Seed seed = (Seed) optSeed.get();
            model.addAttribute("seed", seed);
            return "view";
        } else {
            return "redirect:../";
        }
    }
}
