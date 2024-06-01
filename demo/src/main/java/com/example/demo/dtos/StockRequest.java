package com.example.demo.dtos;

import com.example.demo.models.Producto;
import lombok.Data;

import java.util.List;

@Data
public class StockRequest {
    private Long id;
    private List<ProductoRequest> productos;
    private int cantidad;
}
