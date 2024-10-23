package org.rer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
