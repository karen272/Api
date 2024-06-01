package com.example.demo.controllers;

import com.example.demo.dtos.ClienteRequest;
import com.example.demo.dtos.ClientesResponse;
import com.example.demo.models.Cliente;
import com.example.demo.services.ClienteService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping ("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/getAll")
    public ClientesResponse getClientes(){
        return clienteService.getClientes();
    }

    @PostMapping("/new")
    public ResponseEntity saveCliente(@RequestBody Cliente cliente){
        return clienteService.saveCliente(cliente);
    }

    @GetMapping("/{id}")
    public Optional<Cliente> getClienteById(@PathVariable("id") Long id){
        return clienteService.getById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateClienteById(@PathVariable("id") Long id,@RequestBody Cliente request){
        return clienteService.updateById(request, id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteClienteById(@PathVariable("id") Long id){
        try {
            clienteService.deleteClienteById(id);
            return ResponseEntity.ok("Registro eliminado :) ");
        }catch (Exception ex){
            return ResponseEntity.badRequest().body("No se pudo eliminar el registro. El error es: "+ ex.getMessage());
        }
    }




}
