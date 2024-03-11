package com.nt.controller;


import com.nt.hash.Customer;
import com.nt.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;


    @PostMapping("/saveCustomer")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
        return new ResponseEntity(customerService.addCustomer(customer), HttpStatus.CREATED);
    }

    @GetMapping("/getCustomerById/{cid}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Integer cid){
        return new ResponseEntity(customerService.getCustomerById(cid),HttpStatus.ACCEPTED);
    }

    @GetMapping("/getAllCustomer")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        return new ResponseEntity<>(customerService.getAllCustomer(),HttpStatus.OK);
    }

    @DeleteMapping("/deleteMapping")
    public ResponseEntity<String> deleteCustomer(@RequestParam int id){
        return new ResponseEntity<>(customerService.deleteCustomer(id),HttpStatus.GONE);
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.addCustomer(customer),HttpStatus.ACCEPTED);
    }


    @PutMapping("/refreshCache")
    public ResponseEntity<List<Customer>>cacheRefresh(){
       return new ResponseEntity<>(customerService.refreshCache(),HttpStatus.OK) ;
    }


}
