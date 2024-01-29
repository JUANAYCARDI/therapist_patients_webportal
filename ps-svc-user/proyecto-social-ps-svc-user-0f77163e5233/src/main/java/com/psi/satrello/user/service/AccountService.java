package com.psi.satrello.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psi.satrello.user.entity.Account;
import com.psi.satrello.user.model.AccountLoginRequest;
import com.psi.satrello.user.repository.AccountRepository;

// Service for user account creation after validation in the endpoint
@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account create(AccountLoginRequest account){
        Account acc = new Account();
        acc.setName(account.getName());
        acc.setUsername(account.getUsername());
        acc.setPersonalId(account.getPersonalId());
        acc.setRoleId(account.getRoleId());
        acc.setPhone(account.getPhone());
        acc.setEmail(account.getEmail());
        acc.setAvatarUrl(account.getAvatarUrl());
        acc.setStateId(account.getStateId());
        return accountRepository.save(acc);
    }

    public Account update(Account account){
        return accountRepository.save(account);
    }

    public List<Account> checkUserState(String checkState){
        return accountRepository.findAllByPersonalId(checkState);
    }

    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }
    
    public void delete(Account account){
        accountRepository.delete(account);
    }
}