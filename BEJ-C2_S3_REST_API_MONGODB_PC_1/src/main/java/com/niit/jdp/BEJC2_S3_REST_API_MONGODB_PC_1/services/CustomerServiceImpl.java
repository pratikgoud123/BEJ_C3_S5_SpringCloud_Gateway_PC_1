/*
 * Author Name: Pratik Goud
 * Date: 24-11-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.BEJC2_S3_REST_API_MONGODB_PC_1.services;

import com.niit.jdp.BEJC2_S3_REST_API_MONGODB_PC_1.domain.Customer;
import com.niit.jdp.BEJC2_S3_REST_API_MONGODB_PC_1.exceptions.customerAlreadyExists;
import com.niit.jdp.BEJC2_S3_REST_API_MONGODB_PC_1.exceptions.customerDoesNotExist;
import com.niit.jdp.BEJC2_S3_REST_API_MONGODB_PC_1.respository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements ICustomerService {

    private CustomerRepository customerRepository;
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer customer) throws customerAlreadyExists {
        if (customerRepository.findById(customer.getCustomerId()).isPresent()){
            throw new customerAlreadyExists();
        }
        return customerRepository.save(customer);
    }

    @Override
    public boolean deleteCustomer(int customerId) throws customerDoesNotExist {
        if (customerRepository.findById(customerId).isEmpty()){
            throw new customerDoesNotExist();
        }
        customerRepository.deleteById(customerId);
        return true;
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> getCustomersByProductName(String productName) throws customerDoesNotExist {
        if (customerRepository.findAllCustomersByProductName(productName).isEmpty()){
            throw new customerDoesNotExist();
        }
        return customerRepository.findAllCustomersByProductName(productName);
    }
}
