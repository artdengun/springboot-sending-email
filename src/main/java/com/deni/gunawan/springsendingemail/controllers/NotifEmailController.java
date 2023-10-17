package com.deni.gunawan.springsendingemail.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.deni.gunawan.springsendingemail.models.EmailStructure;

@Controller
public class NotifEmailController {

    @GetMapping(value = "/")
    public String getIndex(ModelMap map){
        EmailStructure emailStructure = new EmailStructure();
        map.addAttribute("sendingLangsung", emailStructure);
        return "/index";
    }

    @GetMapping(value = "/rabbit")
    public String getRabbit(){
        return "/index_satu";
    }

        @GetMapping(value = "/scheduler")
    public String getScheduler(){
        return "/index_dua";
    }
}
