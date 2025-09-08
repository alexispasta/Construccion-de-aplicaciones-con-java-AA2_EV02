package dao;

import java.sql.*;
import modelo.RRHH;
import conexion.ConexionBD;

public class RRHHDAO {

    public boolean insertarRRHH(RRHH rrhh) {
        String sql = "INSERT INTO rrhh(id_persona, fecha_contratacion) VALUES (?, ?)";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, rrhh.getIdPersona());
            ps.setDate(2, rrhh.getFechaContratacion());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar RRHH: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarRRHH(RRHH rrhh) {
        String sql = "UPDATE rrhh SET fecha_contratacion = ? WHERE id_persona = ?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDate(1, rrhh.getFechaContratacion());
            ps.setInt(2, rrhh.getIdPersona());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar RRHH: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarRRHH(int idPersona) {
        String sql = "DELETE FROM rrhh WHERE id_persona = ?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idPersona);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar RRHH: " + e.getMessage());
            return false;
        }
    }
}

