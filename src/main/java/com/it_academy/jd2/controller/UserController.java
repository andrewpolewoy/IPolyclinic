package com.it_academy.jd2.controller;

import com.it_academy.jd2.model.user.User;
import com.it_academy.jd2.service.api.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("/registration")
    public String getUserRegistrationPage() {
        return "registration";
    }

    @PostMapping("/registration")
    public String userRegistration(@RequestParam(name = "email") String email,
                                   @RequestParam(name = "password") String password,
                                   @RequestParam(name = "tel") String tel,
                                   HttpServletRequest req) {
        try {
            User user = userService.registerUser(email, password, tel);
            req.setAttribute("username", user.geteMail());
            req.setAttribute("password", user.getPassword());
            req.setAttribute("tel", user.getPhoneNumber());
            return "signIn";
//            return "redirect: " + req.getContextPath() + "/signIn";
        } catch (IllegalArgumentException e) {
            req.setAttribute("error", true);
            req.setAttribute("message", e.getMessage());
            return "registration";
        }
    }

    @GetMapping("/signIn")
    public String getSignInPage(){
        return "signIn";
    }

}
