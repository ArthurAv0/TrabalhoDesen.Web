package com.example.demo.controller;

import com.example.demo.entity.Cliente;
import com.example.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("aluno")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    private List<Cliente> buscarCliente(){
        return clienteService.findAllCliente();
    }

    @GetMapping("/{id}")
    private ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long id){
        return clienteService.findClienteById(id)
                .map(cliente -> new ResponseEntity<>(cliente, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    private Cliente criarCliente(@RequestBody Cliente cliente){
        return clienteService.saveCliente(cliente);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> excluirCliente(@PathVariable Long id){
        clienteService.deleteCliente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    private Cliente atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente){
        return clienteService.updateCliente(id, cliente);
    }

}