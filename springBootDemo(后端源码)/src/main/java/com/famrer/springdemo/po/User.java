package com.famrer.springdemo.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;

    @Length(min = 5, max = 20)
    @NotNull
    private String username;

    @Email
    private String email;

    @NotNull
    @Length(min = 5, max = 32)
    private String password;



}
