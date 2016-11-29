/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas.Ventas;

import javax.swing.JFrame;

/**
 *
 * @author rodrigopeniche
 */
public class VentanaVentas extends JFrame {
    
    private static VentanaVentas ventanaVentas = null;
    private final PanelCarritoCompras panelCarritoCompras;
    private final PanelRealizarVenta panelRealizarVenta;
    
    public VentanaVentas(){
        
        panelCarritoCompras = new PanelCarritoCompras();
        panelRealizarVenta = new PanelRealizarVenta();
        
        
        setTitle("Ventas");
        
        setDefaultCloseOperation( javax.swing.WindowConstants.DISPOSE_ON_CLOSE );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane( ) );
        getContentPane( ).setLayout( layout );
        layout.setHorizontalGroup(
            layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
            .addGap( 0, 900, Short.MAX_VALUE )
        );
        layout.setVerticalGroup(
            layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
            .addGap( 0, 500, Short.MAX_VALUE )
        );
        
        pack();
    }
    
    private static void generarVentanaVerInventario( ){
        ventanaVentas = new VentanaVentas();
    }
    
    public static VentanaVentas obtenerVentanaVentas( ){
        if( ventanaVentas== null ){
             generarVentanaVerInventario();
        }
        ventanaVentas.setVisible(true);
        
        return ventanaVentas;
    }
    
    
}
