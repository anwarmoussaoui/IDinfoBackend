package com.example.auth.controllers;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IDcard {
    private String first_name;
    private String last_name;
    private String date_of_birth;
    private String place_of_birth;
    private String id_code;

}
