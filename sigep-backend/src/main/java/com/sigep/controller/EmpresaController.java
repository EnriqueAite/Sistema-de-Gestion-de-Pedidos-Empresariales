package com.sigep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sigep.model.Empresa;
import com.sigep.repository.IEmpresaRepository;
import java.util.List;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @Autowired
    private IEmpresaRepository repoEmp;

    @GetMapping
    public List<Empresa> listar() {
        return repoEmp.findAll();
    }
}