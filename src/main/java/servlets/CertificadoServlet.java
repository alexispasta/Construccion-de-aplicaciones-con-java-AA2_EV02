package servlets;

import java.io.IOException;
import java.sql.Date;

import dao.CertificadoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Certificado;

public class CertificadoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int idPersona = Integer.parseInt(request.getParameter("id_persona"));
            String nombrePersona = request.getParameter("nombre_persona");
            String carrera = request.getParameter("carrera");
            Date fechaInicio = Date.valueOf(request.getParameter("fecha_inicio"));
            String institucion = request.getParameter("institucion");

            // Crear objeto
            Certificado certificado = new Certificado();
            certificado.setIdPersona(idPersona);
            certificado.setNombrePersona(nombrePersona);
            certificado.setCarrera(carrera);
            certificado.setFechaInicio(fechaInicio);
            certificado.setInstitucion(institucion);

            // Insertar
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
