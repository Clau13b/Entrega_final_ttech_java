package com.techlab.ecommerce.service;

import com.techlab.ecommerce.model.Producto;
import com.techlab.ecommerce.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    public Producto guardar(Producto producto) {
        if (producto.getCategoria() == null) {
            throw new RuntimeException("El producto debe tener una categoría asignada.");
        }
        return productoRepository.save(producto);
    }
}