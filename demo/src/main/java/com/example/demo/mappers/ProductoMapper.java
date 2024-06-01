package com.example.demo.mappers;

import com.example.demo.dtos.ProductoResponse;
import com.example.demo.dtos.ProductosResponse;
import com.example.demo.models.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoMapper {

    public ProductosResponse ListProductosToProductosResponse(List<Producto>productos){
        ProductosResponse c = new ProductosResponse();
        List<ProductoResponse> responseList = new ArrayList<>();
        for (Producto producto : productos){
            responseList.add(ProductoToProductoResponse(producto));

        }
        c.setProductos(responseList);
        return c;
    }
    public ProductoResponse ProductoToProductoResponse (Producto producto){
        ProductoResponse response = new ProductoResponse();
        response.setNombre(producto.getNombre());
        response.setPrecio(producto.getPrecio());
        return response;
    }

}
