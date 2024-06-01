package com.example.demo.dtos;

import com.example.demo.models.Producto;
import lombok.Data;

import java.util.List;

@Data
public class DetallePedidoResponse {
    private Long id;
    private List<ProductoResponse>productos;
    private int cantidad;
    private Float precioFinal;
}
