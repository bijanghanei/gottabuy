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
public class GottaBuyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private String email;
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<GottaBuyList> lists;
    private long createdAt;
    @OneToOne
    @JoinColumn(name = "gotta_buy_user_id")
    private GottaBuyUserDetails details;

    @Data
    @Builder
    @Entity
    @AllArgsConstructor
    @NoArgsConstructor
    public static class GottaBuyUserDetails {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        @OneToOne
        @JoinColumn(name = "gotta_buy_user_id",referencedColumnName = "id")
        private GottaBuyUser user;
        private String name;
        private long birthday;
        private String phone;

        /*
            TODO: add this in future
            private GottaBuyLocation location;
        */
    }
}
