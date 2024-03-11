package com.nt.mapper;

import com.nt.hash.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {

    public Integer addCustomer(Customer customer);

    public Customer getCustomerById(@Param("cid") Integer cid);

    public int deleteCustomer(@Param("cid") Integer cid);


    public List<Customer> getAllCustomer();
}
