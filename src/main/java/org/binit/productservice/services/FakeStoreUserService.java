package org.binit.productservice.services;

import org.binit.productservice.dtos.FakeStoreProductDto;
import org.binit.productservice.dtos.userdetailsDto.FakeStoreAddressDto;
import org.binit.productservice.dtos.userdetailsDto.FakeStoreGeolocationDto;
import org.binit.productservice.dtos.userdetailsDto.FakeStoreNameDto;
import org.binit.productservice.dtos.userdetailsDto.FakeStoreUserDto;
import org.binit.productservice.models.userdetails.Address;
import org.binit.productservice.models.userdetails.Geolocation;
import org.binit.productservice.models.userdetails.Name;
import org.binit.productservice.models.userdetails.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<User> getAllUsers(){
        String url = "https://fakestoreapi.com/users/";
        FakeStoreUserDto[] response = restTemplate.getForObject(
                url,
                FakeStoreUserDto[].class
        );
        List<User> users = new ArrayList<>();
        for(FakeStoreUserDto fakeStoreUserDto: response){
            users.add(fakeStoreUserDto.toUser());
        }

        return users;
    }

    @Override
    public User addTheUser(String email, String userName, String password,
                           FakeStoreNameDto name, FakeStoreAddressDto address
            , String phone){
        String url = "https://fakestoreapi.com/users";

        FakeStoreUserDto fakeStoreUserDto = new FakeStoreUserDto();
        fakeStoreUserDto.setEmail(email);
        fakeStoreUserDto.setUserName(userName);
        fakeStoreUserDto.setPassword(password);

        FakeStoreNameDto fakeStoreNameDto = new FakeStoreNameDto();
        fakeStoreNameDto.setFirstName(name.getFirstName());
        fakeStoreNameDto.setLastName(name.getLastName());
        fakeStoreUserDto.setName(fakeStoreNameDto);

        FakeStoreAddressDto fakeStoreAddressDto = new FakeStoreAddressDto();
        fakeStoreAddressDto.setCity(address.getCity());
        fakeStoreAddressDto.setStreet(address.getStreet());
        fakeStoreAddressDto.setNumber(address.getNumber());
        fakeStoreAddressDto.setZipcode(address.getZipcode());
        fakeStoreUserDto.setAddress(fakeStoreAddressDto);

        FakeStoreGeolocationDto fakeStoreGeolocationDto = new FakeStoreGeolocationDto();
        fakeStoreGeolocationDto.setLat(address.getGeolocation().getLat());
        fakeStoreGeolocationDto.setLon(address.getGeolocation().getLon());
        fakeStoreAddressDto.setGeolocation(fakeStoreGeolocationDto);

        FakeStoreUserDto response = restTemplate.postForObject(
            url,
                fakeStoreUserDto,
                FakeStoreUserDto.class
        );

        return response.toUser();
    }

    @Override
    public User updateTheUser(Long id, String email, String userName,
                              String password, FakeStoreNameDto name,
                              FakeStoreAddressDto address, String phone){
        String url = "https://fakestoreapi.com/users/" + id;

        FakeStoreUserDto fakeStoreUserDto = new FakeStoreUserDto();
        fakeStoreUserDto.setId(id);
        fakeStoreUserDto.setEmail(email);
        fakeStoreUserDto.setUserName(userName);
        fakeStoreUserDto.setPassword(password);

        FakeStoreNameDto fakeStoreNameDto = new FakeStoreNameDto();
        fakeStoreNameDto.setFirstName(name.getFirstName());
        fakeStoreNameDto.setLastName(name.getLastName());
        fakeStoreUserDto.setName(fakeStoreNameDto);

        FakeStoreAddressDto fakeStoreAddressDto = new FakeStoreAddressDto();
        fakeStoreAddressDto.setCity(address.getCity());
        fakeStoreAddressDto.setStreet(address.getStreet());
        fakeStoreAddressDto.setNumber(address.getNumber());
        fakeStoreAddressDto.setZipcode(address.getZipcode());
        fakeStoreUserDto.setAddress(fakeStoreAddressDto);

        FakeStoreGeolocationDto fakeStoreGeolocationDto = new FakeStoreGeolocationDto();
        fakeStoreGeolocationDto.setLat(address.getGeolocation().getLat());
        fakeStoreGeolocationDto.setLon(address.getGeolocation().getLon());
        fakeStoreAddressDto.setGeolocation(fakeStoreGeolocationDto);

        HttpEntity<FakeStoreUserDto> requestEntity = new HttpEntity<>(fakeStoreUserDto);
        ResponseEntity<FakeStoreUserDto> response =
                restTemplate.exchange(
                        url,
                        HttpMethod.PUT,
                        requestEntity,
                        FakeStoreUserDto.class
                );

        return response.getBody().toUser();
    }

}
