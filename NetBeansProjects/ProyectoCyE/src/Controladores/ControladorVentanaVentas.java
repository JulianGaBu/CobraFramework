/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;


import Administradores.AdministradorInventario;
import Modelo.Articulo;
import Modelo.CarritoCompras;
import Ventanas.Ventas.PanelRealizarVenta;
import Ventanas.Ventas.PanelVerVentas;
import Ventanas.Ventas.VentanaVentas;
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
public class ControladorVentanaVentas {
    
    private VentanaVentas ventanaVentas;
    private PanelRealizarVenta panelRealizarVenta;
    private PanelVerVentas panelVerVentas;
    private CarritoCompras carritoCompras;
    
    public ControladorVentanaVentas(){
        ventanaVentas = new VentanaVentas();
        inicializarVentana();
    }
    
    void desplegarPanelRealizarVenta(){
        panelRealizarVenta = ventanaVentas.getPanelRealizarVenta();
        ventanaVentas.mostrarPanelRealizarVenta();
        carritoCompras = new CarritoCompras();
    }
    
    void desplegarPanelVerVentas(){
        panelVerVentas = ventanaVentas.getPanelVerVentas();
        ventanaVentas.mostrarPenalVerVentas();
    }
    
    void agregarEventoBotonAgregarAlCarrito() {
        panelRealizarVenta = ventanaVentas.getPanelRealizarVenta();
        JButton botonAgregar = panelRealizarVenta.getBotonAgregarCarrito();

        botonAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    accionarEventoBotonAgregarAlCarrito();
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorVentanaVentas.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ControladorVentanaVentas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        panelRealizarVenta.setBotonAgregarCarrito(botonAgregar);
    }
    
    private void accionarEventoBotonAgregarAlCarrito() throws SQLException, ClassNotFoundException{
        String claveArticulo;
        Articulo articulo;
        AdministradorInventario admin = new AdministradorInventario();
        
        claveArticulo = JOptionPane.showInputDialog("Ingrese la clave del articulo");
        articulo = admin.buscar(claveArticulo);
        carritoCompras.agregarAlCarrito(articulo);
        actualizarTablaCarrito();
        
    }
    
    private void llenarTablaCarrito(CarritoCompras carritoCompras) throws SQLException, ClassNotFoundException {
        ArrayList<Articulo> articulos = carritoCompras.getArticulosEnCarrito();
        
        for (int numArticulo = 0; numArticulo < articulos.size(); numArticulo++) {
            panelRealizarVenta.getContenidoTablaCarrito().addRow(new Object[]{articulos.get(numArticulo).getClaveArticulo(),
                articulos.get(numArticulo).getClaveProveedor(),
                articulos.get(numArticulo).getDescripcion(),
                articulos.get(numArticulo).getDetalleArticulo().getCantidad(),
                articulos.get(numArticulo).getDetalleArticulo().getPrecioCompra().getPrecio(),
                articulos.get(numArticulo).getDetalleArticulo().getPrecioVenta().getPrecio()
            });
        }
    }
    
    private void actualizarTablaCarrito() throws SQLException, ClassNotFoundException{
        borrarContenidoTablaCarrito();
        llenarTablaCarrito(carritoCompras);
    }
    
    private void borrarContenidoTablaCarrito(){
        panelRealizarVenta.getContenidoTablaCarrito().setRowCount(0);
    }
    
    void agregarEventoBotonEliminarDelCarrito(){
        panelRealizarVenta = ventanaVentas.getPanelRealizarVenta();
        JButton botonEliminar = panelRealizarVenta.getBotonEliminarDelCarrito();
        
        botonEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {    
                    accionarEventoBotonEliminarDelCarrito();
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorVentanaVentas.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ControladorVentanaVentas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        panelRealizarVenta.setBotonEliminarCarrito(botonEliminar);
    }
    
    private void accionarEventoBotonEliminarDelCarrito() throws SQLException, ClassNotFoundException{
        String claveArticulo;
        
        claveArticulo = JOptionPane.showInputDialog("Ingrese la clave del articulo");
        carritoCompras.eliminarDelCarrito(claveArticulo);
        actualizarTablaCarrito();
    }
    
    private void inicializarVentana() {
        this.ventanaVentas = new VentanaVentas();
        this.ventanaVentas.setVisible(true);
    }
    
}
