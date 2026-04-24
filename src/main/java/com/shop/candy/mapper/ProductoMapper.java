// mapper/ProductoMapper.java
package com.shop.candy.mapper;

import com.shop.candy.models.Producto;
import com.shop.candy.dto.ProductoDTO;

public class ProductoMapper {

    public static ProductoDTO toDTO(Producto p) {
        double precio = Double.parseDouble(
            p.getPrecio().replace("$", "").trim()
        );

        String nombre = p.getNombre().toLowerCase().trim();

        return new ProductoDTO(nombre, precio);

        
    }
}