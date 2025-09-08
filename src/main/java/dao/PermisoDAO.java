package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexion.ConexionBD;
import modelo.Permiso;

public class PermisoDAO {

    public boolean insertarPermiso(Permiso permiso) {
        String sql = "INSERT INTO permiso(id_autor, id_persona, nombre_persona, documento_identidad, razon, fecha_solicitud, fecha_aplicacion) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, permiso.getIdAutor());
            ps.setInt(2, permiso.getIdPersona());
            ps.setString(3, permiso.getNombrePersona());
            ps.setString(4, permiso.getDocumentoIdentidad());
            ps.setString(5, permiso.getRazon());
            ps.setDate(6, permiso.getFechaSolicitud());
            ps.setDate(7, permiso.getFechaAplicacion());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar permiso: " + e.getMessage());
            return false;
        }
    }
}
