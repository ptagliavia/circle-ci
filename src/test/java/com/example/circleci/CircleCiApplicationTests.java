package com.example.circleci;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CircleCiApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate template;


    @Test
    void contextLoads() {
    }


    @Test
    public void homeTest() {
        //create request for local host
        String url = "http://localhost:" +port + "/api/v1/home";

        HttpEntity request = new HttpEntity(new HttpHeaders());

        ResponseEntity<String> response = template.exchange(url, HttpMethod.GET, request, String.class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), "Hello, world!");
    }
}
