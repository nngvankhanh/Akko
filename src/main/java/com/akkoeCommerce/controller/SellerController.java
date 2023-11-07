package com.akkoeCommerce.controller;

import com.akkoeCommerce.service.SellerService;
import com.akkoeCommerce.payload.request.LoginRequestDto;
import com.akkoeCommerce.payload.request.ProductRequestDto;
import com.akkoeCommerce.payload.request.RegisterRequestDto;
import com.akkoeCommerce.payload.response.ProductResponseDto;
import com.akkoeCommerce.entity.Product;
import com.akkoeCommerce.service.CategoryService;
import com.akkoeCommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
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
        ModelAndView modelAndView = new ModelAndView("views/dashboard/index");
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
    public ResponseEntity<Iterable<ProductResponseDto>> allProduct() {
        Iterable<ProductResponseDto> productResponseDto = productService.findAll();
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
    public ResponseEntity<?> save(@RequestBody ProductRequestDto productRequestDto) {
        productService.save(productRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/manager/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        ProductResponseDto productResponseDto = productService.findById(id).orElse(null);
        if (productResponseDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/manager/edit/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> edit(@PathVariable Long id) {
        ProductResponseDto productResponseDto = productService.findById(id).orElse(null);
        return new ResponseEntity<>(productResponseDto,HttpStatus.OK);
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView showLogin(){
        return new ModelAndView("views/from/login");
    }
    @RequestMapping(value="/register", method = RequestMethod.GET)
    public ModelAndView showRegister(){
        return new ModelAndView("views/from/register");
    }
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestBody LoginRequestDto loginRequestDto){
        boolean result = sellerService.isCheckEmailAndPassword(loginRequestDto.getEmail(), loginRequestDto.getPassword());
        if(result){
            return new ModelAndView("redirect:/seller");
        }
        return new ModelAndView("redirect:/seller/login");
    }
    @RequestMapping(value="/register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody RegisterRequestDto registerRequestDto){
        boolean result = false;
        if(registerRequestDto.getConfirmPassword().equals(registerRequestDto.getPassword())){
            result = sellerService.isCheckEmailAndPassword(registerRequestDto.getEmail(),registerRequestDto.getPassword());
            if(result){
                sellerService.save(registerRequestDto);
                return new ResponseEntity<>(result,HttpStatus.CREATED);
            }
        }
        return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
    }
}
