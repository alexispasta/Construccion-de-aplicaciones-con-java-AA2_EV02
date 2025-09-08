<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Persona" %>
<%@ page import="dao.PersonaDAO" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Gestión de Empleados</title>
    <style>
        table { width: 100%; border-collapse: collapse; }
        th, td { border: 1px solid #ddd; padding: 8px; }
        th { background-color: #f2f2f2; }
        input, select { width: 95%; }
        button { padding: 5px 10px; }
    </style>
</head>
<body>
    <h2>Gestión de Empleados</h2>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Correo</th>
                <th>Teléfono</th>
                <th>Dirección</th>
                <th>Documento</th>
                <th>F. Nacimiento</th>
                <th>F. Contratación</th>
                <th>Contrato</th>
                <th>Rol</th>
                <th>Activo</th>
                <th>Contraseña</th>
                <th>Empresa</th>
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
                <form action="empleado" method="post">
                    <td>
                        <%= emp.getId() %>
                        <input type="hidden" name="id" value="<%= emp.getId() %>">
                    </td>
                    <td><input type="text" name="nombre" value="<%= emp.getNombre() %>" required></td>
                    <td><input type="text" name="apellido" value="<%= emp.getApellido() %>" required></td>
                    <td><input type="email" name="correo" value="<%= emp.getCorreo() %>"></td>
                    <td><input type="text" name="telefono" value="<%= emp.getTelefono() == null ? "" : emp.getTelefono() %>"></td>
                    <td><input type="text" name="direccion" value="<%= emp.getDireccion() == null ? "" : emp.getDireccion() %>"></td>
                    <td><input type="text" name="documento_identidad" value="<%= emp.getDocumentoIdentidad() == null ? "" : emp.getDocumentoIdentidad() %>"></td>
                    <td><input type="date" name="fecha_nacimiento" value="<%= emp.getFechaNacimiento() != null ? emp.getFechaNacimiento().toString() : "" %>"></td>
                    <td><input type="date" name="fecha_contratacion" value="<%= emp.getFechaContratacion() != null ? emp.getFechaContratacion().toString() : "" %>"></td>
                    <td>
                        <select name="tipo_contrato">
                            <option value="termino fijo" <%= "termino fijo".equals(emp.getTipoContrato()) ? "selected" : "" %>>Término fijo</option>
                            <option value="termino indefinido" <%= "termino indefinido".equals(emp.getTipoContrato()) ? "selected" : "" %>>Término indefinido</option>
                            <option value="prestacion de servicios" <%= "prestacion de servicios".equals(emp.getTipoContrato()) ? "selected" : "" %>>Prestación de servicios</option>
                        </select>
                    </td>
                    <td>
                        <select name="rol">
                            <option value="empleado" <%= "empleado".equals(emp.getRol()) ? "selected" : "" %>>Empleado</option>
                            <option value="supervisor" <%= "supervisor".equals(emp.getRol()) ? "selected" : "" %>>Supervisor</option>
                            <option value="RRHH" <%= "RRHH".equals(emp.getRol()) ? "selected" : "" %>>RRHH</option>
                            <option value="gerente" <%= "gerente".equals(emp.getRol()) ? "selected" : "" %>>Gerente</option>
                        </select>
                    </td>
                    <td>
                        <input type="checkbox" name="activo" value="true" <%= emp.isActivo() ? "checked" : "" %>>
                    </td>
                    <td><input type="password" name="contrasena" value="<%= emp.getContrasena() == null ? "" : emp.getContrasena() %>"></td>
                    <td><input type="number" name="id_empresa" value="<%= emp.getIdEmpresa() %>"></td>
                    <td><button type="submit">Guardar</button></td>
                </form>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>
</body>
</html>
