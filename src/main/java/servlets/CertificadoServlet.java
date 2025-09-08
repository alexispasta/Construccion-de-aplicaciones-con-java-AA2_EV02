package servlets;

import java.io.IOException;
import java.sql.Date;

import dao.CertificadoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Certificado;

@WebServlet("/CertificadoServlet")
public class CertificadoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // Validar sesión
            HttpSession session = request.getSession(false);
            if (session == null || session.getAttribute("usuario") == null) {
                response.sendRedirect("login.html");
                return;
            }

            // Obtener datos del formulario
            int idPersona = Integer.parseInt(request.getParameter("id_persona"));
            String nombrePersona = request.getParameter("nombre_persona");
            String carrera = request.getParameter("carrera");
            Date fechaInicio = Date.valueOf(request.getParameter("fecha_inicio"));
            String institucion = request.getParameter("institucion");

            // Crear objeto Certificado
            Certificado certificado = new Certificado();
            certificado.setIdPersona(idPersona);
            certificado.setNombrePersona(nombrePersona);
            certificado.setCarrera(carrera);
            certificado.setFechaInicio(fechaInicio);
            certificado.setInstitucion(institucion);

            // Insertar en BD
            CertificadoDAO dao = new CertificadoDAO();
            boolean ok = dao.insertarCertificado(certificado);

            if (ok) {
                response.sendRedirect("certificado_exito.jsp");
            } else {
                response.sendRedirect("certificado_error.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("certificado_error.jsp");
        }
    }
}
