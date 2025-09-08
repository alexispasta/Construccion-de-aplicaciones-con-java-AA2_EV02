package servlets;

import java.io.IOException;

import dao.PersonaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Persona;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String correo = request.getParameter("correo").trim();
        String contrasena = request.getParameter("contrasena").trim();

        PersonaDAO dao = new PersonaDAO();
        Persona persona = dao.validarLogin(correo, contrasena);

        if (persona != null) {
            // Guardar sesión
            HttpSession session = request.getSession();
            session.setAttribute("usuario", persona);

            // Redirigir al dashboard
            response.sendRedirect("dashboard.html");
        } else {
            // Si no existe, volver al login con error
            response.sendRedirect("login.html?error=1");
        }
    }
}
