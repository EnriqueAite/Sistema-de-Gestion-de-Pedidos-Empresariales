package com.sigep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sigep.model.Producto;
import com.sigep.repository.IProductoRepository;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private IProductoRepository repoProd;

    @GetMapping
    public List<Producto> listar() {
        return repoProd.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscar(@PathVariable Integer id) {
        return repoProd.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Producto guardar(@RequestBody Producto producto) {
        return repoProd.save(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable Integer id, @RequestBody Producto producto) {
        if (!repoProd.existsById(id)) return ResponseEntity.notFound().build();
        producto.setId_producto(id);
        return ResponseEntity.ok(repoProd.save(producto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (!repoProd.existsById(id)) return ResponseEntity.notFound().build();
        repoProd.deleteById(id);
        return ResponseEntity.ok().build();
    }
}