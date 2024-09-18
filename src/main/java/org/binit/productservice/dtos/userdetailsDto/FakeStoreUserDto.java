package org.binit.productservice.dtos.userdetailsDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FakeStoreUserDto {
    private Long id;
    private String email;
    private String userName;
    private String password;
    private FakeStoreNameDto name;
    private FakeStoreAddressDto address;
    private String phone;
}
