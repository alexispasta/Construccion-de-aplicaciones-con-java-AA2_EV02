package dao;

import java.sql.*;
import modelo.Gerente;
import conexion.ConexionBD;

public class GerenteDAO {

    public boolean insertarGerente(Gerente gerente) {
        String sql = "INSERT INTO gerente(id_persona, fecha_contratacion) VALUES (?, ?)";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, gerente.getIdPersona());
            ps.setDate(2, gerente.getFechaContratacion());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar gerente: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarGerente(Gerente gerente) {
        String sql = "UPDATE gerente SET fecha_contratacion = ? WHERE id_persona = ?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDate(1, gerente.getFechaContratacion());
            ps.setInt(2, gerente.getIdPersona());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar gerente: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarGerente(int idPersona) {
        String sql = "DELETE FROM gerente WHERE id_persona = ?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idPersona);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar gerente: " + e.getMessage());
            return false;
        }
    }
}
