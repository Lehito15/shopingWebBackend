package com.example.implementaionpo2.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BasketId implements Serializable {
    @ManyToOne(cascade = CascadeType.MERGE)
    private Client client;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Product product;
}
