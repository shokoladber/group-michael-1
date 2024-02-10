package org.launchcode.demo.controllers;

import org.launchcode.demo.models.PlantHardinessZone;
import org.springframework.ui.Model;
import org.launchcode.demo.models.data.SeedRepository;
import org.launchcode.demo.models.data.BotanicalNameRepository;
import org.launchcode.demo.models.data.CommonNameRepository;
import org.launchcode.demo.models.data.EndangeredStatusRepository;
import org.launchcode.demo.models.data.SeedSourceRepository;
import org.launchcode.demo.models.Seed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.launchcode.demo.models.SeedData;
import java.util.HashMap;
@Controller
@RequestMapping(value = "list")
public class ListController {

    @Autowired
    private SeedRepository seedRepository;
    @Autowired
    private BotanicalNameRepository botanicalNameRepository;
    @Autowired
    private CommonNameRepository commonNameRepository;
    @Autowired
    private EndangeredStatusRepository endangeredStatusRepository;
    @Autowired
    private PlantHardinessZone plantHardinessZone;
    @Autowired
    private SeedSourceRepository seedSourceRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public ListController () {

        columnChoices.put("all", "All");
        columnChoices.put("botanicalName", "BotanicalName");
        columnChoices.put("commonName", "CommonName");
    }

    @RequestMapping("")
    public String list(Model model) {
        model.addAttribute("botanicalNames", botanicalNameRepository.findAll());
        model.addAttribute("commonNames", commonNameRepository.findAll());
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