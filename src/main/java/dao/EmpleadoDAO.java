package dao;

import java.sql.*;
import modelo.Empleado;
import conexion.ConexionBD;

public class EmpleadoDAO {

    public boolean insertarEmpleado(Empleado empleado) {
        String sql = "INSERT INTO empleado(id_persona, fecha_contratacion, cargo) VALUES (?, ?, ?)";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, empleado.getIdPersona());
            ps.setDate(2, empleado.getFechaContratacion());
            ps.setString(3, empleado.getCargo());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar empleado: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarEmpleado(Empleado empleado) {
        String sql = "UPDATE empleado SET fecha_contratacion = ?, cargo = ? WHERE id_persona = ?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDate(1, empleado.getFechaContratacion());
            ps.setString(2, empleado.getCargo());
            ps.setInt(3, empleado.getIdPersona());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar empleado: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarEmpleado(int idPersona) {
        String sql = "DELETE FROM empleado WHERE id_persona = ?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idPersona);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar empleado: " + e.getMessage());
            return false;
        }
    }
}

