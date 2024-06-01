package com.example.demo.mappers;

import com.example.demo.dtos.PedidoResponse;
import com.example.demo.dtos.PedidosResponse;
import com.example.demo.models.Pedido;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoMapper {
    public PedidosResponse ListPedidosToPedidosResponse(List<Pedido> pedidos){
        PedidosResponse c = new PedidosResponse();
        List<PedidoResponse> pedidoResponseList = new ArrayList<>();
        for (Pedido pedido:pedidos) {

            pedidoResponseList.add(PedidoToPedidoResponse(pedido));
        }
        c.setPedidos(pedidoResponseList);
        return  c;
    }
    public PedidoResponse PedidoToPedidoResponse(Pedido pedido){
        PedidoResponse pedidoResponse = new PedidoResponse();
        pedidoResponse.setFecha(pedido.getFecha());
        return  pedidoResponse;
    }
}
