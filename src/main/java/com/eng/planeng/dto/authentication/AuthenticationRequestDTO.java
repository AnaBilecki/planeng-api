package com.eng.planeng.dto.authentication;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthenticationRequestDTO {

    @NotBlank(message = "Login is mandatory!")
    private String login;

    @NotBlank(message = "Password is mandatory!")
    private String password;
}
