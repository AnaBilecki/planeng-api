package com.eng.planeng.dto.client;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddressRequestDTO {

    @NotBlank(message = "Street is mandatory!")
    private String street;

    private Integer number;

    @NotBlank(message = "Neighborhood is mandatory!")
    private String neighborhood;

    @NotBlank(message = "City is mandatory!")
    private String city;

    @NotBlank(message = "State is mandatory!")
    private String state;

    private String zipcode;
    private String complement;

    @NotBlank(message = "Country is mandatory!")
    private String country;
}
