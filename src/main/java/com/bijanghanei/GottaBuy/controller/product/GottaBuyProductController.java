package com.bijanghanei.GottaBuy.controller.product;

import org.springframework.web.bind.annotation.*;

/**
*
 * User authorized only
*
*/
@RestController
@RequestMapping("/products")
public class GottaBuyProductController {
    // TODO : add new product
    @PostMapping("/new")
    public void create() {

    }

    // TODO : remove product
    @GetMapping
    public void get() {

    }
    @GetMapping("/all")
    public void getAll() {

    }

    @PutMapping("/edit")
    public void edit() {

    }
    @PostMapping("/remove")
    public void remove() {

    }
}
