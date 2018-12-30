package com.itheima.service.Impl;

import com.itheima.dao.CustomDao;
import com.itheima.domain.Customer;
import com.itheima.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomServiceImpl implements CustomService {
    @Autowired
    private CustomDao customDao;

    @Override
    public List<Customer> findAll() {
        List<Customer> list = customDao.findAll();
        return list;
    }

    /**
     * 根据id查找客户
     * @return
     * @param custId
     */
    @Override
    public Customer findById(int custId) {
        Customer customer=customDao.findById(custId);
        return customer;
    }

    @Override
    public void update(Customer customer) {
        customDao.update(customer);
    }

    @Override
    public int findCount() {
        int total=customDao.findCount();
        return total;
    }

    @Override
    public void save(Customer customer, int total) {
        customer.setCustId(total+1L);
        customDao.save(customer);
    }
}
