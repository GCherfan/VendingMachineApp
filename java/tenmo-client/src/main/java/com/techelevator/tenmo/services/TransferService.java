package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


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
}
