package com.example.demo.dtos;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ClienteRequest {
    private long id;
    private String nombre;
    private String direccion;
    private int dni;

}
