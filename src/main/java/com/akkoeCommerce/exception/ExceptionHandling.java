package com.akkoeCommerce.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandling extends Exception{
    @ExceptionHandler({Exception.class })
    public String catchException(Exception e, Model model){
        model.addAttribute("mess",e.getMessage());
        return "views/error/index";
    }
}
