/*
package com.akkoeCommerce.controller;

import com.akkoeCommerce.model.dto.LoginDto;
import com.akkoeCommerce.model.dto.RegisterDto;
import com.akkoeCommerce.entity.User;
import com.akkoeCommerce.service.UserService;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/user")
public class UserController {

    private UserService customerService;

    public UserController(UserService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView showLogin(){
        ModelAndView modelAndView = new ModelAndView("views/from/login");
        modelAndView.addObject("login", new LoginDto());
        return modelAndView;
    }
    @RequestMapping(value="/register", method = RequestMethod.GET)
    public ModelAndView showRegister(){
        ModelAndView modelAndView = new ModelAndView("views/from/register");
        modelAndView.addObject("register", new RegisterDto());
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@Validated @ModelAttribute("login") LoginDto loginDto, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("views/from/login");
        modelAndView.addObject("login", new LoginDto());
        if(bindingResult.hasErrors()){
            modelAndView = new ModelAndView("views/from/login");
            return modelAndView;
        }
        if (customerService.findByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword())) {
            return new ModelAndView("/views/eCommerce/index");
        }
        modelAndView.addObject("result","đăng nhập thất bại");
        return modelAndView;
    }
    @RequestMapping(value="/register", method = RequestMethod.POST)
    public ModelAndView signup(@Validated @ModelAttribute("register") RegisterDto registerDto, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("views/from/register");
        modelAndView.addObject("register", new RegisterDto());
        if(bindingResult.hasErrors()){
            modelAndView = new ModelAndView("views/from/register");
            return modelAndView;
        }
        if(registerDto.getPassword().equals(registerDto.getConfirm()) && !customerService.findByEmail(registerDto.getEmail())){
            customerService.save(new User(registerDto.getEmail(), registerDto.getPassword()));
            modelAndView = new ModelAndView("views/from/login");
            modelAndView.addObject("login", new LoginDto());
            modelAndView.addObject("result","đăng ký thành công");
            return modelAndView;
        }
        modelAndView.addObject("result","email đã tồn tại");
        return modelAndView;
    }
}
*/
