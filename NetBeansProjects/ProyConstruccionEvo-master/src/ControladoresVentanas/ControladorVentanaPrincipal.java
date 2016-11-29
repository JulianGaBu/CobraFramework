/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresVentanas;

import Ventanas.VentanaPrincipal;
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
        agregarEventoBotonAgregarArticulo();
        agregarEventoBotonVerInventario();
        agregarEventoVerProveedores();
        agregarEventoBotonAgregarProveedor();
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

    public void agregarEventoBotonVerInventario() {
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

    public void agregarEventoBotonAgregarArticulo() {
        JMenuItem botonAgregarArticulo = ventanaPrincipal.getMenuItemAgregarArticulo();
        
        botonAgregarArticulo.addActionListener((java.awt.event.ActionEvent evt) -> {
            inicializarPanelAgregarArticulo();
        });
        
        ventanaPrincipal.setMenuItemAgregarArticulo(botonAgregarArticulo);
    }

    public void agregarEventoVerProveedores() {
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

    public void agregarEventoBotonAgregarProveedor() {
        JMenuItem botonAgregarProveedor = ventanaPrincipal.getMenuItemAgregarProveedor();
        
        botonAgregarProveedor.addActionListener((java.awt.event.ActionEvent evt) -> {
            inicializarPanelAgregarProveedores();
        });
        
        ventanaPrincipal.setMenuItemAgregarProveedor(botonAgregarProveedor);
    }

    public void agregarReceptorEventoBotonVerVentas( ){
        JMenuItem botonVerVentas = ventanaPrincipal.getMenuItemVerVentas();
        botonVerVentas.addActionListener( ( java.awt.event.ActionEvent evt ) -> {
            inicializarPanelVerVentas();
        });
        ventanaPrincipal.setMenuItemVerVentas(botonVerVentas);
    }
    
    public void agregarReceptorEventoBotonRealizarVenta( ){
        JMenuItem botonRealizarVenta = ventanaPrincipal.getMenuItemRealizarVenta();
        botonRealizarVenta.addActionListener( ( java.awt.event.ActionEvent evt ) -> {
            inicializarPanelVerVentas();
        });
    }

    
    private void inicializarPanelVerInventario() throws SQLException {

        ControladorVentanaInventario.obtenerControladorVentanaInventario().mostrarPanelVerInventario();
        ControladorVentanaInventario.obtenerControladorVentanaInventario().agregarEventoBotonBuscarArticulo();
        ControladorVentanaInventario.obtenerControladorVentanaInventario().agregarEventoBotonEliminarArticulo();
        ControladorVentanaInventario.obtenerControladorVentanaInventario().agregarEventoBotonActualizarArticulo();

    }

    private void inicializarPanelAgregarArticulo() {
        ControladorVentanaInventario.obtenerControladorVentanaInventario().mostrarPanelAgregarArticulo();
    }

    private void inicializarPanelVerProveedores() throws SQLException {

        ControladorVentanaProveedores.obtenerControladorVentanaInventario().mostrarPanelVerProveedores();
        ControladorVentanaProveedores.obtenerControladorVentanaInventario().agregarEventoBotonBuscarProveedor();
        ControladorVentanaProveedores.obtenerControladorVentanaInventario().agregarEventoBotonEliminarProveedor();
        ControladorVentanaProveedores.obtenerControladorVentanaInventario().agregarEventoBotonActualizarProveedor();
    }

    private void inicializarPanelAgregarProveedores() {
        ControladorVentanaProveedores.obtenerControladorVentanaInventario().mostrarPanelAgregarProveedor();
    }

     private void inicializarPanelVerVentas( ){
        
     }
     
     private void inicializarPanelRealizarVentas( ){

     }
}
