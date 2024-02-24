package org.launchcode.IndigenoUS_Seed_Exchange_Network.controllers;

import org.springframework.ui.Model;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.data.SeedRepository;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.models.Seed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.launchcode.IndigenoUS_Seed_Exchange_Network.models.SeedData;
import java.util.HashMap;
@Controller
@RequestMapping(value = "list")
public class ListController {

    @Autowired
    private SeedRepository seedRepository;
    static HashMap<String, String> columnChoices = new HashMap<>();

    public ListController () {

        columnChoices.put("all", "All");
        columnChoices.put("seed", "Seed");
    }

    @RequestMapping("")
    public String list(Model model) {
        model.addAttribute("seeds", seedRepository.findAll());
        return "list";
    }

    @RequestMapping(value = "seeds")
    public String listSeedsByColumnAndValue(Model model, @RequestParam String column, @RequestParam String value) {
        Iterable<Seed> seeds;
        if (column.toLowerCase().equals("all")){
            seeds = seedRepository.findAll();
            model.addAttribute("title", "All Seeds");
        } else {
            seeds = SeedData.findByColumnAndValue(column, value, seedRepository.findAll());
            model.addAttribute("title", "Seeds with " + columnChoices.get(column) + ": " + value);
        }
        model.addAttribute("seeds", seeds);

        return "list-seeds";
    }
}