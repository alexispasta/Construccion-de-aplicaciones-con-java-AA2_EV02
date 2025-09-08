<%@ page import="java.util.List" %>
<%@ page import="modelo.Persona" %>
<%@ page import="dao.PersonaDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    // ✅ Verificar sesión
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
    <title>Solicitud de Permiso</title>
    <style>
        body { font-family: Arial, sans-serif; background: #eef2f7; margin: 0; padding: 20px; }
        .container { background: #fff; padding: 20px; border-radius: 10px;
                     box-shadow: 0px 4px 10px rgba(0,0,0,0.1); max-width: 900px; margin: auto; }
        h2 { text-align: center; margin-bottom: 20px; }
        label { font-weight: bold; display: block; margin-top: 10px; }
        input, textarea, select { padding: 8px; margin: 5px 0; width: 100%; }
        .btn { background: #28a745; color: white; padding: 12px 20px;
               border: none; border-radius: 6px; cursor: pointer; margin-top: 15px; display: block; width: 100%; }
        .btn:hover { background: #218838; }
    </style>
</head>
<body>
    <div class="container">
        <h2>Solicitud de Permiso</h2>

        <form action="permiso" method="post">
            <!-- ID del autor oculto desde la sesión -->
            <input type="hidden" name="id_autor" value="<%= usuario.getId() %>">

            <label for="id_persona">Empleado:</label>
            <select name="id_persona" id="id_persona" required>
                <option value="">Seleccione un empleado</option>
                <% for (Persona emp : empleados) { %>
                    <option value="<%= emp.getId() %>">
                        <%= emp.getNombre() %> <%= emp.getApellido() %>
                    </option>
                <% } %>
            </select>

            <label for="razon">Razón del Permiso:</label>
            <textarea name="razon" id="razon" rows="4" required></textarea>

            <label for="fecha_solicitud">Fecha de Solicitud:</label>
            <input type="date" name="fecha_solicitud" id="fecha_solicitud" required>

            <label for="fecha_aplicacion">Fecha de Aplicación:</label>
            <input type="date" name="fecha_aplicacion" id="fecha_aplicacion" required>

            <input type="submit" value="Guardar Permiso" class="btn">
        </form>
    </div>
</body>
</html>
