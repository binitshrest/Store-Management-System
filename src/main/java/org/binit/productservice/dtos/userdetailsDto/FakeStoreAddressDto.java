package org.binit.productservice.dtos.userdetailsDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FakeStoreAddressDto {
    private String city;
    private String street;
    private Integer number;
    private String zipcode;
    private FakeStoreGeolocationDto geolocation;
}