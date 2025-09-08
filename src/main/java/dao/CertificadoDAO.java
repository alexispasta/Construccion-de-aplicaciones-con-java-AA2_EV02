package dao;

import java.sql.*;
import modelo.Certificado;
import conexion.ConexionBD;

public class CertificadoDAO {

    public boolean insertarCertificado(Certificado certificado) {
        String sql = "INSERT INTO certificado(id_persona, nombre_persona, carrera, fecha_inicio, institucion) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, certificado.getIdPersona());
            ps.setString(2, certificado.getNombrePersona());
            ps.setString(3, certificado.getCarrera());
            ps.setDate(4, certificado.getFechaInicio());
            ps.setString(5, certificado.getInstitucion());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar certificado: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarCertificado(Certificado certificado) {
        String sql = "UPDATE certificado SET nombre_persona = ?, carrera = ?, fecha_inicio = ?, institucion = ? WHERE id = ?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, certificado.getNombrePersona());
            ps.setString(2, certificado.getCarrera());
            ps.setDate(3, certificado.getFechaInicio());
            ps.setString(4, certificado.getInstitucion());
            ps.setInt(5, certificado.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar certificado: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarCertificado(int id) {
        String sql = "DELETE FROM certificado WHERE id = ?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar certificado: " + e.getMessage());
            return false;
        }
    }
}
