
 /* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Datos;


import java.sql.ResultSet;
import Modelo.Venta;
import java.sql.SQLException;

/**
 *
 * @author rodrigopeniche
 */
public class AccesoBDVentas extends AccesoBD {
    
    private static final String CLAVE = "clave";
    private static final String MONTO = "monto";
    private static final String GANANCIA = "ganancia";
    private static final String FECHA = "fecha";
    
    public void insertarVenta(Venta venta) throws ClassNotFoundException, SQLException{
         ManejadorConexionBD.obtenerInstancia( ).conectarConBD( );
         conexionBD = ManejadorConexionBD.obtenerConexion( );
        
         consultaBD = COMANDO_INSERT + COMANDO_INTO + "ventas" + COMANDO_VALUES+ "(\"" + venta.getClave( ) + "\", "
                                                 + "\"" + venta.getMontoVenta( ) + "\", "
                                                 + "\"" + venta.getGanancia( ) + "\", "
                                                 + "\"" + venta.getFecha( ) + "\")";
         sentenciaConsulta = conexionBD.createStatement( );
         sentenciaConsulta.executeUpdate( consultaBD );
        
         ManejadorConexionBD.obtenerInstancia( ).desconectarConBD( );
    }
    
//     public Venta buscarVenta( String claveVenta ) throws SQLException, ClassNotFoundException {
//         ManejadorConexionBD.obtenerInstancia( ).conectarConBD( );
//         conexionBD = ManejadorConexionBD.obtenerConexion();
//        
//         consultaBD = SELECT_STRING + "*" + FROM_STRING + "ventas" + WHERE_STRING + clave + " = \"" + claveVenta + "\"";
//         sentenciaConsulta = conexionBD.createStatement( );
//         ResultSet resultadoConsultaBD = sentenciaConsulta.executeQuery(consultaBD);
//        
//         //Omite el primer elemento del ResultSet el cual es una direccion de memoria
//         resultadoConsultaBD.next( );
//        
//         Venta venta = new Venta( resultadoConsultaBD.getString( clave ),
//                                              resultadoConsultaBD.getString( monto ),
//                                              resultadoConsultaBD.getString( ganancia ),
//                                              resultadoConsultaBD.getString( fecha ) );
//        
//         ManejadorConexionBD.obtenerInstancia( ).desconectarConBD( );
//        
//         return venta;
//    }
//    
}
