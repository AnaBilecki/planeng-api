package com.eng.planeng.dto.client;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClientRequestDTO {

    @NotBlank(message = "Name is mandatory!")
    private String name;

    @NotBlank(message = "Email is mandatory!")
    @Email(message = "Invalid email format!")
    private String email;

    private String phone;

    @Valid
    private AddressRequestDTO address;

    @NotBlank(message = "Cpf is mandatory!")
    private String cpf;

    private LocalDate dateOfBirth;
    private String gender;
    private String occupation;
}
