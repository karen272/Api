package com.example.demo.dtos;

import lombok.Data;

@Data
public class ClienteResponse {
    private long id;
    private String nombre;
    private String direccion;
    private int dni;
}
