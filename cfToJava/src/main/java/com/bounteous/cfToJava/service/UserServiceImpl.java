package com.bounteous.cfToJava.service;

import com.bounteous.cfToJava.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public String deleteUser(int id) {
        return null;
    }

    @Override
    public User getUser(int id) {
        return null;
    }

    @Override
    public User getUserByCredentials(User user) {
        return null;
    }

    @Override
    public User getUserByEmailOrUsername(User user) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public String newPassword() {
        return null;
    }

    @Override
    public User newUser() {
        return null;
    }

    @Override
    public String save(User user) {
        return null;
    }

    @Override
    public String isEmailUnique(String email) {
        return null;
    }

    @Override
    public String isUsernameUnique(String username) {
        return null;
    }

    @Override
    public String hashPassword(String pass) {
        return null;
    }

    @Override
    public String validate(User user, String firstName, String lastName, String email, String password, String passwordConfirm) {
        return null;
    }

    @Override
    public String checkPassword(User user, String currPassword, String newPassword, String retypePassword) {
        return null;
    }
}
