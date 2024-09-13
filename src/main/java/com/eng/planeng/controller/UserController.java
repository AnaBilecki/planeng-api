package com.eng.planeng.controller;

import com.eng.planeng.dto.user.UserRegisterRequestDTO;
import com.eng.planeng.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@Valid @RequestBody UserRegisterRequestDTO userRegisterDTO) {
        service.register(userRegisterDTO);
        return ResponseEntity.ok().build();
    }
}
