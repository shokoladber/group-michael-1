package org.launchcode.demo.controllers;

import org.springframework.ui.Model;
import org.launchcode.demo.models.Seed;
import org.launchcode.demo.models.SeedData;
import org.launchcode.demo.models.data.SeedRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import static org.launchcode.demo.controllers.ListController.columnChoices;

@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private SeedRepository seedRepository;

    @RequestMapping("")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm){
        Iterable<Seed> seeds;
        if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")){
            seeds = seedRepository.findAll();
        } else {
            seeds = SeedData.findByColumnAndValue(searchType, searchTerm, seedRepository.findAll());
        }
        model.addAttribute("columns", columnChoices);
        model.addAttribute("title", "Seeds with " + columnChoices.get(searchType) + ": " + searchTerm);
        model.addAttribute("seeds", seeds);

        return "search";
    }


//    private SeedData seedData = new SeedData();
//    @GetMapping (value = "")
//    public String search(Model model) {
//        model.addAttribute("columns", columnChoices);
//        return "search";
//    }
//    @PostMapping ("/results")
//    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {
//
//        List<Seed> searchResults;
//
//        if ((searchTerm == "all".toLowerCase()) || searchTerm == "") {
//            searchResults = SeedData.findAll();
//        } else {
//            searchResults = SeedData.findByColumnAndValue(searchType, searchTerm);
//        }
//
//        model.addAttribute("searchType", searchType);
//        model.addAttribute("searchTerm", searchTerm);
//        model.addAttribute("seeds", searchResults);
//
//
//        return "search";
//    }
}
