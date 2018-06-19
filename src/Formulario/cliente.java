
package Formulario;

import ClaseConectar.Conectar;
import Clases.fecha;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class cliente extends javax.swing.JInternalFrame {
    fecha fecha=new fecha();
    Integer n=1;
    public static String id;
    public static String bandera_cliente;
    public static editar_cliente editar_clien;
  //  public static editar_huesped editar_huespededi;    
    public cliente() {
        initComponents();
        java.util.Date fecha = new java.util.Date();
        java.sql.Date fechasq1 = new java.sql.Date(fecha.getTime());
        txtfecha.setMaxSelectableDate(fechasq1);        
        this.setTitle("Datos de nuevo cliente");
        this.setLocation(10, 10);      
        btnguardar.setEnabled(true);
        btnnuevo.setEnabled(true);     
        btneditar.setEnabled(false);
        bandera_cliente="bandera";
        fechadefecto();      
    }
    
    void limpiar(){
        txtdni.setText("");       
        txtnombre.setText("");
        txtapellido.setText("");
        fechadefecto(); 
        txttelefono.setText("");  
        txtciudad.setText("");
        txtpais.setText(""); 
        txtdireccion.setText("");   
        txtemail.setText("");   
    } 
    void fechadefecto(){
        try{
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse("1990-01-01");
            txtfecha.setDate(date);            
        }catch(ParseException ex){
            //Logger.getLogger(alquiler.class.getName()).log(Level.WARNING);
        }
    }
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jcMousePanel2 = new jcMousePanel.jcMousePanel();
        jPanel3 = new javax.swing.JPanel();
        btnguardar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
        btnbuscar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        txtfecha = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        txtdni = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtciudad = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtpais = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jcMousePanel1 = new jcMousePanel.jcMousePanel();

        jMenuItem1.setText("jMenuItem1");
        jPopupMenu1.add(jMenuItem1);

        setTitle("Registro de Cliente");

        jcMousePanel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/fondo7.jpg"))); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

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

        btnbuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscaaar13.png"))); // NOI18N
        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnbuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btneditar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(btnnuevo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnguardar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnsalir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnbuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btneditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsalir)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de Nuevo Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel1.setForeground(java.awt.Color.white);
        jPanel1.setToolTipText("");
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setName("Datos del Huesped"); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nombres:");

        jLabel4.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        jLabel4.setText("Apellidos:");

        jLabel5.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        jLabel5.setText("Fecha de nacimiento:");

        txtnombre.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });

        txtapellido.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        txtapellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtapellidoActionPerformed(evt);
            }
        });
        txtapellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapellidoKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        jLabel2.setText("DNI:");

        txtdni.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        txtdni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdniActionPerformed(evt);
            }
        });
        txtdni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdniKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        jLabel7.setText("Teléfono:");

        txttelefono.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefonoKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        jLabel8.setText("Ciudad:");

        txtciudad.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        txtciudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtciudadActionPerformed(evt);
            }
        });
        txtciudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtciudadKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        jLabel9.setText("País:");

        txtpais.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        txtpais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpaisActionPerformed(evt);
            }
        });
        txtpais.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpaisKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        jLabel10.setText("Dirección:");

        txtdireccion.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        txtdireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdireccionActionPerformed(evt);
            }
        });
        txtdireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdireccionKeyTyped(evt);
            }
        });

        txtemail.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });
        txtemail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtemailKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        jLabel11.setText("Email:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(54, 54, 54)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtdni, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtapellido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(55, 55, 55)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(45, 45, 45)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel8))
                            .addGap(65, 65, 65)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtciudad)
                                .addComponent(txttelefono)
                                .addComponent(txtpais, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtdireccion, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtemail))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel10)))
                        .addGap(214, 214, 214)))
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtpais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jcMousePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/images.jpg"))); // NOI18N

        javax.swing.GroupLayout jcMousePanel1Layout = new javax.swing.GroupLayout(jcMousePanel1);
        jcMousePanel1.setLayout(jcMousePanel1Layout);
        jcMousePanel1Layout.setHorizontalGroup(
            jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jcMousePanel1Layout.setVerticalGroup(
            jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 147, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jcMousePanel2Layout = new javax.swing.GroupLayout(jcMousePanel2);
        jcMousePanel2.setLayout(jcMousePanel2Layout);
        jcMousePanel2Layout.setHorizontalGroup(
            jcMousePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcMousePanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jcMousePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcMousePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jcMousePanel2Layout.setVerticalGroup(
            jcMousePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcMousePanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jcMousePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jcMousePanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcMousePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("REGISTRO DE HUESPED");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        if(txtnombre.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingrese el nombre","¡Error!",JOptionPane.ERROR_MESSAGE);
        }else if(txtapellido.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingrese apellidos","¡Error!",JOptionPane.ERROR_MESSAGE);
        }else if(txtdni.getText().length()< 8){
            JOptionPane.showMessageDialog(null,"DNI incompleto","¡Error!",JOptionPane.ERROR_MESSAGE);
        }else if (txtfecha.getDate()==null) {
            JOptionPane.showMessageDialog(null,"Ingrese fecha de nacimiento","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if(txttelefono.getText().length()< 6){
            JOptionPane.showMessageDialog(null,"Teléfono incompleto","¡Error!",JOptionPane.ERROR_MESSAGE);
        }else if(txtpais.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingrese País","¡Error!",JOptionPane.ERROR_MESSAGE);
        }else if(txtciudad.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingrese ciudad","¡Error!",JOptionPane.ERROR_MESSAGE);
        }else if(n==1){
            try{
                Conectar cc=new Conectar();
                Connection cn=cc.conexion();
                PreparedStatement pst=cn.prepareStatement("INSERT INTO clientes(dni_cliente,nombres,apellidos,nacimiento,ciudad,telefono,pais,direccion,email) Values(?,?,?,?,?,?,?,?,?)");
                pst.setString(1,txtdni.getText());
                pst.setString(2,txtnombre.getText());
                pst.setString(3,txtapellido.getText());
                pst.setString(4,fecha.getFecha(txtfecha));
                pst.setString(5,txtciudad.getText());
                pst.setString(6,txttelefono.getText());
                pst.setString(7,txtpais.getText());
                pst.setString(8,txtdireccion.getText());
                pst.setString(9,txtemail.getText());

                //jTable1.setEnabled(false);
                btnguardar.setEnabled(false);
                btneditar.setEnabled(false);
                btnnuevo.setEnabled(true);
                pst.executeUpdate();
                txtapellido.setEnabled(false);
                txtdni.setEnabled(false);
                txtfecha.setEnabled(false);
                txttelefono.setEnabled(false);
                txtdireccion.setEnabled(false);
                txtnombre.setEnabled(false);
                txtciudad.setEnabled(false);
                txtpais.setEnabled(false);
                txtemail.setEnabled(false);
                JOptionPane.showMessageDialog(null,"Registro exitoso","¡Aviso!",JOptionPane.INFORMATION_MESSAGE);
                cc.desconectar();
            }catch (HeadlessException | SQLException e){
                System.out.print(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        bandera_cliente=null;
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        // TODO add your handling code here:
        // jTable1.setEnabled(true);

        try {
            Conectar cc=new Conectar();
            Connection cn=cc.conexion();

            PreparedStatement pst;
            pst = cn.prepareStatement("UPDATE clientes SET dni_cliente='"+txtdni.getText()+"',nombres='"+txtnombre.getText()+"',apellidos='"+txtapellido.getText()+"',pais='"+txtpais.getText()+"',direccion='"+txtdireccion.getText()+"',email='"+txtemail.getText()+"'   WHERE id_cliente="+id );
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Modificacion exitosa","¡Aviso!",JOptionPane.INFORMATION_MESSAGE);
            txtapellido.setEnabled(false);
            txtdni.setEnabled(false);
            txtfecha.setEnabled(false);
            txttelefono.setEnabled(false);
            txtdireccion.setEnabled(false);
            txtnombre.setEnabled(false);
            txtciudad.setEnabled(false);
            txtpais.setEnabled(false);  
            txtemail.setEnabled(false);
            cc.desconectar();
            id="null";
            //jTable1.setEnabled(false);
            btnguardar.setEnabled(false);
            btneditar.setEnabled(false);      // CAMBIO
            btnnuevo.setEnabled(true);
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }//GEN-LAST:event_btneditarActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        limpiar();
        txtapellido.setEnabled(true);
        txtdni.setEnabled(true);
        txtfecha.setEnabled(true);
        txttelefono.setEnabled(true);
        txtdireccion.setEnabled(true);
        txtnombre.setEnabled(true);
        txtciudad.setEnabled(true);
        txtpais.setEnabled(true);
        txtemail.setEnabled(true);
        btneditar.setEnabled(false);
        btnguardar.setEnabled(true);
        btnnuevo.setEnabled(true);
        // mostrardatos("");
        //jTable1.setEnabled(false);
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
        editar_clien=new editar_cliente(this,true);
        editar_clien.setVisible(true);
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed

    private void txtnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyReleased
        // TODO add your handling code here:
        //mostrardatos(txtnombre.getText());
    }//GEN-LAST:event_txtnombreKeyReleased

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        // TODO add your handling code here:
        //btnguardar.setEnabled(true);
        int numerocaracteres=25;
        char c = evt.getKeyChar();
        if (Character.isDigit(c))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Ingresar solo letras","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }

        else if (txtnombre.getText().length()>=numerocaracteres){
            evt.consume();
            JOptionPane.showMessageDialog(null,"Exceso de dígitos","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
        else if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=159
        )
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"No usar caracteres","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }else if(!Character.isLetter(evt.getKeyChar()) && evt.getKeyChar() !='´' &&c != KeyEvent.VK_SPACE){
            evt.consume();
        }
        else if (evt.getKeyChar()=='´' && txtnombre.getText().contains("´" )&&c != KeyEvent.VK_SPACE){
            evt.consume();
        }
    }//GEN-LAST:event_txtnombreKeyTyped

    private void txtapellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtapellidoActionPerformed

    private void txtapellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidoKeyTyped
        // TODO add your handling code here:
        int numerocaracteres=25;
        char c = evt.getKeyChar();
        if (Character.isDigit(c))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Ingresar solo letras","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }

        else if (txtapellido.getText().length()>=numerocaracteres){
            evt.consume();
            JOptionPane.showMessageDialog(null,"Exceso de dígitos","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
        else if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=159
        )
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"No usar caracteres","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }else if(!Character.isLetter(evt.getKeyChar()) && evt.getKeyChar() !='´' &&c != KeyEvent.VK_SPACE){
            evt.consume();
        }
        else if (evt.getKeyChar()=='´' && txtapellido.getText().contains("´" )&&c != KeyEvent.VK_SPACE){
            evt.consume();
        }
    }//GEN-LAST:event_txtapellidoKeyTyped

    private void txtdniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdniActionPerformed

    private void txtdniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdniKeyTyped
        // TODO add your handling code here:
        char d=evt.getKeyChar();
        if (txtdni.getText().length()>=15){
            evt.consume();
            JOptionPane.showMessageDialog(null,"Exceso de dígitos","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
        else if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=44
               ||(int)evt.getKeyChar()>45 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=159)
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"No usar caracteres","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
       /* else if (evt.getKeyChar()=='-' && txtapellido.getText().contains("-" )&&d != KeyEvent.VK_SPACE){
            evt.consume();
        }*/
    }//GEN-LAST:event_txtdniKeyTyped

    private void txttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyTyped
        // TODO add your handling code here:
        int numerocaracteres=20;
        char d=evt.getKeyChar();
        if (txttelefono.getText().length()>=numerocaracteres){
            evt.consume();
            JOptionPane.showMessageDialog(null,"Exceso de dígitos","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
        else if (Character.isLetter(d))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Solo números","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
         else if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=39
               ||(int)evt.getKeyChar()>43 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=159)
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"No usar caracteres","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txttelefonoKeyTyped

    private void txtciudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtciudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtciudadActionPerformed

    private void txtciudadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtciudadKeyTyped
        // TODO add your handling code here:
        //btnguardar.setEnabled(true);
        int numerocaracteres=25;
        char c = evt.getKeyChar();
        if (Character.isDigit(c))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Ingresar solo letras","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }

        else if (txtciudad.getText().length()>=numerocaracteres){
            evt.consume();
            JOptionPane.showMessageDialog(null,"Exceso de dígitos","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
        else if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=159
        )
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"No usar caracteres","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }else if(!Character.isLetter(evt.getKeyChar()) && evt.getKeyChar() !='´' &&c != KeyEvent.VK_SPACE){
            evt.consume();
        }
        else if (evt.getKeyChar()=='´' && txtciudad.getText().contains("´" )&&c != KeyEvent.VK_SPACE){
            evt.consume();
        }
    }//GEN-LAST:event_txtciudadKeyTyped

    private void txtpaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpaisActionPerformed

    private void txtpaisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpaisKeyTyped
        // TODO add your handling code here:
        //btnguardar.setEnabled(true);
        int numerocaracteres=19;
        char c = evt.getKeyChar();
        if (Character.isDigit(c))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Ingresar solo letras","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }

        else if (txtpais.getText().length()>=numerocaracteres){
            evt.consume();
            JOptionPane.showMessageDialog(null,"Exceso de dígitos","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
        else if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=159
        )
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"No usar caracteres","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }else if(!Character.isLetter(evt.getKeyChar()) && evt.getKeyChar() !='´' &&c != KeyEvent.VK_SPACE){
            evt.consume();
        }
        else if (evt.getKeyChar()=='´' && txtpais.getText().contains("´" )&&c != KeyEvent.VK_SPACE){
            evt.consume();
        }
    }//GEN-LAST:event_txtpaisKeyTyped

    private void txtdireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdireccionActionPerformed

    private void txtdireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdireccionKeyTyped
        // TODO add your handling code here:
        //btnguardar.setEnabled(true);
        int numerocaracteres=40;
        /*char c = evt.getKeyChar();
        if (Character.isDigit(c))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Ingresar solo letras","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }*/
        //else
        if (txtdireccion.getText().length()>=numerocaracteres){
            evt.consume();
            JOptionPane.showMessageDialog(null,"Exceso de dígitos","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
        /*else if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=255)
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"No usar caracteres","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }*/
    }//GEN-LAST:event_txtdireccionKeyTyped

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailActionPerformed

    private void txtemailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtemailKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    public static javax.swing.JButton btneditar;
    public static javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private jcMousePanel.jcMousePanel jcMousePanel1;
    private jcMousePanel.jcMousePanel jcMousePanel2;
    public static javax.swing.JTextField txtapellido;
    public static javax.swing.JTextField txtciudad;
    public static javax.swing.JTextField txtdireccion;
    public static javax.swing.JTextField txtdni;
    public static javax.swing.JTextField txtemail;
    public static com.toedter.calendar.JDateChooser txtfecha;
    public static javax.swing.JTextField txtnombre;
    public static javax.swing.JTextField txtpais;
    public static javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
