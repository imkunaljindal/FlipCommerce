package com.example.FlipCommerce.repository;

import com.example.FlipCommerce.Enum.Category;
import com.example.FlipCommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByCategoryAndPrice(Category category, int price);
}
