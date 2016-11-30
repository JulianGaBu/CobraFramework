/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;


import Ventanas.Ventas.PanelRealizarVenta;
import Ventanas.Ventas.PanelVerVentas;
import Ventanas.Ventas.VentanaVentas;

/**
 *
 * @author rodrigopeniche
 */
public class ControladorVentanaVentas {
    
    private VentanaVentas ventanaVentas;
    private PanelRealizarVenta panelRealizarVenta;
    private PanelVerVentas panelVerVentas;
    
    public ControladorVentanaVentas(){
        ventanaVentas = new VentanaVentas();
        inicializarVentana();
    }
    
    void desplegarPanelRealizarVenta(){
        panelRealizarVenta = ventanaVentas.getPanelRealizarVenta();
        ventanaVentas.mostrarPanelRealizarVenta();
    }
    
    void desplegarPanelVerVentas(){
        panelVerVentas = ventanaVentas.getPanelVerVentas();
        ventanaVentas.mostrarPenalVerVentas();
    }
    
    
    
    
    
    
    
    private void inicializarVentana() {
        this.ventanaVentas = new VentanaVentas();
        this.ventanaVentas.setVisible(true);
    }
    
}
