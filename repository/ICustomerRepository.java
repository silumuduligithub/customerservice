/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.curstomerservice.repository;

import com.example.curstomerservice.entity.Customer;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author siluk
 */
public interface ICustomerRepository extends JpaRepository<Customer, Integer>{

    public Optional<Customer> findByFirstname(String first_name);

    public Optional<Customer> findByCity(String city);

    public Optional<Customer> findByPhone(String phone);

    public Optional<Customer> findByEmail(String email);

    public List<Customer> findAllByFirstname(String firstname);

    public List<Customer> findAllByCity(String city);
    
}
