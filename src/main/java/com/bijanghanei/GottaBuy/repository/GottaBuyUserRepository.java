package com.bijanghanei.GottaBuy.repository;

import com.bijanghanei.GottaBuy.model.entity.GottaBuyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GottaBuyUserRepository extends JpaRepository<GottaBuyUser, Long> {
}
