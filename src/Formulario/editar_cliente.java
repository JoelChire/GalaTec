/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulario;

import ClaseConectar.Conectar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;
import java.util.Date;
//import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class editar_cliente extends javax.swing.JDialog {   
    public static cliente clien;
    Conectar cc=new Conectar();
    Connection cn=cc.conexion();
    public static int idhues;
    ResultSet datos;
    DefaultTableModel model;
    String dni,nomb,apellido,fono,ciudad,pais,direccion,ocupacion,estadocivil,nacimiento;
    
    public editar_cliente(cliente parent, boolean modal) {
        //super(parent, modal);        
        this.clien= parent;
        this.setModal(modal);
        this.setTitle("BUSCAR CLIENTE");
        initComponents();
        mostrardatos("");
        this.setLocationRelativeTo(this);
        
        
    }
    
    void mostrardatos(String valor){
    DefaultTableModel modelo= new DefaultTableModel(); 
    modelo.addColumn(" CODIGO"); 
    modelo.addColumn(" DNI"); 
    modelo.addColumn("NOMBRES");
    modelo.addColumn("APELLIDOS");      
    modelo.addColumn("NACIMIENTO");
    modelo.addColumn("CIUDAD");
    modelo.addColumn("TELEFONO");
    modelo.addColumn(" PAIS ");      
    modelo.addColumn("  DIRECCION  ");
    modelo.addColumn(" EMAIL ");                                         
    
    jTable1.setModel(modelo);
    String SQL="";
    if(valor.equals(""))
    {
        String []datos = new String [10];

        SQL="SELECT * FROM clientes";
    }
    else{
        SQL="SELECT * FROM clientes WHERE nombres LIKE  '%"+valor+"%'";
    }
 
    String []datos = new String [10];
        try {
            Conectar cc=new Conectar();            
            Connection cn=cc.conexion();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while(rs.next()){
                datos[0]=rs.getString(1);                
                datos[1]=rs.getString(10);
                datos[2]=rs.getString(2);
                datos[3]=rs.getString(3);
                datos[4]=rs.getString(9);
                datos[5]=rs.getString(4);
                datos[6]=rs.getString(6);
                datos[7]=rs.getString(8);
                datos[8]=rs.getString(7);
                datos[9]=rs.getString(5);           
                modelo.addRow(datos);
            }
            jTable1.setModel(modelo);
            cc.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
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

        jcMousePanel1 = new jcMousePanel.jcMousePanel();
        jLabel1 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jcMousePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/fond3.jpg"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre:");

        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnombreKeyReleased(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cerrar13.png"))); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jcMousePanel1Layout = new javax.swing.GroupLayout(jcMousePanel1);
        jcMousePanel1.setLayout(jcMousePanel1Layout);
        jcMousePanel1Layout.setHorizontalGroup(
            jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jcMousePanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButton1))
                    .addGroup(jcMousePanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 912, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jcMousePanel1Layout.setVerticalGroup(
            jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jcMousePanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed

    private void txtnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyReleased
        // TODO add your handling code here:
        mostrardatos(txtnombre.getText());
    }//GEN-LAST:event_txtnombreKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int fila= jTable1.getSelectedRow();
        try {

            cliente.id=jTable1.getValueAt(fila, 0).toString();
            ////////////////huesped.idhues.jTable1.getValueAt(fila,0),toString();
            cliente.txtdni.setText(jTable1.getValueAt(fila, 1).toString());
            cliente.txtnombre.setText(jTable1.getValueAt(fila, 2).toString());
            cliente.txtapellido.setText(jTable1.getValueAt(fila, 3).toString());

            String fechaSeleccionada = (String) jTable1.getModel().getValueAt(fila,4);
            //Date fecha = new Date();
            SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd");
            Date fecha;
            fecha = df.parse(fechaSeleccionada);
            cliente.txtfecha.setDate(fecha);
           cliente.txtciudad.setText(jTable1.getValueAt(fila, 5).toString());
            // int filaSeleccionada = jTable1.getSelectedRow();

            /*DateFormat df = new SimpleDateFormat("dd-MMMM-yyyy");
            Date fecha = df.parse(fechaSeleccionada);

            huesped.txtfecha.setDate(fechaSeleccionada);*/
            //  huesped.txtfecha.setDate(jTable1.getValueAt(fila, 5));
            cliente.txttelefono.setText(jTable1.getValueAt(fila, 6).toString());
            cliente.txtpais.setText(jTable1.getValueAt(fila, 7).toString());
            
            cliente.txtdireccion.setText(jTable1.getValueAt(fila, 8).toString());
            cliente.txtemail.setText(jTable1.getValueAt(fila, 9).toString());
            cliente.txtapellido.setEnabled(true);
            cliente.txtdni.setEnabled(true);
            cliente.txtfecha.setEnabled(true);
            cliente.txttelefono.setEnabled(true);
            cliente.txtdireccion.setEnabled(true);
            cliente.txtnombre.setEnabled(true);
            cliente.txtciudad.setEnabled(true);
            cliente.txtpais.setEnabled(true);
            cliente.btneditar.setEnabled(true);
            cliente.btnguardar.setEnabled(false);
            this.dispose();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jTable1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(editar_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editar_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editar_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editar_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               editar_cliente dialog = new editar_cliente(clien , true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private jcMousePanel.jcMousePanel jcMousePanel1;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
