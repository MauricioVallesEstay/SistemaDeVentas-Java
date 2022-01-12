/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaGUI;

import CapaDTO.Cliente;
import CapaDTO.DevoCabecera;

import CapaDTO.DevoDetalle;
import CapaDTO.Producto;
import CapaNegocio.NegocioCliente;
import CapaNegocio.NegocioDevolucion;
import CapaNegocio.NegocioProducto;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author xTheBlackKeYx
 */
public class PantallaDevolucion extends javax.swing.JFrame {

    /**
     * Creates new form PantallaDevolucion
     */
    public PantallaDevolucion() {
        initComponents();
        this.setLocationRelativeTo(null);
        txtIdCli.setVisible(false);
        txtIdPro.setVisible(false);
        
    }
    
    DevoCabecera devoCabecera = new DevoCabecera();
    DevoDetalle devoDetalle = new DevoDetalle();
    NegocioDevolucion nevo = new NegocioDevolucion();
    DefaultTableModel modelo = new DefaultTableModel();
    Cliente cliente = new Cliente();
    NegocioCliente nc = new NegocioCliente();
    Producto producto = new Producto();
    NegocioProducto nepro = new NegocioProducto();
    
    
    
    
    public void  ingresarDevoCabecera(){
        try{
            devoCabecera.setCliente(txtNomCliente.getText());
            devoCabecera.setIdVenta(Integer.parseInt(txtIdVenta.getText()));
            devoCabecera.setObservacion(txtObservacion.getText());                
            //Situacion
            if(rbtProducto.isSelected()){
                devoCabecera.setSituacion("Estado Producto");
            }else{
                rbtDespacho.isSelected();
                devoCabecera.setSituacion("Recibo del Despacho");
            }
            // Opcion de devolucion
            if(rbtCambioProducto.isSelected()){
                devoCabecera.setOpDevolucion("Cambio de producto");
            }else{
                rbtDevoDinero.isSelected();
                devoCabecera.setOpDevolucion("Devolucion dinero");
            }
            nevo.RegistrarDevoCabecera(devoCabecera);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al agregar la informacion Devolucion ");
        }
    }
    private void LimpiarDevoCabecera(){
        txtRutCliente.setText("");
        txtNomCliente.setText("");
        txtIdVenta.setText("");
        txtObservacion.setText("");
        situacion.clearSelection();
        OpcionDevolucion.clearSelection();
    }
    
    private void ListarDevoPro(){
        modelo = (DefaultTableModel) this.tableDevoDetalle.getModel();
        
        modelo.setNumRows(0);
        int fila = 0;
        
        Iterator iter = nevo.ListarDevoProducto().iterator();
        while(iter.hasNext()){
            devoDetalle = (DevoDetalle) iter.next();
            Object[] num={};
            modelo.addRow(num);
            this.tableDevoDetalle.setValueAt(devoDetalle.getIdDevoDetalle(), fila, 0);
            this.tableDevoDetalle.setValueAt(devoDetalle.getCodProducto(), fila, 1);
            this.tableDevoDetalle.setValueAt(devoDetalle.getDescProducto(), fila, 2);
            this.tableDevoDetalle.setValueAt(devoDetalle.getCantidad(), fila, 3);
            fila++;
        }
    }
    
    
    private void ListarDevoInfo(){
        modelo = (DefaultTableModel) this.tableDevoInfo.getModel();
        
        modelo.setNumRows(0);
        int fila = 0;
        
        Iterator iter = nevo.ListarDevoInfo().iterator();
        while(iter.hasNext()){
            devoCabecera = (DevoCabecera) iter.next();
            Object[] num={};
            modelo.addRow(num);
            this.tableDevoInfo.setValueAt(devoCabecera.getCliente(), fila, 0);
            this.tableDevoInfo.setValueAt(devoCabecera.getIdVenta(), fila, 1);
            this.tableDevoInfo.setValueAt(devoCabecera.getSituacion(), fila, 2);
            this.tableDevoInfo.setValueAt(devoCabecera.getObservacion(), fila, 3);
            this.tableDevoInfo.setValueAt(devoCabecera.getOpDevolucion(), fila, 4);
            fila++;
        }
    }

    
    public void ingresarDevoDetalle(){
        try{
            devoDetalle.setCodProducto(txtCodProducto.getText());
            devoDetalle.setDescProducto(txtDescProducto.getText());
            devoDetalle.setCantidad(Integer.parseInt(txtCantidad.getText()));
            nevo.RegistrarDevoDetalle(devoDetalle);
        }catch(Exception ex){ 
            JOptionPane.showMessageDialog(null, "Error al agregar la producto Devolucion ");
        }  
    }
    
    
    private void LimpiarDevoDetalle(){
        txtCodProducto.setText("");
        txtDescProducto.setText("");
        txtCantidad.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        situacion = new javax.swing.ButtonGroup();
        OpcionDevolucion = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCodProducto = new javax.swing.JTextField();
        txtDescProducto = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtIdPro = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtRutCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNomCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        rbtProducto = new javax.swing.JRadioButton();
        rbtDespacho = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        txtObservacion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        rbtCambioProducto = new javax.swing.JRadioButton();
        rbtDevoDinero = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        txtIdVenta = new javax.swing.JTextField();
        txtIdCli = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDevoDetalle = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDevoInfo = new javax.swing.JTable();
        btnDevolucion = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setText("Codigo");

        jLabel9.setText("Descripcion");

        jLabel10.setText("Cantidad");

        txtCodProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodProductoKeyPressed(evt);
            }
        });

        txtDescProducto.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtCodProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtIdPro, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtDescProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCodProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtDescProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Rut");

        txtRutCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRutClienteKeyPressed(evt);
            }
        });

        jLabel3.setText("Nombre");

        txtNomCliente.setEditable(false);

        jLabel4.setText("Situacion:");

        rbtProducto.setBackground(new java.awt.Color(255, 255, 255));
        situacion.add(rbtProducto);
        rbtProducto.setText("Estado Producto");

        rbtDespacho.setBackground(new java.awt.Color(255, 255, 255));
        situacion.add(rbtDespacho);
        rbtDespacho.setText("Recibo del despacho");

        jLabel5.setText("Observacion:");

        jLabel6.setText("Opcion de Devolucion:");

        rbtCambioProducto.setBackground(new java.awt.Color(255, 255, 255));
        OpcionDevolucion.add(rbtCambioProducto);
        rbtCambioProducto.setText("Cambio Producto");

        rbtDevoDinero.setBackground(new java.awt.Color(255, 255, 255));
        OpcionDevolucion.add(rbtDevoDinero);
        rbtDevoDinero.setText("Devolucion dinero");

        jLabel7.setText("ID VENTA");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rbtDespacho)
                    .addComponent(rbtProducto)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomCliente)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtRutCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtIdCli, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42))))
                    .addComponent(jLabel4)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtDevoDinero)
                            .addComponent(rbtCambioProducto))
                        .addGap(137, 137, 137)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtRutCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNomCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtDespacho)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtCambioProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtDevoDinero))
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 102));
        jLabel1.setText("DEVOLUCION");

        tableDevoDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdDevo", "Codigo", "Descripcion", "Cantidad"
            }
        ));
        jScrollPane1.setViewportView(tableDevoDetalle);

        tableDevoInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre Cliente", "IdVenta", "Situacion", "Observacion", "Opcion Devolucion"
            }
        ));
        jScrollPane2.setViewportView(tableDevoInfo);

        btnDevolucion.setText("Generar Devolucion");
        btnDevolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolucionActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDevolucion)
                .addGap(308, 308, 308))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(btnVolver))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnDevolucion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnDevolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolucionActionPerformed
        ingresarDevoCabecera();
        ingresarDevoDetalle();
        ListarDevoPro();
        ListarDevoInfo();
        LimpiarDevoCabecera();
        LimpiarDevoDetalle();
        JOptionPane.showMessageDialog(null, "Devolucion Generada Correctamente");
    }//GEN-LAST:event_btnDevolucionActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        this.dispose();
        System.gc();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void txtRutClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRutClienteKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(txtRutCliente.getText())) {
                int dni = Integer.parseInt(txtRutCliente.getText());
                cliente = nc.Buscarcliente(dni);
                if (cliente.getNombreCliente() != null) {
                    txtNomCliente.setText("" + cliente.getNombreCliente());
                    txtIdCli.setText("" + cliente.getIdCliente());
                    txtIdVenta.requestFocus();
                } else {
                    txtIdVenta.requestFocus();
                    txtRutCliente.setText("");
                    JOptionPane.showMessageDialog(null, "El cliente no existe");
                }
            }
        }
    }//GEN-LAST:event_txtRutClienteKeyPressed

    private void txtCodProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodProductoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(!"".equals(txtCodProducto.getText())){
                String codigo = txtCodProducto.getText();
                producto = nepro.BuscarPro(codigo);
                if(producto.getDescripcion() != null){
                    txtIdPro.setText(""+producto.getIdProducto());
                    txtDescProducto.setText(""+producto.getDescripcion());
                    txtCantidad.requestFocus();
                }else{
                    txtCodProducto.requestFocus();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese el codigo del producto");
                txtCodProducto.requestFocus();
            }
        }
    }//GEN-LAST:event_txtCodProductoKeyPressed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup OpcionDevolucion;
    private javax.swing.JButton btnDevolucion;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbtCambioProducto;
    private javax.swing.JRadioButton rbtDespacho;
    private javax.swing.JRadioButton rbtDevoDinero;
    private javax.swing.JRadioButton rbtProducto;
    private javax.swing.ButtonGroup situacion;
    private javax.swing.JTable tableDevoDetalle;
    private javax.swing.JTable tableDevoInfo;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodProducto;
    private javax.swing.JTextField txtDescProducto;
    private javax.swing.JTextField txtIdCli;
    private javax.swing.JTextField txtIdPro;
    private javax.swing.JTextField txtIdVenta;
    private javax.swing.JTextField txtNomCliente;
    private javax.swing.JTextField txtObservacion;
    private javax.swing.JTextField txtRutCliente;
    // End of variables declaration//GEN-END:variables
}
