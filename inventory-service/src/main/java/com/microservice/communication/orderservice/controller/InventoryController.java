package com.microservice.communication.orderservice.controller;

import com.microservice.communication.orderservice.service.Inventoryservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private Inventoryservice inventoryservice;

    @GetMapping("/all")
    public Map getInventory() {
        return inventoryservice.getInventory();
    }

}
