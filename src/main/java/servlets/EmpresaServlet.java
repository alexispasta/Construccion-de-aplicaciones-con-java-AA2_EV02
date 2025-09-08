package servlets;

import java.io.IOException;
import java.sql.Date; // Import necesario para la conversión de fecha

import dao.EmpresaDAO;
import dao.PersonaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Empresa;
import modelo.Persona;

public class EmpresaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if ("registrarEmpresaGerente".equals(accion)) {
            // ---- Datos Empresa ----
            String nombreEmpresa = request.getParameter("nombre_empresa");
            String telefonoEmpresa = request.getParameter("telefono_empresa");
            String direccionEmpresa = request.getParameter("direccion_empresa");
            String ciudad = request.getParameter("ciudad_empresa");
            String pais = request.getParameter("pais_empresa");

            Empresa empresa = new Empresa();
            empresa.setNombre(nombreEmpresa);
            empresa.setTelefono(telefonoEmpresa);
            empresa.setDireccion(direccionEmpresa);
            empresa.setCiudad(ciudad);
            empresa.setPais(pais);

            EmpresaDAO empresaDAO = new EmpresaDAO();
            int idEmpresa = empresaDAO.insertarEmpresa(empresa);

            if (idEmpresa > 0) {
                // ---- Datos Gerente ----
                String nombre = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                String correo = request.getParameter("correo");
                String telefono = request.getParameter("telefono");
                String direccion = request.getParameter("direccion");
                String documento = request.getParameter("documento_identidad");
                String fechaNacimientoStr = request.getParameter("fecha_nacimiento");
                String tipoContrato = request.getParameter("tipo_contrato");
                String contrasena = request.getParameter("contrasena");

                Persona gerente = new Persona();
                gerente.setNombre(nombre);
                gerente.setApellido(apellido);
                gerente.setCorreo(correo);
                gerente.setTelefono(telefono);
                gerente.setDireccion(direccion);
                gerente.setDocumentoIdentidad(documento);

                // ✅ Conversión de String a java.sql.Date
                try {
                    Date fechaNacimiento = Date.valueOf(fechaNacimientoStr); // formato yyyy-MM-dd
                    gerente.setFechaNacimiento(fechaNacimiento);
                } catch (IllegalArgumentException e) {
                    response.getWriter().println("<h1>Error: formato de fecha inválido.</h1>");
                    return; // detenemos la ejecución si la fecha no es válida
                }

                gerente.setTipoContrato(tipoContrato);
                gerente.setContrasena(contrasena);
                gerente.setRol("gerente");
                gerente.setIdEmpresa(idEmpresa);

                PersonaDAO personaDAO = new PersonaDAO();
                boolean insertado = personaDAO.insertarPersona(gerente);

                if (insertado) {
                    response.sendRedirect("exito.jsp");
                } else {
                    response.getWriter().println("<h1>Error al registrar gerente.</h1>");
                }

            } else {
                response.getWriter().println("<h1>Error al registrar empresa.</h1>");
            }
        }
    }
}
