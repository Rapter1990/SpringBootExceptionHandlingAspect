package com.springbootexceptionhandlingwithaspect.app.request;

import lombok.Data;

@Data
public class UserDTO {

    private String name;
    private String email;
    private String phone;
    private String password;
}
