package com.sigep.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "movimiento_stock")
public class MovimientoStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_movimiento;

    private Integer id_producto;
    private String tipo;
    private int cantidad;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    private String observacion;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto objProducto;

    public Integer getId_movimiento()                          { return id_movimiento; }
    public Integer getId_producto()                            { return id_producto; }
    public String getTipo()                                    { return tipo; }
    public int getCantidad()                                   { return cantidad; }
    public Date getFecha()                                     { return fecha; }
    public String getObservacion()                             { return observacion; }
    public Producto getObjProducto()                           { return objProducto; }

    public void setId_movimiento(Integer id_movimiento)        { this.id_movimiento = id_movimiento; }
    public void setId_producto(Integer id_producto)            { this.id_producto = id_producto; }
    public void setTipo(String tipo)                           { this.tipo = tipo; }
    public void setCantidad(int cantidad)                      { this.cantidad = cantidad; }
    public void setFecha(Date fecha)                           { this.fecha = fecha; }
    public void setObservacion(String observacion)             { this.observacion = observacion; }
    public void setObjProducto(Producto objProducto)           { this.objProducto = objProducto; }
}