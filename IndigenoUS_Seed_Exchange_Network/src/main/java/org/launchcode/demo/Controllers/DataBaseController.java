package org.launchcode.demo.controllers;

import jakarta.validation.Valid;
import org.launchcode.demo.models.*;
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
@RequestMapping("dataBase")
public class DataBaseController {

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

    @GetMapping ({"/", ""})
    public String index(Model model) {
        model.addAttribute("seeds", seedRepository.findAll());
        return "dataBase";
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
                                    Errors errors, Model model, @RequestParam int botanicalNameId, @RequestParam List<Integer> commonNames,
                                     @RequestParam List<Integer> endangeredStatuses, @RequestParam List<Integer> plantHardinessZones,
                                     @RequestParam List<Integer> seedSources, @RequestParam List<Integer> seedQuanitities) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Seed");
            return "add";
        }
        BotanicalName botanicalName = botanicalNameRepository.findById(botanicalNameId).orElse(new BotanicalName());
        newSeed.setBotanicalName(botanicalName);

        List<CommonName> commonNameObjs = (List<CommonName>) commonNameRepository.findAllById(commonNames);
        newSeed.setCommonNames(commonNameObjs);
        seedRepository.save(newSeed);

        List<EndangeredStatus> endangeredStatusObjs = (List<EndangeredStatus>) endangeredStatusRepository.findAllById(endangeredStatuses);
        newSeed.setEndangeredStatuses(endangeredStatusObjs);
        seedRepository.save(newSeed);

        List<PlantHardinessZone> plantHardinessZoneObjs = (List<PlantHardinessZone>) plantHardinessZoneRepository.findAllById(plantHardinessZones);
        newSeed.setPlantHardinessZones(plantHardinessZoneObjs);
        seedRepository.save(newSeed);

        List<SeedSource> seedSourceObjs = (List<SeedSource>) seedSourceRepository.findAllById(seedSources);
        newSeed.setSeedSources(seedSourceObjs);
        seedRepository.save(newSeed);

        List<SeedQuantity> seedQuantityObjs = (List<SeedQuantity>) seedQuantityRepository.findAllById(seedQuanitities);

        newSeed.setSeedQuantities(seedQuantityObjs);
        seedRepository.save(newSeed);

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
