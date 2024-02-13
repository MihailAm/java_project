package ru.mihail.spring.ispi.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/app")
public class UsersController {

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome you the Hospital";
    }

    @GetMapping("/doctor")
    public String doctor(){
        return "You doctor";
    }

    @GetMapping("/admin")
    public String admin(){
        return "You admin";
    }

    @GetMapping("/patient")
    public String patient(){
        return "You patient";
    }
}
