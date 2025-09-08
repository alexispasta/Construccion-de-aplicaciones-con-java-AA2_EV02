package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.ConexionBD;
import modelo.Persona;

public class PersonaDAO {

    // INSERTAR PERSONA
    public boolean insertarPersona(Persona p) {
        String sql = "INSERT INTO persona(nombre, apellido, correo, telefono, direccion, documento_identidad, fecha_nacimiento, fecha_contratacion, tipo_contrato, rol, activo, contrasena, id_empresa) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellido());
            ps.setString(3, p.getCorreo());
            ps.setString(4, p.getTelefono());
            ps.setString(5, p.getDireccion());
            ps.setString(6, p.getDocumentoIdentidad());
            ps.setDate(7, p.getFechaNacimiento());
            ps.setDate(8, p.getFechaContratacion());
            ps.setString(9, p.getTipoContrato());
            ps.setString(10, p.getRol());
            ps.setBoolean(11, p.isActivo());
            ps.setString(12, p.getContrasena());
            ps.setInt(13, p.getIdEmpresa());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar persona: " + e.getMessage());
            return false;
        }
    }

    // ACTUALIZAR PERSONA
    public boolean actualizarPersona(Persona p) {
        String sql = "UPDATE persona SET nombre=?, apellido=?, correo=?, telefono=?, direccion=?, documento_identidad=?, fecha_nacimiento=?, fecha_contratacion=?, tipo_contrato=?, rol=?, activo=?, contrasena=?, id_empresa=? WHERE id=?";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellido());
            ps.setString(3, p.getCorreo());
            ps.setString(4, p.getTelefono());
            ps.setString(5, p.getDireccion());
            ps.setString(6, p.getDocumentoIdentidad());
            ps.setDate(7, p.getFechaNacimiento());
            ps.setDate(8, p.getFechaContratacion());
            ps.setString(9, p.getTipoContrato());
            ps.setString(10, p.getRol());
            ps.setBoolean(11, p.isActivo());
            ps.setString(12, p.getContrasena());
            ps.setInt(13, p.getIdEmpresa());
            ps.setInt(14, p.getId());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar persona: " + e.getMessage());
            return false;
        }
    }

    // ELIMINAR PERSONA
    public boolean eliminarPersona(int id) {
        String sql = "DELETE FROM persona WHERE id = ?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar persona: " + e.getMessage());
            return false;
        }
    }

    // VALIDAR LOGIN (correo y contraseña)
    public Persona validarLogin(String correo, String contrasena) {
        String sql = "SELECT * FROM persona WHERE correo = ? AND contrasena = ? AND activo = true";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, correo);
            ps.setString(2, contrasena);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Persona persona = new Persona();
                persona.setId(rs.getInt("id"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido(rs.getString("apellido"));
                persona.setCorreo(rs.getString("correo"));
                persona.setRol(rs.getString("rol"));
                persona.setActivo(rs.getBoolean("activo"));
                persona.setIdEmpresa(rs.getInt("id_empresa"));
                return persona;
            }
        } catch (SQLException e) {
            System.out.println("Error al validar login: " + e.getMessage());
        }
        return null;
    }

    // OBTENER TODOS LOS EMPLEADOS/PERSONAS ACTIVAS
    public List<Persona> obtenerTodos() {
    List<Persona> lista = new ArrayList<>();
    String sql = "SELECT * FROM persona"; // 👈 ya no filtra por activo

    try (Connection con = ConexionBD.getConnection();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            Persona persona = new Persona();
            persona.setId(rs.getInt("id"));
            persona.setNombre(rs.getString("nombre"));
            persona.setApellido(rs.getString("apellido"));
            persona.setCorreo(rs.getString("correo"));
            persona.setRol(rs.getString("rol"));
            persona.setActivo(rs.getBoolean("activo"));
            persona.setIdEmpresa(rs.getInt("id_empresa"));
            lista.add(persona);
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener empleados: " + e.getMessage());
    }
    return lista;
}
// OBTENER EMPLEADOS DE UNA EMPRESA ESPECÍFICA
public List<Persona> obtenerPorEmpresa(int idEmpresa) {
    List<Persona> lista = new ArrayList<>();
    String sql = "SELECT * FROM persona WHERE id_empresa = ? AND activo = true";

    try (Connection con = ConexionBD.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, idEmpresa);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Persona persona = new Persona();
            persona.setId(rs.getInt("id"));
            persona.setNombre(rs.getString("nombre"));
            persona.setApellido(rs.getString("apellido"));
            persona.setCorreo(rs.getString("correo"));
            persona.setRol(rs.getString("rol"));
            persona.setActivo(rs.getBoolean("activo"));
            persona.setIdEmpresa(rs.getInt("id_empresa"));
            lista.add(persona);
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener empleados por empresa: " + e.getMessage());
    }
    return lista;
}
// Dentro de PersonaDAO
public Persona obtenerPorId(int id) {
    String sql = "SELECT * FROM persona WHERE id = ?";
    try (Connection con = ConexionBD.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Persona persona = new Persona();
            persona.setId(rs.getInt("id"));
            persona.setNombre(rs.getString("nombre"));
            persona.setApellido(rs.getString("apellido"));
            persona.setCorreo(rs.getString("correo"));
            persona.setRol(rs.getString("rol"));
            persona.setActivo(rs.getBoolean("activo"));
            persona.setIdEmpresa(rs.getInt("id_empresa"));
            return persona;
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener persona por ID: " + e.getMessage());
    }
    return null;
}



}
