package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexion.ConexionBD;
import modelo.Empresa;

public class EmpresaDAO {
    // Crear empresa y devolver el ID generado
    public int insertarEmpresa(Empresa empresa) {
        String sql = "INSERT INTO empresa(nombre, telefono, direccion, ciudad, pais) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, empresa.getNombre());
            ps.setString(2, empresa.getTelefono());
            ps.setString(3, empresa.getDireccion());
            ps.setString(4, empresa.getCiudad());
            ps.setString(5, empresa.getPais());

            int filas = ps.executeUpdate();
            if (filas > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        return rs.getInt(1); // Devuelve el ID generado
                    }
                }
            }
            return -1;

        } catch (SQLException e) {
            System.out.println("Error al insertar empresa: " + e.getMessage());
            return -1;
        }
    }

    // Actualizar empresa
    public boolean actualizarEmpresa(Empresa empresa) {
        String sql = "UPDATE empresa SET nombre=?, telefono=?, direccion=?, ciudad=?, pais=? WHERE id=?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, empresa.getNombre());
            ps.setString(2, empresa.getTelefono());
            ps.setString(3, empresa.getDireccion());
            ps.setString(4, empresa.getCiudad());
            ps.setString(5, empresa.getPais());
            ps.setInt(6, empresa.getId());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar empresa: " + e.getMessage());
            return false;
        }
    }

    // Eliminar empresa
    public boolean eliminarEmpresa(int id) {
        String sql = "DELETE FROM empresa WHERE id=?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar empresa: " + e.getMessage());
            return false;
        }
    }
}
