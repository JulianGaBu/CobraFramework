/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas.Proveedores;

import AdministradoresDAO.AdministradorProveedores;

/**
 *
 * @author rodrigopeniche
 */
public class PanelEliminarProveedor extends javax.swing.JPanel {

    /**
     * Creates new form PanelEliminarProveedor
     */
    
    public PanelEliminarProveedor( ) {
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

        etiquetaEliminar = new javax.swing.JLabel();
        etiquetaClave = new javax.swing.JLabel();
        campoTextoClave = new javax.swing.JTextField();
        botonEliminar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();

        etiquetaEliminar.setText("Eliminar proveedor");

        etiquetaClave.setText("Clave:");

        botonEliminar.setText("Eliminar proveedor");

        botonCancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiquetaEliminar)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etiquetaClave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonEliminar)
                                .addGap(76, 76, 76)
                                .addComponent(botonCancelar))
                            .addComponent(campoTextoClave, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiquetaEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaClave)
                    .addComponent(campoTextoClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonEliminar)
                    .addComponent(botonCancelar))
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JTextField campoTextoClave;
    private javax.swing.JLabel etiquetaClave;
    private javax.swing.JLabel etiquetaEliminar;
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
     * @return the botonEliminar
     */
    public javax.swing.JButton getBotonEliminar() {
        return botonEliminar;
    }

    /**
     * @param botonEliminar the botonEliminar to set
     */
    public void setBotonEliminar(javax.swing.JButton botonEliminar) {
        this.botonEliminar = botonEliminar;
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
     * @return the etiquetaClave
     */
    public javax.swing.JLabel getEtiquetaClave() {
        return etiquetaClave;
    }

    /**
     * @param etiquetaClave the etiquetaClave to set
     */
    public void setEtiquetaClave(javax.swing.JLabel etiquetaClave) {
        this.etiquetaClave = etiquetaClave;
    }

    /**
     * @return the etiquetaEliminar
     */
    public javax.swing.JLabel getEtiquetaEliminar() {
        return etiquetaEliminar;
    }

    /**
     * @param etiquetaEliminar the etiquetaEliminar to set
     */
    public void setEtiquetaEliminar(javax.swing.JLabel etiquetaEliminar) {
        this.etiquetaEliminar = etiquetaEliminar;
    }
}
