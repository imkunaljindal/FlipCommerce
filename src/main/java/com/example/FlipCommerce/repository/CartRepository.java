package com.example.FlipCommerce.repository;

import com.example.FlipCommerce.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
}
