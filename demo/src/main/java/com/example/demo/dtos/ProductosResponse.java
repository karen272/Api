package com.example.demo.dtos;

import lombok.Data;

import java.util.List;

@Data
public class ProductosResponse {
    private List<ProductoResponse> productos;
}