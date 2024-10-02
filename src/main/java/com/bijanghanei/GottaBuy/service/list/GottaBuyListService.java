package com.bijanghanei.GottaBuy.service.list;

import com.bijanghanei.GottaBuy.model.dto.request.GottaBuyListRequest;
import com.bijanghanei.GottaBuy.model.entity.GottaBuyList;
import com.bijanghanei.GottaBuy.model.entity.GottaBuyUser;
import com.bijanghanei.GottaBuy.repository.GottaBuyListRepository;
import com.bijanghanei.GottaBuy.repository.GottaBuyUserRepository;
import com.bijanghanei.GottaBuy.security.jwt.JwtService;
import com.bijanghanei.GottaBuy.service.common.AbstractService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GottaBuyListService extends AbstractService<GottaBuyListRepository, GottaBuyList, Long> {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private GottaBuyUserRepository userRepository;
    @Transactional
    public GottaBuyList create(HttpServletRequest request, GottaBuyListRequest dto) {
        GottaBuyUser user = jwtService.extractUser(request);
        GottaBuyList list = new GottaBuyList();
        list.setTitle(dto.getTitle());
        list.setUser(user);
        return list;
    }
    @Transactional(readOnly = true)
    public List<GottaBuyList> getAll(HttpServletRequest request) {
        GottaBuyUser user = jwtService.extractUser(request);
        return repository.findAllByUser(user);
    }
    @Transactional(readOnly = true)
    public GottaBuyList getListById(HttpServletRequest request, long id) {
        GottaBuyUser user = jwtService.extractUser(request);
        return repository.findByUserAndId(user, id);
    }
    @Transactional
    public GottaBuyList update(HttpServletRequest request, long id, GottaBuyListRequest dto) {
        GottaBuyList list = this.getListById(request, id);
        list.setTitle(dto.getTitle());
        return list;
    }
    @Transactional
    public void delete(HttpServletRequest request, long id) {
        GottaBuyUser user = jwtService.extractUser(request);
        repository.deleteByUserAndId(user,id);
    }
}
