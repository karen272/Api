package com.example.demo.dtos;

import com.example.demo.models.Cliente;
import lombok.Data;

import java.util.Date;

@Data
public class PedidoRequest {
    private Long id;
    private ClienteRequest cliente;
    private DetallePedidoRequest detallePedido;
    private Date fecha;
}
