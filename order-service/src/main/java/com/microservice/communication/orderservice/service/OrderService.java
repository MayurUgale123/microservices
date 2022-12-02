package com.microservice.communication.orderservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class OrderService {

    private final WebClient webClient;

    public OrderService(WebClient webClient) {
        this.webClient = webClient;
    }

    public void postOrder() {
        Map<String,String> result = webClient.get()
                .uri("http://localhost:8082/api/inventory/all")
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        System.out.println("response from Inventory service");
        result.forEach((k,v) -> System.out.println(k + " : " + v));

        System.out.println("order placed");
    }
}
