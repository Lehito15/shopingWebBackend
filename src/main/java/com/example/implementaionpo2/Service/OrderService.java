package com.example.implementaionpo2.Service;

import com.example.implementaionpo2.Entity.Order;
import com.example.implementaionpo2.Entity.Product;
import com.example.implementaionpo2.Repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Getter
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductService productService;

    public Order getOrderById(long id){
       return orderRepository.findById(id).orElse(null);
    }

    @Transactional
    public void addOrders(){
        Random random = new Random();
//        LocalDate startDate = LocalDate.now().minusDays(30);
        int daysRange = 60;
        Order o = new Order();
        List<Product> products = new ArrayList<>();

        products.add(productService.getProductById(1L));
        products.add(productService.getProductById(3L));
        products.add(productService.getProductById(4L));
        products.add(productService.getProductById(6L));

        o.setProducts(products);
        LocalDate startDate = LocalDate.now().minusDays(30);
        LocalDate orderDate = startDate.plusDays(random.nextInt(daysRange));
        o.setOrderDate(orderDate);
        o.setAmount(55.54F);

        Order o1 = new Order();
        List<Product> products2 = new ArrayList<>();

        products2.add(productService.getProductById(1L));
        products2.add(productService.getProductById(2L));
        products2.add(productService.getProductById(3L));

        o1.setProducts(products2);
        LocalDate startDate1 = LocalDate.now().minusDays(30);
        LocalDate orderDate1 = startDate1.plusDays(random.nextInt(daysRange));
        o1.setOrderDate(orderDate1);
        o1.setAmount(15.9F);


        orderRepository.save(o);
        orderRepository.save(o1);

    }
}
