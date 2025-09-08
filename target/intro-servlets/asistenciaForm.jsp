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
    <title>Registro de Asistencia</title>
    <style>
        body { font-family: Arial, sans-serif; background: #eef2f7; margin: 0; padding: 20px; }
        .container { background: #fff; padding: 20px; border-radius: 10px;
                     box-shadow: 0px 4px 10px rgba(0,0,0,0.1); max-width: 900px; margin: auto; }
        h2 { text-align: center; margin-bottom: 20px; }
        table { width: 100%; border-collapse: collapse; margin-top: 15px; }
        th, td { border: 1px solid #ddd; padding: 12px; text-align: center; }
        th { background: #007bff; color: white; }
        input[type="date"] { padding: 8px; margin-bottom: 15px; width: 200px; }
        select { padding: 6px; }
        .btn { background: #28a745; color: white; padding: 12px 20px;
               border: none; border-radius: 6px; cursor: pointer; margin-top: 15px; display: block; width: 100%; }
        .btn:hover { background: #218838; }
    </style>
</head>
<body>
    <div class="container">
        <h2>Registro de Asistencia</h2>
        
        <form action="AsistenciaServlet" method="post">
            <label><b>Fecha:</b></label>
            <input type="date" name="fecha" required>

            <table>
                <tr>
                    <th>ID</th>
                    <th>Empleado</th>
                    <th>Correo</th>
                    <th>Estado</th>
                </tr>
                <% for (Persona emp : empleados) { %>
                <tr>
                    <td><%= emp.getId() %></td>
                    <td><%= emp.getNombre() %> <%= emp.getApellido() %></td>
                    <td><%= emp.getCorreo() %></td>
                    <td>
                        <select name="estado_<%= emp.getId() %>">
                            <option value="Presente">Presente</option>
                            <option value="Ausente">Ausente</option>
                            <option value="Permiso">Permiso</option>
                        </select>
                    </td>
                </tr>
                <% } %>
            </table>

            <input type="submit" value="Guardar Asistencia" class="btn">
        </form>
    </div>
</body>
</html>
