package com.bounteous.cfToJava.dao;

import com.bounteous.cfToJava.model.User;
import com.bounteous.cfToJava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    UserRepository userRepository;

    @Override
    public User newUser() {
        return new User();
    }

    @Override
    public void deleteUser(int pkId) {
        User user = userRepository.findUserByPkId(pkId);
        user.setIsActive(false);
        userRepository.save(user);
    }

    @Override
    public User saveUser(User user) {
        Date now = new Date();
        user.setDateCreated(now);
        userRepository.save(user);
        return user;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(int pkId) {
        return userRepository.findUserByPkId(pkId);
    }

    @Override
    public User getUserByEmailOrUsername(User user) {
        String email = user.getEmailAddress();
        String username = user.getUsername();
        if(userRepository.existsByEmailAddress(email))
        {
            return userRepository.findUserByEmailAddress(email);
        } else if (userRepository.existsByUsername(username)) {
            return userRepository.findUserByUsername(username);
        }
        else {
            return null;
        }

    }

    @Override
    public User getUserByCredentials(User user) {
        User user1 = getUserByEmailOrUsername(user);
        if(user1.getPassword().equals(user.getPassword()))
        {
            return user1;
        }
        else
            return null;
    }
}
