package com.example.implementaionpo2.Controller;

import com.example.implementaionpo2.Entity.Order;
import com.example.implementaionpo2.Entity.Product;
import com.example.implementaionpo2.Service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/complaint")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService= orderService;
    }

    @GetMapping({"/index","","/"})
    public String home(Model model) {
        List<Order> orderList = orderService.getOrderRepository().findAll();
        model.addAttribute("orderList", orderList );
        return "complaint/index";
    }

    @GetMapping("/products/{orderId}")
    public String addToBasket(Model model, @PathVariable("orderId") Long orderId) {
        model.addAttribute(model.addAttribute("productList", orderService.getOrderById(orderId).getProducts()));

        return "complaint/products";
    }

    @GetMapping("/form/{productId}")
    public String productForm(Model model, @PathVariable("productId") Long productId) {
        model.addAttribute(model.addAttribute("productName", orderService.getProductService().getProductById(productId).getName()));

        return "complaint/form";
    }

    @PostMapping("/index")
    public String handleComplaintSubmission() {
        // Obsługa przesłanego formularza
        // Przykładowa logika obsługi

        return "redirect:/complaint/index"; // Przekierowanie na stronę /complaint/index
    }
}

