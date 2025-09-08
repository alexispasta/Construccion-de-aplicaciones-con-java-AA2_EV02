package servlets;

import java.io.IOException;
import java.sql.Date;

import dao.PersonaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Persona;

public class PersonaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String correo = request.getParameter("correo");
            String telefono = request.getParameter("telefono");
            String direccion = request.getParameter("direccion");
            String documento = request.getParameter("documento_identidad");
            String fechaNacimientoStr = request.getParameter("fecha_nacimiento");
            String fechaContratacionStr = request.getParameter("fecha_contratacion");
            String tipoContrato = request.getParameter("tipo_contrato");
            String rol = request.getParameter("rol");
            String contrasena = request.getParameter("contrasena");
            int idEmpresa = Integer.parseInt(request.getParameter("id_empresa"));
            boolean activo = "true".equals(request.getParameter("activo"));

            Persona persona = new Persona();
            persona.setId(id);
            persona.setNombre(nombre);
            persona.setApellido(apellido);
            persona.setCorreo(correo);
            persona.setTelefono(telefono);
            persona.setDireccion(direccion);
            persona.setDocumentoIdentidad(documento);

            if (fechaNacimientoStr != null && !fechaNacimientoStr.isEmpty()) {
                persona.setFechaNacimiento(Date.valueOf(fechaNacimientoStr));
            }
            if (fechaContratacionStr != null && !fechaContratacionStr.isEmpty()) {
                persona.setFechaContratacion(Date.valueOf(fechaContratacionStr));
            }

            persona.setTipoContrato(tipoContrato);
            persona.setRol(rol);
            persona.setContrasena(contrasena);
            persona.setIdEmpresa(idEmpresa);
            persona.setActivo(activo);

            PersonaDAO dao = new PersonaDAO();
            boolean ok = dao.actualizarPersona(persona);

            if (ok) {
                response.sendRedirect("empleados.jsp");
            } else {
                response.sendRedirect("error.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
