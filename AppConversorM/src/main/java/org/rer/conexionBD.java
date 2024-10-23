package org.rer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionBD {
    private static final String url = "jdbc:mysql://localhost:3306/bdh";
    private static final String user = "roger1";
    private static final String pass= "rer27390656";

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(url,user, pass);
    }
}
