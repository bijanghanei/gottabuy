package com.bijanghanei.GottaBuy.service.common;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractService<R extends JpaRepository<T, I>, T, I> {
    public R repository;
}
