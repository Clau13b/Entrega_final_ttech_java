package com.techlab.ecommerce.controller;

import com.techlab.ecommerce.model.Carrito;
import com.techlab.ecommerce.service.CarritoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carritos")
@CrossOrigin(origins = "*") // Soluciona bloqueos de seguridad del navegador
public class CarritoController {

    private final CarritoService service;

    public CarritoController(CarritoService service) {
        this.service = service;
    }

    // NUEVO: Método necesario para que el navegador pueda obtener los datos
    @GetMapping("/{id}")
    public ResponseEntity<Carrito> obtenerCarrito(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Carrito> crear() {
        return ResponseEntity.ok(service.crear());
    }

    @PostMapping("/{carritoId}/productos/{productoId}")
    public ResponseEntity<Carrito> agregar(@PathVariable Long carritoId, @PathVariable Long productoId) {
        return ResponseEntity.ok(service.agregar(carritoId, productoId));
    }

    @DeleteMapping("/{carritoId}/productos/{productoId}")
    public ResponseEntity<Carrito> eliminar(@PathVariable Long carritoId, @PathVariable Long productoId) {
        return ResponseEntity.ok(service.eliminar(carritoId, productoId));
    }
}