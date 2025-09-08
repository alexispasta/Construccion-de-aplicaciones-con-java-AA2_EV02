package servlets;

import java.io.IOException;
import java.sql.Date;

import dao.PersonaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Persona;

@WebServlet("/PersonaServlet")
public class PersonaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private PersonaDAO personaDAO;

    @Override
    public void init() {
        personaDAO = new PersonaDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession(false);
            if (session == null || session.getAttribute("usuario") == null) {
                response.sendRedirect("login.html");
                return;
            }

            // 📌 Capturamos parámetros del formulario
            String idStr = request.getParameter("id");
            int id = (idStr != null && !idStr.isEmpty()) ? Integer.parseInt(idStr) : 0;

            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String correo = request.getParameter("correo");
            String telefono = request.getParameter("telefono");
            String direccion = request.getParameter("direccion");
            String documentoIdentidad = request.getParameter("documento_identidad");

            String fechaNacStr = request.getParameter("fecha_nacimiento");
            Date fechaNacimiento = (fechaNacStr != null && !fechaNacStr.isEmpty()) ? Date.valueOf(fechaNacStr) : null;

            // 📌 Solo usamos fecha_contratacion automática en inserción
            Date fechaContratacion;
            if (id > 0) {
                // Actualización → se conserva lo que venga del form (si lo mandas oculto)
                String fechaContStr = request.getParameter("fecha_contratacion");
                fechaContratacion = (fechaContStr != null && !fechaContStr.isEmpty()) ? Date.valueOf(fechaContStr) : null;
            } else {
                // Inserción → se genera con la fecha actual del servidor
                fechaContratacion = new Date(System.currentTimeMillis());
            }

            String tipoContrato = request.getParameter("tipo_contrato");
            String rol = request.getParameter("rol");
            boolean activo = request.getParameter("activo") != null; // checkbox
            String contrasena = request.getParameter("contrasena");
            int idEmpresa = Integer.parseInt(request.getParameter("id_empresa"));

            // 📌 Crear objeto Persona
            Persona persona = new Persona();
            persona.setId(id);
            persona.setNombre(nombre);
            persona.setApellido(apellido);
            persona.setCorreo(correo);
            persona.setTelefono(telefono);
            persona.setDireccion(direccion);
            persona.setDocumentoIdentidad(documentoIdentidad);
            persona.setFechaNacimiento(fechaNacimiento);
            persona.setFechaContratacion(fechaContratacion);
            persona.setTipoContrato(tipoContrato);
            persona.setRol(rol);
            persona.setActivo(activo);
            persona.setContrasena(contrasena);
            persona.setIdEmpresa(idEmpresa);

            boolean exito;
            if (id > 0) {
                // 📌 Actualizar
                exito = personaDAO.actualizarPersona(persona);
            } else {
                // 📌 Insertar
                exito = personaDAO.insertarPersona(persona);
            }

            if (!exito) {
                response.sendRedirect("empleados.jsp?error=1");
                return;
            }

            response.sendRedirect("empleados.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("empleados.jsp?error=2");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 📌 Manejar eliminación con ?accion=eliminar&id=xx
        String accion = request.getParameter("accion");
        if ("eliminar".equals(accion)) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                boolean eliminado = personaDAO.eliminarPersona(id);
                if (eliminado) {
                    response.sendRedirect("empleados.jsp");
                } else {
                    response.sendRedirect("empleados.jsp?error=3");
                }
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("empleados.jsp?error=4");
            }
        } else {
            response.sendRedirect("empleados.jsp");
        }
    }
}
