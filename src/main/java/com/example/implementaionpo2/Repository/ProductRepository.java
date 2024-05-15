package com.example.implementaionpo2.Repository;

import com.example.implementaionpo2.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
