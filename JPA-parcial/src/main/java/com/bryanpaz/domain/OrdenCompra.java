/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bryanpaz.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author 001la
 */
@Entity
@Table(name = "orden_compra")
public class OrdenCompra implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="orden_compra_id")
    private Integer ordenCompraId;
    
    @Column(name="numero_orden")
    private String numeroOrden;
    
    @Column(name="pedido_el")
    private LocalDateTime pedidoEl;
    
    @ManyToOne
    @JoinColumn(name = "proveedor_id", referencedColumnName = "proveedor_id")
    private Proveedor proveedor;
    
    @OneToMany(mappedBy = "ordenCompra")
    private List<OrdenCompraDetalle> ordenCompraDetalleList;

    public Integer getOrdenCompraId() {
        return ordenCompraId;
    }

    public void setOrdenCompraId(Integer ordenCompraId) {
        this.ordenCompraId = ordenCompraId;
    }

    public String getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(String numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public LocalDateTime getPedidoEl() {
        return pedidoEl;
    }

    public void setPedidoEl(LocalDateTime pedidoEl) {
        this.pedidoEl = pedidoEl;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<OrdenCompraDetalle> getOrdenCompraDetalleList() {
        return ordenCompraDetalleList;
    }

    public void setOrdenCompraDetalleList(List<OrdenCompraDetalle> ordenCompraDetalleList) {
        this.ordenCompraDetalleList = ordenCompraDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.ordenCompraId);
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
        final OrdenCompra other = (OrdenCompra) obj;
        if (!Objects.equals(this.ordenCompraId, other.ordenCompraId)) {
            return false;
        }
        return true;
    }
    
    
}
