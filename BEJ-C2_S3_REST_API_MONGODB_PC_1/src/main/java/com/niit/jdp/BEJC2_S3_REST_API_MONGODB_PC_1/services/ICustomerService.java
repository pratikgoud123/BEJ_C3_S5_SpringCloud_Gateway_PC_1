package com.niit.jdp.BEJC2_S3_REST_API_MONGODB_PC_1.services;

import com.niit.jdp.BEJC2_S3_REST_API_MONGODB_PC_1.domain.Customer;
import com.niit.jdp.BEJC2_S3_REST_API_MONGODB_PC_1.exceptions.customerAlreadyExists;
import com.niit.jdp.BEJC2_S3_REST_API_MONGODB_PC_1.exceptions.customerDoesNotExist;

import java.util.List;

public interface ICustomerService {

    Customer saveCustomer (Customer customer) throws customerAlreadyExists;
    boolean deleteCustomer (int customerId) throws customerDoesNotExist;
    List<Customer> getAllCustomer ();
    List<Customer> getCustomersByProductName (String productName) throws customerDoesNotExist;

}
