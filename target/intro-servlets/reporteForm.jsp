<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Persona" %>
<%@ page import="dao.PersonaDAO" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Reportes de Empleados</title>
    <style>
        table { width: 100%; border-collapse: collapse; }
        th, td { border: 1px solid #ddd; padding: 8px; }
        th { background-color: #f2f2f2; }
        textarea { width: 100%; resize: vertical; }
        input[type="date"], input[type="text"], input[type="number"] {
            width: 95%;
        }
    </style>
</head>
<body>
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
            PersonaDAO dao = new PersonaDAO();
            List<Persona> empleados = dao.obtenerTodos();
            int idAutor = 1; // 🔹 Aquí puedes obtener el ID del usuario logueado (ej: desde sesión)
            for (Persona emp : empleados) {
        %>
            <tr>
                <form action="reporte" method="post">
                    <td>
                        <%= emp.getId() %>
                        <input type="hidden" name="id_persona" value="<%= emp.getId() %>">
                        <input type="hidden" name="nombre_persona" value="<%= emp.getNombre() %> <%= emp.getApellido() %>">
                        <input type="hidden" name="id_autor" value="<%= idAutor %>">
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
                        <input type="submit" value="Enviar">
                    </td>
                </form>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>
</body>
</html>
