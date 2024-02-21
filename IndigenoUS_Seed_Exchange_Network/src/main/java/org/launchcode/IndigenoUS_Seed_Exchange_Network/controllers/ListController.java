package org.launchcode.IndigenoUS_Seed_Exchange_Network.controllers;

import org.springframework.ui.Model;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.data.SeedRepository;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.data.BotanicalNameRepository;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.data.CommonNameRepository;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.data.EndangeredStatusRepository;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.data.PlantHardinessZoneRepository;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.data.SeedQuantityRepository;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.data.SeedSourceRepository;
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
    private SeedSourceRepository seedSourceRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public ListController () {

        columnChoices.put("all", "All");
        columnChoices.put("botanicalName", "BotanicalName");
        columnChoices.put("commonName", "CommonName");
        columnChoices.put("endangeredStatus", "EndangeredStatus");
        columnChoices.put("plantHardinessZone", "PlantHardinessZone");
        columnChoices.put("seedQuantity", "SeedQuantity");
        columnChoices.put("seedSource", "SeedSource");

    }

    @RequestMapping("")
    public String list(Model model) {
        model.addAttribute("botanicalNames", botanicalNameRepository.findAll());
        model.addAttribute("commonNames", commonNameRepository.findAll());
        model.addAttribute("endangeredStatus", endangeredStatusRepository.findAll());
        model.addAttribute("plantHardinessZone", plantHardinessZoneRepository.findAll());
        model.addAttribute("seedQuantity", seedQuantityRepository.findAll());
        model.addAttribute("seedSource", seedSourceRepository.findAll());
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