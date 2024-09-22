package org.binit.productservice.dtos.userdetailsDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.binit.productservice.models.Product;
import org.binit.productservice.models.userdetails.User;


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

//    public User toProduct(){
//        User user = new User();
//        user.setId(getId());
//        user.setEmail(getEmail());
//        user.setUserName(getUserName());
//        user.setPassword(getPassword());
//        user.setName(getName());
//        user.setAddress(getAddress());
//        user.get
//
//
//        return product;
//    }
}
