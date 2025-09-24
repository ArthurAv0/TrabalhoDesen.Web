package com.example.demo.service;

import com.example.demo.entity.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
//a
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAllClientes(){
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findClienteById(Long id){
        return clienteRepository.findById(id);
    }

    public Cliente saveCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public void deleteCliente(Long id){
        clienteRepository.deleteById(id);
    }

    public Cliente updateCliente(Long id, Cliente updateCliente){
        return clienteRepository.findById(id)
                .map(cliente -> {
                    cliente.setNome(updateCliente.getNome());
                    cliente.setEmail(updateCliente.getEmail());
                    cliente.setDataNascimento(updateCliente.getDataNascimento());
                    cliente.setSenha(updateCliente.getSenha());
                    return clienteRepository.save(cliente);
                }).orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
    }
    public List<Cliente> findAllCliente() {
        return clienteRepository.findAll()
                .stream()
                .toList();
    }


}