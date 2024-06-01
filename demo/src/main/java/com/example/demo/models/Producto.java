package com.example.demo.models;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name="product")
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private Float precio;
}
