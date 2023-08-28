package com.project.crud.Services.ImplementationsServices;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.project.crud.Models.Entity.UserEntity;
import com.project.crud.Repositories.UserRepository;
import com.project.crud.Services.UserService;

@Service
public class UserImplement implements UserService {

    // !-------------------------------------------------------------------------------

    private final UserRepository userRepository;
    // constructor

    public UserImplement(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    // !-------------------------------------------------------------------------------

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }
    // !-------------------------------------------------------------------------------

    @Override
    public UserEntity findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
    }
    // !-------------------------------------------------------------------------------

    @Override
    public UserEntity CreateUser(UserEntity user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        System.out.println("Hello from Spring Boot!  CreateUser  " + user + " Function");

        return userRepository.save(user);
    }
    // !-------------------------------------------------------------------------------

    @Override
    public UserEntity updateById(Long id, UserEntity user) {
                System.out.println("Hello from Spring Boot!  CreateUser  " + user + " Function");

        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setfirst_name(user.getfirst_name());
                    existingUser.setlast_name(user.getlast_name());
                    existingUser.setBirth(user.getBirth());
                    existingUser.setAddress(user.getAddress());
                    existingUser.setEmail(user.getEmail());
                    existingUser.setPassword(user.getPassword());
                    return userRepository.save(existingUser);
                })
                .orElse(null); // Or throw an exception indicating user not found
    }
    // !-------------------------------------------------------------------------------

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
    // !-------------------------------------------------------------------------------

}
