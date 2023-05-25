package com.example.FlipCommerce.service;

import com.example.FlipCommerce.dto.RequestDto.ItemRequestDto;
import com.example.FlipCommerce.exception.CustomerNotFoundException;
import com.example.FlipCommerce.exception.InsufficientQuantityException;
import com.example.FlipCommerce.exception.OutOfStockException;
import com.example.FlipCommerce.exception.ProductNotFoundException;
import com.example.FlipCommerce.model.Customer;
import com.example.FlipCommerce.model.Item;
import com.example.FlipCommerce.model.Product;
import com.example.FlipCommerce.repository.CustomerRepository;
import com.example.FlipCommerce.repository.ProductRepository;
import com.example.FlipCommerce.transformer.ItemTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public Item createItem(ItemRequestDto itemRequestDto) throws ProductNotFoundException, CustomerNotFoundException, InsufficientQuantityException, OutOfStockException {

        Optional<Product> productOptional = productRepository.findById(itemRequestDto.getProductId());
        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("Product doesn't exist");
        }

        Customer customer = customerRepository.findByEmailId(itemRequestDto.getCustomerEmailId());
        if(customer==null){
            throw new CustomerNotFoundException("Customer doesn't exist");
        }

        Product product = productOptional.get();
        if(product.getQuantity()==0){
            throw new OutOfStockException("Product is out of stock");
        }
        if(product.getQuantity()<itemRequestDto.getRequiredQuantity()){
            throw new InsufficientQuantityException("Sorry! The required quantity is not avaiable");
        }

        Item item = ItemTransformer.ItemRequestDtoToItem(itemRequestDto.getRequiredQuantity());
        return item;
    }
}
