/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas.Proveedores;
/**
 *
 * @author rodrigopeniche
 */
public class PanelActualizarProveedor extends javax.swing.JPanel {

    
    /**
     * Creates new form PanelActualizarProveedor
     */
    
    public PanelActualizarProveedor( ) {
        initComponents( );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etiquetaInstruccion = new javax.swing.JLabel();
        campoTextoClave = new javax.swing.JTextField();
        etiquetaNombre = new javax.swing.JLabel();
        campoTextoNombre = new javax.swing.JTextField();
        etiquetaTel = new javax.swing.JLabel();
        campoTextoTel = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        etiquetaDireccion = new javax.swing.JLabel();
        campoTextoDireccion = new javax.swing.JTextField();
        botonGuardarCambios = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();

        etiquetaInstruccion.setText("Ingresa la clave del proveedor a actualizar:");

        etiquetaNombre.setText("Nombre:");

        etiquetaTel.setText("Teléfono:");

        etiquetaDireccion.setText("Dirección:");

        botonGuardarCambios.setText("Guardar cambios");

        botonCancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(etiquetaNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(campoTextoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(etiquetaTel)
                                    .addComponent(etiquetaDireccion))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(campoTextoDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                    .addComponent(campoTextoTel))))
                        .addGap(78, 78, 78))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoTextoClave, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiquetaInstruccion)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(botonGuardarCambios)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(55, 55, 55)
                                .addComponent(botonCancelar)))
                        .addContainerGap(86, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(etiquetaInstruccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoTextoClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaNombre)
                    .addComponent(campoTextoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaTel)
                    .addComponent(campoTextoTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaDireccion)
                    .addComponent(campoTextoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGuardarCambios)
                    .addComponent(botonCancelar))
                .addContainerGap(59, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonGuardarCambios;
    public javax.swing.JTextField campoTextoClave;
    private javax.swing.JTextField campoTextoDireccion;
    private javax.swing.JTextField campoTextoNombre;
    private javax.swing.JTextField campoTextoTel;
    private javax.swing.JLabel etiquetaDireccion;
    private javax.swing.JLabel etiquetaInstruccion;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JLabel etiquetaTel;
    private javax.swing.JLabel jLabel2;
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
     * @return the campoTextoDireccion
     */
    public javax.swing.JTextField getCampoTextoDireccion() {
        return campoTextoDireccion;
    }

    /**
     * @param campoTextoDireccion the campoTextoDireccion to set
     */
    public void setCampoTextoDireccion(javax.swing.JTextField campoTextoDireccion) {
        this.campoTextoDireccion = campoTextoDireccion;
    }

    /**
     * @return the campoTextoNombre
     */
    public javax.swing.JTextField getCampoTextoNombre() {
        return campoTextoNombre;
    }

    /**
     * @param campoTextoNombre the campoTextoNombre to set
     */
    public void setCampoTextoNombre(javax.swing.JTextField campoTextoNombre) {
        this.campoTextoNombre = campoTextoNombre;
    }

    /**
     * @return the campoTextoTel
     */
    public javax.swing.JTextField getCampoTextoTel() {
        return campoTextoTel;
    }

    /**
     * @param campoTextoTel the campoTextoTel to set
     */
    public void setCampoTextoTel(javax.swing.JTextField campoTextoTel) {
        this.campoTextoTel = campoTextoTel;
    }

    /**
     * @return the etiquetaNombre
     */
    public javax.swing.JLabel getEtiquetaNombre() {
        return etiquetaNombre;
    }

    /**
     * @param etiquetaNombre the etiquetaNombre to set
     */
    public void setEtiquetaNombre(javax.swing.JLabel etiquetaNombre) {
        this.etiquetaNombre = etiquetaNombre;
    }

    /**
     * @return the etiquetaTel
     */
    public javax.swing.JLabel getEtiquetaTel() {
        return etiquetaTel;
    }

    /**
     * @param etiquetaTel the etiquetaTel to set
     */
    public void setEtiquetaTel(javax.swing.JLabel etiquetaTel) {
        this.etiquetaTel = etiquetaTel;
    }

    /**
     * @return the jLabel1
     */
    public javax.swing.JLabel getEtiquetaInstruccion() {
        return etiquetaInstruccion;
    }

    /**
     * @param jLabel1 the jLabel1 to set
     */
    public void setEtiquetaInstruccion(javax.swing.JLabel jLabel1) {
        this.etiquetaInstruccion = jLabel1;
    }

    /**
     * @return the jLabel3
     */
    public javax.swing.JLabel getEtiquetaDireccion() {
        return etiquetaDireccion;
    }

    /**
     * @param jLabel3 the jLabel3 to set
     */
    public void setEtiquetaDireccion(javax.swing.JLabel jLabel3) {
        this.etiquetaDireccion = jLabel3;
    }
}
