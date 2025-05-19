/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.reto_equipo3.Swing;

import com.mycompany.reto_equipo3.Actividad;
import com.mycompany.reto_equipo3.Calendario;
import com.mycompany.reto_equipo3.DAOS.AccesoABaseDatos;
import com.mycompany.reto_equipo3.DAOS.DAOActividad;
import com.mycompany.reto_equipo3.DAOS.DAOCalendario;
import com.mycompany.reto_equipo3.DAOS.DAOImagenesInteres;
import com.mycompany.reto_equipo3.DAOS.DAOImagenesPeligro;
import com.mycompany.reto_equipo3.DAOS.DAOPuntosinteres;
import com.mycompany.reto_equipo3.DAOS.DAOPuntospeligro;
import com.mycompany.reto_equipo3.DAOS.DAORutas;
import com.mycompany.reto_equipo3.DAOS.DAOUsuario;
import com.mycompany.reto_equipo3.DAOS.DAOValora;
import com.mycompany.reto_equipo3.Enums.Clasificacion;
import com.mycompany.reto_equipo3.Enums.Roles;
import com.mycompany.reto_equipo3.Enums.Tipo;
import com.mycompany.reto_equipo3.Ficheros.FichaOrganizacion;
import com.mycompany.reto_equipo3.Ficheros.FichaSeguridad;
import com.mycompany.reto_equipo3.Ficheros.FichaUsuario;
import com.mycompany.reto_equipo3.ImagenesInteres;
import com.mycompany.reto_equipo3.ImagenesPeligro;
import com.mycompany.reto_equipo3.PuntosInteres;
import com.mycompany.reto_equipo3.PuntosPeligro;
import com.mycompany.reto_equipo3.Reto_equipo3;
import com.mycompany.reto_equipo3.Rutas;
import com.mycompany.reto_equipo3.Usuario;
import com.mycompany.reto_equipo3.Validaciones.Teclado;
import com.mycompany.reto_equipo3.Valora;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Clase Swing donde se ejecutará la interfaz gráfica
 * @author Saúl García, Miguel Inglés, Hugo Fernández y Manuel Mediavilla, JavaDoc por Hugo Fernández
 */
public class SwingPrincipal extends javax.swing.JFrame {

    // Guarda el usuario
    Usuario usuario = null;
    //Guarda la id de la ruta
    int idrutaapipp;
    // Guarda la id del punto de interes
    int idpi;
    // Guarda la id del punto de peligro
    int idpp;

    public SwingPrincipal() {
        initComponents();
        //No deja salir ni con x ni con alt + f4
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.out.println("Cierre deshabilitado.");
            }
        });
        // Botones por defecto desactivados hasta que ponga su rol y tamaño de tablas
        TableRutasValidas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPane1.setPreferredSize(new Dimension(1500, 600));
        Botonparacrearrutas.setVisible(false);
        botoncrearvaloracion.setVisible(false);
        Botonpararefrecartablas.setVisible(false);
        BotonCrearPunto.setVisible(false);
        CrearImagenes.setVisible(false);
        CrearImagenesPeligro.setVisible(false);
        BotoncrearActividad.setVisible(false);
        botoncrearcalendario.setVisible(false);
        Botonvalidarutasir.setVisible(false);
        TablaDetallesruta.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jScrollPane7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jScrollPane7.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPane7.setPreferredSize(new Dimension(2800, 400));
        //Imagenes que se ven en el proyecto no se pueden ver de otra forma
         mostrarImagen("Imagenes/ImagenfondoInicio.jpg",jLabel49);
         mostrarImagen("Imagenes/Imagen-logo-equipo5050.png",jLabel50);
         mostrarImagen("Imagenes/Imagen-logo-equipo5050.png",jLabel51);
         mostrarImagen("Imagenes/Imagen-logo-equipo5050.png",jLabel52);
         mostrarImagen("Imagenes/Imagen-logo-equipo5050.png",jLabel53);
         mostrarImagen("Imagenes/Imagen-logo-equipo5050.png",jLabel54);
         mostrarImagen("Imagenes/Imagen-logo-equipo5050.png",jLabel55);
         mostrarImagen("Imagenes/Imagen-logo-equipo5050.png",jLabel56);
         
         mostrarImagen("Imagenes/Imagen-logo-equipo5050.png",jLabel57);
         mostrarImagen("Imagenes/Imagen-logo-equipo5050.png",jLabel58);
         mostrarImagen("Imagenes/Imagen-logo-equipo5050.png",jLabel59);
         mostrarImagen("Imagenes/Imagen-logo-equipo5050.png",jLabel60);
         mostrarImagen("Imagenes/Imagen-logo-equipo5050.png",jLabel61);
         mostrarImagen("Imagenes/Imagen-logo-equipo5050.png",jLabel62);
         mostrarImagen("Imagenes/Imagen-logo-equipo5050.png",jLabel63);
         
         mostrarImagen("Imagenes/Imagen-logo-equipo5050.png",jLabel64);
         mostrarImagen("Imagenes/Imagen-logo-equipo5050.png",jLabel65);
         mostrarImagen("Imagenes/Imagen-logo-equipo5050.png",jLabel66);
         mostrarImagen("Imagenes/Imagen-logo-equipo5050.png",jLabel67);
         mostrarImagen("Imagenes/Imagen-logo-equipo5050.png",jLabel68);
         mostrarImagen("Imagenes/Imagen-logo-equipo5050.png",jLabel69);
    }
    // metodo que muestra las imagenes
      public void mostrarImagen(String url,JLabel label) {
        java.net.URL imgUrl = getClass().getClassLoader().getResource(url);
        ImageIcon img = new ImageIcon(imgUrl);
        Icon icon = new ImageIcon(img.getImage().
                getScaledInstance(label.getWidth(),
                        label.getHeight(), img.getIconWidth()));
        label.setIcon(img);
    }
    // Tamaño de lo que ocupa cada cuadrado de la tabla valida rutas y los detalles de la ruta valida
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
//Metodo que da formato a la tabla de detalles

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

        jRadioButton1 = new javax.swing.JRadioButton();
        PanelEntrada = new javax.swing.JPanel();
        CuadroEntrada = new javax.swing.JLabel();
        BotonEntrada = new javax.swing.JButton();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
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
        Botonpararefrecar = new javax.swing.JButton();
        jLabel51 = new javax.swing.JLabel();
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
        jLabel52 = new javax.swing.JLabel();
        RutasValidas = new javax.swing.JPanel();
        VolverInicio = new javax.swing.JButton();
        NombreRutas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableRutasValidas = new javax.swing.JTable();
        Botonparacrearrutas = new javax.swing.JButton();
        Botonpararefrecartablas = new javax.swing.JButton();
        jLabel53 = new javax.swing.JLabel();
        PuntosdeRuta = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablePuntosInteres = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablePuntosPeligro = new javax.swing.JTable();
        BotonCrearPunto = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        ValoracionesdeRuta = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        TablaValoraciones = new javax.swing.JTable();
        botoncrearvaloracion = new javax.swing.JButton();
        jLabel56 = new javax.swing.JLabel();
        Actividades = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        TablaActividades = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        BotoncrearActividad = new javax.swing.JButton();
        jLabel54 = new javax.swing.JLabel();
        DetallesRuta = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        TablaDetallesruta = new javax.swing.JTable();
        jLabel57 = new javax.swing.JLabel();
        ImagenesInteres = new javax.swing.JPanel();
        NombreImagenesInteres = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaimagenesInteres = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        CrearImagenes = new javax.swing.JButton();
        jLabel58 = new javax.swing.JLabel();
        ImagenesPeligro = new javax.swing.JPanel();
        Cuadroimagenespeligro = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        TablaImagenesPeligro = new javax.swing.JTable();
        votonimagenvolverpeligro = new javax.swing.JButton();
        CrearImagenesPeligro = new javax.swing.JButton();
        jLabel59 = new javax.swing.JLabel();
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
        Botonvalidarutasir = new javax.swing.JButton();
        jLabel60 = new javax.swing.JLabel();
        CatalogodeRutas = new javax.swing.JPanel();
        Nombrerutasinavlidas = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        Tabladerutasnovalidas = new javax.swing.JTable();
        volverarutasdesdeno = new javax.swing.JButton();
        jLabel63 = new javax.swing.JLabel();
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
        jLabel61 = new javax.swing.JLabel();
        PanelCalendario = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        TablaCalendarios = new javax.swing.JTable();
        BotonarutasdesdeCatalogo = new javax.swing.JButton();
        botoncrearcalendario = new javax.swing.JButton();
        jLabel62 = new javax.swing.JLabel();
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
        jLabel64 = new javax.swing.JLabel();
        CrearPuntosRutap = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        Nombrep = new javax.swing.JLabel();
        nombrePP = new javax.swing.JTextField();
        Latitudp = new javax.swing.JLabel();
        nombreLatitud1 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        BotonvolverPunto = new javax.swing.JButton();
        Longitudp = new javax.swing.JLabel();
        nombreLongitud1 = new javax.swing.JTextField();
        Elevacionp = new javax.swing.JLabel();
        nombreElevacion1 = new javax.swing.JTextField();
        EligePunto = new javax.swing.JComboBox<>();
        Descripcionp = new javax.swing.JLabel();
        nombreDescripcion1 = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        CrearActividades = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        NombreActi = new javax.swing.JTextField();
        volveraactividad = new javax.swing.JButton();
        CrearActividadBoton = new javax.swing.JButton();
        jLabel66 = new javax.swing.JLabel();
        CrearImagen = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        ValidaURL = new javax.swing.JTextField();
        ValidaDescripcion = new javax.swing.JTextField();
        CrearImagenesnuevo = new javax.swing.JButton();
        VolverImagenes = new javax.swing.JButton();
        jLabel67 = new javax.swing.JLabel();
        CrearImagenPeligrop = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        CrearURLY = new javax.swing.JTextField();
        descripcionpl = new javax.swing.JLabel();
        CREARDESCRIPCION = new javax.swing.JTextField();
        crearimagenpeligro = new javax.swing.JButton();
        VolverImagnesPeligro = new javax.swing.JButton();
        jLabel68 = new javax.swing.JLabel();
        ValidaRutas = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        desnivelpositivo = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        desnivelnegativo = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        tipoterreno = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        altmaxima = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        altminima = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        indicaciones = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        recomen = new javax.swing.JTextField();
        BotonvolverRutass = new javax.swing.JButton();
        BotonParamodificarUsuario = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        clasi = new javax.swing.JComboBox<>();
        rutafam = new javax.swing.JComboBox<>();
        jLabel47 = new javax.swing.JLabel();
        geo = new javax.swing.JTextField();
        accesibilidad = new javax.swing.JComboBox<>();
        temp = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        PanelEntrada.setBackground(new java.awt.Color(204, 255, 255));
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

        BotonEntrada.setBackground(new java.awt.Color(102, 153, 255));
        BotonEntrada.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        BotonEntrada.setForeground(new java.awt.Color(0, 51, 153));
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
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(PanelEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEntradaLayout.createSequentialGroup()
                        .addComponent(BotonEntrada)
                        .addGap(215, 215, 215))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEntradaLayout.createSequentialGroup()
                        .addComponent(CuadroEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)
                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEntradaLayout.createSequentialGroup()
                        .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87))))
        );
        PanelEntradaLayout.setVerticalGroup(
            PanelEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEntradaLayout.createSequentialGroup()
                .addGroup(PanelEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CuadroEntrada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(BotonEntrada)
                .addGap(18, 18, 18))
        );

        getContentPane().add(PanelEntrada, "card2");
        PanelEntrada.getAccessibleContext().setAccessibleName("");

        PanelInicio.setBackground(new java.awt.Color(204, 204, 255));
        PanelInicio.setMaximumSize(new java.awt.Dimension(600, 400));
        PanelInicio.setMinimumSize(new java.awt.Dimension(600, 400));
        PanelInicio.setPreferredSize(new java.awt.Dimension(600, 400));

        TextoInicio.setFont(new java.awt.Font("Times New Roman", 2, 36)); // NOI18N
        TextoInicio.setForeground(new java.awt.Color(51, 51, 255));
        TextoInicio.setText("Rutas al aire libre");

        Salida.setBackground(new java.awt.Color(204, 255, 255));
        Salida.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        Salida.setForeground(new java.awt.Color(0, 0, 204));
        Salida.setText("Salir de la aplicacion");
        Salida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalidaActionPerformed(evt);
            }
        });

        Rutas.setBackground(new java.awt.Color(204, 255, 255));
        Rutas.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        Rutas.setForeground(new java.awt.Color(0, 0, 204));
        Rutas.setText("Ver Rutas");
        Rutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RutasActionPerformed(evt);
            }
        });

        Usuario.setBackground(new java.awt.Color(204, 255, 255));
        Usuario.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        Usuario.setForeground(new java.awt.Color(0, 0, 153));
        Usuario.setText("Registro");
        Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioActionPerformed(evt);
            }
        });

        Cuadro2.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        Cuadro2.setForeground(new java.awt.Color(0, 0, 204));
        Cuadro2.setText("Email");

        Email.setToolTipText("");
        Email.setActionCommand("<Not Set>");
        Email.setName(""); // NOI18N

        Cuadro1.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        Cuadro1.setForeground(new java.awt.Color(0, 0, 153));
        Cuadro1.setText("Contraseña");

        IniciarSesion.setBackground(new java.awt.Color(204, 255, 255));
        IniciarSesion.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        IniciarSesion.setForeground(new java.awt.Color(0, 0, 153));
        IniciarSesion.setText("Iniciar Sesión");
        IniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarSesionActionPerformed(evt);
            }
        });

        Botonpararefrecar.setBackground(new java.awt.Color(204, 255, 255));
        Botonpararefrecar.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        Botonpararefrecar.setForeground(new java.awt.Color(0, 0, 153));
        Botonpararefrecar.setText("Refrescar Aplicacion");
        Botonpararefrecar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonpararefrecarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelInicioLayout = new javax.swing.GroupLayout(PanelInicio);
        PanelInicio.setLayout(PanelInicioLayout);
        PanelInicioLayout.setHorizontalGroup(
            PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInicioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Contraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(Email))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInicioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TextoInicio)
                .addGap(108, 108, 108)
                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInicioLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(Usuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addComponent(Rutas)
                .addGap(94, 94, 94)
                .addGroup(PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Salida)
                    .addComponent(Botonpararefrecar))
                .addGap(15, 15, 15))
            .addGroup(PanelInicioLayout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addComponent(Cuadro2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelInicioLayout.createSequentialGroup()
                .addGap(253, 253, 253)
                .addComponent(Cuadro1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelInicioLayout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(IniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelInicioLayout.setVerticalGroup(
            PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInicioLayout.createSequentialGroup()
                .addGroup(PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextoInicio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Cuadro2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(Cuadro1)
                .addGap(18, 18, 18)
                .addComponent(Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(IniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Rutas)
                    .addComponent(Usuario)
                    .addComponent(Salida))
                .addGap(12, 12, 12)
                .addComponent(Botonpararefrecar)
                .addContainerGap())
        );

        Email.getAccessibleContext().setAccessibleName("");

        getContentPane().add(PanelInicio, "card3");

        CrearUsuarios.setBackground(new java.awt.Color(204, 204, 255));
        CrearUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        CrearUsuarios.setMaximumSize(new java.awt.Dimension(600, 400));
        CrearUsuarios.setMinimumSize(new java.awt.Dimension(600, 400));

        Texto.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        Texto.setForeground(new java.awt.Color(0, 0, 255));
        Texto.setText("Crear Usuario");

        Nombre.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        Nombre.setForeground(new java.awt.Color(0, 0, 255));
        Nombre.setText("Nuevo nombre:");

        apellido.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        apellido.setForeground(new java.awt.Color(0, 0, 255));
        apellido.setText("Nuevo apellido:");

        email.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        email.setForeground(new java.awt.Color(0, 51, 255));
        email.setText("Nuevo email:");

        contraseña.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        contraseña.setForeground(new java.awt.Color(0, 0, 255));
        contraseña.setText("Nueva Contraseña:");

        rol.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        rol.setForeground(new java.awt.Color(0, 0, 255));
        rol.setText("Elige tu rol:");

        eligerol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "administrador", "diseñador", "profesor", "alumno" }));
        eligerol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eligerolActionPerformed(evt);
            }
        });

        VolverUsuarios.setBackground(new java.awt.Color(204, 255, 255));
        VolverUsuarios.setForeground(new java.awt.Color(0, 51, 153));
        VolverUsuarios.setText("Volver");
        VolverUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverUsuariosActionPerformed(evt);
            }
        });

        darbotonUsuario.setBackground(new java.awt.Color(204, 255, 255));
        darbotonUsuario.setForeground(new java.awt.Color(51, 51, 255));
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
                .addComponent(email)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearUsuariosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Texto)
                .addGap(157, 157, 157)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearUsuariosLayout.createSequentialGroup()
                .addGroup(CrearUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CrearUsuariosLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(Nombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearUsuariosLayout.createSequentialGroup()
                        .addContainerGap(55, Short.MAX_VALUE)
                        .addComponent(intronombre, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(208, 208, 208)))
                .addGroup(CrearUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(contraseña, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(introcontraseña))
                .addGap(65, 65, 65))
            .addGroup(CrearUsuariosLayout.createSequentialGroup()
                .addGroup(CrearUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(CrearUsuariosLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(apellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(CrearUsuariosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(CrearUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(introapellido, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(introemail))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(CrearUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearUsuariosLayout.createSequentialGroup()
                        .addComponent(rol)
                        .addGap(105, 105, 105))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearUsuariosLayout.createSequentialGroup()
                        .addComponent(eligerol, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(CrearUsuariosLayout.createSequentialGroup()
                        .addComponent(darbotonUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearUsuariosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(VolverUsuarios)
                .addGap(23, 23, 23))
        );
        CrearUsuariosLayout.setVerticalGroup(
            CrearUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrearUsuariosLayout.createSequentialGroup()
                .addGroup(CrearUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CrearUsuariosLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1))
                    .addGroup(CrearUsuariosLayout.createSequentialGroup()
                        .addGroup(CrearUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto))
                        .addGap(45, 45, 45)
                        .addGroup(CrearUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(contraseña)
                            .addComponent(Nombre))
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
                .addGroup(CrearUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(darbotonUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(introemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(VolverUsuarios)
                .addGap(24, 24, 24))
        );

        getContentPane().add(CrearUsuarios, "card5");

        RutasValidas.setBackground(new java.awt.Color(204, 204, 255));
        RutasValidas.setForeground(new java.awt.Color(255, 255, 255));
        RutasValidas.setMaximumSize(new java.awt.Dimension(600, 400));
        RutasValidas.setMinimumSize(new java.awt.Dimension(600, 400));

        VolverInicio.setBackground(new java.awt.Color(204, 255, 255));
        VolverInicio.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        VolverInicio.setForeground(new java.awt.Color(0, 0, 153));
        VolverInicio.setText("Volver");
        VolverInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverInicioActionPerformed(evt);
            }
        });

        NombreRutas.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        NombreRutas.setForeground(new java.awt.Color(0, 0, 255));
        NombreRutas.setText("Rutas Validas");

        TableRutasValidas.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
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
        TableRutasValidas.setSelectionBackground(new java.awt.Color(255, 255, 255));
        TableRutasValidas.setSelectionForeground(new java.awt.Color(255, 255, 255));
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

        Botonparacrearrutas.setBackground(new java.awt.Color(204, 255, 255));
        Botonparacrearrutas.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        Botonparacrearrutas.setForeground(new java.awt.Color(0, 0, 153));
        Botonparacrearrutas.setText("Crear ruta");
        Botonparacrearrutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonparacrearrutasActionPerformed(evt);
            }
        });

        Botonpararefrecartablas.setBackground(new java.awt.Color(204, 255, 255));
        Botonpararefrecartablas.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        Botonpararefrecartablas.setForeground(new java.awt.Color(0, 0, 204));
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RutasValidasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NombreRutas)
                .addGap(179, 179, 179)
                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(RutasValidasLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(RutasValidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(RutasValidasLayout.createSequentialGroup()
                        .addComponent(Botonparacrearrutas)
                        .addGap(111, 111, 111)
                        .addComponent(Botonpararefrecartablas)
                        .addGap(127, 127, 127)
                        .addComponent(VolverInicio)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        RutasValidasLayout.setVerticalGroup(
            RutasValidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RutasValidasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RutasValidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NombreRutas)
                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(RutasValidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Botonparacrearrutas)
                    .addComponent(Botonpararefrecartablas)
                    .addComponent(VolverInicio))
                .addGap(36, 36, 36))
        );

        getContentPane().add(RutasValidas, "card6");

        PuntosdeRuta.setBackground(new java.awt.Color(204, 204, 255));
        PuntosdeRuta.setMaximumSize(new java.awt.Dimension(600, 400));
        PuntosdeRuta.setMinimumSize(new java.awt.Dimension(600, 400));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("Puntos Interes");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
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

        jButton1.setBackground(new java.awt.Color(204, 255, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 204));
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

        BotonCrearPunto.setBackground(new java.awt.Color(204, 255, 255));
        BotonCrearPunto.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        BotonCrearPunto.setForeground(new java.awt.Color(0, 0, 204));
        BotonCrearPunto.setText("Crear Punto");
        BotonCrearPunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCrearPuntoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PuntosdeRutaLayout = new javax.swing.GroupLayout(PuntosdeRuta);
        PuntosdeRuta.setLayout(PuntosdeRutaLayout);
        PuntosdeRutaLayout.setHorizontalGroup(
            PuntosdeRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PuntosdeRutaLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(28, 28, 28)
                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PuntosdeRutaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PuntosdeRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonCrearPunto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(PuntosdeRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PuntosdeRutaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(PuntosdeRutaLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 8, Short.MAX_VALUE))))
        );
        PuntosdeRutaLayout.setVerticalGroup(
            PuntosdeRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PuntosdeRutaLayout.createSequentialGroup()
                .addGroup(PuntosdeRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PuntosdeRutaLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(PuntosdeRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)))
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PuntosdeRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addGroup(PuntosdeRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(BotonCrearPunto))
                .addGap(27, 27, 27))
        );

        getContentPane().add(PuntosdeRuta, "card7");

        ValoracionesdeRuta.setBackground(new java.awt.Color(204, 204, 255));
        ValoracionesdeRuta.setMaximumSize(new java.awt.Dimension(600, 400));
        ValoracionesdeRuta.setMinimumSize(new java.awt.Dimension(600, 400));

        jLabel4.setBackground(new java.awt.Color(102, 102, 255));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setText("Valoraciones");

        jButton2.setBackground(new java.awt.Color(204, 255, 255));
        jButton2.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 204));
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

        botoncrearvaloracion.setBackground(new java.awt.Color(204, 255, 255));
        botoncrearvaloracion.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        botoncrearvaloracion.setForeground(new java.awt.Color(0, 0, 204));
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
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(157, 157, 157)
                        .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ValoracionesdeRutaLayout.createSequentialGroup()
                        .addGroup(ValoracionesdeRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                            .addGroup(ValoracionesdeRutaLayout.createSequentialGroup()
                                .addComponent(botoncrearvaloracion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)))
                        .addGap(18, 18, 18))))
        );
        ValoracionesdeRutaLayout.setVerticalGroup(
            ValoracionesdeRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ValoracionesdeRutaLayout.createSequentialGroup()
                .addGroup(ValoracionesdeRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ValoracionesdeRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(botoncrearvaloracion))
                .addContainerGap())
        );

        getContentPane().add(ValoracionesdeRuta, "card8");

        Actividades.setBackground(new java.awt.Color(204, 204, 255));
        Actividades.setMaximumSize(new java.awt.Dimension(600, 400));
        Actividades.setMinimumSize(new java.awt.Dimension(600, 400));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
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

        jButton3.setBackground(new java.awt.Color(204, 255, 255));
        jButton3.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 153));
        jButton3.setText("Volver");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        BotoncrearActividad.setBackground(new java.awt.Color(204, 255, 255));
        BotoncrearActividad.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        BotoncrearActividad.setForeground(new java.awt.Color(0, 0, 255));
        BotoncrearActividad.setText("Crear Actividad");
        BotoncrearActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotoncrearActividadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ActividadesLayout = new javax.swing.GroupLayout(Actividades);
        Actividades.setLayout(ActividadesLayout);
        ActividadesLayout.setHorizontalGroup(
            ActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ActividadesLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(BotoncrearActividad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(31, 31, 31))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ActividadesLayout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .addGroup(ActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ActividadesLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(161, 161, 161)
                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ActividadesLayout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106))))
        );
        ActividadesLayout.setVerticalGroup(
            ActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ActividadesLayout.createSequentialGroup()
                .addGroup(ActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ActividadesLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel5)))
                .addGroup(ActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ActividadesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 82, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ActividadesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(ActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BotoncrearActividad)
                            .addComponent(jButton3))
                        .addGap(37, 37, 37))))
        );

        getContentPane().add(Actividades, "card9");

        DetallesRuta.setBackground(new java.awt.Color(204, 204, 255));
        DetallesRuta.setMaximumSize(new java.awt.Dimension(600, 400));
        DetallesRuta.setMinimumSize(new java.awt.Dimension(600, 400));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 255));
        jLabel6.setText("Detalles");

        jButton4.setBackground(new java.awt.Color(204, 255, 255));
        jButton4.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 204));
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
                .addGap(165, 165, 165)
                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(DetallesRutaLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(DetallesRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 19, Short.MAX_VALUE))
        );
        DetallesRutaLayout.setVerticalGroup(
            DetallesRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DetallesRutaLayout.createSequentialGroup()
                .addGroup(DetallesRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(DetallesRutaLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addGap(18, 18, 18))
        );

        getContentPane().add(DetallesRuta, "card10");

        ImagenesInteres.setBackground(new java.awt.Color(204, 204, 255));

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

        jButton5.setBackground(new java.awt.Color(204, 255, 255));
        jButton5.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 0, 204));
        jButton5.setText("Volver");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        CrearImagenes.setBackground(new java.awt.Color(204, 255, 255));
        CrearImagenes.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        CrearImagenes.setForeground(new java.awt.Color(0, 0, 204));
        CrearImagenes.setText("Crear Imagenes");
        CrearImagenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearImagenesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ImagenesInteresLayout = new javax.swing.GroupLayout(ImagenesInteres);
        ImagenesInteres.setLayout(ImagenesInteresLayout);
        ImagenesInteresLayout.setHorizontalGroup(
            ImagenesInteresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ImagenesInteresLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(CrearImagenes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(26, 26, 26))
            .addGroup(ImagenesInteresLayout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .addGroup(ImagenesInteresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ImagenesInteresLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ImagenesInteresLayout.createSequentialGroup()
                        .addComponent(NombreImagenesInteres)
                        .addGap(130, 130, 130)))
                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        ImagenesInteresLayout.setVerticalGroup(
            ImagenesInteresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImagenesInteresLayout.createSequentialGroup()
                .addGroup(ImagenesInteresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ImagenesInteresLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(NombreImagenesInteres)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(ImagenesInteresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CrearImagenes)
                    .addComponent(jButton5))
                .addGap(46, 46, 46))
        );

        getContentPane().add(ImagenesInteres, "card11");

        ImagenesPeligro.setBackground(new java.awt.Color(204, 204, 255));
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

        votonimagenvolverpeligro.setBackground(new java.awt.Color(204, 255, 255));
        votonimagenvolverpeligro.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        votonimagenvolverpeligro.setForeground(new java.awt.Color(0, 0, 204));
        votonimagenvolverpeligro.setText("Volver");
        votonimagenvolverpeligro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                votonimagenvolverpeligroActionPerformed(evt);
            }
        });

        CrearImagenesPeligro.setBackground(new java.awt.Color(204, 255, 255));
        CrearImagenesPeligro.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        CrearImagenesPeligro.setForeground(new java.awt.Color(0, 0, 255));
        CrearImagenesPeligro.setText("Crear Imagenes");
        CrearImagenesPeligro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearImagenesPeligroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ImagenesPeligroLayout = new javax.swing.GroupLayout(ImagenesPeligro);
        ImagenesPeligro.setLayout(ImagenesPeligroLayout);
        ImagenesPeligroLayout.setHorizontalGroup(
            ImagenesPeligroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ImagenesPeligroLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(CrearImagenesPeligro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(votonimagenvolverpeligro)
                .addGap(40, 40, 40))
            .addGroup(ImagenesPeligroLayout.createSequentialGroup()
                .addGroup(ImagenesPeligroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ImagenesPeligroLayout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE))
                    .addGroup(ImagenesPeligroLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Cuadroimagenespeligro)
                        .addGap(122, 122, 122)))
                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        ImagenesPeligroLayout.setVerticalGroup(
            ImagenesPeligroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImagenesPeligroLayout.createSequentialGroup()
                .addGroup(ImagenesPeligroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ImagenesPeligroLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(Cuadroimagenespeligro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(ImagenesPeligroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(votonimagenvolverpeligro)
                    .addComponent(CrearImagenesPeligro))
                .addGap(26, 26, 26))
        );

        getContentPane().add(ImagenesPeligro, "card11");

        CrearRutasde0.setBackground(new java.awt.Color(204, 204, 255));
        CrearRutasde0.setMaximumSize(new java.awt.Dimension(600, 400));
        CrearRutasde0.setMinimumSize(new java.awt.Dimension(600, 400));

        Cuadrodecrearrutas.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        Cuadrodecrearrutas.setForeground(new java.awt.Color(0, 0, 255));
        Cuadrodecrearrutas.setText("Crear Rutas");

        volverdecrearruta.setBackground(new java.awt.Color(204, 255, 255));
        volverdecrearruta.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        volverdecrearruta.setForeground(new java.awt.Color(0, 0, 204));
        volverdecrearruta.setText("Volver");
        volverdecrearruta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverdecrearrutaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 204));
        jLabel7.setText("Nombre de la ruta");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 204));
        jLabel8.setText("Nombre de inicio ruta");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 255));
        jLabel9.setText("Latitud");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 255));
        jLabel10.setText("Longitud");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 204));
        jLabel11.setText("Nombre fin de ruta");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 204));
        jLabel12.setText("Latitud");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 153));
        jLabel13.setText("Longitud");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 153));
        jLabel14.setText("Distancia");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 204));
        jLabel15.setText("Duracion:HH:mm:ss");

        Botonparacrearruta.setBackground(new java.awt.Color(204, 255, 255));
        Botonparacrearruta.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        Botonparacrearruta.setForeground(new java.awt.Color(51, 51, 255));
        Botonparacrearruta.setText("Crear Ruta");
        Botonparacrearruta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonparacrearrutaActionPerformed(evt);
            }
        });

        Botonvalidarutasir.setBackground(new java.awt.Color(204, 255, 255));
        Botonvalidarutasir.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        Botonvalidarutasir.setForeground(new java.awt.Color(0, 0, 204));
        Botonvalidarutasir.setText("Ver rutas no validas");
        Botonvalidarutasir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonvalidarutasirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CrearRutasde0Layout = new javax.swing.GroupLayout(CrearRutasde0);
        CrearRutasde0.setLayout(CrearRutasde0Layout);
        CrearRutasde0Layout.setHorizontalGroup(
            CrearRutasde0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrearRutasde0Layout.createSequentialGroup()
                .addGroup(CrearRutasde0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CrearRutasde0Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(CrearRutasde0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CrearRutasde0Layout.createSequentialGroup()
                                .addGroup(CrearRutasde0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ldi, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(li, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(CrearRutasde0Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jLabel10))
                                    .addComponent(jLabel8)
                                    .addComponent(Botonvalidarutasir))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 283, Short.MAX_VALUE))
                            .addGroup(CrearRutasde0Layout.createSequentialGroup()
                                .addComponent(nombreinicio, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel14)
                                .addGap(110, 110, 110))))
                    .addGroup(CrearRutasde0Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel9)
                        .addGroup(CrearRutasde0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CrearRutasde0Layout.createSequentialGroup()
                                .addGap(182, 182, 182)
                                .addGroup(CrearRutasde0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(duracion, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(distancia, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearRutasde0Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(CrearRutasde0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Cuadrodecrearrutas)
                                    .addComponent(jLabel7))
                                .addGap(70, 70, 70)))))
                .addGroup(CrearRutasde0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CrearRutasde0Layout.createSequentialGroup()
                        .addGroup(CrearRutasde0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearRutasde0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(nombrefini, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ldf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addGroup(CrearRutasde0Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel13))
                            .addComponent(lf, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(volverdecrearruta, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(31, 31, 31))
                    .addComponent(jLabel60, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearRutasde0Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(CrearRutasde0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearRutasde0Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(249, 249, 249))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearRutasde0Layout.createSequentialGroup()
                        .addGroup(CrearRutasde0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreruta, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Botonparacrearruta, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(236, 236, 236))))
        );
        CrearRutasde0Layout.setVerticalGroup(
            CrearRutasde0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrearRutasde0Layout.createSequentialGroup()
                .addGroup(CrearRutasde0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(CrearRutasde0Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Cuadrodecrearrutas)))
                .addGroup(CrearRutasde0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CrearRutasde0Layout.createSequentialGroup()
                        .addGroup(CrearRutasde0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CrearRutasde0Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(CrearRutasde0Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addGap(44, 44, 44)
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
                        .addGap(16, 143, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearRutasde0Layout.createSequentialGroup()
                        .addComponent(ldi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                        .addGroup(CrearRutasde0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Botonparacrearruta)
                            .addComponent(Botonvalidarutasir)
                            .addComponent(volverdecrearruta))
                        .addGap(35, 35, 35))))
        );

        getContentPane().add(CrearRutasde0, "card12");

        CatalogodeRutas.setBackground(new java.awt.Color(204, 204, 255));
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

        volverarutasdesdeno.setBackground(new java.awt.Color(204, 255, 255));
        volverarutasdesdeno.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        volverarutasdesdeno.setForeground(new java.awt.Color(0, 0, 204));
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
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(CatalogodeRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CatalogodeRutasLayout.createSequentialGroup()
                        .addGroup(CatalogodeRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(volverarutasdesdeno)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CatalogodeRutasLayout.createSequentialGroup()
                        .addComponent(Nombrerutasinavlidas)
                        .addGap(113, 113, 113)
                        .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        CatalogodeRutasLayout.setVerticalGroup(
            CatalogodeRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CatalogodeRutasLayout.createSequentialGroup()
                .addGroup(CatalogodeRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CatalogodeRutasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CatalogodeRutasLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(Nombrerutasinavlidas)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(volverarutasdesdeno)
                .addContainerGap())
        );

        getContentPane().add(CatalogodeRutas, "card13");

        Panelparacrearvaloracion.setBackground(new java.awt.Color(204, 204, 255));
        Panelparacrearvaloracion.setMaximumSize(new java.awt.Dimension(600, 400));
        Panelparacrearvaloracion.setMinimumSize(new java.awt.Dimension(600, 400));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 51, 255));
        jLabel16.setText("Crear Valoracion");

        Volveraverlasvaloraciones.setBackground(new java.awt.Color(204, 255, 255));
        Volveraverlasvaloraciones.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        Volveraverlasvaloraciones.setForeground(new java.awt.Color(0, 0, 153));
        Volveraverlasvaloraciones.setText("Volver");
        Volveraverlasvaloraciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolveraverlasvaloracionesActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 204));
        jLabel17.setText("Dificultad 1-5");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 153));
        jLabel18.setText("Estrellas 1-5");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 255));
        jLabel19.setText("Interes Cultural 1-5");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 204));
        jLabel20.setText("Belleza 1-5");

        jLabel21.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 204));
        jLabel21.setText("Crear Reseña");

        Botonparacrearvaloracion.setBackground(new java.awt.Color(204, 255, 255));
        Botonparacrearvaloracion.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        Botonparacrearvaloracion.setForeground(new java.awt.Color(0, 0, 204));
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
                .addContainerGap(248, Short.MAX_VALUE)
                .addGroup(PanelparacrearvaloracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelparacrearvaloracionLayout.createSequentialGroup()
                        .addComponent(Volveraverlasvaloraciones)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelparacrearvaloracionLayout.createSequentialGroup()
                        .addGroup(PanelparacrearvaloracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Botonparacrearvaloracion)
                            .addComponent(jLabel16))
                        .addGap(115, 115, 115)
                        .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelparacrearvaloracionLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(PanelparacrearvaloracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotonIntere, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelparacrearvaloracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Botonbelle, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                        .addComponent(Botondificul))
                    .addGroup(PanelparacrearvaloracionLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19)))
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
                .addGroup(PanelparacrearvaloracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelparacrearvaloracionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addGroup(PanelparacrearvaloracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Botonrese, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonIntere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(Botonbelle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(Botonparacrearvaloracion)
                .addGap(29, 29, 29)
                .addComponent(Volveraverlasvaloraciones)
                .addGap(20, 20, 20))
        );

        getContentPane().add(Panelparacrearvaloracion, "card14");

        PanelCalendario.setBackground(new java.awt.Color(204, 204, 255));
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

        BotonarutasdesdeCatalogo.setBackground(new java.awt.Color(204, 255, 255));
        BotonarutasdesdeCatalogo.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        BotonarutasdesdeCatalogo.setForeground(new java.awt.Color(0, 0, 204));
        BotonarutasdesdeCatalogo.setText("Volver");
        BotonarutasdesdeCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonarutasdesdeCatalogoActionPerformed(evt);
            }
        });

        botoncrearcalendario.setBackground(new java.awt.Color(204, 255, 255));
        botoncrearcalendario.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        botoncrearcalendario.setForeground(new java.awt.Color(0, 0, 153));
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
                .addGap(18, 18, 18)
                .addComponent(botoncrearcalendario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotonarutasdesdeCatalogo)
                .addGap(30, 30, 30))
            .addGroup(PanelCalendarioLayout.createSequentialGroup()
                .addGroup(PanelCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCalendarioLayout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelCalendarioLayout.createSequentialGroup()
                        .addContainerGap(133, Short.MAX_VALUE)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)))
                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelCalendarioLayout.setVerticalGroup(
            PanelCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCalendarioLayout.createSequentialGroup()
                .addGroup(PanelCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCalendarioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel22)
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botoncrearcalendario)
                    .addComponent(BotonarutasdesdeCatalogo))
                .addGap(43, 43, 43))
        );

        getContentPane().add(PanelCalendario, "card15");

        CrearCalendario.setBackground(new java.awt.Color(204, 204, 255));
        CrearCalendario.setForeground(new java.awt.Color(255, 255, 255));
        CrearCalendario.setMaximumSize(new java.awt.Dimension(600, 400));
        CrearCalendario.setMinimumSize(new java.awt.Dimension(600, 400));

        jLabel23.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 255));
        jLabel23.setText("Crear Calendario para una ruta determinada");

        jLabel24.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 153));
        jLabel24.setText("Detalles");

        VolveraCalendario.setBackground(new java.awt.Color(204, 255, 255));
        VolveraCalendario.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        VolveraCalendario.setForeground(new java.awt.Color(0, 0, 153));
        VolveraCalendario.setText("Volver");
        VolveraCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolveraCalendarioActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 204));
        jLabel25.setText("Recomendaciones");

        botoncrearcalendariode0.setBackground(new java.awt.Color(204, 255, 255));
        botoncrearcalendariode0.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        botoncrearcalendariode0.setForeground(new java.awt.Color(0, 0, 204));
        botoncrearcalendariode0.setText("Crear Calendario");
        botoncrearcalendariode0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoncrearcalendariode0ActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 204));
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
                .addGap(79, 79, 79)
                .addGroup(CrearCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CrearCalendarioLayout.createSequentialGroup()
                        .addComponent(añadefech, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(CrearCalendarioLayout.createSequentialGroup()
                        .addComponent(Creardetall, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
                        .addComponent(CrearRecomen, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))))
            .addGroup(CrearCalendarioLayout.createSequentialGroup()
                .addGroup(CrearCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CrearCalendarioLayout.createSequentialGroup()
                        .addGroup(CrearCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CrearCalendarioLayout.createSequentialGroup()
                                .addGap(249, 249, 249)
                                .addComponent(botoncrearcalendariode0))
                            .addGroup(CrearCalendarioLayout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(jLabel26)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearCalendarioLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel23)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        CrearCalendarioLayout.setVerticalGroup(
            CrearCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrearCalendarioLayout.createSequentialGroup()
                .addGroup(CrearCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(CrearCalendarioLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel23)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(botoncrearcalendariode0)
                .addGap(27, 27, 27)
                .addComponent(VolveraCalendario)
                .addGap(39, 39, 39))
        );

        getContentPane().add(CrearCalendario, "card16");

        CrearPuntosRutap.setBackground(new java.awt.Color(204, 204, 255));
        CrearPuntosRutap.setMaximumSize(new java.awt.Dimension(600, 400));
        CrearPuntosRutap.setMinimumSize(new java.awt.Dimension(600, 400));

        jLabel27.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 204));
        jLabel27.setText("Crear Puntos");

        Nombrep.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        Nombrep.setForeground(new java.awt.Color(0, 0, 204));
        Nombrep.setText("Nombre");

        Latitudp.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        Latitudp.setForeground(new java.awt.Color(0, 0, 204));
        Latitudp.setText("Latitud");

        jButton6.setBackground(new java.awt.Color(204, 255, 255));
        jButton6.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 0, 204));
        jButton6.setText("Crear Punto");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        BotonvolverPunto.setBackground(new java.awt.Color(204, 255, 255));
        BotonvolverPunto.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        BotonvolverPunto.setForeground(new java.awt.Color(0, 0, 153));
        BotonvolverPunto.setText("Volver");
        BotonvolverPunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonvolverPuntoActionPerformed(evt);
            }
        });

        Longitudp.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        Longitudp.setForeground(new java.awt.Color(0, 0, 204));
        Longitudp.setText("Longitud");

        Elevacionp.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        Elevacionp.setForeground(new java.awt.Color(0, 0, 204));
        Elevacionp.setText("Elevacion");

        EligePunto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Punto Interes", "Punto Peligro" }));

        Descripcionp.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        Descripcionp.setForeground(new java.awt.Color(0, 0, 204));
        Descripcionp.setText("Descripcion");

        javax.swing.GroupLayout CrearPuntosRutapLayout = new javax.swing.GroupLayout(CrearPuntosRutap);
        CrearPuntosRutap.setLayout(CrearPuntosRutapLayout);
        CrearPuntosRutapLayout.setHorizontalGroup(
            CrearPuntosRutapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrearPuntosRutapLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(CrearPuntosRutapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CrearPuntosRutapLayout.createSequentialGroup()
                        .addComponent(nombreLongitud1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(427, Short.MAX_VALUE))
                    .addGroup(CrearPuntosRutapLayout.createSequentialGroup()
                        .addGroup(CrearPuntosRutapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CrearPuntosRutapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CrearPuntosRutapLayout.createSequentialGroup()
                                    .addGap(29, 29, 29)
                                    .addComponent(Nombrep)
                                    .addGap(9, 9, 9))
                                .addComponent(nombreLatitud1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                .addComponent(nombrePP))
                            .addGroup(CrearPuntosRutapLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(CrearPuntosRutapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Latitudp)
                                    .addComponent(Longitudp))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(CrearPuntosRutapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearPuntosRutapLayout.createSequentialGroup()
                                .addComponent(nombreElevacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearPuntosRutapLayout.createSequentialGroup()
                                .addComponent(Elevacionp)
                                .addGap(98, 98, 98))
                            .addGroup(CrearPuntosRutapLayout.createSequentialGroup()
                                .addComponent(nombreDescripcion1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearPuntosRutapLayout.createSequentialGroup()
                                .addComponent(Descripcionp)
                                .addGap(90, 90, 90))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearPuntosRutapLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(CrearPuntosRutapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearPuntosRutapLayout.createSequentialGroup()
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(157, 157, 157))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearPuntosRutapLayout.createSequentialGroup()
                                .addComponent(BotonvolverPunto)
                                .addGap(19, 19, 19))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearPuntosRutapLayout.createSequentialGroup()
                                .addGroup(CrearPuntosRutapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(CrearPuntosRutapLayout.createSequentialGroup()
                                        .addComponent(EligePunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(161, 161, 161))
                                    .addGroup(CrearPuntosRutapLayout.createSequentialGroup()
                                        .addComponent(jLabel27)
                                        .addGap(146, 146, 146)))
                                .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        CrearPuntosRutapLayout.setVerticalGroup(
            CrearPuntosRutapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrearPuntosRutapLayout.createSequentialGroup()
                .addGroup(CrearPuntosRutapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CrearPuntosRutapLayout.createSequentialGroup()
                        .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addGroup(CrearPuntosRutapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Elevacionp)
                            .addComponent(Nombrep))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CrearPuntosRutapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreElevacion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombrePP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(Latitudp))
                    .addGroup(CrearPuntosRutapLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EligePunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)))
                .addGroup(CrearPuntosRutapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CrearPuntosRutapLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(nombreLatitud1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Longitudp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombreLongitud1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 173, Short.MAX_VALUE))
                    .addGroup(CrearPuntosRutapLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(Descripcionp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombreDescripcion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(BotonvolverPunto)
                        .addGap(17, 17, 17))))
        );

        getContentPane().add(CrearPuntosRutap, "card17");

        CrearActividades.setBackground(new java.awt.Color(204, 204, 255));
        CrearActividades.setForeground(new java.awt.Color(153, 255, 153));
        CrearActividades.setMaximumSize(new java.awt.Dimension(600, 400));
        CrearActividades.setMinimumSize(new java.awt.Dimension(600, 400));

        jLabel28.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(51, 0, 255));
        jLabel28.setText("Crear Actividad");

        jLabel29.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 204));
        jLabel29.setText("Nombre");

        volveraactividad.setBackground(new java.awt.Color(204, 255, 255));
        volveraactividad.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        volveraactividad.setForeground(new java.awt.Color(0, 0, 204));
        volveraactividad.setText("Volver");
        volveraactividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volveraactividadActionPerformed(evt);
            }
        });

        CrearActividadBoton.setBackground(new java.awt.Color(204, 255, 255));
        CrearActividadBoton.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        CrearActividadBoton.setForeground(new java.awt.Color(0, 0, 153));
        CrearActividadBoton.setText("Crear Actividad");
        CrearActividadBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearActividadBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CrearActividadesLayout = new javax.swing.GroupLayout(CrearActividades);
        CrearActividades.setLayout(CrearActividadesLayout);
        CrearActividadesLayout.setHorizontalGroup(
            CrearActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrearActividadesLayout.createSequentialGroup()
                .addContainerGap(236, Short.MAX_VALUE)
                .addGroup(CrearActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearActividadesLayout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135)
                        .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearActividadesLayout.createSequentialGroup()
                        .addComponent(NombreActi, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(221, 221, 221))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearActividadesLayout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(271, 271, 271))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearActividadesLayout.createSequentialGroup()
                        .addComponent(CrearActividadBoton)
                        .addGap(230, 230, 230))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearActividadesLayout.createSequentialGroup()
                        .addComponent(volveraactividad)
                        .addGap(34, 34, 34))))
        );
        CrearActividadesLayout.setVerticalGroup(
            CrearActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrearActividadesLayout.createSequentialGroup()
                .addGroup(CrearActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CrearActividadesLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel28))
                    .addComponent(jLabel66, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NombreActi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(CrearActividadBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addComponent(volveraactividad)
                .addGap(37, 37, 37))
        );

        getContentPane().add(CrearActividades, "card18");

        CrearImagen.setBackground(new java.awt.Color(204, 204, 255));
        CrearImagen.setMaximumSize(new java.awt.Dimension(600, 400));
        CrearImagen.setMinimumSize(new java.awt.Dimension(600, 400));

        jLabel30.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 255));
        jLabel30.setText("Crear Imagen");

        jLabel31.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 204));
        jLabel31.setText("URL:  .jpg o .png");

        jLabel32.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 204));
        jLabel32.setText("Descripcion");

        CrearImagenesnuevo.setBackground(new java.awt.Color(204, 255, 255));
        CrearImagenesnuevo.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        CrearImagenesnuevo.setForeground(new java.awt.Color(0, 0, 204));
        CrearImagenesnuevo.setText("Crear Imagen");
        CrearImagenesnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearImagenesnuevoActionPerformed(evt);
            }
        });

        VolverImagenes.setBackground(new java.awt.Color(204, 255, 255));
        VolverImagenes.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        VolverImagenes.setForeground(new java.awt.Color(0, 0, 204));
        VolverImagenes.setText("Volver");
        VolverImagenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverImagenesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CrearImagenLayout = new javax.swing.GroupLayout(CrearImagen);
        CrearImagen.setLayout(CrearImagenLayout);
        CrearImagenLayout.setHorizontalGroup(
            CrearImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrearImagenLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel32)
                .addGap(98, 98, 98))
            .addGroup(CrearImagenLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(ValidaURL, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 230, Short.MAX_VALUE)
                .addComponent(ValidaDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearImagenLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(VolverImagenes)
                .addGap(22, 22, 22))
            .addGroup(CrearImagenLayout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addGroup(CrearImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CrearImagenLayout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CrearImagenLayout.createSequentialGroup()
                        .addComponent(CrearImagenesnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        CrearImagenLayout.setVerticalGroup(
            CrearImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrearImagenLayout.createSequentialGroup()
                .addGroup(CrearImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CrearImagenLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel30))
                    .addComponent(jLabel67, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(CrearImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CrearImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ValidaURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ValidaDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(CrearImagenesnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150)
                .addComponent(VolverImagenes)
                .addGap(23, 23, 23))
        );

        getContentPane().add(CrearImagen, "card19");

        CrearImagenPeligrop.setBackground(new java.awt.Color(204, 204, 255));
        CrearImagenPeligrop.setMaximumSize(new java.awt.Dimension(600, 400));
        CrearImagenPeligrop.setMinimumSize(new java.awt.Dimension(600, 400));

        jLabel33.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 204));
        jLabel33.setText("Crear Imagen");

        jLabel34.setText("URL: .JPG O .PNG");

        descripcionpl.setText("Descripcion");

        crearimagenpeligro.setBackground(new java.awt.Color(204, 255, 255));
        crearimagenpeligro.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        crearimagenpeligro.setForeground(new java.awt.Color(0, 0, 255));
        crearimagenpeligro.setText("Crear Imagen");
        crearimagenpeligro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearimagenpeligroActionPerformed(evt);
            }
        });

        VolverImagnesPeligro.setBackground(new java.awt.Color(204, 255, 255));
        VolverImagnesPeligro.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        VolverImagnesPeligro.setForeground(new java.awt.Color(0, 0, 204));
        VolverImagnesPeligro.setText("Volver");
        VolverImagnesPeligro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverImagnesPeligroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CrearImagenPeligropLayout = new javax.swing.GroupLayout(CrearImagenPeligrop);
        CrearImagenPeligrop.setLayout(CrearImagenPeligropLayout);
        CrearImagenPeligropLayout.setHorizontalGroup(
            CrearImagenPeligropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearImagenPeligropLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(VolverImagnesPeligro)
                .addGap(26, 26, 26))
            .addGroup(CrearImagenPeligropLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(descripcionpl)
                .addGap(117, 117, 117))
            .addGroup(CrearImagenPeligropLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(CrearURLY, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                .addComponent(CREARDESCRIPCION, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
            .addGroup(CrearImagenPeligropLayout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addGroup(CrearImagenPeligropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(crearimagenpeligro, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        CrearImagenPeligropLayout.setVerticalGroup(
            CrearImagenPeligropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrearImagenPeligropLayout.createSequentialGroup()
                .addGroup(CrearImagenPeligropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CrearImagenPeligropLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel33))
                    .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(CrearImagenPeligropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(descripcionpl))
                .addGap(18, 18, 18)
                .addGroup(CrearImagenPeligropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CrearURLY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CREARDESCRIPCION, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(crearimagenpeligro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
                .addComponent(VolverImagnesPeligro)
                .addGap(24, 24, 24))
        );

        getContentPane().add(CrearImagenPeligrop, "card20");

        ValidaRutas.setBackground(new java.awt.Color(204, 204, 255));
        ValidaRutas.setMaximumSize(new java.awt.Dimension(600, 400));
        ValidaRutas.setMinimumSize(new java.awt.Dimension(600, 400));

        jLabel35.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 255));
        jLabel35.setText("Modificar Rutas");

        jLabel36.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 0, 153));
        jLabel36.setText("Desnivel Positivo");

        jLabel37.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 0, 153));
        jLabel37.setText("Desnivel Negativo");

        jLabel38.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 0, 255));
        jLabel38.setText("Tipo Terreno");

        jLabel39.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 0, 204));
        jLabel39.setText("Altitud maxima");

        jLabel40.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 0, 204));
        jLabel40.setText("Altitud Minima");

        jLabel41.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 0, 204));
        jLabel41.setText("Indicaciones");

        jLabel42.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 0, 204));
        jLabel42.setText("Ruta Familiar");

        jLabel43.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 0, 204));
        jLabel43.setText("Accesibilidad");

        jLabel45.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 0, 204));
        jLabel45.setText("Temporadas");

        jLabel46.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 0, 153));
        jLabel46.setText("Clasificacion");

        jLabel48.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(0, 0, 204));
        jLabel48.setText("Recomendaciones");

        recomen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recomenActionPerformed(evt);
            }
        });

        BotonvolverRutass.setBackground(new java.awt.Color(204, 255, 255));
        BotonvolverRutass.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        BotonvolverRutass.setForeground(new java.awt.Color(0, 0, 204));
        BotonvolverRutass.setText("Volver");
        BotonvolverRutass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonvolverRutassActionPerformed(evt);
            }
        });

        BotonParamodificarUsuario.setBackground(new java.awt.Color(204, 255, 255));
        BotonParamodificarUsuario.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        BotonParamodificarUsuario.setForeground(new java.awt.Color(0, 0, 204));
        BotonParamodificarUsuario.setText("Modifica el usuario");
        BotonParamodificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonParamodificarUsuarioActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 51, 255));
        jLabel44.setText("Solo se modificaran los campos que no esten en blanco");

        clasi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "circular", "lineal" }));

        rutafam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "si", "no" }));

        jLabel47.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(0, 0, 204));
        jLabel47.setText("Zona Geografica");

        geo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                geoActionPerformed(evt);
            }
        });

        accesibilidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "si", "no" }));

        javax.swing.GroupLayout ValidaRutasLayout = new javax.swing.GroupLayout(ValidaRutas);
        ValidaRutas.setLayout(ValidaRutasLayout);
        ValidaRutasLayout.setHorizontalGroup(
            ValidaRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ValidaRutasLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(ValidaRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ValidaRutasLayout.createSequentialGroup()
                        .addGroup(ValidaRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ValidaRutasLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel38)
                                .addGap(111, 111, 111)
                                .addComponent(jLabel41)
                                .addGap(77, 77, 77)
                                .addComponent(jLabel45))
                            .addComponent(jLabel36))
                        .addContainerGap())
                    .addGroup(ValidaRutasLayout.createSequentialGroup()
                        .addGroup(ValidaRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ValidaRutasLayout.createSequentialGroup()
                                .addGroup(ValidaRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ValidaRutasLayout.createSequentialGroup()
                                        .addGroup(ValidaRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel37)
                                            .addComponent(desnivelnegativo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tipoterreno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(ValidaRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(ValidaRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(ValidaRutasLayout.createSequentialGroup()
                                                    .addGap(105, 105, 105)
                                                    .addComponent(jLabel39))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ValidaRutasLayout.createSequentialGroup()
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(ValidaRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(altmaxima, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(indicaciones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(ValidaRutasLayout.createSequentialGroup()
                                                .addGap(102, 102, 102)
                                                .addGroup(ValidaRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel40)
                                                    .addComponent(altminima, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(BotonParamodificarUsuario)))))
                                    .addComponent(desnivelpositivo, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(ValidaRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rutafam, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(accesibilidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(ValidaRutasLayout.createSequentialGroup()
                                        .addGroup(ValidaRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel42)
                                            .addGroup(ValidaRutasLayout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(jLabel43)))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(temp)))
                            .addGroup(ValidaRutasLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(ValidaRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel44)
                                    .addGroup(ValidaRutasLayout.createSequentialGroup()
                                        .addComponent(jLabel35)
                                        .addGap(78, 78, 78)))))
                        .addGroup(ValidaRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ValidaRutasLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(ValidaRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ValidaRutasLayout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addGroup(ValidaRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel46)
                                            .addComponent(clasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ValidaRutasLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(ValidaRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(BotonvolverRutass)
                                            .addGroup(ValidaRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel47)
                                                .addComponent(recomen, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(geo)))
                                        .addGap(13, 13, 13))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ValidaRutasLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        ValidaRutasLayout.setVerticalGroup(
            ValidaRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ValidaRutasLayout.createSequentialGroup()
                .addGroup(ValidaRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ValidaRutasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ValidaRutasLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel35)))
                .addGap(18, 18, 18)
                .addGroup(ValidaRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jLabel39)
                    .addComponent(jLabel46)
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ValidaRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ValidaRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(altmaxima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(clasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rutafam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(desnivelpositivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(ValidaRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ValidaRutasLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ValidaRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel43)
                        .addComponent(jLabel40)
                        .addComponent(jLabel47)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ValidaRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ValidaRutasLayout.createSequentialGroup()
                        .addGroup(ValidaRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(desnivelnegativo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(altminima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(ValidaRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(jLabel41)
                            .addComponent(jLabel45)
                            .addComponent(jLabel48))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ValidaRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tipoterreno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(indicaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(recomen, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(temp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ValidaRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(geo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(accesibilidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(BotonParamodificarUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ValidaRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ValidaRutasLayout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ValidaRutasLayout.createSequentialGroup()
                        .addComponent(BotonvolverRutass)
                        .addGap(27, 27, 27))))
        );

        getContentPane().add(ValidaRutas, "card21");

        pack();
    }// </editor-fold>//GEN-END:initComponents
//Metodo de volver
    private void BotonEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEntradaActionPerformed
        PanelEntrada.setVisible(false);
        PanelInicio.setVisible(true);
    }//GEN-LAST:event_BotonEntradaActionPerformed
//Metodo de volver
    private void SalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalidaActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "Desea salir de la aplicacion", "Salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == 0) {
            boolean conn=AccesoABaseDatos.getInstance().cerrar();
            if (conn==true) {
                System.out.println("Se quito la conexion con la base de datos");
            }else{
                System.out.println("No se quito la conexion con la base de datos");
            }
            System.exit(0);
        }
    }//GEN-LAST:event_SalidaActionPerformed
//Metodo de volver
    private void RutasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RutasActionPerformed
        PanelInicio.setVisible(false);
        RutasValidas.setVisible(true);
        TableRutasValidas.setVisible(true);
        VolverInicio.setVisible(true);
        jScrollPane1.setVisible(true);
        Botonpararefrecartablas.setVisible(true);

    }//GEN-LAST:event_RutasActionPerformed
//Metodo que inicia sesion con email y contraseña validos
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
                BotonCrearPunto.setVisible(true);
                BotoncrearActividad.setVisible(true);
                CrearImagenes.setVisible(true);
                BotonCrearPunto.setVisible(true);
                CrearImagenes.setVisible(true);
                CrearImagenesPeligro.setVisible(true);
                BotoncrearActividad.setVisible(true);
                usuario = U1;
                if (usuario.getRol() == Roles.administrador || usuario.getRol() == Roles.diseñador || usuario.getRol() == Roles.profesor) {
                    Botonparacrearrutas.setVisible(true);
                }
                if (usuario.getRol() == Roles.administrador || usuario.getRol() == Roles.diseñador || usuario.getRol() == Roles.profesor || usuario.getRol() == Roles.alumno) {
                    botoncrearvaloracion.setVisible(true);
                }
                if (usuario.getRol() == Roles.profesor || usuario.getRol() == Roles.administrador) {
                    botoncrearcalendario.setVisible(true);
                    Botonvalidarutasir.setVisible(true);
                }
            }
            if (U1 == null) {
                JOptionPane.showMessageDialog(null, "No se encontro a ningun usuario con ese email o contraseña", "Volver", JOptionPane.PLAIN_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Formato mal introducido el email o contraseña", "Volver", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_IniciarSesionActionPerformed
//Metodo de volver
    private void UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioActionPerformed
        CrearUsuarios.setVisible(true);
        PanelInicio.setVisible(false);
    }//GEN-LAST:event_UsuarioActionPerformed

    private void eligerolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eligerolActionPerformed

    }//GEN-LAST:event_eligerolActionPerformed
//Metodo de volver
    private void VolverUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverUsuariosActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "Desea volver a menu de inicio", "Volver", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == 0) {
            CrearUsuarios.setVisible(false);
            PanelInicio.setVisible(true);
        }
    }//GEN-LAST:event_VolverUsuariosActionPerformed
//metodo que crea el usuario
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
//Metodo de volver al main
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
        BotonCrearPunto.setVisible(false);
        BotoncrearActividad.setVisible(false);
        CrearImagenes.setVisible(false);
        BotonCrearPunto.setVisible(false);
        CrearImagenes.setVisible(false);
        CrearImagenesPeligro.setVisible(false);
        BotoncrearActividad.setVisible(false);
        Botonvalidarutasir.setVisible(false);
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
        TableRutasValidas.setAutoCreateRowSorter(true);
        TableRutasValidas.setModel(model);
        tamañocolumnasRutaValidas();
        TableRutasValidas.setOpaque(true);
    }//GEN-LAST:event_TableRutasValidasAncestorAdded
    //Al hacer click en una fila de la tabla RutasValidas te permite ver lo que puede hacer cada tipo de usuario
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
                    O1 = new Object[]{"Seleccione", "Puntos Interes y Puntos Peligro", "Detalles de la ruta", "Valoraciones", "Actividades", "Calendarios asociados", "Ver catalogo de rutas", "Descargar Ficha informativa", "Borrar ruta"};
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
//Metodo de volver
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
        TablePuntosInteres.getColumnModel().getColumn(0).setMinWidth(0);
        TablePuntosInteres.getColumnModel().getColumn(0).setMaxWidth(0);
        TablePuntosInteres.getColumnModel().getColumn(0).setPreferredWidth(0);
        TablePuntosInteres.setAutoCreateRowSorter(true);
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
        TablePuntosPeligro.setModel(model);
        TablePuntosPeligro.getColumnModel().getColumn(0).setMinWidth(0);
        TablePuntosPeligro.getColumnModel().getColumn(0).setMaxWidth(0);
        TablePuntosPeligro.getColumnModel().getColumn(0).setPreferredWidth(0);
        TablePuntosPeligro.setAutoCreateRowSorter(true);
    }//GEN-LAST:event_TablePuntosPeligroAncestorAdded
//Metodo de volver
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "Desea volver a ver las rutas", "Volver", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == 0) {
            idrutaapipp = 1;
            RutasValidas.setVisible(true);
            ValoracionesdeRuta.setVisible(false);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
//Metodo de volver
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
        TablaActividades.setModel(model);
        TablaActividades.getColumnModel().getColumn(0).setMinWidth(0);
        TablaActividades.getColumnModel().getColumn(0).setMaxWidth(0);
        TablaActividades.getColumnModel().getColumn(0).setPreferredWidth(0);
        TablaActividades.setAutoCreateRowSorter(true);
    }//GEN-LAST:event_TablaActividadesAncestorAdded
//Metodo de volver
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
        TablaValoraciones.setModel(model);
        TablaValoraciones.setAutoCreateRowSorter(true);
        TablaValoraciones.getColumnModel().getColumn(0).setMinWidth(0);
        TablaValoraciones.getColumnModel().getColumn(0).setMaxWidth(0);
        TablaValoraciones.getColumnModel().getColumn(0).setPreferredWidth(0);
    }//GEN-LAST:event_TablaValoracionesAncestorAdded
//Metodo de volver
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "Desea volver a ver los puntos", "Volver", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == 0) {
            idrutaapipp = 1;
            PuntosdeRuta.setVisible(true);
            ImagenesInteres.setVisible(false);
        }
    }//GEN-LAST:event_jButton5ActionPerformed
//Metodo queve las imagenes de un punto de interes y ademas podria eliminar este
    private void TablePuntosInteresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePuntosInteresMouseClicked
        int fila = TablePuntosInteres.getSelectedRow(); // Fila que has clicado 
        if (fila != -1) {
            Object valorColumna0 = TablePuntosInteres.getValueAt(fila, 0); // pillo la columna 0 
            int resultado = (int) valorColumna0;// valor recogido
            int respuesta = JOptionPane.showConfirmDialog(null, "Desea ver las imagenes o no ", "Validar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == 0) {
                idpi = resultado;
                PuntosdeRuta.setVisible(false);
                ImagenesInteres.setVisible(true);
            } else {
                int resp = JOptionPane.showConfirmDialog(null, "Desea borrar el punto", "Validar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == 0) {
                    DAOPuntosinteres daor = new DAOPuntosinteres();
                    if (daor.eliminar(resultado)) {
                        JOptionPane.showMessageDialog(null, "Se elimino el punto ", "Bien", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }

        }
    }//GEN-LAST:event_TablePuntosInteresMouseClicked
//Metodo de volver
    private void votonimagenvolverpeligroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_votonimagenvolverpeligroActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "Desea volver a ver los puntos", "Volver", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == 0) {
            idrutaapipp = 1;
            PuntosdeRuta.setVisible(true);
            ImagenesPeligro.setVisible(false);
        }
    }//GEN-LAST:event_votonimagenvolverpeligroActionPerformed
//Metodo que hace la tabla de imagenes de peligro
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

    }//GEN-LAST:event_TablaImagenesPeligroAncestorAdded
//Metodo para eliminar un punto de peligro al clicar
    private void TablePuntosPeligroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePuntosPeligroMouseClicked
        int fila = TablePuntosPeligro.getSelectedRow(); // Fila que has clicado 
        if (fila != -1) {
            Object valorColumna0 = TablePuntosPeligro.getValueAt(fila, 0); // pillo la columna 0 
            int resultado = (int) valorColumna0;// valor recogido 
            int respuesta = JOptionPane.showConfirmDialog(null, "Desea ver las imagenes ", "Validar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == 0) {
                idpp = resultado;
                PuntosdeRuta.setVisible(false);
                ImagenesPeligro.setVisible(true);
            } else {
                int resp = JOptionPane.showConfirmDialog(null, "Desea borrar el punnto", "Validar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == 0) {
                    DAOPuntospeligro daor = new DAOPuntospeligro();
                    if (daor.eliminar(resultado)) {
                        JOptionPane.showMessageDialog(null, "Se elimino el punto de interes", "Bien", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }

        }
    }//GEN-LAST:event_TablePuntosPeligroMouseClicked
//Metodo de volver
    private void BotonparacrearrutasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonparacrearrutasActionPerformed
        RutasValidas.setVisible(false);
        CrearRutasde0.setVisible(true);
    }//GEN-LAST:event_BotonparacrearrutasActionPerformed
//Metodo de volver
    private void volverdecrearrutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverdecrearrutaActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "Desea volver a ver los puntos", "Volver", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == 0) {
            RutasValidas.setVisible(true);
            CrearRutasde0.setVisible(false);
        }
    }//GEN-LAST:event_volverdecrearrutaActionPerformed
// Metodo que crea una ruta
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
//Metodo de volver
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
//Metodo que valida la ruta y puede eliminar si quiere
    private void TabladerutasnovalidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabladerutasnovalidasMouseClicked
        int fila = Tabladerutasnovalidas.getSelectedRow(); // Fila que has clicado 
        if (fila != -1) {
            Object valorColumna0 = Tabladerutasnovalidas.getValueAt(fila, 0); // pillo la columna 0 
            // String resultado = valorColumna0.toString(); si hay que convertirla a toString 
            int resultado = (int) valorColumna0;// valor recogido
            int respuesta = JOptionPane.showConfirmDialog(null, "Desea pasar una de estas rutas a ser valida o no", "Validar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == 0) {
                DAORutas daor = new DAORutas();
                if (daor.modificarporid(resultado)) {
                    JOptionPane.showMessageDialog(null, "La ruta paso a ser valida", "Bien", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                int res = JOptionPane.showConfirmDialog(null, "Desea eliminar una de estas rutas no validas", "Validar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (res == 0) {
                    DAORutas daor = new DAORutas();
                    if (daor.eliminar(resultado)) {
                        JOptionPane.showMessageDialog(null, "La ruta se elimino", "Bien", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }

        }
    }//GEN-LAST:event_TabladerutasnovalidasMouseClicked
//Metodo de volver
    private void botoncrearvaloracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoncrearvaloracionActionPerformed
        ValoracionesdeRuta.setVisible(false);
        Panelparacrearvaloracion.setVisible(true);
    }//GEN-LAST:event_botoncrearvaloracionActionPerformed
//Metodo de volver
    private void VolveraverlasvaloracionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolveraverlasvaloracionesActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "Desea volver a ver las valoraciones", "Volver", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == 0) {
            ValoracionesdeRuta.setVisible(true);
            Panelparacrearvaloracion.setVisible(false);
        }
    }//GEN-LAST:event_VolveraverlasvaloracionesActionPerformed
// Netodo que crea una valoracion
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
//Metodo de volver
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
        TablaCalendarios.setModel(model);
        TablaCalendarios.setAutoCreateRowSorter(true);
        TablaCalendarios.getColumnModel().getColumn(0).setMinWidth(0);
        TablaCalendarios.getColumnModel().getColumn(0).setMaxWidth(0);
        TablaCalendarios.getColumnModel().getColumn(0).setPreferredWidth(0);
    }//GEN-LAST:event_TablaCalendariosAncestorAdded
//Metodo de volver
    private void botoncrearcalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoncrearcalendarioActionPerformed
        CrearCalendario.setVisible(true);
        PanelCalendario.setVisible(false);
    }//GEN-LAST:event_botoncrearcalendarioActionPerformed
//Metodo de volver
    private void VolveraCalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolveraCalendarioActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "Desea volver a ver los calendarios", "Volver", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == 0) {
            CrearCalendario.setVisible(false);
            PanelCalendario.setVisible(true);
        }
    }//GEN-LAST:event_VolveraCalendarioActionPerformed
// boton que crea un calendario
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
        if (idrutaapipp >= 0) {
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
            JOptionPane.showMessageDialog(null, "Se actualizaron las tablas de la ruta: " + idrutaapipp, "Bien", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona unicamente 1 y no varias o ninguna rutas", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BotonpararefrecartablasActionPerformed
//Metodo que borra una actividad al clicar en ella
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
// Borra una valoracion al clicar
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
//Metodo que borra una imagen al clicar en ella
    private void TablaimagenesInteresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaimagenesInteresMouseClicked
        int fila = TablaimagenesInteres.getSelectedRow(); // Fila que has clicado 
        if (fila != -1) {
            Object valorColumna0 = TablaimagenesInteres.getValueAt(fila, 0); // pillo la columna 0 
            // String resultado = valorColumna0.toString(); si hay que convertirla a toString 
            int resultado = (int) valorColumna0;// valor recogido
            int filas = TablaimagenesInteres.rowAtPoint(evt.getPoint());
            int columna = TablaimagenesInteres.columnAtPoint(evt.getPoint());
            if (columna == 1) {
                ImageIcon icono = (ImageIcon) TablaimagenesInteres.getValueAt(filas, columna);
                String descripcion = (String) TablaimagenesInteres.getValueAt(filas, 2);
                if (icono != null) {
                    mostrarImagenYDescripcionEnPanel(icono, descripcion);
                }
            }
            int respuesta = JOptionPane.showConfirmDialog(null, "Desea eliminar esta imagen", "Borrar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == 0) {
                DAOImagenesInteres daor = new DAOImagenesInteres();
                if (daor.eliminar(resultado)) {
                    JOptionPane.showMessageDialog(null, "Se borro la imagen", "Bien", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_TablaimagenesInteresMouseClicked
//Metodo que borra una imagen al clicar en ella
    private void TablaImagenesPeligroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaImagenesPeligroMouseClicked
        int fila = TablaImagenesPeligro.getSelectedRow(); // Fila que has clicado 
        if (fila != -1) {
            Object valorColumna0 = TablaImagenesPeligro.getValueAt(fila, 0); // pillo la columna 0 
            // String resultado = valorColumna0.toString(); si hay que convertirla a toString 
            int resultado = (int) valorColumna0;// valor recogido
            int filas = TablaImagenesPeligro.rowAtPoint(evt.getPoint());
            int columna = TablaImagenesPeligro.columnAtPoint(evt.getPoint());
            if (columna == 1) {
                ImageIcon icono = (ImageIcon) TablaImagenesPeligro.getValueAt(filas, columna);
                String descripcion = (String) TablaImagenesPeligro.getValueAt(filas, 2);
                if (icono != null) {
                    mostrarImagenYDescripcionEnPanel(icono, descripcion);
                }
            }
            int respuesta = JOptionPane.showConfirmDialog(null, "Desea eliminar esta imagen", "Borrar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == 0) {
                DAOImagenesPeligro daor = new DAOImagenesPeligro();
                if (daor.eliminar(resultado)) {
                    JOptionPane.showMessageDialog(null, "Se borro la imagen", "Bien", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_TablaImagenesPeligroMouseClicked
//Metodo para borrar un calendario al clicar sobre este
    private void TablaCalendariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaCalendariosMouseClicked
        int fila = TablaCalendarios.getSelectedRow(); // Fila que has clicado 
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
//Metodo de volver
    private void BotonCrearPuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCrearPuntoActionPerformed
        this.PuntosdeRuta.setVisible(false);
        this.CrearPuntosRutap.setVisible(true);
    }//GEN-LAST:event_BotonCrearPuntoActionPerformed
//Metodo de volver
    private void BotonvolverPuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonvolverPuntoActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "Desea volver a ver los puntos", "Volver", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == 0) {
            this.PuntosdeRuta.setVisible(true);
            this.CrearPuntosRutap.setVisible(false);
        }
    }//GEN-LAST:event_BotonvolverPuntoActionPerformed
// Metodo que crea un punto de interes o peligro depende de lo elija el usuario
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String nombrepp = nombrePP.getText();
        String nombreLat1 = nombreLatitud1.getText();
        String elevacion1 = nombreElevacion1.getText();
        String descripcion1 = nombreDescripcion1.getText();
        String longitud1 = nombreLongitud1.getText();
        String seleccion = EligePunto.getSelectedItem().toString();
        if (seleccion.equals("Punto Interes")) {
            if (Teclado.validanombre(nombrepp) && Teclado.validaCoordenadas(nombreLat1)
                    && Teclado.validaCoordenadas(longitud1) && Teclado.validanombre(descripcion1) && Teclado.validaDesnivel(elevacion1)) {
                PuntosInteres pp = new PuntosInteres(nombrepp, Integer.parseInt(nombreLat1), Integer.parseInt(longitud1), Integer.parseInt(elevacion1), descripcion1);
                DAOPuntosinteres daopp = new DAOPuntosinteres();
                if (daopp.insertar(pp, idrutaapipp)) {
                    JOptionPane.showMessageDialog(null, "Se creo un punto de interes correctamnete", "Bien", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No se guardo el punto de interes en la base de datos", "Error", JOptionPane.PLAIN_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Formato mal introducido el formato de uno de los datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            if (Teclado.validanombre(nombrepp) && Teclado.validaCoordenadas(nombreLat1)
                    && Teclado.validaCoordenadas(longitud1) && Teclado.validanombre(descripcion1) && Teclado.validaDesnivel(elevacion1)) {
                PuntosPeligro pp = new PuntosPeligro(nombrepp, Integer.parseInt(nombreLat1), Integer.parseInt(longitud1), Integer.parseInt(elevacion1), descripcion1);
                DAOPuntospeligro daopp = new DAOPuntospeligro();
                if (daopp.insertar(pp, idrutaapipp)) {
                    JOptionPane.showMessageDialog(null, "Se creo un punto de peligro correctamnete", "Bien", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No se guardo el punto de peligro en la base de datos", "Error", JOptionPane.PLAIN_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Formato mal introducido el formato de uno de los datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed
//Metodo de volver
    private void BotoncrearActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotoncrearActividadActionPerformed
        Actividades.setVisible(false);
        CrearActividades.setVisible(true);
    }//GEN-LAST:event_BotoncrearActividadActionPerformed
//Metodo de volver
    private void volveraactividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volveraactividadActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "Desea volver a ver las actividades", "Volver", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == 0) {
            Actividades.setVisible(true);
            CrearActividades.setVisible(false);
        }
    }//GEN-LAST:event_volveraactividadActionPerformed
//Metodo que crea una actividad para una ruta
    private void CrearActividadBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearActividadBotonActionPerformed
        String nombre = this.NombreActi.getText();
        if (Teclado.validanombre(nombre)) {
            Actividad A1 = new Actividad(nombre);
            DAOActividad daoa = new DAOActividad();
            if (daoa.insertar(A1, idrutaapipp)) {
                JOptionPane.showMessageDialog(null, "Se creo una actividad correctamnete", "Bien", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se guardo la actividad en la base de datos", "Error", JOptionPane.PLAIN_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Formato mal introducido el formato de uno de los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_CrearActividadBotonActionPerformed
//Metodo de volver
    private void VolverImagenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverImagenesActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "Desea volver a ver las imagenes", "Volver", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == 0) {
            ImagenesInteres.setVisible(true);
            CrearImagen.setVisible(false);
        }
    }//GEN-LAST:event_VolverImagenesActionPerformed
//Metodo de volver
    private void CrearImagenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearImagenesActionPerformed
        ImagenesInteres.setVisible(false);
        CrearImagen.setVisible(true);
    }//GEN-LAST:event_CrearImagenesActionPerformed
//Metodo que crea una imagen de interes
    private void CrearImagenesnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearImagenesnuevoActionPerformed
        String URL = ValidaURL.getText();
        String descripcion = this.ValidaDescripcion.getText();
        if (Teclado.validaURL(URL) && Teclado.validanombre(descripcion)) {
            ImagenesInteres A1 = new ImagenesInteres(URL, descripcion);
            DAOImagenesInteres daoa = new DAOImagenesInteres();
            if (daoa.insertar(A1, idpi)) {
                JOptionPane.showMessageDialog(null, "Se creo una imagen correctamnete", "Bien", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se guardo una imagen en la base de datos", "Error", JOptionPane.PLAIN_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Formato mal introducido el formato de uno de los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_CrearImagenesnuevoActionPerformed
//Metodo de volver
    private void CrearImagenesPeligroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearImagenesPeligroActionPerformed
        ImagenesPeligro.setVisible(false);
        CrearImagenPeligrop.setVisible(true);
    }//GEN-LAST:event_CrearImagenesPeligroActionPerformed
//Metodo de volver
    private void VolverImagnesPeligroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverImagnesPeligroActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "Desea volver a ver las imagenes", "Volver", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == 0) {
            ImagenesPeligro.setVisible(true);
            CrearImagenPeligrop.setVisible(false);
        }
    }//GEN-LAST:event_VolverImagnesPeligroActionPerformed
//Metodo que crea una imagen de peligro
    private void crearimagenpeligroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearimagenpeligroActionPerformed
        String URL = CrearURLY.getText();
        String descripcion = this.CREARDESCRIPCION.getText();
        if (Teclado.validaURL(URL) && Teclado.validanombre(descripcion)) {
            ImagenesPeligro A1 = new ImagenesPeligro(URL, descripcion);
            DAOImagenesPeligro daoa = new DAOImagenesPeligro();
            System.out.println("id punto peligro:" + idpp);
            if (daoa.insertar(A1, idpp)) {
                JOptionPane.showMessageDialog(null, "Se creo una imagen correctamnete", "Bien", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se guardo la imagen en la base de datos", "Error", JOptionPane.PLAIN_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Formato mal introducido el formato de uno de los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_crearimagenpeligroActionPerformed
//Metodo que modifica rutas
    private void BotonParamodificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonParamodificarUsuarioActionPerformed
        String desnivelpos = desnivelpositivo.getText();
        String desnivelneg = desnivelnegativo.getText();
        String altitudmax = altmaxima.getText();
        String altitudmin = altminima.getText();
        String tipoTer = tipoterreno.getText();
        String indica = indicaciones.getText();
        String rutafamiliar = rutafam.getSelectedItem().toString();
        boolean rutafamiliarvalida = false;
        if (rutafamiliar.equals("si")) {
            rutafamiliarvalida = true;
        }
        String acesibilidad = this.accesibilidad.getSelectedItem().toString();
        boolean rutaacceso = false;
        if (acesibilidad.equals("si")) {
            rutaacceso = true;
        }
        String temporadas = temp.getText();
        String clasificacion = clasi.getSelectedItem().toString();
        String zonaGeografica = geo.getText();
        String recomendaciones = recomen.getText();
        DAORutas daor = new DAORutas();
        Rutas R1 = daor.buscarTodaInfo(idrutaapipp);
        if (Teclado.validaDesnivel(desnivelpos) && !desnivelpos.isEmpty()) {
            R1.setDesnivelPositivo(Integer.parseInt(desnivelpos));
        }
        if (Teclado.validaDesnivel(desnivelneg) && !desnivelneg.isEmpty()) {
            R1.setDesnivelNegativo(Integer.parseInt(desnivelneg));
        }
        if (Teclado.validaCoordenadas(altitudmax) && !altitudmax.isEmpty()) {
            R1.setAltitudMax(Double.parseDouble(altitudmax));
        }
        if (Teclado.validaCoordenadas(altitudmin) && !altitudmin.isEmpty()) {
            R1.setAltitudMin(Double.parseDouble(altitudmin));
        }
        if (Teclado.validaRango1a5(tipoTer) && !tipoTer.isEmpty()) {
            R1.setTipoterreno(Integer.parseInt(tipoTer));
        }
        if (Teclado.validaRango1a5(indica) && !indica.isEmpty()) {
            R1.setIndicaciones(Integer.parseInt(indica));
        }
        R1.setRutaFamiliar(rutafamiliarvalida);
        R1.setAccesibilidad(rutaacceso);
        Set<String> temp = new HashSet<>(Arrays.asList(temporadas.split(",")));
        if (Teclado.validaTemporada(temp) && !temporadas.isEmpty()) {
            R1.setTemporada(temp);
        }
        Clasificacion C1 = null;
        if (Teclado.validaClasificacion(clasificacion) && !clasificacion.isEmpty()) {
            if (clasificacion.equals("circular")) {
                C1 = Clasificacion.CIRCULAR;
            } else {
                C1 = Clasificacion.LINEAL;
            }
            R1.setClasificacion(C1);
        }
        if (!zonaGeografica.isEmpty()) {
            R1.setZonaGeografica(zonaGeografica);
        }
        if (!recomendaciones.isEmpty()) {
            R1.setRecomendaciones(recomendaciones);
        }
        if (daor.modificarr(R1)) {
            JOptionPane.showMessageDialog(null, "Se modifico la ruta", "Bien", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se guardo los cambios de la ruta en la base de datos", "Error", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_BotonParamodificarUsuarioActionPerformed
//Boton de volver
    private void BotonvolverRutassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonvolverRutassActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "Desea volver a ver las rutas", "Volver", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == 0) {
            RutasValidas.setVisible(true);
            ValidaRutas.setVisible(false);
        }
    }//GEN-LAST:event_BotonvolverRutassActionPerformed

    private void recomenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recomenActionPerformed

    }//GEN-LAST:event_recomenActionPerformed

    private void geoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_geoActionPerformed

    }//GEN-LAST:event_geoActionPerformed
//Metodo de volver
    private void BotonvalidarutasirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonvalidarutasirActionPerformed
        CrearRutasde0.setVisible(false);
        CatalogodeRutas.setVisible(true);
        Tabladerutasnovalidas.setVisible(true);
        jScrollPane9.setVisible(true);
        Nombrerutasinavlidas.setVisible(true);
        volverarutasdesdeno.setVisible(true);
    }//GEN-LAST:event_BotonvalidarutasirActionPerformed
  // boton que elimina la instancia actual y crea una nueva en caso de que el programa este dando muchos fallos con las tablas 
    private void BotonpararefrecarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonpararefrecarActionPerformed
    // otra forma de refrecar es asi directamente
        this.dispose();
        Reto_equipo3.main(new String[0]);        
        
    }//GEN-LAST:event_BotonpararefrecarActionPerformed
    //Metodos del boton que modifican las tablas para actualizarlas
    private void cargarTablarutasvalidas() {
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
        TablePuntosPeligro.setModel(model);
        TablePuntosPeligro.setAutoCreateRowSorter(true);
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
        TablaValoraciones.setModel(model);
        TablaValoraciones.setAutoCreateRowSorter(true);
        TablaValoraciones.getColumnModel().getColumn(0).setMinWidth(0);
        TablaValoraciones.getColumnModel().getColumn(0).setMaxWidth(0);
        TablaValoraciones.getColumnModel().getColumn(0).setPreferredWidth(0);
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
        TablaActividades.setModel(model);
        TablaActividades.setAutoCreateRowSorter(true);
        TablaActividades.getColumnModel().getColumn(0).setMinWidth(0);
        TablaActividades.getColumnModel().getColumn(0).setMaxWidth(0);
        TablaActividades.getColumnModel().getColumn(0).setPreferredWidth(0);
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
        tamañocolumnasDetalles();
        TablaDetallesruta.setModel(model);
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
        TablaCalendarios.setModel(model);
        TablaCalendarios.setAutoCreateRowSorter(true);
        TablaCalendarios.getColumnModel().getColumn(0).setMinWidth(0);
        TablaCalendarios.getColumnModel().getColumn(0).setMaxWidth(0);
        TablaCalendarios.getColumnModel().getColumn(0).setPreferredWidth(0);

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

        for (MouseListener ml : TablaImagenesPeligro.getMouseListeners()) {
            TablaImagenesPeligro.removeMouseListener(ml);
        }

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

        for (MouseListener ml : TablaImagenesPeligro.getMouseListeners()) {
            TablaImagenesPeligro.removeMouseListener(ml);
        }

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
        TablaimagenesInteres.getColumnModel().getColumn(0).setMinWidth(0);
        TablaimagenesInteres.getColumnModel().getColumn(0).setMaxWidth(0);
        TablaimagenesInteres.getColumnModel().getColumn(0).setPreferredWidth(0);
        TablaimagenesInteres.setAutoCreateRowSorter(true);

    }
// Metodo de imagenes de peligro y interes que muestra en panatalla la imagen seleccionada

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
//Metodo que limpiar todas las tablas(contenido)

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
    private javax.swing.JButton BotonCrearPunto;
    private javax.swing.JButton BotonEntrada;
    private javax.swing.JTextField BotonIntere;
    private javax.swing.JButton BotonParamodificarUsuario;
    private javax.swing.JButton BotonarutasdesdeCatalogo;
    private javax.swing.JTextField Botonbelle;
    private javax.swing.JButton BotoncrearActividad;
    private javax.swing.JTextField Botondificul;
    private javax.swing.JTextField Botonestre;
    private javax.swing.JButton Botonparacrearruta;
    private javax.swing.JButton Botonparacrearrutas;
    private javax.swing.JButton Botonparacrearvaloracion;
    private javax.swing.JButton Botonpararefrecar;
    private javax.swing.JButton Botonpararefrecartablas;
    private javax.swing.JTextField Botonrese;
    private javax.swing.JButton Botonvalidarutasir;
    private javax.swing.JButton BotonvolverPunto;
    private javax.swing.JButton BotonvolverRutass;
    private javax.swing.JTextField CREARDESCRIPCION;
    private javax.swing.JPanel CatalogodeRutas;
    private javax.swing.JPasswordField Contraseña;
    private javax.swing.JButton CrearActividadBoton;
    private javax.swing.JPanel CrearActividades;
    private javax.swing.JPanel CrearCalendario;
    private javax.swing.JPanel CrearImagen;
    private javax.swing.JPanel CrearImagenPeligrop;
    private javax.swing.JButton CrearImagenes;
    private javax.swing.JButton CrearImagenesPeligro;
    private javax.swing.JButton CrearImagenesnuevo;
    private javax.swing.JPanel CrearPuntosRutap;
    private javax.swing.JTextField CrearRecomen;
    private javax.swing.JPanel CrearRutasde0;
    private javax.swing.JTextField CrearURLY;
    private javax.swing.JPanel CrearUsuarios;
    private javax.swing.JTextField Creardetall;
    private javax.swing.JLabel Cuadro1;
    private javax.swing.JLabel Cuadro2;
    private javax.swing.JLabel CuadroEntrada;
    private javax.swing.JLabel Cuadrodecrearrutas;
    private javax.swing.JLabel Cuadroimagenespeligro;
    private javax.swing.JLabel Descripcionp;
    private javax.swing.JPanel DetallesRuta;
    private javax.swing.JLabel Elevacionp;
    private javax.swing.JComboBox<String> EligePunto;
    private javax.swing.JTextField Email;
    private javax.swing.JPanel ImagenesInteres;
    private javax.swing.JPanel ImagenesPeligro;
    private javax.swing.JButton IniciarSesion;
    private javax.swing.JLabel Latitudp;
    private javax.swing.JLabel Longitudp;
    private javax.swing.JLabel Nombre;
    private javax.swing.JTextField NombreActi;
    private javax.swing.JLabel NombreImagenesInteres;
    private javax.swing.JLabel NombreRutas;
    private javax.swing.JLabel Nombrep;
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
    private javax.swing.JTextField ValidaDescripcion;
    private javax.swing.JPanel ValidaRutas;
    private javax.swing.JTextField ValidaURL;
    private javax.swing.JPanel ValoracionesdeRuta;
    private javax.swing.JButton VolverImagenes;
    private javax.swing.JButton VolverImagnesPeligro;
    private javax.swing.JButton VolverInicio;
    private javax.swing.JButton VolverUsuarios;
    private javax.swing.JButton VolveraCalendario;
    private javax.swing.JButton Volveraverlasvaloraciones;
    private javax.swing.JComboBox<String> accesibilidad;
    private javax.swing.JTextField altmaxima;
    private javax.swing.JTextField altminima;
    private javax.swing.JLabel apellido;
    private javax.swing.JTextField añadefech;
    private javax.swing.JButton botoncrearcalendario;
    private javax.swing.JButton botoncrearcalendariode0;
    private javax.swing.JButton botoncrearvaloracion;
    private javax.swing.JComboBox<String> clasi;
    private javax.swing.JLabel contraseña;
    private javax.swing.JButton crearimagenpeligro;
    private javax.swing.JButton darbotonUsuario;
    private javax.swing.JLabel descripcionpl;
    private javax.swing.JTextField desnivelnegativo;
    private javax.swing.JTextField desnivelpositivo;
    private javax.swing.JTextField distancia;
    private javax.swing.JTextField duracion;
    private javax.swing.JComboBox<String> eligerol;
    private javax.swing.JLabel email;
    private javax.swing.JTextField geo;
    private javax.swing.JTextField indicaciones;
    private javax.swing.JTextField introapellido;
    private javax.swing.JPasswordField introcontraseña;
    private javax.swing.JTextField introemail;
    private javax.swing.JTextField intronombre;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
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
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
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
    private javax.swing.JTextField ldf;
    private javax.swing.JTextField ldi;
    private javax.swing.JTextField lf;
    private javax.swing.JTextField li;
    private javax.swing.JTextField nombreDescripcion1;
    private javax.swing.JTextField nombreElevacion1;
    private javax.swing.JTextField nombreLatitud1;
    private javax.swing.JTextField nombreLongitud1;
    private javax.swing.JTextField nombrePP;
    private javax.swing.JTextField nombrefini;
    private javax.swing.JTextField nombreinicio;
    private javax.swing.JTextField nombreruta;
    private javax.swing.JTextField recomen;
    private javax.swing.JLabel rol;
    private javax.swing.JComboBox<String> rutafam;
    private javax.swing.JTextField temp;
    private javax.swing.JTextField tipoterreno;
    private javax.swing.JButton volveraactividad;
    private javax.swing.JButton volverarutasdesdeno;
    private javax.swing.JButton volverdecrearruta;
    private javax.swing.JButton votonimagenvolverpeligro;
    // End of variables declaration//GEN-END:variables
}
