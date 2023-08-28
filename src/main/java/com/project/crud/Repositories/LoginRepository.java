package com.project.crud.Repositories;

import com.project.crud.Models.Entity.LoginEntity;
import com.project.crud.Models.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<UserEntity, Long> {
  UserEntity findByEmail(String email);
}
