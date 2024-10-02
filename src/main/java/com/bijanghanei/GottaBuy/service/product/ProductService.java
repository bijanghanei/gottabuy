package com.bijanghanei.GottaBuy.service.product;

import com.bijanghanei.GottaBuy.model.dto.request.ProductDto;
import com.bijanghanei.GottaBuy.model.entity.GottaBuyUser;
import com.bijanghanei.GottaBuy.model.entity.Product;
import com.bijanghanei.GottaBuy.repository.GottaBuyListRepository;
import com.bijanghanei.GottaBuy.repository.GottaBuyUserRepository;
import com.bijanghanei.GottaBuy.repository.ProductRepository;
import com.bijanghanei.GottaBuy.security.jwt.JwtService;
import com.bijanghanei.GottaBuy.service.common.AbstractService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService extends AbstractService<ProductRepository, Product, Long> {
    @Autowired
    private GottaBuyListRepository listRepository;
    @Autowired
    private GottaBuyUserRepository userRepository;
    @Autowired
    private JwtService jwtService;
    @Transactional
    public Product create(HttpServletRequest request, ProductDto dto) {
        GottaBuyUser user = jwtService.extractUser(request);

        Product product = new Product();
        product.setUser(user);
        product.setTitle(dto.getTitle());
        product.setUrls(dto.getUrls());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setCategory(dto.getCategory());
        product.setCreatedAt(Instant.now().toEpochMilli());
        product.setList(dto.getList());

        return product;
    }

    @Transactional
    public void delete(HttpServletRequest request,long id) {
        GottaBuyUser user = jwtService.extractUser(request);
        repository.deleteByUserAndId(user, id);
    }

    @Transactional
    public Product update(HttpServletRequest request,long id, ProductDto dto) {
        GottaBuyUser user = jwtService.extractUser(request);
        Optional<Product> product = repository.findByUserAndId(user,id);
        if (product.isPresent()) {
            Product p = product.get();
            p.setTitle(dto.getTitle());
            p.setUrls(dto.getUrls());
            p.setDescription(dto.getDescription());
            p.setPrice(dto.getPrice());
            p.setCategory(dto.getCategory());
            p.setList(dto.getList());
            return product.get();
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Transactional(readOnly = true)
    public Product getById(HttpServletRequest request, long id) {
        GottaBuyUser user = jwtService.extractUser(request);
        Optional<Product> product = repository.findByUserAndId(user, id);
        if (product.isPresent()){
            return product.get();
        } else {
            throw new RuntimeException();
        }
    }
    @Transactional(readOnly = true)
    public List<Product> getAll(HttpServletRequest request) {
        GottaBuyUser user = jwtService.extractUser(request);
        return repository.findAllByUser(user);
    }
}
