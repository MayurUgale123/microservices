package com.microservice.communication.orderservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class OrderService {

    private final WebClient webClient;

    public OrderService(WebClient webClient) {
        this.webClient = webClient;
    }

    public void postOrder() {


 /*     // Blocking call
        Map<String,String> result = new HashMap<>();
        result = webClient.get()
                .uri("http://localhost:8082/api/inventory/all")
                .retrieve()
                .bodyToMono(Map.class)
        .block();
*/
        Map<String,String> map = new HashMap<>();
        webClient.get()
                .uri("http://localhost:8082/api/inventory/all")
                .retrieve()
                .bodyToMono(Map.class)
                .subscribe(m->m.putAll(map));

        System.out.println("response from Inventory service");
        map.forEach((k,v)-> System.out.println(k+""+v));
        System.out.println("order placed");
    }
}
