package dao;

import java.sql.*;
import modelo.Supervisor;
import conexion.ConexionBD;

public class SupervisorDAO {

    public boolean insertarSupervisor(Supervisor supervisor) {
        String sql = "INSERT INTO supervisor(id_persona, fecha_contratacion) VALUES (?, ?)";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, supervisor.getIdPersona());
            ps.setDate(2, supervisor.getFechaContratacion());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar supervisor: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarSupervisor(Supervisor supervisor) {
        String sql = "UPDATE supervisor SET fecha_contratacion = ? WHERE id_persona = ?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDate(1, supervisor.getFechaContratacion());
            ps.setInt(2, supervisor.getIdPersona());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar supervisor: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarSupervisor(int idPersona) {
        String sql = "DELETE FROM supervisor WHERE id_persona = ?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idPersona);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar supervisor: " + e.getMessage());
            return false;
        }
    }
}
