package com.example.springplayground.service;

import com.example.springplayground.entities.Customer;
import com.example.springplayground.repositories.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImplementation implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImplementation(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> get() {
        return customerRepository.findAll();
    }

    @Override
    public Customer get(int id) {
        return (customerRepository.findById(id).isEmpty()==false)?(customerRepository.findById(id).get()):null;
    }

    @Override
    public void create(Customer customer) {
        customerRepository.saveAndFlush(customer);
    }

    @Override
    public void update(int id, Customer customer) {
        Customer customer1=customerRepository.findById(id).get();
        BeanUtils.copyProperties(customer,customer1);
        customerRepository.saveAndFlush(customer1);
    }

    @Override
    public void delete(int id) {
        customerRepository.deleteById(id);
    }
}
