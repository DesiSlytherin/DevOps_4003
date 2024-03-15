package com.afrah.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afrah.example.repository.logInRepo;
import com.afrah.example.domain.logIn;

@Service
public class logInService 
{
    @Autowired
    private logInRepo rep;

    public logIn log(String username, String password)
    {
        logIn user=rep.findByUsernameAndPassword(username, password);
        return user;
    }
}
