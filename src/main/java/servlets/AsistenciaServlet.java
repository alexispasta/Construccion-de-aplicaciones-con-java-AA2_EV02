package servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import dao.AsistenciaDAO;
import dao.PersonaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Asistencia;
import modelo.Persona;

@WebServlet("/AsistenciaServlet")
public class AsistenciaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String fechaStr = request.getParameter("fecha");
            if (fechaStr == null || fechaStr.isEmpty()) {
                response.sendRedirect("asistencia_error.jsp");
                return;
            }

            Date fecha = Date.valueOf(fechaStr);

            PersonaDAO personaDAO = new PersonaDAO();
            List<Persona> empleados = personaDAO.obtenerTodos();

            AsistenciaDAO asistenciaDAO = new AsistenciaDAO();

            for (Persona emp : empleados) {
                String estado = request.getParameter("estado_" + emp.getId());

                if (estado != null && !estado.trim().isEmpty()) {
                    Asistencia asistencia = new Asistencia();
                    asistencia.setIdPersona(emp.getId());
                    asistencia.setFecha(fecha);
                    asistencia.setEstado(estado);

                    asistenciaDAO.insertarAsistencia(asistencia);
                }
            }

            response.sendRedirect("asistencia_exito.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("asistencia_error.jsp");
        }
    }
}
