package com.bijanghanei.GottaBuy.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @OneToOne(mappedBy = "user")
    private GottaBuyList list;
    private long createdAt;
    @OneToOne(mappedBy = "user")
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
        @JoinColumn(name = "gotta_buy_user_id")
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
