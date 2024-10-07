package org.rer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;
import java.util.Objects;

public class MenuConversor extends JFrame {

    String[] listMonedas={"Elegir Moneda","ARS","AED", "AFN", "ALL", "AMD", "ANG", "AOA", "AUD", "AWG",
                          "AZN", "BAM", "BBD", "BDT", "BGN", "BHD", "BIF", "BMD", "BND", "BOB", "BRL",
                          "BSD", "BTN", "BWP", "BYN", "BZD", "CAD", "CDF", "CHF", "CLP", "CNY", "COP",
                          "CRC", "CUP", "CVE", "CZK", "DJF", "DKK", "DOP", "DZD", "EGP", "ERN", "ETB",
                          "EUR", "FJD", "FKP", "FOK", "GBP", "GEL", "GGP", "GHS", "GIP", "GMD", "GNF",
                          "GTQ", "GYD", "HKD", "HNL", "HRK", "HTG", "HUF", "IDR", "ILS", "IMP", "INR",
                          "IQD", "IRR", "ISK", "JEP", "JMD", "JOD", "JPY", "KES", "KGS", "KHR", "KID",
                          "KMF", "KRW", "KWD", "KYD", "KZT", "LAK", "LBP", "LKR", "LRD", "LSL", "LYD",
                          "MAD", "MDL", "MGA", "MKD", "MMK", "MNT", "MOP", "MRU", "MUR", "MVR", "MWK",
                          "MXN", "MYR", "MZN", "NAD", "NGN", "NIO", "NOK", "NPR", "NZD", "OMR", "PAB",
                          "PEN", "PGK", "PHP", "PKR", "PLN", "PYG", "QAR", "RON", "RSD", "RUB", "RWF",
                          "SAR", "SBD", "SCR", "SDG", "SEK", "SGD", "SHP", "SLE", "SLL", "SOS", "SRD",
                          "SSP", "STN", "SYP", "SZL", "THB", "TJS", "TMT", "TND", "TOP", "TRY", "TTD",
                          "TVD", "TWD", "TZS", "UAH", "UGX", "USD", "UYU", "UZS", "VES", "VND", "VUV",
                          "WST", "XAF", "XCD", "XDR", "XOF", "XPF", "YER", "ZAR", "ZMW", "ZWL"};

    JLabel cantidad = new JLabel();
    JLabel codBaseDe = new JLabel();
    JLabel codBaseA = new JLabel();
    JLabel resultadoLabel = new JLabel();
    JTextField CantidadIngresada=new JTextField();
    JTextField Resultado=new JTextField();
    JComboBox<String> codigoBaseDe = new JComboBox<>(listMonedas);
    JComboBox<String> codigoBaseA = new JComboBox<>(listMonedas);
    JButton Convertir = new JButton();
    JButton Salir = new JButton();
    double tasaConversion;
    servicioConversion serv=new servicioConversion();
    @Serial
    private static final long serialVersionUID = 0;

    public static void main(String[] args) {
        MenuConversor  menuConversor=new MenuConversor();
    }
    //Constructor

    public MenuConversor() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Menu Conversor");
        this.setBounds(500, 240, 400, 350);
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

        codBaseDe.setBounds(10, 80, 300,20);
        codBaseDe.setFont(new Font("Century-Gothic", Font.BOLD,12));
        codBaseDe.setText("De:");
        this.getContentPane().add(codBaseDe);

        codBaseA.setBounds(180, 80, 300,20);
        codBaseA.setFont(new Font("Century-Gothic", Font.BOLD,12));
        codBaseA.setText("a:");
        this.getContentPane().add(codBaseA);

        ActionListener accionD = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codBaseDe = Objects.requireNonNull(codigoBaseDe.getSelectedItem()).toString();
                System.out.println(codBaseDe);
            }
        };
        codigoBaseDe.addActionListener(accionD);
        codigoBaseDe.setBounds(25, 110, 145, 21);
        this.getContentPane().add(codigoBaseDe);

        ActionListener accionA = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codBaseDe = Objects.requireNonNull(codigoBaseDe.getSelectedItem()).toString();
                String codBaseA = Objects.requireNonNull(codigoBaseA.getSelectedItem()).toString();
                System.out.println(codBaseA);
                tasaConversion = serv.convertirMoneda(codBaseDe,codBaseA);
            }
        };
        codigoBaseA.addActionListener(accionA);
        codigoBaseA.setBounds(190, 110, 145, 21);
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
                double ResultadoConversion=CantIngresada*tasaConversion;
                Resultado.setText(String.valueOf(ResultadoConversion));
            }
        };
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
