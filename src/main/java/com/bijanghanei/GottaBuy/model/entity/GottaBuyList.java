package com.bijanghanei.GottaBuy.model.entity;

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
public class GottaBuyList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn(name = "gotta_buy_user_id")
    private GottaBuyUser user;
    @OneToMany(mappedBy = "list")
    private List<Product> products;
}
