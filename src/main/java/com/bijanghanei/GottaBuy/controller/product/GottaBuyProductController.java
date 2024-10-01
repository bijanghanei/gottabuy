package com.bijanghanei.GottaBuy.controller.product;

import org.springframework.web.bind.annotation.*;

/**
*
 * User authorized only
*
*/
@RestController
public class GottaBuyProductController {
    // TODO : add new product
    @PostMapping("/products/new")
    public void create() {

    }

    // TODO : remove product
    @GetMapping("/products")
    public void get() {

    }
    @GetMapping("/products/all")
    public void getAll() {

    }

    @PutMapping("/products/edit")
    public void edit() {

    }
    @PostMapping("/products/remove")
    public void remove() {

    }
}
