package com.example.Payee.controller;


import com.example.Payee.model.rtgsDetails;
import com.example.Payee.repository.rtgsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class rtgsController {

    @Autowired
    private rtgsRepo rtgsRepo;

    @GetMapping("/fundRtgs")
    public String showFundRtgsForm(Model model) {
        model.addAttribute("rtgsDetails", new rtgsDetails());
        return "rtgs"; // Assuming this is your form page (rtgs.html)
    }

    @PostMapping("/fundRtgs")
    public String processFundRtgsForm(@ModelAttribute rtgsDetails item, Model model) {
        try {
            System.out.println(item);
            rtgsRepo.save(item);
            model.addAttribute("rtgsDetails", item); // Add posted data to model
            model.addAttribute("message", "Transfer Amount successfully");
            return "redirect:/rtgstransfer"; // Redirect to success page
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred while processing the transfer.");
            return "error"; // Redirect to error page
        }
    }

    @GetMapping("/rtgstransfer")
    public String showRTGSSuccessPage(Model model) {
        // Fetch last saved rtgsDetails from repository
        rtgsDetails details = rtgsRepo.findTopByOrderByIdDesc();
        if (details == null) {
            return "redirect:/fundRtgs";
        }
        model.addAttribute("rtgsDetails", details);
        model.addAttribute("message", "Transfer Amount successfully");
        return "rtgstransfer"; // Assuming this is your success page (success.html)
    }
}

