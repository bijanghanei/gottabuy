package com.bijanghanei.GottaBuy.repository;

import com.bijanghanei.GottaBuy.model.entity.GottaBuyUser;
import com.bijanghanei.GottaBuy.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByUserAndId(GottaBuyUser user, long productId);
    void deleteByUserAndId(GottaBuyUser user, long id);
    List<Product> findAllByUser(GottaBuyUser user);
}
