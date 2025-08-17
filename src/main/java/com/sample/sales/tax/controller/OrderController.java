package com.sample.sales.tax.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.sales.tax.dto.Order;
import com.sample.sales.tax.dto.OrderResponse;
import com.sample.sales.tax.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;
    
    @PostMapping
    public ResponseEntity<OrderResponse> order(@RequestBody Order orders){
        
        return new ResponseEntity<>(orderService.makeOrder(orders),HttpStatus.CREATED);
    }
}
