package com.example.producerk8s;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @GetMapping("/greeting")
    public String greeting() {
        return System.getenv("message");
    }
}
