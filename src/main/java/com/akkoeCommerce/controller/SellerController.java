package com.akkoeCommerce.controller;

import com.akkoeCommerce.service.SellerService;
import com.akkoeCommerce.payload.request.LoginRequest;
import com.akkoeCommerce.payload.request.ProductRequest;
import com.akkoeCommerce.payload.request.RegisterRequest;
import com.akkoeCommerce.payload.response.ProductResponse;
import com.akkoeCommerce.entity.Product;
import com.akkoeCommerce.service.CategoryService;
import com.akkoeCommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/seller")
//@CrossOrigin("*")//http://..
public class SellerController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SellerService sellerService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView showHome() {
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }

    @RequestMapping(value = "/manager", method = RequestMethod.GET)
    public ModelAndView showLayout(@ModelAttribute("product") Product product, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("views/dashboard/manager");
        if (bindingResult.hasErrors()) {
            return modelAndView;
        }
        modelAndView.addObject("products", productService.findAll());
        modelAndView.addObject("category", categoryService.findAll());
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @RequestMapping(value = "/manager/list", method = RequestMethod.GET)
    public ResponseEntity<Iterable<ProductResponse>> allProduct() {
        Iterable<ProductResponse> productResponseDto = productService.findAll();
        return new ResponseEntity<>(productResponseDto,HttpStatus.OK);
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("views/dashboard/order");
        return modelAndView;
    }

    @RequestMapping(value = "/setting", method = RequestMethod.GET)
    public ModelAndView showShopDetail() {
        ModelAndView modelAndView = new ModelAndView("views/dashboard/setting");
        return modelAndView;
    }

    @RequestMapping(value = "/wallet", method = RequestMethod.GET)
    public ModelAndView showShoppingCart() {
        ModelAndView modelAndView = new ModelAndView("views/dashboard/wallet");
        return modelAndView;
    }

    @RequestMapping(value = "/manager/save", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody ProductRequest productRequest) {
        productService.save(productRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/manager/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        ProductResponse productResponse = productService.findById(id).orElse(null);
        if (productResponse == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/manager/edit/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> edit(@PathVariable Long id) {
        ProductResponse productResponse = productService.findById(id).orElse(null);
        return new ResponseEntity<>(productResponse,HttpStatus.OK);
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView showLogin(){
        return new ModelAndView("views/dashboard/page/login");
    }
    @RequestMapping(value="/register", method = RequestMethod.GET)
    public ModelAndView showRegister(){
        return new ModelAndView("views/dashboard/page/register");
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestBody LoginRequest loginRequest){
        boolean result = sellerService.isCheckEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        if(result){
            return new ModelAndView("redirect:/seller");
        }
        return new ModelAndView("redirect:/seller/login");
    }
    @RequestMapping(value="/register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest){
        boolean result = false;
        if(registerRequest.getConfirmPassword().equals(registerRequest.getPassword())){
            result = sellerService.isCheckEmailAndPassword(registerRequest.getEmail(), registerRequest.getPassword());
            if(result){
                sellerService.save(registerRequest);
                return new ResponseEntity<>(result,HttpStatus.CREATED);
            }
        }
        return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
    }
}
