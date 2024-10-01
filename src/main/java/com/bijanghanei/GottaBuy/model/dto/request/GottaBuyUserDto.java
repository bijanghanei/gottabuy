package com.bijanghanei.GottaBuy.model.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GottaBuyUserDto {
    private String username;
    private String password;
    private String email;
    private String name;
    private long birthday;
    private String phone;
}
