package com.sigep.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_categoria;

    private String nombre;

    public Integer getId_categoria()                   { return id_categoria; }
    public String getNombre()                          { return nombre; }

    public void setId_categoria(Integer id_categoria)  { this.id_categoria = id_categoria; }
    public void setNombre(String nombre)               { this.nombre = nombre; }
}