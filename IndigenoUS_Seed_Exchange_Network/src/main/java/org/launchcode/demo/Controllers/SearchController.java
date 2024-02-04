package org.launchcode.demo.controllers;

import org.launchcode.demo.data.SeedData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("search")
public class SearchController {
    private SeedData seedData = new SeedData();
    @GetMapping (value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }
    @PostMapping ("/results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {

        List<Seed> searchResults;

        if ((searchTerm == "all".toLowerCase()) || searchTerm == "") {
            searchResults = SeedData.findAll();
        } else {
            searchResults = SeedData.findByColumnAndValue(searchType, searchTerm);
        }

        model.addAttribute("searchType", searchType);
        model.addAttribute("searchTerm", searchTerm);
        model.addAttribute("seeds", searchResults);


        return "search";
    }
}
