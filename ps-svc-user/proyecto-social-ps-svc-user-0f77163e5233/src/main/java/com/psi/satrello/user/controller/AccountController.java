package com.psi.satrello.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psi.satrello.user.entity.Account;
import com.psi.satrello.user.entity.Login;
import com.psi.satrello.user.model.AccountLoginRequest;
import com.psi.satrello.user.service.AccountService;
import com.psi.satrello.user.service.LoginService;

@RestController
@RequestMapping("/register")
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    // Endpoint for creating a new standard user (Therapist, Patient)
    @PostMapping
    private ResponseEntity<Void> save(@RequestBody AccountLoginRequest account){

        String checkState = account.getPersonalId();
        List<Account> tempAcc = accountService.checkUserState(checkState);

        if(!tempAcc.isEmpty()){
            Integer state = tempAcc.get(0).getStateId();
            if(state == 1){
                throw new RuntimeException( "There already exists an active account with this personal id. Try again.");
            }
            else{
                if(tempAcc.get(0).getRoleId() == 1){
                    throw new RuntimeException( "You don't have permission to create a new administrator. Please change your role id.");
                }
                else{
                    Account actAccount = tempAcc.get(0);
                    actAccount.setStateId(1);
                    accountService.update(actAccount);
                    Login log = new Login();
                    log.setAccount(actAccount);
                    log.setPersonalId(account.getPersonalId());
                    log.setPassword(passwordEncoder.encode(account.getPassword()));
                    loginService.create(log);
                    return new ResponseEntity<Void>(HttpStatus.CREATED);
                } 
            }
        }
        else{
            if(account.getRoleId() == 1){
                throw new RuntimeException( "You don't have permission to create a new administrator. Please change your role id.");
            }
            Account temp = accountService.create(account);
            Login log = new Login();
            log.setAccount(temp);
            log.setPassword(passwordEncoder.encode(account.getPassword()));
            loginService.create(log);
            return new ResponseEntity<Void>(HttpStatus.CREATED);   
        }
    }

    // Endpoint for creating a new administrator user
    @PostMapping("/admin")
    private ResponseEntity<Void> saveAdmin(@RequestBody AccountLoginRequest account){
        
        String checkState = account.getPersonalId();
        List<Account> tempAcc = accountService.checkUserState(checkState);

        if(!tempAcc.isEmpty()){
            Integer state = tempAcc.get(0).getStateId();
            if(state == 1){
                throw new RuntimeException( "There already exists an active account with this personal id. Try again.");
            }
            else{
                if(tempAcc.get(0).getRoleId() != 1){
                    throw new RuntimeException( "You must use the correct role id to create a new administrator. Please change your role id.");
                }
                else{
                    Account actAccount = tempAcc.get(0);
                    actAccount.setStateId(1);
                    accountService.update(actAccount);
                    Login log = new Login();
                    log.setAccount(actAccount);
                    log.setPersonalId(account.getPersonalId());
                    log.setPassword(passwordEncoder.encode(account.getPassword()));
                    loginService.create(log);
                    return new ResponseEntity<Void>(HttpStatus.CREATED);
                } 
            }
        }
        else{
            if(account.getRoleId() != 1){
                throw new RuntimeException( "You must use the correct role id to create a new administrator. Please change your role id.");
            }
            Account temp = accountService.create(account);
            Login log = new Login();
            log.setAccount(temp);
            log.setPassword(passwordEncoder.encode(account.getPassword()));
            loginService.create(log);
            return new ResponseEntity<Void>(HttpStatus.CREATED);   
        }
    }

    // Endpoint for retrieving information of all created users
    @GetMapping
    private ResponseEntity<List<Account>> listAll(){
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    // Endpoint for deleting a specific user
    @DeleteMapping
    private ResponseEntity<Void> delete(@RequestBody Account account){
        accountService.delete(account);
        return ResponseEntity.ok().build();
    }
}