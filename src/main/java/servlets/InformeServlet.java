package servlets;

import java.io.IOException;

import dao.InformeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Informe;

public class InformeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idAutor = Integer.parseInt(request.getParameter("id_autor"));
        int idEmpresa = Integer.parseInt(request.getParameter("id_empresa"));
        String asunto = request.getParameter("asunto");
        String comentario = request.getParameter("comentario");

        Informe informe = new Informe();
        informe.setIdAutor(idAutor);
        informe.setIdEmpresa(idEmpresa);
        informe.setAsunto(asunto);
        informe.setComentario(comentario);

        InformeDAO dao = new InformeDAO();
        dao.insertarInforme(informe);

        response.sendRedirect("informe_exito.jsp");
    }
}
