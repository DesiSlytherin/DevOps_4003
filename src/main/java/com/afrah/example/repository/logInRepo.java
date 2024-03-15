package com.afrah.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.afrah.example.domain.logIn;


@Repository
public interface logInRepo extends JpaRepository<logIn,String>
{
    logIn findByUsernameAndPassword(String username, String password);
}
                                               