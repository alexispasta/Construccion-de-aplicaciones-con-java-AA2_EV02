package servlets;

import dao.EmpresaDAO;
import modelo.Empresa;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class EmpresaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Recoger datos del formulario
        String nombre = request.getParameter("nombre");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String ciudad = request.getParameter("ciudad");
        String pais = request.getParameter("pais");

        // Crear objeto empresa
        Empresa empresa = new Empresa();
        empresa.setNombre(nombre);
        empresa.setTelefono(telefono);
        empresa.setDireccion(direccion);
        empresa.setCiudad(ciudad);
        empresa.setPais(pais);

        // Insertar en BD
        EmpresaDAO dao = new EmpresaDAO();
        boolean insertado = dao.insertarEmpresa(empresa);

        // Enviar respuesta al navegador
        response.setContentType("text/html");
        response.getWriter().println("<h1>" + (insertado ? "Empresa registrada exitosamente." : "Error al registrar empresa.") + "</h1>");
    }
}
