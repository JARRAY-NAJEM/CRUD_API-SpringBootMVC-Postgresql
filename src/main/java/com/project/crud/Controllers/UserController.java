package com.project.crud.Controllers;

import com.project.crud.Models.Entity.UserEntity;
import com.project.crud.Services.UserService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("user")
public class UserController {

  // !-------------------------------------------------------------------------------
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  // !-------------------------------------------------------------------------------

  @GetMapping
  public List<UserEntity> findAll() {
    return userService.findAll();
  }

  // !-------------------------------------------------------------------------------

  @GetMapping("/{id}")
  public UserEntity findById(@PathVariable Long id) {
    try {
      return userService.findById(id);
    } catch (NoSuchElementException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
    }
  }

  // !-------------------------------------------------------------------------------

  @PostMapping
  public UserEntity createUser(@Valid @RequestBody UserEntity user) {
    return userService.CreateUser(user);
  }

  // !-------------------------------------------------------------------------------
  @PutMapping("/{id}")
  public UserEntity updateById(
    @PathVariable Long id,
    @RequestBody UserEntity user
  ) {
    return userService.updateById(id, user);
  }

  // !-------------------------------------------------------------------------------

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Long id) {
    try {
      userService.deleteById(id);
    } catch (NoSuchElementException e) {
      throw new ResponseStatusException(
        HttpStatus.NOT_FOUND,
        "User not found",
        e
      );
    } catch (Exception e) {
      throw new ResponseStatusException(
        HttpStatus.INTERNAL_SERVER_ERROR,
        "Failed to delete user",
        e
      );
    }
  }
  // !-------------------------------------------------------------------------------

}
