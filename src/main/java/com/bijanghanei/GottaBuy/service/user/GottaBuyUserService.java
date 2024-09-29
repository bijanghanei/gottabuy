package com.bijanghanei.GottaBuy.service.user;

import com.bijanghanei.GottaBuy.model.entity.GottaBuyUser;
import com.bijanghanei.GottaBuy.repository.GottaBuyUserRepository;
import com.bijanghanei.GottaBuy.service.common.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class GottaBuyUserService extends AbstractService<GottaBuyUserRepository, GottaBuyUser, Long> {
}
