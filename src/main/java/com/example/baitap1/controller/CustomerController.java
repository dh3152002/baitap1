package com.example.baitap1.controller;

import com.example.baitap1.entity.CustomerEntity;
import com.example.baitap1.payload.response.BaseResponse;
import com.example.baitap1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("")
    public ResponseEntity<?> insert(@RequestParam String name,@RequestParam String email){
        String message=customerService.insert(name,email);
        BaseResponse baseResponse=new BaseResponse();
        baseResponse.setMessage(message);

        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> findAll(){
        List<CustomerEntity> list=customerService.findAll();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        try {
            CustomerEntity customerEntity=customerService.findById(id);
            return new ResponseEntity<>(customerEntity,HttpStatus.OK);

        }catch (Exception e){
            throw new RuntimeException("Error findById customer: "+e.getMessage());
        }
    }
}
