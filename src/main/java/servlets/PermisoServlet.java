package servlets;

import java.io.IOException;
import java.sql.Date;

import dao.PermisoDAO;
import dao.PersonaDAO;
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

            // Datos del formulario
            int idAutor = usuario.getId();
            int idPersona = Integer.parseInt(request.getParameter("id_persona"));
            String razon = request.getParameter("razon");
            Date fechaSolicitud = Date.valueOf(request.getParameter("fecha_solicitud"));
            Date fechaAplicacion = Date.valueOf(request.getParameter("fecha_aplicacion"));

            // Buscar empleado para obtener nombre y documento
            PersonaDAO personaDAO = new PersonaDAO();
            Persona empleado = personaDAO.obtenerPorId(idPersona);

            // Crear objeto permiso
            Permiso permiso = new Permiso();
            permiso.setIdAutor(idAutor);
            permiso.setIdPersona(idPersona);
            permiso.setNombrePersona(empleado.getNombre() + " " + empleado.getApellido());
            permiso.setDocumentoIdentidad(empleado.getDocumentoIdentidad());
            permiso.setRazon(razon);
            permiso.setFechaSolicitud(fechaSolicitud);
            permiso.setFechaAplicacion(fechaAplicacion);

            // Insertar en BD
            PermisoDAO dao = new PermisoDAO();
            boolean exito = dao.insertarPermiso(permiso);

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
}
