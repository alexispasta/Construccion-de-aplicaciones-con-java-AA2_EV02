package dao;

import java.sql.*;
import modelo.DetalleNomina;
import conexion.ConexionBD;

public class DetalleNominaDAO {

    public boolean insertarDetalle(DetalleNomina d) {
        String sql = "INSERT INTO detalle_nomina(id_persona, cuenta_bancaria, salario_base, auxilio_transporte, horas_extra, bonificacion, comisiones, viaticos, descuentos, retencion_fuente, prestamos_empresa, embargos_judiciales, incapacidades_dias, vacaciones_dias, cesantias, intereses_cesantias, prima_servicios, total_pagar) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, d.getIdPersona());
            ps.setString(2, d.getCuentaBancaria());
            ps.setDouble(3, d.getSalarioBase());
            ps.setDouble(4, d.getAuxilioTransporte());
            ps.setInt(5, d.getHorasExtra());
            ps.setDouble(6, d.getBonificacion());
            ps.setDouble(7, d.getComisiones());
            ps.setDouble(8, d.getViaticos());
            ps.setDouble(9, d.getDescuentos());
            ps.setDouble(10, d.getRetencionFuente());
            ps.setDouble(11, d.getPrestamosEmpresa());
            ps.setDouble(12, d.getEmbargosJudiciales());
            ps.setInt(13, d.getIncapacidadesDias());
            ps.setInt(14, d.getVacacionesDias());
            ps.setDouble(15, d.getCesantias());
            ps.setDouble(16, d.getInteresesCesantias());
            ps.setDouble(17, d.getPrimaServicios());
            ps.setDouble(18, d.getTotalPagar());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar detalle de nómina: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarDetalle(DetalleNomina d) {
        String sql = "UPDATE detalle_nomina SET cuenta_bancaria = ?, salario_base = ?, auxilio_transporte = ?, horas_extra = ?, bonificacion = ?, comisiones = ?, viaticos = ?, descuentos = ?, retencion_fuente = ?, prestamos_empresa = ?, embargos_judiciales = ?, incapacidades_dias = ?, vacaciones_dias = ?, cesantias = ?, intereses_cesantias = ?, prima_servicios = ?, total_pagar = ? WHERE id = ?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, d.getCuentaBancaria());
            ps.setDouble(2, d.getSalarioBase());
            ps.setDouble(3, d.getAuxilioTransporte());
            ps.setInt(4, d.getHorasExtra());
            ps.setDouble(5, d.getBonificacion());
            ps.setDouble(6, d.getComisiones());
            ps.setDouble(7, d.getViaticos());
            ps.setDouble(8, d.getDescuentos());
            ps.setDouble(9, d.getRetencionFuente());
            ps.setDouble(10, d.getPrestamosEmpresa());
            ps.setDouble(11, d.getEmbargosJudiciales());
            ps.setInt(12, d.getIncapacidadesDias());
            ps.setInt(13, d.getVacacionesDias());
            ps.setDouble(14, d.getCesantias());
            ps.setDouble(15, d.getInteresesCesantias());
            ps.setDouble(16, d.getPrimaServicios());
            ps.setDouble(17, d.getTotalPagar());
            ps.setInt(18, d.getId());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar detalle de nómina: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarDetalle(int id) {
        String sql = "DELETE FROM detalle_nomina WHERE id = ?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar detalle de nómina: " + e.getMessage());
            return false;
        }
    }
}
