package servlets;

import java.io.IOException;

import dao.DetalleNominaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.DetalleNomina;

public class DetalleNominaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            DetalleNomina detalle = new DetalleNomina();
            detalle.setIdPersona(Integer.parseInt(request.getParameter("id_persona")));
            detalle.setCuentaBancaria(request.getParameter("cuenta_bancaria"));
            detalle.setSalarioBase(parseDoubleSafe(request.getParameter("salario_base")));
            detalle.setAuxilioTransporte(parseDoubleSafe(request.getParameter("auxilio_transporte")));
            detalle.setHorasExtra(parseIntSafe(request.getParameter("horas_extra")));
            detalle.setBonificacion(parseDoubleSafe(request.getParameter("bonificacion")));
            detalle.setComisiones(parseDoubleSafe(request.getParameter("comisiones")));
            detalle.setViaticos(parseDoubleSafe(request.getParameter("viaticos")));
            detalle.setDescuentos(parseDoubleSafe(request.getParameter("descuentos")));
            detalle.setRetencionFuente(parseDoubleSafe(request.getParameter("retencion_fuente")));
            detalle.setPrestamosEmpresa(parseDoubleSafe(request.getParameter("prestamos_empresa")));
            detalle.setEmbargosJudiciales(parseDoubleSafe(request.getParameter("embargos_judiciales")));
            detalle.setIncapacidadesDias(parseIntSafe(request.getParameter("incapacidades_dias")));
            detalle.setVacacionesDias(parseIntSafe(request.getParameter("vacaciones_dias")));
            detalle.setCesantias(parseDoubleSafe(request.getParameter("cesantias")));
            detalle.setInteresesCesantias(parseDoubleSafe(request.getParameter("intereses_cesantias")));
            detalle.setPrimaServicios(parseDoubleSafe(request.getParameter("prima_servicios")));
            detalle.setTotalPagar(parseDoubleSafe(request.getParameter("total_pagar")));

            DetalleNominaDAO dao = new DetalleNominaDAO();
            boolean exito = dao.insertarDetalle(detalle);

            if (exito) {
                response.sendRedirect("detalleNomina.jsp?success=1");
            } else {
                response.sendRedirect("detalleNomina.jsp?error=1");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("detalleNomina.jsp?error=2");
        }
    }

    private double parseDoubleSafe(String param) {
        try {
            return (param != null && !param.isEmpty()) ? Double.parseDouble(param) : 0.0;
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    private int parseIntSafe(String param) {
        try {
            return (param != null && !param.isEmpty()) ? Integer.parseInt(param) : 0;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
