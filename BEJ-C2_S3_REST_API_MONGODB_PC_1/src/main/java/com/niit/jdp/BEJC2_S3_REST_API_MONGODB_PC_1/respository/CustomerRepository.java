package com.niit.jdp.BEJC2_S3_REST_API_MONGODB_PC_1.respository;

import com.niit.jdp.BEJC2_S3_REST_API_MONGODB_PC_1.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, Integer> {

    @Query ("{'customerProduct.productName':{$in:[?0]}}")
    List<Customer> findAllCustomersByProductName (String productName);

}
