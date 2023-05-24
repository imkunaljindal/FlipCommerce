package com.example.FlipCommerce.transformer;

import com.example.FlipCommerce.dto.ResponseDto.CartResponseDto;
import com.example.FlipCommerce.dto.ResponseDto.ItemResponseDto;
import com.example.FlipCommerce.model.Cart;
import com.example.FlipCommerce.model.Item;

import java.util.ArrayList;
import java.util.List;

public class CartTransformer {

    public static CartResponseDto CartToCartResponseDto(Cart cart){

        List<ItemResponseDto> itemResponseDtos = new ArrayList<>();
        for(Item item: cart.getItems()){
            itemResponseDtos.add(ItemTransformer.ItemToItemResponseDto(item));
        }

        return CartResponseDto.builder()
                .cartTotal(cart.getCartTotal())
                .customerName(cart.getCustomer().getName())
                .items(itemResponseDtos)
                .build();
    }
}
