package com.cs411.solar_project.service;

import com.cs411.solar_project.model.Company;
import com.cs411.solar_project.model.Order;
import com.cs411.solar_project.model.User;
import com.cs411.solar_project.repository.CompanyRepository;
import com.cs411.solar_project.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private CompanyRepository companyRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, CompanyRepository companyRepository) {
        this.orderRepository = orderRepository;
        this.companyRepository = companyRepository;
    }
//    public Company getCompany(List<Company> companyID) {
//        return companyRepository.findByCompanyID(companyID);
//    }

    public List<Order> listByGuest(String username){
        return orderRepository.findByGuest(new User.Builder().setUsername(username).build());
    }

    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    public void addCompanies(Company company) {
        companyRepository.save(company);
    }

//  @Transactional(isolation = Isolation.SERIALIZABLE)
//  public void deleteOrder(Long orderId) throws OrderNotExistException {
//    Order order = orderRepository.findById(orderId);
//    if (order == null) {
//      throw new OrderNotExistException("Order doesn't exist");
//    }
//    orderRepository.deleteById(orderId);
//  }
}