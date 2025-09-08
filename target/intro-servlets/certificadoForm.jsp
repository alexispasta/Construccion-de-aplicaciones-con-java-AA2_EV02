<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Persona" %>
<%@ page import="dao.PersonaDAO" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registro de Certificados</title>
    <style>
        table { width: 100%; border-collapse: collapse; }
        th, td { border: 1px solid #ddd; padding: 8px; }
        th { background-color: #f2f2f2; }
        input, textarea { width: 95%; }
    </style>
</head>
<body>
    <h2>Registrar Certificados de Empleados</h2>

    <table>
        <thead>
            <tr>
                <th>ID Empleado</th>
                <th>Nombre</th>
                <th>Correo</th>
                <th>Carrera</th>
                <th>Fecha Inicio</th>
                <th>Institución</th>
                <th>Acción</th>
            </tr>
        </thead>
        <tbody>
        <%
            PersonaDAO dao = new PersonaDAO();
            List<Persona> empleados = dao.obtenerTodos();
            for (Persona emp : empleados) {
        %>
            <tr>
                <form action="certificado" method="post">
                    <td>
                        <%= emp.getId() %>
                        <input type="hidden" name="id_persona" value="<%= emp.getId() %>">
                        <input type="hidden" name="nombre_persona" value="<%= emp.getNombre() %> <%= emp.getApellido() %>">
                    </td>
                    <td><%= emp.getNombre() %> <%= emp.getApellido() %></td>
                    <td><%= emp.getCorreo() %></td>
                    <td>
                        <input type="text" name="carrera" required>
                    </td>
                    <td>
                        <input type="date" name="fecha_inicio" required>
                    </td>
                    <td>
                        <input type="text" name="institucion" required>
                    </td>
                    <td>
                        <button type="submit">Guardar</button>
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
