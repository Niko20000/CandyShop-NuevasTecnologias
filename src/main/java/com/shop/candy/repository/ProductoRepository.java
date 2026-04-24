
package com.shop.candy.repository;

import com.shop.candy.models.Producto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepository {

    private List<Producto> productos = new ArrayList<>();

    public void cargarCSV(String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {

            String linea;
            br.readLine(); 

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                Producto p = new Producto();
                p.setId(datos[0]);
                p.setNombre(datos[1]);
                p.setPrecio(datos[2]);

                productos.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Producto> obtenerTodos() {
        return productos;
    }

    public List<Producto> buscarPorNombre(String nombre) {
        List<Producto> resultado = new ArrayList<>();

        for (Producto p : productos) {
            if (p.getNombre() != null &&
                p.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                resultado.add(p);
            }
        }

        return resultado;
    }
}