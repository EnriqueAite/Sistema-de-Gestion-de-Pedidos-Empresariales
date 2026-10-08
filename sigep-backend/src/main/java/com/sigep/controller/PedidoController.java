package com.sigep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sigep.model.Pedido;
import com.sigep.repository.IPedidoRepository;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private IPedidoRepository repoPed;

    @GetMapping
    public List<Pedido> listar() {
        return repoPed.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscar(@PathVariable Integer id) {
        return repoPed.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pedido guardar(@RequestBody Pedido pedido) {
        pedido.setFecha_pedido(new Date());
        pedido.setEstado("EN ESPERA");
        return repoPed.save(pedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> actualizar(@PathVariable Integer id, @RequestBody Pedido pedido) {
        if (!repoPed.existsById(id)) return ResponseEntity.notFound().build();
        pedido.setId_pedido(id);
        return ResponseEntity.ok(repoPed.save(pedido));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (!repoPed.existsById(id)) return ResponseEntity.notFound().build();
        repoPed.deleteById(id);
        return ResponseEntity.ok().build();
    }
}