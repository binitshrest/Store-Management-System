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
        user.setUserName(fakeStoreUserDto.getUserName());
        user.setPassword(fakeStoreUserDto.getPassword());

        // Convert Name DTO to Name domain model
        Name name = new Name();
        name.setFirstName(fakeStoreUserDto.getName().getFirstName());
        name.setLastName(fakeStoreUserDto.getName().getLastName());
        user.setName(name);

        // Convert Address DTO to Address domain model
        Address address = new Address();
        address.setCity(fakeStoreUserDto.getAddress().getCity());
        address.setStreet(fakeStoreUserDto.getAddress().getStreet());
        address.setNumber(fakeStoreUserDto.getAddress().getNumber());
        address.setZipcode(fakeStoreUserDto.getAddress().getZipcode());

        // Convert Geolocation DTO to Geolocation domain model
        Geolocation geolocation = new Geolocation();
        geolocation.setLat(fakeStoreUserDto.getAddress().getGeolocation().getLat());
        geolocation.setLon(fakeStoreUserDto.getAddress().getGeolocation().getLon());
        address.setGeolocation(geolocation);

        user.setAddress(address);
        user.setPhone(fakeStoreUserDto.getPhone());
        return user;
    }
}
