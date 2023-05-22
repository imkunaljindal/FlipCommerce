package com.example.FlipCommerce.model;

import com.example.FlipCommerce.Enum.CardType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level= AccessLevel.PRIVATE)
@Table(name="card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(unique = true,nullable = false)
    String cardNo;

    int cvv;

    @Enumerated(EnumType.STRING)
    CardType cardType;

    Date validTill;

    @ManyToOne
    @JoinColumn
    Customer customer;
}
