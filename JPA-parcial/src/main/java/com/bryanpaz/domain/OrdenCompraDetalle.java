/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bryanpaz.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author 001la
 */
@Entity
@Table(name = "orden_compra_detalle")
public class OrdenCompraDetalle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "orden_compra_detalle_id")
    private Integer ordenCompraDetalleId;
    
    @Column(name= "cantidad")
    private Integer cantidad;
    
    @Column(name="precio_compra")
    private BigDecimal precio_compra;
    
    @Column(name="observaciones")
    private String observaciones;
    
    @ManyToOne
    @JoinColumn(name="orden_compra_id", referencedColumnName="orden_compra_id")
    private OrdenCompra ordenCompra;

    @ManyToOne
    @JoinColumn(name="producto_id", referencedColumnName="producto_id")
    private Producto producto;
    
    public Integer getOrdenCompraDetalleId() {
        return ordenCompraDetalleId;
    }

    public void setOrdenCompraDetalleId(Integer ordenCompraDetalleId) {
        this.ordenCompraDetalleId = ordenCompraDetalleId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(BigDecimal precio_compra) {
        this.precio_compra = precio_compra;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }
    
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.ordenCompraDetalleId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrdenCompraDetalle other = (OrdenCompraDetalle) obj;
        if (!Objects.equals(this.ordenCompraDetalleId, other.ordenCompraDetalleId)) {
            return false;
        }
        return true;
    }
    
    
}
