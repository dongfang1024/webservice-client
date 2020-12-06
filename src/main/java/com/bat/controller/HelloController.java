package com.bat.controller;

import com.bat.client.DemoServiceClient;
import com.bat.wsdl.SayHelloResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class HelloController {

    @Autowired
    private DemoServiceClient client;

    @GetMapping("hello")
    public ResponseEntity<String> testHello(){
        return ResponseEntity.ok("Hello, world.");
    }


    @GetMapping("sth")
    public ResponseEntity<String> saySth(String name){
        SayHelloResponse response = this.client.response();
        System.out.println(response.getReturn());
        return ResponseEntity.ok("Test");


    }

}
