package com.example.demo.dtos;

import lombok.Data;

@Data
public class ProductoRequest {
    private Long id;
    private String nombre;
    private Float precio;
}
