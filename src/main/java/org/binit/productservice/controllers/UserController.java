package org.binit.productservice.controllers;

import org.binit.productservice.dtos.userdetailsDto.CreateUserRequestDto;
import org.binit.productservice.models.userdetails.User;
import org.binit.productservice.services.UserService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }
//ResponseEntity is the Extension of HttpEntity that adds an HttpStatusCode
// status code. Used in RestTemplate as well as in @Controller methods.
    @GetMapping("/")  /*localhost:8080/users/*/
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> responseData = userService.getAllUsers();
        ResponseEntity<List<User>> responseEntity = new ResponseEntity(
                responseData, HttpStatusCode.valueOf(202)
        );

        return responseEntity;
    }
    @GetMapping("/{id}")
    public User getAUser(@PathVariable("id") Long id){
        return userService.getAUser(id);
    }

    @PostMapping("/")
    public ResponseEntity<User> addTheUser(CreateUserRequestDto createUserRequestDto) {
        User user = userService.addTheUser(
                createUserRequestDto.getEmail(),
                createUserRequestDto.getUserName(),
                createUserRequestDto.getPassword(),
                createUserRequestDto.getName(),
                createUserRequestDto.getAddress(),
                createUserRequestDto.getPhone()
        );
        return ResponseEntity.ok(user);  // Return the created user as a response
    }


    @PutMapping("")
    public void updateTheUser(){

    }

    @DeleteMapping("")
    public void deleteTheUser(){

    }
}
