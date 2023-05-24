package com.example.FlipCommerce.transformer;

import com.example.FlipCommerce.dto.ResponseDto.ItemResponseDto;
import com.example.FlipCommerce.model.Customer;
import com.example.FlipCommerce.model.Item;
import com.example.FlipCommerce.model.Product;

public class ItemTransformer {

    public static Item ItemRequestDtoToItem(Product product, Customer customer, int quantiy){

        return Item.builder()
                .requiredQuantity(quantiy)
                .build();
    }

    public static ItemResponseDto ItemToItemResponseDto(Item item) {

        return ItemResponseDto.builder()
                .quatityAdded(item.getRequiredQuantity())
                .productName(item.getProduct().getName())
                .price(item.getProduct().getPrice())
                .build();
    }
}
