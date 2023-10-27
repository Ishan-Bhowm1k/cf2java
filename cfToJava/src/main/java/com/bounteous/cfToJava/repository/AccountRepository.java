package com.bounteous.cfToJava.repository;

import com.bounteous.cfToJava.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account,Integer> {
    Account findAccountByCustomerId(int id);
    Boolean existsByCustomerId(int id);
    List<String> findBySourceCodeLike(String q);
    List<String> findByCityLike(String c);
}
