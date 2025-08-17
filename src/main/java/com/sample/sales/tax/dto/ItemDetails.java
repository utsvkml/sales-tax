package com.sample.sales.tax.dto;

import com.sample.sales.tax.enums.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemDetails {
    
    private String item_name;
    private Category category;
    private Double item_price;

}
