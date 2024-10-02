package com.bijanghanei.GottaBuy.controller.product;

import com.bijanghanei.GottaBuy.controller.common.AbstractController;
import com.bijanghanei.GottaBuy.model.dto.request.ProductDto;
import com.bijanghanei.GottaBuy.model.entity.GottaBuyUser;
import com.bijanghanei.GottaBuy.model.entity.Product;
import com.bijanghanei.GottaBuy.repository.GottaBuyUserRepository;
import com.bijanghanei.GottaBuy.security.jwt.JwtService;
import com.bijanghanei.GottaBuy.service.product.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
*
 * User authorized only
*
*/
@RestController
public class GottaBuyProductController extends AbstractController<ProductService> {

    @Autowired
    private GottaBuyUserRepository userRepository;
    @PostMapping("/products/new")
    public Product create(HttpServletRequest request, @RequestBody ProductDto dto) {
        Product product = service.create(request, dto);
        service.commit(product);
        return product;
    }

    @GetMapping("/products")
    public Product get(HttpServletRequest request, @RequestParam("productId") long productId) {
        return service.getById(request, productId);
    }
    @GetMapping("/products/all")
    public List<Product> getAll(HttpServletRequest request) {
        return service.getAll(request);
    }

    @PutMapping("/products/edit")
    public ResponseEntity<Product> edit(HttpServletRequest request,@RequestParam("productId") long productId, @RequestBody ProductDto dto) {
        Product updated = service.update(request,productId, dto);
        service.commit(updated);
        return ResponseEntity.ok(updated);
    }
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/products/remove")
    public void remove(HttpServletRequest request,@RequestParam("productId") long productId) {
        service.delete(request,productId);
    }
}
