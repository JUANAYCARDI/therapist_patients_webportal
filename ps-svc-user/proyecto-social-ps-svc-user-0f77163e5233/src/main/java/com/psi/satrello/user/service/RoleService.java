package com.psi.satrello.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psi.satrello.user.entity.Role;
import com.psi.satrello.user.repository.RoleRepository;

// Service for role creation after validation in the endpoint
@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role create(Role role){
        return roleRepository.save(role);
    }

    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }
    
    public void delete(Role role){
        roleRepository.delete(role);
    }

    public Optional<Role> findById(Long id){
        return roleRepository.findById(id);
    }
}
