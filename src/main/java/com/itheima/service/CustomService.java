package com.itheima.service;

import com.itheima.domain.Customer;

import java.util.List;

public interface CustomService {
    List<Customer> findAll();

    Customer findById(int custId);

    void update(Customer customer);

    int findCount();

    void save(Customer customer, int total);
}
