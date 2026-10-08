package com.sigep.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cliente;

    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String direccion;

    public Integer getId_cliente()              { return id_cliente; }
    public String getNombre()                   { return nombre; }
    public String getApellido()                 { return apellido; }
    public String getEmail()                    { return email; }
    public String getTelefono()                 { return telefono; }
    public String getDireccion()                { return direccion; }

    public void setId_cliente(Integer id_cliente) { this.id_cliente = id_cliente; }
    public void setNombre(String nombre)           { this.nombre = nombre; }
    public void setApellido(String apellido)       { this.apellido = apellido; }
    public void setEmail(String email)             { this.email = email; }
    public void setTelefono(String telefono)       { this.telefono = telefono; }
    public void setDireccion(String direccion)     { this.direccion = direccion; }
}