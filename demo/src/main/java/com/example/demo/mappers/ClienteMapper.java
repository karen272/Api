package com.example.demo.mappers;

import com.example.demo.dtos.ClienteResponse;
import com.example.demo.dtos.ClientesResponse;
import com.example.demo.models.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteMapper {

    public ClientesResponse ListClientesToClienteResponse(List<Cliente> clientes){
        ClientesResponse c = new ClientesResponse();
        List<ClienteResponse>responseList = new ArrayList<>();
        for(Cliente cliente : clientes ){
            responseList.add(ClienteToClienteResponse(cliente));
        }
        c.setClientes(responseList);
        return c;
    }

    public ClienteResponse ClienteToClienteResponse(Cliente cliente){
        ClienteResponse response = new ClienteResponse();
        response.setNombre(cliente.getNombre());
        response.setDireccion(cliente.getDireccion());
        response.setDni(cliente.getDni());
        return response;
    }
}
