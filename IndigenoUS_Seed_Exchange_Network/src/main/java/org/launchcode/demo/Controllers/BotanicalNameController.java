package org.launchcode.demo.controllers;

import jakarta.validation.Valid;
import org.launchcode.demo.models.BotanicalName;
import org.launchcode.demo.models.Seed;
import org.launchcode.demo.models.data.BotanicalNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("botanicalNames")
public class BotanicalNameController {

    @Autowired
    private BotanicalNameRepository botanicalNameRepository;
    private static List<String> botanicalNames = new ArrayList<>();

    @GetMapping ({"/", ""})
    public String index(Model model) {
        model.addAttribute("botanicalNames", botanicalNameRepository.findAll());
        return "index";
    }

    @GetMapping("add")
    public String displayAddBotanicalNameForm(Model model) {
        model.addAttribute(new Seed());
        model.addAttribute("botanicalNames", botanicalNameRepository.findAll());
        return "botanicalNames/add";
    }

    @PostMapping("add")
    public String processAddBotanicalNameForm(@ModelAttribute @Valid BotanicalName newBotanicalName,
                                         Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add BotanicalNames");
            return "botanicalNames/add";
        }
        botanicalNameRepository.save(newBotanicalName);
        return "redirect:";
    }

    @GetMapping("view/{botanicalNameId}")
    public String displayViewBotanicalName(Model model, @PathVariable int botanicalNameId) {

        Optional optBotanicalName = botanicalNameRepository.findById(botanicalNameId);
        if (optBotanicalName.isPresent()) {
            BotanicalName botanicalName = (BotanicalName) optBotanicalName.get();
            model.addAttribute("botanicalName", botanicalName);
            return "botanicalNames/view";
        } else {
            return "redirect:../";
        }

    }
}
