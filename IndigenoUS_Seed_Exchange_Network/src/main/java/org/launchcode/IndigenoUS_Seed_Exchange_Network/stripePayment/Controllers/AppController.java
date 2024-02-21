package org.launchcode.IndigenoUS_Seed_Exchange_Network.stripePayment.Controllers;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.stripePayment.Models.Request;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {
    @Value("${Stripe.api.publicKey}")
    private String publicKey;
    @GetMapping("/donate")
    public String home(Model model){
        model.addAttribute("request", new Request());
        return "donate";
    }
    @PostMapping("/donate")
    public String showCard(@ModelAttribute @Valid Request request,
                           BindingResult bindingResult,
                           Model model){
        if (bindingResult.hasErrors()){
            return "404";
        }
        model.addAttribute("publicKey", publicKey);
        model.addAttribute("email", request.getEmail());
        model.addAttribute("firstName", request.getFirstName());
        model.addAttribute("lastName", request.getLastName());
        model.addAttribute("businessName", request.getBusinessName());
        model.addAttribute("amount", request.getAmount());
        model.addAttribute("productName", request.getDonationNote());
        return "checkout";
    }
}

