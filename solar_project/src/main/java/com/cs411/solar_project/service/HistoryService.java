package com.cs411.solar_project.service;


import com.cs411.solar_project.model.Order;
import com.cs411.solar_project.model.User;
import com.cs411.solar_project.repository.AuthorityRepository;
import com.cs411.solar_project.repository.CompanyRepository;
import com.cs411.solar_project.repository.OrderRepository;
import com.cs411.solar_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {
    private AuthorityRepository authorityRepository;
    private OrderRepository orderRepository;
    private CompanyRepository companyRepository;
    private UserRepository userRepository;

    @Autowired
    public HistoryService(AuthorityRepository authorityRepository,OrderRepository orderRepository, CompanyRepository companyRepository, UserRepository userRepository) {
        this.authorityRepository = authorityRepository;
        this.orderRepository = orderRepository;
        this.companyRepository = companyRepository;
        this.userRepository = userRepository;
    }

    public List<Order> listByUser(String username) {
        return orderRepository.findByGuest(new User.Builder().setUsername(username).build());
    }

//    public List<Order> listByAdmin(String username) {
//        return orderRepository.findAll();
//    }
}