/*
 * Author Name: Pratik Goud
 * Date: 24-11-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.BEJC2_S3_REST_API_MONGODB_PC_1.controller;

import com.niit.jdp.BEJC2_S3_REST_API_MONGODB_PC_1.domain.Customer;
import com.niit.jdp.BEJC2_S3_REST_API_MONGODB_PC_1.exceptions.customerAlreadyExists;
import com.niit.jdp.BEJC2_S3_REST_API_MONGODB_PC_1.exceptions.customerDoesNotExist;
import com.niit.jdp.BEJC2_S3_REST_API_MONGODB_PC_1.services.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2")
public class CustomerController {

    private CustomerServiceImpl customerService;
    @Autowired
    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/insertCustomer")
    public ResponseEntity<?> insertCustomer (@RequestBody Customer customer) throws customerAlreadyExists {
        try{
            return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.CREATED);
        }catch(customerAlreadyExists e){
            throw new customerAlreadyExists();
        }catch(Exception e){
            return new ResponseEntity<>("Server error, try after sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteCustomerById/{customerId}")
    public ResponseEntity<?> insertCustomer (@PathVariable int customerId) throws customerDoesNotExist {
        try{
            return new ResponseEntity<>(customerService.deleteCustomer(customerId), HttpStatus.OK);
        }catch(customerDoesNotExist e){
            throw new customerDoesNotExist();
        }catch(Exception e){
            return new ResponseEntity<>("Server error, try after sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findAllCustomer")
    public ResponseEntity<?> findAllCustomer (){
        return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.OK);
    }

    @GetMapping("/findCustomerByProductName/{productName}")
    public ResponseEntity<?> findCustomerByProductName (@PathVariable String productName) throws customerDoesNotExist{
        try{
            return new ResponseEntity<>(customerService.getCustomersByProductName(productName), HttpStatus.OK);
        }catch(customerDoesNotExist e){
            throw new customerDoesNotExist();
        }catch(Exception e){
            return new ResponseEntity<>("Server error, try after sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
