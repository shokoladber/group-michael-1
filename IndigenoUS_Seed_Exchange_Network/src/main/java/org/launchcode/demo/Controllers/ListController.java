package org.launchcode.demo.controllers;


import org.launchcode.demo.models.Seed;
import org.launchcode.demo.models.SeedData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;



@Controller
@RequestMapping(value = "seed")
public class ListController {
    static HashMap<String, String> columnChoices = new HashMap<>();
    static HashMap<String, Object> tableChoices = new HashMap<>();

    public ListController () {
        columnChoices.put("all", "All");
        columnChoices.put("endangered", "Endangered");
        columnChoices.put("hardinessZone", "HardinessZone");
        columnChoices.put("indigenous", "Indigenous");
        columnChoices.put("regionUS", "RegionUS");
        columnChoices.put("status", "Status");
        columnChoices.put("sunRequirement", "SunRequirement");
        columnChoices.put("waterRequirement", "WaterRequirement");

        tableChoices.put("all", "View All");
        tableChoices.put("endangered", SeedData.getAllEndangered());
        tableChoices.put("hardinessZone", SeedData.getAllHardinessZones());
        tableChoices.put("indigenous", SeedData.getAllIndigenous());
        tableChoices.put("regionUS", SeedData.getAllRegionUS());
        tableChoices.put("status", SeedData.getAllStatuses());
        tableChoices.put("sunRequirement", SeedData.getAllSunRequirements());
        tableChoices.put("waterRequirement", SeedData.getAllWaterRequirements());
    }

    @GetMapping(value = "")
    public String list(Model model) {
        model.addAttribute("columns", columnChoices);
        model.addAttribute("tableChoices", tableChoices);
        model.addAttribute("endangered", SeedData.getAllEndangered());
        model.addAttribute("hardinessZone", SeedData.getAllHardinessZones());
        model.addAttribute("indigenous", SeedData.getAllIndigenous());
        model.addAttribute("regionUS", SeedData.getAllRegionsUS());
        model.addAttribute("status", SeedData.getAllStatuses());
        model.addAttribute("sunRequirement", SeedData.getAllSunRequirements());
        model.addAttribute("waterRequirement", SeedData.getAllWaterRequirements());

        return "list";
    }

    @GetMapping (value = "seeds")
    public String listSeedsByColumnAndValue(Model model, @RequestParam String column, @RequestParam(required = false) String value) {
        ArrayList<Seed> seeds;
        if (column.equals("all")){
            seeds = SeedData.findAll();
            model.addAttribute("title", "All Seeds");
        } else {
            seeds = SeedData.findByColumnAndValue(column, value);
            model.addAttribute("title", "Seeds with " + columnChoices.get(column) + ": " + value);
        }
        model.addAttribute("seeds", seeds);

        return "list-seeds";
    }
}
