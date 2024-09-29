package com.bijanghanei.GottaBuy.repository;

import com.bijanghanei.GottaBuy.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
