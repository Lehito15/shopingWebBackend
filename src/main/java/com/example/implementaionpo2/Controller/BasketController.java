package com.example.implementaionpo2.Controller;

import com.example.implementaionpo2.Entity.Basket;
import com.example.implementaionpo2.Entity.BasketId;
import com.example.implementaionpo2.Entity.Product;
import com.example.implementaionpo2.Service.BasketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Basket")
public class BasketController {
    private final BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @GetMapping({"/basket","","/"})
    public String home(Model model) {
        List<Basket> productList = basketService.getBasketRepository().findAll();
        model.addAttribute("basketList", productList );
        return "Basket/basket";
    }

    @RequestMapping (path = "/delete/{id}")
    public String deleteProduct(@PathVariable("id") long id) {
        System.out.println(id);
        System.out.println("usuwam");

//        basketService.getBasketRepository().deleteById(id);
        basketService.delete(id);
        return "redirect:/Basket/basket";
    }

//    @PostMapping("/add/")
//    public String addProduct(@PathVariable Integer prodId) {
//
//        basketService.getBasketRepository().save(product);
//        return "redirect:/product/"; // Przekierowanie do listy produktów po dodaniu
//    }
}
