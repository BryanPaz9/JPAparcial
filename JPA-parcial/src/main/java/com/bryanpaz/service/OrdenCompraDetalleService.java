/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bryanpaz.service;

import com.bryanpaz.domain.OrdenCompraDetalle;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 001la
 */
public class OrdenCompraDetalleService {
    private final EntityManager em;
    
    public OrdenCompraDetalleService(EntityManager em){
        this.em = em;
    }    
    
            //Un método que  devuelva todos los registros.
        public List<OrdenCompraDetalle> getRecords() {
        CriteriaBuilder builder = this.em.getCriteriaBuilder();
        CriteriaQuery<OrdenCompraDetalle> ordenCompraDetalleQuery = builder.createQuery(OrdenCompraDetalle.class);
        Root<OrdenCompraDetalle> ordenCompraDetalleRoot = ordenCompraDetalleQuery.from(OrdenCompraDetalle.class);
        ordenCompraDetalleQuery.select(ordenCompraDetalleRoot);
        List<OrdenCompraDetalle> ordenCompraDetalleList = this.em.createQuery(ordenCompraDetalleQuery).getResultList();
        return ordenCompraDetalleList;
    }
    
    //Un método que devuelva el registro por su llave primaria, si no existe retornar null.
    public OrdenCompraDetalle getOrdenCompraDetalleByPK(Integer ordenCompraDetalleId){
        try{
        return this.em.find(OrdenCompraDetalle.class, ordenCompraDetalleId);
        }catch(NoResultException e){
            return null;
        }
    }
}
