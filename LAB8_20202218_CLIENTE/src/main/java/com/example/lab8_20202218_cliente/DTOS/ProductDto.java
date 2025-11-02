package com.example.lab8_20202218_cliente.DTOS;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class ProductDto {
    private Integer productId;
    private String productName;
    private SupplierDto supplier;
    private CategoryDto category;
    private String quantityPerUnit;
    private BigDecimal unitPrice;
    private Short unitsInStock;
}
