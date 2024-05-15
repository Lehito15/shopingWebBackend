package com.example.implementaionpo2.Repository;

import com.example.implementaionpo2.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
