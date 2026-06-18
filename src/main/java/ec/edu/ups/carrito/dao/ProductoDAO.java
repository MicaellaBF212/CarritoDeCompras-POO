/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.carrito.dao;

import ec.edu.ups.carrito.models.Producto;

/**
 *
 * @author User
 */
public interface ProductoDAO {
    //METODOS PUBLICOS ABSTRACTOS
    void crear(Producto producto);
    Producto buscar(int codigo);
    void actualizar(int codigo, Producto producto);
    void eliminar(int codigo);
    
}
