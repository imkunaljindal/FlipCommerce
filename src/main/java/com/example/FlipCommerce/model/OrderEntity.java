package com.example.FlipCommerce.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level= AccessLevel.PRIVATE)
@Table(name="order_info")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String orderNo;

    int totalValue;

    @CreationTimestamp
    Date orderDate;

    String cardUsed;

    @ManyToOne
    @JoinColumn
    Customer customer;

    @OneToMany(mappedBy = "orderEntity",cascade = CascadeType.ALL)
    List<Item> items = new ArrayList<>();
}
