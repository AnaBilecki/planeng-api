package com.eng.planeng.dto.user;

import com.eng.planeng.entity.user.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRegisterRequestDTO {

    @NotBlank(message = "Name is mandatory!")
    private String name;

    @NotBlank(message = "Login is mandatory!")
    @Email(message = "Login must be in email format")
    private String login;

    @NotBlank(message = "Password is mandatory!")
    private String password;

    @NotNull(message = "Role is mandatory!")
    private UserRole role;
}
