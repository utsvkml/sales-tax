package com.sample.sales.tax.dto;

import java.util.List;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    
    private String userName;
    private List<OrderItemInfo> orderList;
    private Double total;
}
