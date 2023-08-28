package com.project.crud.Controllers;

import com.project.crud.Models.Entity.LoginEntity;
import com.project.crud.Models.Entity.UserEntity;
import com.project.crud.Repositories.LoginRepository;
import com.project.crud.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

  private final LoginService loginService;

  public LoginController(LoginService loginService) {
    this.loginService = loginService;
  }

  @PostMapping("/login")
  public ResponseEntity<String> verifyLogin(
    @RequestBody LoginEntity loginEntity
  ) {
    if (
      loginService.verifyLogin(
        loginEntity.getEmail(),
        loginEntity.getPassword()
      )
    ) {
      return ResponseEntity.ok("Login successful");
    }
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
  }
}
