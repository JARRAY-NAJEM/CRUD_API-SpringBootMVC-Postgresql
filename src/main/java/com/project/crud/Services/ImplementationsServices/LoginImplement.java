package com.project.crud.Services.ImplementationsServices;

import com.project.crud.Models.Entity.UserEntity;
import com.project.crud.Repositories.LoginRepository;
import com.project.crud.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginImplement implements LoginService {

  private final LoginRepository loginRepository; // Assuming you have a UserRepository

  public LoginImplement(LoginRepository loginRepository) {
    this.loginRepository = loginRepository;
  }

  @Override
  public boolean verifyLogin(String email, String password) {
    UserEntity user = loginRepository.findByEmail(email);
    if (user != null && user.getPassword().equals(password)) {
      return true; // Email and password are correct
    }
    return false; // Either user not found or incorrect password
  }
}
