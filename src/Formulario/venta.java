package Formulario;

import ClaseConectar.Conectar;
import Clases.fecha;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

public class venta extends javax.swing.JInternalFrame {

    public static seleccion_cliente seleccion_c;
    public static elegir_cliente elegir_c;
    public static elegir_producto elegir_p;
    String precio,precioxmayor;
    DefaultTableModel modelo;
    Conectar cc=new Conectar();
    Connection cn=cc.conexion();
    Integer seleccionado,c;
    Double p;
    
    fecha fecha=new fecha();
    //String rtta;//r
    Integer cantidadpersonas,totalpersonas;
    public static String bandera_venta;//guardar el usuario que inicio sesion
    public String usuario_alquiler;
    public static String id_habitacion_seleccion; //guarda el id retornado
    public String id_cliente_cliente;//recibe el huesped de la interfaz elegir
    Integer fila=0,cen=1;
    public static Blob blobimagen=null;
///////////////
    public venta() {
        super();
        initComponents();
        this.setLocation(5,5);        
        this.setTitle("Venta");
        java.util.Date fechaa = new java.util.Date();
        java.sql.Date fechasq1 = new java.sql.Date(fechaa.getTime());
        
        bandera_venta="bandera";
        ////Tabla
        modelo= new DefaultTableModel();              
        modelo.addColumn("CODIGO"); 
        modelo.addColumn("CANTIDAD"); 
        modelo.addColumn("DESCRIPCION"); 
        modelo.addColumn("PRECIO UNITARIO");      
        modelo.addColumn("SUBTOTAL"); 
        this.tabla.setModel(modelo);
        jPanel1.setOpaque(false);
        panel_dt_cliente.setOpaque(false);
        panel_dt_producto.setOpaque(false);
        panel_dt_venta.setOpaque(false);
        txtboleta.setEnabled(false);
        txtdescuento.setEnabled(false);
        ///
        
        //nm.setStepSize(1);
        
        ///
        limpiar();  
        btnnuevo();  
    }
    
    void mostrardatos(){
                                       
    tabla.setModel(modelo);
    
    String []datos = new String [10];

    datos[0]=txtcodigo.getText();
    datos[1]=txtcantidad.getText();
    datos[2]=txtnombrep.getText();
    c=Integer.parseInt(datos[1]);
    if (c>=10) {
        datos[3]=precioxmayor; 
    }
    else{
        datos[3]=precio; 
    }
    p=Double.parseDouble(datos[3]);
    datos[4]= Double.toString(p*c);

    modelo.addRow(datos); 
    fila=fila+1;
    tabla.setModel(modelo);
  
    } 
    
    public void obtenerusuario (String u){
        usuario_alquiler=u;        
    }
    void bloqueorestantes(){
        btnbuscar_h.setEnabled(false);
        btnhuesped.setEnabled(false); 
        btnexplorar.setEnabled(false);
        txtdni.setEnabled(false);
        txtnombre.setEnabled(false);
        txtapellido.setEnabled(false);
    }    
    void btnnuevo(){
        btnbuscar_h.setEnabled(true);
        btnhuesped.setEnabled(true); 
        btnexplorar.setEnabled(true);
        btnguardar.setEnabled(false);
        //
        txtdni.setEnabled(true);
        txtdni.setEditable(true);
        txtnombre.setEditable(false);
        txtapellido.setEditable(false); 
        txtciudad.setEditable(false);
        txtcantidad.setEditable(false);
        txtcodigo.setEnabled(true);
        txtcodigo.setEditable(true);
        txtstock.setEditable(false);
        //
        //
        txtidventa.setEnabled(false);
        txtllegada.setEnabled(false);
        txtboleta.setEditable(false);
        txtdescuento.setEditable(true);
                 
    }    
    void limpiar(){
        txtdni.setText("");
        txtnombre.setText("");
        txtapellido.setText("");
        txtcodigo.setText("");
        txtnombrep.setText("");
        txtcantidad.setText("");
        txtciudad.setText("");
        txtstock.setText("");
        txtdescripcion.setText("");
        txtboleta.setText("");
        obt_id(); 
        txtllegada.setText(fecha_actual());
              
    }
    void eliminarelementos(){
        int cantfil=tabla.getRowCount();
        if (cantfil>0) {
            for(int i=cantfil;i>=0;i--){
            modelo.removeRow(i-1);
            }
        }
        
    }
    /////////////////  
    
    public void obt_id(){
        try{
            //obteniendo id de alquila.. id maximo            
            ResultSet rsa;
            Statement sent = cn.createStatement();
            rsa = sent.executeQuery("SELECT IFNULL(MAX(CAST(id_venta AS UNSIGNED)), 0) codigoExterno FROM venta");
            int cont;
            while(rsa.next()){
                cont =Integer.parseInt(rsa.getString("codigoExterno"))+1;
                this.txtidventa.setText(String.valueOf(cont));
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
//////    
    public static String fecha_actual(){
        Date fecha = new Date();
      //SimpleDateFormat formatoFecha= new SimpleDateFormat("YYYY-MM-dd");
        SimpleDateFormat formatoFecha= new SimpleDateFormat("YYYY-MM-dd h:mm:ss"); 
        return formatoFecha.format(fecha);
    } 
    /////////////
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcMousePanel1 = new jcMousePanel.jcMousePanel();
        jPanel1 = new javax.swing.JPanel();
        panel_dt_cliente = new javax.swing.JPanel();
        lb_dni_alq = new javax.swing.JLabel();
        txtdni = new javax.swing.JTextField();
        lb_nom_alq = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        lb_ape_alq = new javax.swing.JLabel();
        btnbuscar_h = new javax.swing.JButton();
        btnhuesped = new javax.swing.JButton();
        btnexplorar = new javax.swing.JButton();
        lb_ape_alq1 = new javax.swing.JLabel();
        txtciudad = new javax.swing.JTextField();
        panel_dt_producto = new javax.swing.JPanel();
        lb_num_hab_alq = new javax.swing.JLabel();
        lb_tip_hab_alq = new javax.swing.JLabel();
        txtnombrep = new javax.swing.JTextField();
        txtcodigo = new javax.swing.JTextField();
        btnbuscar_producto = new javax.swing.JButton();
        lbl_image = new javax.swing.JLabel();
        btnagregarp = new javax.swing.JButton();
        txtdescripcion = new javax.swing.JTextField();
        btnexplorar_producto = new javax.swing.JButton();
        txtcantidad = new javax.swing.JTextField();
        btnnuevoproducto = new javax.swing.JButton();
        lb_num_camas_hab_alq1 = new javax.swing.JLabel();
        lb_num_hab_alq1 = new javax.swing.JLabel();
        txtstock = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        panel_dt_venta = new javax.swing.JPanel();
        lb_id_alq = new javax.swing.JLabel();
        lb_fech_lleg = new javax.swing.JLabel();
        txtidventa = new javax.swing.JTextField();
        txtllegada = new javax.swing.JTextField();
        txtdescuento = new javax.swing.JTextField();
        lb_fech_lleg1 = new javax.swing.JLabel();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        lb_fech_lleg2 = new javax.swing.JLabel();
        txtboleta = new javax.swing.JTextField();
        eliminar_producto = new javax.swing.JButton();

        setClosable(true);
        setTitle("Venta");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jcMousePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/fondoplomo1.jpg"))); // NOI18N

        panel_dt_cliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("URW Gothic L", 1, 12))); // NOI18N
        panel_dt_cliente.setToolTipText("");

        lb_dni_alq.setFont(new java.awt.Font("URW Gothic L", 0, 12)); // NOI18N
        lb_dni_alq.setText("DNI:");

        txtdni.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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

        lb_nom_alq.setFont(new java.awt.Font("URW Gothic L", 0, 12)); // NOI18N
        lb_nom_alq.setText("Nombres:");

        txtnombre.setEditable(false);
        txtnombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtapellido.setEditable(false);
        txtapellido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lb_ape_alq.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_ape_alq.setText("Apellidos:");

        btnbuscar_h.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnbuscar_h.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscaaar13.png"))); // NOI18N
        btnbuscar_h.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscar_hActionPerformed(evt);
            }
        });

        btnhuesped.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnhuesped.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nuevohuesped13.png"))); // NOI18N
        btnhuesped.setText("Nuevo Cliente");
        btnhuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhuespedActionPerformed(evt);
            }
        });

        btnexplorar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnexplorar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/EXPLORAR1.PNG"))); // NOI18N
        btnexplorar.setText("Explorar");
        btnexplorar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexplorarActionPerformed(evt);
            }
        });

        lb_ape_alq1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_ape_alq1.setText("Localidad:");

        txtciudad.setEditable(false);
        txtciudad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout panel_dt_clienteLayout = new javax.swing.GroupLayout(panel_dt_cliente);
        panel_dt_cliente.setLayout(panel_dt_clienteLayout);
        panel_dt_clienteLayout.setHorizontalGroup(
            panel_dt_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dt_clienteLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panel_dt_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_dt_clienteLayout.createSequentialGroup()
                        .addGroup(panel_dt_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_nom_alq)
                            .addComponent(lb_ape_alq)
                            .addComponent(lb_ape_alq1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel_dt_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtapellido, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                            .addComponent(txtciudad)
                            .addComponent(txtnombre))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_dt_clienteLayout.createSequentialGroup()
                        .addComponent(lb_dni_alq)
                        .addGap(18, 18, 18)
                        .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel_dt_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel_dt_clienteLayout.createSequentialGroup()
                                .addComponent(btnbuscar_h, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnexplorar))
                            .addComponent(btnhuesped, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(23, 23, 23))))
        );
        panel_dt_clienteLayout.setVerticalGroup(
            panel_dt_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dt_clienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_dt_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_dt_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lb_dni_alq)
                        .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_dt_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnbuscar_h, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(btnexplorar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnhuesped)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(panel_dt_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_nom_alq)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(panel_dt_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_ape_alq)
                    .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(panel_dt_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_ape_alq1)
                    .addComponent(txtciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        panel_dt_producto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("URW Gothic L", 1, 12))); // NOI18N

        lb_num_hab_alq.setFont(new java.awt.Font("URW Gothic L", 0, 12)); // NOI18N
        lb_num_hab_alq.setText("Código de producto:");

        lb_tip_hab_alq.setFont(new java.awt.Font("URW Gothic L", 0, 12)); // NOI18N
        lb_tip_hab_alq.setText("Nombre del producto:");

        txtnombrep.setEditable(false);
        txtnombrep.setFont(new java.awt.Font("URW Gothic L", 0, 12)); // NOI18N

        txtcodigo.setEditable(false);
        txtcodigo.setBackground(new java.awt.Color(255, 255, 255));
        txtcodigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtcodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigoActionPerformed(evt);
            }
        });

        btnbuscar_producto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnbuscar_producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscaaar13.png"))); // NOI18N
        btnbuscar_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscar_productoActionPerformed(evt);
            }
        });

        lbl_image.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnagregarp.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnagregarp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/GUARdar1.png"))); // NOI18N
        btnagregarp.setText("Agregar");
        btnagregarp.setEnabled(false);
        btnagregarp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarpActionPerformed(evt);
            }
        });

        txtdescripcion.setEditable(false);
        txtdescripcion.setFont(new java.awt.Font("URW Gothic L", 0, 12)); // NOI18N

        btnexplorar_producto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnexplorar_producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/EXPLORAR1.PNG"))); // NOI18N
        btnexplorar_producto.setText("Explorar");
        btnexplorar_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexplorar_productoActionPerformed(evt);
            }
        });

        txtcantidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtcantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcantidadActionPerformed(evt);
            }
        });
        txtcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantidadKeyTyped(evt);
            }
        });

        btnnuevoproducto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnnuevoproducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nuevohuesped13.png"))); // NOI18N
        btnnuevoproducto.setText("Nuevo Producto");
        btnnuevoproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoproductoActionPerformed(evt);
            }
        });

        lb_num_camas_hab_alq1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_num_camas_hab_alq1.setText("Cantidad: ");

        lb_num_hab_alq1.setFont(new java.awt.Font("URW Gothic L", 0, 12)); // NOI18N
        lb_num_hab_alq1.setText("Stock:");

        txtstock.setEditable(false);
        txtstock.setBackground(new java.awt.Color(255, 255, 255));
        txtstock.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtstock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_dt_productoLayout = new javax.swing.GroupLayout(panel_dt_producto);
        panel_dt_producto.setLayout(panel_dt_productoLayout);
        panel_dt_productoLayout.setHorizontalGroup(
            panel_dt_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dt_productoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_dt_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_dt_productoLayout.createSequentialGroup()
                        .addComponent(lb_tip_hab_alq)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtnombrep, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_dt_productoLayout.createSequentialGroup()
                        .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(panel_dt_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_dt_productoLayout.createSequentialGroup()
                                .addComponent(lb_num_camas_hab_alq1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(btnagregarp))
                            .addComponent(txtdescripcion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_dt_productoLayout.createSequentialGroup()
                        .addGroup(panel_dt_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_num_hab_alq)
                            .addComponent(lb_num_hab_alq1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel_dt_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtstock, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(panel_dt_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel_dt_productoLayout.createSequentialGroup()
                                .addComponent(btnbuscar_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnexplorar_producto))
                            .addComponent(btnnuevoproducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panel_dt_productoLayout.setVerticalGroup(
            panel_dt_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dt_productoLayout.createSequentialGroup()
                .addGroup(panel_dt_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel_dt_productoLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(panel_dt_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_num_hab_alq))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel_dt_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_num_hab_alq1)
                            .addComponent(txtstock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel_dt_productoLayout.createSequentialGroup()
                        .addGroup(panel_dt_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnbuscar_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnexplorar_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnnuevoproducto)))
                .addGap(18, 18, 18)
                .addGroup(panel_dt_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_tip_hab_alq)
                    .addComponent(txtnombrep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_dt_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_dt_productoLayout.createSequentialGroup()
                        .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel_dt_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_num_camas_hab_alq1)
                            .addComponent(btnagregarp, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_dt_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_dt_producto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panel_dt_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_dt_producto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla);

        panel_dt_venta.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Venta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        panel_dt_venta.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        lb_id_alq.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_id_alq.setText("Nº venta:");

        lb_fech_lleg.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_fech_lleg.setText("Fecha:");

        txtidventa.setEditable(false);
        txtidventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidventaActionPerformed(evt);
            }
        });

        txtllegada.setEditable(false);
        txtllegada.setBackground(new java.awt.Color(255, 255, 255));
        txtllegada.setEnabled(false);
        txtllegada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtllegadaActionPerformed(evt);
            }
        });
        txtllegada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtllegadaKeyTyped(evt);
            }
        });

        txtdescuento.setEditable(false);
        txtdescuento.setBackground(new java.awt.Color(255, 255, 255));
        txtdescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdescuentoActionPerformed(evt);
            }
        });
        txtdescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdescuentoKeyTyped(evt);
            }
        });

        lb_fech_lleg1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_fech_lleg1.setText("Descuento:");

        btnnuevo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nuevo13.png"))); // NOI18N
        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnguardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/GUARdar1.png"))); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cerrar13.png"))); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        lb_fech_lleg2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_fech_lleg2.setText("N° de boleta:");

        txtboleta.setEditable(false);
        txtboleta.setBackground(new java.awt.Color(255, 255, 255));
        txtboleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtboletaActionPerformed(evt);
            }
        });
        txtboleta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtboletaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panel_dt_ventaLayout = new javax.swing.GroupLayout(panel_dt_venta);
        panel_dt_venta.setLayout(panel_dt_ventaLayout);
        panel_dt_ventaLayout.setHorizontalGroup(
            panel_dt_ventaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dt_ventaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_dt_ventaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_dt_ventaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_dt_ventaLayout.createSequentialGroup()
                        .addGroup(panel_dt_ventaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panel_dt_ventaLayout.createSequentialGroup()
                                .addComponent(lb_id_alq)
                                .addGap(14, 14, 14)
                                .addComponent(txtidventa, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_dt_ventaLayout.createSequentialGroup()
                                .addComponent(lb_fech_lleg2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtboleta)))
                        .addGap(18, 18, 18)
                        .addGroup(panel_dt_ventaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_dt_ventaLayout.createSequentialGroup()
                                .addComponent(lb_fech_lleg)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtllegada, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_dt_ventaLayout.createSequentialGroup()
                                .addComponent(lb_fech_lleg1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtdescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(panel_dt_ventaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnnuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnguardar, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        panel_dt_ventaLayout.setVerticalGroup(
            panel_dt_ventaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dt_ventaLayout.createSequentialGroup()
                .addGroup(panel_dt_ventaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_dt_ventaLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panel_dt_ventaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_id_alq)
                            .addComponent(txtidventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_fech_lleg)
                            .addComponent(txtllegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel_dt_ventaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_dt_ventaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_fech_lleg2)
                                .addComponent(txtboleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_dt_ventaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_fech_lleg1)
                                .addComponent(txtdescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panel_dt_ventaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnsalir)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        eliminar_producto.setText("Eliminar último producto");
        eliminar_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminar_productoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jcMousePanel1Layout = new javax.swing.GroupLayout(jcMousePanel1);
        jcMousePanel1.setLayout(jcMousePanel1Layout);
        jcMousePanel1Layout.setHorizontalGroup(
            jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_dt_venta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jcMousePanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(eliminar_producto)))
                .addContainerGap())
        );
        jcMousePanel1Layout.setVerticalGroup(
            jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jcMousePanel1Layout.createSequentialGroup()
                        .addComponent(panel_dt_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eliminar_producto)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_dt_venta.getAccessibleContext().setAccessibleName("Datos de la venta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jcMousePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // cerrando ventana
        bandera_venta=null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void txtdniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdniActionPerformed

    private void txtdniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdniKeyTyped
        // TIPEO DNI
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
    }//GEN-LAST:event_txtdniKeyTyped

    private void btnbuscar_hActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscar_hActionPerformed
        // boton buscar huesped
        if (txtdni.getText().length()<8){
            JOptionPane.showMessageDialog(null,"Ingrese DNI Completo");
            txtnombre.setText(null);
            txtapellido.setText(null);
            txtciudad.setText(null);
        }
        else
        {
            txtnombre.setText(null);
            txtapellido.setText(null);
            txtciudad.setText(null);
            String dni= (txtdni.getText());
            try{
                ResultSet rs1;
                PreparedStatement pst=cn.prepareStatement("SELECT nombres,apellidos,id_cliente,ciudad "
                    + "FROM clientes where dni_cliente='"+dni+"'");
                rs1 = pst.executeQuery();//buscando datos y guardando en interfaz
                while(rs1.next()){
                    txtnombre.setText(rs1.getString("nombres"));
                    txtapellido.setText(rs1.getString("apellidos"));
                    txtciudad.setText(rs1.getString("ciudad"));
                    id_cliente_cliente=rs1.getString("id_cliente");
                }
                if (txtnombre.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"DNI no encontrado, por favor registre al cliente","AVISO",JOptionPane.INFORMATION_MESSAGE);
                    txtdni.setText(null);
                }else{
                    //desbloqueo
                    //btnhuesped.setEnabled(false);
                    //txtdni.setEditable(false);
                    
                    txtnombrep.setEnabled(true);
                    
                    //txtnumeroha.setEnabled(true);
                    //txttipoha.setEnabled(true);
                }
                if (txtnombre.getText().isEmpty() || txtnombrep.getText().isEmpty() ) {
                   
                }
                else{
                    btnguardar.setEnabled(true);
                    txtboleta.setEnabled(true);
                    txtboleta.setEditable(true);
                    txtdescuento.setEnabled(true);
                    txtdescuento.setEditable(true);
                    txtdescuento.setText("0");
                }
            }catch(HeadlessException | SQLException e){
                System.err.println("No se pudo buscar");
            }
        }
    }//GEN-LAST:event_btnbuscar_hActionPerformed

    private void btnhuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhuespedActionPerformed
        // boton nuevo huesped

        String bandera=cliente.bandera_cliente;
        try{
            if(bandera==null){
                cliente a= new cliente();
                this.getDesktopPane().add(a);
                a.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(rootPane,"La ventana ya esta abierta!");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnhuespedActionPerformed

    private void btnexplorarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexplorarActionPerformed
        // Boton explorar
        elegir_c=new elegir_cliente(this,true);
        elegir_c.setVisible(true);
        txtdni.setEditable(false);
        if (txtnombre.getText().isEmpty() || txtnombrep.getText().isEmpty() ) {          
        }
        else{
            btnguardar.setEnabled(true);
            txtboleta.setEnabled(true);
            txtboleta.setEditable(true);
            txtdescuento.setEnabled(true);
            txtdescuento.setEditable(true);
            txtdescuento.setText("0");
        }
        System.out.println("el ide huesped regresado: "+id_cliente_cliente);
    }//GEN-LAST:event_btnexplorarActionPerformed

    private void txtcodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigoActionPerformed

    private void btnbuscar_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscar_productoActionPerformed
        //boton buscar // mostrar_seleccion_habitacion();
        
            txtnombrep.setText(null);
            txtdescripcion.setText(null);
            String cod= (txtcodigo.getText());
            try{
                ResultSet rs1;
                PreparedStatement pst=cn.prepareStatement("SELECT nombre,descripcion,stock,precio,precioxmayor,imagen "
                    + "FROM productos where cod_producto='"+cod+"'");
                rs1 = pst.executeQuery();//buscando datos y guardando en interfaz
                while(rs1.next()){
                    txtnombrep.setText(rs1.getString("nombre"));
                    txtcantidad.setEnabled(true);
                    txtcantidad.setEditable(true);
                    txtdescripcion.setText(rs1.getString("descripcion"));
                    txtstock.setText(rs1.getString("stock"));
                    precio = rs1.getString("precio");
                    precioxmayor = rs1.getString("precioxmayor");
                    ByteArrayOutputStream ouput = new ByteArrayOutputStream();
                    InputStream isdatos = rs1.getBinaryStream("imagen");
                    int temp=isdatos.read();
                    while(temp>=0)
                    {
                       ouput.write((char)temp);
                       temp=isdatos.read();

                    }
                    Image imagen=Toolkit.getDefaultToolkit().createImage(ouput.toByteArray());
                    imagen=imagen.getScaledInstance(lbl_image.getWidth(),lbl_image.getHeight(), 1);
                    lbl_image.setIcon(new ImageIcon(imagen));
                    //txtciudad.setText(rs1.getString("ciudad"));
                    //id_cliente_cliente=rs1.getString("id_cliente");
                }
                if (txtnombrep.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"PRODUCTO no encontrado, por favor registre el producto","AVISO",JOptionPane.INFORMATION_MESSAGE);
                    //txtdni.setText(null);
                }else{
                    //desbloqueo
                    //btnhuesped.setEnabled(false);
                    
                    btnagregarp.setEnabled(true);
                    txtcantidad.setText("1");
                    //txtnumeroha.setEnabled(true);
                    //txttipoha.setEnabled(true);
                }
                if (txtnombre.getText().isEmpty() || txtnombrep.getText().isEmpty() ) {
                   
                }
                else{
                    btnguardar.setEnabled(true);
                    txtboleta.setEnabled(true);
                    txtboleta.setEditable(true);
                    txtdescuento.setEnabled(true);
                    txtdescuento.setEditable(true);
                    txtdescuento.setText("0");
                }
            }catch(HeadlessException | SQLException e){
                System.err.println("No se pudo buscar");
            } catch (IOException ex) {
            Logger.getLogger(venta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnbuscar_productoActionPerformed

    private void txtcantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyTyped
        // camas
        char c = evt.getKeyChar();
        if (Character.isLetter(c))
        {
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(rootPane, "Solo numeros");
        }else if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=255)
        {
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(null,"No usar caracteres","!Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtcantidadKeyTyped

    private void txtidventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidventaActionPerformed

    private void txtllegadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtllegadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtllegadaActionPerformed

    private void txtllegadaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtllegadaKeyTyped
        // fecha llegada
        int numerocaracteres=20;
        if(txtllegada.getText().length()>=numerocaracteres){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtllegadaKeyTyped

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // boton nuevo
        limpiar();
        btnnuevo();
        eliminarelementos(); 
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // boton salir
        cc.desconectar();
        bandera_venta=null;
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // boton guardar

        if(txtboleta.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingrese el número de boleta","ERROR",JOptionPane.ERROR_MESSAGE);
        }else{
        try{
                Conectar cc=new Conectar();
                Connection cn=cc.conexion();
                String SQL1="",SQL2="",SQL3="";
                Integer id_cliente = 0;
                SQL1="SELECT * FROM clientes WHERE dni_cliente = '"+txtdni.getText()+"'";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(SQL1); 
                while(rs.next()){
                    id_cliente=Integer.parseInt(rs.getString(1));
                }
                Double total=0.0,pre;
                System.out.println(tabla.getRowCount());
                for (int i = 0; i < tabla.getRowCount(); i++) {
                    pre=Double.parseDouble(tabla.getValueAt(i,4).toString());
                    total=total+pre;
                }            
                PreparedStatement pst1=cn.prepareStatement("INSERT INTO venta(id_venta,nro_boleta,id_cliente,descuento,total,fecha) Values(?,?,?,?,?,?)");
                
                pst1.setInt(1,Integer.parseInt(txtidventa.getText()));
                pst1.setString(2,txtboleta.getText());
                pst1.setInt(3,id_cliente);
                pst1.setDouble(4,Double.parseDouble(txtdescuento.getText()));
                pst1.setDouble(5,total);
                Date fecha = new Date();
                SimpleDateFormat formatoFecha= new SimpleDateFormat("YYYY-MM-dd h:mm:ss"); 
                pst1.setString(6,formatoFecha.format(fecha));             
                pst1.executeUpdate();
                
                for (int i = 0; i < tabla.getRowCount(); i++) {
                    PreparedStatement pst=cn.prepareStatement("INSERT INTO detalle_venta(id_venta,cod_producto,cantidad,subtotal) Values(?,?,?,?)");
                    pst.setInt(1,Integer.parseInt(txtidventa.getText()));
                    pst.setString(2,tabla.getValueAt(i,0).toString());
                    pst.setInt(3, Integer.parseInt(tabla.getValueAt(i,1).toString()));
                    //String cant=tabla.getValueAt(i,0).toString();
                    pst.setDouble(4,Double.parseDouble(tabla.getValueAt(i,4).toString()));
                    pst.executeUpdate();
                    
                    /*SQL2="SELECT * FROM productos WHERE cod_producto = '"+tabla.getValueAt(i,0).toString()+"'";
                    Statement st2 = cn.createStatement();
                    ResultSet rs2 = st2.executeQuery(SQL2); 
                    Integer s=0;
                    System.out.println("gggg");
                    if(rs2.next()){
                        s=Integer.parseInt(rs.getString(8));
                    }
                    System.out.println("rrrr");
                    s=s-Integer.parseInt(tabla.getValueAt(i,1).toString());
                    System.out.println("qqqq");
                    PreparedStatement pst3;
                    pst3 = cn.prepareStatement("UPDATE productos SET stock='"+s+"' WHERE cod_producto="+cant);
                    pst3.executeUpdate();*/
                }
                
                btnguardar.setEnabled(false); 
                txtdni.setEnabled(false);
                txtnombre.setEnabled(false);
                txtapellido.setEnabled(false);
                txtciudad.setEnabled(false);
                txtcodigo.setEnabled(false); 
                txtstock.setEnabled(false);
                txtnombrep.setEnabled(false);
                txtdescripcion.setEnabled(false);
                txtcantidad.setEnabled(false);
                txtboleta.setEnabled(false); 
                txtdescuento.setEnabled(false);
                txtstock.setEnabled(false);
                
                JOptionPane.showMessageDialog(null,"Registro exitoso","¡Aviso!",JOptionPane.INFORMATION_MESSAGE);
                cc.desconectar();
            }catch (HeadlessException | SQLException e){
                System.out.print(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnagregarpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarpActionPerformed
        mostrardatos();
        
    }//GEN-LAST:event_btnagregarpActionPerformed

    private void btnexplorar_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexplorar_productoActionPerformed
        elegir_p=new elegir_producto(this,true);
        elegir_p.setVisible(true);
        if (txtnombre.getText().isEmpty() || txtnombrep.getText().isEmpty() ) {          
        }
        else{
            btnguardar.setEnabled(true);
            txtboleta.setEnabled(true);
            txtboleta.setEditable(true);
            txtdescuento.setEnabled(true);
            txtdescuento.setEditable(true);
            txtdescuento.setText("0");
        }
    }//GEN-LAST:event_btnexplorar_productoActionPerformed

    private void btnnuevoproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoproductoActionPerformed
        String bandera=productos.bandera_productos;
        try{
            if(bandera==null){
                productos a= new productos();
                this.getDesktopPane().add(a);
                a.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(rootPane,"La ventana ya esta abierta!");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnnuevoproductoActionPerformed

    private void txtdescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdescuentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdescuentoActionPerformed

    private void txtdescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescuentoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdescuentoKeyTyped

    private void txtstockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstockActionPerformed

    private void eliminar_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminar_productoActionPerformed
        if (cen==1) {
            fila=fila-1;
            cen=0;
        }
        if (fila>=0) {
            modelo.removeRow(fila);
            fila=fila-1;
        }
    }//GEN-LAST:event_eliminar_productoActionPerformed

    private void txtboletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtboletaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtboletaActionPerformed

    private void txtboletaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtboletaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtboletaKeyTyped

    private void txtcantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcantidadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnagregarp;
    private javax.swing.JButton btnbuscar_h;
    private javax.swing.JButton btnbuscar_producto;
    private javax.swing.JButton btnexplorar;
    private javax.swing.JButton btnexplorar_producto;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnhuesped;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnnuevoproducto;
    private javax.swing.JButton btnsalir;
    private javax.swing.JButton eliminar_producto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private jcMousePanel.jcMousePanel jcMousePanel1;
    private javax.swing.JLabel lb_ape_alq;
    private javax.swing.JLabel lb_ape_alq1;
    private javax.swing.JLabel lb_dni_alq;
    private javax.swing.JLabel lb_fech_lleg;
    private javax.swing.JLabel lb_fech_lleg1;
    private javax.swing.JLabel lb_fech_lleg2;
    private javax.swing.JLabel lb_id_alq;
    private javax.swing.JLabel lb_nom_alq;
    private javax.swing.JLabel lb_num_camas_hab_alq1;
    private javax.swing.JLabel lb_num_hab_alq;
    private javax.swing.JLabel lb_num_hab_alq1;
    private javax.swing.JLabel lb_tip_hab_alq;
    public static javax.swing.JLabel lbl_image;
    private javax.swing.JPanel panel_dt_cliente;
    private javax.swing.JPanel panel_dt_producto;
    private javax.swing.JPanel panel_dt_venta;
    private javax.swing.JTable tabla;
    public static javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtboleta;
    public static javax.swing.JTextField txtcantidad;
    public static javax.swing.JTextField txtciudad;
    public static javax.swing.JTextField txtcodigo;
    public static javax.swing.JTextField txtdescripcion;
    private javax.swing.JTextField txtdescuento;
    public static javax.swing.JTextField txtdni;
    private javax.swing.JTextField txtidventa;
    private javax.swing.JTextField txtllegada;
    public static javax.swing.JTextField txtnombre;
    public static javax.swing.JTextField txtnombrep;
    public static javax.swing.JTextField txtstock;
    // End of variables declaration//GEN-END:variables
}
