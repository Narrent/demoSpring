package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.exception.UserAlreadyExistException;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public UserEntity reg(UserEntity user) throws UserAlreadyExistException {
        if(userRepo.findByName(user.getName())!= null){
            throw new UserAlreadyExistException("Есть такой уже!");
        }
        return userRepo.save(user);
    }
}
