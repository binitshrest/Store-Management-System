package org.binit.productservice.models.userdetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String email;
    private String userName;
    private String password;
    private Name name;
    private Address address;
    private String phone;
}