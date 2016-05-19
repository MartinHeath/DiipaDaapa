/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uta.courses.web;

import edu.uta.courses.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Martin
 */
@Controller
@SessionAttributes(value = {"morsku", "lucky", "tod"})
public class morskuController {
    
    @Autowired
    HelloService helloService;
    
    @RequestMapping("/morsku")
    public String morsku (Model model) {
        int lucky = helloService.getLuckyNumber();
        String tod = helloService.getNow();
        model.addAttribute("morsku","MORSKU ON METOTI");
        model.addAttribute("lucky", lucky);
        model.addAttribute("tod",tod);
        return "/morsku";
    }
    
}
