package servlets;

import java.io.IOException;
import java.sql.Date;

import dao.ReporteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Persona;
import modelo.Reporte;

@WebServlet("/ReporteServlet")
public class ReporteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // Recuperar usuario logueado
            HttpSession session = request.getSession(false);
            if (session == null || session.getAttribute("usuario") == null) {
                response.sendRedirect("login.html");
                return;
            }

            Persona usuario = (Persona) session.getAttribute("usuario");
            int idAutor = usuario.getId(); // 🔹 Ahora el autor es el usuario logueado

            // Obtener datos del formulario
            int idPersona = Integer.parseInt(request.getParameter("id_persona"));
            String nombrePersona = request.getParameter("nombre_persona");
            String razon = request.getParameter("razon");
            Date fechaReporte = Date.valueOf(request.getParameter("fecha_reporte"));
            String comentarios = request.getParameter("comentarios");

            // Crear objeto reporte
            Reporte reporte = new Reporte();
            reporte.setIdAutor(idAutor);
            reporte.setIdPersona(idPersona);
            reporte.setNombrePersona(nombrePersona);
            reporte.setRazon(razon);
            reporte.setFechaReporte(fechaReporte);
            reporte.setComentarios(comentarios);

            // Guardar en BD
            ReporteDAO dao = new ReporteDAO();
            boolean ok = dao.insertarReporte(reporte);

            if (ok) {
                response.getWriter().println("<h1>Operacion completada con exito.</h1>");
            } else {
                response.getWriter().println("<h1>error en la operacion.</h1>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<h1>error en la operacion.</h1>");
        }
    }
}
