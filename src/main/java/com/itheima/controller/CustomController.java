package com.itheima.controller;

import com.itheima.domain.Customer;
import com.itheima.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 客户模块
 */
@Controller
@RequestMapping("/customer")
public class CustomController {
    @Autowired
    private CustomService customService;

    /**
     * 查询所有
     * @param model
     * @return
     */
    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<Customer> list = customService.findAll();

        model.addAttribute("customers", list);
        return "list";
    }

    /**
     * 跳转添加页面
     * @return
     */
    @RequestMapping("/addUI")
    public String addUI() {
        return "add";
    }

    /**
     * 添加客户
     * @param customer
     * @return
     */
    @RequestMapping("/addCustomer")
    public String addCustomer(Customer customer) {
        //先查询总数，获得主键加1
        int total=customService.findCount();
        customService.save(customer,total);
        return "redirect:/customer/findAll";
    }

    /**
     * 更新页的数据回显
     * @param model
     * @param custId
     * @return
     */
    @RequestMapping("/findById")
    public String findById(Model model,int custId) {
        Customer customer = customService.findById(custId);
        model.addAttribute("customer", customer);
        return "edit";
    }

    /**
     * 更新客户
     * @param customer
     * @return
     */
    @RequestMapping("/update")
    public String update(Customer customer) {
        customService.update(customer);
        return "redirect:/customer/findAll";
    }
}
