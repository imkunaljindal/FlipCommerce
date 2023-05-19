package com.example.FlipCommerce.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level= AccessLevel.PRIVATE)
@Table(name="item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int requiredQuantity;

    @ManyToOne
    @JoinColumn
    Product product;

    @ManyToOne
    @JoinColumn
    OrderEntity orderEntity;

    @ManyToOne
    @JoinColumn
    Cart cart;
}
