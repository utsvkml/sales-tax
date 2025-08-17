package com.sample.sales.tax.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sample.sales.tax.dto.Order;
import com.sample.sales.tax.dto.OrderDetails;
import com.sample.sales.tax.dto.OrderResponse;
import com.sample.sales.tax.entitys.Items;
import com.sample.sales.tax.entitys.Orders;
import com.sample.sales.tax.enums.Category;
import com.sample.sales.tax.exception.CustomeException;
import com.sample.sales.tax.repo.ItemRepo;
import com.sample.sales.tax.repo.OrderRepo;
import com.sample.sales.tax.utils.ItemsUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
    
    private final OrderRepo orderRepo;
    private final ItemRepo itemRepo;

    @Value("${sales.tax}")
    private Double salesTax;

    @Value("${import.duty}")
    private Double importDuty;

    private double grandTotal =0;
    private double totalTax = 0;

   
    public OrderResponse makeOrder(Order orders) {
        
        List<OrderDetails> items = orders.getOrderList().stream().map(item->{
            OrderDetails orderDetails = OrderDetails.builder().build();
            try {
               Items items1= itemRepo.findById(item.getItemId()).orElseThrow(()->new CustomeException("Item Not Found"));
                
               createOrderDetails(items1,item.getQuantity(), orderDetails);
                
            } catch (CustomeException e) {
               
                e.printStackTrace();
            }

            return orderDetails;

        }).toList();

        return OrderResponse.builder()
                            .userName(orders.getUserName())
                            .order(items)
                            .totol_amount(grandTotal)
                            .sales_tax(totalTax)
                            .build();
         
    }

    public void saveOrder(Order order){
        Orders orders = ItemsUtils.toOrders(order);
        orders.setTotal(grandTotal);

        orderRepo.save(orders);

    }

    public void createOrderDetails(Items items1,int quantity,OrderDetails orderDetails){
        double taxRate = importDuty;
               if(items1.getCategory().equals(Category.OHTER)){
                    taxRate+=salesTax;
               }
               double subTotal = quantity * items1.getItem_price();
               double paidTax = subTotal* taxRate;
               double total = subTotal + paidTax;

               orderDetails.setItemName(items1.getItem_name());
               orderDetails.setTotal(total);
               orderDetails.setQuantity(items1.getQuantity());
               orderDetails.setTotalTax(paidTax);
              
               totalTax+= paidTax;
               grandTotal+=total;
    }



}
