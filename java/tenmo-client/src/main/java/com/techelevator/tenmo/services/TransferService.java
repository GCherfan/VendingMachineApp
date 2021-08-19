package com.techelevator.tenmo.services;

import org.springframework.web.client.RestTemplate;

public class TransferService {
    private RestTemplate restTemplate = new RestTemplate();
    private final String BASE_URL;


    public TransferService(String base_url) {
        BASE_URL = base_url;
    }
}
