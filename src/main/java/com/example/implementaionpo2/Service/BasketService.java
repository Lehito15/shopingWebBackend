package com.example.implementaionpo2.Service;

import com.example.implementaionpo2.Entity.Basket;
import com.example.implementaionpo2.Entity.BasketId;
import com.example.implementaionpo2.Repository.BasketRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
public class BasketService {
    @Autowired
    private BasketRepository basketRepository;
    @Autowired
    private ClientService clientService;
    @Autowired ProductService productService;

    public void addToBasket(long prodId){
        boolean isIn = false;
        for(Basket basketDb: basketRepository.findAll()){
            if(basketDb.getId().getProduct().getId() == prodId){
                int number = basketDb.getNumber();
                basketDb.setNumber(number + 1);
                basketRepository.save(basketDb);
                isIn = true;
            }
        }
        Basket basket = new Basket();
        BasketId basketId = new BasketId();
        basketId.setProduct(productService.getProductById(prodId));
        basketId.setClient(clientService.getClientById(1L));
        basket.setId(basketId);

        basket.setNumber(1);
        if(isIn == false){
            basketRepository.save(basket);
        }


    }

    public void delete(long idProd){
        for(Basket basket: basketRepository.findAll()){
            if(basket.getId().getProduct().getId() == idProd){
                basketRepository.delete(basket);
            }
        }
    }

}
