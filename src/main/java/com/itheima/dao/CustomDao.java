package com.itheima.dao;

import com.itheima.domain.Customer;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CustomDao {
    @Select("select * from cst_customer")
    @Results({
            @Result(id =true,property = "custId",column = "cust_id"),
            @Result(property = "custName",column = "cust_name"),
            @Result(property = "custIndustry",column = "cust_industry"),
            @Result(property = "custAddress",column = "cust_address"),
            @Result(property = "custPhone",column = "cust_phone"),
            @Result(property = "custLevel",column = "cust_level"),
            @Result(property = "custSource",column = "cust_source")
    })
    List<Customer> findAll();
    @Select("select * from cst_customer where cust_id=#{custId}")
    @Results({
            @Result(id =true,property = "custId",column = "cust_id"),
            @Result(property = "custName",column = "cust_name"),
            @Result(property = "custIndustry",column = "cust_industry"),
            @Result(property = "custAddress",column = "cust_address"),
            @Result(property = "custPhone",column = "cust_phone"),
            @Result(property = "custLevel",column = "cust_level"),
            @Result(property = "custSource",column = "cust_source")
    })
    Customer findById(int custId);
    @Update("update cst_customer set cust_name=#{custName},cust_industry=#{custIndustry}," +
            "cust_address=#{custAddress},cust_phone=#{custPhone}, cust_level=#{custLevel},cust_source=#{custSource} where cust_id=#{custId}")
    @Results({
            @Result(id =true,property = "custId",column = "cust_id"),
            @Result(property = "custName",column = "cust_name"),
            @Result(property = "custIndustry",column = "cust_industry"),
            @Result(property = "custAddress",column = "cust_address"),
            @Result(property = "custPhone",column = "cust_phone"),
            @Result(property = "custLevel",column = "cust_level"),
            @Result(property = "custSource",column = "cust_source")
    })
    void update(Customer customer);
    @Select("select count(1) from cst_customer")
    int findCount();
    @Insert("insert into cst_customer values(#{custId},#{custName}" +
            ",#{custSource},#{custIndustry},#{custLevel},#{custAddress},#{custPhone})")
    @Results({
            @Result(id =true,property = "custId",column = "cust_id"),
            @Result(property = "custName",column = "cust_name"),
            @Result(property = "custIndustry",column = "cust_industry"),
            @Result(property = "custAddress",column = "cust_address"),
            @Result(property = "custPhone",column = "cust_phone"),
            @Result(property = "custLevel",column = "cust_level"),
            @Result(property = "custSource",column = "cust_source")
    })
    void save(Customer customer);
}
