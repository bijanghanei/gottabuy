package com.bijanghanei.GottaBuy.controller.common;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractController<S> {
    @Autowired
    public S service;
}
