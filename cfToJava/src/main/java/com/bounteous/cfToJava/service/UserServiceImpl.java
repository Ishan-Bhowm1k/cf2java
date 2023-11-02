package com.bounteous.cfToJava.service;

import com.bounteous.cfToJava.dao.UserDao;
import com.bounteous.cfToJava.model.User;
import com.bounteous.cfToJava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;
    @Autowired
    UserRepository userRepository;
    @Override
    public ResponseEntity<String> deleteUser(int id) {
        User user = userDao.getUser(id);
        if(user.isEmpty())
        {
            userDao.deleteUser(id);
            return ResponseEntity.status(HttpStatus.OK).body("The user " + user.getName() + "has been deleted");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The user could not be deleted");
        }
    }

    @Override
    public ResponseEntity<User> getUser(int id) {
        return ResponseEntity.status(HttpStatus.OK).body(userDao.getUser(id));
    }

    @Override
    public ResponseEntity<User> getUserByCredentials(String username, String password) {
        return ResponseEntity.status(HttpStatus.OK).body(userDao.getUserByCredentials(username,password));
    }

    @Override
    public ResponseEntity<User> getUserByEmailOrUsername(String data) {
        return ResponseEntity.status(HttpStatus.OK).body(userDao.getUserByEmailOrUsername(data));
    }

    @Override
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userDao.getUsers());
    }

    @Override
    public ResponseEntity<String> newPassword() {
        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString();
        return ResponseEntity.status(HttpStatus.OK).body(uuidString.substring(0,8));
    }

    @Override
    public ResponseEntity<User> newUser() {
        return ResponseEntity.status(HttpStatus.OK).body(userDao.newUser());
    }

    @Override
    public ResponseEntity<String> save(User user) {
        userDao.saveUser(user);
        if(user.getPkId()>0)
        {
            return ResponseEntity.status(HttpStatus.OK).body("The user " + user.getName() + "has been saved");
        }
        else
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The user could not be saved");
        }
    }

    @Override
    public ResponseEntity<String> isEmailUnique(String email) {
        if(userRepository.existsByEmailAddress(email))
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The email address " + email + " is registered to an existing account.");
        }
        else
        {
            return ResponseEntity.status(HttpStatus.OK).body("Email is unique");
        }

    }

    @Override
    public ResponseEntity<String> isUsernameUnique(String username) {
        if(userRepository.existsByUsername(username))
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The username " + username + " is registered to an existing account.");
        }
        else
        {
            return ResponseEntity.status(HttpStatus.OK).body("Username is unique");
        }
    }

    @Override
    public ResponseEntity<String> hashPassword(String pass) throws NoSuchAlgorithmException {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(salt);
        byte [] hashedBytes = md.digest(pass.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for(byte b : hashedBytes) {
            sb.append(String.format("%02x", b));
        }
        return ResponseEntity.status(HttpStatus.OK).body(sb.toString());
    }

    @Override
    public ResponseEntity<String> validate(User user, String firstName, String lastName, String email, String password, String passwordConfirm) {
        return null;
    }

    @Override
    public ResponseEntity<String> checkPassword(User user, String currPassword, String newPassword, String retypePassword) {
        return null;
    }

}
