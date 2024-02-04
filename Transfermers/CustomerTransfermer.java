/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.curstomerservice.Transfermers;

import com.example.curstomerservice.dtos.requestdots.CustomerRequestDto;
import com.example.curstomerservice.entity.Customer;

/**
 *
 * @author siluk
 */
public class CustomerTransfermer {

    public static Customer ConvertCustomerRequestDtoTOCustomerEntity(CustomerRequestDto customerRequestDto) {
        Customer customer = Customer.builder().firstname(customerRequestDto.getFirstname())
                .last_name(customerRequestDto.getLast_name())
                .street(customerRequestDto.getStreet())
                .address(customerRequestDto.getAddress())
                .city(customerRequestDto.getCity())
                .state(customerRequestDto.getState())
                .email(customerRequestDto.getEmail())
                .phone(customerRequestDto.getPhone())
                .build();
        return customer;
    }
}
