<%@ page import="java.util.List" %> 
<%@ page import="modelo.Persona" %>
<%@ page import="dao.PersonaDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Solicitud de Permiso</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
            margin-bottom: 20px;
        }
        table, th, td {
            border: 1px solid #333;
            padding: 8px;
        }
        th {
            background: #f2f2f2;
        }
    </style>
</head>
<body>
    <h2>Formulario de Solicitud de Permiso</h2>

    <form action="permiso" method="post">
        <label for="id_autor">ID del Autor:</label><br>
        <input type="number" name="id_autor" id="id_autor" required><br><br>

        <!-- Solo datos del empleado -->
        <label for="id_persona">ID de la Persona:</label><br>
        <input type="number" name="id_persona" id="id_persona" readonly required><br><br>

        <label for="nombre_persona">Nombre del Empleado:</label><br>
        <input type="text" name="nombre_persona" id="nombre_persona" readonly required><br><br>

        <!-- Campos de permiso -->
        <label for="razon">Razón del Permiso:</label><br>
        <textarea name="razon" id="razon" rows="4" cols="50" required></textarea><br><br>

        <label for="fecha_solicitud">Fecha de Solicitud:</label><br>
        <input type="date" name="fecha_solicitud" id="fecha_solicitud" required><br><br>

        <label for="fecha_aplicacion">Fecha de Aplicación:</label><br>
        <input type="date" name="fecha_aplicacion" id="fecha_aplicacion" required><br><br>

        <input type="submit" value="Guardar Permiso">
    </form>

    <h3>Seleccionar Empleado</h3>
    <table>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Acción</th>
        </tr>
        <%
            PersonaDAO dao = new PersonaDAO();
            List<Persona> lista = dao.obtenerTodos();
            for (Persona p : lista) {
        %>
        <tr>
            <td><%= p.getId() %></td>
            <td><%= p.getNombre() %></td>
            <td>
                <button type="button" onclick="seleccionarEmpleado('<%=p.getId()%>', '<%=p.getNombre()%>')">
                    Seleccionar
                </button>
            </td>
        </tr>
        <% } %>
    </table>

    <script>
        function seleccionarEmpleado(id, nombre) {
            document.getElementById("id_persona").value = id;
            document.getElementById("nombre_persona").value = nombre;
        }
    </script>
</body>
</html>
