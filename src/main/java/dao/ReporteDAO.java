package dao;

import java.sql.*;
import modelo.Reporte;
import conexion.ConexionBD;

public class ReporteDAO {

    public boolean insertarReporte(Reporte reporte) {
        String sql = "INSERT INTO reporte(id_autor, id_persona, nombre_persona, razon, fecha_reporte, comentarios) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, reporte.getIdAutor());
            ps.setInt(2, reporte.getIdPersona());
            ps.setString(3, reporte.getNombrePersona());
            ps.setString(4, reporte.getRazon());
            ps.setDate(5, reporte.getFechaReporte());
            ps.setString(6, reporte.getComentarios());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar reporte: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarReporte(Reporte reporte) {
        String sql = "UPDATE reporte SET nombre_persona = ?, razon = ?, fecha_reporte = ?, comentarios = ? WHERE id = ?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, reporte.getNombrePersona());
            ps.setString(2, reporte.getRazon());
            ps.setDate(3, reporte.getFechaReporte());
            ps.setString(4, reporte.getComentarios());
            ps.setInt(5, reporte.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar reporte: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarReporte(int id) {
        String sql = "DELETE FROM reporte WHERE id = ?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar reporte: " + e.getMessage());
            return false;
        }
    }
}
