package com.cs411.solar_project.controller;

import com.cs411.solar_project.model.Company;
import com.cs411.solar_project.model.Order;
import com.cs411.solar_project.model.User;
import com.cs411.solar_project.repository.OrderRepository;
import com.cs411.solar_project.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class OrderController {
    private OrderService orderService;
    private OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderService orderService, OrderRepository orderRepository) {
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

//    @GetMapping(value = "/order")
//    public List<Order> listOrders(Principal principal){
//        return orderService.listByGuest(principal.getName());
//    }

//    @GetMapping(value = "/order/{orderID}")
//    public Order getOrder(@PathVariable String userName) {
//        return orderService.listByGuest(userName);
//    }

    @PostMapping("/order")
    public void addOrder(@RequestBody Order order, Principal principal){
//        List<Company> company = order.getCompanies();
//        for(Company c : company){
//            c.setCompanyID(c.getCompanyID());
//            c.setOrderID(order);
//            orderService.addCompanies(c);
//        }
//        for(Company c : company){
//            c.setOrderID(order);
//            orderService.addCompanies(c);
//        }
//
        order.setGuest(new User.Builder().setUsername(principal.getName()).build());
//        order.setCompanies(company);
        orderService.addOrder(order);
    }
}
