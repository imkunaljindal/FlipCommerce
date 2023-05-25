package com.example.FlipCommerce.controller;

import com.example.FlipCommerce.dto.RequestDto.OrderRequestDto;
import com.example.FlipCommerce.dto.ResponseDto.OrderResponseDto;
import com.example.FlipCommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/place")
    public ResponseEntity placeOrder(@RequestBody OrderRequestDto orderRequestDto){

        try{
            OrderResponseDto orderResponseDto = orderService.placeOrder(orderRequestDto);
            return new ResponseEntity(orderResponseDto,HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // get top 5 orders with highest order value

    // all the orders of a particular customer

    // top 5 orders of a customer based on cost

    // top 5 recently ordered orders of a customer
}
