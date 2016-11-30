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
    
    PanelEliminarProveedor panelEliminarProveedor; 
    PanelActualizarProveedor panelActualizarProveedor;
    PanelVerProveedores panelVerProveedores;
    PanelBuscarProveedor panelBuscarProveedor;
    PanelAgregarProveedor panelAgregarProveedor;
    
    public VentanaProveedores(){
        
        panelEliminarProveedor = new PanelEliminarProveedor( );
        panelActualizarProveedor = new PanelActualizarProveedor( );
        panelVerProveedores = new PanelVerProveedores( );
        panelBuscarProveedor = new PanelBuscarProveedor( );
        panelAgregarProveedor = new PanelAgregarProveedor( );
        
        
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
        
    public void mostrarPanelAgregarProveedor( ){
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane( ) );
        getContentPane( ).setLayout( layout );
        layout.setHorizontalGroup(
            layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
            .addGroup( layout.createSequentialGroup( )
                .addGap( 94, 94, 94 )
                .addComponent( panelAgregarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE )
                .addContainerGap( 176, Short.MAX_VALUE ) )
        );
        layout.setVerticalGroup(
            layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
            .addGroup( layout.createSequentialGroup( )
                .addContainerGap( )
                .addComponent( panelAgregarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE )
                .addContainerGap( 193, Short.MAX_VALUE ) )
        );
     }
    
    public void mostrarPanelVerProveedores ( ) {
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
                .addComponent(panelVerProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE )
                .addContainerGap( 237, Short.MAX_VALUE) )
        );
        
    }
    
    public void mostrarPanelBuscarProveedor( ){
        panelBuscarProveedor.setVisible(true);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane( ) );
        getContentPane( ).setLayout( layout );
        layout.setHorizontalGroup(
            layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
            .addGroup( javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup( )
                .addContainerGap( 235, Short.MAX_VALUE )
                .addComponent( panelBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 244, 
                        javax.swing.GroupLayout.PREFERRED_SIZE )
                .addGap( 43, 43, 43) )
        );
        layout.setVerticalGroup(
            layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
            .addGroup( layout.createSequentialGroup( )
                .addContainerGap( )
                .addComponent( panelBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 394, 
                        javax.swing.GroupLayout.PREFERRED_SIZE )
                .addContainerGap( 216, Short.MAX_VALUE ) )
        );
     }
    
    public void mostrarPanelEliminarProveedor( ){
        panelEliminarProveedor.setVisible(true);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane( ) );
        getContentPane( ).setLayout( layout );
        layout.setHorizontalGroup(
            layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
            .addGroup( layout.createSequentialGroup( )
                .addGap( 26, 26, 26 )
                .addComponent( panelEliminarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE )
                .addContainerGap( 282, Short.MAX_VALUE ) )
        );
        layout.setVerticalGroup(
            layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
            .addGroup( javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup( )
                .addContainerGap( 342, Short.MAX_VALUE )
                .addComponent( panelEliminarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE )
                .addGap( 27, 27, 27 ) )
        );
     }
    
    public void mostrarPanelActualizarProveedor( ){
        panelActualizarProveedor.setVisible(true);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane( ) );
        getContentPane( ).setLayout( layout );
        layout.setHorizontalGroup(
            layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
            .addGroup( javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup( )
                .addContainerGap( 465, Short.MAX_VALUE )
                .addComponent( panelActualizarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE )
                .addContainerGap( ) )
        );
        layout.setVerticalGroup(
            layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
            .addGroup( layout.createSequentialGroup( )
                .addGap( 38, 38, 38 )
                .addComponent( panelActualizarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE )
                .addContainerGap( 103, Short.MAX_VALUE ) )
        ); 
     }

    public PanelEliminarProveedor getPanelEliminarProveedor() {
        return panelEliminarProveedor;
    }

    public PanelActualizarProveedor getPanelActualizarProveedor() {
        return panelActualizarProveedor;
    }

    public PanelVerProveedores getPanelVerProveedores() {
        return panelVerProveedores;
    }

    public PanelBuscarProveedor getPanelBuscarProveedor() {
        return panelBuscarProveedor;
    }

    public PanelAgregarProveedor getPanelAgregarProveedor() {
        return panelAgregarProveedor;
    }

    public void setPanelEliminarProveedor(PanelEliminarProveedor panelEliminarProveedor) {
        this.panelEliminarProveedor = panelEliminarProveedor;
    }

    public void setPanelActualizarProveedor(PanelActualizarProveedor panelActualizarProveedor) {
        this.panelActualizarProveedor = panelActualizarProveedor;
    }

    public void setPanelVerProveedores(PanelVerProveedores panelVerProveedores) {
        this.panelVerProveedores = panelVerProveedores;
    }

    public void setPanelBuscarProveedor(PanelBuscarProveedor panelBuscarProveedor) {
        this.panelBuscarProveedor = panelBuscarProveedor;
    }

    public void setPanelAgregarProveedor(PanelAgregarProveedor panelAgregarProveedor) {
        this.panelAgregarProveedor = panelAgregarProveedor;
    }
    
    
}
