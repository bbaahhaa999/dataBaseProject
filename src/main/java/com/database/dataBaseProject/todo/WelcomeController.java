package com.database.dataBaseProject.todo;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("name")
public class WelcomeController {

    @RequestMapping(value = "/welcome",method = RequestMethod.GET)
    public String goToWelcomePage(Model model, HttpSession session){

        try {
            session.setAttribute("name", "bhajahmad");
            model.addAttribute("name",getLoggedinUsername());
        }
        catch (Exception e){
            System.out.println(e);
        }
        return "welcome";
    }

    private String getLoggedinUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();


    }
}
