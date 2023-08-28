package com.project.crud.Services;

import java.util.List;

import com.project.crud.Models.Entity.UserEntity;


public interface UserService {
    // !-------------------------------------------------------------------------------

    List<UserEntity> findAll();
    // !-------------------------------------------------------------------------------

    UserEntity findById(Long id);
    // !-------------------------------------------------------------------------------

    UserEntity CreateUser(UserEntity user);
    // !-------------------------------------------------------------------------------

    UserEntity updateById(Long id, UserEntity user);
    // !-------------------------------------------------------------------------------

    void deleteById(Long id);
}