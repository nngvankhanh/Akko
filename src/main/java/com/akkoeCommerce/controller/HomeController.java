package com.akkoeCommerce.controller;

import com.akkoeCommerce.entity.Cart;
import com.akkoeCommerce.entity.Category;
import com.akkoeCommerce.payload.request.CartRequest;
import com.akkoeCommerce.payload.response.ProductResponse;
import com.akkoeCommerce.service.CartService;
import com.akkoeCommerce.service.CategoryService;
import com.akkoeCommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView showHome(){
        ModelAndView modelAndView = new ModelAndView("views/eCommerce/page/home");
        Iterable<Category> categoryList= categoryService.findAll();
        modelAndView.addObject("categoryList",categoryList);
        return modelAndView;
    }

    @RequestMapping(value = "/shop/{id}", method = RequestMethod.GET)
    public ModelAndView showShop(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("views/eCommerce/page/shop");
        Iterable<Category> categoryList= categoryService.findAll();
        modelAndView.addObject("categoryList",categoryList);
        List<ProductResponse> productResponseList = productService.findProductListByCategoryId(id);
        modelAndView.addObject("productList", productResponseList);
        return modelAndView;
    }

    @RequestMapping(value = "/shop/{idCategory}/detail/{idProduct}", method = RequestMethod.GET)
    public ModelAndView showShopDetail(@PathVariable("idProduct") Long idProduct, @ModelAttribute("cartRequest") CartRequest cartRequest){
        ModelAndView modelAndView = new ModelAndView("views/eCommerce/page/detail");
        Iterable<Category> listCategory= categoryService.findAll();
        ProductResponse productResponse = productService.findById(idProduct).get();
        modelAndView.addObject("listCategory",listCategory);
        modelAndView.addObject("productDetail",productResponse);
        modelAndView.addObject("cartRequest", new CartRequest());
        if(cartRequest.getQuantity() != 0 && cartRequest.getSize() !=null && cartRequest.getColor() != null){
            List<Cart> cartList = cartService.save(cartRequest,idProduct);
            modelAndView.addObject("cartList",cartList);
        }
        return modelAndView;
    }
    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public ModelAndView showShoppingCart(){
        ModelAndView modelAndView = new ModelAndView("views/eCommerce/cart");
        Iterable<Category> categoryList= categoryService.findAll();
        modelAndView.addObject("categoryList",categoryList);
        return modelAndView;
    }
    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public ModelAndView showCheckout(){
        ModelAndView modelAndView = new ModelAndView("views/eCommerce/checkout");
        Iterable<Category> categoryList= categoryService.findAll();
        modelAndView.addObject("categoryList",categoryList);
        return modelAndView;
    }
    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public ModelAndView showContact(){
        ModelAndView modelAndView = new ModelAndView("views/eCommerce/contact");
        Iterable<Category> categoryList= categoryService.findAll();
        modelAndView.addObject("categoryList",categoryList);
        return modelAndView;
    }
}
