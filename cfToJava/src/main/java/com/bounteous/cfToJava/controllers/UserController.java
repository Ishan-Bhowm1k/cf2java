package com.bounteous.cfToJava.controllers;

import com.bounteous.cfToJava.model.User;
import com.bounteous.cfToJava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    @DeleteMapping("/user/[id]")
    public ResponseEntity<String> delete(@PathVariable  int id) {
        return userService.deleteUser(id);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @GetMapping("/user/{user}/{pass}")
    public ResponseEntity<User> getUserByCredentials(@PathVariable String username, @PathVariable String password) {
        return userService.getUserByCredentials(username,password);
    }

    @GetMapping("/user/data/{data}")
    ResponseEntity<User> getUserByEmailOrUsername(@PathVariable String data) {
        return userService.getUserByEmailOrUsername(data);
    }

    @GetMapping("/user/users")
    public ResponseEntity<List<User>> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/user/new-pass")
    public ResponseEntity<String> newPassword() {
        return userService.newPassword();
    }

    @GetMapping("/user/new-user")
    ResponseEntity<User> newUser() {
        return userService.newUser();
    }

    @PostMapping("/user/")
    public ResponseEntity<String> save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/user/unique-email/{email}")
    public ResponseEntity<String> isEmailUnique(@PathVariable String email) {
        return userService.isEmailUnique(email);
    }

    @GetMapping("/user/unique-name/{user}")
    public ResponseEntity<String> isUsernameUnique(@PathVariable String username) {
        return userService.isUsernameUnique(username);
    }

    @GetMapping("/user/hash/{pass}")
    public ResponseEntity<String> hashPassword(@PathVariable String pass) throws NoSuchAlgorithmException {
        return userService.hashPassword(pass);
    }

}
