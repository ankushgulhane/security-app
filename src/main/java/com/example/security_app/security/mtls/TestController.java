package com.example.security_app.security.mtls;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {



    @GetMapping("/mtls/hi")
    public ResponseEntity<String> callApi(){

        return new ResponseEntity(" Hi this is mTLS secure app", HttpStatusCode.valueOf(200));
    }
}
