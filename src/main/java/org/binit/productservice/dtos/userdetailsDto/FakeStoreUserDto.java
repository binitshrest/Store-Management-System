package org.binit.productservice.dtos.userdetailsDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.binit.productservice.models.Product;
import org.binit.productservice.models.userdetails.Address;
import org.binit.productservice.models.userdetails.Geolocation;
import org.binit.productservice.models.userdetails.Name;
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

    public User toUser() {
        User user = new User();
        user.setId(getId());
        user.setEmail(getEmail());
        user.setUserName(getUserName());
        user.setPassword(getPassword());

        // Mapping FakeStoreNameDto to Name object
        Name name = new Name();
        name.setFirstName(getName().getFirstName());
        name.setLastName(getName().getLastName());
        user.setName(name);

        // Mapping FakeStoreAddressDto to Address object
        Address address = new Address();
        address.setCity(getAddress().getCity());
        address.setStreet(getAddress().getStreet());
        address.setNumber(getAddress().getNumber());
        address.setZipcode(getAddress().getZipcode());

        // Mapping FakeStoreGeolocationDto to Geolocation object (if it exists)
        Geolocation geolocation = new Geolocation();
        geolocation.setLat(getAddress().getGeolocation().getLat());
        geolocation.setLon(getAddress().getGeolocation().getLon());
        address.setGeolocation(geolocation);

        user.setAddress(address);
        user.setPhone(getPhone());

        return user;
    }
}
