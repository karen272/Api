package com.example.demo.dtos;

import lombok.Data;

@Data
public class ProductoResponse {
    private Long id;
    private String nombre;
    private Float precio;
}
