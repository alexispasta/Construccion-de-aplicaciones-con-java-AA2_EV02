package servlets;

import java.io.IOException;

import dao.DetalleNominaDAO;
import dao.PersonaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.DetalleNomina;
import modelo.Persona;

@WebServlet("/DetalleNominaServlet")
public class DetalleNominaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            HttpSession session = request.getSession(false);
            if (session == null || session.getAttribute("usuario") == null) {
                response.sendRedirect("login.html");
                return;
            }

            Persona usuario = (Persona) session.getAttribute("usuario");
            int idEmpresa = usuario.getIdEmpresa();

            int idPersona = Integer.parseInt(request.getParameter("id_persona"));

            // ✅ Verificar que el empleado pertenece a la empresa del usuario
            PersonaDAO personaDAO = new PersonaDAO();
            Persona empleado = personaDAO.obtenerPorId(idPersona);

            if (empleado == null || empleado.getIdEmpresa() != idEmpresa) {
                response.sendRedirect("detalleNomina.jsp?error=empresa");
                return;
            }

            // ✅ Crear detalle con parámetros
            DetalleNomina detalle = new DetalleNomina();
            detalle.setIdPersona(idPersona);
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

            // ✅ Guardar en BD
            DetalleNominaDAO dao = new DetalleNominaDAO();
            boolean exito = dao.insertarDetalle(detalle);

            if (exito) {
                response.getWriter().println("<h1>Operacion completada con exito.</h1>");
            } else {
                response.getWriter().println("<h1>error en la operacion.</h1>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<h1>error en la operacion.</h1>");
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
