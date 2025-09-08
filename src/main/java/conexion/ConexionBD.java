package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
    public static Connection getConnection() {
    try {
        System.out.println("Cargando Driver JDBC...");
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver cargado, conectando a BD...");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/sgrh", "root", "");
    } catch (Exception e) {
        e.printStackTrace(); // MUY IMPORTANTE PARA VER EL ERROR EN catalina.out
        throw new RuntimeException("Error al conectar con la base de datos", e);
    }
}
}
