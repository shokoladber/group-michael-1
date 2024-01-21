package org.launchcode.controllers;

import org.launchcode.model.ApplicationForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormSubmissionController {

    @GetMapping("/application")
    public String showApplicationForm (Model model) {
        model.addAttribute("applicationForm", new ApplicationForm());
        return "application";
    }

    @PostMapping("/application")
    public String submitApplicationForm (ApplicationForm applicationForm, Model model) {
        model.addAttribute("message", "Application submitted");
        return "redirect:/conformation";
    }

    @GetMapping("/confirmation")
    public String showConfirmation(Model model){
        return "confirmation";
    }
}
