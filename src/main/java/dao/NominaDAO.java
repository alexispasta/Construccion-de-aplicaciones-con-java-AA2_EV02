package dao;

import java.sql.*;
import modelo.Nomina;
import conexion.ConexionBD;

public class NominaDAO {

    public boolean insertarNomina(Nomina nomina) {
        String sql = "INSERT INTO nomina(id_persona, fecha_pago, cantidad) VALUES (?, ?, ?)";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, nomina.getIdPersona());
            ps.setDate(2, nomina.getFechaPago());
            ps.setDouble(3, nomina.getCantidad());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar nómina: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarNomina(Nomina nomina) {
        String sql = "UPDATE nomina SET fecha_pago = ?, cantidad = ? WHERE id = ?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDate(1, nomina.getFechaPago());
            ps.setDouble(2, nomina.getCantidad());
            ps.setInt(3, nomina.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar nómina: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarNomina(int id) {
        String sql = "DELETE FROM nomina WHERE id = ?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar nómina: " + e.getMessage());
            return false;
        }
    }
}
