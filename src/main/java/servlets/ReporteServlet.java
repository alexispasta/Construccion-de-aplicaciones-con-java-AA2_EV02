package servlets;

import java.io.IOException;
import java.sql.Date;

import dao.ReporteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Reporte;

public class ReporteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int idAutor = Integer.parseInt(request.getParameter("id_autor"));
            int idPersona = Integer.parseInt(request.getParameter("id_persona"));
            String nombrePersona = request.getParameter("nombre_persona");
            String razon = request.getParameter("razon");
            Date fechaReporte = Date.valueOf(request.getParameter("fecha_reporte"));
            String comentarios = request.getParameter("comentarios");

            Reporte reporte = new Reporte();
            reporte.setIdAutor(idAutor);
            reporte.setIdPersona(idPersona);
            reporte.setNombrePersona(nombrePersona);
            reporte.setRazon(razon);
            reporte.setFechaReporte(fechaReporte);
            reporte.setComentarios(comentarios);

            ReporteDAO dao = new ReporteDAO();
            boolean ok = dao.insertarReporte(reporte);

            if (ok) {
                response.sendRedirect("reporte_exito.jsp");
            } else {
                response.sendRedirect("reporte_error.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("reporte_error.jsp");
        }
    }
}
