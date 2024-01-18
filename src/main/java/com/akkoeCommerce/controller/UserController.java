package com.akkoeCommerce.controller;

import com.akkoeCommerce.payload.request.LoginRequest;
import com.akkoeCommerce.payload.request.RegisterRequest;
import com.akkoeCommerce.service.UserService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService customerService;

    public UserController(UserService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLogin(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("views/eCommerce/page/login");
        String result2 = request.getParameter("result2");
        modelAndView.addObject("result2",result2);
        modelAndView.addObject("loginRequest", new LoginRequest());
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegister() {
        ModelAndView modelAndView = new ModelAndView("views/eCommerce/page/register");
        modelAndView.addObject("registerRequest", new RegisterRequest());
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@Valid @ModelAttribute("loginRequest") LoginRequest loginRequest, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("views/eCommerce/page/login");
        if (bindingResult.hasErrors()) {
            return modelAndView;
        }
        if (customerService.isLogin(loginRequest)) {
            return new ModelAndView("redirect:/home");
        }
        modelAndView.addObject("result1","Invalid information");
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView signup(@Validated @ModelAttribute("registerRequest") RegisterRequest registerRequest, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView("views/eCommerce/page/register");
        if (bindingResult.hasErrors()) {
            return modelAndView;
        }
        if (customerService.isRegister(registerRequest)) {
            customerService.save(registerRequest);
            redirectAttributes.addAttribute("result2","Sign Up Success");
            return new ModelAndView("redirect:/user/login");
        }
        modelAndView.addObject("result1", "Email already exists");
        return modelAndView;
    }
}
