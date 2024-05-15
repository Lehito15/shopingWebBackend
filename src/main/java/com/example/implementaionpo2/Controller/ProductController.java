package com.example.implementaionpo2.Controller;

import com.example.implementaionpo2.Entity.Product;
import com.example.implementaionpo2.Service.BasketService;
import com.example.implementaionpo2.Service.ProductService;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RestController
@RequestMapping("/Basket")
public class ProductController {
    private final ProductService productService;
    private final BasketService basketService;

    public ProductController(ProductService productService, BasketService basketService) {
        this.productService = productService;
        this.basketService= basketService;
    }

    @GetMapping({"/index","","/"})
    public String home(@RequestParam(required = false, defaultValue = "asc") String order, Model model) {
        List<Product> productList;

        if ("desc".equalsIgnoreCase(order)) {
            productList = productService.getProductRepository().findAll((Sort.by(Sort.Direction.ASC, "Price")));
        } else {
            productList = productService.getProductRepository().findAll((Sort.by(Sort.Direction.ASC, "Price")));
        }

        model.addAttribute("productList", productList);
        return "Basket/index";
    }

    @GetMapping("/sort")
    public ResponseEntity<List<Product>> sortProducts(@RequestParam String order) {
        List<Product> sortedProducts;

        if ("desc".equalsIgnoreCase(order)) {
            sortedProducts = productService.getProductRepository().findAll(Sort.by(Sort.Direction.DESC, "price"));
        } else {
            sortedProducts = productService.getProductRepository().findAll(Sort.by(Sort.Direction.ASC, "price"));
        }

        return ResponseEntity.ok(sortedProducts);
    }

    @GetMapping("/add/{productId}")
    public String addToBasket(@PathVariable("productId") Long productId) {
        // Tutaj dodaj logikę dodawania produktu do koszyka
        // Możesz użyć odpowiedniego serwisu, np. BasketService, aby to zaimplementować
        basketService.addToBasket(productId);
        // ...

        return "redirect:/Basket/index";
    }
}
