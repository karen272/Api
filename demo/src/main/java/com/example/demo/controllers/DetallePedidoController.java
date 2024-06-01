package com.example.demo.controllers;

import com.example.demo.dtos.DetallesPedidosResponse;
import com.example.demo.models.DetallePedido;
import com.example.demo.services.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/detallePedido")
public class DetallePedidoController {
    @Autowired
    private DetallePedidoService detallePedidoService;

    @GetMapping("/getAll")
    public DetallesPedidosResponse getDetallesPedidos(){
        return detallePedidoService.getDetallesPedidos();
    }

    @PostMapping("/new")
    public ResponseEntity saveDetallePedido(@RequestBody DetallePedido detallePedido){
        return this.detallePedidoService.saveDetallePedido(detallePedido);
    }
    @GetMapping("{id}")
    public Optional<DetallePedido> getDetallePedidoById(@PathVariable("id") Long id){
        return detallePedidoService.getById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateDetallePedidoById(@PathVariable("id") Long id, @RequestBody DetallePedido request ){
        return detallePedidoService.updateById(request, id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDetallePedidoById(@PathVariable("id") Long id){
        boolean ok = detallePedidoService.deleteDetallePedidoById(id);
        if (ok){
            return ResponseEntity.ok("Registro eliminado");
        }else{
            return ResponseEntity.badRequest().body("No se pudo eliminar el registro.");
        }
    }
}
