/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaGUI;

import CapaDTO.Usuario;
import CapaNegocio.NegocioUsuario;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cristobal
 */
public class PantallaUsuario extends javax.swing.JFrame {

    /**
     * Creates new form PantallaUsuario
     */
    public PantallaUsuario() {
        initComponents();
        this.setLocationRelativeTo(null);
        txtIDUsuario.setVisible(false);
        ListarUsuario();
    }
    
    Usuario usuario = new Usuario();
    
    NegocioUsuario nu = new NegocioUsuario();
    
    DefaultTableModel modelo = new DefaultTableModel();
    
    //LIMPIAR USUARIO
     private void LimpiarUsuario(){
        txtIDUsuario.setText("");
        txtRutUsuario.setText("");
        txtNombreUsuario.setText("");
        txtCorreoUsuario.setText("");
        txtContraseñaUsuario.setText("");

    }
     
    
     
    
    public void ListarUsuario(){
        modelo = (DefaultTableModel) this.tableListarUsuario.getModel();

        modelo.setNumRows(0);
        int fila =0;

        Iterator iter = nu.ListarUsuario().iterator();
        while(iter.hasNext()){
            usuario = (Usuario) iter.next();
            Object[] num ={};
            modelo.addRow(num);
            this.tableListarUsuario.setValueAt(usuario.getIdUsuario(), fila, 0);
            this.tableListarUsuario.setValueAt(usuario.getRut(), fila, 1);
            this.tableListarUsuario.setValueAt(usuario.getNombre(), fila, 2);
            this.tableListarUsuario.setValueAt(usuario.getCorreo(), fila, 3);
            this.tableListarUsuario.setValueAt(usuario.getPass(), fila, 4);
            this.tableListarUsuario.setValueAt(usuario.getRol(), fila, 5);
            fila++;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtRutUsuario = new javax.swing.JTextField();
        txtNombreUsuario = new javax.swing.JTextField();
        txtCorreoUsuario = new javax.swing.JTextField();
        txtContraseñaUsuario = new javax.swing.JTextField();
        cbxRolUsuario = new javax.swing.JComboBox<>();
        btnAgregarUsuario = new javax.swing.JButton();
        btnModificarUsuario = new javax.swing.JButton();
        btnEliminarUsuario = new javax.swing.JButton();
        txtIDUsuario = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableListarUsuario = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Rut");

        jLabel2.setText("Nombre");

        jLabel3.setText("Correo");

        jLabel4.setText("Contraseña");

        jLabel5.setText("Rol");

        cbxRolUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Vendedor" }));
        cbxRolUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxRolUsuarioActionPerformed(evt);
            }
        });

        btnAgregarUsuario.setText("Agregar");
        btnAgregarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarUsuarioActionPerformed(evt);
            }
        });

        btnModificarUsuario.setText("Modificar");
        btnModificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarUsuarioActionPerformed(evt);
            }
        });

        btnEliminarUsuario.setText("Eliminar");
        btnEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRutUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtIDUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregarUsuario)
                        .addGap(63, 63, 63)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtCorreoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtContraseñaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxRolUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnModificarUsuario)
                        .addGap(62, 62, 62)
                        .addComponent(btnEliminarUsuario)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRutUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContraseñaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxRolUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(txtIDUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarUsuario)
                    .addComponent(btnModificarUsuario)
                    .addComponent(btnEliminarUsuario))
                .addContainerGap())
        );

        tableListarUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Rut", "Nombre", "Correo", "Pass", "Rol"
            }
        ));
        tableListarUsuario.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tableListarUsuarioAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tableListarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableListarUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableListarUsuario);

        jLabel6.setText("Buscar Usuario");

        jLabel7.setText("NOMBRE DEL USUARIO");

        jLabel8.setText("Nuevo Usuario");

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(264, 264, 264)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxRolUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxRolUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxRolUsuarioActionPerformed

    private void btnAgregarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarUsuarioActionPerformed
            //AGREGAR usuario
        try{
            usuario.setRut(txtRutUsuario.getText());
            usuario.setNombre(txtNombreUsuario.getText());
            usuario.setCorreo(txtCorreoUsuario.getText());
            usuario.setPass(txtContraseñaUsuario.getText());
            usuario.setRol(cbxRolUsuario.getSelectedItem().toString());
            nu.insertarUsuario(usuario);
            LimpiarUsuario();
            ListarUsuario();
            JOptionPane.showMessageDialog(null, "Usuario Agregado");
            
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error al agregar Usuario" + ex.getMessage());
            
        }
      
    }//GEN-LAST:event_btnAgregarUsuarioActionPerformed

    private void btnModificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarUsuarioActionPerformed
        // MODIFICAR USUARIO
        if ("".equals(txtIDUsuario.getText())) {
            
            JOptionPane.showMessageDialog(null, "seleccione una fila");
        } else {

            if (!"".equals(txtRutUsuario.getText()) ||  !"".equals(txtNombreUsuario.getText()) ||
                    !"".equals(txtCorreoUsuario.getText()) || !"".equals(txtContraseñaUsuario.getText())){
                
            usuario.setRut(txtRutUsuario.getText());
            usuario.setNombre(txtNombreUsuario.getText());
            usuario.setCorreo(txtCorreoUsuario.getText());
            usuario.setPass(txtContraseñaUsuario.getText());

            nu.ModificarUsuario(usuario);
            JOptionPane.showMessageDialog(null, "Cliente Modificado");
            LimpiarUsuario();
            ListarUsuario();

            } else {
                JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            }
        }
        
    }//GEN-LAST:event_btnModificarUsuarioActionPerformed

    private void tableListarUsuarioAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tableListarUsuarioAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tableListarUsuarioAncestorAdded

    private void tableListarUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableListarUsuarioMouseClicked
        int fila = tableListarUsuario.rowAtPoint(evt.getPoint());
        txtIDUsuario.setText(tableListarUsuario.getValueAt(fila, 0).toString());
        txtRutUsuario.setText(tableListarUsuario.getValueAt(fila, 1).toString());
        txtNombreUsuario.setText(tableListarUsuario.getValueAt(fila, 2).toString());
        txtCorreoUsuario.setText(tableListarUsuario.getValueAt(fila, 3).toString());
        txtContraseñaUsuario.setText(tableListarUsuario.getValueAt(fila, 4).toString());
        cbxRolUsuario.setSelectedItem(tableListarUsuario.getValueAt(fila, 5).toString());
      
    }//GEN-LAST:event_tableListarUsuarioMouseClicked

    private void btnEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioActionPerformed
        //ELIMINAR PROVEEDOR
        if(!"".equals(txtIDUsuario.getText())){
            int pregunta = JOptionPane.showConfirmDialog(null, "Estas seguro de eliminar?");
            if(pregunta == 0){
                int id = Integer.parseInt(txtIDUsuario.getText());
                nu.EliminarUsuario(id);
                LimpiarUsuario();
                ListarUsuario();
                
            }

        }
    }//GEN-LAST:event_btnEliminarUsuarioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarUsuario;
    private javax.swing.JButton btnEliminarUsuario;
    private javax.swing.JButton btnModificarUsuario;
    private javax.swing.JComboBox<String> cbxRolUsuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tableListarUsuario;
    private javax.swing.JTextField txtContraseñaUsuario;
    private javax.swing.JTextField txtCorreoUsuario;
    private javax.swing.JTextField txtIDUsuario;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtRutUsuario;
    // End of variables declaration//GEN-END:variables
}

