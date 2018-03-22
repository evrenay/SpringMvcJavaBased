package com.example.testspring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @RequestMapping(value = "/giris.ajax")
   public @ResponseBody String giris (@RequestParam String kullaniciAdi, @RequestParam String sifre, HttpServletRequest request, HttpServletResponse response){

        System.out.println("Gelen Parametreler: Kullanıcı Adı: "+ kullaniciAdi +" Sifre :"+ sifre);
        return kullaniciAdi;
   }
}
