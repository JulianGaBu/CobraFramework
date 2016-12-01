/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administradores;

import Modelo.Datos.AccesoBDDetallesVentas;
import Modelo.Datos.AccesoBDVentas;
import Modelo.Articulo;
import Modelo.CarritoCompras;
import Modelo.Venta;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodrigopeniche
 */
public class AdministradorVentas implements Administrador {
    
    private final AccesoBDVentas accesoBDVentas;
    private final AccesoBDDetallesVentas accesoBDDetallesVentas;
    private final CarritoCompras carritoCompras;
    private final ArrayList<Articulo> articulosEnCarrito;
 
    
    public AdministradorVentas( ){
        accesoBDVentas = new AccesoBDVentas( );
        accesoBDDetallesVentas = new AccesoBDDetallesVentas( );
        carritoCompras = new CarritoCompras();
        articulosEnCarrito = carritoCompras.getArticulosEnCarrito();

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

    @Override
    public void agregar( Object registro ) {
        try {
            accesoBDVentas.insertarVenta( ( Venta ) registro );
            
            ArrayList<Articulo> articulosVendidos = ( ( Venta )registro ).getArticulosVendidos( );
            
            for( int i=0; i<articulosVendidos.size(); i++){
                accesoBDDetallesVentas.insertarArticuloEnVenta( articulosVendidos.get( i ), ( Venta )registro );
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdministradorVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar( Object registro ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object buscar( Object registro ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar( Object registro ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object obtenerDatos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public CarritoCompras getCarritoCompras() {
        return carritoCompras;
    }
    
    
    
}
