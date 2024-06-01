package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name= "client")
@Data

public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<Producto>productos;

    @Column
    private int cantidad;

    @Column
    private Float precioFinal;
}
