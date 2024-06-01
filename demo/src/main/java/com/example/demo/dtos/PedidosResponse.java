package com.example.demo.dtos;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class PedidosResponse {
    private List<PedidoResponse>pedidos;
}
