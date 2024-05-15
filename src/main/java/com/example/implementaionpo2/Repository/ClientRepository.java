package com.example.implementaionpo2.Repository;

import com.example.implementaionpo2.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
