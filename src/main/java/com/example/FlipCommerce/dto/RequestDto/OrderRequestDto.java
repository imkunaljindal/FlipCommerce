package com.example.FlipCommerce.dto.RequestDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class OrderRequestDto {

    String emailId;

    int productId;

    String cardNo;

    int cvv;

    int requiredQuantity;
}
