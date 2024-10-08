package com.bijanghanei.GottaBuy.model.entity;

import com.bijanghanei.GottaBuy.model.ProductCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "gotta_buy_list_id", referencedColumnName = "id")
    private GottaBuyList list;
    @ManyToOne
    @JoinColumn(name = "gotta_buy_user_id", referencedColumnName = "id")
    private GottaBuyUser user;
    private String title;
    private List<String> urls;
    private String description;
    private String category;
    private double price;
    private long createdAt;
}
