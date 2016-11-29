/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas.Proveedores;

import javax.swing.JFrame;

/**
 *
 * @author rodrigopeniche
 */
public class VentanaProveedores extends JFrame {
    
    private static VentanaProveedores ventanaProveedores = null;
    private final PanelActualizarProveedor panelActualizarProveedor;
    private final PanelAgregarProveedor panelAgregarProveedor;
    private final PanelBuscarProveedor panelBuscarProveedor;
    private final PanelVerProveedores panelVerProveedores;
    private final PanelEliminarProveedor panelEliminarProveedor;
    
    private VentanaProveedores(){
        panelActualizarProveedor = new PanelActualizarProveedor();
        panelAgregarProveedor = new PanelAgregarProveedor();
        panelBuscarProveedor = new PanelBuscarProveedor();
        panelVerProveedores = new PanelVerProveedores();
        panelEliminarProveedor =  new PanelEliminarProveedor();
        
        setTitle("Proveedores");
        setDefaultCloseOperation( javax.swing.WindowConstants.DISPOSE_ON_CLOSE );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane( ) );
        getContentPane( ).setLayout( layout );
        layout.setHorizontalGroup(
            layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
            .addGap( 0, 877, Short.MAX_VALUE )
        );
        layout.setVerticalGroup(
            layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
            .addGap( 0, 500, Short.MAX_VALUE )
        );
        
        pack();
    }
    
   private static void generarVentanaProveedores( ){
        ventanaProveedores = new VentanaProveedores();
    }
    
    public static VentanaProveedores obtenerVentanaProveedores( ){
        if( ventanaProveedores== null ){
             generarVentanaProveedores();
        }
        ventanaProveedores.setVisible(true);
        
        return ventanaProveedores;
    }
        
    public void mostrarPanelAgregarProveedor( ){
        panelVerProveedores.setVisible(false);
        panelBuscarProveedor.setVisible(false);
        panelAgregarProveedor.setVisible(true);
        panelEliminarProveedor.setVisible(false);
        panelActualizarProveedor.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelAgregarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 492, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelAgregarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 208, Short.MAX_VALUE))
        );
     }
    
    public void mostrarPanelVerProveedores ( ) {
        panelVerProveedores.setVisible(true);
        panelBuscarProveedor.setVisible(false);
        panelAgregarProveedor.setVisible(false);
        panelEliminarProveedor.setVisible(false);
        panelActualizarProveedor.setVisible(false);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane( ) );
        getContentPane( ).setLayout( layout );
        layout.setHorizontalGroup(
            layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
            .addGroup( layout.createSequentialGroup( )
                .addComponent( panelVerProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE )
                .addContainerGap( 280, Short.MAX_VALUE) )
        );
        layout.setVerticalGroup(
            layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
            .addGroup( layout.createSequentialGroup( )
                .addComponent( panelVerProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE )
                .addContainerGap( 237, Short.MAX_VALUE) )
        );
        
    }
    
    public void mostrarPanelBuscarProveedor( ){
        panelBuscarProveedor.setVisible(true);
        panelAgregarProveedor.setVisible(false);
        panelEliminarProveedor.setVisible(false);
        panelActualizarProveedor.setVisible(false);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(566, Short.MAX_VALUE)
                .addComponent(panelBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(panelBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(180, Short.MAX_VALUE))
        );
     }
    
    public void mostrarPanelEliminarProveedor( ){
        panelBuscarProveedor.setVisible(false);
        panelAgregarProveedor.setVisible(false);
        panelEliminarProveedor.setVisible(true);
        panelActualizarProveedor.setVisible(false);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane( ) );
        getContentPane( ).setLayout( layout );
        layout.setHorizontalGroup(
            layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
            .addGroup( layout.createSequentialGroup( )
                .addGap (26, 26, 26 )
                .addComponent( panelEliminarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE )
                .addContainerGap( 282, Short.MAX_VALUE ) )
        );
        layout.setVerticalGroup(
            layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
            .addGroup( javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup( )
                .addContainerGap (342, Short.MAX_VALUE )
                .addComponent( panelEliminarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE )
                .addGap( 27, 27, 27 ) )
        );
     }
    
    public void mostrarPanelActualizarProveedor( ){
        panelBuscarProveedor.setVisible(false);
        panelAgregarProveedor.setVisible(false);
        panelEliminarProveedor.setVisible(false);
        panelActualizarProveedor.setVisible(true);
        
       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(456, Short.MAX_VALUE)
                .addComponent(panelActualizarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelActualizarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 202, Short.MAX_VALUE))
        ); 
     } 

    public PanelActualizarProveedor getPanelActualizarProveedor() {
        return panelActualizarProveedor;
    }

    public PanelAgregarProveedor getPanelAgregarProveedor() {
        return panelAgregarProveedor;
    }

    public PanelBuscarProveedor getPanelBuscarProveedor() {
        return panelBuscarProveedor;
    }

    public PanelVerProveedores getPanelVerProveedores() {
        return panelVerProveedores;
    }

    public PanelEliminarProveedor getPanelEliminarProveedor() {
        return panelEliminarProveedor;
    }
    
    
}
