package com.sample.sales.tax.utils;


import java.util.List;

import com.sample.sales.tax.dto.ItemDetails;
import com.sample.sales.tax.dto.Order;
import com.sample.sales.tax.dto.OrderItemInfo;
import com.sample.sales.tax.entitys.Items;
import com.sample.sales.tax.entitys.Orders;

public class ItemsUtils {

    public static Items toEntity(ItemDetails itemDetails){
        return Items.builder()
                    .item_name(itemDetails.getItem_name())
                    .item_price(itemDetails.getItem_price())
                    .category(itemDetails.getCategory())
                    .quantity(itemDetails.getQuantity())
                    .item_id(itemDetails.getId())
                    .build();
    }

    public static ItemDetails toDto(Items items){
        return ItemDetails.builder()
                            .item_name(items.getItem_name())
                            .item_price(items.getItem_price())
                            .category(items.getCategory())
                            .quantity(items.getQuantity())
                            .id(items.getItem_id())
                            .build();
    }
    public static Orders toOrders(Order order){
        List<OrderItemInfo> items = order.getOrderList();

        return Orders.builder()
                            .userName(order.getUserName())
                            .orderLIst(items)
                            .total(order.getTotal())
                            .build();
    }
}
