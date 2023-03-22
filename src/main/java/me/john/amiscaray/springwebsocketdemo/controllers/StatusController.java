package me.john.amiscaray.springwebsocketdemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
    
    @GetMapping({"/status"})
    public String status() {
        return "Application status (OK)";
    }
}
