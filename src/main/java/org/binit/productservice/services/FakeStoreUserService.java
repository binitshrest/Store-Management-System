package org.binit.productservice.services;

import org.binit.productservice.dtos.userdetailsDto.FakeStoreUserDto;
import org.binit.productservice.models.userdetails.Address;
import org.binit.productservice.models.userdetails.Geolocation;
import org.binit.productservice.models.userdetails.Name;
import org.binit.productservice.models.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreUserService implements UserService{

    RestTemplate restTemplate;
    public FakeStoreUserService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    @Override
    public User getAUser(Long id){
//        RestTemplate restTemplate = new RestTemplate();
        FakeStoreUserDto fakeStoreUserDto = restTemplate.getForObject(
                "https://fakestoreapi.com/users/" + id, FakeStoreUserDto.class
        );
        User user = new User();
        user.setId(fakeStoreUserDto.getId());
        user.setEmail(fakeStoreUserDto.getEmail());
        user.setUserName(fakeStoreUserDto.getUserName());  // Use 'username' (not 'userName') to match DTO
        user.setPassword(fakeStoreUserDto.getPassword());

// Map Name
        Name name = new Name();
        name.setFirstName(fakeStoreUserDto.getName().getFirstName());  // Match 'firstname' field in DTO
        name.setLastName(fakeStoreUserDto.getName().getLastName());    // Match 'lastname' field in DTO
        user.setName(name);

// Map Address
        Address address = new Address();
        address.setCity(fakeStoreUserDto.getAddress().getCity());
        address.setStreet(fakeStoreUserDto.getAddress().getStreet());
        address.setNumber(fakeStoreUserDto.getAddress().getNumber());
        address.setZipcode(fakeStoreUserDto.getAddress().getZipcode());

// Map Geolocation
        Geolocation geolocation = new Geolocation();
        geolocation.setLat(fakeStoreUserDto.getAddress().getGeolocation().getLat());
        geolocation.setLon(fakeStoreUserDto.getAddress().getGeolocation().getLon());  // 'lon' should be mapped
        address.setGeolocation(geolocation);

        user.setAddress(address);
        user.setPhone(fakeStoreUserDto.getPhone());

        return user;
    }
}
