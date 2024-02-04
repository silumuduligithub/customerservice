/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.curstomerservice.serviceImpl;

import com.example.curstomerservice.Transfermers.CustomerTransfermer;
import com.example.curstomerservice.dtos.requestdots.CustomerByCityRequestDto;
import com.example.curstomerservice.dtos.requestdots.CustomerByEmailRequestDto;
import com.example.curstomerservice.dtos.requestdots.CustomerByFirstNameRequestDto;
import com.example.curstomerservice.dtos.requestdots.CustomerByIdDto;
import com.example.curstomerservice.dtos.requestdots.CustomerByPhoneRequestDto;
import com.example.curstomerservice.dtos.requestdots.CustomerRequestDto;
import com.example.curstomerservice.entity.Customer;
import com.example.curstomerservice.event.Event;
import com.example.curstomerservice.event.EventSuccess;
import com.example.curstomerservice.exceptions.CustomerCredentialException;
import com.example.curstomerservice.exceptions.CustomerNotFound;
import com.example.curstomerservice.repository.ICustomerRepository;
import com.example.curstomerservice.service.ICustomerService;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author siluk
 */
@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    ICustomerRepository customerRepository;

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Override
    public Event addCustomer(CustomerRequestDto customerRequestDto) throws CustomerCredentialException {
        try {
            Customer customer = CustomerTransfermer.ConvertCustomerRequestDtoTOCustomerEntity(customerRequestDto);
            customerRepository.save(customer);
            Random random = new Random();
            EventSuccess eventSuccess = new EventSuccess(random.nextInt(9919292) + "");
            eventSuccess.setMessage("customer added successfully");
            logger.info("customer added successfully");
            return eventSuccess;
        } catch (Exception e) {
            logger.info("error cought during add customer");
            throw new CustomerCredentialException(e.getMessage());
        }
    }

    public Event updateCustomerById(CustomerRequestDto customerUpdateRequestDto) throws CustomerNotFound {
        Optional<Customer> customerToBeEdited = customerRepository.findById(customerUpdateRequestDto.getId());
        Random random = new Random();
        if (customerToBeEdited.isEmpty()) {
            logger.info("error cought during add customer");
            throw new CustomerNotFound("please enter a valid customer id");
        } else {
            customerToBeEdited.get().setFirstname(customerUpdateRequestDto.getFirstname());
            customerToBeEdited.get().setLast_name(customerUpdateRequestDto.getLast_name());
            customerToBeEdited.get().setAddress(customerUpdateRequestDto.getAddress());
            customerToBeEdited.get().setCity(customerUpdateRequestDto.getCity());
            customerToBeEdited.get().setStreet(customerUpdateRequestDto.getStreet());
            customerToBeEdited.get().setState(customerUpdateRequestDto.getState());
            customerToBeEdited.get().setEmail(customerUpdateRequestDto.getEmail());

            customerRepository.save(customerToBeEdited.get());
            EventSuccess eventSuccess = new EventSuccess(random.nextInt(9919292) + "");
            eventSuccess.setMessage("customer added successfully");
            logger.info("customer updated successfully");
            return eventSuccess;
        }
    }

    public Event getCustomerById(CustomerByIdDto customerrequestdto) throws CustomerNotFound {
        Optional<Customer> customer = customerRepository.findById(customerrequestdto.getId());
        Random random = new Random();
        if (customer.isEmpty()) {
            logger.info("error cought during add customer");
            throw new CustomerNotFound("please enter a valid customer id");
        } else {
            EventSuccess eventSuccess = new EventSuccess(random.nextInt(9919292) + "");
            eventSuccess.setMessage(customer.get().toString());
            logger.info("got the Customer successfully");
            return eventSuccess;
        }
    }

    public Event getCustomerByFirstName(CustomerByFirstNameRequestDto customerByFirstNameRequestDto) throws CustomerNotFound{
        List<Customer> customer = customerRepository.findAllByFirstname(customerByFirstNameRequestDto.getFirstname());
        Random random = new Random();
        if (customer.isEmpty()) {
            logger.info("error cought during add customer");
            throw new CustomerNotFound("please enter a valid customer name");
        } else {
            EventSuccess eventSuccess = new EventSuccess(random.nextInt(9919292) + "");
            eventSuccess.setMessage(customer.toString());
            logger.info("got the Customer successfully");
            return eventSuccess;
        }
//return null;
    }
    
    public Event getCustomerByCity(CustomerByCityRequestDto customerByCityRequestDto) throws CustomerNotFound{
        List<Customer> customer = customerRepository.findAllByCity(customerByCityRequestDto.getCity());
        Random random = new Random();
        if (customer.isEmpty()) {
            logger.info("error cought during add customer");
            throw new CustomerNotFound("please enter a valid customer id");
        } else {
            EventSuccess eventSuccess = new EventSuccess(random.nextInt(9919292) + "");
            eventSuccess.setMessage(customer.toString());
            logger.info("got the Customer successfully");
            return eventSuccess;
        }
    }

    public Event getCustomerByEmail(CustomerByEmailRequestDto customerByEmailRequestDto) throws CustomerNotFound{
        Optional<Customer> customer = customerRepository.findByEmail(customerByEmailRequestDto.getEmail());
        Random random = new Random();
        if (customer.isEmpty()) {
            logger.info("error cought during add customer");
            throw new CustomerNotFound("please enter a valid customer email");
        } else {
            EventSuccess eventSuccess = new EventSuccess(random.nextInt(9919292) + "");
            eventSuccess.setMessage(customer.get().toString());
            logger.info("got the Customer successfully");
            return eventSuccess;
        }
    }
     public Event getCustomerByPhone(CustomerByPhoneRequestDto customerByPhoneRequestDto)throws CustomerNotFound{
          Optional<Customer> customer = customerRepository.findByPhone(customerByPhoneRequestDto.getPhone());
        Random random = new Random();
        if (customer.isEmpty()) {
            logger.info("error cought during add customer");
            throw new CustomerNotFound("please enter a valid phone number");
        } else {
            EventSuccess eventSuccess = new EventSuccess(random.nextInt(9919292) + "");
            eventSuccess.setMessage(customer.get().toString());
            logger.info("got the Customer successfully");
            return eventSuccess;
        }
     }
    public Event getAllCustomer() {
        List<Customer> customerList = customerRepository.findAll();
        Random random = new Random();
        EventSuccess eventSuccess = new EventSuccess(random.nextInt(9919292) + "");
        eventSuccess.setMessage(customerList.toString());
        logger.info("get all the successfully");
        return eventSuccess;
    }

    public Event deleteCustomer(CustomerByIdDto customerByIdDto) throws CustomerNotFound {
        Optional<Customer> customer = customerRepository.findById(customerByIdDto.getId());
        Random random = new Random();
        if (customer.isEmpty()) {
            logger.info("error cought during add customer");
            throw new CustomerNotFound("please enter a valid customer id");
        } else {
            customerRepository.deleteById(customerByIdDto.getId());
            EventSuccess eventSuccess = new EventSuccess(random.nextInt(9919292) + "");
            eventSuccess.setMessage( "Customer Deleted successfully " + customer.get().toString());
            logger.info("customer deleted successfully");
            return eventSuccess;
        }
    }

}
