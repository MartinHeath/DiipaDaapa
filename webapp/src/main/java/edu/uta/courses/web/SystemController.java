/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uta.courses.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Martin
 */
@Controller
@RequestMapping(value={"/system"})
public class SystemController {
    
    @RequestMapping(value={"/home"})
    public String home (Model model){
        return "/system/home";
    }
}
