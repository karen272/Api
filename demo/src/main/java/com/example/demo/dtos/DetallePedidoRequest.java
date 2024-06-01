package com.example.demo.dtos;

import com.example.demo.models.Producto;
import lombok.Data;

import java.util.List;

@Data
public class DetallePedidoRequest {
    private Long id;
    private List<ProductoRequest>productos;
    private int cantidad;
    private Float precioFinal;
}
