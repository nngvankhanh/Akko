package com.akkoeCommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/home")
public class HomeController {


    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView showHome(){
        ModelAndView modelAndView = new ModelAndView("views/eCommerce/index");
        return modelAndView;
    }

    @RequestMapping(value = "layout", method = RequestMethod.GET)
    public ModelAndView showLayout(){
        ModelAndView modelAndView = new ModelAndView("views/eCommerce/layout");
        return modelAndView;
    }

    @RequestMapping(value = "/shop", method = RequestMethod.GET)
    public ModelAndView showShop(){
        ModelAndView modelAndView = new ModelAndView("views/eCommerce/shop");
        return modelAndView;
    }
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ModelAndView showShopDetail(){
        ModelAndView modelAndView = new ModelAndView("views/eCommerce/detail");
        return modelAndView;
    }
    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public ModelAndView showShoppingCart(){
        ModelAndView modelAndView = new ModelAndView("views/eCommerce/cart");
        return modelAndView;
    }
    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public ModelAndView showCheckout(){
        ModelAndView modelAndView = new ModelAndView("views/eCommerce/checkout");
        return modelAndView;
    }
    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public ModelAndView showContact(){
        ModelAndView modelAndView = new ModelAndView("views/eCommerce/contact");
        return modelAndView;
    }
}
