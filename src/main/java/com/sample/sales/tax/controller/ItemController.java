package com.sample.sales.tax.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.sales.tax.dto.ItemDetails;
import com.sample.sales.tax.exception.CustomeException;
import com.sample.sales.tax.service.ItemService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;
    
    @PostMapping("/add")
    public ResponseEntity<List<ItemDetails>> addItem(@RequestBody List<ItemDetails> itemDetails){

        return new ResponseEntity<>(itemService.addItem(itemDetails),HttpStatus.CREATED);
    }

    @GetMapping("/get/{itemId}")
    public ResponseEntity<ItemDetails> getItems(@PathVariable Long item) throws CustomeException{
        
        return new ResponseEntity<>(itemService.getItems(item),HttpStatus.OK);
    }
}
