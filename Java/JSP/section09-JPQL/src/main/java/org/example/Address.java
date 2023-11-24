package org.example;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Address {

    private String city;

    private String street;

    private String zipcode;

}
