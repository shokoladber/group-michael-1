package org.launchcode.IndigenoUS_Seed_Exchange_Network.controllers;

import jakarta.validation.Valid;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.models.PlantHardinessZone;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.data.PlantHardinessZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("plantHardinessZones")
public class PlantHardinessZoneController {

    @Autowired
    private PlantHardinessZoneRepository plantHardinessZoneRepository;

    @GetMapping ({"/", ""})
    public String index(Model model) {
        model.addAttribute("plantHardinessZones", plantHardinessZoneRepository.findAll());
        return "index";
    }

    @GetMapping("add")
    public String displayAddPlantHardinessZoneForm(Model model) {
        model.addAttribute(new PlantHardinessZone());
        model.addAttribute("plantHardinessZones", plantHardinessZoneRepository.findAll());
        return "plantHardinessZones/add";
    }

    @PostMapping("add")
    public String processAddPlantHardinessZoneForm(@ModelAttribute @Valid PlantHardinessZone newPlantHardinessZone,
                                                 Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add PlantHardinessZones");
            return "plantHardinessZones/add";
        }
        plantHardinessZoneRepository.save(newPlantHardinessZone);
        return "redirect:";
    }

    @GetMapping("view/{plantHardinessZonesId}")
    public String displayViewPlantHardinessZone(Model model, @PathVariable int plantHardinessZonesId) {

        Optional optPlantHardinessZones = plantHardinessZoneRepository.findById(plantHardinessZonesId);
        if (optPlantHardinessZones.isPresent()) {
            PlantHardinessZone plantHardinessZone = (PlantHardinessZone) optPlantHardinessZones.get();
            model.addAttribute("plantHardinessZone", plantHardinessZone);
            return "plantHardinessZones/view";
        } else {
            return "redirect:../";
        }

    }
}
