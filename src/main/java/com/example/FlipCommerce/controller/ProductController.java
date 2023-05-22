package com.example.FlipCommerce.controller;

import com.example.FlipCommerce.Enum.Category;
import com.example.FlipCommerce.dto.RequestDto.ProductRequestDto;
import com.example.FlipCommerce.dto.ResponseDto.ProductResponseDto;
import com.example.FlipCommerce.exception.SellerNotFoundException;
import com.example.FlipCommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody ProductRequestDto productRequestDto){

        try{
            ProductResponseDto productResponseDto = productService.addProduct(productRequestDto);
            return new ResponseEntity(productResponseDto, HttpStatus.CREATED);
        }
        catch (SellerNotFoundException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get/category/{category}/price/{price}")
    public ResponseEntity getAllProductsByCategoryAndPrice(@PathVariable("category") Category category,
                                                           @PathVariable("price") int price){

        List<ProductResponseDto> productResponseDtos = productService.getAllProductsByCategoryAndPrice(category,price);
        return new ResponseEntity(productResponseDtos,HttpStatus.FOUND);
    }

    // get all the products of a category

    // get all the products in a category who have price greater than 500

    // get the top 5 cheapest products in a category

    // get top 5 costliest products in a category

    // get all the products of seller based on emailid

    // get all the out of stock products for a particular catgeory

    // send an email to the seller of the product if the product is out os stock.


}
