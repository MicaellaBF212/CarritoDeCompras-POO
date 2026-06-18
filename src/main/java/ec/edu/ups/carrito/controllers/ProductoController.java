/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.carrito.controllers;

import ec.edu.ups.carrito.dao.ProductoDAO;
import ec.edu.ups.carrito.models.Producto;
import ec.edu.ups.carrito.views.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author User
 */
public class ProductoController {
    private ProductoDAO productoDAO;
    private CrearProductoView crearProductoView;
    private ActualizarProductoView actualizarProductoView;
    private EliminarProductoView eliminarProductoView;
    private BuscarProductoView buscarProductoView;
    
    public ProductoController(CrearProductoView crearProductoView, ProductoDAO productoDAO, 
            ActualizarProductoView actualizarProductoView, EliminarProductoView eliminarProductoView, 
            BuscarProductoView buscarProductoView){
        this.crearProductoView = crearProductoView;
        this.productoDAO = productoDAO;
        this.actualizarProductoView = actualizarProductoView;
        this.buscarProductoView = buscarProductoView;
        this.eliminarProductoView = eliminarProductoView;
        configurarEventosCrearProducto();
    }
    
    public void crearProducto(){
        int codigo = Integer.parseInt(crearProductoView.getTxtCodigo().getText());
        String nombre = crearProductoView.getTxtNombre().getText();
        double precio = Double.parseDouble(crearProductoView.getTxtPrecio().getText());
        
        Producto producto = new Producto(codigo, nombre, precio);
        productoDAO.crear(producto);
        crearProductoView.mostrarInformacion("Producto creado exitosamente!");
    }
    public void configurarEventosCrearProducto(){
        crearProductoView.getBtnAceptar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                crearProducto();
            }
        });
    }
    public void actualizarProducto(){
        
    }
    
    public void buscarProducto(){
        
    }
    
    public void eliminarProducto(){
        
    }
    
}
