/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

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

    private VentanaPrincipal ventanaPrincipal;
    private ControladorVentanaInventario controladorVentanaInventario;
    private ControladorVentanaProveedores controladorVentanaProveedores;

    public void inicializarVentanaPrincipal() {
        ventanaPrincipal = new VentanaPrincipal();
        ventanaPrincipal.setVisible(true);
        agregarReceptorEventoBotonAgregarArticulo();
        agregarReceptorEventoBotonVerInventario();
        agregarReceptorEventoBotonVerProveedores();
        agregarReceptorEventoBotonAgregarProveedor();
    }

    public void agregarReceptorEventoBotonVerInventario() {
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

    public void agregarReceptorEventoBotonAgregarArticulo() {
        JMenuItem botonAgregarArticulo = ventanaPrincipal.getMenuItemAgregarArticulo();
        botonAgregarArticulo.addActionListener((java.awt.event.ActionEvent evt) -> {
            inicializarPanelAgregarArticulo();
        });
        ventanaPrincipal.setMenuItemAgregarArticulo(botonAgregarArticulo);
    }

    public void agregarReceptorEventoBotonVerProveedores() {
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

    public void agregarReceptorEventoBotonAgregarProveedor() {
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
        controladorVentanaInventario = new ControladorVentanaInventario();

        controladorVentanaInventario.mostrarPanelVerInventario();
        controladorVentanaInventario.agregarReceptorEventoBotonBuscarArticulo();
        controladorVentanaInventario.agregarReceptorEventoBotonEliminarArticulo();
        controladorVentanaInventario.agregarReceptorEventoBotonActualizarArticulo();

    }

    private void inicializarPanelAgregarArticulo() {
        controladorVentanaInventario = new ControladorVentanaInventario();
        controladorVentanaInventario.mostrarPanelAgregarArticulo();
    }

    private void inicializarPanelVerProveedores() throws SQLException {
        controladorVentanaProveedores = new ControladorVentanaProveedores();

        controladorVentanaProveedores.mostrarPanelVerProveedores();
        controladorVentanaProveedores.agregarReceptorEventoBotonBuscarProveedor();
        controladorVentanaProveedores.agregarReceptorEventoBotonEliminarProveedor();
        controladorVentanaProveedores.agregarReceptorEventoBotonActualizarProveedor();
    }

    private void inicializarPanelAgregarProveedores() {
        controladorVentanaProveedores = new ControladorVentanaProveedores();
        controladorVentanaProveedores.mostrarPanelAgregarProveedor();
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
