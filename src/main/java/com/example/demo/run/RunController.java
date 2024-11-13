package com.example.demo.run;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RunController {

    // @RequestMapping("/") -> One way to create a request inside a class
    @GetMapping("/hello")
    String home(){
        return "Hello Runners";
    }
}
