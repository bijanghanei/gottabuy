package com.bijanghanei.GottaBuy.controller.user;

import com.bijanghanei.GottaBuy.model.dto.request.GottaBuyUserDto;
import com.bijanghanei.GottaBuy.model.dto.request.LoginRequest;
import com.bijanghanei.GottaBuy.model.dto.response.LoginResponse;
import com.bijanghanei.GottaBuy.model.entity.GottaBuyUser;
import com.bijanghanei.GottaBuy.security.GottaBuyUserDetailsService;
import com.bijanghanei.GottaBuy.security.jwt.JwtService;
import com.bijanghanei.GottaBuy.service.user.GottaBuyUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class GottaBuyUserController {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private GottaBuyUserDetailsService userDetailsService;
    @Autowired
    private GottaBuyUserService service;
    @PostMapping("/register")
    public String register(@RequestBody GottaBuyUserDto dto) {
        GottaBuyUser user = service.create(dto);
        service.commit(user);
        return "user created";
    }

    @PostMapping("/signin")
    public ResponseEntity<LoginResponse> authenticateUser(@RequestBody LoginRequest request) throws AuthenticationException {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        if (authentication.isAuthenticated()) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
            String token = jwtService.generateToken(userDetails);
            LoginResponse response = LoginResponse.builder().token(token).username(userDetails.getUsername()).build();
            return ResponseEntity.ok(response);
        } else {
            throw new AuthenticationException("Authentication failed");
        }
    }
    @GetMapping("/get/test")
    public String getTest() {
        return "heeeeey";
    }
}
