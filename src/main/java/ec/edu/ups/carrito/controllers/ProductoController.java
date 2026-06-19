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
    private BuscarProductoView buscarProductoView;
    private EliminarProductoView eliminarProductoView;
    private ActualizarProductoView actualizarProductoView;
    
    
    
    public ProductoController(CrearProductoView crearProductoView, ProductoDAO productoDAO, 
            ActualizarProductoView actualizarProductoView, EliminarProductoView eliminarProductoView, 
            BuscarProductoView buscarProductoView){
        this.crearProductoView = crearProductoView;
        this.productoDAO = productoDAO;
        this.actualizarProductoView = actualizarProductoView;
        this.buscarProductoView = buscarProductoView;
        this.eliminarProductoView = eliminarProductoView;
        configurarEventosCrearProducto();
        configurarEventosActualizarProducto();
        configurarEventosBuscarProducto();
        configurarEventosEliminarProducto();
    }
    
    public void crearProducto(){
        int codigo = Integer.parseInt(crearProductoView.getTxtCodigo().getText());
        String nombre = crearProductoView.getTxtNombre().getText();
        double precio = Double.parseDouble(crearProductoView.getTxtPrecio().getText());
        
        Producto producto = new Producto(codigo, nombre, precio);
        productoDAO.crear(producto);
        crearProductoView.mostrarInformacion("Producto creado exitosamente");
    }
    public void configurarEventosCrearProducto(){
        crearProductoView.getBtnAceptar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                crearProducto();
            }
        });
    }
    
    public void buscarProducto(){
        int codigo = Integer.parseInt(buscarProductoView.getTxtCodigo().getText());
        Producto producto = productoDAO.buscar(codigo);
        if(producto != null){
            buscarProductoView.getTxtNombre().setText(producto.getNombre());
            buscarProductoView.getTxtPrecio().setText(String.valueOf(producto.getPrecio()));
        }else{
            buscarProductoView.mostrarInformacion("Producto no encontrado");
        }
    }
    public void configurarEventosBuscarProducto(){
        buscarProductoView.getBtnBuscar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
               buscarProducto();
            } 
        });
    }
    
    public void eliminarProducto(){
        int codigo = Integer.parseInt(eliminarProductoView.getTxtCodigo().getText());
        boolean confirmado = eliminarProductoView.confirmarEliminacion("Esta seguro que desea eliminar el producto?");
        if(confirmado){
            productoDAO.eliminar(codigo);
            eliminarProductoView.mostrarInformacion("Producto eliminado exitosamente");
        }
    }
    public void buscarProductoParaEliminar(){
        int codigo = Integer.parseInt(eliminarProductoView.getTxtCodigo().getText());
        Producto producto = productoDAO.buscar(codigo);
        if(producto != null){
            eliminarProductoView.getTxtNombre().setText(producto.getNombre());
        }else{
            eliminarProductoView.mostrarInformacion("Producto no encontrado");
        }
    }
    public void configurarEventosEliminarProducto(){
        eliminarProductoView.getBtnBuscar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                buscarProductoParaEliminar();
            }
        });
        eliminarProductoView.getBtnEliminar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                eliminarProducto();
            }
        }); 
    }
    
        public void actualizarProducto(){
        int codigo = Integer.parseInt(actualizarProductoView.getTxtCodigo().getText());
        String nombre = actualizarProductoView.getTxtNombre().getText();
        double precio = Double.parseDouble(actualizarProductoView.getTxtPrecio().getText());
        
        Producto producto = new Producto(codigo,nombre,precio);
        productoDAO.actualizar(codigo,producto);
        actualizarProductoView.mostrarInformacion("Producto actualizado exitosamente");
    }
    public void buscarProductoParaActualizar(){
        int codigo = Integer.parseInt(actualizarProductoView.getTxtCodigo().getText());
        Producto producto = productoDAO.buscar(codigo);
        if(producto != null){
            actualizarProductoView.getTxtNombre().setText(producto.getNombre());
            actualizarProductoView.getTxtPrecio().setText(String.valueOf(producto.getPrecio()));
        }else{
            actualizarProductoView.mostrarInformacion("Producto no encontrado");
        }
    }
    public void configurarEventosActualizarProducto(){
        actualizarProductoView.getBtnBuscar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                buscarProductoParaActualizar();
            }
        });
        actualizarProductoView.getBtnActualizar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                actualizarProducto();
            }
        });
    }
    
}
