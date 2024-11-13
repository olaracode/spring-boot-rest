package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class WelcomeMessage {
    public String getWelComeMessage(){
        return "Welcome to the sprint boot application";
    }
}
