package com.sigep.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pedido;

    private Integer id_cliente;
    private Integer id_producto;
    private int cantidad;

    @Temporal(TemporalType.DATE)
    private Date fecha_pedido;

    @Temporal(TemporalType.DATE)
    private Date fecha_pago;

    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private Cliente objCliente;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto objProducto;

    public Integer getId_pedido()                      { return id_pedido; }
    public Integer getId_cliente()                     { return id_cliente; }
    public Integer getId_producto()                    { return id_producto; }
    public int getCantidad()                           { return cantidad; }
    public Date getFecha_pedido()                      { return fecha_pedido; }
    public Date getFecha_pago()                        { return fecha_pago; }
    public String getEstado()                          { return estado; }
    public Cliente getObjCliente()                     { return objCliente; }
    public Producto getObjProducto()                   { return objProducto; }

    public void setId_pedido(Integer id_pedido)        { this.id_pedido = id_pedido; }
    public void setId_cliente(Integer id_cliente)      { this.id_cliente = id_cliente; }
    public void setId_producto(Integer id_producto)    { this.id_producto = id_producto; }
    public void setCantidad(int cantidad)              { this.cantidad = cantidad; }
    public void setFecha_pedido(Date fecha_pedido)     { this.fecha_pedido = fecha_pedido; }
    public void setFecha_pago(Date fecha_pago)         { this.fecha_pago = fecha_pago; }
    public void setEstado(String estado)               { this.estado = estado; }
    public void setObjCliente(Cliente objCliente)      { this.objCliente = objCliente; }
    public void setObjProducto(Producto objProducto)   { this.objProducto = objProducto; }
}