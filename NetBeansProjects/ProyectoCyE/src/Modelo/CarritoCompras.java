/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author rodrigopeniche
 */
public class CarritoCompras {
    
    private final ArrayList<Articulo> articulosEnCarrito;

    public CarritoCompras() {
        this.articulosEnCarrito = new ArrayList<>();
    }
     
    public ArrayList<Articulo> getArticulosEnCarrito() {
        return articulosEnCarrito;
    }
    
    public void agregarAlCarrito(Articulo articulo){
        articulosEnCarrito.add(articulo);
    }
    
    public void eliminarDelCarrito(String claveArticulo){
        for(int i=0; i<articulosEnCarrito.size(); i++){
            if(articulosEnCarrito.get(i).getClaveArticulo().equals(claveArticulo)){
                articulosEnCarrito.remove(i);
            }
        }
    }
    
}
