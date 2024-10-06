package com.bijanghanei.GottaBuy.controller.list;

import com.bijanghanei.GottaBuy.controller.common.AbstractController;
import com.bijanghanei.GottaBuy.model.dto.request.GottaBuyListRequest;
import com.bijanghanei.GottaBuy.model.entity.GottaBuyList;
import com.bijanghanei.GottaBuy.security.jwt.JwtService;
import com.bijanghanei.GottaBuy.service.list.GottaBuyListService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class GottaBuyListController extends AbstractController<GottaBuyListService> {
    @Autowired
    private JwtService jwtService;
    @PostMapping("/lists/new")
    public GottaBuyList create(HttpServletRequest request,
                               @RequestBody GottaBuyListRequest dto) {
        GottaBuyList list = service.create(request, dto);
        service.commit(list);
        return list;
    }

    @GetMapping("/lists")
    public GottaBuyList get(HttpServletRequest request, @RequestParam("listId") long listId) {
        return service.getListById(request, listId);
    }
    @GetMapping("/lists/all")
    public List<GottaBuyList> getAll(HttpServletRequest request) {
        return service.getAll(request);
    }

    @PutMapping("/lists/edit")
    public ResponseEntity<GottaBuyList> edit(HttpServletRequest request, @RequestParam("listId") long listId, @RequestBody GottaBuyListRequest dto) {
        GottaBuyList updated = service.update(request, listId, dto);
        service.commit(updated);
        return ResponseEntity.ok(updated);
    }
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/lists/remove")
    public void remove(HttpServletRequest request, @RequestParam("listId") long listId) {
        service.delete(request,listId);
    }
}
