package com.psi.satrello.user.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psi.satrello.user.entity.Role;
import com.psi.satrello.user.service.RoleService;

@RestController
@RequestMapping ("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    // Endpoint for creating new user roles 
    @PostMapping
    private ResponseEntity<Role> save(@RequestBody Role role){
        Role temp = roleService.create(role);

        try{
            return ResponseEntity.created(new URI("/role"+temp.getRole_id())).body(temp);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // Endpoint for retrieving all user roles
    @GetMapping
    private ResponseEntity<List<Role>> listAll(){
        return ResponseEntity.ok(roleService.getAllRoles());
    }

    // Endpoint for deleting a user role
    @DeleteMapping
    private ResponseEntity<Void> delete(@RequestBody Role role){
        roleService.delete(role);
        return ResponseEntity.ok().build();
    }
    
}
