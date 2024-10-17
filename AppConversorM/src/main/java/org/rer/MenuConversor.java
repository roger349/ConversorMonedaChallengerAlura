package org.rer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Serial;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class MenuConversor extends JFrame {

    public static Connection conectarBD(){
        Connection conexion;
        //String HOST="bzfvgulv8wnbhgcgfecu-mysql.services.clever-cloud.com";
        String DB="bzfvgulv8wnbhgcgfecu";
        String USER="u93fob5hqfiijvwj";
        String PASS="jIBwWg50rYxXlRYCQ8st";
        String URL= "jdbc:mysql://bzfvgulv8wnbhgcgfecu-mysql.services.clever-cloud.com:3306/bzfvgulv8wnbhgcgfecu?user=u93fob5hqfiijvwj&password=jIBwWg50rYxXlRYCQ8st";

        System.out.println("....conectando");

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion= DriverManager.getConnection(URL,USER,PASS);
            System.out.println("conexion aceptada");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        catch (ClassNotFoundException e) {
            System.out.println("Driver MySQL no encontrado: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return conexion;
    }

    String[] listMonedas={"Elegir Moneda","ARS-Argentina","AED-Emiratos Á.Unidos","AFN-Afghanistan","ALL-Albania",
                          "AMD-Armenia","ANG-Curazao","AOA-Angola","AUD-Australia","AWG-Aruba","AZN-Azerbaiyán",
                          "BAM-BosniayHerzegovina","BBD-Barbados","BDT-Bangladesh","BGN-Bulgaria","BHD-Baréin",
                          "BIF-Burundi","BMD-Bermudas","BND-Sultanato de Brunéi","BOB-Bolivia","BRL-Brazil","BSD-Bahamas",
                          "BTN-Bután","BWP-Botsuana","BYN-Bielorrusia","BZD-Belice","CAD-Canadá","CDF-Congo","CHF-Suiza",
                          "CLP-Chile","CNY-China","COP-Colombia","CRC-Costa Rica","CUP-Cuba","CVE-Rep.Cabo Verde",
                          "CZK-Rep.Checa","DJF-Yibuti","DKK-Dinamarca","DOP-Rep. Dominicana","DZD-Argelia","EGP-Egipto",
                          "ERN-Eritrea","ETB-Etiopía","EUR-Eurozona","FJD-Fiyi","FKP-Isl. Malvinas","FOK-Islas Feroe",
                          "GBP-Reino Unido","GEL-Georgia","GGP-Guernsey","GHS-Ghana","GIP-Gibraltar","GMD-Gambia",
                          "GNF-Guinea","GTQ-Guatemala","GYD-Guyana","HKD-Hong Kong","HNL-Honduras","HRK-Croacia",
                          "HTG-Haití","HUF-Hungría","IDR-Indonesia","ILS-Israel","IMP-Isl. de Man","INR-India",
                          "IQD-Irak","IRR-Irán","ISK-Islandia","JEP-Jersey","JMD-Jamaica","JOD-Jordania","JPY-Japón",
                          "KES-kenia","KGS-Kirguistán","KHR-Camboya","KID-Kiribati","KMF-Isl. Comoras","KRW-Corea del Sur",
                          "KWD-Kuwait","KYD-Isl. Caimán","KZT-Kazajistán","LAK-Laos","LBP-Líbano","LKR-Sri Lanka",
                          "LRD-Rep. de Liberia","LSL-Lesoto","LYD-Libia","MAD-Marruecos","MDL-Moldavia","MGA-Madagascar",
                          "MKD-Macedonia del Norte","MMK-Birmania","MNT-Mongolia","MOP-Macao","MRU-Mauritania",
                          "MUR-Mauricio","MVR-Maldivas","MWK-Malaui","MXN-México","MYR-Malasia","MZN-Mozambique",
                          "NAD-Namibia","NGN-Nigeria","NIO-Nicaragua","NOK-Noruega","NPR-Nepal","NZD-Nueva Zelanda",
                          "OMR-Omán","PAB-Panamá","PEN-Perú","PGK-Papúa Nueva Guinea","PHP-Filipinas","PKR-Pakistán",
                          "PLN-Polonia","PYG-Paraguay","QAR-Qatar","RON-Rumanía","RSD-Serbia","RUB-Rusia","RWF-Ruanda",
                          "SAR-Arabia Saudí","SBD-Isl. Salomón","SCR-Seychelles","SDG-Sudán","SEK-Suecia","SGD-Singapur",
                          "SHP-Isl. de Sta. Elena","SLE-Sierra Leona","SLL-Sierra Leona","SOS-Somalia","SRD-Surinam",
                          "SSP-Sudán del Sur","STN-Sto. Tomé y Príncipe","SYP-Siria","SZL-Suazilandia","THB-Tailandia",
                          "TJS-Tayikistán","TMT-Turkmenistán","TND-Túnez","TOP-Tonga","TRY-Turquia","TTD-Trinidad y Tobago",
                          "TVD-Tuvalu","TWD-Taiwan","TZS-Tanzania","UAH-Ucrania","UGX-Uganda","USD-EE.UU.","UYU-Uruguay",
                          "UZS-Uzbekistán","VES-Venezuela","VND-Vietnam","VUV-Vanuatu","WST-Samoa","XAF-África Central",
                          "XCD-Caribe Oriental","XDR-Fmi","XOF-África Occidental","XPF-Francia-Pacífico","YER-Yemen",
                          "ZAR-Sudáfrica","ZMW-Zambia","ZWL-Zimbabue"};

    String[] listMonedas1={"Elegir Moneda","ARS-Peso argentino","BOB-Boliviano boliviano","BRL-Real brasileño"
                          ,"CLP-Peso chileno","COP-Peso colombiano","USD-Dólar E.E.U.U."};

    JLabel cantidad = new JLabel();
    JLabel codBaseDe = new JLabel();
    JLabel codBaseA = new JLabel();
    JLabel resultadoLabel = new JLabel();
    JTextField CantidadIngresada=new JTextField();
    JTextField Resultado=new JTextField();
    JComboBox<String> codigoBaseDe = new JComboBox<>(listMonedas1);
    JComboBox<String> codigoBaseA = new JComboBox<>(listMonedas1);
    JButton Convertir = new JButton();
    JButton Salir = new JButton();
    double tasaConversion;
    servicioConversion serv=new servicioConversion();
    String monedaDA="";

    @Serial
    private static final long serialVersionUID = 0;

    public static void main(String[] args) {
        Connection BD=conectarBD();
        MenuConversor  menuConversor=new MenuConversor();
    }
    //Constructor

    public MenuConversor() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Menu Conversor");
        this.setBounds(500, 240, 390, 320);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.componentesMenu();
        this.setLayout(null);
        this.setVisible(true);
    }

    public void componentesMenu() {

        cantidad.setBounds(10, 10, 300,20);
        cantidad.setFont(new Font("Century-Gothic",1,12));
        cantidad.setText("Ingrese la Cantidad a Convertir");
        this.getContentPane().add(cantidad);

        CantidadIngresada.setBounds(10, 40, 330,27);
        CantidadIngresada.setColumns(10);
        this.getContentPane().add(CantidadIngresada);
        CantidadIngresada.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (!Character.isLetter(caracter)) {
                    double num = Double.parseDouble(CantidadIngresada.getText());
                    if (num <= 0.00) {
                            JOptionPane.showMessageDialog(null, "Ingrese un número mayor que cero.");
                    }
                }
                else {
                        JOptionPane.showMessageDialog(null, "Ingrese solo numeros");
                    }
            }
        });
        codBaseDe.setBounds(10, 80, 305,20);
        codBaseDe.setFont(new Font("Century-Gothic", Font.BOLD,12));
        codBaseDe.setText("Moneda Origen:");
        this.getContentPane().add(codBaseDe);

        codBaseA.setBounds(180, 80, 305,20);
        codBaseA.setFont(new Font("Century-Gothic", Font.BOLD,12));
        codBaseA.setText("Moneda Destino:");
        this.getContentPane().add(codBaseA);

        ActionListener accionOrigen = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codBDE= Objects.requireNonNull(codigoBaseDe.getSelectedItem()).toString();
                String codigoBaseOrigen=codBDE.substring(0,3);
                System.out.println(codigoBaseOrigen);
                serv.convertirMoneda(codigoBaseOrigen);

            }
        };
        codigoBaseDe.addActionListener(accionOrigen);
        codigoBaseDe.setBounds(10, 110, 145, 21);
        this.getContentPane().add(codigoBaseDe);

        ActionListener accionDestino = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codBA = Objects.requireNonNull(codigoBaseA.getSelectedItem()).toString();
                String codigoBaseDestino = codBA.substring(0, 3);
                tasaConversion = serv.obtenerTasaConversion(codigoBaseDestino);
                System.out.println(codigoBaseDestino);
            }
        };
        codigoBaseA.addActionListener(accionDestino);
        codigoBaseA.setBounds(180, 110, 145, 21);
        this.getContentPane().add(codigoBaseA);

        resultadoLabel.setBounds(10,147, 300,20);
        resultadoLabel.setFont(new Font("Century-Gothic", Font.BOLD,12));
        resultadoLabel.setText("Resultado Conversion:");
        this.getContentPane().add(resultadoLabel);

        Resultado.setBounds(10, 175, 330, 27);
        this.getContentPane().add(Resultado);

        ActionListener convertir= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double CantIngresada = Double.parseDouble(CantidadIngresada.getText());
                String codBA = Objects.requireNonNull(codigoBaseA.getSelectedItem()).toString();
                String codigoBaseDestino = codBA.substring(0, 3);
                if (monedaDA.equals(codigoBaseDestino)) {
                        tasaConversion = serv.obtenerTasaConversion(monedaDA);
                        double ResultadoConversion = CantIngresada * tasaConversion;
                        Resultado.setText(String.valueOf(ResultadoConversion));
                } else {

                        double ResultadoConversion = CantIngresada * tasaConversion;
                        Resultado.setText(String.valueOf(ResultadoConversion));
                        String monedaDestinoA=(String) codigoBaseA.getSelectedItem();
                        monedaDA =monedaDestinoA.substring(0, 3);
                        System.out.println(monedaDA);
                }

            }
        } ;
        Convertir.addActionListener(convertir);
        Convertir.setText("Convertir");
        Convertir.setBounds(47, 220, 104, 23);
        this.getContentPane().add(Convertir);

        ActionListener salir=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(WIDTH);
            }
        };
        Salir.addActionListener(salir);
        Salir.setText("Salir");
        Salir.setBounds(187, 220, 104, 23);
        this.getContentPane().add(Salir);
    }

}
