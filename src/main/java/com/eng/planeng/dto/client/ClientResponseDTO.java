package com.eng.planeng.dto.client;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ClientResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private AddressResponseDTO address;
    private String cpf;
    private LocalDate dateOfBirth;
    private String gender;
    private String occupation;
}
