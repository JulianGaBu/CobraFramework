/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas.Inventario;

import javax.swing.JFrame;

/**
 *
 * @author rodrigopeniche
 */
public class VentanaInventario extends JFrame {
     
    private static VentanaInventario ventanaInventario = null;
    private final PanelActualizarArticulo panelActualizarArticulo;
    private final PanelAgregarArticulo panelAgregarArticulo;
    private final PanelBuscarArticulo panelBuscarArticulo;
    private final PanelEliminarArticulo panelEliminarArticulo;
    private final PanelVerInventario panelVerInventario;
    
    private VentanaInventario( ){
        panelActualizarArticulo = new PanelActualizarArticulo();
        panelAgregarArticulo = new PanelAgregarArticulo();
        panelBuscarArticulo = new PanelBuscarArticulo();
        panelEliminarArticulo = new PanelEliminarArticulo();
        panelVerInventario = new PanelVerInventario();
        
        setTitle("Inventario");
        
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
        ventanaInventario = new VentanaInventario();
    }
    
    public static VentanaInventario obtenerVentanaVerInventario( ){
        if( ventanaInventario== null ){
             generarVentanaVerInventario();
        }
        ventanaInventario.setVisible(true);
        return ventanaInventario;
    }
    
    public void mostrarPanelAgregarArticulo( ) {
        panelVerInventario.setVisible(false);
        panelBuscarArticulo.setVisible(false);
        panelAgregarArticulo.setVisible(true);
        panelEliminarArticulo.setVisible(false);
        panelActualizarArticulo.setVisible(false);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelAgregarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 492, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelAgregarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 208, Short.MAX_VALUE))
        );
    }
    
    public void mostrarPanelVerInventario( ){
        panelVerInventario.setVisible(true);
        panelBuscarArticulo.setVisible(false);
        panelAgregarArticulo.setVisible(false);
        panelEliminarArticulo.setVisible(false);
        panelActualizarArticulo.setVisible(false);
          
       javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane( ) );
        getContentPane( ).setLayout( layout );
        layout.setHorizontalGroup(
            layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
            .addGroup( layout.createSequentialGroup( )
                .addComponent(panelVerInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE )
                .addContainerGap( 280, Short.MAX_VALUE) )
        );
        layout.setVerticalGroup(
            layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
            .addGroup( layout.createSequentialGroup( )
                .addComponent(panelVerInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE )
                .addContainerGap( 237, Short.MAX_VALUE) )
        );

    }
    
    public void mostrarPanelBuscarArticulo( ){
        panelBuscarArticulo.setVisible(true);
        panelAgregarArticulo.setVisible(false);
        panelEliminarArticulo.setVisible(false);
        panelActualizarArticulo.setVisible(false);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(566, Short.MAX_VALUE)
                .addComponent(panelBuscarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(panelBuscarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(180, Short.MAX_VALUE))
        );
     }
    
    public void mostrarPanelEliminarArticulo( ){
        panelBuscarArticulo.setVisible(false);
        panelAgregarArticulo.setVisible(false);
        panelEliminarArticulo.setVisible(true);
        panelActualizarArticulo.setVisible(false);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane( ) );
        getContentPane( ).setLayout( layout );
        layout.setHorizontalGroup(
            layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
            .addGroup( layout.createSequentialGroup( )
                .addGap (26, 26, 26 )
                .addComponent( panelEliminarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE )
                .addContainerGap( 282, Short.MAX_VALUE ) )
        );
        layout.setVerticalGroup(
            layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
            .addGroup( javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup( )
                .addContainerGap (342, Short.MAX_VALUE )
                .addComponent( panelEliminarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE )
                .addGap( 27, 27, 27 ) )
        );
     }
    
    
    public void mostrarPanelActualizarArticulo(  ){
        panelBuscarArticulo.setVisible(false);
        panelAgregarArticulo.setVisible(false);
        panelEliminarArticulo.setVisible(false);
        panelActualizarArticulo.setVisible(true);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(456, Short.MAX_VALUE)
                .addComponent(panelActualizarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelActualizarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 202, Short.MAX_VALUE))
        );
     }
    
    public PanelAgregarArticulo getPanelAgregarArticulo() {
        return panelAgregarArticulo;
    }

    public PanelBuscarArticulo getPanelBuscarArticulo() {
        return panelBuscarArticulo;
    }

    public PanelEliminarArticulo getPanelEliminarArticulo() {
        return panelEliminarArticulo;
    }

    public PanelVerInventario getPanelVerInventario() {
        return panelVerInventario;
    }

    public PanelActualizarArticulo getPanelActualizarArticulo() {
        return panelActualizarArticulo;
    }
    
}
