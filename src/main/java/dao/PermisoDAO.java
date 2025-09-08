package dao;

import java.sql.*;
import modelo.Permiso;
import conexion.ConexionBD;

public class PermisoDAO {

    public boolean insertarPermiso(Permiso permiso) {
        String sql = "INSERT INTO permiso(id_autor, id_persona, nombre_persona, documento_identidad, razon, fecha_solicitud, fecha_aplicacion) VALUES (?, ?, ?, ?, ?, ?, ?)";
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

    public boolean actualizarPermiso(Permiso permiso) {
        String sql = "UPDATE permiso SET nombre_persona = ?, documento_identidad = ?, razon = ?, fecha_solicitud = ?, fecha_aplicacion = ? WHERE id = ?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, permiso.getNombrePersona());
            ps.setString(2, permiso.getDocumentoIdentidad());
            ps.setString(3, permiso.getRazon());
            ps.setDate(4, permiso.getFechaSolicitud());
            ps.setDate(5, permiso.getFechaAplicacion());
            ps.setInt(6, permiso.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar permiso: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarPermiso(int id) {
        String sql = "DELETE FROM permiso WHERE id = ?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar permiso: " + e.getMessage());
            return false;
        }
    }
}
