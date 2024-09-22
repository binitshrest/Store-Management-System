package org.binit.productservice.services;

import org.binit.productservice.models.userdetails.User;

import java.util.List;

public interface UserService {
    public User getAUser(Long id);
    public List<User> getAllUsers();
}
