package com.cs411.solar_project.controller;

import com.cs411.solar_project.model.Order;
import com.cs411.solar_project.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class HistoryController {
    private HistoryService historyService;

    @Autowired
    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;

    }
    @GetMapping(value = "/history/guest")
    public List<Order> listOrdersUser(Principal principal) {
        return historyService.listByUser(principal.getName());
    }


}