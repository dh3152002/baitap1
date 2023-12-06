package com.example.baitap1.service;

import com.example.baitap1.entity.CustomerEntity;
import com.example.baitap1.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerEntity findByEmail(String email){
        return customerRepository.findByEmail(email);
    }

    public String insert(String name,String email){
        String message="";

        boolean isSuccess=findByEmail(email)!=null;

        if(!isSuccess){
            CustomerEntity customer=new CustomerEntity();
            customer.setEmail(email);
            customer.setName(name);

            customerRepository.save(customer);
            message="Thêm thành công";
        }else{
            message="Tồn tại email";
        }
        return message;
    }

    public List<CustomerEntity> findAll(){
        return customerRepository.findAll();
    }

    public CustomerEntity findById(int id){
        CustomerEntity customerEntity=new CustomerEntity();
        Optional<CustomerEntity> optional=customerRepository.findById(id);
        optional.ifPresent(existingCustomer -> {
            customerEntity.setId(id);
            customerEntity.setName(existingCustomer.getName());
            customerEntity.setEmail(existingCustomer.getEmail());
        });
        return customerEntity;
    }
}
