package com.brokkko.taskmanager.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class GreetingController {
    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hello from our api");

    }

    @GetMapping("/end")
    public ResponseEntity<String> sayBay() {
        return ResponseEntity.ok("goodbay");
    }
}
