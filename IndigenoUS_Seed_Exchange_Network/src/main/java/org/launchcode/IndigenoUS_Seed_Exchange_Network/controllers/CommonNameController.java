package org.launchcode.IndigenoUS_Seed_Exchange_Network.controllers;

import jakarta.validation.Valid;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.models.CommonName;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.data.CommonNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@RequestMapping("commonNames")
public class CommonNameController {

    @Autowired
    private CommonNameRepository commonNameRepository;

    @GetMapping ({"/", ""})
    public String index(Model model) {
        model.addAttribute("commonNames", commonNameRepository.findAll());
        return "index";
    }

    @GetMapping("add")
    public String displayAddCommonNameForm(Model model) {
        model.addAttribute(new CommonName());
        model.addAttribute("commonNames", commonNameRepository.findAll());
        return "commonNames/add";
    }

    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute @Valid CommonName newCommonName,
                                      Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Common Names");
            return "commonNames/add";
        }
        commonNameRepository.save(newCommonName);
        return "redirect:";
    }

    @GetMapping("view/{commonNamesId}")
    public String displayViewCommonName(Model model, @PathVariable int commonNamesId) {

        Optional optCommonNames = commonNameRepository.findById(commonNamesId);
        if (optCommonNames.isPresent()) {
            CommonName commonName = (CommonName) optCommonNames.get();
            model.addAttribute("commonName", commonName);
            return "commonNames/view";
        } else {
            return "redirect:../";
        }

    }
}
