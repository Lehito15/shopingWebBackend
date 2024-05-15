package com.example.implementaionpo2.Repository;

import com.example.implementaionpo2.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
