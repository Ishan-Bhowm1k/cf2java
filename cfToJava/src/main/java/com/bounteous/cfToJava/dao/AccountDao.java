package com.bounteous.cfToJava.dao;

import com.bounteous.cfToJava.model.Account;
import com.bounteous.cfToJava.model.ServiceModel;

import java.util.List;

public interface AccountDao {
    List<Account> getAccountList();
    Account getAccount(int customerId);
    Account saveAccount(Account account);
    ServiceModel saveService(ServiceModel serviceModel);
    Boolean removeService(ServiceModel serviceModel);
    Boolean removeAccount(Account account);
    List<String> getSourceCodeList(String q);
    List<String> getCityList(String q);
    List<String> getTechnicianList(String q);
}
