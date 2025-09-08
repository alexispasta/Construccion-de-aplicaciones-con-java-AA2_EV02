package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import conexion.ConexionBD;
import modelo.Asistencia;

public class AsistenciaDAO {

    public boolean insertarAsistencia(Asistencia asistencia) {
        String sql = "INSERT INTO asistencia (id_persona, fecha, estado) " +
                     "VALUES (?, ?, ?) " +
                     "ON DUPLICATE KEY UPDATE estado = VALUES(estado)";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, asistencia.getIdPersona());
            if (asistencia.getFecha() != null) {
                ps.setDate(2, asistencia.getFecha());
            } else {
                ps.setNull(2, Types.DATE);
            }
            ps.setString(3, asistencia.getEstado());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar asistencia: " + e.getMessage());
            return false;
        }
    }
}
