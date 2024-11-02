package org.rer;

import java.sql.*;

public class DAO {

    public void insertarDatos(String ce, Double ci, String mo, String md, Double rc, String fc) throws SQLException {
        Connection conexion =conexionBD.obtenerConexion();
        String query = "INSERT INTO Historial_de_Conversiones (Correo_Electronico,Cantidad_Ingresada,Moneda_Origen,Moneda_Destino,Resultado_Conversion,Fecha_Conversion) VALUES (?, ?, ? , ?, ?, ?)";
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
                System.out.println("Cantidad Ingresada: " + ci + "; Moneda Origen: " + mo + "; Moneda Destino: " + md +
                                   ";" + " Resultado Conversion: " + rc + "; Fecha Conversion: " + fc + "\n");
            }
        }
        if (b == 0) {
            System.out.println("Nose encontro Conversiones para el correo ingresado");
        }
        conexion.close();
    }
}
