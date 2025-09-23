package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cliente-demo")
public class DemoController {

    @GetMapping("/hello")
    public String helloCliente() {
        return "Olá, sou o cliente!";
    }

    @GetMapping("/bye")
    public String byeCliente() {
        return "Tchau cliente, até logo!";
    }
}
