package org.rer;

import javax.swing.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DatosBD extends JFrame{

    JTextArea datosbd=new JTextArea();
    StringBuilder datosSB = new StringBuilder();

    public void insertarDatos(String ce, Double ci, String mo, String md, Double rc, String fc) throws SQLException {
        Connection conexion =conexionBD.obtenerConexion();
        String query = "INSERT INTO historial_de_conversiones (Correo_Electronico,Cantidad_Ingresada,Moneda_Origen,Moneda_Destino,Resultado_Conversion,Fecha_Conversion) VALUES (?, ?, ? , ?, ?, ?)";
        PreparedStatement Ps = conexion.prepareStatement(query);
        Ps.setString(1,ce);
        Ps.setDouble(2,ci);
        Ps.setString(3,mo);
        Ps.setString(4,md);
        Ps.setDouble(5,rc);
        Ps.setString(6,fc);
        Ps.executeUpdate();
        conexion.close();
    }
    public void mostrarHistorial(String correo) throws SQLException {
        Connection conexion = conexionBD.obtenerConexion();
        Statement st = conexion.createStatement();
        ResultSet resultado = st.executeQuery("SELECT * FROM historial_de_conversiones");

        System.out.println("Correo Electronico: " + correo + "\n");

        String co;
        int b = 0;
        while (resultado.next()) {
            co = resultado.getString("Correo_Electronico");

            if (correo.equals(co)) {

                Double ci = resultado.getDouble("Cantidad_Ingresada");
                String mo = resultado.getString("Moneda_Origen");
                String md = resultado.getString("Moneda_Destino");
                Double rc = resultado.getDouble("Resultado_Conversion");
                String fc = resultado.getString("Fecha_Conversion");
                b = 1;
                System.out.println("Cantidad Ingresada: " + ci + "; Moneda Origen: " + mo + "; Moneda Destino: " + md + ";"
                                   + " Resultado Conversion: " + rc + "; Fecha Conversion: " + fc + "\n\n");

                datosSB.append("Cantidad Ingresada: ").append(resultado.getDouble("Cantidad_Ingresada")).append(" ; ");
                datosSB.append("Moneda Origen: ").append(resultado.getString("Moneda_Origen")).append(" ; ");
                datosSB.append("Moneda Destino: ").append(resultado.getString("Moneda_Destino")).append(" ; ");
                datosSB.append("Resultado Conversion: ").append(resultado.getDouble("Resultado_Conversion")).append(" ; ");
                datosSB.append("Fecha Conversion: ").append(resultado.getString("Fecha_Conversion")).append("\n\n");
                datosbd.setText(datosSB.toString());

            }
        }
        if (b == 0) {
            JOptionPane.showMessageDialog(null,"Nose encontro Conversiones para el correo ingresado");
        }
        else{
            String m = "Contenido de la base de datos: \n\n " + datosbd.getText();
            JOptionPane.showMessageDialog(null, m, "Base de datos", JOptionPane.INFORMATION_MESSAGE);
        }
        conexion.close();
    }
    public static boolean validarCorreo(String correo) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }
}



