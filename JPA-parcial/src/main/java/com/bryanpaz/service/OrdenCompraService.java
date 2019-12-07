/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bryanpaz.service;

import com.bryanpaz.domain.OrdenCompra;
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
public class OrdenCompraService {
        private final EntityManager em;
    
    public OrdenCompraService(EntityManager em){
        this.em = em;
    }
    //Un método que  devuelva todos los registros.
        public List<OrdenCompra> getRecords() {
        CriteriaBuilder builder = this.em.getCriteriaBuilder();
        CriteriaQuery<OrdenCompra> ordenCompraQuery = builder.createQuery(OrdenCompra.class);
        Root<OrdenCompra> ordenCompraRoot = ordenCompraQuery.from(OrdenCompra.class);
        ordenCompraQuery.select(ordenCompraRoot);
        List<OrdenCompra> ordenCompraList = this.em.createQuery(ordenCompraQuery).getResultList();
        return ordenCompraList;
    }
    
    //Un método que devuelva el registro por su llave primaria, si no existe retornar null.
    public OrdenCompra getOrdenCompraByPK(Integer ordenCompraId){
        try{
        return this.em.find(OrdenCompra.class, ordenCompraId);
        }catch(NoResultException e){
            return null;
        }
    }
    
     // Para orden compra, un método que devuelva todos los registros por proveedor.
    
    public List<OrdenCompra> findByProvider(Integer providerId){
            try{
            CriteriaBuilder builder = this.em.getCriteriaBuilder();
            CriteriaQuery<OrdenCompra> ordenCompraQuery = builder.createQuery(OrdenCompra.class);
            Root<OrdenCompra> ordenCompraRoot = ordenCompraQuery.from(OrdenCompra.class);
            ordenCompraQuery.select(ordenCompraRoot).where(builder.equal(ordenCompraRoot.get("proveedor"), providerId));
            List<OrdenCompra> ordenCompraRecords = this.em.createQuery(ordenCompraQuery).getResultList();
            return ordenCompraRecords;
        }catch(NoResultException ex){
            return null;
        }
    }
}
