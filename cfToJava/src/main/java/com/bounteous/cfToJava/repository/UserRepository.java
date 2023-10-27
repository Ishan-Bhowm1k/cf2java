package com.bounteous.cfToJava.repository;

import com.bounteous.cfToJava.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserByPkId(int pkId);
    Boolean existsByUsername(String username);
    Boolean existsByEmailAddress(String email);
    User findUserByEmailAddress(String email);
    User findUserByUsername(String username);
}
