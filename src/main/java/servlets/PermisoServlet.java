package servlets;

import java.io.IOException;
import java.sql.Date;

import dao.PermisoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Permiso;
import modelo.Persona;

@WebServlet("/permiso")
public class PermisoServlet extends HttpServlet {
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

            // El autor es siempre el usuario logueado
            int idAutor = usuario.getId();
            int idPersona = Integer.parseInt(request.getParameter("id_persona"));
            String razon = request.getParameter("razon");
            Date fechaSolicitud = Date.valueOf(request.getParameter("fecha_solicitud"));
            Date fechaAplicacion = Date.valueOf(request.getParameter("fecha_aplicacion"));

            Permiso permiso = new Permiso();
            permiso.setIdAutor(idAutor);
            permiso.setIdPersona(idPersona);
            permiso.setRazon(razon);
            permiso.setFechaSolicitud(fechaSolicitud);
            permiso.setFechaAplicacion(fechaAplicacion);

            PermisoDAO dao = new PermisoDAO();
            boolean exito = dao.insertarPermiso(permiso);

            if (exito) {
                response.sendRedirect("permiso_exito.jsp");
            } else {
                response.sendRedirect("permiso_error.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("permiso_error.jsp");
        }
    }
}
