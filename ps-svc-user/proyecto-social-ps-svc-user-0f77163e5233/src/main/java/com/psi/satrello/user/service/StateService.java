package com.psi.satrello.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.psi.satrello.user.entity.State;
import com.psi.satrello.user.repository.StateRepository;

// Service for state creation after validation in the endpoint
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public State create(State state){
        return stateRepository.save(state);
    }

    public List<State> getAllStates(){
        return stateRepository.findAll();
    }
    
    public void delete(State state){
        stateRepository.delete(state);
    }

    public Optional<State> findById(Long id){
        return stateRepository.findById(id);
    }
}
