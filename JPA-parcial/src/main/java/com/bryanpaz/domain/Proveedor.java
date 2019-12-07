/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bryanpaz.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author 001la
 */

@Entity
@Table(name = "proveedor")
public class Proveedor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "proveedor_id")
    private Integer proveedorId;
    
    @Column(name = "codigo")
    private String codigo;
    
    @Column(name = "nombre")
    private String nombre;
    
    @OneToMany(mappedBy="proveedor")
    private List<OrdenCompra> ordenCompraList;

    public Integer getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(Integer proveedorId) {
        this.proveedorId = proveedorId;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<OrdenCompra> getOrdenCompraList() {
        return ordenCompraList;
    }

    public void setOrdenCompraList(List<OrdenCompra> ordenCompraList) {
        this.ordenCompraList = ordenCompraList;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.proveedorId);
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
        final Proveedor other = (Proveedor) obj;
        if (!Objects.equals(this.proveedorId, other.proveedorId)) {
            return false;
        }
        return true;
    }

    
}
