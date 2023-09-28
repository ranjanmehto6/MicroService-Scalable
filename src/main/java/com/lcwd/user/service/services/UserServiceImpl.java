package com.lcwd.user.service.services;

import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.repositries.UserRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepositry userRepositry;

    @Override
    public User saveUser(User user) {
      String randomUserId =  UUID.randomUUID().toString();
      user.setUserId(randomUserId);
        User save = userRepositry.save(user);
        return save;
    }

    @Override
    public List<User> getAllUser() {
        List<User> all = userRepositry.findAll();
        return all;
    }

    @Override
    public User getUser(String userId) {
        return userRepositry.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with user id" + userId));
    }

    @Override
    public void deleteUser(String userId) {

      User users =  userRepositry.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with user id" + userId));
      userRepositry.delete(users);



    }

    @Override
    public User updateUser(String userId, User user) {
        User users =  userRepositry.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User not found with user id" + userId));
        users.setName(user.getName());
        users.setEmail(user.getEmail());
        users.setAbout(user.getAbout());
        return userRepositry.save(users);
    }
}
