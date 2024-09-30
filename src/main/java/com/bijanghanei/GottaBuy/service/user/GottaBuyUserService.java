package com.bijanghanei.GottaBuy.service.user;

import com.bijanghanei.GottaBuy.model.dto.GottaBuyUserDto;
import com.bijanghanei.GottaBuy.model.entity.GottaBuyUser;
import com.bijanghanei.GottaBuy.repository.GottaBuyUserRepository;
import com.bijanghanei.GottaBuy.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class GottaBuyUserService extends AbstractService<GottaBuyUserRepository, GottaBuyUser, Long> {
    @Autowired
    private PasswordEncoder encoder;
    public GottaBuyUser create(GottaBuyUserDto dto) {
        GottaBuyUser user = new GottaBuyUser();
        user.setUsername(dto.getUsername());
        user.setPassword(encoder.encode(dto.getPassword()));
        user.setEmail(dto.getEmail());
        user.setCreatedAt(Instant.now().toEpochMilli());

//        GottaBuyUser.GottaBuyUserDetails details = new GottaBuyUser.GottaBuyUserDetails();
//        details.setName(dto.getName());
//        details.setBirthday(dto.getBirthday());
//        details.setPhone(dto.getPhone());
//
//        user.setDetails(details);

        return user;
    }
}
