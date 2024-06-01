package com.example.demo.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class PedidoResponse {
    private Long id;
    private ClienteResponse cliente;
    private DetallePedidoResponse detallePedido;
    private Date fecha;
}
