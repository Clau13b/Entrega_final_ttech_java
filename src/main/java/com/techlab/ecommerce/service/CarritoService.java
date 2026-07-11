package com.techlab.ecommerce.service;

import com.techlab.ecommerce.model.Carrito;
import com.techlab.ecommerce.model.Producto;
import com.techlab.ecommerce.repository.CarritoRepository;
import org.springframework.stereotype.Service;

@Service
public class CarritoService {

    private final CarritoRepository carritoRepository;
    private final ProductoService productoService;

    public CarritoService(CarritoRepository carritoRepository, ProductoService productoService) {
        this.carritoRepository = carritoRepository;
        this.productoService = productoService;
    }

    public Carrito crear() {
        return carritoRepository.save(new Carrito());
    }

    public Carrito obtenerPorId(Long id) {
        return carritoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado"));
    }

    public Carrito agregar(Long carritoId, Long productoId) {
        Carrito carrito = carritoRepository.findById(carritoId)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado"));
        Producto producto = productoService.obtenerPorId(productoId);
        
        if (producto.getStock() > 0) {
            producto.setStock(producto.getStock() - 1);
            productoService.guardar(producto);
            carrito.getProductos().add(producto);
            return carritoRepository.save(carrito);
        }
        throw new RuntimeException("Stock insuficiente");
    }

    public Carrito eliminar(Long carritoId, Long productoId) {
        Carrito carrito = carritoRepository.findById(carritoId)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado"));

        Producto prod = carrito.getProductos().stream()
                .filter(p -> p.getId().equals(productoId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Producto no en carrito"));
        
        carrito.getProductos().remove(prod);
        prod.setStock(prod.getStock() + 1);
        productoService.guardar(prod);
        return carritoRepository.save(carrito);
    }
}