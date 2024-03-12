package org.launchcode.IndigenoUS_Seed_Exchange_Network.controllers;

import org.launchcode.IndigenoUS_Seed_Exchange_Network.data.SeedRepository;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.models.Seed;
import org.springframework.ui.Model;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.models.SeedData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import static org.launchcode.IndigenoUS_Seed_Exchange_Network.models.SeedData.findByColumnAndValue;

@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private SeedRepository seedRepository;

    @RequestMapping("")
    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }

    @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm){
        Iterable<Seed> seeds;
        if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")){
            seeds = seedRepository.findAll();
        } else {
            seeds = findByColumnAndValue(searchType, searchTerm, seedRepository.findAll());
        }
        model.addAttribute("columns", ListController.columnChoices);
        model.addAttribute("title", "Seeds with " + ListController.columnChoices.get(searchType) + ": " + searchTerm);
        model.addAttribute("seeds", seeds);

        return "search";
    }
}
