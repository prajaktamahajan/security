package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "This is a public API. No authentication required here.";
    }

    @GetMapping("/secure")
    public String secureEndpoint() {
        return "This is a secure API. Authentication required.";
    }
}
