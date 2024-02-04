/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.curstomerservice.dtos.requestdots;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author siluk
 */
@Getter
@Setter
public class CustomerRequestDto extends CustomerByIdDto{

    private String firstname;
    private String last_name;
    private String street;
    private String address;
    private String city;
    private String state;
    private String email;
    private String phone;
}
