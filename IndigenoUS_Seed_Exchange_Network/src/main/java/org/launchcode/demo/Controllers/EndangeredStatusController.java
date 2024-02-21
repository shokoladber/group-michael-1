package org.launchcode.demo.controllers;

import jakarta.validation.Valid;
import org.launchcode.demo.models.EndangeredStatus;
import org.launchcode.demo.models.data.EndangeredStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@RequestMapping("endangeredStatuses")
public class EndangeredStatusController {

    @Autowired
    private EndangeredStatusRepository endangeredStatusRepository;

    @GetMapping ({"/", ""})
    public String index(Model model) {
        model.addAttribute("endangeredStatuses", endangeredStatusRepository.findAll());
        return "index";
    }

    @GetMapping("add")
    public String displayAddCommonNameForm(Model model) {
        model.addAttribute(new EndangeredStatus());
        model.addAttribute("endangeredStatuses", endangeredStatusRepository.findAll());
        return "endangeredStatuses/add";
    }

    @PostMapping("add")
    public String processAddEndangeredStatusForm(@ModelAttribute @Valid EndangeredStatus newEndangeredStatus,
                                      Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add EndangeredStatuses");
            return "endangeredStatuses/add";
        }
        endangeredStatusRepository.save(newEndangeredStatus);
        return "redirect:";
    }

    @GetMapping("view/{endangeredStatusesId}")
    public String displayViewEndangeredStatus(Model model, @PathVariable int endangeredStatusesId) {

        Optional optEndangeredStatuses = endangeredStatusRepository.findById(endangeredStatusesId);
        if (optEndangeredStatuses.isPresent()) {
            EndangeredStatus endangeredStatus = (EndangeredStatus) optEndangeredStatuses.get();
            model.addAttribute("endangeredStatus", endangeredStatus);
            return "endangeredStatuses/view";
        } else {
            return "redirect:../";
        }

    }
}
