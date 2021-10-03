package com.springbootexceptionhandlingwithaspect.app.service.impl;

import com.springbootexceptionhandlingwithaspect.app.model.User;

import java.util.List;

public interface IUserService {

    public List<User> getAll();
    public User findById(Long id);
    public User save(User user);
    public void delete(Long id);
    public User update(Long id, User user);

}
