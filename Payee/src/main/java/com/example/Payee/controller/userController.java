package com.example.Payee.controller;


import com.example.Payee.model.impsDetails;
import com.example.Payee.repository.impsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class userController {

    @Autowired
    private impsRepo repo;

    @GetMapping("/fundImps")
    public String showFundImpsForm(Model model) {
        model.addAttribute("impsDetails", new impsDetails());
        return "imps"; // Assuming this is your form page (imps.html)
    }

    @PostMapping("/fundImps")
    public String processFundImpsForm(@ModelAttribute impsDetails item, Model model) {
        System.out.println(item);
        repo.save(item);
        model.addAttribute("impsDetails", item); // Add posted data to model
        model.addAttribute("message", "Transfer Amount successfully");
        return "redirect:/imtrans"; // Redirect to success page
    }

    @GetMapping("/imtrans")
    public String showSuccessPage(Model model) {
        // Fetch last saved impsDetails from repository
        impsDetails details = repo.findTopByOrderByIdDesc();
        if (details == null) {
            return "redirect:/fundImps";
        }
        model.addAttribute("impsDetails", details);
        model.addAttribute("message", "Transfer Amount successfully");
        model.addAttribute("redirectUrl", "/api/success"); // Add redirect URL to model
        return "imtrans"; // Assuming this is your success page (success.html)
    }
}