/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.curstomerservice.service;

import com.example.curstomerservice.dtos.requestdots.CustomerByCityRequestDto;
import com.example.curstomerservice.dtos.requestdots.CustomerByEmailRequestDto;
import com.example.curstomerservice.dtos.requestdots.CustomerByFirstNameRequestDto;
import com.example.curstomerservice.dtos.requestdots.CustomerByIdDto;
import com.example.curstomerservice.dtos.requestdots.CustomerByPhoneRequestDto;
import com.example.curstomerservice.dtos.requestdots.CustomerRequestDto;
import com.example.curstomerservice.event.Event;
import com.example.curstomerservice.exceptions.CustomerCredentialException;
import com.example.curstomerservice.exceptions.CustomerNotFound;

/**
 *
 * @author siluk
 */
public interface ICustomerService {

    public Event addCustomer(CustomerRequestDto customerRequestDto) throws CustomerCredentialException;

    public Event updateCustomerById(CustomerRequestDto customerUpdateRequestDto) throws CustomerNotFound;

    public Event getCustomerById(CustomerByIdDto customerId) throws CustomerNotFound;

    public Event getAllCustomer();

    public Event deleteCustomer(CustomerByIdDto customerByIdDto) throws CustomerNotFound;

    public Event getCustomerByFirstName(CustomerByFirstNameRequestDto customerByFirstNameRequestDto) throws CustomerNotFound;

    public Event getCustomerByCity(CustomerByCityRequestDto customerByCityRequestDto) throws CustomerNotFound;

    public Event getCustomerByEmail(CustomerByEmailRequestDto customerByEmailRequestDto) throws CustomerNotFound;

    public Event getCustomerByPhone(CustomerByPhoneRequestDto customerByPhoneRequestDto)throws CustomerNotFound;
}
