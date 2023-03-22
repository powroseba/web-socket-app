package me.john.amiscaray.springwebsocketdemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/status")
public class StatusController {

    @GetMapping
    public String status() {
        return "Application status (OK)";
    }
}
