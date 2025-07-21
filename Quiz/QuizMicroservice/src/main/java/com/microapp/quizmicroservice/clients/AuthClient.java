package com.microapp.quizmicroservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "auth-microservice", url = "http://localhost:8081/api")
public interface AuthClient {
    @GetMapping("/auth/validateToken")
    boolean validateToken(@RequestParam("token") String token);

    @GetMapping("/auth/test")
    String auth();
}
