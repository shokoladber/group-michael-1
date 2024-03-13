package org.launchcode.IndigenoUS_Seed_Exchange_Network.controllers;

import jakarta.validation.Valid;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.data.SeedRepository;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.models.Blog;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.models.Seed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;


@Controller
public class DataBaseController {
    @Autowired
    private SeedRepository seedRepository;

    @GetMapping ({"/dataBase"})
    public String seed(Model model) {
        model.addAttribute("seeds", seedRepository.findAll());
        return "dataBase";
    }
    @GetMapping("aSeed/{id}")
    public String getaSeed(Model model, Seed seed, @PathVariable int id) {
        Optional optSeed = seedRepository.findById(id);
        if (optSeed.isPresent()) {
            seed = (Seed) optSeed.get();
            model.addAttribute("seed", seed);
            return "aSeed";
        } else {
            return "404";
        }
    }

    @GetMapping("/list/edit")
    public String seedEditForm(Model model, Seed seed, @PathVariable int id) {
        Optional optSeed = seedRepository.findById(id);
        if (optSeed.isPresent()) {
            seed = (Seed) optSeed.get();
            model.addAttribute("seed", seed);
            return "edit";
        } else {
            return "404";
        }
    }

    @PostMapping("/list/edit")
    public String updateExistingSeed(Model model, @PathVariable int id, Seed seed) {

        Optional<Seed> optSeed = seedRepository.findById(id);
        if (optSeed.isPresent()) {
            Seed existingSeed = optSeed.get();
            // Update the existing blog with the new data
            existingSeed.setBotanicalName(seed.getBotanicalName());
            existingSeed.setCommonName(seed.getCommonName());
            existingSeed.setSeedQuantity(seed.getSeedQuantity());
            existingSeed.setEndangered(seed.getEndangered());
            existingSeed.setSourceIsIndigenous(seed.getSourceIsIndigenous());
            existingSeed.setPlantHardinessZone(seed.getPlantHardinessZone());
            // Save the updated blog
            seedRepository.save(existingSeed);
            model.addAttribute("seeds", seedRepository.findAll());
            return "seed";
        } else {
            return "404";
        }
    }

    @GetMapping("/dataBase/delete")
    public String deleteSeedById(@PathVariable int id) {
        seedRepository.deleteById(id);

        return "delete";
    }

    @GetMapping("/add")
    public String displayAddSeedForm(Model model) {
//        model.addAttribute("seed", "Add Seed");
        model.addAttribute("seed", new Seed());
//        model.addAttribute("seed", seedRepository.findAll());
        return "add";
    }
    
    @PostMapping("/add")
    public String handleSeedPostForm(Model model, @ModelAttribute @Valid Seed seed, Errors errors){
        model.addAttribute("seed", seed);
        if(errors.hasErrors()){
            return "add";
        }

        seedRepository.save(seed);
        model.addAttribute("seeds", seedRepository.findAll());
        return "view";
    }
}
//    public String processAddSeedForm(@ModelAttribute @Valid Seed newSeed,
//                                    Errors errors, Model model, @PathVariable int id) {
//
//        if (errors.hasErrors()) {
//            model.addAttribute("seed", "Add Seed");
//            return "add";
//        }
//
//        Seed botanicalName = seedRepository.findById(id).orElse(new Seed());
//        newSeed.setBotanicalName(String.valueOf(botanicalName));
//
//        Seed commonName = seedRepository.findById(id).orElse(new Seed());
//        newSeed.setCommonName(String.valueOf(commonName));
//
//        Seed seedQuantity = seedRepository.findById(id).orElse(new Seed());
//        newSeed.setSeedQuantity(Integer.valueOf(String.valueOf(seedQuantity)));
//
//        Seed plantHardinessZone = seedRepository.findById(id).orElse(new Seed());
//        newSeed.setPlantHardinessZone(new String[]{String.valueOf(plantHardinessZone)});
//
//        Seed isEndangered = seedRepository.findById(id).orElse(new Seed());
//        newSeed.setEndangered(Boolean.valueOf(String.valueOf(isEndangered)));
//
//        Seed isIndigenous = seedRepository.findById(id).orElse(new Seed());
//        newSeed.setSourceIsIndigenous(Boolean.valueOf(String.valueOf(isIndigenous)));
//
//        return "redirect:";
//    }

//    @GetMapping("/seed/{seedId}")
//    public String displayViewSeed(Model model, Seed seed, @PathVariable int seedId) {
//        Optional<Seed> optSeed = seedRepository.findById(seedId);
//        if (optSeed.isPresent()) {
//            seed = optSeed.get();
//            model.addAttribute("seed", seed);
//            return "view";
//        } else {
//            return "redirect:../";
//        }
//   }
//}
