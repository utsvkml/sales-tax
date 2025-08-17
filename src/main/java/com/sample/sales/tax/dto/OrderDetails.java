package com.sample.sales.tax.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails {
    String itemName;
    Integer quantity;
    Double total;
    Double totalTax;
}
