package com.sample.sales.tax.utils;


import com.sample.sales.tax.dto.ItemDetails;
import com.sample.sales.tax.entitys.Items;

public class ItemsUtils {

    public static Items toEntity(ItemDetails itemDetails){
        return Items.builder()
                    .item_name(itemDetails.getItem_name())
                    .item_price(itemDetails.getItem_price())
                    .category(itemDetails.getCategory())
                    .build();
    }

    public static ItemDetails toDto(Items items){
        return ItemDetails.builder()
                            .item_name(items.getItem_name())
                            .item_price(items.getItem_price())
                            .category(items.getCategory())
                            .build();
    }
}
