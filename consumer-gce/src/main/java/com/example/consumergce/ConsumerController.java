package com.example.consumergce;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    LoadBalancerClient loadBalancerClient;


    public ConsumerController(RestTemplateBuilder builder, ObjectMapper objectMapper, LoadBalancerClient loadBalancerClient) {
        this.restTemplate = builder.build();
        this.objectMapper = objectMapper;
        this.loadBalancerClient = loadBalancerClient;
    }

    @GetMapping("/")
    public String getGreeting() {
        String greeting = this.restTemplate.getForObject(getUrl() + "/greeting", String.class);
        return "GEERTING TO GCE: \"" + greeting + "\"";

    }

    public String getUrl() {
        return this.loadBalancerClient.choose("hashiboot-producer-k8s-default").getUri().toString();
    }
}
