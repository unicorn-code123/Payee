package com.example.Payee.controller;

import com.example.Payee.model.neftDetails;
import com.example.Payee.repository.neftRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class neftController {

    @Autowired
    private neftRepo neftRepo;

    @GetMapping("/fundNeft")
    public String showFundNeftForm(Model model) {
        model.addAttribute("neftDetails", new neftDetails());
        return "neft"; // Assuming this is your form page (rtgs.html)
    }

    @PostMapping("/fundNeft")
    public String processFundNeftForm(@ModelAttribute("neftDetails") neftDetails item, Model model) {
        try {
            System.out.println(item);
            neftRepo.save(item);
            model.addAttribute("neftDetails", item); // Add posted data to model
            model.addAttribute("message", "Transfer Amount successfully");
            return "redirect:/nefttransfer"; // Redirect to success page
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred while processing the transfer.");
            return "error"; // Redirect to error page
        }
    }

    @GetMapping("/nefttransfer")
    public String showNeftSuccessPage(Model model) {
        // Fetch last saved neftDetails from repository
        neftDetails details = neftRepo.findTopByOrderByIdDesc();
        if (details == null) {
            return "redirect:/fundNeft";
        }
        model.addAttribute("neftDetails", details);
        model.addAttribute("message", "Transfer Amount successfully");
        model.addAttribute("redirectUrl", "/api/success"); // Add redirect URL to model
        return "nefttransfer"; // Assuming this is your success page (nefttransfer.html)
    }
}
