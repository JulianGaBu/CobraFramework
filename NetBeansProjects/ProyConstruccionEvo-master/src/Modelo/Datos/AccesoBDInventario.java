 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Datos;

import Modelo.Articulo;
import Modelo.DetalleArticulo;
import Modelo.Precio;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author juan
 */

public class AccesoBDInventario extends AccesoBD {
    
    private static final String CLAVE_ARTICULO = "claveArticulo";
    private static final String CLAVE_PROVEEDOR = "claveProveedor";
    private static final String CLAVE_DESCRIPCION = "descripcion";
    private static final String CLAVE_CANTIDAD = "cantidad";
    private static final String PRECIO_COMPRA = "preciocompra";
    private static final String PRECIO_VENTA = "precioventa";
    
    public ArrayList<Articulo> obtenerInventario( ) throws ClassNotFoundException, SQLException{
         ManejadorConexionBD.obtenerInstancia( ).conectarConBD( );
         conexionBD = ManejadorConexionBD.obtenerConexion( );
 
         consultaBD =  COMANDO_SELECT + "*" + COMANDO_FROM + "articulo";
         sentenciaConsulta = conexionBD.createStatement( );
         ResultSet resultadoConsultaArticulos = sentenciaConsulta.executeQuery( consultaBD );
         
         consultaBD =  COMANDO_SELECT + "*" + COMANDO_FROM + "detallearticulo";
         sentenciaConsulta = conexionBD.createStatement( );
         ResultSet resultadoConsultaDetalleArticulos = sentenciaConsulta.executeQuery( consultaBD );
         
         ArrayList<Articulo> articulos= new ArrayList<>( );
         Articulo articulo;
        
         while ( resultadoConsultaArticulos.next() && resultadoConsultaDetalleArticulos.next()) {
            articulo = new Articulo( resultadoConsultaArticulos.getString(CLAVE_ARTICULO ),
                                     resultadoConsultaArticulos.getString(CLAVE_PROVEEDOR ),
                                     resultadoConsultaArticulos.getString(CLAVE_DESCRIPCION ),
                                     new DetalleArticulo(resultadoConsultaDetalleArticulos.getInt(CLAVE_CANTIDAD),
                                     new Precio(resultadoConsultaDetalleArticulos.getDouble(PRECIO_COMPRA)),
                                     new Precio(resultadoConsultaDetalleArticulos.getDouble(PRECIO_VENTA))));
            
            articulos.add(articulo);
        }
        
         ManejadorConexionBD.obtenerInstancia( ).desconectarConBD( );
        
         return articulos;
    }
   
   public void insertarArticulo( Articulo articulo ) throws SQLException, ClassNotFoundException {
         ManejadorConexionBD.obtenerInstancia( ).conectarConBD( );
         conexionBD = ManejadorConexionBD.obtenerConexion( );
        
         consultaBD = COMANDO_INSERT + COMANDO_INTO + "articulo" + COMANDO_VALUES
                        +"(\"" + articulo.getClaveArticulo()+ "\", "
                        + "\"" + articulo.getClaveProveedor( ) + "\", "
                        + "\"" + articulo.getDescripcion( ) +"\")";
         
         sentenciaConsulta = conexionBD.createStatement( );
         sentenciaConsulta.executeUpdate( consultaBD );
        
         insertarDetalleArticulo(articulo);
         
         ManejadorConexionBD.obtenerInstancia( ).desconectarConBD( );
    }
   
   private void insertarDetalleArticulo (Articulo articulo ) throws SQLException{
        consultaBD = COMANDO_INSERT + COMANDO_INTO + "detallearticulo"+ COMANDO_VALUES 
                        + "(\""+ articulo.getClaveArticulo() + "\","
                        + "\"" + articulo.getDetalleArticulo().getCantidad() + "\","
                        + "\"" + articulo.getDetalleArticulo().getPrecioCompra().getPrecio()+ "\","
                        + "\"" + articulo.getDetalleArticulo().getPrecioVenta().getPrecio() + "\")";
        
            sentenciaConsulta = conexionBD.createStatement( );
            sentenciaConsulta.executeUpdate( consultaBD );
   }
   
    public void eliminarArticulo( String claveArticulo ) throws SQLException, ClassNotFoundException {
         ManejadorConexionBD.obtenerInstancia( ).conectarConBD( );
         conexionBD = ManejadorConexionBD.obtenerConexion( );
        
         consultaBD = COMANDO_DELETE + COMANDO_FROM + "articulo" + COMANDO_WHERE + CLAVE_ARTICULO + " = \"" + claveArticulo + "\"";
         sentenciaConsulta = conexionBD.createStatement( );
         sentenciaConsulta.executeUpdate( consultaBD );
        
         ManejadorConexionBD.obtenerInstancia( ).desconectarConBD( );
    }
   
    public Articulo buscarArticulo( String claveArticulo ) throws SQLException, ClassNotFoundException {
         ManejadorConexionBD.obtenerInstancia( ).conectarConBD( );
         conexionBD = ManejadorConexionBD.obtenerConexion( );
        
         consultaBD = COMANDO_SELECT + "*" + COMANDO_FROM + "articulo" + COMANDO_WHERE + CLAVE_ARTICULO + "= \"" + claveArticulo + "\"";
         sentenciaConsulta = conexionBD.createStatement( );
         ResultSet resultadoConsultaArticulos = sentenciaConsulta.executeQuery( consultaBD );
         
         //Omite el primero elemento del ResultSet el cual es una dirección de memoria
         resultadoConsultaArticulos.next( );
         
         consultaBD =  COMANDO_SELECT + "*" + COMANDO_FROM + "detallearticulo" + COMANDO_WHERE + CLAVE_ARTICULO + "= \"" +
                 claveArticulo + "\"";
         sentenciaConsulta = conexionBD.createStatement( );
         ResultSet resultadoConsultaDetalleArticulos = sentenciaConsulta.executeQuery( consultaBD );
        
         //Omite el primero elemento del ResultSet el cual es una dirección de memoria
         resultadoConsultaDetalleArticulos.next();
         
         Articulo articulo = new Articulo( resultadoConsultaArticulos.getString(CLAVE_ARTICULO ),
                                     resultadoConsultaArticulos.getString(CLAVE_PROVEEDOR ),
                                     resultadoConsultaArticulos.getString(CLAVE_DESCRIPCION ),
                                     new DetalleArticulo(resultadoConsultaDetalleArticulos.getInt(CLAVE_CANTIDAD),
                                     new Precio(resultadoConsultaDetalleArticulos.getDouble(PRECIO_COMPRA)),
                                     new Precio(resultadoConsultaDetalleArticulos.getDouble(PRECIO_VENTA))));
        
         ManejadorConexionBD.obtenerInstancia( ).desconectarConBD( );
        
         return articulo;
    }
    
    public void actualizarArticulo( Articulo articuloModificado ) throws SQLException, ClassNotFoundException{
         ManejadorConexionBD.obtenerInstancia( ).conectarConBD( );
         conexionBD = ManejadorConexionBD.obtenerConexion( );
        
         consultaBD = COMANDO_UPDATE + " articulo " + COMANDO_SET + " " + CLAVE_PROVEEDOR + " = \""
                 + articuloModificado.getClaveProveedor( ) + "\", "
                 + CLAVE_DESCRIPCION + " = \"" + articuloModificado.getDescripcion( ) + "\" "
                 + COMANDO_WHERE + " " + CLAVE_ARTICULO + " = \"" + articuloModificado.getClaveArticulo( ) + "\"";
         
         sentenciaConsulta = conexionBD.createStatement( );
         sentenciaConsulta.executeUpdate( consultaBD );
         
         consultaBD = COMANDO_UPDATE + " detallearticulo " + COMANDO_SET + " "
                 + CLAVE_CANTIDAD + " = " + articuloModificado.getDetalleArticulo().getCantidad( )+ ", "
                 + PRECIO_COMPRA + " = " + articuloModificado.getDetalleArticulo().getPrecioCompra().getPrecio() + ", "
                 + PRECIO_VENTA + " = " + articuloModificado.getDetalleArticulo().getPrecioVenta().getPrecio() + " "
                 + COMANDO_WHERE + " " + CLAVE_ARTICULO + " = \"" + articuloModificado.getClaveArticulo( ) + "\"";
        
        sentenciaConsulta = conexionBD.createStatement( );
        sentenciaConsulta.executeUpdate( consultaBD );
         
         ManejadorConexionBD.obtenerInstancia( ).desconectarConBD( );
       
    }

}
