package com.eng.planeng.entity.client;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {

    @Column(nullable = false)
    private String street;

    private Integer number;

    @Column(nullable = false)
    private String neighborhood;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String zipcode;

    private String complement;

    @Column(nullable = false)
    private String country;
}
