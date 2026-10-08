package com.sigep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sigep.model.Categoria;
import com.sigep.repository.ICategoriaRepository;
import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private ICategoriaRepository repoCate;

    @GetMapping
    public List<Categoria> listar() {
        return repoCate.findAll();
    }
}