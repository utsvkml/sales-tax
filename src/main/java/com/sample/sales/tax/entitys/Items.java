package com.sample.sales.tax.entitys;

import com.sample.sales.tax.enums.Category;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="t_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Items {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long item_id;

    private String item_name;
    
    @Enumerated(EnumType.STRING)
    private Category category;
    private Double item_price;

}
