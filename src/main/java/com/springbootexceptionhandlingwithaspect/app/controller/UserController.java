package com.springbootexceptionhandlingwithaspect.app.controller;

import com.springbootexceptionhandlingwithaspect.app.model.User;
import com.springbootexceptionhandlingwithaspect.app.request.UserDTO;
import com.springbootexceptionhandlingwithaspect.app.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/v1")
public class UserController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     *
     * {
     *     "name": "User Green",
     *     "email" : "usergreen@user.com",
     *     "phone" : "1111111",
     *     "password" : "123456"
     * }
     */

    // http://localhost:8082/api/user/v1/users
    @GetMapping("/users")
    public List<User> getAll() {
        LOG.info("UserController | getAll is called");
        return userService.getAll();
    }

    // http://localhost:8082/api/user/v1/user/add
    @PostMapping("/user/add")
    public User createUser(@RequestBody UserDTO user) {
        LOG.info("UserController | createUser is called");
        return userService.save(user);
    }

    // http://localhost:8082/api/user/v1/user/getUserById/{id}
    @GetMapping("/user/getUserById/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        LOG.info("UserController | getUserById is called");
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    // http://localhost:8082/api/user/v1/user/update?id={id}
    @PutMapping("/user/update")
    public ResponseEntity<User> updateUser(@RequestParam long id, @RequestBody UserDTO user) {
        LOG.info("UserController | updateUser is called");
        User updatedUser = userService.update(id,user);
        return ResponseEntity.ok(updatedUser);
    }

    // http://localhost:8082/api/user/v1/user/delete/{id}
    @DeleteMapping("/user/delete/{id}")
    public void deleteUser(@PathVariable long id) {
        LOG.info("UserController | deleteUser is called");
        userService.delete(id);
    }
}
