package com.bijanghanei.GottaBuy.service.product;

import com.bijanghanei.GottaBuy.model.entity.Product;
import com.bijanghanei.GottaBuy.repository.ProductRepository;
import com.bijanghanei.GottaBuy.service.common.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends AbstractService<ProductRepository, Product, Long> {

}
