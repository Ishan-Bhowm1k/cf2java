package com.bounteous.cfToJava.service;

import com.bounteous.cfToJava.model.User;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface UserService {
    String deleteUser(int id);
    User getUser(int id);
    User getUserByCredentials(String username,String password);
    User getUserByEmailOrUsername(User user);
    List<User> getUsers();
    String newPassword();
    User newUser();
    String save(User user);
    String isEmailUnique(String email);
    String isUsernameUnique(String username);
    String hashPassword(String pass) throws NoSuchAlgorithmException;
    String validate(User user, String firstName, String lastName, String email, String password, String passwordConfirm);
    String checkPassword(User user, String currPassword, String newPassword, String retypePassword);
}
