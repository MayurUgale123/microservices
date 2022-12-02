package com.microservice.communication.orderservice.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Inventoryservice {

    private static Map<String, String> products = new HashMap<>();
    static {
        products.put("laptop","7");
    }

    public Map getInventory() {
        return products;
    }
}
