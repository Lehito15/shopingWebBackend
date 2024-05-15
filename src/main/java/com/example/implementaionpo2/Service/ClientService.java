package com.example.implementaionpo2.Service;

import com.example.implementaionpo2.Entity.Client;
import com.example.implementaionpo2.Entity.Unit;
import com.example.implementaionpo2.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private UserService userService;

    public void addClient(){
        Client c1 = new Client();
        c1.setNIP("242442424");
        c1.setPoints(20);
        System.out.print("Client  ");
        System.out.print(userService.getUserById(1L).getName());
        c1.setUserId(userService.getUserById(1L));

        clientRepository.save(c1);
    }
    public Client getClientById(Long unitId) {
        return clientRepository.findById(unitId).orElse(null);
    }
}
