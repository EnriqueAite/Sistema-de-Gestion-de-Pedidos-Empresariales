package com.sigep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sigep.model.MovimientoStock;
import com.sigep.model.Producto;
import com.sigep.repository.IMovimientoStockRepository;
import com.sigep.repository.IProductoRepository;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoStockController {

    @Autowired
    private IMovimientoStockRepository repoMov;

    @Autowired
    private IProductoRepository repoProd;

    @GetMapping
    public List<MovimientoStock> listar() {
        return repoMov.findAll();
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody MovimientoStock movimiento) {
        Producto p = repoProd.findById(movimiento.getId_producto()).orElse(null);
        if (p == null) return ResponseEntity.badRequest().body("Producto no encontrado");

        movimiento.setFecha(new Date());

        if (movimiento.getTipo().equals("ENTRADA")) {
            p.setStock(p.getStock() + movimiento.getCantidad());
        } else if (movimiento.getTipo().equals("SALIDA")) {
            if (p.getStock() < movimiento.getCantidad())
                return ResponseEntity.badRequest().body("Stock insuficiente");
            p.setStock(p.getStock() - movimiento.getCantidad());
        }

        repoProd.save(p);
        return ResponseEntity.ok(repoMov.save(movimiento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (!repoMov.existsById(id)) return ResponseEntity.notFound().build();
        repoMov.deleteById(id);
        return ResponseEntity.ok().build();
    }
}