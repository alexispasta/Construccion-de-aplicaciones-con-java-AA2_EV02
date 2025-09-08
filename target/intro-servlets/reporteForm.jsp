<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Persona" %>
<%@ page import="dao.PersonaDAO" %>

<%
    // Recuperar usuario logueado
    Persona usuario = (Persona) session.getAttribute("usuario");
    if (usuario == null) {
        response.sendRedirect("login.html");
        return;
    }

    int idEmpresa = usuario.getIdEmpresa();

    PersonaDAO dao = new PersonaDAO();
    List<Persona> empleados = dao.obtenerPorEmpresa(idEmpresa);
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Reportes de Empleados</title>
    <style>
        body { font-family: Arial, sans-serif; background: #eef2f7; margin: 0; padding: 20px; }
        .container { background: #fff; padding: 20px; border-radius: 10px;
                     box-shadow: 0px 4px 10px rgba(0,0,0,0.1); max-width: 1000px; margin: auto; }
        h2 { text-align: center; margin-bottom: 20px; }
        table { width: 100%; border-collapse: collapse; margin-top: 15px; }
        th, td { border: 1px solid #ddd; padding: 12px; text-align: center; }
        th { background: #007bff; color: white; }
        textarea { width: 100%; resize: vertical; }
        input[type="date"], input[type="text"], input[type="number"] {
            width: 95%;
        }
        .btn { background: #007bff; color: white; padding: 8px 15px;
               border: none; border-radius: 6px; cursor: pointer; }
        .btn:hover { background: #0056b3; }
    </style>
</head>
<body>
    <div class="container">
        <h2>Generar Reportes de Empleados</h2>

        <table>
            <thead>
                <tr>
                    <th>ID Empleado</th>
                    <th>Nombre</th>
                    <th>Correo</th>
                    <th>Razón</th>
                    <th>Fecha</th>
                    <th>Comentarios</th>
                    <th>Acción</th>
                </tr>
            </thead>
            <tbody>
            <%
                for (Persona emp : empleados) {
            %>
                <tr>
                    <form action="ReporteServlet" method="post">
                        <td>
                            <%= emp.getId() %>
                            <input type="hidden" name="id_persona" value="<%= emp.getId() %>">
                            <input type="hidden" name="nombre_persona" value="<%= emp.getNombre() %> <%= emp.getApellido() %>">
                        </td>
                        <td><%= emp.getNombre() %> <%= emp.getApellido() %></td>
                        <td><%= emp.getCorreo() %></td>
                        <td>
                            <textarea name="razon" required></textarea>
                        </td>
                        <td>
                            <input type="date" name="fecha_reporte" required>
                        </td>
                        <td>
                            <textarea name="comentarios"></textarea>
                        </td>
                        <td>
                            <input type="submit" value="Enviar" class="btn">
                        </td>
                    </form>
                </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</body>
</html>
