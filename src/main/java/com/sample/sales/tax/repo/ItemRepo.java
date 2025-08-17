package com.sample.sales.tax.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.sales.tax.entitys.Items;


@Repository
public interface ItemRepo extends JpaRepository<Items,Long> {

}
