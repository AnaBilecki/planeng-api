package com.eng.planeng.controller;

import com.eng.planeng.dto.authentication.AuthenticationRequestDTO;
import com.eng.planeng.dto.authentication.AuthenticationResponseDTO;
import com.eng.planeng.entity.user.User;
import com.eng.planeng.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

        @PostMapping("/login")
        public ResponseEntity<AuthenticationResponseDTO> login(@Valid @RequestBody AuthenticationRequestDTO authenticationDTO) {
            UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(
                    authenticationDTO.getLogin(),
                    authenticationDTO.getPassword()
            );
            Authentication auth = authenticationManager.authenticate(usernamePassword);

            String token = tokenService.generateToken((User) auth.getPrincipal());

            return ResponseEntity.ok(new AuthenticationResponseDTO(token));
        }
}
