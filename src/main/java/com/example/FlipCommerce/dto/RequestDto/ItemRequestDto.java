package com.example.FlipCommerce.dto.RequestDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ItemRequestDto {

    int productId;

    String customerEmailId;

    int requiredQuantity;
}
