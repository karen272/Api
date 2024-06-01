package com.example.demo.controllers;

import com.example.demo.dtos.PedidosResponse;
import com.example.demo.models.Pedido;
import com.example.demo.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pedido")
public class PedidoControlller {
    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private PedidosResponse pedidosResponse;

    @GetMapping("/getAll")
    public PedidosResponse getPedidos(){
        return pedidoService.getPedidos();
    }

    @PostMapping("/new")
    public ResponseEntity savePedido(@RequestBody Pedido pedido){
        return this.pedidoService.savePedido(pedido);
    }
    @GetMapping("{id}")
    public Optional<Pedido> getPedidoById(@PathVariable("id") Long id){
        return pedidoService.getById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updatePedidoById(@PathVariable("id") Long id, @RequestBody Pedido request ){
        return pedidoService.updateById(request, id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePedidoById(@PathVariable("id") Long id){
        boolean ok = pedidoService.deletePedidoById(id);
        if (ok){
            return ResponseEntity.ok("Registro eliminado");
        }else{
            return ResponseEntity.badRequest().body("No se pudo eliminar el registro.");
        }
    }


}
