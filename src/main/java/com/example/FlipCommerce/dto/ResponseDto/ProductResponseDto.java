package com.example.FlipCommerce.dto.ResponseDto;

import com.example.FlipCommerce.Enum.Category;
import com.example.FlipCommerce.Enum.ProductStatus;
import com.example.FlipCommerce.model.Product;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProductResponseDto {

    String productName;

    String sellerName;

    Category category;

    int price;

    ProductStatus productStatus;
}
