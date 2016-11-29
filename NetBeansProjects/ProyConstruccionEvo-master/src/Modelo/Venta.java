/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author rodrigopeniche
 */
public class Venta {
    

    private String clave;
    private final ArrayList<Articulo> articulosVendidos;
    private final double montoVenta;
    private double ganancia;
    private Calendar fecha;
    
    public Venta(ArrayList<Articulo> articulosVendidos){
        this.articulosVendidos= articulosVendidos;
        this.fecha = new GregorianCalendar();
        this.montoVenta = 0;
    }
    
    public String getClave(){
        return clave;
    }

    public ArrayList<Articulo> getArticulosVendidos() {
        return articulosVendidos;
    }
    
    public double getMontoVenta() {
        return montoVenta;
    }

    public double getGanancia() {
        return ganancia;
    }

    public Calendar getFecha() {
        return fecha;
    }
       
}
