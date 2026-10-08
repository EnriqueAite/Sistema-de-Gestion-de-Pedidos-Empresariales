package com.sigep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sigep.model.Cliente;
import com.sigep.repository.IClienteRepository;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private IClienteRepository repoCli;

    @GetMapping
    public List<Cliente> listar() {
        return repoCli.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable Integer id) {
        return repoCli.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cliente guardar(@RequestBody Cliente cliente) {
        return repoCli.save(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizar(@PathVariable Integer id, @RequestBody Cliente cliente) {
        if (!repoCli.existsById(id)) return ResponseEntity.notFound().build();
        cliente.setId_cliente(id);
        return ResponseEntity.ok(repoCli.save(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (!repoCli.existsById(id)) return ResponseEntity.notFound().build();
        repoCli.deleteById(id);
        return ResponseEntity.ok().build();
    }
}