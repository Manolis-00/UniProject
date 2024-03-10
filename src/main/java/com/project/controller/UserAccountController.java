package com.project.controller;

import com.project.model.Address;
import com.project.model.Telephone;
import com.project.model.TelephoneType;
import com.project.model.users.UserAccount;
import com.project.model.users.UserAccountStatus;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserAccountController {

   // @Autowired
    //private UserAccountService userAccountService;

    @GetMapping("/registerUserAccount")
    public String showRegistrationForm(Model model) {
        UserAccount userAccount = new UserAccount();
        // Initialize Telephone and Address if necessary
        userAccount.setTelephone(new Telephone());
        userAccount.setAddress(new Address());
        model.addAttribute("telephoneTypes", TelephoneType.values());
        model.addAttribute("userAccountStatuses", UserAccountStatus.values());
        model.addAttribute("userAccount", userAccount);
        return "registerUserAccount";
    }

    @PostMapping("/registerUserAccount")
    public String registerUserAccount(@ModelAttribute("userAccount") @Valid UserAccount userAccount,
                                      BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "registerUserAccount"; // Return to the form page if there are validation errors
        }
        //userAccountService.saveUserAccount(userAccount);
        model.addAttribute("message", "User account registered successfully!");
        return "success"; // Redirect to a success page or return to the form page
    }
}
