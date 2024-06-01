package com.example.demo.services;

import com.example.demo.dtos.DetallesPedidosResponse;
import com.example.demo.mappers.DetallePedidoMapper;
import com.example.demo.models.DetallePedido;
import com.example.demo.repositories.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DetallePedidoService {
    @Autowired
    DetallePedidoRepository detallePedidoRepository;

    @Autowired
    DetallePedidoMapper detallePedidoMapper;

    public DetallesPedidosResponse getDetallesPedidos(){
        return detallePedidoMapper.ListDetallesPedidosToDetallesPedidosResponse(detallePedidoRepository.findAll());
    }

    public Optional<DetallePedido> getById(Long id){
        return (Optional<DetallePedido>) detallePedidoRepository.findById(id);
    }

    public ResponseEntity saveDetallePedido(DetallePedido detallePedido){
        detallePedidoRepository.save(detallePedido);
        return ResponseEntity.ok("Registro guardado");
    }

    public ResponseEntity updateById(DetallePedido request, Long id){
        DetallePedido detallePedido = detallePedidoRepository.findById(id).get();
        detallePedido.setProductos(request.getProductos());
        detallePedido.setCantidad(request.getCantidad());
        detallePedido.setPrecioFinal(request.getPrecioFinal());
        saveDetallePedido(detallePedido);
        return ResponseEntity.ok("Registro actualizado");

    }

    public boolean deleteDetallePedidoById(Long id){
        try{
            detallePedidoRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
