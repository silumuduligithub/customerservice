/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.curstomerservice.controller;

import com.example.curstomerservice.dtos.requestdots.CustomerByCityRequestDto;
import com.example.curstomerservice.dtos.requestdots.CustomerByEmailRequestDto;
import com.example.curstomerservice.dtos.requestdots.CustomerByFirstNameRequestDto;
import com.example.curstomerservice.dtos.requestdots.CustomerByIdDto;
import com.example.curstomerservice.dtos.requestdots.CustomerByPhoneRequestDto;
import com.example.curstomerservice.dtos.requestdots.CustomerRequestDto;
import com.example.curstomerservice.event.Event;
import com.example.curstomerservice.event.EventFailed;
import com.example.curstomerservice.service.ICustomerService;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author siluk
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    ICustomerService customerservice;

//    @Autowired
    RestTemplate restTemplate = new RestTemplate();
    @PostMapping("/add-customer")
    public ResponseEntity<?> addCustomer(@ModelAttribute CustomerRequestDto customerRequestDto) {
        logger.info(">>Customer add request got : " + customerRequestDto);
        Event event = null;
        try {
            event = customerservice.addCustomer(customerRequestDto);
            logger.info("customer added successfully" + event);
            return BuildResponse(HttpStatus.OK, event.toString());
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            event = new EventFailed(new Random().nextInt(9999999) + "");
            event.setMessage(ex.getMessage());
        }
        return BuildResponse(HttpStatus.INTERNAL_SERVER_ERROR, event.toString());
    }

    @PutMapping("edit-customer")
    public ResponseEntity<?> updateCustomerById(@RequestBody CustomerRequestDto customerUpdateRequestDto) {
        logger.info(">>Customer update request got : " + customerUpdateRequestDto);
        Event event = null;
        try {
            event = customerservice.updateCustomerById(customerUpdateRequestDto);
            logger.info("customer updated successfully" + event);
            return BuildResponse(HttpStatus.OK, event.toString());
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            event = new EventFailed(new Random().nextInt(9999999) + "");
            event.setMessage(ex.getMessage());
        }
        return BuildResponse(HttpStatus.NOT_FOUND, event.toString());
    }

    @PostMapping("get-customer-by-id")
    public ResponseEntity<?> getCustomerById(@RequestBody CustomerByIdDto customerId) {
        logger.info(">> get Customer by id request got : " + customerId);
        System.out.println(customerId.getId());
        Event event = null;
        try {
            event = customerservice.getCustomerById(customerId);
            logger.info("got the customer successfully" + event);
            return new ResponseEntity<>(event, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            event = new EventFailed(new Random().nextInt(9999999) + "");
            event.setMessage(ex.getMessage());
        }
        return BuildResponse(HttpStatus.NOT_FOUND, event.toString());
    }

    @PostMapping("get-customer-by-firstname")
    public ResponseEntity<?> getCustomerByFirstName(@RequestBody CustomerByFirstNameRequestDto customerByFirstNameRequestDto) {
        logger.info(">> get Customer by first_name request got : " + customerByFirstNameRequestDto);
        System.out.println(customerByFirstNameRequestDto.getFirstname());
        Event event = null;
        try {
            event = customerservice.getCustomerByFirstName(customerByFirstNameRequestDto);
            logger.info("got the successfully" + event);
            return new ResponseEntity<>(event, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            event = new EventFailed(new Random().nextInt(9999999) + "");
            event.setMessage(ex.getMessage());
        }
        return BuildResponse(HttpStatus.NOT_FOUND, event.toString());
    }
    
    @PostMapping("get-customer-by-city")
    public ResponseEntity<?> getCustomerByCity(@RequestBody CustomerByCityRequestDto customerByCityRequestDto) {
        logger.info(">> get Customer by city request got : " + customerByCityRequestDto.getCity());
        System.out.println(customerByCityRequestDto.getCity());
        Event event = null;
        try {
            event = customerservice.getCustomerByCity(customerByCityRequestDto);
            logger.info("got the successfully" + event);
            return new ResponseEntity<>(event, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            event = new EventFailed(new Random().nextInt(9999999) + "");
            event.setMessage(ex.getMessage());
        }
        return BuildResponse(HttpStatus.NOT_FOUND, event.toString());
    }
    
    @PostMapping("get-customer-by-phone")
    public ResponseEntity<?> getCustomerByPhone(@RequestBody CustomerByPhoneRequestDto customerByPhoneRequestDto) {
        logger.info(">> get Customer by phone request got : " + customerByPhoneRequestDto.getPhone());
        System.out.println(customerByPhoneRequestDto.getPhone());
        Event event = null;
        try {
            event = customerservice.getCustomerByPhone(customerByPhoneRequestDto);
            logger.info("got the customer successfully by phone" + event);
            return new ResponseEntity<>(event, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            event = new EventFailed(new Random().nextInt(9999999) + "");
            event.setMessage(ex.getMessage());
        }
        return BuildResponse(HttpStatus.NOT_FOUND, event.toString());
    }
    
    @PostMapping("get-customer-by-email")
    public ResponseEntity<?> getCustomerByEmail(@RequestBody CustomerByEmailRequestDto customerByEmailRequestDto) {
        logger.info(">> get Customer by city request got by email : " + customerByEmailRequestDto.getEmail());
        System.out.println(customerByEmailRequestDto.getEmail());
        Event event = null;
        try {
            event = customerservice.getCustomerByEmail(customerByEmailRequestDto);
            logger.info("got the customer successfully by email" + event);
            return new ResponseEntity<>(event, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            event = new EventFailed(new Random().nextInt(9999999) + "");
            event.setMessage(ex.getMessage());
        }
        return BuildResponse(HttpStatus.NOT_FOUND, event.toString());
    }
    
    
    @GetMapping("get-allcustomer")
    public ResponseEntity<?> getAllCustomer() {
        logger.info(">> get all Customer request got : ");
        Event event = customerservice.getAllCustomer();
        logger.info("customer updated successfully" + event);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    @DeleteMapping("delete-customer")
    public ResponseEntity<?> deleteCustomer(@RequestBody CustomerRequestDto customerByIdDto) {
        logger.info(">> delete Customer request got : ");
        Event event = null;
        try {
            event = customerservice.deleteCustomer(customerByIdDto);
            logger.info("customer deleted successfully" + event);
            return new ResponseEntity<>(event, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            event = new EventFailed(new Random().nextInt(9999999) + "");
            event.setMessage(ex.getMessage());
        }
        return BuildResponse(HttpStatus.NOT_FOUND, event.toString());
    }

    
    private ResponseEntity<?> BuildResponse(HttpStatus status, String obj) {
        logger.info("Build Response : " + obj.toString());
        return ResponseEntity.status(status).body(obj);
    }
    
    @PostMapping("getdata-from-remote-api")
     public ResponseEntity<String> getDataFromRemoteAPI() {
        String remoteApiUrl = "https://qa.sunbasedata.com/sunbase/portal/api/assignment.jsp?cmd=get_customer_list";

        // Create HttpHeaders and add Authorization header
        logger.info("remote api called ***************************************");
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "dGVzdEBzdW5iYXNlZGF0YS5jb206VGVzdEAxMjM=");

        // Create HttpEntity with HttpHeaders
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Make a GET request to the remote API with Authorization header
        ResponseEntity<String> response = restTemplate.exchange(remoteApiUrl, HttpMethod.GET, entity, String.class);
        return response;
    }
}
