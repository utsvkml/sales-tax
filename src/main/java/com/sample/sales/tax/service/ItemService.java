package com.sample.sales.tax.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sample.sales.tax.dto.ItemDetails;
import com.sample.sales.tax.entitys.Items;
import com.sample.sales.tax.exception.CustomeException;
import com.sample.sales.tax.repo.ItemRepo;
import com.sample.sales.tax.utils.ItemsUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepo itemRepo;

    public ItemDetails addItem(ItemDetails itemDetails) {

        Items item = ItemsUtils.toEntity(itemDetails);
        Items items = itemRepo.save(item);
        return ItemsUtils.toDto(items);

    }

    public ItemDetails getItems(Long item) throws CustomeException {
       
        Items items = itemRepo.findById(item).orElseThrow(()->new CustomeException("Item Not Found"));
        
        return ItemsUtils.toDto(items);
        
      
    }

    
}
