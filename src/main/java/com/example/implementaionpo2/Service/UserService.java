package com.example.implementaionpo2.Service;

import com.example.implementaionpo2.Entity.User;
import com.example.implementaionpo2.Repository.UserRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
public class UserService {
    @Autowired
    private  UserRepository userRepository;

    public void addSampleUser(){
        User u1 = new User();
        u1.setName("Leszek");
        u1.setSurname("Kryzar");
        u1.setMail("l.kryzar@gmail.com");
        u1.setPhoneNr("799217205");
        u1.setLogin("login");

        userRepository.save(u1);

    }
    public User getUserById(long userId) {
        for(User productCategory: userRepository.findAll()) {
            if (productCategory.getId() == userId) return productCategory;
        }
        return null;
//        return userRepository.findById(userId).orElse(null);
    }


}
