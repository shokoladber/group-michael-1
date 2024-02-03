package org.launchcode.IndigenoUS_Seed_Exchange_Network.controllers;


import jakarta.validation.Valid;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.models.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/application")
public class ApplicationController {

    @Autowired
    private JavaMailSender javaMailSender;

    @GetMapping
    public String showApplicationForm (Model model){
        model.addAttribute("application", new Application());
        return "application-form";
    }

    @PostMapping("/submit")
    public String submitApplicationForm (@ModelAttribute @Valid Application application, BindingResult result, Model model){
        if(result.hasErrors()) {
            return "application-form";
        }

        sendApplicationEmailToAdmin(application);

        model.addAttribute("successMessage", "Your application has been submitted!");
        return "application-form";
    }
    private void sendApplicationEmailToAdmin(Application application) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo("rtypien@gmail.com");

        message.setSubject("New Application Form Submission");
        message.setText("A new application form has been submitted.\n\n"
                        + "Full Name: " + application.getFullName() + "\n"
                        + "Affiliation: " + application.getAffiliation() + "\n"
                        + "Position: " + application.getPosition() + "\n"
                        + "Phone Number: " + application.getPhoneNumber() + "\n"
                        + "e-Mail: " + application.getEmail() + "\n"
                        + "Introduction: " + application.getIntroduction()+ "\n"
                        + "Reference 1 Name: " + application.getReference1().getName() + "\n"
                        + "Reference 1 Institution: " + application.getReference1().getInstitution() + "\n"
                        + "Reference 1 Position: " + application.getReference1().getPosition() + "\n"
                        + "Reference 1 E-Mail: " + application.getReference1().getEmail() + "\n"
                        + "Reference 2 Name: " + application.getReference2().getName() + "\n"
                        + "Reference 2 Institution: " + application.getReference2().getInstitution() + "\n"
                        + "Reference 2 Position: " + application.getReference2().getPosition() + "\n"
                        + "Reference 2 E-Mail: " + application.getReference2().getEmail() + "\n"
        );

        javaMailSender.send(message);
    }
}
