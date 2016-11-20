/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Datos;

import Modelo.Articulo;
import Modelo.Venta;
import java.sql.SQLException;

/**
 *
 * @author rodrigopeniche
 */
public class AccesoBDDetallesVentas extends AccesoBD {
    
    private static final String CLAVE_VENTA = "claveVenta";
    private static final String CLAVE_ARTICULO = "claveArticulo";
    
    public void insertarArticuloEnVenta( Articulo articulo, Venta venta ) throws SQLException, ClassNotFoundException {
         ManejadorConexionBD.obtenerInstancia( ).conectarConBD( );
         conexionBD = ManejadorConexionBD.obtenerConexion( );
        
         consultaBD = COMANDO_INSERT + COMANDO_INTO + "DetallesVentas" + COMANDO_VALUES+ "(\"" + articulo.getClaveArticulo( ) + "\", "
                                                 + "\"" + venta.getClave() + "\")";
         sentenciaConsulta = conexionBD.createStatement( );
         sentenciaConsulta.executeUpdate( consultaBD );
        
         ManejadorConexionBD.obtenerInstancia( ).desconectarConBD( );
    }
    
    
    
}
