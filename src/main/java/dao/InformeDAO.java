package dao;

import java.sql.*;
import modelo.Informe;
import conexion.ConexionBD;

public class InformeDAO {

    public boolean insertarInforme(Informe informe) {
        String sql = "INSERT INTO informe(id_autor, id_empresa, asunto, comentario) VALUES (?, ?, ?, ?)";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, informe.getIdAutor());
            ps.setInt(2, informe.getIdEmpresa());
            ps.setString(3, informe.getAsunto());
            ps.setString(4, informe.getComentario());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar informe: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarInforme(Informe informe) {
        String sql = "UPDATE informe SET asunto = ?, comentario = ? WHERE id = ?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, informe.getAsunto());
            ps.setString(2, informe.getComentario());
            ps.setInt(3, informe.getId());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar informe: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarInforme(int id) {
        String sql = "DELETE FROM informe WHERE id = ?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar informe: " + e.getMessage());
            return false;
        }
    }
}
