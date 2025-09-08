package servlets;

import java.io.IOException;
import java.sql.Date;

import dao.NominaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Nomina;

public class NominaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idPersona = Integer.parseInt(request.getParameter("id_persona"));
        Date fechaPago = Date.valueOf(request.getParameter("fecha_pago"));
        double cantidad = Double.parseDouble(request.getParameter("cantidad"));

        Nomina nomina = new Nomina();
        nomina.setIdPersona(idPersona);
        nomina.setFechaPago(fechaPago);
        nomina.setCantidad(cantidad);

        NominaDAO dao = new NominaDAO();
        dao.insertarNomina(nomina);

        response.sendRedirect("nomina_exito.jsp");
    }
}
