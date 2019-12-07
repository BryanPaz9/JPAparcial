/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bryanpaz.service;

import com.bryanpaz.domain.Proveedor;
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
public class ProveedorService {
    private final EntityManager em;
    
    public ProveedorService(EntityManager em){
        this.em = em;
    }
        //Un método que  devuelva todos los registros.
        public List<Proveedor> getRecords() {
        CriteriaBuilder builder = this.em.getCriteriaBuilder();
        CriteriaQuery<Proveedor> providerQuery = builder.createQuery(Proveedor.class);
        Root<Proveedor> providerRoot = providerQuery.from(Proveedor.class);
        providerQuery.select(providerRoot);
        List<Proveedor> providerList = this.em.createQuery(providerQuery).getResultList();
        return providerList;
    }
    
    //Un método que devuelva el registro por su llave primaria, si no existe retornar null.
    public Proveedor getProductByPK(Integer providerId){
        try{
        return this.em.find(Proveedor.class, providerId);
        }catch(NoResultException e){
            return null;
        }
    }
    
    
     // Para proveedores, un método que devuelva un proveedor por su código.
    
    public Proveedor findProvider(String codigo){
        try{
            CriteriaBuilder builder = this.em.getCriteriaBuilder();
            CriteriaQuery<Proveedor> providerQuery = builder.createQuery(Proveedor.class);
            Root<Proveedor> providerRoot = providerQuery.from(Proveedor.class);
            providerQuery.select(providerRoot).where(builder.equal(providerRoot.get("codigo"), codigo));
            Proveedor provider = this.em.createQuery(providerQuery).getSingleResult();
            return provider;
        }catch(NoResultException ex){
            return null;
        }
    }
}
