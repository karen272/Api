package com.example.demo.services;

import com.example.demo.dtos.ClientesResponse;
import com.example.demo.mappers.ClienteMapper;
import com.example.demo.models.Cliente;
import com.example.demo.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ClienteMapper clienteMapper;
    public ClientesResponse getClientes(){
        return clienteMapper.ListClientesToClienteResponse(clienteRepository.findAll());
    }

    public Optional<Cliente> getById(Long id){
        return (Optional<Cliente>)clienteRepository.findById(id);
    }

    public ResponseEntity saveCliente(Cliente cliente){
        clienteRepository.save(cliente);
        return ResponseEntity.ok("Resgistro guardado :) ");
    }

    public ResponseEntity updateById(Cliente request, Long id){
        Cliente cliente = clienteRepository.findById(id).get();
        cliente.setNombre(request.getNombre());
        cliente.setDireccion(request.getDireccion());
        cliente.setDni(request.getDni());
        saveCliente(cliente);
        return ResponseEntity.ok("Registro actualizado :) ");
    }

    public boolean deleteClienteById(Long id){
        try{
            clienteRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }





}
