package me.john.amiscaray.springwebsocketdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexViewController {

    @RequestMapping(path = "/")
    public String index() {
        return "index.html";
    }
}
