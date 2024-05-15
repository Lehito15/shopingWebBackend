//import org.springframework.beans.factory.annotation.Autowired;
//
//package com.example.implementaionpo2;
//
//import com.example.implementaionpo2.Service.*;
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DataInitializer  {
//
//    private  UserService userService;
//
//    private CategoryService categoryService;
//
//    private ProductService productService;
//
//    private UnitService unitService;
//
//
//
//
//
//    @Autowired
//    public DataInitializer(UserService userService, CategoryService categoryService, ProductService productService, UnitService unitService, ClientService clientService, OrderService orderService) {
//        this.userService = userService;
//        this.categoryService = categoryService;
//        this.productService = productService;
//        this.unitService = unitService;
//        this.clientService = clientService;
//        this.orderService = orderService;
//    }
//
//    @PostConstruct
//    public void add() {
////        userService.addSampleUser();
////        clientService.addClient();
////        categoryService.addSampleCategories();
////        unitService.addSampleUnit();
////        productService.addSampleProduct();
//        orderService.addOrders();
//    }
//}
