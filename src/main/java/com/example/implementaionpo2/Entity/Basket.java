package com.example.implementaionpo2.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Basket {
    @EmbeddedId
    private BasketId id;

    @Column(nullable = false)
    private int number;


}
