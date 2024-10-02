package com.bijanghanei.GottaBuy.repository;

import com.bijanghanei.GottaBuy.model.entity.GottaBuyList;
import com.bijanghanei.GottaBuy.model.entity.GottaBuyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GottaBuyListRepository extends JpaRepository<GottaBuyList, Long> {
    GottaBuyList findByUserAndId(GottaBuyUser user, long id);
    List<GottaBuyList> findAllByUser(GottaBuyUser user);
    void deleteByUserAndId(GottaBuyUser user, long id);
}