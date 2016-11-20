/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresVentanas;

import Ventanas.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;

/**
 *
 * @author rodrigopeniche
 */
public class ControladorVentanaPrincipal {

    private static VentanaPrincipal ventanaPrincipal;
    private static ControladorVentanaPrincipal controladorVentanaPrincipal = null;
    
    private ControladorVentanaPrincipal(){
        ventanaPrincipal = new VentanaPrincipal();
    }
    
    public void inicializarVentanaPrincipal() {
        eventoBotonAgregarArticulo();
        eventoBotonVerInventario();
        eventoBotonVerProveedores();
        eventoBotonAgregarProveedor();
    }
    
    private static void generarControladorVentanaPrincipal( ){
        controladorVentanaPrincipal = new ControladorVentanaPrincipal();
    }
    
    public static ControladorVentanaPrincipal obtenerControladorVentanaPrincipal( ){
        if( controladorVentanaPrincipal == null ){
             generarControladorVentanaPrincipal();
        }
        ventanaPrincipal.setVisible(true);
        return controladorVentanaPrincipal;
    }

    public void eventoBotonVerInventario() {
        JMenuItem botonVerInventario = ventanaPrincipal.getMenuItemVerInventario();
        botonVerInventario.addActionListener((java.awt.event.ActionEvent evt) -> {
            try {
                inicializarPanelVerInventario();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        ventanaPrincipal.setMenuItemVerInventario(botonVerInventario);
    }

    public void eventoBotonAgregarArticulo() {
        JMenuItem botonAgregarArticulo = ventanaPrincipal.getMenuItemAgregarArticulo();
        botonAgregarArticulo.addActionListener((java.awt.event.ActionEvent evt) -> {
            inicializarPanelAgregarArticulo();
        });
        ventanaPrincipal.setMenuItemAgregarArticulo(botonAgregarArticulo);
    }

    public void eventoBotonVerProveedores() {
        JMenuItem botonVerProveedores = ventanaPrincipal.getMenuItemVerProveedores();
        botonVerProveedores.addActionListener((java.awt.event.ActionEvent evt) -> {
            try {
                inicializarPanelVerProveedores();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        ventanaPrincipal.setMenuItemVerProveedores(botonVerProveedores);
    }

    public void eventoBotonAgregarProveedor() {
        JMenuItem botonAgregarProveedor = ventanaPrincipal.getMenuItemAgregarProveedor();
        botonAgregarProveedor.addActionListener((java.awt.event.ActionEvent evt) -> {
            inicializarPanelAgregarProveedores();
        });
        ventanaPrincipal.setMenuItemAgregarProveedor(botonAgregarProveedor);
    }

//    public void agregarReceptorEventoBotonVerVentas( ){
//        JMenuItem botonVerVentar = ventanaPrincipal.getMenuItemVerVentas();
//        botonVerVentar.addActionListener( ( java.awt.event.ActionEvent evt ) -> {
//            clickVerVentas( evt );
//        });
//        ventanaPrincipal.setMenuItemVerVentas(botonVerVentar);
//    }
//    
//    public void agregarReceptorEventoBotonRealizarVenta( ){
//        JMenuItem botonRealizarVenta = ventanaPrincipal.getMenuItemRealizarVenta();
//        botonRealizarVenta.addActionListener( ( java.awt.event.ActionEvent evt ) -> {
//            clickRealizarVenta( evt );
//        });
//    }
//    private void clickVerVentas( ActionEvent evt ){
//        inicializarPanelVerVentas();
//    }
//    
//    private void clickRealizarVenta( ActionEvent evt ){
//        inicializarPanelRealizarVentas();
//    }
//    
    private void inicializarPanelVerInventario() throws SQLException {

        ControladorVentanaInventario.obtenerControladorVentanaInventario().mostrarPanelVerInventario();
        ControladorVentanaInventario.obtenerControladorVentanaInventario().eventoBotonBuscarArticulo();
        ControladorVentanaInventario.obtenerControladorVentanaInventario().eventoBotonEliminarArticulo();
        ControladorVentanaInventario.obtenerControladorVentanaInventario().eventoBotonActualizarArticulo();

    }

    private void inicializarPanelAgregarArticulo() {
        ControladorVentanaInventario.obtenerControladorVentanaInventario().mostrarPanelAgregarArticulo();
    }

    private void inicializarPanelVerProveedores() throws SQLException {

        ControladorVentanaProveedores.obtenerControladorVentanaInventario().mostrarPanelVerProveedores();
        ControladorVentanaProveedores.obtenerControladorVentanaInventario().eventoBotonBuscarProveedor();
        ControladorVentanaProveedores.obtenerControladorVentanaInventario().eventoBotonEliminarProveedor();
        ControladorVentanaProveedores.obtenerControladorVentanaInventario().eventoBotonActualizarProveedor();
    }

    private void inicializarPanelAgregarProveedores() {
        ControladorVentanaProveedores.obtenerControladorVentanaInventario().mostrarPanelAgregarProveedor();
    }

//     private void inicializarPanelVerVentas( ){
//        
//     }
//     
//     private void inicializarPanelRealizarVentas( ){
//         if( ventanaVentas == null ){
//             ventanaVentas = new VentanaVentas( );
//             ventanaVentas.setVisible( true );
//             ventanaVentas.mostrarPanelRealizarVentas( );
//         }
//         else{
//             ventanaVentas.setVisible( true );
//             ventanaVentas.mostrarPanelRealizarVentas( );
//         }
//
//     }
}
