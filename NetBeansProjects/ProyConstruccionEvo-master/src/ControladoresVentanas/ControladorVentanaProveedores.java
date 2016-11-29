/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresVentanas;

import AdministradoresDAO.AdministradorProveedores;
import Modelo.Proveedor;
import Ventanas.Proveedores.VentanaProveedores;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author rodrigopeniche
 */
public class ControladorVentanaProveedores {

    private static ControladorVentanaProveedores controladorVentanaProveedores = null;
    ArrayList<Proveedor> proveedores;

    private ControladorVentanaProveedores() {
        
    }
    
    private static void generarControladorVentanaProveedores( ){
        controladorVentanaProveedores = new ControladorVentanaProveedores();
    }
    
    public static ControladorVentanaProveedores obtenerControladorVentanaInventario( ){
        if( controladorVentanaProveedores == null ){
             generarControladorVentanaProveedores();
        }
        VentanaProveedores.obtenerVentanaProveedores().setVisible(true);
        return controladorVentanaProveedores;
    }

    protected void mostrarPanelVerProveedores() throws SQLException {
        VentanaProveedores.obtenerVentanaProveedores().mostrarPanelVerProveedores();

        try {
            obtenerProveedoresBD();
            llenarTablaProveedores(proveedores);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorVentanaInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void mostrarPanelAgregarProveedor() {
        VentanaProveedores.obtenerVentanaProveedores().mostrarPanelAgregarProveedor();
        agregarEventoBotonAgregarProveedor();
        agregarEventoBotonCancelarAgregacion();

    }
    
    private void obtenerProveedoresBD(){
        AdministradorProveedores  adminProveedores = new AdministradorProveedores();
        proveedores = adminProveedores.obtenerDatos();
    }
    
    private void llenarTablaProveedores(ArrayList<Proveedor> proveedores) throws SQLException, ClassNotFoundException {

        borrarContenidoTablaProveedores();
        
        for (int numProveedor = 0; numProveedor < proveedores.size(); numProveedor++) {
            VentanaProveedores.obtenerVentanaProveedores().getPanelVerProveedores().getContenidoTablaProveedores().addRow(new Object[]{proveedores.get(numProveedor).getClave(),
                proveedores.get(numProveedor).getNombre(),
                proveedores.get(numProveedor).getTelefono(),
                proveedores.get(numProveedor).getDireccion(),});
        }
    }
    
    private void actualizarTablaProveedores() throws SQLException, ClassNotFoundException {
        borrarContenidoTablaProveedores();
        llenarTablaProveedores(proveedores);
    }
    
    private void borrarContenidoTablaProveedores(){
        VentanaProveedores.obtenerVentanaProveedores().getPanelVerProveedores().getContenidoTablaProveedores().setRowCount(0);
    }

    protected void agregarEventoBotonBuscarProveedor() {
        JButton botonBuscar = VentanaProveedores.obtenerVentanaProveedores().getPanelVerProveedores().getBotonBuscar();

        botonBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VentanaProveedores.obtenerVentanaProveedores().mostrarPanelBuscarProveedor();
                agregarEventoBotonBuscar();
                eventoBotonCancelarBusqueda();
            }
        });
        VentanaProveedores.obtenerVentanaProveedores().getPanelBuscarProveedor().setBotonBuscar(botonBuscar);
    }

    protected void agregarEventoBotonEliminarProveedor() {
        JButton botonEliminar = VentanaProveedores.obtenerVentanaProveedores().getPanelVerProveedores().getBotonEliminar();

        botonEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VentanaProveedores.obtenerVentanaProveedores().mostrarPanelEliminarProveedor();
                agregarEventoBotonEliminar();
                agregaEventoBotonCancelarEliminacion();
            }
        });
        VentanaProveedores.obtenerVentanaProveedores().getPanelEliminarProveedor().setBotonEliminar(botonEliminar);
    }

    protected void agregarEventoBotonActualizarProveedor() {
        JButton botonActualizar = VentanaProveedores.obtenerVentanaProveedores().getPanelVerProveedores().getBotonActualizar();

        botonActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VentanaProveedores.obtenerVentanaProveedores().mostrarPanelActualizarProveedor();
                agregarEventoBotonActualizar();
                agregarEventoBotonCancelarActualizacion();
            }
        });
        VentanaProveedores.obtenerVentanaProveedores().getPanelVerProveedores().setBotonActualizar(botonActualizar);
    }

    protected void agregarEventoBotonEliminar() {
        JButton botonEliminar = VentanaProveedores.obtenerVentanaProveedores().getPanelEliminarProveedor().getBotonEliminar();

        botonEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accionarBotonEliminarProveedores();
            }
        });
        VentanaProveedores.obtenerVentanaProveedores().getPanelEliminarProveedor().setBotonEliminar(botonEliminar);
    }

    private void accionarBotonEliminarProveedores() {
        AdministradorProveedores adminProveedores = new AdministradorProveedores();
        String claveProveedor =  VentanaProveedores.obtenerVentanaProveedores().getPanelEliminarProveedor().getCampoTextoClave().getText();

        try {
            adminProveedores.eliminar(claveProveedor);
            actualizarTablaProveedores();
            
            JOptionPane.showMessageDialog(null, "Proveedor eliminado exitosamente");
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Hubo un error al actualizar el proveedor");
            Logger.getLogger(ControladorVentanaInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void agregaEventoBotonCancelarEliminacion() {
        JButton botonCancelarEliminacion = VentanaProveedores.obtenerVentanaProveedores().getPanelEliminarProveedor().getBotonCancelar();

        botonCancelarEliminacion.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VentanaProveedores.obtenerVentanaProveedores().getPanelEliminarProveedor().setVisible(false);
            }
        });
        VentanaProveedores.obtenerVentanaProveedores().getPanelEliminarProveedor().setBotonCancelar(botonCancelarEliminacion);
    }

    private void agregarEventoBotonAgregarProveedor() {
        JButton botonAgregar = VentanaProveedores.obtenerVentanaProveedores().getPanelAgregarProveedor().getBotonAgregar();
        botonAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accionarEventoBotonAgregarProveedor();
            }
        });
    }

    private void accionarEventoBotonAgregarProveedor() {
        String claveProveedor = VentanaProveedores.obtenerVentanaProveedores().getPanelAgregarProveedor().getCampoTextoClave().getText();
        String nombre = VentanaProveedores.obtenerVentanaProveedores().getPanelAgregarProveedor().getCampoTextoNombre().getText();
        String telefono = VentanaProveedores.obtenerVentanaProveedores().getPanelAgregarProveedor().getCampoTextoTel().getText();
        String direccion = VentanaProveedores.obtenerVentanaProveedores().getPanelAgregarProveedor().getCampoTextoDireccion().getText();

        AdministradorProveedores adminProveedores = new AdministradorProveedores();

        Proveedor proveedor = new Proveedor(claveProveedor, nombre, telefono, direccion);

        try {
            adminProveedores.agregar(proveedor);
            JOptionPane.showMessageDialog(null, "El proveedor se ha agregado exitosamente");
            vaciarCamposAgregarProveedor();
        } catch (HeadlessException createException) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al agregar el proveedor");
        }
    }

    private void agregarEventoBotonCancelarAgregacion() {
        JButton botonCancelar = VentanaProveedores.obtenerVentanaProveedores().getPanelAgregarProveedor().getBotonCancelar();

        botonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VentanaProveedores.obtenerVentanaProveedores().getPanelAgregarProveedor().setVisible(false);
                VentanaProveedores.obtenerVentanaProveedores().setVisible(false);
            }
        });
        VentanaProveedores.obtenerVentanaProveedores().getPanelAgregarProveedor().setBotonCancelar(botonCancelar);
    }

    private void agregarEventoBotonBuscar() {
        JButton botonBuscar = VentanaProveedores.obtenerVentanaProveedores().getPanelBuscarProveedor().getBotonBuscar();

        botonBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accionarBotonBuscarProveedor();
            }
        });
        VentanaProveedores.obtenerVentanaProveedores().getPanelBuscarProveedor().setBotonBuscar(botonBuscar);
    }

    private void accionarBotonBuscarProveedor() {
        VentanaProveedores.obtenerVentanaProveedores().getPanelBuscarProveedor().mostrarCampoTextoNombre();
        VentanaProveedores.obtenerVentanaProveedores().getPanelBuscarProveedor().mostrarCampoTextoTel();
        VentanaProveedores.obtenerVentanaProveedores().getPanelBuscarProveedor().mostrarCampoTextoDireccion();
        VentanaProveedores.obtenerVentanaProveedores().getPanelBuscarProveedor().mostrarEtiquetaNombre();
        VentanaProveedores.obtenerVentanaProveedores().getPanelBuscarProveedor().mostrarEtiquetaTel();
        VentanaProveedores.obtenerVentanaProveedores().getPanelBuscarProveedor().mostrarEtiquetaDireccion();

        String claveProveedor = VentanaProveedores.obtenerVentanaProveedores().getPanelBuscarProveedor().getCampoTextoClave().getText();
        AdministradorProveedores adminProveedores = new AdministradorProveedores();
        Proveedor proveedor = adminProveedores.buscar(claveProveedor);

        VentanaProveedores.obtenerVentanaProveedores().getPanelBuscarProveedor().setCampoTextoNombre(proveedor.getNombre());
        VentanaProveedores.obtenerVentanaProveedores().getPanelBuscarProveedor().setCampoTextoTel(proveedor.getTelefono());
        VentanaProveedores.obtenerVentanaProveedores().getPanelBuscarProveedor().setCampoTextoDireccion(proveedor.getDireccion());
    }

    private void eventoBotonCancelarBusqueda() {
        JButton botonCancelar = VentanaProveedores.obtenerVentanaProveedores().getPanelBuscarProveedor().getBotonCancelar();

        botonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VentanaProveedores.obtenerVentanaProveedores().getPanelBuscarProveedor().setVisible(false);
            }
        });
        VentanaProveedores.obtenerVentanaProveedores().getPanelBuscarProveedor().setBotonCancelar(botonCancelar);
    }

    private void agregarEventoBotonActualizar() {
        JButton botonActualizar = VentanaProveedores.obtenerVentanaProveedores().getPanelActualizarProveedor().getBotonGuardarCambios();
        botonActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accionarEventoBotonActualizarProveedor();
            }
        });
    }

    private void accionarEventoBotonActualizarProveedor() {

        String claveProveedor = VentanaProveedores.obtenerVentanaProveedores().getPanelActualizarProveedor().getCampoTextoClave().getText();
        String nuevoNombre = VentanaProveedores.obtenerVentanaProveedores().getPanelActualizarProveedor().getCampoTextoNombre().getText();
        String nuevoTel = VentanaProveedores.obtenerVentanaProveedores().getPanelActualizarProveedor().getCampoTextoTel().getText();
        String nuevaDireccion = VentanaProveedores.obtenerVentanaProveedores().getPanelActualizarProveedor().getCampoTextoDireccion().getText();

        Proveedor proveedor;
        proveedor = new Proveedor(claveProveedor, nuevoNombre, nuevoTel, nuevaDireccion);

        AdministradorProveedores adminProveedores = new AdministradorProveedores();

        try {
            adminProveedores.actualizar(proveedor);
            JOptionPane.showMessageDialog(null, "El artículo ha sido actualizado exitosamente");
        } catch (HeadlessException updateException) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el artículo");
        }

        try {
            actualizarTablaProveedores();
        } catch (SQLException | ClassNotFoundException ex) {
         
        }
    }

    private void agregarEventoBotonCancelarActualizacion() {
        JButton botonCancelar = VentanaProveedores.obtenerVentanaProveedores().getPanelActualizarProveedor().getBotonCancelar();
        botonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VentanaProveedores.obtenerVentanaProveedores().getPanelActualizarProveedor().setVisible(false);
            }
        });
        VentanaProveedores.obtenerVentanaProveedores().getPanelActualizarProveedor().setBotonCancelar(botonCancelar);
    }

    private void vaciarCamposAgregarProveedor() {
        VentanaProveedores.obtenerVentanaProveedores().getPanelAgregarProveedor().getCampoTextoClave().setText(null);
        VentanaProveedores.obtenerVentanaProveedores().getPanelAgregarProveedor().getCampoTextoNombre().setText(null);
        VentanaProveedores.obtenerVentanaProveedores().getPanelAgregarProveedor().getCampoTextoTel().setText(null);
        VentanaProveedores.obtenerVentanaProveedores().getPanelAgregarProveedor().getCampoTextoDireccion().setText(null);
    }
}
