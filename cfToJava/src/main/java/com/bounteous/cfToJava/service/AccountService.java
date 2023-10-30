package com.bounteous.cfToJava.service;

import com.bounteous.cfToJava.model.Account;
import com.bounteous.cfToJava.model.ServiceModel;

import java.util.List;

public interface AccountService {
    List<Account> getAccountList();
    Account getAccount(int customerId);
    Account newAccount();
    Account saveAccount(Account account);
    ServiceModel newService();
    ServiceModel saveService(ServiceModel serviceModel);
    Boolean removeService(ServiceModel serviceModel);
    Boolean removeAccount(Account account);
    List<String> getSourceCodeList(String q);
    List<String> getCityList(String q);
    List<String> getTechnicianList(String q);
}
