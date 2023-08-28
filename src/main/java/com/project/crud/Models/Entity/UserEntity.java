package com.project.crud.Models.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@Table(name = "userData")
public class UserEntity {

  // !-------------------------------------------------------------------------------

  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // !-------------------------------------------------------------------------------

  @Column
  @NotNull(message = "First name may not be empty")
  private String first_name;

  // !-------------------------------------------------------------------------------

  @Column
  @NotNull(message = "Last name may not be empty")
  private String last_name;

  // !-------------------------------------------------------------------------------

  @Column
  @NotNull(message = "Birth date may not be empty")
  @Min(value = 18, message = "Age should not be less than 18")
  private Integer birth;

  // !-------------------------------------------------------------------------------

  @Column
  @NotNull(message = "Address may not be empty")
  private String address;

  // !-------------------------------------------------------------------------------

  @Column(unique = true)
  @NotNull(message = "Email may not be empty")
  @Email(message = "Invalid email format")
  private String email;

  // !-------------------------------------------------------------------------------

  @Column
  @NotNull(message = "Password may not be empty")
  @Pattern(
    regexp = "^[a-zA-Z0-9]+$",
    message = "Password should only contain letters and numbers"
  )
  private String password;

  // !-------------------------------------------------------------------------------

  public UserEntity(
    Long id,
    String first_name,
    String last_name,
    Integer birth,
    String address,
    String email,
    String password
  ) {
    this.id = id;
    this.first_name = first_name;
    this.last_name = last_name;
    this.birth = birth;
    this.address = address;
    this.email = email;
    this.password = password;
  }

  // !-------------------------------------------------------------------------------

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  // !-------------------------------------------------------------------------------

  public String getfirst_name() {
    return this.first_name;
  }

  public void setfirst_name(String first_name) {
    this.first_name = first_name;
  }

  // !-------------------------------------------------------------------------------

  public String getlast_name() {
    return this.last_name;
  }

  public void setlast_name(String last_name) {
    this.last_name = last_name;
  }

  // !-------------------------------------------------------------------------------

  public Integer getBirth() {
    return this.birth;
  }

  public void setBirth(Integer birth) {
    this.birth = birth;
  }

  // !-------------------------------------------------------------------------------

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  // !-------------------------------------------------------------------------------

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  // !-------------------------------------------------------------------------------

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  // !-------------------------------------------------------------------------------

  public boolean isPresent() {
    return false;
  }
}
