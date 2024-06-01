package com.example.demo.services;

import com.example.demo.dtos.PedidosResponse;
import com.example.demo.mappers.PedidoMapper;
import com.example.demo.models.Pedido;
import com.example.demo.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    PedidoMapper pedidoMapper;

    public PedidosResponse getPedidos(){
        return pedidoMapper.ListPedidosToPedidosResponse(pedidoRepository.findAll());
    }

    public Optional<Pedido> getById(Long id){
        return (Optional<Pedido>) pedidoRepository.findById(id);
    }

    public ResponseEntity savePedido(Pedido pedido){
        pedidoRepository.save(pedido);
        return ResponseEntity.ok("Registro guardado");
    }

    public ResponseEntity updateById(Pedido request, Long id){
        Pedido pedido = pedidoRepository.findById(id).get();
        pedido.setCliente(request.getCliente());
        pedido.setDetallePedido(request.getDetallePedido());
        pedido.setFecha(request.getFecha());
        savePedido(pedido);
        return ResponseEntity.ok("Registro actualizado");

    }

    public boolean deletePedidoById(Long id){
        try{
            pedidoRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
