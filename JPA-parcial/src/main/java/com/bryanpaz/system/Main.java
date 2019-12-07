/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bryanpaz.system;

import com.bryanpaz.domain.OrdenCompra;
import com.bryanpaz.domain.OrdenCompraDetalle;
import com.bryanpaz.domain.Producto;
import com.bryanpaz.domain.Proveedor;
import com.bryanpaz.service.OrdenCompraDetalleService;
import com.bryanpaz.service.OrdenCompraService;
import com.bryanpaz.service.ProductoService;
import com.bryanpaz.service.ProveedorService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 001la
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ParcialJPA");
        EntityManager em = emf.createEntityManager();
  
        /**PROVEEDOR**/
        ProveedorService providerService = new ProveedorService(em);
        
        // 1.1 Un método que  devuelva todos los registros.
        List<Proveedor> providerList = providerService.getRecords();
        providerList.stream().forEach(System.out::println);
        // 2.1 Un método que devuelva el registro por su llave primaria, si no existe retornar null.
        Proveedor providerPK = providerService.getProductByPK(12);
        System.out.println("El proveedor equivalente a la FK es: "+ providerPK);
        
        //  4. Para proveedores, un método que devuelva un proveedor por su código.
        Proveedor provider = providerService.findProvider("292");
        System.out.println("El proveedor es: "+ provider);
        
        
        
        
        
        /**PRODUCTO**/
        ProductoService productService = new ProductoService(em);
        
        // 1.2 Un método que  devuelva todos los registros.
        List<Producto> productList = productService.getRecords();
        productList.stream().forEach(System.out::println);
        
        // 2.2 Un método que devuelva el registro por su llave primaria, si no existe retornar null.
        Producto productPK = productService.getProductByPK(37);
        System.out.println("El producto equivalente a la FK es: "+ productPK);
        
        // 3.  Para productos, un método que devuelva un producto por su código.
        Producto product = productService.findProduct("280");
        System.out.println("El producto es: "+ product);

        /**ORDEN COMPRA**/
        OrdenCompraService ordenCompraService = new OrdenCompraService(em);
        
        // 1.3 Un método que  devuelva todos los registros.
        List<OrdenCompra> ordenCompraList = ordenCompraService.getRecords();
        ordenCompraList.stream().forEach(System.out::println);
        
        // 2.3 Un método que devuelva el registro por su llave primaria, si no existe retornar null.
        OrdenCompra ordenPK = ordenCompraService.getOrdenCompraByPK(15);
        System.out.println("La orden de compra equivalente a la FK es: "+ ordenPK);
        
        // 5.  Para orden compra, un método que devulva todos los registros por proveedor.
        List<OrdenCompra> ordenCompra = ordenCompraService.findByProvider(4);
        ordenCompra.stream().forEach(System.out::println);
        
        
        /**ORDEN COMPRA DETALLE**/
        OrdenCompraDetalleService ordenCompraDetalleService = new OrdenCompraDetalleService(em);
        
        // 1.4 Un método que  devuelva todos los registros.
        List<OrdenCompraDetalle> ordenCompraDetalleList = ordenCompraDetalleService.getRecords();
        ordenCompraDetalleList.stream().forEach(System.out::println);
        
        // 2.4 Un método que devuelva el registro por su llave primaria, si no existe retornar null.
        OrdenCompraDetalle ordenCompraDetallePK = ordenCompraDetalleService.getOrdenCompraDetalleByPK(54);
        System.out.println("La orden de compra detalle equivalente a la FK es: "+ ordenCompraDetallePK);
        
        em.close();

        emf.close();

    }
}
