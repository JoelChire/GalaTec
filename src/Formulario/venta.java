package Formulario;

import ClaseConectar.Conectar;
import Clases.fecha;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
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
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

public class venta extends javax.swing.JInternalFrame {

    public static seleccion_cliente seleccion_c;
    public static elegir_cliente elegir_c;
    DefaultTableModel modelo;
    Conectar cc=new Conectar();
    Connection cn=cc.conexion();
    Integer seleccionado;
    fecha fecha=new fecha();
    //String rtta;//r
    Integer cantidadpersonas,totalpersonas;
    public static String bandera_venta;//guardar el usuario que inicio sesion
    public String usuario_alquiler;
    public static String id_habitacion_seleccion; //guarda el id retornado
    public String id_cliente_cliente;//recibe el huesped de la interfaz elegir
    ///////////////
    public venta() {
        super();
        initComponents();
        this.setLocation(5,5);        
        this.setTitle("Venta");
        java.util.Date fechaa = new java.util.Date();
        java.sql.Date fechasq1 = new java.sql.Date(fechaa.getTime());
        bandera_venta="bandera";
        txtobservacion.setLineWrap(true);
        txtobservacion.setWrapStyleWord(true);
        ////Tabla
        modelo= new DefaultTableModel();        
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("DNI");
        modelo.addColumn("Fecha Nacimiento");
        modelo.addColumn("Ciudad");
        modelo.addColumn("Estado Civil");
        modelo.addColumn("País");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Ocupacion");
        modelo.addColumn("Dirección");        
        this.tb_det.setModel(modelo);
        ///
        spinner.setValue(0);
        SpinnerNumberModel nm=new SpinnerNumberModel();
        nm.setMaximum(10);
        nm.setMinimum(0);
        //nm.setStepSize(1);
        spinner.setModel(nm);
        ///
        limpiar();  
        btnnuevo();  
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
        btnbuscar_th.setEnabled(false);
        btnguardar.setEnabled(false);
        //
        txtdni.setEnabled(true);
        txtdni.setEditable(true);
        txtnombre.setEnabled(true);
        txtapellido.setEnabled(true);        
        spinner.setEnabled(false);//spiner true
        txtnumeroha.setEnabled(false);
        txttipoha.setEnabled(false);
        txtnumeroca.setEnabled(false);
        //
        //
        txtidventa.setEnabled(false);
        txtllegada.setEnabled(false);
        txtsalida.setEnabled(false);
        txtusuario.setEnabled(false);
        txtmonto.setEnabled(false);
        txtobservacion.setEnabled(false);          
    }    
    void limpiar(){
        txtdni.setText("");
        txtnombre.setText("");
        txtapellido.setText("");
        spinner.setValue(0);//spiner a 0
        txtnumeroha.setText("");
        txttipoha.setText("");
        txtnumeroca.setText("");
        obt_id(); 
        txtllegada.setText(fecha_actual());
        txtusuario.setText(usuario_alquiler);
        txtmonto.setText("");
        txtobservacion.setText("");
        eliminarelementos();       
    }
    void eliminarelementos(){
        int cantfil=tb_det.getRowCount();
        for(int i=cantfil-1;i>=0;i--){
            modelo.removeRow(i);
            cantidadpersonas=cantidadpersonas+1;
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
        jLabel2 = new javax.swing.JLabel();
        btnbuscar_h = new javax.swing.JButton();
        btnhuesped = new javax.swing.JButton();
        btnexplorar = new javax.swing.JButton();
        spinner = new javax.swing.JSpinner();
        panel_dt_producto = new javax.swing.JPanel();
        lb_num_hab_alq = new javax.swing.JLabel();
        lb_tip_hab_alq = new javax.swing.JLabel();
        txttipoha = new javax.swing.JTextField();
        txtnumeroha = new javax.swing.JTextField();
        btnbuscar_th = new javax.swing.JButton();
        txtnumeroca = new javax.swing.JTextField();
        lb_num_camas_hab_alq1 = new javax.swing.JLabel();
        lb_num_camas_hab_alq = new javax.swing.JLabel();
        txtmonto = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        panel_dt_venta = new javax.swing.JPanel();
        lb_id_alq = new javax.swing.JLabel();
        lb_fech_lleg = new javax.swing.JLabel();
        lb_fech_sal = new javax.swing.JLabel();
        lb_obs_alq = new javax.swing.JLabel();
        lb_id_recep = new javax.swing.JLabel();
        txtidventa = new javax.swing.JTextField();
        txtllegada = new javax.swing.JTextField();
        txtusuario = new javax.swing.JTextField();
        txtsalida = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtobservacion = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        btnnuevo = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_det = new javax.swing.JTable();

        setClosable(true);
        setTitle("Alquiler");
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

        jcMousePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/fond2.jpg"))); // NOI18N

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

        jLabel2.setFont(new java.awt.Font("URW Gothic L", 0, 12)); // NOI18N
        jLabel2.setText("Cantidad de personas:");

        btnbuscar_h.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnbuscar_h.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscaaar13.png"))); // NOI18N
        btnbuscar_h.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscar_hActionPerformed(evt);
            }
        });

        btnhuesped.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnhuesped.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nuevohuesped13.png"))); // NOI18N
        btnhuesped.setText("Nuevo Huesped");
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

        spinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panel_dt_clienteLayout = new javax.swing.GroupLayout(panel_dt_cliente);
        panel_dt_cliente.setLayout(panel_dt_clienteLayout);
        panel_dt_clienteLayout.setHorizontalGroup(
            panel_dt_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dt_clienteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_dt_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_dt_clienteLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(32, 32, 32)
                        .addComponent(spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_dt_clienteLayout.createSequentialGroup()
                        .addGroup(panel_dt_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_nom_alq)
                            .addComponent(lb_ape_alq))
                        .addGap(33, 33, 33)
                        .addGroup(panel_dt_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(txtapellido)))
                    .addGroup(panel_dt_clienteLayout.createSequentialGroup()
                        .addComponent(lb_dni_alq)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_dt_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnhuesped)
                            .addGroup(panel_dt_clienteLayout.createSequentialGroup()
                                .addComponent(btnbuscar_h, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnexplorar)))))
                .addGap(87, 87, 87))
        );
        panel_dt_clienteLayout.setVerticalGroup(
            panel_dt_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dt_clienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_dt_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnbuscar_h, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(panel_dt_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lb_dni_alq)
                        .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnexplorar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnhuesped, javax.swing.GroupLayout.PREFERRED_SIZE, 42, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_dt_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_nom_alq)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_dt_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_ape_alq)
                    .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(panel_dt_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(spinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panel_dt_producto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("URW Gothic L", 1, 12))); // NOI18N

        lb_num_hab_alq.setFont(new java.awt.Font("URW Gothic L", 0, 12)); // NOI18N
        lb_num_hab_alq.setText("N° Habitación:");

        lb_tip_hab_alq.setFont(new java.awt.Font("URW Gothic L", 0, 12)); // NOI18N
        lb_tip_hab_alq.setText("Tipo:");

        txttipoha.setEditable(false);
        txttipoha.setFont(new java.awt.Font("URW Gothic L", 0, 12)); // NOI18N

        txtnumeroha.setEditable(false);
        txtnumeroha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtnumeroha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumerohaActionPerformed(evt);
            }
        });

        btnbuscar_th.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnbuscar_th.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscaaar13.png"))); // NOI18N
        btnbuscar_th.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscar_thActionPerformed(evt);
            }
        });

        txtnumeroca.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtnumeroca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnumerocaKeyTyped(evt);
            }
        });

        lb_num_camas_hab_alq1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_num_camas_hab_alq1.setText("N° Camas: ");

        lb_num_camas_hab_alq.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_num_camas_hab_alq.setText("Monto Diario:");

        txtmonto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtmonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtmontoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panel_dt_productoLayout = new javax.swing.GroupLayout(panel_dt_producto);
        panel_dt_producto.setLayout(panel_dt_productoLayout);
        panel_dt_productoLayout.setHorizontalGroup(
            panel_dt_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dt_productoLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panel_dt_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_dt_productoLayout.createSequentialGroup()
                        .addGroup(panel_dt_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_dt_productoLayout.createSequentialGroup()
                                .addGroup(panel_dt_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_num_hab_alq)
                                    .addComponent(lb_tip_hab_alq, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_dt_productoLayout.createSequentialGroup()
                                .addComponent(lb_num_camas_hab_alq1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(panel_dt_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_dt_productoLayout.createSequentialGroup()
                                .addComponent(txtnumeroha, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnbuscar_th, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(47, Short.MAX_VALUE))
                            .addGroup(panel_dt_productoLayout.createSequentialGroup()
                                .addGroup(panel_dt_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtnumeroca, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txttipoha, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(panel_dt_productoLayout.createSequentialGroup()
                        .addComponent(lb_num_camas_hab_alq, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(txtmonto, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        panel_dt_productoLayout.setVerticalGroup(
            panel_dt_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dt_productoLayout.createSequentialGroup()
                .addGroup(panel_dt_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_dt_productoLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(panel_dt_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_num_hab_alq)
                            .addComponent(txtnumeroha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnbuscar_th, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_dt_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_tip_hab_alq)
                    .addComponent(txttipoha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_dt_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_num_camas_hab_alq1)
                    .addComponent(txtnumeroca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_dt_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_num_camas_hab_alq))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_dt_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 330, Short.MAX_VALUE)
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

        panel_dt_cliente.getAccessibleContext().setAccessibleName("Datos del Cliente");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 11))); // NOI18N

        panel_dt_venta.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Venta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        panel_dt_venta.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        lb_id_alq.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_id_alq.setText("Nº venta:");

        lb_fech_lleg.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_fech_lleg.setText("Fecha Llegada:");

        lb_fech_sal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_fech_sal.setText("Fecha Salida:");

        lb_obs_alq.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_obs_alq.setText("Observación: ");

        lb_id_recep.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_id_recep.setText("Recepcionista:");

        txtidventa.setEditable(false);
        txtidventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidventaActionPerformed(evt);
            }
        });

        txtllegada.setEditable(false);
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

        txtusuario.setEditable(false);
        txtusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuarioActionPerformed(evt);
            }
        });

        txtobservacion.setColumns(15);
        txtobservacion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtobservacion.setRows(5);
        txtobservacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtobservacionKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txtobservacion);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        btnnuevo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nuevo13.png"))); // NOI18N
        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
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

        btnguardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/GUARdar1.png"))); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnnuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnguardar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel_dt_ventaLayout = new javax.swing.GroupLayout(panel_dt_venta);
        panel_dt_venta.setLayout(panel_dt_ventaLayout);
        panel_dt_ventaLayout.setHorizontalGroup(
            panel_dt_ventaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dt_ventaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_dt_ventaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_dt_ventaLayout.createSequentialGroup()
                        .addGroup(panel_dt_ventaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_dt_ventaLayout.createSequentialGroup()
                                .addComponent(lb_id_recep)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_dt_ventaLayout.createSequentialGroup()
                                .addComponent(lb_fech_sal)
                                .addGap(18, 18, 18)
                                .addComponent(txtsalida, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_dt_ventaLayout.createSequentialGroup()
                                .addComponent(lb_id_alq)
                                .addGap(28, 28, 28)
                                .addComponent(txtidventa, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_dt_ventaLayout.createSequentialGroup()
                                .addComponent(lb_fech_lleg)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtllegada, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lb_obs_alq))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE))))
        );
        panel_dt_ventaLayout.setVerticalGroup(
            panel_dt_ventaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dt_ventaLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panel_dt_ventaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_dt_ventaLayout.createSequentialGroup()
                        .addGroup(panel_dt_ventaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_id_alq)
                            .addComponent(txtidventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(panel_dt_ventaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_fech_lleg)
                            .addComponent(txtllegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(panel_dt_ventaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_fech_sal)
                            .addComponent(txtsalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel_dt_ventaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_id_recep)
                            .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(lb_obs_alq))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(panel_dt_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_dt_venta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panel_dt_venta.getAccessibleContext().setAccessibleName("Datos de la venta");

        tb_det.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tb_det);

        javax.swing.GroupLayout jcMousePanel1Layout = new javax.swing.GroupLayout(jcMousePanel1);
        jcMousePanel1.setLayout(jcMousePanel1Layout);
        jcMousePanel1Layout.setHorizontalGroup(
            jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jcMousePanel1Layout.setVerticalGroup(
            jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jcMousePanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        }
        else
        {
            txtnombre.setText(null);
            txtapellido.setText(null);
            String dni= (txtdni.getText());
            try{
                ResultSet rs1;
                PreparedStatement pst=cn.prepareStatement("SELECT nombres,apellidos,id_cliente "
                    + "FROM clientes where dni_cliente='"+dni+"'");
                rs1 = pst.executeQuery();//buscando datos y guardando en interfaz
                while(rs1.next()){
                    txtnombre.setText(rs1.getString("nombres"));
                    txtapellido.setText(rs1.getString("apellidos"));
                    id_cliente_cliente=rs1.getString("id_cliente");
                }
                if (txtnombre.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"DNI no encontrado, por favor registre al cliente","AVISO",JOptionPane.INFORMATION_MESSAGE);
                    txtdni.setText(null);
                }else{
                    //desbloqueo
                    btnhuesped.setEnabled(false);
                    spinner.setEnabled(true);//enabled spinner
                    txtdni.setEditable(false);
                    btnguardar.setEnabled(true);
                    //txtnumeroha.setEnabled(true);
                    //txttipoha.setEnabled(true);
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
        spinner.setEnabled(true);//set enable spinner
        txtdni.setEditable(false);
        System.out.println("el ide huesped regresado: "+id_cliente_cliente);
    }//GEN-LAST:event_btnexplorarActionPerformed

    private void spinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerStateChanged
        // cambio en spinner
        txtnumeroha.setEnabled(true);
        txttipoha.setEnabled(true);
        //txtnumeroha.setEnabled(true);
        //txttipoha.setEnabled(true);
        btnbuscar_th.setEnabled(true);
        //btnbuscarhabitacion.setEnabled(true);
        //txtalquiler.setEnabled(true);
    }//GEN-LAST:event_spinnerStateChanged

    private void txtnumerohaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumerohaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumerohaActionPerformed

    private void btnbuscar_thActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscar_thActionPerformed
        //boton buscar // mostrar_seleccion_habitacion();
        btnhuesped.setEnabled(false);
        btnguardar.setEnabled(true);
        btnbuscar_h.setEnabled(false);
        btnexplorar.setEnabled(false);
        txtdni.setEditable(false);

        totalpersonas=Integer.parseInt(spinner.getValue().toString());
        if(totalpersonas>0){
            cantidadpersonas=totalpersonas;
            seleccion_c=new seleccion_cliente(this,true);
            seleccion_c.setVisible(true);
            spinner.setEnabled(false);//spinner desanilidado
            txtnumeroca.setEnabled(true);
            txtidventa.setEnabled(true);
            txtllegada.setEnabled(true);
            txtsalida.setEnabled(true);
            txtusuario.setEnabled(true);
            txtmonto.setEnabled(true);
            btnguardar.setEnabled(true);
            txtobservacion.setEnabled(true);
        }else{
            JOptionPane.showMessageDialog(null,"Ingresa número válido de Personas","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnbuscar_thActionPerformed

    private void txtnumerocaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnumerocaKeyTyped
        // camas
        char c = evt.getKeyChar();
        int numerocaracteres=1;
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
        }else if(txtnumeroca.getText().length()>=numerocaracteres){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtnumerocaKeyTyped

    private void txtmontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmontoKeyTyped
        // monto total
        int numerocaracteres=7;
        char c = evt.getKeyChar();
        if (Character.isLetter(c))
        {
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(rootPane, "Solo numeros");
        }else if(txtmonto.getText().length()>=numerocaracteres){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtmontoKeyTyped

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
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // boton salir
        cc.desconectar();
        bandera_venta=null;
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // boton guardar
        
        
        if(txtdni.getText().length()<6){
            JOptionPane.showMessageDialog(null,"Elija Huésped","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if(totalpersonas<1){
            JOptionPane.showMessageDialog(null,"Ingresa Cantidas de Personas","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if (txtnumeroca.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Ingresa Cantidad de camas","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if (txtmonto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Ingresa Monto Total","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if(txtidventa.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"No existe ID_Alquiler","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if (txtllegada.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Error al Obtener Fecha de llegada","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if (txtsalida.getDate()==null) {
            JOptionPane.showMessageDialog(null,"Ingresa Fecha Salida","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if (txtusuario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Error al obtener Usuario ","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if(txttipoha.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Elije habitacion","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if((totalpersonas>1) && ((tb_det.getRowCount()+1)!=totalpersonas)){
            JOptionPane.showMessageDialog(null,"Completa la Tabla de Huespedes en esta habitación","ERROR",JOptionPane.ERROR_MESSAGE);
        }else
        {
            SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date fech = new Date();
            String ll= myFormat.format(fech);
            String sa = fecha.getFecha(txtsalida);
            double montoneto=0,intmonto=0;
            int numdias=0;
            try {
                Date date1 = myFormat.parse(ll);
                Date date2 = myFormat.parse(sa);
                long diff = date2.getTime() - date1.getTime();
                System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
                String dias=String.valueOf(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
                numdias=Integer.parseInt(dias);

            } catch (ParseException e) {
                e.printStackTrace();
            }
            intmonto=Double.parseDouble(txtmonto.getText());
            montoneto=numdias*intmonto;
            
            Date fecha_salida=txtsalida.getDate();
            fecha_salida.setHours(12);
            fecha_salida.setSeconds(0);
            fecha_salida.setMinutes(0);
            SimpleDateFormat formatoFecha= new SimpleDateFormat("YYYY-MM-dd h:mm:ss"); 
            String fechafinal= formatoFecha.format(fecha_salida);
            System.out.println(fechafinal);  
            
            try
            {
                PreparedStatement pst=cn.prepareStatement("INSERT INTO alquila(id_alquila,huesped_id_huesped,"
                    + "usuario_id_usuario,fecha_llegada,fecha_salida,num_dias,num_camas,observacion,monto_total,"
                    + "habitacion_id_habitacion) VALUES (?,?,?,?,?,?,?,?,?,?)");
                //pst.setString(1,txtnumeroha.getText());
                pst.setString(1,txtidventa.getText());//id alquiler
                pst.setString(2,id_cliente_cliente);
                pst.setString(3,txtusuario.getText());
                pst.setString(4,txtllegada.getText());
                //pst.setString(5,fecha.getFecha(txtsalida));//fecha salida
                pst.setString(5,fechafinal);//fecha salida
                pst.setString(6,String.valueOf(numdias));//num dias// corregir
                pst.setString(7,txtnumeroca.getText());//num camas
                pst.setString(8,txtobservacion.getText());
                pst.setString(9,String.valueOf(montoneto));//monto total, corregir!!
                pst.setString(10,id_habitacion_seleccion);

                int a=pst.executeUpdate();
                if(a>0){
                    System.out.println("Registro exitoso en Alquila");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Error al agregar en Alquila ","Error",1);
                }
                //
                //String habb=txtnumeroha.getText();
                PreparedStatement pst1=cn.prepareStatement("UPDATE habitacion"
                    + " SET estado='Ocupado' WHERE id_habitacion='"+id_habitacion_seleccion+"'");
                int b=pst1.executeUpdate();
                if(b>0){
                    System.out.println("Actualizacion exitosa en Habitacion");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Error al actualizar habitación ","Error",1);
                }
                int c=1;
                ////  actualizar tabla detalle
                if(totalpersonas>1)
                {
                    c=0;//sirve para dar mensaje de confirmacion
                    try
                    {
                        String id="";
                        ResultSet rsa;
                        int cont;
                        for(int i=0;i<tb_det.getRowCount();i++)
                        {
                            Statement sent = cn.createStatement();
                            rsa = sent.executeQuery("SELECT IFNULL(MAX(CAST(id_detalle AS UNSIGNED)), 0) codigoExterno FROM detalle_alquila");
                            while(rsa.next()){
                                cont =Integer.parseInt(rsa.getString("codigoExterno"))+1;
                                id=(String.valueOf(cont));
                            }/////detalle de alquiler
                            PreparedStatement pst2=cn.prepareStatement("INSERT INTO detalle_alquila"
                                + "(id_detalle,Nombres,Apellidos,dni,nacimiento,ciudad,estado_civil,pais,telefono,"
                                + "ocupacion,direccion,alquila_id_alquila) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
                            /*Nombres,Apellidos,DNI,Fecha Nacimiento,Ciudad,Estado Civil,País,Teléfono,Ocupacion,Dirección*/
                            pst2.setString(1,id);// id detalle
                            pst2.setString(2,tb_det.getValueAt(i,0).toString());//nombre
                            pst2.setString(3,tb_det.getValueAt(i,1).toString());//apellido
                            pst2.setString(4,tb_det.getValueAt(i,2).toString());//dni
                            pst2.setString(5,tb_det.getValueAt(i,3).toString());//
                            pst2.setString(6,tb_det.getValueAt(i,4).toString());//
                            pst2.setString(7,tb_det.getValueAt(i,5).toString());//estado civil
                            pst2.setString(8,tb_det.getValueAt(i,6).toString());//
                            pst2.setString(9,tb_det.getValueAt(i,7).toString());//telefono
                            pst2.setString(10,tb_det.getValueAt(i,8).toString());//
                            pst2.setString(11,tb_det.getValueAt(i,9).toString());//direccion
                            pst2.setString(12,txtidventa.getText());//id alquiler
                            c=pst2.executeUpdate();
                            if(c>0){
                                System.out.println("Registro exitoso en detalle_alquiler");
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"Error al agregar ","Error",1);
                            }
                        }//fin for
                    } catch (Exception e) {
                        System.out.println("no se pudo actualizar detalle alquiler: "+e.getMessage());
                    }//fin trycatch
                }// fin if para detalle alquiler
                if((a>0)&&(b>0)&&(c>0)){
                    JOptionPane.showMessageDialog(null,"Registro Exitoso","FELICITACIONES",JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Error al agregar ");
                }
                btnnuevo();
                eliminarelementos();
                bloqueorestantes();///fin de todos los insert

            }catch(HeadlessException | SQLException e){
                JOptionPane.showMessageDialog(null, "error al agegar datos en alquila y detalle " +e);
            }//fin trycatch
        }//fn else
        ///
    }//GEN-LAST:event_btnguardarActionPerformed

    private void txtusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusuarioActionPerformed

    private void txtobservacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtobservacionKeyTyped
        // TODO add your handling code here:
        int numerocaracteres=120;
        if(txtobservacion.getText().length()>=numerocaracteres){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtobservacionKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar_h;
    private javax.swing.JButton btnbuscar_th;
    private javax.swing.JButton btnexplorar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnhuesped;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private jcMousePanel.jcMousePanel jcMousePanel1;
    private javax.swing.JLabel lb_ape_alq;
    private javax.swing.JLabel lb_dni_alq;
    private javax.swing.JLabel lb_fech_lleg;
    private javax.swing.JLabel lb_fech_sal;
    private javax.swing.JLabel lb_id_alq;
    private javax.swing.JLabel lb_id_recep;
    private javax.swing.JLabel lb_nom_alq;
    private javax.swing.JLabel lb_num_camas_hab_alq;
    private javax.swing.JLabel lb_num_camas_hab_alq1;
    private javax.swing.JLabel lb_num_hab_alq;
    private javax.swing.JLabel lb_obs_alq;
    private javax.swing.JLabel lb_tip_hab_alq;
    private javax.swing.JPanel panel_dt_cliente;
    private javax.swing.JPanel panel_dt_producto;
    private javax.swing.JPanel panel_dt_venta;
    private javax.swing.JSpinner spinner;
    private javax.swing.JTable tb_det;
    public static javax.swing.JTextField txtapellido;
    public static javax.swing.JTextField txtdni;
    private javax.swing.JTextField txtidventa;
    private javax.swing.JTextField txtllegada;
    public static javax.swing.JTextField txtmonto;
    public static javax.swing.JTextField txtnombre;
    public static javax.swing.JTextField txtnumeroca;
    public static javax.swing.JTextField txtnumeroha;
    private javax.swing.JTextArea txtobservacion;
    private com.toedter.calendar.JDateChooser txtsalida;
    public static javax.swing.JTextField txttipoha;
    public static javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
