/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulario;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import ClaseConectar.Conectar;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class productos extends javax.swing.JInternalFrame {

    Integer n=1;

    Conectar cc=new Conectar();
    Connection cn=cc.conexion();
    public String usuario_alquiler;
    public static String bandera_productos;//guardar el usuario que inicio sesion
    public static editar_producto editar_prod;
    public static FileInputStream archivofoto;
    public static Blob blobimagen;
    public static String urlimagen;
    public productos() {
        initComponents();
        this.setLocation(5,5);        
        this.setTitle("productos");
        bandera_productos="bandera";
        btneditar.setEnabled(false);
        jPanel1.setOpaque(false);
    }

    void limpiar(){
        txtcodigo.setText("");       
        txtnombre.setText("");
        txtdescripcion.setText("");
        txtprecio.setText("");  
        txtprecioxmayor.setText(""); 
        txturl.setText(""); 
        txtstock.setText("");
        lblimagen.setIcon(null);   
    }
    
    public void obtenerusuario (String u){
        usuario_alquiler=u;        
    }
    
    void mostrarimagen(String codigo) throws SQLException{
        String SQL1="";
        Conectar cc=new Conectar();            
        Connection cn=cc.conexion();
            SQL1="SELECT * FROM productos WHERE cod_producto="+codigo;
            Statement st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(SQL1);
            Blob blob=rs1.getBlob(7);
            byte[] data=blob.getBytes(1,(int)blob.length());
            BufferedImage img=null;
            try{
                    img=ImageIO.read(new ByteArrayInputStream(data));
            }catch(Exception ex){   
            }
            ImageIcon icono=new ImageIcon(img); 
            lblimagen.setIcon(icono);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcMousePanel3 = new jcMousePanel.jcMousePanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtdescripcion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtstock = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtprecio = new javax.swing.JTextField();
        btncargari = new javax.swing.JButton();
        txturl = new javax.swing.JTextField();
        lblimagen = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtprecioxmayor = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();

        setClosable(true);

        jcMousePanel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/fondoplomo1.jpg"))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de nuevo producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel1.setForeground(java.awt.Color.white);
        jPanel1.setToolTipText("");
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setName("Datos del Huesped"); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Código de producto:");

        jLabel4.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        jLabel4.setText("Nombre:");

        txtcodigo.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        txtcodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigoActionPerformed(evt);
            }
        });
        txtcodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcodigoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodigoKeyTyped(evt);
            }
        });

        txtnombre.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        jLabel2.setText("Descripción:");

        txtdescripcion.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        txtdescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdescripcionActionPerformed(evt);
            }
        });
        txtdescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdescripcionKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        jLabel7.setText("Imagen:");

        jLabel8.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        jLabel8.setText("Stock:");

        txtstock.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        txtstock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstockActionPerformed(evt);
            }
        });
        txtstock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtstockKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        jLabel9.setText("Precio por mayor:");

        txtprecio.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        txtprecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprecioActionPerformed(evt);
            }
        });
        txtprecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtprecioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtprecioKeyTyped(evt);
            }
        });

        btncargari.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btncargari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nuevo13.png"))); // NOI18N
        btncargari.setText("Cargar imagen");
        btncargari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncargariActionPerformed(evt);
            }
        });

        txturl.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        txturl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txturlActionPerformed(evt);
            }
        });
        txturl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txturlKeyTyped(evt);
            }
        });

        lblimagen.setBackground(new java.awt.Color(255, 255, 255));
        lblimagen.setForeground(new java.awt.Color(255, 255, 255));
        lblimagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        jLabel10.setText("Precio:");

        txtprecioxmayor.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        txtprecioxmayor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprecioxmayorActionPerformed(evt);
            }
        });
        txtprecioxmayor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtprecioxmayorKeyTyped(evt);
            }
        });

        btnbuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscaaar13.png"))); // NOI18N
        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        btneditar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btneditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/editar13.png"))); // NOI18N
        btneditar.setText("Actualizar");
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });

        btnnuevo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nuevo13.png"))); // NOI18N
        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnguardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/GUARdar1.png"))); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cerrar13.png"))); // NOI18N
        btnsalir.setText("Cancelar");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel2))
                                        .addGap(34, 34, 34))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel10))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtprecio, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                            .addComponent(txtstock))
                                        .addGap(27, 27, 27)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(35, 35, 35)
                                        .addComponent(txtprecioxmayor, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                                    .addComponent(txtcodigo)
                                    .addComponent(txtnombre)
                                    .addComponent(txtdescripcion)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnbuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btneditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnsalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(btncargari)
                                .addContainerGap(119, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(txturl)
                                .addContainerGap())))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btneditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtprecioxmayor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnsalir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtstock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(btncargari)
                        .addGap(18, 18, 18)
                        .addComponent(txturl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout jcMousePanel3Layout = new javax.swing.GroupLayout(jcMousePanel3);
        jcMousePanel3.setLayout(jcMousePanel3Layout);
        jcMousePanel3Layout.setHorizontalGroup(
            jcMousePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcMousePanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jcMousePanel3Layout.setVerticalGroup(
            jcMousePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcMousePanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        if(txtnombre.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingrese el nombre","¡Error!",JOptionPane.ERROR_MESSAGE);
        }else if(txtcodigo.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingrese el código","¡Error!",JOptionPane.ERROR_MESSAGE);
        }else if (txtprecio.getText()==null) {
            JOptionPane.showMessageDialog(null,"Ingrese precio","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if(txtstock.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingrese stock","¡Error!",JOptionPane.ERROR_MESSAGE);
        }
            try{
                Conectar cc=new Conectar();
                Connection cn=cc.conexion();
                PreparedStatement pst=cn.prepareStatement("INSERT INTO productos(cod_producto,nombre,descripcion,precio,precioxmayor,urlimagen,imagen,stock) Values(?,?,?,?,?,?,?,?)");
                pst.setString(1,txtcodigo.getText());
                pst.setString(2,txtnombre.getText());
                pst.setString(3,txtdescripcion.getText());
                pst.setDouble(4,Double.parseDouble(txtprecio.getText()));
                pst.setDouble(5,Double.parseDouble(txtprecioxmayor.getText()));
                pst.setString(6,txturl.getText());
                FileInputStream archivofoto;
                archivofoto = new FileInputStream(txturl.getText());
                pst.setBinaryStream(7, archivofoto);
                pst.setInt(8,Integer.parseInt(txtstock.getText()));
                pst.executeUpdate();

                btnguardar.setEnabled(false);
                btneditar.setEnabled(false);
                btnnuevo.setEnabled(true);
                btncargari.setEnabled(false);
                txtcodigo.setEnabled(false);
                txtnombre.setEnabled(false);
                txtdescripcion.setEnabled(false);
                txtprecio.setEnabled(false);
                txtprecioxmayor.setEnabled(false);
                txturl.setEnabled(false);
                lblimagen.setEnabled(false);
                txtstock.setEnabled(false);
                
                JOptionPane.showMessageDialog(null,"Registro exitoso","¡Aviso!",JOptionPane.INFORMATION_MESSAGE);
                cc.desconectar();
            }catch (HeadlessException | SQLException e){
                System.out.print(e.getMessage());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(productos.class.getName()).log(Level.SEVERE, null, ex);
            }  
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        bandera_productos=null;
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        // TODO add your handling code here:
        
        if(txtnombre.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingrese el nombre","¡Error!",JOptionPane.ERROR_MESSAGE);
        }else if(txtcodigo.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingrese el código","¡Error!",JOptionPane.ERROR_MESSAGE);
        }else if (txtprecio.getText()==null) {
            JOptionPane.showMessageDialog(null,"Ingrese precio","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if(txtstock.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingrese stock","¡Error!",JOptionPane.ERROR_MESSAGE);
        }
        try {
            Conectar cc=new Conectar();
            Connection cn=cc.conexion();
            String cod=txtcodigo.getText();
            PreparedStatement pst;
            if (txturl.getText().isEmpty()) {  
                pst = cn.prepareStatement("UPDATE productos SET cod_producto='"+txtcodigo.getText()+"',nombre='"+txtnombre.getText()+"',descripcion='"+txtdescripcion.getText()+"',precio='"+Double.parseDouble(txtprecio.getText())+"',precioxmayor='"+Double.parseDouble(txtprecioxmayor.getText())+"',stock='"+Integer.parseInt(txtstock.getText())+"'   WHERE cod_producto="+cod);
                pst.executeUpdate();  
            }
            else{
                String sql="UPDATE productos SET cod_producto = ?, "
                 + "nombre = ?,"
                 + "descripcion = ?,"
                 + "precio = ?,"
                 + "precioxmayor=?,"
                 + "urlimagen=?,"
                 + "imagen=?,"
                 + "stock=?"
                 + "WHERE cod_producto =?"; 
                pst = cn.prepareStatement(sql);

                pst.setString(1,txtcodigo.getText());
                pst.setString(2,txtnombre.getText());
                pst.setString(3,txtdescripcion.getText());
                pst.setDouble(4,Double.parseDouble(txtprecio.getText()));
                pst.setDouble(5,Double.parseDouble(txtprecioxmayor.getText()));
                pst.setString(6,txturl.getText());
                FileInputStream foto;
                foto = new FileInputStream(txturl.getText());
                pst.setBinaryStream(7, foto);
                pst.setInt(8,Integer.parseInt(txtstock.getText()));
                pst.setString(9,cod);
                pst.executeUpdate();
            }
            JOptionPane.showMessageDialog(null,"Modificacion exitosa","¡Aviso!",JOptionPane.INFORMATION_MESSAGE);
            txtcodigo.setEnabled(false);
            txtnombre.setEnabled(false);
            txtdescripcion.setEnabled(false);
            txtprecio.setEnabled(false);
            txtprecioxmayor.setEnabled(false);
            txtstock.setEnabled(false);
            lblimagen.setIcon(null);
            btnguardar.setEnabled(false);
            btneditar.setEnabled(false);      // CAMBIO
            btnnuevo.setEnabled(true);
            cc.desconectar();
            
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(productos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btneditarActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        limpiar();
        txtcodigo.setEnabled(true);
        txtnombre.setEnabled(true);
        txtdescripcion.setEnabled(true);
        txtprecio.setEnabled(true);
        txtprecioxmayor.setEnabled(true);
        txturl.setEnabled(true);  
        lblimagen.setEnabled(true);
        txtstock.setEnabled(true);
        btneditar.setEnabled(false);
        btnguardar.setEnabled(true);
        btnnuevo.setEnabled(true);
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        editar_prod=new editar_producto(this,true);
        editar_prod.setVisible(true);
        
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void txtcodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigoActionPerformed

    private void txtcodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoKeyReleased
        
    }//GEN-LAST:event_txtcodigoKeyReleased

    private void txtcodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoKeyTyped
        
    }//GEN-LAST:event_txtcodigoKeyTyped

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_txtnombreKeyTyped

    private void txtdescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdescripcionActionPerformed

    private void txtdescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescripcionKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtdescripcionKeyTyped

    private void txtstockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstockActionPerformed

    private void txtstockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtstockKeyTyped
        // TODO add your handling code here:
        //btnguardar.setEnabled(true);
        
    }//GEN-LAST:event_txtstockKeyTyped

    private void txtprecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprecioActionPerformed

    private void txtprecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioKeyTyped
        // TODO add your handling code here:
        //btnguardar.setEnabled(true);
        
    }//GEN-LAST:event_txtprecioKeyTyped

    private void btncargariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargariActionPerformed
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Formatos de Archivos JPEG(*.JPG;*.JPEG)","jpg","jpeg","png");
        JFileChooser ruta = new JFileChooser();
        ruta.addChoosableFileFilter(filtro);
        ruta.setDialogTitle("Abrir archivo");
        File destino = new File("D:/productos");
        ruta.setCurrentDirectory(destino);
        int ventana = ruta.showOpenDialog(null);
        if (ventana == JFileChooser.APPROVE_OPTION) {
            File file = ruta.getSelectedFile();
            txturl.setText(String.valueOf(file));
            Image foto = getToolkit().getImage(txturl.getText());
            foto.getScaledInstance(lblimagen.getWidth(),lblimagen.getHeight(),1);
            lblimagen.setIcon(new ImageIcon(foto));
        }
    }//GEN-LAST:event_btncargariActionPerformed

    private void txturlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txturlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txturlActionPerformed

    private void txturlKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txturlKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txturlKeyTyped

    private void txtprecioxmayorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprecioxmayorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprecioxmayorActionPerformed

    private void txtprecioxmayorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioxmayorKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprecioxmayorKeyTyped

    private void txtprecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioKeyReleased
        String pre=txtprecio.getText();
        txtprecioxmayor.setText(pre);
    }//GEN-LAST:event_txtprecioKeyReleased

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
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncargari;
    public static javax.swing.JButton btneditar;
    public static javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private jcMousePanel.jcMousePanel jcMousePanel3;
    public static javax.swing.JLabel lblimagen;
    public static javax.swing.JTextField txtcodigo;
    public static javax.swing.JTextField txtdescripcion;
    public static javax.swing.JTextField txtnombre;
    public static javax.swing.JTextField txtprecio;
    public static javax.swing.JTextField txtprecioxmayor;
    public static javax.swing.JTextField txtstock;
    public static javax.swing.JTextField txturl;
    // End of variables declaration//GEN-END:variables
}
