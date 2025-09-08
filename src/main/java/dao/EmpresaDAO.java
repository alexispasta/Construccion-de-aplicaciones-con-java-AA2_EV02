package dao;

import conexion.ConexionBD;
import java.sql.*;
import modelo.Empresa;

public class EmpresaDAO {
    //crear empresa
    public boolean insertarEmpresa(Empresa empresa) {
        String sql = "INSERT INTO empresa(nombre, telefono, direccion, ciudad, pais) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, empresa.getNombre());
            ps.setString(2, empresa.getTelefono());
            ps.setString(3, empresa.getDireccion());
            ps.setString(4, empresa.getCiudad());
            ps.setString(5, empresa.getPais());

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar empresa: " + e.getMessage());
            return false;
        }
    }
    //actualizar empresa
    public boolean actualizarEmpresa(Empresa empresa) {
    String sql = "UPDATE empresa SET nombre = ?, telefono = ?, direccion = ?, ciudad = ?, pais = ? WHERE id = ?";
    try (Connection con = ConexionBD.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, empresa.getNombre());
        ps.setString(2, empresa.getTelefono());
        ps.setString(3, empresa.getDireccion());
        ps.setString(4, empresa.getCiudad());
        ps.setString(5, empresa.getPais());
        ps.setInt(6, empresa.getId());

        int filas = ps.executeUpdate();
        return filas > 0;

    } catch (SQLException e) {
        System.out.println("Error al actualizar empresa: " + e.getMessage());
        return false;
    }
}
    //eliminar empresa
    public boolean eliminarEmpresa(int id) {
    String sql = "DELETE FROM empresa WHERE id = ?";
    try (Connection con = ConexionBD.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, id);
        int filas = ps.executeUpdate();
        return filas > 0;

    } catch (SQLException e) {
        System.out.println("Error al eliminar empresa: " + e.getMessage());
        return false;
    }
}
}
