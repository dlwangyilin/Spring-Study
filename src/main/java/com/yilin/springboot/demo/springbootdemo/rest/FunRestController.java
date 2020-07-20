package com.yilin.springboot.demo.springbootdemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {

    // expose /
    @GetMapping("/")
    public String sayHello() {
        return "Hello word on " + LocalDateTime.now();
    }
}
