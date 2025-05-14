/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.reto_equipo3.Swing;

import com.mycompany.reto_equipo3.Actividad;
import com.mycompany.reto_equipo3.Calendario;
import com.mycompany.reto_equipo3.DAOS.DAOActividad;
import com.mycompany.reto_equipo3.DAOS.DAOCalendario;
import com.mycompany.reto_equipo3.DAOS.DAOImagenesInteres;
import com.mycompany.reto_equipo3.DAOS.DAOImagenesPeligro;
import com.mycompany.reto_equipo3.DAOS.DAOPuntosinteres;
import com.mycompany.reto_equipo3.DAOS.DAOPuntospeligro;
import com.mycompany.reto_equipo3.DAOS.DAORutas;
import com.mycompany.reto_equipo3.DAOS.DAOUsuario;
import com.mycompany.reto_equipo3.DAOS.DAOValora;
import com.mycompany.reto_equipo3.Enums.Roles;
import com.mycompany.reto_equipo3.Ficheros.FichaOrganizacion;
import com.mycompany.reto_equipo3.Ficheros.FichaSeguridad;
import com.mycompany.reto_equipo3.Ficheros.FichaUsuario;
import com.mycompany.reto_equipo3.ImagenesInteres;
import com.mycompany.reto_equipo3.ImagenesPeligro;
import com.mycompany.reto_equipo3.PuntosInteres;
import com.mycompany.reto_equipo3.PuntosPeligro;
import com.mycompany.reto_equipo3.Rutas;
import com.mycompany.reto_equipo3.Usuario;
import com.mycompany.reto_equipo3.Validaciones.Teclado;
import com.mycompany.reto_equipo3.Valora;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author salsa
 */
public class SwingPrincipal extends javax.swing.JFrame {

    Usuario usuario = null;
    int idrutaapipp;
    int idpi;
    int idpp;

    public SwingPrincipal() {
        initComponents();
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.out.println("Cierre deshabilitado.");
            }
        });
        // Reajustar Tamaño de rutas validas tabla
        TableRutasValidas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPane1.setPreferredSize(new Dimension(1500, 600));
        Botonparacrearrutas.setVisible(false);
        botoncrearvaloracion.setVisible(false);
        botoncrearcalendario.setVisible(false);
        TablaDetallesruta.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jScrollPane7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jScrollPane7.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPane7.setPreferredSize(new Dimension(2800, 400));
    }

    // Tamaño de lo que ocupa cada cuadrado de la tabla valida rutas y los detalles de la ruta
    public void tamañocolumnasRutaValidas() {
        TableRutasValidas.getColumnModel().getColumn(0).setMinWidth(0);
        TableRutasValidas.getColumnModel().getColumn(0).setMaxWidth(0);
        TableRutasValidas.getColumnModel().getColumn(0).setPreferredWidth(0);
        TableRutasValidas.getColumnModel().getColumn(1).setPreferredWidth(200);
        TableRutasValidas.getColumnModel().getColumn(2).setPreferredWidth(150);
        TableRutasValidas.getColumnModel().getColumn(3).setPreferredWidth(150);
        TableRutasValidas.getColumnModel().getColumn(4).setPreferredWidth(200);
        TableRutasValidas.getColumnModel().getColumn(5).setPreferredWidth(150);
        TableRutasValidas.getColumnModel().getColumn(6).setPreferredWidth(150);
        TableRutasValidas.getColumnModel().getColumn(7).setPreferredWidth(200);
        TableRutasValidas.getColumnModel().getColumn(8).setPreferredWidth(150);
        TableRutasValidas.getColumnModel().getColumn(9).setPreferredWidth(150);
    }

    public void tamañocolumnasDetalles() {
        TablaDetallesruta.getColumnModel().getColumn(0).setMinWidth(0);
        TablaDetallesruta.getColumnModel().getColumn(0).setMaxWidth(0);
        TablaDetallesruta.getColumnModel().getColumn(0).setPreferredWidth(0);
        TablaDetallesruta.getColumnModel().getColumn(1).setPreferredWidth(200);
        TablaDetallesruta.getColumnModel().getColumn(2).setPreferredWidth(150);
        TablaDetallesruta.getColumnModel().getColumn(3).setPreferredWidth(150);
        TablaDetallesruta.getColumnModel().getColumn(4).setPreferredWidth(200);
        TablaDetallesruta.getColumnModel().getColumn(5).setPreferredWidth(150);
        TablaDetallesruta.getColumnModel().getColumn(6).setPreferredWidth(150);
        TablaDetallesruta.getColumnModel().getColumn(7).setPreferredWidth(200);
        TablaDetallesruta.getColumnModel().getColumn(8).setPreferredWidth(150);
        TablaDetallesruta.getColumnModel().getColumn(9).setPreferredWidth(150);
        TablaDetallesruta.getColumnModel().getColumn(10).setPreferredWidth(200);
        TablaDetallesruta.getColumnModel().getColumn(11).setPreferredWidth(150);
        TablaDetallesruta.getColumnModel().getColumn(12).setPreferredWidth(150);
        TablaDetallesruta.getColumnModel().getColumn(13).setPreferredWidth(200);
        TablaDetallesruta.getColumnModel().getColumn(14).setPreferredWidth(150);
        TablaDetallesruta.getColumnModel().getColumn(15).setPreferredWidth(150);
        TablaDetallesruta.getColumnModel().getColumn(16).setPreferredWidth(200);
        TablaDetallesruta.getColumnModel().getColumn(17).setPreferredWidth(150);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField7 = new javax.swing.JTextField();
        PanelEntrada = new javax.swing.JPanel();
        CuadroEntrada = new javax.swing.JLabel();
        BotonEntrada = new javax.swing.JButton();
        PanelInicio = new javax.swing.JPanel();
        TextoInicio = new javax.swing.JLabel();
        Salida = new javax.swing.JButton();
        Rutas = new javax.swing.JButton();
        Usuario = new javax.swing.JButton();
        Cuadro2 = new javax.swing.JLabel();
        Email = new javax.swing.JTextField();
        Cuadro1 = new javax.swing.JLabel();
        IniciarSesion = new javax.swing.JButton();
        Contraseña = new javax.swing.JPasswordField();
        CrearUsuarios = new javax.swing.JPanel();
        Texto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Nombre = new javax.swing.JLabel();
        intronombre = new javax.swing.JTextField();
        apellido = new javax.swing.JLabel();
        introapellido = new javax.swing.JTextField();
        email = new javax.swing.JLabel();
        introemail = new javax.swing.JTextField();
        contraseña = new javax.swing.JLabel();
        rol = new javax.swing.JLabel();
        eligerol = new javax.swing.JComboBox<>();
        introcontraseña = new javax.swing.JPasswordField();
        VolverUsuarios = new javax.swing.JButton();
        darbotonUsuario = new javax.swing.JButton();
        RutasValidas = new javax.swing.JPanel();
        VolverInicio = new javax.swing.JButton();
        NombreRutas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableRutasValidas = new javax.swing.JTable();
        Botonparacrearrutas = new javax.swing.JButton();
        Botonpararefrecartablas = new javax.swing.JButton();
        PuntosdeRuta = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablePuntosInteres = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablePuntosPeligro = new javax.swing.JTable();
        ValoracionesdeRuta = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        TablaValoraciones = new javax.swing.JTable();
        botoncrearvaloracion = new javax.swing.JButton();
        Actividades = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        TablaActividades = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        DetallesRuta = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        TablaDetallesruta = new javax.swing.JTable();
        ImagenesInteres = new javax.swing.JPanel();
        NombreImagenesInteres = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaimagenesInteres = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        ImagenesPeligro = new javax.swing.JPanel();
        Cuadroimagenespeligro = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        TablaImagenesPeligro = new javax.swing.JTable();
        votonimagenvolverpeligro = new javax.swing.JButton();
        CrearRutasde0 = new javax.swing.JPanel();
        Cuadrodecrearrutas = new javax.swing.JLabel();
        volverdecrearruta = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        nombreruta = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        nombreinicio = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        li = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        ldi = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        nombrefini = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        lf = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        ldf = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        distancia = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        duracion = new javax.swing.JTextField();
        Botonparacrearruta = new javax.swing.JButton();
        CatalogodeRutas = new javax.swing.JPanel();
        Nombrerutasinavlidas = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        Tabladerutasnovalidas = new javax.swing.JTable();
        volverarutasdesdeno = new javax.swing.JButton();
        Panelparacrearvaloracion = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        Volveraverlasvaloraciones = new javax.swing.JButton();
        Botondificul = new javax.swing.JTextField();
        Botonestre = new javax.swing.JTextField();
        BotonIntere = new javax.swing.JTextField();
        Botonbelle = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        Botonrese = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        Botonparacrearvaloracion = new javax.swing.JButton();
        PanelCalendario = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        TablaCalendarios = new javax.swing.JTable();
        BotonarutasdesdeCatalogo = new javax.swing.JButton();
        botoncrearcalendario = new javax.swing.JButton();
        CrearCalendario = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        VolveraCalendario = new javax.swing.JButton();
        Creardetall = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        CrearRecomen = new javax.swing.JTextField();
        botoncrearcalendariode0 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        añadefech = new javax.swing.JTextField();

        jTextField7.setText("jTextField7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        PanelEntrada.setBackground(new java.awt.Color(153, 255, 153));
        PanelEntrada.setForeground(new java.awt.Color(255, 255, 255));
        PanelEntrada.setMaximumSize(new java.awt.Dimension(600, 400));
        PanelEntrada.setMinimumSize(new java.awt.Dimension(600, 400));
        PanelEntrada.setPreferredSize(new java.awt.Dimension(600, 400));

        CuadroEntrada.setBackground(new java.awt.Color(0, 0, 0));
        CuadroEntrada.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        CuadroEntrada.setForeground(new java.awt.Color(51, 51, 255));
        CuadroEntrada.setText("Aplicacion de Rutas");
        CuadroEntrada.setAlignmentX(200.0F);
        CuadroEntrada.setAlignmentY(200.0F);

        BotonEntrada.setBackground(new java.awt.Color(51, 255, 51));
        BotonEntrada.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        BotonEntrada.setForeground(new java.awt.Color(0, 102, 0));
        BotonEntrada.setText("Iniciar aplicacion");
        BotonEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEntradaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelEntradaLayout = new javax.swing.GroupLayout(PanelEntrada);
        PanelEntrada.setLayout(PanelEntradaLayout);
        PanelEntradaLayout.setHorizontalGroup(
            PanelEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEntradaLayout.createSequentialGroup()
                .addContainerGap(210, Short.MAX_VALUE)
                .addGroup(PanelEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEntradaLayout.createSequentialGroup()
                        .addComponent(CuadroEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(155, 155, 155))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEntradaLayout.createSequentialGroup()
                        .addComponent(BotonEntrada)
                        .addGap(215, 215, 215))))
        );
        PanelEntradaLayout.setVerticalGroup(
            PanelEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEntradaLayout.createSequentialGroup()
                .addComponent(CuadroEntrada)
                .addGap(294, 294, 294)
                .addComponent(BotonEntrada)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        getContentPane().add(PanelEntrada, "card2");
        PanelEntrada.getAccessibleContext().setAccessibleName("");

        PanelInicio.setBackground(new java.awt.Color(153, 255, 153));
        PanelInicio.setMaximumSize(new java.awt.Dimension(600, 400));
        PanelInicio.setMinimumSize(new java.awt.Dimension(600, 400));
        PanelInicio.setPreferredSize(new java.awt.Dimension(600, 400));

        TextoInicio.setFont(new java.awt.Font("Times New Roman", 2, 36)); // NOI18N
        TextoInicio.setForeground(new java.awt.Color(51, 51, 255));
        TextoInicio.setText("Rutas al aire libre");

        Salida.setText("Salir de la aplicacion");
        Salida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalidaActionPerformed(evt);
            }
        });

        Rutas.setText("Ver Rutas");
        Rutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RutasActionPerformed(evt);
            }
        });

        Usuario.setText("Registro");
        Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioActionPerformed(evt);
            }
        });

        Cuadro2.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        Cuadro2.setForeground(new java.awt.Color(153, 0, 0));
        Cuadro2.setText("Email");

        Email.setToolTipText("");
        Email.setActionCommand("<Not Set>");
        Email.setName(""); // NOI18N

        Cuadro1.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        Cuadro1.setForeground(new java.awt.Color(153, 0, 0));
        Cuadro1.setText("Contraseña");

        IniciarSesion.setText("Iniciar Sesión");
        IniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelInicioLayout = new javax.swing.GroupLayout(PanelInicio);
        PanelInicio.setLayout(PanelInicioLayout);
        PanelInicioLayout.setHorizontalGroup(
            PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInicioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TextoInicio)
                .addGap(105, 105, 105))
            .addGroup(PanelInicioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Contraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(Email))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelInicioLayout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addComponent(Cuadro2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInicioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Cuadro1)
                .addGap(257, 257, 257))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInicioLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(Usuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addGroup(PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IniciarSesion)
                    .addGroup(PanelInicioLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Rutas)
                        .addGap(105, 105, 105)
                        .addComponent(Salida)))
                .addGap(15, 15, 15))
        );
        PanelInicioLayout.setVerticalGroup(
            PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInicioLayout.createSequentialGroup()
                .addComponent(TextoInicio)
                .addGap(49, 49, 49)
                .addComponent(Cuadro2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(Cuadro1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(IniciarSesion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Salida)
                    .addComponent(Rutas)
                    .addComponent(Usuario))
                .addGap(33, 33, 33))
        );

        Email.getAccessibleContext().setAccessibleName("");

        getContentPane().add(PanelInicio, "card3");

        CrearUsuarios.setBackground(new java.awt.Color(153, 255, 153));
        CrearUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        CrearUsuarios.setMaximumSize(new java.awt.Dimension(600, 400));
        CrearUsuarios.setMinimumSize(new java.awt.Dimension(600, 400));

        Texto.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        Texto.setForeground(new java.awt.Color(0, 0, 255));
        Texto.setText("Crear Usuario");

        Nombre.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        Nombre.setText("Nuevo nombre:");

        apellido.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        apellido.setText("Nuevo apellido:");

        email.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        email.setText("Nuevo email:");

        contraseña.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        contraseña.setText("Nueva Contraseña:");

        rol.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        rol.setText("Elige tu rol:");

        eligerol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "administrador", "diseñador", "profesor", "alumno" }));
        eligerol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eligerolActionPerformed(evt);
            }
        });

        VolverUsuarios.setText("Volver");
        VolverUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverUsuariosActionPerformed(evt);
            }
        });

        darbotonUsuario.setText("Crear Usuario");
        darbotonUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                darbotonUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CrearUsuariosLayout = new javax.swing.GroupLayout(CrearUsuarios);
        CrearUsuarios.setLayout(CrearUsuariosLayout);
        CrearUsuariosLayout.setHorizontalGroup(
            CrearUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrearUsuariosLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(CrearUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CrearUsuariosLayout.createSequentialGroup()
                        .addComponent(email)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearUsuariosLayout.createSequentialGroup()
                        .addGroup(CrearUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Nombre)
                            .addGroup(CrearUsuariosLayout.createSequentialGroup()
                                .addComponent(intronombre, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                                .addGap(164, 164, 164)))
                        .addGap(84, 84, 84)
                        .addGroup(CrearUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(contraseña, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(introcontraseña))
                        .addGap(65, 65, 65))
                    .addGroup(CrearUsuariosLayout.createSequentialGroup()
                        .addGroup(CrearUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(introemail)
                            .addComponent(introapellido, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(apellido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(CrearUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearUsuariosLayout.createSequentialGroup()
                                .addComponent(rol)
                                .addGap(105, 105, 105))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearUsuariosLayout.createSequentialGroup()
                                .addComponent(eligerol, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(CrearUsuariosLayout.createSequentialGroup()
                                .addComponent(darbotonUsuario)
                                .addContainerGap())))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearUsuariosLayout.createSequentialGroup()
                .addContainerGap(242, Short.MAX_VALUE)
                .addGroup(CrearUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearUsuariosLayout.createSequentialGroup()
                        .addComponent(Texto)
                        .addGap(214, 214, 214)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearUsuariosLayout.createSequentialGroup()
                        .addComponent(VolverUsuarios)
                        .addContainerGap())))
        );
        CrearUsuariosLayout.setVerticalGroup(
            CrearUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrearUsuariosLayout.createSequentialGroup()
                .addGroup(CrearUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CrearUsuariosLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1))
                    .addGroup(CrearUsuariosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Texto)
                        .addGap(42, 42, 42)
                        .addGroup(CrearUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Nombre)
                            .addComponent(contraseña))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(CrearUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(intronombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(introcontraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26)
                .addGroup(CrearUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellido)
                    .addComponent(rol))
                .addGap(26, 26, 26)
                .addGroup(CrearUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(introapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eligerol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(email)
                .addGap(18, 18, 18)
                .addGroup(CrearUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(introemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(darbotonUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(VolverUsuarios)
                .addGap(15, 15, 15))
        );

        getContentPane().add(CrearUsuarios, "card5");

        RutasValidas.setBackground(new java.awt.Color(153, 255, 153));
        RutasValidas.setForeground(new java.awt.Color(255, 255, 255));
        RutasValidas.setMaximumSize(new java.awt.Dimension(600, 400));
        RutasValidas.setMinimumSize(new java.awt.Dimension(600, 400));

        VolverInicio.setText("Volver");
        VolverInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverInicioActionPerformed(evt);
            }
        });

        NombreRutas.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        NombreRutas.setForeground(new java.awt.Color(0, 0, 255));
        NombreRutas.setText("Rutas Validas");

        TableRutasValidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TableRutasValidas.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                TableRutasValidasAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        TableRutasValidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableRutasValidasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableRutasValidas);

        Botonparacrearrutas.setText("Crear ruta");
        Botonparacrearrutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonparacrearrutasActionPerformed(evt);
            }
        });

        Botonpararefrecartablas.setText("Refrescar pagina");
        Botonpararefrecartablas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonpararefrecartablasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RutasValidasLayout = new javax.swing.GroupLayout(RutasValidas);
        RutasValidas.setLayout(RutasValidasLayout);
        RutasValidasLayout.setHorizontalGroup(
            RutasValidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RutasValidasLayout.createSequentialGroup()
                .addGroup(RutasValidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RutasValidasLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 28, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RutasValidasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Botonparacrearrutas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(VolverInicio)))
                .addContainerGap())
            .addGroup(RutasValidasLayout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(NombreRutas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Botonpararefrecartablas)
                .addGap(20, 20, 20))
        );
        RutasValidasLayout.setVerticalGroup(
            RutasValidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RutasValidasLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(RutasValidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NombreRutas)
                    .addComponent(Botonpararefrecartablas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(RutasValidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VolverInicio)
                    .addComponent(Botonparacrearrutas))
                .addContainerGap())
        );

        getContentPane().add(RutasValidas, "card6");

        PuntosdeRuta.setBackground(new java.awt.Color(153, 255, 153));
        PuntosdeRuta.setMaximumSize(new java.awt.Dimension(600, 400));
        PuntosdeRuta.setMinimumSize(new java.awt.Dimension(600, 400));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 255));
        jLabel2.setText("PuntosInteres");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 255));
        jLabel3.setText("Puntos peligro");

        TablePuntosInteres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TablePuntosInteres.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                TablePuntosInteresAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        TablePuntosInteres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablePuntosInteresMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TablePuntosInteres);

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        TablePuntosPeligro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TablePuntosPeligro.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                TablePuntosPeligroAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        TablePuntosPeligro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablePuntosPeligroMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TablePuntosPeligro);

        javax.swing.GroupLayout PuntosdeRutaLayout = new javax.swing.GroupLayout(PuntosdeRuta);
        PuntosdeRuta.setLayout(PuntosdeRutaLayout);
        PuntosdeRutaLayout.setHorizontalGroup(
            PuntosdeRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PuntosdeRutaLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(97, 97, 97))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PuntosdeRutaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PuntosdeRutaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(23, 23, 23))
        );
        PuntosdeRutaLayout.setVerticalGroup(
            PuntosdeRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PuntosdeRutaLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(PuntosdeRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(PuntosdeRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(27, 27, 27))
        );

        getContentPane().add(PuntosdeRuta, "card7");

        ValoracionesdeRuta.setBackground(new java.awt.Color(153, 255, 153));
        ValoracionesdeRuta.setMaximumSize(new java.awt.Dimension(600, 400));
        ValoracionesdeRuta.setMinimumSize(new java.awt.Dimension(600, 400));

        jLabel4.setBackground(new java.awt.Color(102, 102, 255));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 255));
        jLabel4.setText("Valoraciones");

        jButton2.setText("Volver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        TablaValoraciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TablaValoraciones.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                TablaValoracionesAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        TablaValoraciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaValoracionesMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(TablaValoraciones);

        botoncrearvaloracion.setText("Crear Valoracion");
        botoncrearvaloracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoncrearvaloracionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ValoracionesdeRutaLayout = new javax.swing.GroupLayout(ValoracionesdeRuta);
        ValoracionesdeRuta.setLayout(ValoracionesdeRutaLayout);
        ValoracionesdeRutaLayout.setHorizontalGroup(
            ValoracionesdeRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ValoracionesdeRutaLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(ValoracionesdeRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ValoracionesdeRutaLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(227, 227, 227))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ValoracionesdeRutaLayout.createSequentialGroup()
                        .addGroup(ValoracionesdeRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                            .addGroup(ValoracionesdeRutaLayout.createSequentialGroup()
                                .addComponent(botoncrearvaloracion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)))
                        .addGap(18, 18, 18))))
        );
        ValoracionesdeRutaLayout.setVerticalGroup(
            ValoracionesdeRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ValoracionesdeRutaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addGroup(ValoracionesdeRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(botoncrearvaloracion))
                .addContainerGap())
        );

        getContentPane().add(ValoracionesdeRuta, "card8");

        Actividades.setBackground(new java.awt.Color(153, 255, 153));
        Actividades.setMaximumSize(new java.awt.Dimension(600, 400));
        Actividades.setMinimumSize(new java.awt.Dimension(600, 400));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 255));
        jLabel5.setText("Actividades");

        TablaActividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TablaActividades.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                TablaActividadesAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        TablaActividades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaActividadesMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(TablaActividades);

        jButton3.setText("Volver");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ActividadesLayout = new javax.swing.GroupLayout(Actividades);
        Actividades.setLayout(ActividadesLayout);
        ActividadesLayout.setHorizontalGroup(
            ActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ActividadesLayout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addGroup(ActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ActividadesLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(238, 238, 238))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ActividadesLayout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ActividadesLayout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(20, 20, 20))))
        );
        ActividadesLayout.setVerticalGroup(
            ActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ActividadesLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        getContentPane().add(Actividades, "card9");

        DetallesRuta.setBackground(new java.awt.Color(153, 255, 153));
        DetallesRuta.setMaximumSize(new java.awt.Dimension(600, 400));
        DetallesRuta.setMinimumSize(new java.awt.Dimension(600, 400));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 255));
        jLabel6.setText("Detalles");

        jButton4.setText("Volver");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        TablaDetallesruta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TablaDetallesruta.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                TablaDetallesrutaAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane7.setViewportView(TablaDetallesruta);

        javax.swing.GroupLayout DetallesRutaLayout = new javax.swing.GroupLayout(DetallesRuta);
        DetallesRuta.setLayout(DetallesRutaLayout);
        DetallesRutaLayout.setHorizontalGroup(
            DetallesRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DetallesRutaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(256, 256, 256))
            .addGroup(DetallesRutaLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(DetallesRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 18, Short.MAX_VALUE))
        );
        DetallesRutaLayout.setVerticalGroup(
            DetallesRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DetallesRutaLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addComponent(jButton4)
                .addGap(18, 18, 18))
        );

        getContentPane().add(DetallesRuta, "card10");

        ImagenesInteres.setBackground(new java.awt.Color(153, 255, 153));

        NombreImagenesInteres.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        NombreImagenesInteres.setForeground(new java.awt.Color(0, 0, 255));
        NombreImagenesInteres.setText("Imágenes interes");

        TablaimagenesInteres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TablaimagenesInteres.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                TablaimagenesInteresAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        TablaimagenesInteres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaimagenesInteresMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TablaimagenesInteres);

        jButton5.setText("Volver");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ImagenesInteresLayout = new javax.swing.GroupLayout(ImagenesInteres);
        ImagenesInteres.setLayout(ImagenesInteresLayout);
        ImagenesInteresLayout.setHorizontalGroup(
            ImagenesInteresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImagenesInteresLayout.createSequentialGroup()
                .addContainerGap(128, Short.MAX_VALUE)
                .addGroup(ImagenesInteresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ImagenesInteresLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ImagenesInteresLayout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(26, 26, 26))))
            .addGroup(ImagenesInteresLayout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(NombreImagenesInteres)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        ImagenesInteresLayout.setVerticalGroup(
            ImagenesInteresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImagenesInteresLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(NombreImagenesInteres)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(32, 32, 32))
        );

        getContentPane().add(ImagenesInteres, "card11");

        ImagenesPeligro.setBackground(new java.awt.Color(153, 255, 153));
        ImagenesPeligro.setMaximumSize(new java.awt.Dimension(600, 400));
        ImagenesPeligro.setMinimumSize(new java.awt.Dimension(600, 400));

        Cuadroimagenespeligro.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        Cuadroimagenespeligro.setForeground(new java.awt.Color(0, 0, 255));
        Cuadroimagenespeligro.setText("Imagenes Peligro");

        TablaImagenesPeligro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TablaImagenesPeligro.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                TablaImagenesPeligroAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        TablaImagenesPeligro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaImagenesPeligroMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(TablaImagenesPeligro);

        votonimagenvolverpeligro.setText("Volver");
        votonimagenvolverpeligro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                votonimagenvolverpeligroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ImagenesPeligroLayout = new javax.swing.GroupLayout(ImagenesPeligro);
        ImagenesPeligro.setLayout(ImagenesPeligroLayout);
        ImagenesPeligroLayout.setHorizontalGroup(
            ImagenesPeligroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ImagenesPeligroLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(votonimagenvolverpeligro)
                .addGap(40, 40, 40))
            .addGroup(ImagenesPeligroLayout.createSequentialGroup()
                .addGroup(ImagenesPeligroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ImagenesPeligroLayout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(Cuadroimagenespeligro))
                    .addGroup(ImagenesPeligroLayout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        ImagenesPeligroLayout.setVerticalGroup(
            ImagenesPeligroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImagenesPeligroLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(Cuadroimagenespeligro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(votonimagenvolverpeligro)
                .addGap(26, 26, 26))
        );

        getContentPane().add(ImagenesPeligro, "card11");

        CrearRutasde0.setBackground(new java.awt.Color(153, 255, 153));
        CrearRutasde0.setMaximumSize(new java.awt.Dimension(600, 400));
        CrearRutasde0.setMinimumSize(new java.awt.Dimension(600, 400));

        Cuadrodecrearrutas.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        Cuadrodecrearrutas.setForeground(new java.awt.Color(0, 0, 153));
        Cuadrodecrearrutas.setText("Crear Rutas");

        volverdecrearruta.setText("Volver");
        volverdecrearruta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverdecrearrutaActionPerformed(evt);
            }
        });

        jLabel7.setText("Nombre de la ruta");

        jLabel8.setText("Nombre de inicio ruta");

        jLabel9.setText("Latitud");

        jLabel10.setText("Longitud");

        jLabel11.setText("Nombre fin de ruta");

        jLabel12.setText("Latitud");

        jLabel13.setText("Longitud");

        jLabel14.setText("Distancia");

        jLabel15.setText("Duracion:HH:mm:ss");

        Botonparacrearruta.setText("Crear Ruta");
        Botonparacrearruta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonparacrearrutaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CrearRutasde0Layout = new javax.swing.GroupLayout(CrearRutasde0);
        CrearRutasde0.setLayout(CrearRutasde0Layout);
        CrearRutasde0Layout.setHorizontalGroup(
            CrearRutasde0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearRutasde0Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(CrearRutasde0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Botonparacrearruta, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(144, 144, 144)
                .addComponent(volverdecrearruta)
                .addGap(34, 34, 34))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearRutasde0Layout.createSequentialGroup()
                .addGroup(CrearRutasde0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CrearRutasde0Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(CrearRutasde0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreinicio, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(CrearRutasde0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Cuadrodecrearrutas)
                                .addGroup(CrearRutasde0Layout.createSequentialGroup()
                                    .addGroup(CrearRutasde0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ldi, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(li, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(CrearRutasde0Layout.createSequentialGroup()
                                            .addGap(8, 8, 8)
                                            .addComponent(jLabel10))
                                        .addComponent(jLabel8))
                                    .addGap(200, 200, 200))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE))
                    .addGroup(CrearRutasde0Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(CrearRutasde0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CrearRutasde0Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel14))
                            .addGroup(CrearRutasde0Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel15))
                            .addGroup(CrearRutasde0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(duracion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                .addComponent(distancia, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(nombreruta, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)))
                .addGroup(CrearRutasde0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearRutasde0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(nombrefini, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ldf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addGroup(CrearRutasde0Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel13))
                    .addComponent(lf, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );
        CrearRutasde0Layout.setVerticalGroup(
            CrearRutasde0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrearRutasde0Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Cuadrodecrearrutas)
                .addGap(23, 23, 23)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(CrearRutasde0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CrearRutasde0Layout.createSequentialGroup()
                        .addGroup(CrearRutasde0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CrearRutasde0Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(CrearRutasde0Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nombreruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14)
                        .addGroup(CrearRutasde0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearRutasde0Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(distancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))
                            .addGroup(CrearRutasde0Layout.createSequentialGroup()
                                .addGroup(CrearRutasde0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nombrefini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nombreinicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(CrearRutasde0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(CrearRutasde0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(li, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(CrearRutasde0Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel8)))
                .addGap(2, 2, 2)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CrearRutasde0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13)
                    .addComponent(duracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CrearRutasde0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CrearRutasde0Layout.createSequentialGroup()
                        .addComponent(ldf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverdecrearruta)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearRutasde0Layout.createSequentialGroup()
                        .addComponent(ldi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(Botonparacrearruta)
                        .addGap(35, 35, 35))))
        );

        getContentPane().add(CrearRutasde0, "card12");

        CatalogodeRutas.setBackground(new java.awt.Color(153, 255, 153));
        CatalogodeRutas.setMaximumSize(new java.awt.Dimension(600, 400));
        CatalogodeRutas.setMinimumSize(new java.awt.Dimension(600, 400));

        Nombrerutasinavlidas.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        Nombrerutasinavlidas.setForeground(new java.awt.Color(0, 0, 204));
        Nombrerutasinavlidas.setText("Rutas no validadas");

        Tabladerutasnovalidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tabladerutasnovalidas.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                TabladerutasnovalidasAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        Tabladerutasnovalidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabladerutasnovalidasMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(Tabladerutasnovalidas);

        volverarutasdesdeno.setText("Volver");
        volverarutasdesdeno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverarutasdesdenoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CatalogodeRutasLayout = new javax.swing.GroupLayout(CatalogodeRutas);
        CatalogodeRutas.setLayout(CatalogodeRutasLayout);
        CatalogodeRutasLayout.setHorizontalGroup(
            CatalogodeRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CatalogodeRutasLayout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(Nombrerutasinavlidas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CatalogodeRutasLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(CatalogodeRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(volverarutasdesdeno)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );
        CatalogodeRutasLayout.setVerticalGroup(
            CatalogodeRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CatalogodeRutasLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(Nombrerutasinavlidas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(volverarutasdesdeno)
                .addContainerGap())
        );

        getContentPane().add(CatalogodeRutas, "card13");

        Panelparacrearvaloracion.setBackground(new java.awt.Color(153, 255, 153));
        Panelparacrearvaloracion.setMaximumSize(new java.awt.Dimension(600, 400));
        Panelparacrearvaloracion.setMinimumSize(new java.awt.Dimension(600, 400));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 51, 255));
        jLabel16.setText("Crear Valoracion");

        Volveraverlasvaloraciones.setText("Volver");
        Volveraverlasvaloraciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolveraverlasvaloracionesActionPerformed(evt);
            }
        });

        jLabel17.setText("Dificultad 1-5");

        jLabel18.setText("Estrellas 1-5");

        jLabel19.setText("Interes Cultural 1-5");

        jLabel20.setText("Belleza 1-5");

        jLabel21.setText("Crear Reseña");

        Botonparacrearvaloracion.setText("Crear Valoracion");
        Botonparacrearvaloracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonparacrearvaloracionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelparacrearvaloracionLayout = new javax.swing.GroupLayout(Panelparacrearvaloracion);
        Panelparacrearvaloracion.setLayout(PanelparacrearvaloracionLayout);
        PanelparacrearvaloracionLayout.setHorizontalGroup(
            PanelparacrearvaloracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelparacrearvaloracionLayout.createSequentialGroup()
                .addContainerGap(216, Short.MAX_VALUE)
                .addGroup(PanelparacrearvaloracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelparacrearvaloracionLayout.createSequentialGroup()
                        .addComponent(Volveraverlasvaloraciones)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelparacrearvaloracionLayout.createSequentialGroup()
                        .addGroup(PanelparacrearvaloracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16)
                            .addGroup(PanelparacrearvaloracionLayout.createSequentialGroup()
                                .addComponent(Botonparacrearvaloracion)
                                .addGap(30, 30, 30)))
                        .addGap(209, 209, 209))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelparacrearvaloracionLayout.createSequentialGroup()
                .addGroup(PanelparacrearvaloracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelparacrearvaloracionLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel19))
                    .addGroup(PanelparacrearvaloracionLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(PanelparacrearvaloracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Botonbelle, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(Botondificul)
                            .addComponent(BotonIntere))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelparacrearvaloracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelparacrearvaloracionLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(75, 75, 75))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelparacrearvaloracionLayout.createSequentialGroup()
                        .addComponent(Botonestre, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(PanelparacrearvaloracionLayout.createSequentialGroup()
                        .addComponent(Botonrese, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(PanelparacrearvaloracionLayout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(jLabel20)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(PanelparacrearvaloracionLayout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(90, 90, 90))
        );
        PanelparacrearvaloracionLayout.setVerticalGroup(
            PanelparacrearvaloracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelparacrearvaloracionLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addGap(25, 25, 25)
                .addGroup(PanelparacrearvaloracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelparacrearvaloracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Botonestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Botondificul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(PanelparacrearvaloracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addGroup(PanelparacrearvaloracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonIntere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Botonrese, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(Botonbelle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(Botonparacrearvaloracion)
                .addGap(2, 2, 2)
                .addComponent(Volveraverlasvaloraciones)
                .addGap(20, 20, 20))
        );

        getContentPane().add(Panelparacrearvaloracion, "card14");

        PanelCalendario.setBackground(new java.awt.Color(153, 255, 153));
        PanelCalendario.setMaximumSize(new java.awt.Dimension(600, 400));
        PanelCalendario.setMinimumSize(new java.awt.Dimension(600, 400));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 51, 255));
        jLabel22.setText("Calendarios");

        TablaCalendarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TablaCalendarios.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                TablaCalendariosAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        TablaCalendarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaCalendariosMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(TablaCalendarios);

        BotonarutasdesdeCatalogo.setText("Volver");
        BotonarutasdesdeCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonarutasdesdeCatalogoActionPerformed(evt);
            }
        });

        botoncrearcalendario.setText("Crear Calendario");
        botoncrearcalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoncrearcalendarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelCalendarioLayout = new javax.swing.GroupLayout(PanelCalendario);
        PanelCalendario.setLayout(PanelCalendarioLayout);
        PanelCalendarioLayout.setHorizontalGroup(
            PanelCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCalendarioLayout.createSequentialGroup()
                .addGroup(PanelCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCalendarioLayout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(jLabel22))
                    .addGroup(PanelCalendarioLayout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
            .addGroup(PanelCalendarioLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(botoncrearcalendario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotonarutasdesdeCatalogo)
                .addGap(25, 25, 25))
        );
        PanelCalendarioLayout.setVerticalGroup(
            PanelCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCalendarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(PanelCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botoncrearcalendario)
                    .addComponent(BotonarutasdesdeCatalogo))
                .addGap(16, 16, 16))
        );

        getContentPane().add(PanelCalendario, "card15");

        CrearCalendario.setBackground(new java.awt.Color(153, 255, 153));
        CrearCalendario.setForeground(new java.awt.Color(255, 255, 255));
        CrearCalendario.setMaximumSize(new java.awt.Dimension(600, 400));
        CrearCalendario.setMinimumSize(new java.awt.Dimension(600, 400));

        jLabel23.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 255));
        jLabel23.setText("Crear Calendario para una ruta determinada");

        jLabel24.setText("Detalles");

        VolveraCalendario.setText("Volver");
        VolveraCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolveraCalendarioActionPerformed(evt);
            }
        });

        jLabel25.setText("Recomendaciones");

        botoncrearcalendariode0.setText("Crear Calendario");
        botoncrearcalendariode0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoncrearcalendariode0ActionPerformed(evt);
            }
        });

        jLabel26.setText("Fecha yyyy-MM-dd HH:mm");

        javax.swing.GroupLayout CrearCalendarioLayout = new javax.swing.GroupLayout(CrearCalendario);
        CrearCalendario.setLayout(CrearCalendarioLayout);
        CrearCalendarioLayout.setHorizontalGroup(
            CrearCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearCalendarioLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(VolveraCalendario)
                .addGap(42, 42, 42))
            .addGroup(CrearCalendarioLayout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addGap(87, 87, 87))
            .addGroup(CrearCalendarioLayout.createSequentialGroup()
                .addGroup(CrearCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CrearCalendarioLayout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(botoncrearcalendariode0))
                    .addGroup(CrearCalendarioLayout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel26)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(CrearCalendarioLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(CrearCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CrearCalendarioLayout.createSequentialGroup()
                        .addComponent(añadefech, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(CrearCalendarioLayout.createSequentialGroup()
                        .addGroup(CrearCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CrearCalendarioLayout.createSequentialGroup()
                                .addComponent(Creardetall, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                                .addComponent(CrearRecomen, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel23))
                        .addGap(59, 59, 59))))
        );
        CrearCalendarioLayout.setVerticalGroup(
            CrearCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrearCalendarioLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel23)
                .addGap(37, 37, 37)
                .addGroup(CrearCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25))
                .addGap(18, 18, 18)
                .addGroup(CrearCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Creardetall, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CrearRecomen, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(añadefech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(botoncrearcalendariode0)
                .addGap(27, 27, 27)
                .addComponent(VolveraCalendario)
                .addGap(39, 39, 39))
        );

        getContentPane().add(CrearCalendario, "card16");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEntradaActionPerformed
        PanelEntrada.setVisible(false);
        PanelInicio.setVisible(true);
    }//GEN-LAST:event_BotonEntradaActionPerformed

    private void SalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalidaActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "Desea salir de la aplicacion", "Salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_SalidaActionPerformed

    private void RutasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RutasActionPerformed
        PanelInicio.setVisible(false);
        RutasValidas.setVisible(true);
        TableRutasValidas.setVisible(true);
        VolverInicio.setVisible(true);
        jScrollPane1.setVisible(true);
        Botonpararefrecartablas.setVisible(true);

    }//GEN-LAST:event_RutasActionPerformed

    private void IniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarSesionActionPerformed
        String email = Email.getText();
        char[] passwordChars = Contraseña.getPassword();
        String password = new String(passwordChars);
        if (Teclado.validaemail(email) && Teclado.validapassword(password)) {
            DAOUsuario d = new DAOUsuario();
            Usuario U1 = d.encontrarUsuario(email, password);
            if (U1 != null) {
                PanelInicio.setVisible(false);
                RutasValidas.setVisible(true);
                TableRutasValidas.setVisible(true);
                VolverInicio.setVisible(true);
                jScrollPane1.setVisible(true);
                Botonpararefrecartablas.setVisible(true);
                usuario = U1;
                if (usuario.getRol() == Roles.administrador || usuario.getRol() == Roles.diseñador || usuario.getRol() == Roles.profesor) {
                    Botonparacrearrutas.setVisible(true);
                }
                if (usuario.getRol() == Roles.administrador || usuario.getRol() == Roles.diseñador || usuario.getRol() == Roles.profesor || usuario.getRol() == Roles.alumno) {
                    botoncrearvaloracion.setVisible(true);
                }
                if (usuario.getRol() == Roles.profesor || usuario.getRol() == Roles.administrador) {
                    botoncrearcalendario.setVisible(true);
                }
            }
            if (U1 == null) {
                JOptionPane.showMessageDialog(null, "No se encontro a ningun usuario con ese email o contraseña", "Volver", JOptionPane.PLAIN_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Formato mal introducido el email o contraseña", "Volver", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_IniciarSesionActionPerformed

    private void UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioActionPerformed
        CrearUsuarios.setVisible(true);
        PanelInicio.setVisible(false);
    }//GEN-LAST:event_UsuarioActionPerformed

    private void eligerolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eligerolActionPerformed

    }//GEN-LAST:event_eligerolActionPerformed

    private void VolverUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverUsuariosActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "Desea volver a menu de inicio", "Volver", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == 0) {
            CrearUsuarios.setVisible(false);
            PanelInicio.setVisible(true);
        }
    }//GEN-LAST:event_VolverUsuariosActionPerformed

    private void darbotonUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_darbotonUsuarioActionPerformed
        char[] passwordChars = introcontraseña.getPassword();
        String password = new String(passwordChars);
        String nombre = intronombre.getText();
        String apellidos = introapellido.getText();
        String emails = introemail.getText();
        Roles rol = null;
        String seleccion = eligerol.getSelectedItem().toString();
        if (seleccion.equals("administrador")) {
            rol = Roles.administrador;
        } else if (seleccion.equals("diseñador")) {
            rol = Roles.diseñador;
        } else if (seleccion.equals("profesor")) {
            rol = Roles.profesor;
        } else if (seleccion.equals("alumno")) {
            rol = Roles.alumno;
        }
        if (Teclado.validanombre(nombre) && Teclado.validaapellido(apellidos) && Teclado.validaemail(emails)) {
            Usuario usu = new Usuario(nombre, apellidos, emails, password, rol);
            DAOUsuario u1 = new DAOUsuario();
            if (u1.insertar(usu)) {
                JOptionPane.showMessageDialog(null, "Se creo el usuario correctamnete", "Bien", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se guardo el usuario en la base de datos, email ya existe", "Error", JOptionPane.PLAIN_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Formato mal introducido el formato de uno de los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_darbotonUsuarioActionPerformed

    private void VolverInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverInicioActionPerformed
        CrearUsuarios.setVisible(false);
        PanelInicio.setVisible(true);
        usuario = null;
        TableRutasValidas.setVisible(false);
        VolverInicio.setVisible(false);
        jScrollPane1.setVisible(false);
        Botonparacrearrutas.setVisible(false);
        botoncrearvaloracion.setVisible(false);
        botoncrearcalendario.setVisible(false);
        CatalogodeRutas.setVisible(true);
        volverarutasdesdeno.setVisible(false);
        jScrollPane9.setVisible(false);
        Tabladerutasnovalidas.setVisible(false);
        Botonpararefrecartablas.setVisible(false);
        limpiartablasalvolver();
    }//GEN-LAST:event_VolverInicioActionPerformed
    // Metodo para modificar la tabla de Rutas aprobadas
    private void TableRutasValidasAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_TableRutasValidasAncestorAdded
        DAORutas daoruta = new DAORutas();
        List<Rutas> lisruta = daoruta.listaraprobadas();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Ruta");
        model.addColumn("Nombre");
        model.addColumn("Duracion");
        model.addColumn("Distancia");
        model.addColumn("Nombre del inicio de ruta");
        model.addColumn("Latitud ");
        model.addColumn("Longitud ");
        model.addColumn("Nombre del final de ruta");
        model.addColumn("Latitud");
        model.addColumn("Longitud");
        for (Rutas r : lisruta) {
            Object[] fila = {r.getIdRuta(), r.getNombre(), r.getDuracion(), r.getDistancia(), r.getNombre_inicioruta(), r.getLatitudInicial(), r.getLongitudInicial(), r.getNombre_finalruta(), r.getLatitudFinal(), r.getLongitudFinal()};
            model.addRow(fila);
        }
        TableRutasValidas.setModel(model);
        TableRutasValidas.setAutoCreateRowSorter(true);
        tamañocolumnasRutaValidas();
    }//GEN-LAST:event_TableRutasValidasAncestorAdded
    //Al hacer click en una fila de la tabla RutasValidas
    private void TableRutasValidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableRutasValidasMouseClicked
        int fila = TableRutasValidas.getSelectedRow(); // Fila que has clicado 
        if (fila != -1) {
            Object valorColumna0 = TableRutasValidas.getValueAt(fila, 0); // pillo la columna 0 
            // String resultado = valorColumna0.toString(); si hay que convertirla a toString 
            int resultado = (int) valorColumna0;// valor recogido
            Object[] O1 = null;
            if (usuario == null) {
                O1 = new Object[]{"Seleccione", "Puntos Interes y Puntos Peligro", "Detalles de la ruta", "Valoraciones", "Actividades", "Calendarios asociados"};
            } else {
                if (usuario.getRol() == Roles.alumno) {
                    O1 = new Object[]{"Seleccione", "Puntos Interes y Puntos Peligro", "Detalles de la ruta", "Valoraciones", "Actividades", "Calendarios asociados", "Ver catalogo de rutas"};
                }
                if (usuario.getRol() == Roles.diseñador) {
                    // crear rutas y valora todo y calendario todo
                    O1 = new Object[]{"Seleccione", "Puntos Interes y Puntos Peligro", "Detalles de la ruta", "Valoraciones", "Actividades", "Calendarios asociados", "Ver catalogo de rutas", "Descargar Ficha de rutas validas"};
                }
                if (usuario.getRol() == Roles.profesor) {
                    // crear ruta y valora todo y ca
                    O1 = new Object[]{"Seleccione", "Puntos Interes y Puntos Peligro", "Detalles de la ruta", "Valoraciones", "Actividades", "Calendarios asociados", "Ver catalogo de rutas ", "Descargar Ficha de rutas validas"};
                }
                if (usuario.getRol() == Roles.administrador) {
                    // modifica ruta , todo ruta, todo valora y todo calendario
                    O1 = new Object[]{"Seleccione", "Puntos Interes y Puntos Peligro", "Detalles de la ruta", "Valoraciones", "Actividades", "Calendarios asociados", "Ver catalogo de rutas", "Descargar Ficha informativa", "Borrar ruta", "Modificar Ruta"};
                }
            }
            DAORutas daor = new DAORutas();
            idrutaapipp = resultado;
            //Para elegir entre diferentes opciones
            Object opcion = JOptionPane.showInputDialog(null, "Seleccione una opcion",
                    "Opcion de ruta", JOptionPane.QUESTION_MESSAGE, null,
                    O1, "Seleccione");
            switch (opcion.toString()) {
                case "Seleccione" -> {
                    JOptionPane.showMessageDialog(null, "No introdujiste ninguna opcion", "Volver", JOptionPane.PLAIN_MESSAGE);
                }
                case "Puntos Interes y Puntos Peligro" -> {
                    RutasValidas.setVisible(false);
                    PuntosdeRuta.setVisible(true);
                }
                case "Detalles de la ruta" -> {
                    RutasValidas.setVisible(false);
                    DetallesRuta.setVisible(true);
                }
                case "Valoraciones" -> {
                    RutasValidas.setVisible(false);
                    ValoracionesdeRuta.setVisible(true);
                }
                case "Actividades" -> {
                    RutasValidas.setVisible(false);
                    Actividades.setVisible(true);
                }
                case "Calendarios asociados" -> {
                    RutasValidas.setVisible(false);
                    PanelCalendario.setVisible(true);
                    Nombrerutasinavlidas.setVisible(false);
                    jLabel22.setVisible(true);
                    this.botoncrearcalendario.setVisible(true);
                }
                case "Ver catalogo de rutas" -> {
                    RutasValidas.setVisible(false);
                    CatalogodeRutas.setVisible(true);
                    volverarutasdesdeno.setVisible(true);
                    Tabladerutasnovalidas.setVisible(true);
                    jScrollPane9.setVisible(true);
                    Nombrerutasinavlidas.setVisible(true);
                }
                case "Descargar Ficha de rutas validas" -> {
                    FichaUsuario f1 = new FichaUsuario();
                    Rutas ruta = daor.buscarTodaInfo(idrutaapipp);
                    if (f1.generarFicha(ruta)) {
                        JOptionPane.showMessageDialog(null, "Se descargo la ficha en la carpeta fichas del proyecto", "Bien", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                case "Descargar Ficha informativa" -> {
                    FichaUsuario f1 = new FichaUsuario();
                    FichaSeguridad f2 = new FichaSeguridad();
                    FichaOrganizacion f3 = new FichaOrganizacion();
                    Rutas ruta = daor.buscarTodaInfo(idrutaapipp);
                    if (f1.generarFicha(ruta) && f2.generarFicha(ruta) && f3.generarFicha(ruta)) {
                        JOptionPane.showMessageDialog(null, "Se descargaron las fichas en la carpeta fichas del proyecto", "Bien", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                case "Borrar ruta" -> {
                    if (daor.eliminar(idrutaapipp)) {
                        JOptionPane.showMessageDialog(null, "Se elimino la ruta numero: " + this.idrutaapipp, "Bien", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        }
    }//GEN-LAST:event_TableRutasValidasMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "Desea volver a  ver las rutas", "Volver", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == 0) {
            idrutaapipp = 1;
            RutasValidas.setVisible(true);
            PuntosdeRuta.setVisible(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    // Metodo para modificar la tabla puntos interes
    private void TablePuntosInteresAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_TablePuntosInteresAncestorAdded
        DAOPuntosinteres daopi = new DAOPuntosinteres();
        List<PuntosInteres> lispi = daopi.listar(idrutaapipp);// cambiar el metodo listar de dao puntos interes de Ruta ruta a int id 
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID PuntosInteres");
        model.addColumn("Nombre");
        model.addColumn("Latitud");
        model.addColumn("Longitud");
        model.addColumn("Elevacion");
        model.addColumn("Descripcion");
        for (PuntosInteres pp : lispi) {
            Object[] fila = {pp.getIdPuntosInteres(), pp.getNombre(), pp.getLatitud(), pp.getLongitud(), pp.getElevacion(), pp.getDescripcion()};
            model.addRow(fila);
        }
        TablePuntosInteres.setModel(model);
        TablePuntosInteres.setAutoCreateRowSorter(true);
        TablePuntosInteres.getColumnModel().getColumn(0).setMinWidth(0);
        TablePuntosInteres.getColumnModel().getColumn(0).setMaxWidth(0);
        TablePuntosInteres.getColumnModel().getColumn(0).setPreferredWidth(0);
    }//GEN-LAST:event_TablePuntosInteresAncestorAdded
    // modica la tabla puntos peligro
    private void TablePuntosPeligroAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_TablePuntosPeligroAncestorAdded
        DAOPuntospeligro daopp = new DAOPuntospeligro();
        List<PuntosPeligro> lispp = daopp.listar(idrutaapipp);// cambiar el metodo listar de dao puntos peligro de Ruta ruta a int id 
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID PuntosPeligro");
        model.addColumn("Nombre");
        model.addColumn("Latitud");
        model.addColumn("Longitud");
        model.addColumn("Elevacion");
        model.addColumn("Descripcion");
        for (PuntosPeligro pp : lispp) {
            Object[] fila = {pp.getIdPuntospeligro(), pp.getNombre(), pp.getLatitud(), pp.getLongitud(), pp.getElevacion(), pp.getDescripcion()};
            model.addRow(fila);
        }
        TablePuntosPeligro.setAutoCreateRowSorter(true);
        TablePuntosPeligro.setModel(model);
        TablePuntosPeligro.getColumnModel().getColumn(0).setMinWidth(0);
        TablePuntosPeligro.getColumnModel().getColumn(0).setMaxWidth(0);
        TablePuntosPeligro.getColumnModel().getColumn(0).setPreferredWidth(0);
    }//GEN-LAST:event_TablePuntosPeligroAncestorAdded

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "Desea volver a ver las rutas", "Volver", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == 0) {
            idrutaapipp = 1;
            RutasValidas.setVisible(true);
            ValoracionesdeRuta.setVisible(false);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "Desea volver a ver las rutas", "Volver", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == 0) {
            idrutaapipp = 1;
            RutasValidas.setVisible(true);
            Actividades.setVisible(false);
        }
    }//GEN-LAST:event_jButton3ActionPerformed
// modifica la tabla actividades
    private void TablaActividadesAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_TablaActividadesAncestorAdded
        DAOActividad daoa = new DAOActividad();
        List<Actividad> lisa = daoa.listar(idrutaapipp);// cambiar el metodo listar de dao valoraciones de Ruta ruta a int id 
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Actividad");
        model.addColumn("Nombre");
        for (Actividad a : lisa) {
            Object[] fila = {a.getIdActividad(), a.getNombre()};
            model.addRow(fila);
        }
        TablaActividades.getColumnModel().getColumn(0).setMinWidth(0);
        TablaActividades.getColumnModel().getColumn(0).setMaxWidth(0);
        TablaActividades.getColumnModel().getColumn(0).setPreferredWidth(0);
        TablaActividades.setAutoCreateRowSorter(true);
        TablaActividades.setModel(model);
    }//GEN-LAST:event_TablaActividadesAncestorAdded

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "Desea volver a ver las rutas", "Volver", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == 0) {
            idrutaapipp = 1;
            RutasValidas.setVisible(true);
            DetallesRuta.setVisible(false);
        }
    }//GEN-LAST:event_jButton4ActionPerformed
// Tabla con los detalles 
    private void TablaDetallesrutaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_TablaDetallesrutaAncestorAdded
        DAORutas daor = new DAORutas();
        Rutas ruta = daor.buscarTodaInfo(idrutaapipp);// cambiar el metodo listar de dao valoraciones de Ruta ruta a int id
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Ruta");
        model.addColumn("Nombre");
        model.addColumn("Nombre del inicio de ruta");
        model.addColumn("Latitud ");
        model.addColumn("Longitud ");
        model.addColumn("Nombre del final de ruta");
        model.addColumn("Latitud");
        model.addColumn("Longitud");
        model.addColumn("Duracion");
        model.addColumn("Distancia");
        model.addColumn("Clasificacion");
        model.addColumn("Nivel Esfuerzo");
        model.addColumn("Nivel Riesgo");
        model.addColumn("Estado Ruta");
        model.addColumn("Tipo Terreno");
        model.addColumn("Indicaciones");
        model.addColumn("Ruta Familiar");
        model.addColumn("Media Estrellas");
        Object[] fila = {ruta.getIdRuta(), ruta.getNombre(), ruta.getNombre_inicioruta(), ruta.getLatitudInicial(), ruta.getLongitudInicial(), ruta.getNombre_finalruta(), ruta.getLatitudFinal(), ruta.getLongitudFinal(), ruta.getDuracion(), ruta.getDistancia(), ruta.getClasificacion(), ruta.getNivelEsfuerzo(), ruta.getNivelriesgo(), ruta.getEstadoRuta(), ruta.getTipoterreno(), ruta.getIndicaciones(), ruta.isRutaFamiliar(), ruta.getMediaEstrellas()};
        model.addRow(fila);
        TablaDetallesruta.setModel(model);
        tamañocolumnasDetalles();
    }//GEN-LAST:event_TablaDetallesrutaAncestorAdded

    // Tabla rellena con las valoraciones de un usuario
    private void TablaValoracionesAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_TablaValoracionesAncestorAdded
        DAOValora daov = new DAOValora();
        List<Valora> lisv = daov.listar(idrutaapipp);// cambiar el metodo listar de dao valoraciones de Ruta ruta a int id
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Valora");
        model.addColumn("Dificultad");
        model.addColumn("Fecha");
        model.addColumn("Estrellas");
        model.addColumn("Interes Cultural");
        model.addColumn("Belleza");
        for (Valora v : lisv) {
            Object[] fila = {v.getIdValora(), v.getDificultad(), v.getFecha(), v.getEstrellas(), v.getInteresCultural(), v.getBelleza()};
            model.addRow(fila);
        }
        TablaValoraciones.setAutoCreateRowSorter(true);
        TablaValoraciones.getColumnModel().getColumn(0).setMinWidth(0);
        TablaValoraciones.getColumnModel().getColumn(0).setMaxWidth(0);
        TablaValoraciones.getColumnModel().getColumn(0).setPreferredWidth(0);
        TablaValoraciones.setModel(model);
    }//GEN-LAST:event_TablaValoracionesAncestorAdded

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "Desea volver a ver los puntos", "Volver", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == 0) {
            idrutaapipp = 1;
            PuntosdeRuta.setVisible(true);
            ImagenesInteres.setVisible(false);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void TablePuntosInteresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePuntosInteresMouseClicked
        int fila = TablePuntosInteres.getSelectedRow(); // Fila que has clicado 
        if (fila != -1) {
            Object valorColumna0 = TablePuntosInteres.getValueAt(fila, 0); // pillo la columna 0 
            int resultado = (int) valorColumna0;// valor recogido
            int respuesta = JOptionPane.showConfirmDialog(null, "Desea ver las imagenes o borrar los puntos Si-Pasar No-Borrar Punto", "Validar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == 0) {
                idpi = resultado;
            PuntosdeRuta.setVisible(false);
            ImagenesInteres.setVisible(true);
            }else if (respuesta==1){
               DAOPuntosinteres daor = new DAOPuntosinteres();
                if (daor.eliminar(resultado)) {
                     JOptionPane.showMessageDialog(null, "Se elimino el punto de interes", "Bien", JOptionPane.INFORMATION_MESSAGE);
                }
            }   
        }
    }//GEN-LAST:event_TablePuntosInteresMouseClicked

    private void votonimagenvolverpeligroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_votonimagenvolverpeligroActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "Desea volver a ver los puntos", "Volver", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == 0) {
            idrutaapipp = 1;
            PuntosdeRuta.setVisible(true);
            ImagenesPeligro.setVisible(false);
        }
    }//GEN-LAST:event_votonimagenvolverpeligroActionPerformed

    private void TablaImagenesPeligroAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_TablaImagenesPeligroAncestorAdded
      DAOImagenesPeligro daoimg = new DAOImagenesPeligro();
        List<ImagenesPeligro> lisimg = daoimg.listar(idpp);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID PuntosPeligro");
        model.addColumn("URL");
        model.addColumn("Descripcion");

        for (ImagenesPeligro pi : lisimg) {
            try {
                System.out.println("Cargando imagen" + pi.getUrl());
                URL url = new URL(pi.getUrl());
                ImageIcon icono = new ImageIcon(ImageIO.read(url));

                Object[] fila = {pi.getIdimagenespeligro(), icono, pi.getDescripcion()};
                model.addRow(fila);

            } catch (Exception ex) {
                model.addRow(new Object[]{null, "Error al cargar imagen: " + pi.getDescripcion()});
            }
        }
        TablaImagenesPeligro.setModel(model);
        TablaImagenesPeligro.getColumnModel().getColumn(0).setMinWidth(0);
        TablaImagenesPeligro.getColumnModel().getColumn(0).setMaxWidth(0);
       TablaImagenesPeligro.getColumnModel().getColumn(0).setPreferredWidth(0);
       TablaImagenesPeligro.setAutoCreateRowSorter(true);
      TablaImagenesPeligro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = TablaImagenesPeligro.rowAtPoint(e.getPoint());
                int columna = TablaImagenesPeligro.columnAtPoint(e.getPoint());
                if (columna == 1) {
                    ImageIcon icono = (ImageIcon) TablaImagenesPeligro.getValueAt(fila, columna);
                    String descripcion = (String) TablaImagenesPeligro.getValueAt(fila, 2);
                    if (icono != null) {
                        mostrarImagenYDescripcionEnPanel(icono, descripcion);
                    }
                }
            }
        }
        );
    }//GEN-LAST:event_TablaImagenesPeligroAncestorAdded

    private void TablePuntosPeligroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePuntosPeligroMouseClicked
        int fila = TablePuntosPeligro.getSelectedRow(); // Fila que has clicado 
        if (fila != -1) {
            Object valorColumna0 = TablePuntosPeligro.getValueAt(fila, 0); // pillo la columna 0 
            int resultado = (int) valorColumna0;// valor recogido 
            int respuesta = JOptionPane.showConfirmDialog(null, "Desea ver las imagenes o borrar los puntos Si-Pasar No-Borrar Punto", "Validar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == 0) {
            idpi = resultado;
            PuntosdeRuta.setVisible(false);
            ImagenesPeligro.setVisible(true);
            }else if (respuesta==1){
               DAOPuntospeligro daor = new DAOPuntospeligro();
                if (daor.eliminar(resultado)) {
                    JOptionPane.showMessageDialog(null, "Se elimino el punto de interes", "Bien", JOptionPane.INFORMATION_MESSAGE);
                }
        }
      }
    }//GEN-LAST:event_TablePuntosPeligroMouseClicked

    private void BotonparacrearrutasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonparacrearrutasActionPerformed
        RutasValidas.setVisible(false);
        CrearRutasde0.setVisible(true);
    }//GEN-LAST:event_BotonparacrearrutasActionPerformed

    private void volverdecrearrutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverdecrearrutaActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "Desea volver a ver los puntos", "Volver", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == 0) {
            RutasValidas.setVisible(true);
            CrearRutasde0.setVisible(false);
        }
    }//GEN-LAST:event_volverdecrearrutaActionPerformed

    private void BotonparacrearrutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonparacrearrutaActionPerformed
        String nombre = nombreruta.getText();
        String nombreini = nombreinicio.getText();
        String nombrefin = nombrefini.getText();
        String latitudini = li.getText();
        String longitudini = ldi.getText();
        String latitudfin = lf.getText();
        String longitudfin = ldf.getText();
        String distanci = distancia.getText();
        String duracio = duracion.getText();
        if (Teclado.validanombre(nombre) && Teclado.validaInicioFinalRuta(nombreini) && Teclado.validaInicioFinalRuta(nombrefin) && Teclado.validaCoordenadas(latitudini) && Teclado.validaCoordenadas(latitudfin) && Teclado.validaCoordenadas(longitudini) && Teclado.validaCoordenadas(longitudfin) && Teclado.validaDistancia(distanci) && Teclado.validaDuracion(duracio)) {
            LocalTime duracion;
            DateTimeFormatter f = DateTimeFormatter.ofPattern("HH:mm:ss");
            duracion = LocalTime.parse(duracio, f);
            Rutas R1 = new Rutas(nombre, nombreini, nombrefin, Double.parseDouble(latitudini), Double.parseDouble(latitudfin), Double.parseDouble(longitudini), Double.parseDouble(longitudfin), Double.parseDouble(distanci), duracion);
            DAORutas u1 = new DAORutas();
            if (u1.insertar(R1, usuario)) {
                JOptionPane.showMessageDialog(null, "Se creo la ruta correctamnete", "Bien", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se guardo la ruta en la base de datos", "Error", JOptionPane.PLAIN_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Formato mal introducido el formato de uno de los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BotonparacrearrutaActionPerformed

    private void volverarutasdesdenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverarutasdesdenoActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "Desea volver a ver las rutas validas", "Volver", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == 0) {
            RutasValidas.setVisible(true);
            CatalogodeRutas.setVisible(false);
            Tabladerutasnovalidas.setVisible(false);
            volverarutasdesdeno.setVisible(false);
            jScrollPane9.setVisible(false);
            Tabladerutasnovalidas.setVisible(false);
        }
    }//GEN-LAST:event_volverarutasdesdenoActionPerformed
// Tabla con las rutas no validas
    private void TabladerutasnovalidasAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_TabladerutasnovalidasAncestorAdded
        DAORutas daoruta = new DAORutas();
        List<Rutas> lisruta = daoruta.listarsinaprobar();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Ruta");
        model.addColumn("Nombre");
        model.addColumn("Duracion");
        model.addColumn("Distancia");
        model.addColumn("Nombre del inicio de ruta");
        model.addColumn("Latitud ");
        model.addColumn("Longitud ");
        model.addColumn("Nombre del final de ruta");
        model.addColumn("Latitud");
        model.addColumn("Longitud");
        for (Rutas r : lisruta) {
            Object[] fila = {r.getIdRuta(), r.getNombre(), r.getDuracion(), r.getDistancia(), r.getNombre_inicioruta(), r.getLatitudInicial(), r.getLongitudInicial(), r.getNombre_finalruta(), r.getLatitudFinal(), r.getLongitudFinal()};
            model.addRow(fila);
        }
        Tabladerutasnovalidas.setModel(model);
        Tabladerutasnovalidas.getColumnModel().getColumn(0).setMinWidth(0);
        Tabladerutasnovalidas.getColumnModel().getColumn(0).setMaxWidth(0);
        Tabladerutasnovalidas.getColumnModel().getColumn(0).setPreferredWidth(0);
        Tabladerutasnovalidas.setAutoCreateRowSorter(true);
    }//GEN-LAST:event_TabladerutasnovalidasAncestorAdded

    private void TabladerutasnovalidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabladerutasnovalidasMouseClicked
        int fila = Tabladerutasnovalidas.getSelectedRow(); // Fila que has clicado 
        if (fila != -1) {
            Object valorColumna0 = Tabladerutasnovalidas.getValueAt(fila, 0); // pillo la columna 0 
            // String resultado = valorColumna0.toString(); si hay que convertirla a toString 
            int resultado = (int) valorColumna0;// valor recogido
            int respuesta = JOptionPane.showConfirmDialog(null, "Desea pasar una de estas rutas a ser valida o desea borrarla ->no", "Validar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == 0) {
                DAORutas daor = new DAORutas();
                if (daor.modificarporid(resultado)) {
                    JOptionPane.showMessageDialog(null, "La ruta paso a ser valida", "Bien", JOptionPane.INFORMATION_MESSAGE);
                }
            }else if(respuesta==1){
                DAORutas daor = new DAORutas();
                if (daor.eliminar(resultado)) {
                    JOptionPane.showMessageDialog(null, "La ruta se elimino", "Bien", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_TabladerutasnovalidasMouseClicked

    private void botoncrearvaloracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoncrearvaloracionActionPerformed
        ValoracionesdeRuta.setVisible(false);
        Panelparacrearvaloracion.setVisible(true);
    }//GEN-LAST:event_botoncrearvaloracionActionPerformed

    private void VolveraverlasvaloracionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolveraverlasvaloracionesActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "Desea volver a ver las valoraciones", "Volver", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == 0) {
            ValoracionesdeRuta.setVisible(true);
            Panelparacrearvaloracion.setVisible(false);
        }
    }//GEN-LAST:event_VolveraverlasvaloracionesActionPerformed

    private void BotonparacrearvaloracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonparacrearvaloracionActionPerformed
        String dificultad = Botondificul.getText();
        String interes = BotonIntere.getText();
        String belleza = Botonbelle.getText();
        String estrellas = Botonestre.getText();
        String reseña = Botonrese.getText();
        LocalDate fecha = LocalDate.now();
        if (Teclado.validaRango1a5(dificultad) && Teclado.validaRango1a5(interes) && Teclado.validaRango1a5(belleza) && Teclado.validaRango1a5(estrellas)) {
            DAOValora daov = new DAOValora();
            Valora V1 = new Valora(Integer.parseInt(dificultad), fecha, Integer.parseInt(interes), Integer.parseInt(belleza), Integer.parseInt(estrellas));
            if (daov.insertar(V1, usuario, this.idrutaapipp)) {
                JOptionPane.showMessageDialog(null, "Se creo la valoracion correctamnete", "Bien", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se guardo la valoracion en la base de datos", "Error", JOptionPane.PLAIN_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Formato mal introducido el formato de uno de los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BotonparacrearvaloracionActionPerformed

    private void BotonarutasdesdeCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonarutasdesdeCatalogoActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "Desea volver a ver las rutas", "Volver", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == 0) {
            RutasValidas.setVisible(true);
            PanelCalendario.setVisible(false);
        }
    }//GEN-LAST:event_BotonarutasdesdeCatalogoActionPerformed
// Tabla con el calendarios
    private void TablaCalendariosAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_TablaCalendariosAncestorAdded
        DAOCalendario daoc = new DAOCalendario();
        List<Calendario> liscal = daoc.listar(idrutaapipp);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Calendario");
        model.addColumn("Fecha");
        model.addColumn("Detalles");
        model.addColumn("Recomendaciones");
        for (Calendario c : liscal) {
            Object[] fila = {c.getIdCalendario(), c.getFecha(), c.getDetalles(), c.getRecomendaciones()};
            model.addRow(fila);
        }
        TablaCalendarios.setAutoCreateRowSorter(true);
        TablaCalendarios.getColumnModel().getColumn(0).setMinWidth(0);
        TablaCalendarios.getColumnModel().getColumn(0).setMaxWidth(0);
        TablaCalendarios.getColumnModel().getColumn(0).setPreferredWidth(0);
        TablaCalendarios.setModel(model);
    }//GEN-LAST:event_TablaCalendariosAncestorAdded

    private void botoncrearcalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoncrearcalendarioActionPerformed
        CrearCalendario.setVisible(true);
        PanelCalendario.setVisible(false);
    }//GEN-LAST:event_botoncrearcalendarioActionPerformed

    private void VolveraCalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolveraCalendarioActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "Desea volver a ver los calendarios", "Volver", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == 0) {
            CrearCalendario.setVisible(false);
            PanelCalendario.setVisible(true);
        }
    }//GEN-LAST:event_VolveraCalendarioActionPerformed

    private void botoncrearcalendariode0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoncrearcalendariode0ActionPerformed
        String detalles = Creardetall.getText();
        String recomendaciones = CrearRecomen.getText();
        String fecha = añadefech.getText();
        if (Teclado.validafechayhora(fecha)) {
            DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime aux = LocalDateTime.parse(fecha, f);
            Calendario C1 = new Calendario(aux, detalles, recomendaciones);
            DAOCalendario daoc = new DAOCalendario();
            if (daoc.insertar(C1, usuario, idrutaapipp)) {
                JOptionPane.showMessageDialog(null, "Se creo un calendario correctamnete", "Bien", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se guardo el calendario en la base de datos", "Error", JOptionPane.PLAIN_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Formato mal introducido el formato de uno de los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botoncrearcalendariode0ActionPerformed
    //Boton en refrecar rutas con metodos de todas las tablas que reinican las rutas de la base de datos
    private void BotonpararefrecartablasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonpararefrecartablasActionPerformed
        cargarTablarutasvalidas();
        cargarTablarutasnovalidas();
        cargarTablapuntosinteres();
        cargarTablapuntospeligro();
        cargarTablavaloraciones();
        cargarTablaactividades();
        caragarTabladetalles();
        cargarTablaimagenesInteres();
        cargarTablaimagenesPeligro();
        cargarTablacalendario();
        tamañocolumnasRutaValidas();
    }//GEN-LAST:event_BotonpararefrecartablasActionPerformed

    private void TablaActividadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaActividadesMouseClicked
      int fila = TablaActividades.getSelectedRow(); // Fila que has clicado 
        if (fila != -1) {
            Object valorColumna0 = TablaActividades.getValueAt(fila, 0); // pillo la columna 0 
            // String resultado = valorColumna0.toString(); si hay que convertirla a toString 
            int resultado = (int) valorColumna0;// valor recogido
                int respuesta = JOptionPane.showConfirmDialog(null, "Desea eliminar esta actividad", "Borrar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == 0) {
                DAOActividad daor = new DAOActividad();
                if (daor.eliminar(resultado)) {
                    JOptionPane.showMessageDialog(null, "Se borro la actividad", "Bien", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_TablaActividadesMouseClicked

    private void TablaValoracionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaValoracionesMouseClicked
        int fila = TablaValoraciones.getSelectedRow(); // Fila que has clicado 
        if (fila != -1) {
            Object valorColumna0 = TablaValoraciones.getValueAt(fila, 0); // pillo la columna 0 
            // String resultado = valorColumna0.toString(); si hay que convertirla a toString 
            int resultado = (int) valorColumna0;// valor recogido
                int respuesta = JOptionPane.showConfirmDialog(null, "Desea eliminar esta valoracion", "Borrar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == 0) {
                DAOValora daor = new DAOValora();
                if (daor.eliminar(resultado)) {
                    JOptionPane.showMessageDialog(null, "Se borro la valoracion", "Bien", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_TablaValoracionesMouseClicked

    private void TablaimagenesInteresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaimagenesInteresMouseClicked
        int fila = TablaimagenesInteres.getSelectedRow(); // Fila que has clicado 
        if (fila != -1) {
            Object valorColumna0 = TablaimagenesInteres.getValueAt(fila, 0); // pillo la columna 0 
            // String resultado = valorColumna0.toString(); si hay que convertirla a toString 
            int resultado = (int) valorColumna0;// valor recogido
                int respuesta = JOptionPane.showConfirmDialog(null, "Desea eliminar esta imagen", "Borrar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == 0) {
                DAOImagenesInteres daor = new DAOImagenesInteres();
                if (daor.eliminar(resultado)) {
                    JOptionPane.showMessageDialog(null, "Se borro la imagen", "Bien", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_TablaimagenesInteresMouseClicked

    private void TablaImagenesPeligroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaImagenesPeligroMouseClicked
          int fila = TablaImagenesPeligro.getSelectedRow(); // Fila que has clicado 
        if (fila != -1) {
            Object valorColumna0 = TablaImagenesPeligro.getValueAt(fila, 0); // pillo la columna 0 
            // String resultado = valorColumna0.toString(); si hay que convertirla a toString 
            int resultado = (int) valorColumna0;// valor recogido
                int respuesta = JOptionPane.showConfirmDialog(null, "Desea eliminar esta imagen", "Borrar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == 0) {
                DAOImagenesPeligro daor = new DAOImagenesPeligro();
                if (daor.eliminar(resultado)) {
                    JOptionPane.showMessageDialog(null, "Se borro la imagen", "Bien", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_TablaImagenesPeligroMouseClicked

    private void TablaCalendariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaCalendariosMouseClicked
        int fila =TablaCalendarios.getSelectedRow(); // Fila que has clicado 
        if (fila != -1) {
            Object valorColumna0 = TablaCalendarios.getValueAt(fila, 0); // pillo la columna 0 
            // String resultado = valorColumna0.toString(); si hay que convertirla a toString 
            int resultado = (int) valorColumna0;// valor recogido
                int respuesta = JOptionPane.showConfirmDialog(null, "Desea eliminar este calendario", "Borrar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == 0) {
                DAOCalendario daor = new DAOCalendario();
                if (daor.eliminar(resultado)) {
                    JOptionPane.showMessageDialog(null, "Se borro el calendario", "Bien", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_TablaCalendariosMouseClicked
    
    private void cargarTablarutasvalidas(){
        DAORutas daoruta = new DAORutas();
        List<Rutas> lisruta = daoruta.listaraprobadas();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Ruta");
        model.addColumn("Nombre");
        model.addColumn("Duracion");
        model.addColumn("Distancia");
        model.addColumn("Nombre del inicio de ruta");
        model.addColumn("Latitud ");
        model.addColumn("Longitud ");
        model.addColumn("Nombre del final de ruta");
        model.addColumn("Latitud");
        model.addColumn("Longitud");
        for (Rutas r : lisruta) {
            Object[] fila = {r.getIdRuta(), r.getNombre(), r.getDuracion(), r.getDistancia(), r.getNombre_inicioruta(), r.getLatitudInicial(), r.getLongitudInicial(), r.getNombre_finalruta(), r.getLatitudFinal(), r.getLongitudFinal()};
            model.addRow(fila);
        }
        TableRutasValidas.setModel(model);
        TableRutasValidas.setAutoCreateRowSorter(true);
        tamañocolumnasRutaValidas();
    }

    private void cargarTablarutasnovalidas() {
        DAORutas daoruta = new DAORutas();
        List<Rutas> lisruta = daoruta.listarsinaprobar();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Ruta");
        model.addColumn("Nombre");
        model.addColumn("Duracion");
        model.addColumn("Distancia");
        model.addColumn("Nombre del inicio de ruta");
        model.addColumn("Latitud ");
        model.addColumn("Longitud ");
        model.addColumn("Nombre del final de ruta");
        model.addColumn("Latitud");
        model.addColumn("Longitud");
        for (Rutas r : lisruta) {
            Object[] fila = {r.getIdRuta(), r.getNombre(), r.getDuracion(), r.getDistancia(), r.getNombre_inicioruta(), r.getLatitudInicial(), r.getLongitudInicial(), r.getNombre_finalruta(), r.getLatitudFinal(), r.getLongitudFinal()};
            model.addRow(fila);
        }
        Tabladerutasnovalidas.setModel(model);
        Tabladerutasnovalidas.getColumnModel().getColumn(0).setMinWidth(0);
        Tabladerutasnovalidas.getColumnModel().getColumn(0).setMaxWidth(0);
        Tabladerutasnovalidas.getColumnModel().getColumn(0).setPreferredWidth(0);
        Tabladerutasnovalidas.setAutoCreateRowSorter(true);
    }

    private void cargarTablapuntosinteres() {
      DAOPuntosinteres daopi = new DAOPuntosinteres();
        List<PuntosInteres> lispi = daopi.listar(idrutaapipp);// cambiar el metodo listar de dao puntos interes de Ruta ruta a int id 
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID PuntosInteres");
        model.addColumn("Nombre");
        model.addColumn("Latitud");
        model.addColumn("Longitud");
        model.addColumn("Elevacion");
        model.addColumn("Descripcion");
        for (PuntosInteres pp : lispi) {
            Object[] fila = {pp.getIdPuntosInteres(), pp.getNombre(), pp.getLatitud(), pp.getLongitud(), pp.getElevacion(), pp.getDescripcion()};
            model.addRow(fila);
        }
        TablePuntosInteres.setModel(model);
        TablePuntosInteres.setAutoCreateRowSorter(true);
        TablePuntosInteres.getColumnModel().getColumn(0).setMinWidth(0);
        TablePuntosInteres.getColumnModel().getColumn(0).setMaxWidth(0);
        TablePuntosInteres.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    private void cargarTablapuntospeligro() {
         DAOPuntospeligro daopp = new DAOPuntospeligro();
        List<PuntosPeligro> lispp = daopp.listar(idrutaapipp);// cambiar el metodo listar de dao puntos peligro de Ruta ruta a int id 
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID PuntosPeligro");
        model.addColumn("Nombre");
        model.addColumn("Latitud");
        model.addColumn("Longitud");
        model.addColumn("Elevacion");
        model.addColumn("Descripcion");
        for (PuntosPeligro pp : lispp) {
            Object[] fila = {pp.getIdPuntospeligro(), pp.getNombre(), pp.getLatitud(), pp.getLongitud(), pp.getElevacion(), pp.getDescripcion()};
            model.addRow(fila);
        }
        TablePuntosPeligro.setAutoCreateRowSorter(true);
        TablePuntosPeligro.setModel(model);
        TablePuntosPeligro.getColumnModel().getColumn(0).setMinWidth(0);
        TablePuntosPeligro.getColumnModel().getColumn(0).setMaxWidth(0);
        TablePuntosPeligro.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    private void cargarTablavaloraciones() {
        DAOValora daov = new DAOValora();
        List<Valora> lisv = daov.listar(idrutaapipp);// cambiar el metodo listar de dao valoraciones de Ruta ruta a int id
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Valora");
        model.addColumn("Dificultad");
        model.addColumn("Fecha");
        model.addColumn("Estrellas");
        model.addColumn("Interes Cultural");
        model.addColumn("Belleza");
        for (Valora v : lisv) {
            Object[] fila = {v.getIdValora(), v.getDificultad(), v.getFecha(), v.getEstrellas(), v.getInteresCultural(), v.getBelleza()};
            model.addRow(fila);
        }
        TablaValoraciones.setAutoCreateRowSorter(true);
       TablaValoraciones.getColumnModel().getColumn(0).setMinWidth(0);
        TablaValoraciones.getColumnModel().getColumn(0).setMaxWidth(0);
        TablaValoraciones.getColumnModel().getColumn(0).setPreferredWidth(0);
        TablaValoraciones.setModel(model);
    }

    private void cargarTablaactividades() {
        DAOActividad daoa = new DAOActividad();
        List<Actividad> lisa = daoa.listar(idrutaapipp);// cambiar el metodo listar de dao valoraciones de Ruta ruta a int id 
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Actividad");
        model.addColumn("Nombre");
        for (Actividad a : lisa) {
            Object[] fila = {a.getIdActividad(), a.getNombre()};
            model.addRow(fila);
        }
        TablaActividades.setAutoCreateRowSorter(true);
        TablaActividades.getColumnModel().getColumn(0).setMinWidth(0);
        TablaActividades.getColumnModel().getColumn(0).setMaxWidth(0);
        TablaActividades.getColumnModel().getColumn(0).setPreferredWidth(0);
        TablaActividades.setModel(model);
    }

    private void caragarTabladetalles() {
        DAORutas daor = new DAORutas();
        Rutas ruta = daor.buscarTodaInfo(idrutaapipp);// cambiar el metodo listar de dao valoraciones de Ruta ruta a int id
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Ruta");
        model.addColumn("Nombre");
        model.addColumn("Nombre del inicio de ruta");
        model.addColumn("Latitud ");
        model.addColumn("Longitud ");
        model.addColumn("Nombre del final de ruta");
        model.addColumn("Latitud");
        model.addColumn("Longitud");
        model.addColumn("Duracion");
        model.addColumn("Distancia");
        model.addColumn("Clasificacion");
        model.addColumn("Nivel Esfuerzo");
        model.addColumn("Nivel Riesgo");
        model.addColumn("Estado Ruta");
        model.addColumn("Tipo Terreno");
        model.addColumn("Indicaciones");
        model.addColumn("Ruta Familiar");
        model.addColumn("Media Estrellas");
        Object[] fila = {ruta.getIdRuta(), ruta.getNombre(), ruta.getNombre_inicioruta(), ruta.getLatitudInicial(), ruta.getLongitudInicial(), ruta.getNombre_finalruta(), ruta.getLatitudFinal(), ruta.getLongitudFinal(), ruta.getDuracion(), ruta.getDistancia(), ruta.getClasificacion(), ruta.getNivelEsfuerzo(), ruta.getNivelriesgo(), ruta.getEstadoRuta(), ruta.getTipoterreno(), ruta.getIndicaciones(), ruta.isRutaFamiliar(), ruta.getMediaEstrellas()};
        model.addRow(fila);
        TablaDetallesruta.setModel(model);
        tamañocolumnasDetalles();
    }

    private void cargarTablacalendario() {
        DAOCalendario daoc = new DAOCalendario();
        List<Calendario> liscal = daoc.listar(idrutaapipp);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Calendario");
        model.addColumn("Fecha");
        model.addColumn("Detalles");
        model.addColumn("Recomendaciones");
        for (Calendario c : liscal) {
            Object[] fila = {c.getIdCalendario(), c.getFecha(), c.getDetalles(), c.getRecomendaciones()};
            model.addRow(fila);
        }
        TablaCalendarios.setAutoCreateRowSorter(true);
        TablaCalendarios.getColumnModel().getColumn(0).setMinWidth(0);
        TablaCalendarios.getColumnModel().getColumn(0).setMaxWidth(0);
        TablaCalendarios.getColumnModel().getColumn(0).setPreferredWidth(0);
        TablaCalendarios.setModel(model);
    }

    private void cargarTablaimagenesInteres() {
        DAOImagenesInteres daoimg = new DAOImagenesInteres();
        List<ImagenesInteres> lisimg = daoimg.listar(idpi);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID PuntosInteres");
        model.addColumn("URL");
        model.addColumn("Descripcion");

        for (ImagenesInteres pi : lisimg) {
            try {
                System.out.println("Cargando imagen" + pi.getUrl());
                URL url = new URL(pi.getUrl());
                ImageIcon icono = new ImageIcon(ImageIO.read(url));

                Object[] fila = {pi.getIdimagenesinteres(), icono, pi.getDescripcion()};
                model.addRow(fila);

            } catch (Exception ex) {
                model.addRow(new Object[]{null, "Error al cargar imagen: " + pi.getDescripcion()});
            }
        }
        TablaimagenesInteres.setModel(model);
        TablaimagenesInteres.getColumnModel().getColumn(0).setMinWidth(0);
        TablaimagenesInteres.getColumnModel().getColumn(0).setMaxWidth(0);
       TablaimagenesInteres.getColumnModel().getColumn(0).setPreferredWidth(0);
        TablaimagenesInteres.setAutoCreateRowSorter(true);
        TablaimagenesInteres.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = TablaimagenesInteres.rowAtPoint(e.getPoint());
                int columna = TablaimagenesInteres.columnAtPoint(e.getPoint());
                if (columna == 1) {
                    ImageIcon icono = (ImageIcon) TablaimagenesInteres.getValueAt(fila, columna);
                    String descripcion = (String) TablaimagenesInteres.getValueAt(fila, 2);
                    if (icono != null) {
                        mostrarImagenYDescripcionEnPanel(icono, descripcion);
                    }
                }
            }
        }
        );
    }

    private void cargarTablaimagenesPeligro() {
        DAOImagenesPeligro daoimg = new DAOImagenesPeligro();
        List<ImagenesPeligro> lisimg = daoimg.listar(idpp);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID PuntosPeligro");
        model.addColumn("URL");
        model.addColumn("Descripcion");

        for (ImagenesPeligro pi : lisimg) {
            try {
                System.out.println("Cargando imagen" + pi.getUrl());
                URL url = new URL(pi.getUrl());
                ImageIcon icono = new ImageIcon(ImageIO.read(url));

                Object[] fila = {pi.getIdimagenespeligro(), icono, pi.getDescripcion()};
                model.addRow(fila);

            } catch (Exception ex) {
                model.addRow(new Object[]{null, "Error al cargar imagen: " + pi.getDescripcion()});
            }
        }
        TablaImagenesPeligro.setModel(model);
        TablaImagenesPeligro.getColumnModel().getColumn(0).setMinWidth(0);
        TablaImagenesPeligro.getColumnModel().getColumn(0).setMaxWidth(0);
       TablaImagenesPeligro.getColumnModel().getColumn(0).setPreferredWidth(0);
       TablaImagenesPeligro.setAutoCreateRowSorter(true);
      TablaImagenesPeligro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = TablaImagenesPeligro.rowAtPoint(e.getPoint());
                int columna = TablaImagenesPeligro.columnAtPoint(e.getPoint());
                if (columna == 1) {
                    ImageIcon icono = (ImageIcon) TablaImagenesPeligro.getValueAt(fila, columna);
                    String descripcion = (String) TablaImagenesPeligro.getValueAt(fila, 2);
                    if (icono != null) {
                        mostrarImagenYDescripcionEnPanel(icono, descripcion);
                    }
                }
            }
        }
        );
    }
    // fin del boton de actualizar todas las tablas 
    //Crea tabla imagenes interes y genera la imagen

    private void TablaimagenesInteresAncestorAdded(javax.swing.event.AncestorEvent evt) {
        DAOImagenesInteres daoimg = new DAOImagenesInteres();
        List<ImagenesInteres> lisimg = daoimg.listar(idpi);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID PuntosInteres");
        model.addColumn("URL");
        model.addColumn("Descripcion");

        for (ImagenesInteres pi : lisimg) {
            try {
                System.out.println("Cargando imagen" + pi.getUrl());
                URL url = new URL(pi.getUrl());
                ImageIcon icono = new ImageIcon(ImageIO.read(url));

                Object[] fila = {pi.getIdimagenesinteres(), icono, pi.getDescripcion()};
                model.addRow(fila);

            } catch (Exception ex) {
                model.addRow(new Object[]{null, "Error al cargar imagen: " + pi.getDescripcion()});
            }
        }
        TablaimagenesInteres.setModel(model);
        TablaimagenesInteres.setAutoCreateRowSorter(true);
        TablaimagenesInteres.getColumnModel().getColumn(0).setMinWidth(0);
        TablaimagenesInteres.getColumnModel().getColumn(0).setMaxWidth(0);
        TablaimagenesInteres.getColumnModel().getColumn(0).setPreferredWidth(0);
        TablaimagenesInteres.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = TablaimagenesInteres.rowAtPoint(e.getPoint());
                int columna = TablaimagenesInteres.columnAtPoint(e.getPoint());
                if (columna == 1) {
                    ImageIcon icono = (ImageIcon) TablaimagenesInteres.getValueAt(fila, columna);
                    String descripcion = (String) TablaimagenesInteres.getValueAt(fila, 2);
                    if (icono != null) {
                        mostrarImagenYDescripcionEnPanel(icono, descripcion);
                    }
                }
            }
        }
        );
    }

    private void mostrarImagenYDescripcionEnPanel(ImageIcon icono, String descripcion) {
        JPanel panelVistaPrevia = new JPanel();
        panelVistaPrevia.setLayout(new BoxLayout(panelVistaPrevia, BoxLayout.Y_AXIS));
        JLabel labelImagen = new JLabel(icono);
        panelVistaPrevia.add(labelImagen);
        JLabel labelDescripcion = new JLabel(descripcion);
        panelVistaPrevia.add(labelDescripcion);
        JFrame ventanaVistaPrevia = new JFrame("Vista Previa");
        ventanaVistaPrevia.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaVistaPrevia.add(panelVistaPrevia);
        ventanaVistaPrevia.pack();
        ventanaVistaPrevia.setLocationRelativeTo(null);
        ventanaVistaPrevia.setVisible(true);
    }

    public void limpiartablasalvolver() {
        TableRutasValidas.setModel(new DefaultTableModel());
        TablePuntosInteres.setModel(new DefaultTableModel());
        TablePuntosPeligro.setModel(new DefaultTableModel());
        TablaValoraciones.setModel(new DefaultTableModel());
        TablaActividades.setModel(new DefaultTableModel());
        TablaDetallesruta.setModel(new DefaultTableModel());
        TablaimagenesInteres.setModel(new DefaultTableModel());
        TablaImagenesPeligro.setModel(new DefaultTableModel());
        Tabladerutasnovalidas.setModel(new DefaultTableModel());
        TablaCalendarios.setModel(new DefaultTableModel());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SwingPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Actividades;
    private javax.swing.JButton BotonEntrada;
    private javax.swing.JTextField BotonIntere;
    private javax.swing.JButton BotonarutasdesdeCatalogo;
    private javax.swing.JTextField Botonbelle;
    private javax.swing.JTextField Botondificul;
    private javax.swing.JTextField Botonestre;
    private javax.swing.JButton Botonparacrearruta;
    private javax.swing.JButton Botonparacrearrutas;
    private javax.swing.JButton Botonparacrearvaloracion;
    private javax.swing.JButton Botonpararefrecartablas;
    private javax.swing.JTextField Botonrese;
    private javax.swing.JPanel CatalogodeRutas;
    private javax.swing.JPasswordField Contraseña;
    private javax.swing.JPanel CrearCalendario;
    private javax.swing.JTextField CrearRecomen;
    private javax.swing.JPanel CrearRutasde0;
    private javax.swing.JPanel CrearUsuarios;
    private javax.swing.JTextField Creardetall;
    private javax.swing.JLabel Cuadro1;
    private javax.swing.JLabel Cuadro2;
    private javax.swing.JLabel CuadroEntrada;
    private javax.swing.JLabel Cuadrodecrearrutas;
    private javax.swing.JLabel Cuadroimagenespeligro;
    private javax.swing.JPanel DetallesRuta;
    private javax.swing.JTextField Email;
    private javax.swing.JPanel ImagenesInteres;
    private javax.swing.JPanel ImagenesPeligro;
    private javax.swing.JButton IniciarSesion;
    private javax.swing.JLabel Nombre;
    private javax.swing.JLabel NombreImagenesInteres;
    private javax.swing.JLabel NombreRutas;
    private javax.swing.JLabel Nombrerutasinavlidas;
    private javax.swing.JPanel PanelCalendario;
    private javax.swing.JPanel PanelEntrada;
    private javax.swing.JPanel PanelInicio;
    private javax.swing.JPanel Panelparacrearvaloracion;
    private javax.swing.JPanel PuntosdeRuta;
    private javax.swing.JButton Rutas;
    private javax.swing.JPanel RutasValidas;
    private javax.swing.JButton Salida;
    private javax.swing.JTable TablaActividades;
    private javax.swing.JTable TablaCalendarios;
    private javax.swing.JTable TablaDetallesruta;
    private javax.swing.JTable TablaImagenesPeligro;
    private javax.swing.JTable TablaValoraciones;
    private javax.swing.JTable Tabladerutasnovalidas;
    private javax.swing.JTable TablaimagenesInteres;
    private javax.swing.JTable TablePuntosInteres;
    private javax.swing.JTable TablePuntosPeligro;
    private javax.swing.JTable TableRutasValidas;
    private javax.swing.JLabel Texto;
    private javax.swing.JLabel TextoInicio;
    private javax.swing.JButton Usuario;
    private javax.swing.JPanel ValoracionesdeRuta;
    private javax.swing.JButton VolverInicio;
    private javax.swing.JButton VolverUsuarios;
    private javax.swing.JButton VolveraCalendario;
    private javax.swing.JButton Volveraverlasvaloraciones;
    private javax.swing.JLabel apellido;
    private javax.swing.JTextField añadefech;
    private javax.swing.JButton botoncrearcalendario;
    private javax.swing.JButton botoncrearcalendariode0;
    private javax.swing.JButton botoncrearvaloracion;
    private javax.swing.JLabel contraseña;
    private javax.swing.JButton darbotonUsuario;
    private javax.swing.JTextField distancia;
    private javax.swing.JTextField duracion;
    private javax.swing.JComboBox<String> eligerol;
    private javax.swing.JLabel email;
    private javax.swing.JTextField introapellido;
    private javax.swing.JPasswordField introcontraseña;
    private javax.swing.JTextField introemail;
    private javax.swing.JTextField intronombre;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField ldf;
    private javax.swing.JTextField ldi;
    private javax.swing.JTextField lf;
    private javax.swing.JTextField li;
    private javax.swing.JTextField nombrefini;
    private javax.swing.JTextField nombreinicio;
    private javax.swing.JTextField nombreruta;
    private javax.swing.JLabel rol;
    private javax.swing.JButton volverarutasdesdeno;
    private javax.swing.JButton volverdecrearruta;
    private javax.swing.JButton votonimagenvolverpeligro;
    // End of variables declaration//GEN-END:variables
}
