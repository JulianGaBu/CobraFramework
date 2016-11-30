/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Administradores.AdministradorProveedores;
import Modelo.Proveedor;
import Ventanas.Inventario.PanelActualizarArticulo;
import Ventanas.Proveedores.PanelActualizarProveedor;
import Ventanas.Proveedores.PanelAgregarProveedor;
import Ventanas.Proveedores.PanelBuscarProveedor;
import Ventanas.Proveedores.PanelEliminarProveedor;
import Ventanas.Proveedores.PanelVerProveedores;
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

    private VentanaProveedores ventanaProveedores;
    private PanelVerProveedores panelVerProveedores;
    private PanelAgregarProveedor panelAgregarProveedor;
    private PanelBuscarProveedor panelBuscarProveedor;
    private PanelEliminarProveedor panelEliminarProveedor;
    private PanelActualizarProveedor panelActualizarProveedor;
    
    private ArrayList<Proveedor> proveedores;

    public ControladorVentanaProveedores() {
        ventanaProveedores = new VentanaProveedores();
        inicializarVentana();
    }

    void desplegarPanelVerProveedores() throws SQLException {
        panelVerProveedores = ventanaProveedores.getPanelVerProveedores();
        ventanaProveedores.mostrarPanelVerProveedores();

        try {
            obtenerProveedoresBD();
            generarTablaProveedores(proveedores);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorVentanaInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void desplegarPanelAgregarProveedor() {
        panelAgregarProveedor = ventanaProveedores.getPanelAgregarProveedor();
        ventanaProveedores.mostrarPanelAgregarProveedor();
        agregarReceptorEventoBotonAgregarProveedor();
        agregarReceptorEventoBotonCancelarAgregacion();

    }
    
    private void obtenerProveedoresBD(){
        AdministradorProveedores admin = new AdministradorProveedores();
        proveedores = admin.obtenerDatos();
    }

    private void generarTablaProveedores(ArrayList<Proveedor> proveedores) throws SQLException, ClassNotFoundException {
        for (int numProveedor = 0; numProveedor < proveedores.size(); numProveedor++) {
            panelVerProveedores.getContenidoTablaProveedores().addRow(new Object[]{proveedores.get(numProveedor).getClave(),
                proveedores.get(numProveedor).getNombre(),
                proveedores.get(numProveedor).getTelefono(),
                proveedores.get(numProveedor).getDireccion(),});
        }
    }

    private void actualizarTablaProveedores() throws SQLException, ClassNotFoundException {
        borrarContenidoTablaArticulos();
        obtenerProveedoresBD();
        generarTablaProveedores(proveedores);
    }
    
    private void borrarContenidoTablaArticulos(){
        panelVerProveedores.getContenidoTablaProveedores().setRowCount(0);
    }

    void agregarReceptorEventoBotonBuscarProveedor() {
        panelVerProveedores = ventanaProveedores.getPanelVerProveedores();
        JButton botonBuscar = panelVerProveedores.getBotonBuscar();

        botonBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ventanaProveedores.mostrarPanelBuscarProveedor();
                agregarReceptorEventoBotonBuscar();
                agregarReceptorEventoBotonCancelarBusqueda();
            }
        });
        panelVerProveedores.setBotonBuscar(botonBuscar);
    }

    void agregarReceptorEventoBotonEliminarProveedor() {
        panelVerProveedores = ventanaProveedores.getPanelVerProveedores();
        JButton botonEliminar = panelVerProveedores.getBotonEliminar();

        botonEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ventanaProveedores.mostrarPanelEliminarProveedor();
                agregarReceptorEventoBotonEliminar();
                agregarReceptorEventoBotonCancelarEliminacion();
            }
        });
        panelVerProveedores.setBotonEliminar(botonEliminar);
    }

    void agregarReceptorEventoBotonActualizarProveedor() {
        panelVerProveedores = ventanaProveedores.getPanelVerProveedores();
        JButton botonActualizar = panelVerProveedores.getBotonActualizar();

        botonActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ventanaProveedores.mostrarPanelActualizarProveedor();
                agregarReceptorEventoBotonActualizar();
                agregarReceptorEventoBotonCancelarActualizacion();
            }
        });
        panelVerProveedores.setBotonActualizar(botonActualizar);
    }

    void agregarReceptorEventoBotonEliminar() {
        panelEliminarProveedor = ventanaProveedores.getPanelEliminarProveedor();
        JButton botonEliminar = panelEliminarProveedor.getBotonEliminar();

        botonEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accionarBotonEliminarProveedor();
            }
        });
        panelEliminarProveedor.setBotonEliminar(botonEliminar);
    }

    private void accionarBotonEliminarProveedor() {
        AdministradorProveedores adminProveedores = new AdministradorProveedores();
        String claveProveedor = panelEliminarProveedor.getCampoTextoClave().getText();

        try {
            adminProveedores.eliminar(claveProveedor);
            actualizarTablaProveedores();
            JOptionPane.showMessageDialog(null, "Proveedor eliminado exitosamente");
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Hubo un error al actualizar el proveedor");
            Logger.getLogger(ControladorVentanaInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void agregarReceptorEventoBotonCancelarEliminacion() {
        panelEliminarProveedor = ventanaProveedores.getPanelEliminarProveedor();
        JButton botonCancelarEliminacion = panelEliminarProveedor.getBotonCancelar();

        botonCancelarEliminacion.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelEliminarProveedor.setVisible(false);
            }
        });
        panelEliminarProveedor.setBotonCancelar(botonCancelarEliminacion);
    }

    private void agregarReceptorEventoBotonAgregarProveedor() {
        panelAgregarProveedor = ventanaProveedores.getPanelAgregarProveedor();
        JButton botonAgregar = panelAgregarProveedor.getBotonAgregar();
        botonAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agregarProveedor();
            }
        });
    }

    private void agregarProveedor() {
        String claveProveedor = panelAgregarProveedor.getCampoTextoClave().getText();
        String nombre = panelAgregarProveedor.getCampoTextoNombre().getText();
        String telefono = panelAgregarProveedor.getCampoTextoTel().getText();
        String direccion = panelAgregarProveedor.getCampoTextoDireccion().getText();

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

    private void agregarReceptorEventoBotonCancelarAgregacion() {
        panelAgregarProveedor = ventanaProveedores.getPanelAgregarProveedor();
        JButton botonCancelar = panelAgregarProveedor.getBotonCancelar();

        botonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelAgregarProveedor.setVisible(false);
            }
        });
        panelAgregarProveedor.setBotonCancelar(botonCancelar);
    }

    private void agregarReceptorEventoBotonBuscar() {
        panelBuscarProveedor = ventanaProveedores.getPanelBuscarProveedor();
        JButton botonBuscar = panelBuscarProveedor.getBotonBuscar();

        botonBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accionarBotonBuscarProveedor();
            }
        });
        panelBuscarProveedor.setBotonBuscar(botonBuscar);
    }

    private void accionarBotonBuscarProveedor() {
        panelBuscarProveedor.mostrarCampoTextoNombre();
        panelBuscarProveedor.mostrarCampoTextoTel();
        panelBuscarProveedor.mostrarCampoTextoDireccion();
        panelBuscarProveedor.mostrarEtiquetaNombre();
        panelBuscarProveedor.mostrarEtiquetaTel();
        panelBuscarProveedor.mostrarEtiquetaDireccion();

        String claveProveedor = panelBuscarProveedor.getCampoTextoClave().getText();
        AdministradorProveedores adminProveedores = new AdministradorProveedores();
        Proveedor proveedor = adminProveedores.buscar(claveProveedor);

        panelBuscarProveedor.setCampoTextoNombre(proveedor.getNombre());
        panelBuscarProveedor.setCampoTextoTel(proveedor.getTelefono());
        panelBuscarProveedor.setCampoTextoDireccion(proveedor.getDireccion());
    }

    private void agregarReceptorEventoBotonCancelarBusqueda() {
        panelBuscarProveedor = ventanaProveedores.getPanelBuscarProveedor();
        JButton botonCancelar = panelBuscarProveedor.getBotonCancelar();

        botonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelBuscarProveedor.setVisible(false);
            }
        });
        panelBuscarProveedor.setBotonCancelar(botonCancelar);
    }

    private void agregarReceptorEventoBotonActualizar() {
        panelActualizarProveedor = ventanaProveedores.getPanelActualizarProveedor();
        JButton botonActualizar = panelActualizarProveedor.getBotonGuardarCambios();
        botonActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accionarBotonActualizarProveedor();
            }
        });
    }

    private void accionarBotonActualizarProveedor() {

        String claveProveedor = panelActualizarProveedor.getCampoTextoClave().getText();
        String nuevoNombre = panelActualizarProveedor.getCampoTextoNombre().getText();
        String nuevoTel = panelActualizarProveedor.getCampoTextoTel().getText();
        String nuevaDireccion = panelActualizarProveedor.getCampoTextoDireccion().getText();

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
            Logger.getLogger(PanelActualizarArticulo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void agregarReceptorEventoBotonCancelarActualizacion() {
        panelActualizarProveedor = ventanaProveedores.getPanelActualizarProveedor();
        JButton botonCancelar = panelActualizarProveedor.getBotonCancelar();
        botonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelActualizarProveedor.setVisible(false);
            }
        });
        panelActualizarProveedor.setBotonCancelar(botonCancelar);
    }

    private void vaciarCamposAgregarProveedor() {
        panelAgregarProveedor.getCampoTextoClave().setText(null);
        panelAgregarProveedor.getCampoTextoNombre().setText(null);
        panelAgregarProveedor.getCampoTextoTel().setText(null);
        panelAgregarProveedor.getCampoTextoDireccion().setText(null);
    }

    public VentanaProveedores getVentanaProveedores() {
        return ventanaProveedores;
    }

    private void inicializarVentana() {
        this.ventanaProveedores = new VentanaProveedores();
        this.ventanaProveedores.setVisible(true);
    }
}
