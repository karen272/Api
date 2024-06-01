package com.example.demo.mappers;

import com.example.demo.dtos.DetallePedidoResponse;
import com.example.demo.dtos.DetallesPedidosResponse;
import com.example.demo.models.DetallePedido;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DetallePedidoMapper {
    public DetallesPedidosResponse ListDetallesPedidosToDetallesPedidosResponse(List<DetallePedido> detallesPedidos){
        DetallesPedidosResponse c = new DetallesPedidosResponse();
        List<DetallePedidoResponse> detallePedidoResponseList = new ArrayList<>();
        for (DetallePedido detallePedido:detallesPedidos) {
            detallePedidoResponseList.add(DetallePedidoToDetallePedidoResponse(detallePedido));

        }
        c.setDetallesPedidos(detallePedidoResponseList);
        return  c;
    }

    public DetallePedidoResponse DetallePedidoToDetallePedidoResponse(DetallePedido detallePedido){
        DetallePedidoResponse detallePedidoResponse = new DetallePedidoResponse();
        detallePedidoResponse.setCantidad(detallePedido.getCantidad());
        detallePedidoResponse.setPrecioFinal(detallePedido.getPrecioFinal());
        return  detallePedidoResponse;
    }

}
