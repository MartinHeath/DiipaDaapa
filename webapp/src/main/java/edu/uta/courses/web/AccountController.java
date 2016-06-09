package edu.uta.courses.web;

import edu.uta.courses.repository.PersonRepository;
import edu.uta.courses.repository.domain.Constants;
import edu.uta.courses.repository.domain.User;
import edu.uta.courses.repository.domain.WwwUser;
import edu.uta.courses.util.UserUtil;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by me on 21.2.2015.
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    Logger logger = Logger.getLogger(AccountController.class.getName());

    @Autowired
    PersonRepository personRepository;


    @RequestMapping( value = {"/", ""})
    public String account(Model model) {
        model.addAttribute("account", "");
        // can not do this anymore! User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name;
        UserDetails user = null;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            user = (UserDetails) auth.getPrincipal();
            name = user.getUsername();
        } else {
            // User is actually anonymous, so is not logged in.
            name = (String)auth.getPrincipal();
        }

        // OR check if the user is instance if WwwUser...?
        try {
            WwwUser wUser = UserUtil.getWwwUser();
        } catch (Exception e) {
          /* no op BUT REMEMBER, there is static user service too, those ARE instances of
           org.springframework.security.core.userdetails.User
           */
            logger.error("Trying to get WwwUser but the user is not such user?");
        }
         //get logged in username

        model.addAttribute("username", name);
        model.addAttribute("user", user);
        return "account";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String accountList(Model model) {
        model.addAttribute("users", personRepository.findUsers());
        return "/account/list";
    }
    @RequestMapping(value = {"/restList"})
    @ResponseBody
    public List<User> restList(){
        return personRepository.findUsers();
    }

    @RequestMapping(value = {"/assignrole/{uid}/{role}"}, method = RequestMethod.GET)
    public String editPersonCommit(@PathVariable("uid") Long uid, @PathVariable("role") String role, Model model) {
        User u = personRepository.findById(uid);
        //WwwUser wwwUser = new WwwUser(u);
        u.setSecurityRoles(role);
        personRepository.update(u);
        model.addAttribute("updatedUser", u);
        model.addAttribute("users", personRepository.findUsers());
        return "/account/list";
    }
    
    @RequestMapping(value={"/delete"})
    public String deleteAccount(@RequestParam("id") Long id){
        User u = personRepository.findById(id);
        personRepository.delete(u);
        return "redirect:/logout";
    }
    
    @RequestMapping(value={"/update"}, method= RequestMethod.GET)
    public String updateAccountOpen (@RequestParam("id") Long id, @ModelAttribute("form") UserCreateForm form, Model model){
        User u = personRepository.findById(id);
        form.setUserId(id);
        form.setUserName(u.getUserName());
        form.setEmail(u.getEmail());
        form.setFirstName(u.getFirstName());
        form.setLastName(u.getLastName());
        
        return "/account/update";
    }
    
    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    public String UpdateAccountCommit(@ModelAttribute("form") UserCreateForm form, Model model) {
        User user = personRepository.findById(form.getUserId());
        
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setUserName(form.getUserName());
        user.setEmail(form.getEmail());
        
        personRepository.update(user);
        model.addAttribute("currentUser", user);
        return "/user/show";
    }



}
