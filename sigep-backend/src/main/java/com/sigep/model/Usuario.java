package com.sigep.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;

    private String nombre;
    private String usuario;
    private String clave;

    public Integer getId_usuario()              { return id_usuario; }
    public String getNombre()                   { return nombre; }
    public String getUsuario()                  { return usuario; }
    public String getClave()                    { return clave; }

    public void setId_usuario(Integer id_usuario) { this.id_usuario = id_usuario; }
    public void setNombre(String nombre)           { this.nombre = nombre; }
    public void setUsuario(String usuario)         { this.usuario = usuario; }
    public void setClave(String clave)             { this.clave = clave; }
}