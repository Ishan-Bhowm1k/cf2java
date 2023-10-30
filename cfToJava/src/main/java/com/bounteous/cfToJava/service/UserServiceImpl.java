package com.bounteous.cfToJava.service;

import com.bounteous.cfToJava.dao.UserDao;
import com.bounteous.cfToJava.model.User;
import com.bounteous.cfToJava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Objects;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;
    @Autowired
    UserRepository userRepository;
    @Override
    public String deleteUser(int id) {
        User user = userDao.getUser(id);
        if(user.isEmpty())
        {
            userDao.deleteUser(id);
            return "The user " + user.getFirstName() + " " + user.getLastName() + "has been deleted";
        }
        else {
            return "The user could not be deleted";
        }
    }

    @Override
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    @Override
    public User getUserByCredentials(String username, String password) {
        return userDao.getUserByCredentials(username,password);
    }

    @Override
    public User getUserByEmailOrUsername(User user) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public String newPassword() {
        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString();
        return uuidString.substring(0,8);
    }

    @Override
    public User newUser() {
        return userDao.newUser();
    }

    @Override
    public String save(User user) {
        userDao.saveUser(user);
        if(user.getPkId()>0)
        {
            return "The user " + user.getFirstName() + " " + user.getLastName() + "has been saved";
        }
        else
        {
            return "The user could not be saved";
        }
    }

    @Override
    public String isEmailUnique(String email) {
        if(userRepository.existsByEmailAddress(email))
        {
            return "The email address " + email + " is registered to an existing account.";
        }
        else
        {
            return "Email is unique";
        }

    }

    @Override
    public String isUsernameUnique(String username) {
        if(userRepository.existsByUsername(username))
        {
            return "The email address " + username + " is registered to an existing account.";
        }
        else
        {
            return "Email is unique";
        }
    }

    @Override
    public String hashPassword(String pass) throws NoSuchAlgorithmException {
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
        return sb.toString();
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
