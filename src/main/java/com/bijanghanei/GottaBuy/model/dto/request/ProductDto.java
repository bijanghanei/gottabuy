package com.bijanghanei.GottaBuy.model.dto.request;

import com.bijanghanei.GottaBuy.model.ProductCategory;
import com.bijanghanei.GottaBuy.model.entity.GottaBuyList;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class ProductDto {
    private GottaBuyList list;
    private String title;
    private List<String> urls;
    private String description;
    private String category;
    private double price;
}
