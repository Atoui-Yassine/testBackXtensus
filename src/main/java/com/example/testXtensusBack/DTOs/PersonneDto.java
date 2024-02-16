package com.example.testXtensusBack.DTOs;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class PersonneDto {

    private String nom;
    private String prenom;
    private String tel;
    private String mail;
    private long gouvernementID =0;
}
