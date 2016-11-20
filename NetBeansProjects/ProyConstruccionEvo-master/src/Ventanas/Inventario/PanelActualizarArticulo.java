/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas.Inventario;

/**
 *
 * @author rodrigopeniche
 */
public class PanelActualizarArticulo extends javax.swing.JPanel {
    
    /**
     * Creates new form PanelActualizarArticulo
     */
    
    public PanelActualizarArticulo(  ) {
        initComponents( );
    }
    

    /*
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etiquetaIngresarClave = new javax.swing.JLabel();
        campoTextoClave = new javax.swing.JTextField();
        etiquetaDescripcion = new javax.swing.JLabel();
        etiquetaCantidad = new javax.swing.JLabel();
        etiquetaPrecio = new javax.swing.JLabel();
        campoTextoDescripcion = new javax.swing.JTextField();
        campoTextoCantidad = new javax.swing.JTextField();
        campoTextoPrecioCompra = new javax.swing.JTextField();
        botonGuardarCambios = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        etiquetaClaveProveedor = new javax.swing.JLabel();
        campoTextoClaveProveedor = new javax.swing.JTextField();
        etiquetaPrecioVenta = new javax.swing.JLabel();
        campoTextoPrecioVenta = new javax.swing.JTextField();

        etiquetaIngresarClave.setText("Ingrese la clave del producto a actualizar:");

        etiquetaDescripcion.setText("Descripcion");

        etiquetaCantidad.setText("Cantidad");

        etiquetaPrecio.setText("Precio compra");

        campoTextoCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoTextoCantidadKeyTyped(evt);
            }
        });

        botonGuardarCambios.setText("Guardar Cambios");

        botonCancelar.setText("Cancelar");

        etiquetaClaveProveedor.setText("Clave de proveedor");

        etiquetaPrecioVenta.setText("Precio venta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etiquetaDescripcion)
                                    .addComponent(etiquetaCantidad)
                                    .addComponent(etiquetaPrecio)
                                    .addComponent(etiquetaPrecioVenta))
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(campoTextoCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                    .addComponent(campoTextoPrecioCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                    .addComponent(campoTextoDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                    .addComponent(campoTextoPrecioVenta)))
                            .addComponent(botonGuardarCambios)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaClaveProveedor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(campoTextoClaveProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2))
                            .addComponent(campoTextoClave, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiquetaIngresarClave)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(157, 157, 157)
                                .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(etiquetaIngresarClave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoTextoClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(campoTextoClaveProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(etiquetaClaveProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(etiquetaDescripcion)
                                    .addComponent(campoTextoDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(etiquetaCantidad))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(campoTextoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(campoTextoPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(etiquetaPrecio))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiquetaPrecioVenta)
                            .addComponent(campoTextoPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 69, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonCancelar)
                            .addComponent(botonGuardarCambios))
                        .addGap(20, 20, 20))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void campoTextoCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTextoCantidadKeyTyped
        char caracterTecleado = evt.getKeyChar();
        if(!Character.isDigit(caracterTecleado)){
            evt.consume();
        }
    }//GEN-LAST:event_campoTextoCantidadKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonGuardarCambios;
    private javax.swing.JTextField campoTextoCantidad;
    private javax.swing.JTextField campoTextoClave;
    private javax.swing.JTextField campoTextoClaveProveedor;
    private javax.swing.JTextField campoTextoDescripcion;
    private javax.swing.JTextField campoTextoPrecioCompra;
    private javax.swing.JTextField campoTextoPrecioVenta;
    private javax.swing.JLabel etiquetaCantidad;
    private javax.swing.JLabel etiquetaClaveProveedor;
    private javax.swing.JLabel etiquetaDescripcion;
    private javax.swing.JLabel etiquetaIngresarClave;
    private javax.swing.JLabel etiquetaPrecio;
    private javax.swing.JLabel etiquetaPrecioVenta;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the botonCancelar
     */
    public javax.swing.JButton getBotonCancelar() {
        return botonCancelar;
    }

    /**
     * @param botonCancelar the botonCancelar to set
     */
    public void setBotonCancelar(javax.swing.JButton botonCancelar) {
        this.botonCancelar = botonCancelar;
    }

    /**
     * @return the botonGuardarCambios
     */
    public javax.swing.JButton getBotonGuardarCambios() {
        return botonGuardarCambios;
    }

    /**
     * @param botonGuardarCambios the botonGuardarCambios to set
     */
    public void setBotonGuardarCambios(javax.swing.JButton botonGuardarCambios) {
        this.botonGuardarCambios = botonGuardarCambios;
    }

    /**
     * @return the campoTextoCantidad
     */
    public javax.swing.JTextField getCampoTextoCantidad() {
        return campoTextoCantidad;
    }

    /**
     * @param campoTextoCantidad the campoTextoCantidad to set
     */
    public void setCampoTextoCantidad(javax.swing.JTextField campoTextoCantidad) {
        this.campoTextoCantidad = campoTextoCantidad;
    }

    /**
     * @return the campoTextoClave
     */
    public javax.swing.JTextField getCampoTextoClave() {
        return campoTextoClave;
    }

    /**
     * @param campoTextoClave the campoTextoClave to set
     */
    public void setCampoTextoClave(javax.swing.JTextField campoTextoClave) {
        this.campoTextoClave = campoTextoClave;
    }

    /**
     * @return the campoTextoClaveProveedor
     */
    public javax.swing.JTextField getCampoTextoClaveProveedor() {
        return campoTextoClaveProveedor;
    }

    /**
     * @param campoTextoClaveProveedor the campoTextoClaveProveedor to set
     */
    public void setCampoTextoClaveProveedor(javax.swing.JTextField campoTextoClaveProveedor) {
        this.campoTextoClaveProveedor = campoTextoClaveProveedor;
    }

    /**
     * @return the campoTextoDescripcion
     */
    public javax.swing.JTextField getCampoTextoDescripcion() {
        return campoTextoDescripcion;
    }

    /**
     * @param campoTextoDescripcion the campoTextoDescripcion to set
     */
    public void setCampoTextoDescripcion(javax.swing.JTextField campoTextoDescripcion) {
        this.campoTextoDescripcion = campoTextoDescripcion;
    }

    /**
     * @return the campoTextoPrecioCompra
     */
    public javax.swing.JTextField getCampoTextoPrecioCompra() {
        return campoTextoPrecioCompra;
    }

    /**
     * @param campoTextoPrecioCompra the campoTextoPrecioCompra to set
     */
    public void setCampoTextoPrecioCompra(javax.swing.JTextField campoTextoPrecioCompra) {
        this.campoTextoPrecioCompra = campoTextoPrecioCompra;
    }

    /**
     * @return the campoTextoPrecioVenta
     */
    public javax.swing.JTextField getCampoTextoPrecioVenta() {
        return campoTextoPrecioVenta;
    }

    /**
     * @param campoTextoPrecioVenta the campoTextoPrecioVenta to set
     */
    public void setCampoTextoPrecioVenta(javax.swing.JTextField campoTextoPrecioVenta) {
        this.campoTextoPrecioVenta = campoTextoPrecioVenta;
    }

    /**
     * @return the etiquetaCantidad
     */
    public javax.swing.JLabel getEtiquetaCantidad() {
        return etiquetaCantidad;
    }

    /**
     * @param etiquetaCantidad the etiquetaCantidad to set
     */
    public void setEtiquetaCantidad(javax.swing.JLabel etiquetaCantidad) {
        this.etiquetaCantidad = etiquetaCantidad;
    }

    /**
     * @return the etiquetaClaveProveedor
     */
    public javax.swing.JLabel getEtiquetaClaveProveedor() {
        return etiquetaClaveProveedor;
    }

    /**
     * @param etiquetaClaveProveedor the etiquetaClaveProveedor to set
     */
    public void setEtiquetaClaveProveedor(javax.swing.JLabel etiquetaClaveProveedor) {
        this.etiquetaClaveProveedor = etiquetaClaveProveedor;
    }

    /**
     * @return the etiquetaDescripcion
     */
    public javax.swing.JLabel getEtiquetaDescripcion() {
        return etiquetaDescripcion;
    }

    /**
     * @param etiquetaDescripcion the etiquetaDescripcion to set
     */
    public void setEtiquetaDescripcion(javax.swing.JLabel etiquetaDescripcion) {
        this.etiquetaDescripcion = etiquetaDescripcion;
    }

    /**
     * @return the etiquetaIngresarClave
     */
    public javax.swing.JLabel getEtiquetaIngresarClave() {
        return etiquetaIngresarClave;
    }

    /**
     * @param etiquetaIngresarClave the etiquetaIngresarClave to set
     */
    public void setEtiquetaIngresarClave(javax.swing.JLabel etiquetaIngresarClave) {
        this.etiquetaIngresarClave = etiquetaIngresarClave;
    }

    /**
     * @return the etiquetaPrecio
     */
    public javax.swing.JLabel getEtiquetaPrecio() {
        return etiquetaPrecio;
    }

    /**
     * @param etiquetaPrecio the etiquetaPrecio to set
     */
    public void setEtiquetaPrecio(javax.swing.JLabel etiquetaPrecio) {
        this.etiquetaPrecio = etiquetaPrecio;
    }

    /**
     * @return the etiquetaPrecioVenta
     */
    public javax.swing.JLabel getEtiquetaPrecioVenta() {
        return etiquetaPrecioVenta;
    }

    /**
     * @param etiquetaPrecioVenta the etiquetaPrecioVenta to set
     */
    public void setEtiquetaPrecioVenta(javax.swing.JLabel etiquetaPrecioVenta) {
        this.etiquetaPrecioVenta = etiquetaPrecioVenta;
    }
}
