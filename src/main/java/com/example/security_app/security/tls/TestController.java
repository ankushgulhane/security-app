package com.example.security_app.security.tls;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {



    @GetMapping("/tls/hi")
    public ResponseEntity<String> callApi(){

        return new ResponseEntity(" Hi this is TLS secure app", HttpStatusCode.valueOf(200));
    }
}
