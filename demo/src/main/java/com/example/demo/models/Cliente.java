package com.example.demo.models;



import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name= "client")
@Data

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;

    @Column
    private String direccion;

    @Column
    private int dni;


}
