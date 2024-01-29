package com.psi.satrello.user.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psi.satrello.user.entity.Login;
import com.psi.satrello.user.repository.LoginRepository;

// Service for login access creation after validation in the endpoint 
@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public Login create(Login login){
        return loginRepository.save(login);
    }

    public List<Login> getAllLogins(){
        return loginRepository.findAll();
    }
    
    public void delete(Login login){
        loginRepository.delete(login);
    }

    public Optional<Login> findById(UUID id){
        return loginRepository.findById(id);
    }
}