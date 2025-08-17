package com.sample.sales.tax.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    String userName;
    List<OrderDetails> order;
    Double sales_tax;
    Double totol_amount;
}
