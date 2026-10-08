package com.sigep.model;

import jakarta.persistence.*;

@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_empresa;

    private String nombre;
    private String pais;

    public Integer getId_empresa()              { return id_empresa; }
    public String getNombre()                   { return nombre; }
    public String getPais()                     { return pais; }

    public void setId_empresa(Integer id_empresa) { this.id_empresa = id_empresa; }
    public void setNombre(String nombre)           { this.nombre = nombre; }
    public void setPais(String pais)               { this.pais = pais; }
}