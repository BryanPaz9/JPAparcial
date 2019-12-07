/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bryanpaz.service;

import com.bryanpaz.domain.Producto;
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
public class ProductoService {
    private final EntityManager em;
    
    public ProductoService(EntityManager em){
        this.em = em;
    }
    
    //Un método que  devuelva todos los registros.
        public List<Producto> getRecords() {
        CriteriaBuilder builder = this.em.getCriteriaBuilder();
        CriteriaQuery<Producto> productQuery = builder.createQuery(Producto.class);
        Root<Producto> productRoot = productQuery.from(Producto.class);
        productQuery.select(productRoot);
        List<Producto> productList = this.em.createQuery(productQuery).getResultList();
        return productList;
    }
    
    //Un método que devuelva el registro por su llave primaria, si no existe retornar null.
    public Producto getProductByPK(Integer productId){
        try{
        return this.em.find(Producto.class, productId);
        }catch(NoResultException e){
            return null;
        }
    }
    
     // Para productos, un método que devuelva un producto por su código.
    
    public Producto findProduct(String codigo){
        try{
            CriteriaBuilder builder = this.em.getCriteriaBuilder();
            CriteriaQuery<Producto> productQuery = builder.createQuery(Producto.class);
            Root<Producto> productRoot = productQuery.from(Producto.class);
            productQuery.select(productRoot).where(builder.equal(productRoot.get("codigo"), codigo));
            Producto product = this.em.createQuery(productQuery).getSingleResult();
            return product;
        }catch(NoResultException e){
            return null;
        }
    }
}
