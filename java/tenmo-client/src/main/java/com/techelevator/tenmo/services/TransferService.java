package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import org.openqa.selenium.remote.Response;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;


public class TransferService {
        private RestTemplate restTemplate = new RestTemplate();
        private final String BASE_URL;


        public TransferService(String base_url) {
            BASE_URL = base_url;
        }

       public User[] listOfUsers(String token){
            //List<User> userList = new ArrayList<User>();
           HttpHeaders httpHeaders = new HttpHeaders();
           httpHeaders.setBearerAuth(token);
           HttpEntity entity = new HttpEntity(httpHeaders);
           ResponseEntity<User[]> userList = restTemplate.exchange(BASE_URL + "/users",
                   HttpMethod.GET, entity, User[].class);
           return userList.getBody();
        }

        public void createTransfer(Transfer transfer, String token){
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setBearerAuth(token);
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Transfer> entity = new HttpEntity(transfer, httpHeaders);
            restTemplate.postForObject(BASE_URL + "/transfers", entity, Transfer.class);
        }

        public Transfer[] transferHistory(Transfer transfer, String token){
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setBearerAuth(token);
            HttpEntity entity = new HttpEntity(transfer, httpHeaders);
            ResponseEntity<Transfer[]> transferList = restTemplate.exchange(BASE_URL + "/transfers/history",
                    HttpMethod.GET, entity, Transfer[].class);
            return transferList.getBody();
        }

        public Transfer getDetailsByTransferId(String token, Long transferId){
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setBearerAuth(token);
            HttpEntity entity = new HttpEntity(httpHeaders);
            ResponseEntity<Transfer> transferDetail = restTemplate.exchange(BASE_URL + "/transfers/history/" + transferId, HttpMethod.GET,
                    entity, Transfer.class);
            return  transferDetail.getBody();
        }
}
