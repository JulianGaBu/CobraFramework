/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author rodrigopeniche
 */
public class Venta {
    

    private String clave;
    private final ArrayList<Articulo> articulosVendidos;
    private double montoVenta;
    private double ganancia;
    private Date fecha;
    private Empleado empleado;

  
    public Venta(ArrayList<Articulo> articulosVendidos){
        this.articulosVendidos= articulosVendidos;
        this.fecha = new Date();
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

    public Date getFecha() {
        return fecha;
    }
    
    public Empleado getEmpleado() {
        return empleado;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public void setMonto(double monto){
        this.montoVenta= monto;
    }

    public void setGanancia(double ganancia) {
        this.ganancia = ganancia;
    }
    

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    public void setFecha(Date fecha){
        this.fecha = fecha;
    }
    
       
}
