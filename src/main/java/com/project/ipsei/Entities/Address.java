package com.project.ipsei.Entities;

import jakarta.persistence.Embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@RequiredArgsConstructor
public class Address {

    @Column(name = "street", nullable = false, length = 150)
    private String street;

    @Column(name = "number", nullable = false, length = 20)
    private String number;

    @Column(name = "complement", length = 100)
    private String complement;

    @Column(name = "neighborhood", nullable = false, length = 100)
    private String neighborhood;

    @Column(name = "city", nullable = false, length = 100)
    private String city;

    @Column(name = "state", nullable = false, length = 50)
    private String state;

    @Column(name = "zip_code", nullable = false, length = 20)
    private String zipCode;

    @Column(name = "country", nullable = false, length = 50)
    private String country;
}