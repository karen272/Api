package com.example.demo.controllers;

import com.example.demo.dtos.ProductosResponse;
import com.example.demo.models.Producto;
import com.example.demo.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping("/getAll")
    public ProductosResponse getProductos(){
        return productoService.getProductos();
    }

    @PostMapping("/new")
    public ResponseEntity saveProducto(@RequestBody Producto producto){
        productoService.saveProducto(producto);
        return ResponseEntity.ok("Registro guardado");
    }
    @GetMapping("/{id}")
    public Optional<Producto> getProductoById(@PathVariable("id") Long id){
        return productoService.getById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateProductoById(@PathVariable("id") Long id, @RequestBody Producto request ){
        productoService.updateById(request, id);
        return ResponseEntity.ok("Registro actualizado");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProductoById(@PathVariable("id") Long id){
        try {
            productoService.deleteProductoById(id);
            return ResponseEntity.ok("Registro eliminado");
        }

        catch(Exception ex) {
            return ResponseEntity.badRequest().body("No se pudo eliminar el registro. ");
        }
    }


}
