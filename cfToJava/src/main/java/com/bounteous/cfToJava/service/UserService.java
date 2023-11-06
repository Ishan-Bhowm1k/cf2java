package com.bounteous.cfToJava.service;

import com.bounteous.cfToJava.model.User;
import org.springframework.http.ResponseEntity;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface UserService {
    ResponseEntity<String> deleteUser(int id);
    ResponseEntity<User> getUser(int id);
    ResponseEntity<User> getUserByCredentials(User user);
    ResponseEntity<User> getUserByEmailOrUsername(User user);
    ResponseEntity<List<User>> getUsers();
    ResponseEntity<String> newPassword();
    ResponseEntity<User> newUser();
    ResponseEntity<String> save(User user);
    ResponseEntity<String> isEmailUnique(String email);
    ResponseEntity<String> isUsernameUnique(String username);
    ResponseEntity<String> hashPassword(String pass) throws NoSuchAlgorithmException;
    ResponseEntity<String> validate(User user, String firstName, String lastName, String email, String password, String passwordConfirm);
    ResponseEntity<String> checkPassword(User user, String currPassword, String newPassword, String retypePassword);
}
