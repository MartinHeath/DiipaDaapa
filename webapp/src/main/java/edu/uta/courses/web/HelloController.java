package edu.uta.courses.web;

import edu.uta.courses.repository.domain.WwwUser;
import edu.uta.courses.util.UserUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;

/**
 * Created by me on 3.1.2015.
 */

@Controller
public class HelloController {

    Logger logger = Logger.getLogger(HelloController.class.getName());



    @Autowired
    ApplicationContext applicationContext;

    @Value("${mun.testi}")
    String munTesti;

    @RequestMapping(value = {"/"})
    public String helloWorld(Model model, @Value("${mun.testi}") String testi) {
        model.addAttribute("greeting", "hello World!");
        System.out.println("helloWorld");
        return "hello";
    }

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("greeting", "hello World (from home)!");
        System.out.println("home");
        return "home";
    }

    @RequestMapping("/slider")
    public String slider(Model model) {
        return "/slider";
    }

    @RequestMapping("/about")
    public String about(Model model) {
        model.addAttribute("about", "This is ...");
        System.out.println("about");
        return "about";
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public @ResponseBody HashMap<String,String> test(@RequestBody TestForm form) {

        return new HashMap<>();
    }







        @RequestMapping("/login")
        public String login() {
            if (logger.isTraceEnabled()) { logger.trace("login()"); }
            return "/login";
        }

        @RequestMapping("/logout")
        public String logout() {
            if (logger.isTraceEnabled()) { logger.trace("logout()"); }
            return "/logout";
        }




}
