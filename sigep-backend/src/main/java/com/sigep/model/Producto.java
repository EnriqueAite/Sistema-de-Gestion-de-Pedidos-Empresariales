package com.sigep.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_producto;

    private String nombre;
    private BigDecimal precio;
    private int stock;
    private Integer id_empresa;
    private Integer id_categoria;

    @ManyToOne
    @JoinColumn(name = "id_empresa", insertable = false, updatable = false)
    private Empresa objEmpresa;

    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    private Categoria objCategoria;

    public Integer getId_producto()                    { return id_producto; }
    public String getNombre()                          { return nombre; }
    public BigDecimal getPrecio()                      { return precio; }
    public int getStock()                              { return stock; }
    public Integer getId_empresa()                     { return id_empresa; }
    public Integer getId_categoria()                   { return id_categoria; }
    public Empresa getObjEmpresa()                     { return objEmpresa; }
    public Categoria getObjCategoria()                 { return objCategoria; }

    public void setId_producto(Integer id_producto)    { this.id_producto = id_producto; }
    public void setNombre(String nombre)               { this.nombre = nombre; }
    public void setPrecio(BigDecimal precio)           { this.precio = precio; }
    public void setStock(int stock)                    { this.stock = stock; }
    public void setId_empresa(Integer id_empresa)      { this.id_empresa = id_empresa; }
    public void setId_categoria(Integer id_categoria)  { this.id_categoria = id_categoria; }
    public void setObjEmpresa(Empresa objEmpresa)      { this.objEmpresa = objEmpresa; }
    public void setObjCategoria(Categoria objCategoria){ this.objCategoria = objCategoria; }
}