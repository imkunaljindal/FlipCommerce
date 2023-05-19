package com.example.FlipCommerce.model;


import com.example.FlipCommerce.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level=AccessLevel.PRIVATE)
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @Column(unique = true,nullable = false)
    String emailId;

    @Column(unique = true,nullable = false)
    String mobNo;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    List<Card> cards = new ArrayList<>();

    @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
    Cart cart;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    List<OrderEntity> orders = new ArrayList<>();
}
