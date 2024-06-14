package com.example.Payee.controller;


import com.example.Payee.model.Payee;
import com.example.Payee.service.PayeeService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/api")
public class PayeeController {

    private static final Logger logger = LoggerFactory.getLogger(PayeeController.class);

    private final PayeeService payeeService;

    @Autowired
    public PayeeController(PayeeService payeeService) {
        this.payeeService = payeeService;
    }

    @GetMapping("/addPayee")
    public String showAddPayeeForm(Model model) {
        model.addAttribute("payee", new Payee());
        return "addPayee";
    }

    @PostMapping("/addPayee")
    public String addPayee(@Valid Payee payee,
                           BindingResult result,
                           @RequestParam("reEnteredAccountNumber") String reEnteredAccountNumber,
                           @RequestParam(value = "confirmCheckbox", required = false) boolean confirmCheckbox,
                           Model model) {
        if (result.hasErrors()) {
            logger.error("Validation errors: {}", result.getAllErrors());
            return "addPayee";
        }

        if (!payee.getAccountNumber().equals(reEnteredAccountNumber)) {
            model.addAttribute("error", "Account numbers do not match.");
            return "addPayee";
        }

        if (!confirmCheckbox) {
            model.addAttribute("error", "Please confirm before submitting.");
            return "addPayee";
        }

        try {
            logger.info("Received request to add payee with name: {}", payee.getName());
            payeeService.savePayee(payee);
            logger.info("Payee saved successfully.");
        } catch (Exception e) {
            logger.error("Error saving payee", e);
            model.addAttribute("error", "An error occurred while saving the payee. Please try again.");
            return "addPayee";
        }

        return "redirect:/api/success";
    }

    @GetMapping("/success")
    public String showSuccessPage(Model model) {
        logger.info("Accessing success page.");
        model.addAttribute("message", "Data saved successfully.");
        return "success";
    }
}