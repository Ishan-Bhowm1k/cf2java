package com.bounteous.cfToJava.service;

import com.bounteous.cfToJava.dao.AccountDao;
import com.bounteous.cfToJava.model.Account;
import com.bounteous.cfToJava.model.ServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    AccountDao accountDao;

    @Override
    public List<Account> getAccountList() {
        return accountDao.getAccountList();
    }

    @Override
    public Account getAccount(int customerId) {
        return accountDao.getAccount(customerId);
    }

    @Override
    public Account newAccount() {
        return new Account();
    }

    @Override
    public Account saveAccount(Account account) {
        return accountDao.saveAccount(account);
    }

    @Override
    public ServiceModel newService() {
        return new ServiceModel();
    }

    @Override
    public ServiceModel saveService(ServiceModel serviceModel) {
        return accountDao.saveService(serviceModel);
    }

    @Override
    public Boolean removeService(ServiceModel serviceModel) {
        return accountDao.removeService(serviceModel);
    }

    @Override
    public Boolean removeAccount(Account account) {
        return accountDao.removeAccount(account);
    }

    @Override
    public List<String> getSourceCodeList(String q) {
        return accountDao.getSourceCodeList(q);
    }

    @Override
    public List<String> getCityList(String q) {
        return accountDao.getCityList(q);
    }

    @Override
    public List<String> getTechnicianList(String q) {
        return accountDao.getTechnicianList(q);
    }
}
