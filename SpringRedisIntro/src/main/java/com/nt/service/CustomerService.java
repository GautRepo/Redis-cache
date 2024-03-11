package com.nt.service;

import com.nt.config.RedisConfig;
import com.nt.hash.Customer;
import com.nt.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService {

    @Autowired
    private RedisTemplate template;

    @Autowired
    private CustomerMapper mapper;


    public Customer addCustomer(Customer customer){
        template.opsForHash().put("Customer",customer.getCid(),customer);
        mapper.addCustomer(customer);
        return customer;
    }

    public Customer getCustomerById(Integer id){
        return (Customer) template.opsForHash().get("Customer",id);
    }

    public List<Customer> getAllCustomer(){
        return template.opsForHash().values("Customer");
    }

    public String deleteCustomer(int cid){
        template.opsForHash().delete("Customer",cid);
        int count =mapper.deleteCustomer(cid);
        return count +" record has been deleted with "+cid+" id ";
    }

    public List<Customer> refreshCache(){
       template.getConnectionFactory().getConnection().flushAll();
       mapper.getAllCustomer().parallelStream().forEach(c -> template.opsForHash().put("Customer",c.getCid(),c));

       return template.opsForHash().values("Customer");

    }


}
