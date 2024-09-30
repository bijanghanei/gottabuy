package com.bijanghanei.GottaBuy.service.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractService<R extends JpaRepository<T, I>, T, I> {
    @Autowired
    public R repository;
    public void commit(T t) {
        repository.save(t);
    }
}
