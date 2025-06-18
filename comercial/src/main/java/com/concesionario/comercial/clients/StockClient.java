package com.concesionario.comercial.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "stock")
public interface StockClient {
    @GetMapping("/")
    ResponseEntity<String> helloWorld();
}
