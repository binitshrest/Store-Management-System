package org.binit.productservice.services;

import org.binit.productservice.dtos.userdetailsDto.FakeStoreAddressDto;
import org.binit.productservice.dtos.userdetailsDto.FakeStoreNameDto;
import org.binit.productservice.models.userdetails.User;

import java.util.List;

public interface UserService {
    public User getAUser(Long id);
    public List<User> getAllUsers();
    public User addTheUser( String email,String userName,String password,
                            FakeStoreNameDto name, FakeStoreAddressDto address
                            ,String phone);
}
