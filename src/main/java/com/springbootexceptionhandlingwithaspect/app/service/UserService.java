package com.springbootexceptionhandlingwithaspect.app.service;

import com.springbootexceptionhandlingwithaspect.app.model.Product;
import com.springbootexceptionhandlingwithaspect.app.model.User;
import com.springbootexceptionhandlingwithaspect.app.repository.UserRepository;
import com.springbootexceptionhandlingwithaspect.app.service.impl.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService implements IUserService {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> getAll() {
        LOG.info("UserService | getAll is called");
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        LOG.info("UserService | findById is called");

        LOG.info("UserService | findById | user : " + userRepository.getById(id).toString());

        return userRepository.getById(id);
    }

    @Override
    public User save(User user) {
        LOG.info("UserService | save is called");
        return userRepository.save(user);
    }

    @Override
    public void saveAll(List<User> userList) {
        LOG.info("UserService | saveAll is called");
        userRepository.saveAll(userList);
    }

    @Override
    public void delete(Long id) {
        LOG.info("UserService | delete is called");
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            User deletedMovie= user.get();
            userRepository.delete(deletedMovie);
            LOG.info("UserService | delete | User deleted ");
        }
    }

    @Override
    public User update(Long id, User user) {
        LOG.info("UserService | update is called");
        Optional<User> selectedUser = userRepository.findById(id);
        if(selectedUser.isPresent()) {
            User userUpdate = selectedUser.get();
            userUpdate.setId(id);
            userUpdate.setEmail(user.getEmail());
            userUpdate.setName(user.getName());
            userUpdate.setPhone(user.getPhone());
            userUpdate.setPassword(user.getPassword());


            return userRepository.save(userUpdate);

        }

        return null;
    }
}
