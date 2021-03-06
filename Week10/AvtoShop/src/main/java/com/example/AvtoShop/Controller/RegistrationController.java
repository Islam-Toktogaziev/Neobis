package com.example.AvtoShop.Controller;

import com.example.AvtoShop.Service.UserService;
import com.example.AvtoShop.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping ("/registration")
public class RegistrationController {

    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("userForm")
    public UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(){
        return "registration";
    }

    @PostMapping
    public String registerUser (@ModelAttribute ("userForm") @Valid UserRegistrationDto userRegistrationDto){


        if (!userService.save(userRegistrationDto)){
            return "redirect:/registration?error";
        }

        return "redirect:/registration?success";
    }

}
