package org.binit.productservice.models.userdetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String city;
    private String street;
    private Integer number;
    private String zipcode;
    private Geolocation geolocation;
}
