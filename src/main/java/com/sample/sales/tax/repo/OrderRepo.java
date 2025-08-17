package com.sample.sales.tax.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.sales.tax.entitys.Orders;

@Repository
public interface OrderRepo  extends JpaRepository<Orders,Long>{
    
}
