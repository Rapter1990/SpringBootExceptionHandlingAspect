package com.springbootexceptionhandlingwithaspect.app.service.impl;

import com.springbootexceptionhandlingwithaspect.app.model.Product;
import com.springbootexceptionhandlingwithaspect.app.model.User;
import com.springbootexceptionhandlingwithaspect.app.request.UserDTO;

import java.util.List;

public interface IUserService {

    public List<User> getAll();
    public User findById(Long id);
    public User save(UserDTO userDTO);
    public void delete(Long id);
    public User update(Long id, UserDTO userDTO);
    public void saveAll(List<User> userList);
}
