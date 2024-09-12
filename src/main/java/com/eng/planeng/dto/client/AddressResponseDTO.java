package com.eng.planeng.dto.client;

import lombok.Data;

@Data
public class AddressResponseDTO {

    private String street;
    private Integer number;
    private String neighborhood;
    private String city;
    private String state;
    private String zipcode;
    private String complement;
    private String country;
}
