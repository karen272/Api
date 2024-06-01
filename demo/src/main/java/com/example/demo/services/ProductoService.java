package com.example.demo.services;

import com.example.demo.dtos.ProductoResponse;
import com.example.demo.dtos.ProductosResponse;
import com.example.demo.mappers.ProductoMapper;
import com.example.demo.models.Cliente;
import com.example.demo.models.Producto;
import com.example.demo.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    ProductoMapper productoMapper;

    public ProductosResponse getProductos(){
        return productoMapper.ListProductosToProductosResponse(productoRepository.findAll());
    }


    public Optional<Producto> getById(Long id){
        return (Optional<Producto>)productoRepository.findById(id);
    }

    public ResponseEntity saveProducto(Producto producto){
        productoRepository.save(producto);
        return ResponseEntity.ok("Resgistro guardado :) ");
    }

    public ResponseEntity updateById(Producto request, Long id){
        Producto producto = productoRepository.findById(id).get();
        producto.setNombre(request.getNombre());
        producto.setPrecio(request.getPrecio());
        saveProducto(producto);
        return ResponseEntity.ok("Registro actualizado :) ");
    }

    public boolean deleteProductoById(Long id){
        try{
            productoRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }


}
