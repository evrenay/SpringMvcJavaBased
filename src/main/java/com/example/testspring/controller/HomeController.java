package com.example.testspring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
public class HomeController {

    @Autowired
    MessageSource messageSource;
// karşılanması gereken istekler view ve ajax requestlerdir.

    @RequestMapping(value = "/", method = RequestMethod.GET) // array halinde tutulup birden çok isteğede karşılık verilebilir.
    //get sınır var postta sınır yok.
    public String home(Locale locale, Model model){
        String welcome = messageSource.getMessage("homepage.welcome", new Object[]{"Evren Ay"}, locale);
        model.addAttribute("karsilama",welcome );


        return "home";
    }
}
