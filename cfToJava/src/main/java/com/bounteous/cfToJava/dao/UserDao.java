package com.bounteous.cfToJava.dao;

import com.bounteous.cfToJava.model.User;

import java.util.List;

public interface UserDao {
    void deleteUser(int pkId);
    User saveUser(User user);
    List<User> getUsers();
    User getUser(int pkId);
    User getUserByEmailOrUsername(User user);
    User getUserByCredentials(User user);
}
