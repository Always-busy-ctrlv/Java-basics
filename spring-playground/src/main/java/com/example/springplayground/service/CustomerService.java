package com.example.springplayground.service;

import com.example.springplayground.entities.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> get();
    Customer get(int id);
    void create(Customer customer);
    void update(int id, Customer customer);
    void delete(int id);
}
