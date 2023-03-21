package me.john.amiscaray.springwebsocketdemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @GetMapping(value = {"/", "/home", "/status"})
    public String getStatus() {
        return "Application status : up";
    }
}
