package com.bijanghanei.GottaBuy.controller.user;

import com.bijanghanei.GottaBuy.model.dto.GottaBuyUserDto;
import com.bijanghanei.GottaBuy.model.entity.GottaBuyUser;
import com.bijanghanei.GottaBuy.service.user.GottaBuyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GottaBuyUserController {
    @Autowired
    private GottaBuyUserService service;
    @PostMapping("/register")
    public String register(@RequestBody GottaBuyUserDto dto) {
        GottaBuyUser user = service.create(dto);
        service.commit(user);
        return "user created";
    }
}
