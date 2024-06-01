package com.example.demo.dtos;

import com.example.demo.models.Producto;
import lombok.Data;

import java.util.List;

@Data
public class StockResponse {
    private Long id;
    private List<Producto> productos;
    private int cantidad;
}
