package com.bounteous.cfToJava.dao;

import com.bounteous.cfToJava.model.Account;
import com.bounteous.cfToJava.model.ServiceModel;
import com.bounteous.cfToJava.repository.AccountRepository;
import com.bounteous.cfToJava.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao{
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public List<Account> getAccountList() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccount(int customerId) {
        return accountRepository.findAccountByCustomerId(customerId);
    }

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public ServiceModel saveService(ServiceModel serviceModel) {
        return serviceRepository.save(serviceModel);
    }

    @Override
    public Boolean removeService(ServiceModel serviceModel) {
        int id = serviceModel.getServiceId();
        if(serviceRepository.existsByServiceId(id))
        {
            serviceRepository.delete(serviceModel);
            return true;
        }
        else
            return false;
    }

    @Override
    public Boolean removeAccount(Account account) {
        int id = account.getCustomerId();
        if(accountRepository.existsByCustomerId(id))
        {
            accountRepository.delete(account);
            return true;
        }
        else
            return false;
    }

    @Override
    public List<String> getSourceCodeList(String q) {
        return accountRepository.findBySourceCodeLike(q);
    }

    @Override
    public List<String> getCityList(String q) {
        return accountRepository.findByCityLike(q);
    }

    @Override
    public List<String> getTechnicianList(String q) {
        return serviceRepository.findByTechnicianLike(q);
    }
}
