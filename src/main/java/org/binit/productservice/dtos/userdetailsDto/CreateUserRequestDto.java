package org.binit.productservice.dtos.userdetailsDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.binit.productservice.models.userdetails.Address;
import org.binit.productservice.models.userdetails.Name;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateUserRequestDto {
    private String email;
    private String userName;
    private String password;
    private FakeStoreNameDto name;
    private FakeStoreAddressDto address;
    private String phone;
}
