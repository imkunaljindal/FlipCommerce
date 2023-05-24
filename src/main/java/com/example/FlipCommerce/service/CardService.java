package com.example.FlipCommerce.service;


import com.example.FlipCommerce.dto.RequestDto.CardRequestDto;
import com.example.FlipCommerce.dto.ResponseDto.CardResponseDto;
import com.example.FlipCommerce.exception.CustomerNotFoundException;
import com.example.FlipCommerce.model.Card;
import com.example.FlipCommerce.model.Customer;
import com.example.FlipCommerce.repository.CustomerRepository;
import com.example.FlipCommerce.transformer.CardTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    @Autowired
    CustomerRepository customerRepository;

    public CardResponseDto addCard(CardRequestDto cardRequestDto) throws CustomerNotFoundException {

        Customer customer = customerRepository.findByEmailId(cardRequestDto.getEmailId());
        if(customer==null){
            throw new CustomerNotFoundException("Invalid email id!!!");
        }

        // dto -> entity
        Card card = CardTransformer.CardRequestDtoToCard(cardRequestDto);
        card.setCustomer(customer);
        customer.getCards().add(card);

        // save customer and card
        Customer savedCustomer = customerRepository.save(customer);

        // preapre response Dto
        return CardTransformer.CardToCardResponseDto(card);
    }
}
