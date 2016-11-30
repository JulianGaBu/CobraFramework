/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

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

    private VentanaPrincipal ventanaPrincipal;
    private ControladorVentanaInventario controladorVentanaInventario;
    private ControladorVentanaProveedores controladorVentanaProveedores;
    private ControladorVentanaVentas controladorVentanaVentas;

    public void inicializarVentanaPrincipal() {
        ventanaPrincipal = new VentanaPrincipal();
        ventanaPrincipal.setVisible(true);
        agregarReceptorEventoBotonAgregarArticulo();
        agregarReceptorEventoBotonVerInventario();
        agregarReceptorEventoBotonVerProveedores();
        agregarReceptorEventoBotonAgregarProveedor();
        agregarReceptorEventoBotonVerVentas();
        agregarReceptorEventoBotonRealizarVenta();
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

    public void agregarReceptorEventoBotonVerVentas( ){
        JMenuItem botonVerVentar = ventanaPrincipal.getMenuItemVerVentas();
        botonVerVentar.addActionListener( ( java.awt.event.ActionEvent evt ) -> {
            inicializarPanelVerVentas();
        });
        ventanaPrincipal.setMenuItemVerVentas(botonVerVentar);
    }
    
    public void agregarReceptorEventoBotonRealizarVenta( ){
        JMenuItem botonRealizarVenta = ventanaPrincipal.getMenuItemRealizarVenta();
        botonRealizarVenta.addActionListener( ( java.awt.event.ActionEvent evt ) -> {
            inicializarPanelRealizarVenta();
        });
    }

    
    private void inicializarPanelVerInventario() throws SQLException {
        controladorVentanaInventario = new ControladorVentanaInventario();

        controladorVentanaInventario.desplegarPanelVerInventario();
        controladorVentanaInventario.agregarReceptorEventoBotonBuscarArticulo();
        controladorVentanaInventario.agregarReceptorEventoBotonEliminarArticulo();
        controladorVentanaInventario.agregarReceptorEventoBotonActualizarArticulo();

    }

    private void inicializarPanelAgregarArticulo() {
        controladorVentanaInventario = new ControladorVentanaInventario();
        controladorVentanaInventario.desplegarPanelAgregarArticulo();
    }

    private void inicializarPanelVerProveedores() throws SQLException {
        controladorVentanaProveedores = new ControladorVentanaProveedores();

        controladorVentanaProveedores.desplegarPanelVerProveedores();
        controladorVentanaProveedores.agregarReceptorEventoBotonBuscarProveedor();
        controladorVentanaProveedores.agregarReceptorEventoBotonEliminarProveedor();
        controladorVentanaProveedores.agregarReceptorEventoBotonActualizarProveedor();
    }

    private void inicializarPanelAgregarProveedores() {
        controladorVentanaProveedores = new ControladorVentanaProveedores();
        controladorVentanaProveedores.desplegarPanelAgregarProveedor();
    }

     private void inicializarPanelVerVentas( ){
        controladorVentanaVentas = new ControladorVentanaVentas();
        controladorVentanaVentas.desplegarPanelVerVentas();
     }
     
     private void inicializarPanelRealizarVenta( ){
        controladorVentanaVentas = new ControladorVentanaVentas();
        controladorVentanaVentas.desplegarPanelRealizarVenta();
     }
}
