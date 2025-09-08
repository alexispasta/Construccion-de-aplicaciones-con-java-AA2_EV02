<%@ page import="java.util.List" %>
<%@ page import="modelo.Persona" %>
<%@ page import="dao.PersonaDAO" %>
<%
    PersonaDAO personaDAO = new PersonaDAO();
    List<Persona> empleados = personaDAO.obtenerTodos();
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Gestión de Nómina</title>
    <style>
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ccc; padding: 5px; }
        input[type="number"], input[type="text"] { width: 120px; }
        .guardar { background: #4CAF50; color: white; border: none; padding: 5px 10px; cursor: pointer; }
    </style>
</head>
<body>
    <h2>Gestión de Nómina</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th><th>Nombre</th><th>Cuenta</th><th>Salario</th><th>Aux. Transp</th>
                <th>Horas Extra</th><th>Bonificación</th><th>Comisiones</th><th>Viáticos</th>
                <th>Descuentos</th><th>Retención</th><th>Préstamos</th><th>Embargos</th>
                <th>Incap.</th><th>Vacaciones</th><th>Cesantías</th><th>Int. Cesantías</th>
                <th>Prima</th><th>Total</th><th>Acción</th>
            </tr>
        </thead>
        <tbody>
        <% for (Persona emp : empleados) { %>
            <tr>
                <form action="detalleNomina" method="post">
                    <td><%= emp.getId() %>
                        <input type="hidden" name="id_persona" value="<%= emp.getId() %>">
                    </td>
                    <td><%= emp.getNombre() %> <%= emp.getApellido() %></td>
                    <td><input type="text" name="cuenta_bancaria"></td>
                    <td><input type="number" step="0.01" name="salario_base"></td>
                    <td><input type="number" step="0.01" name="auxilio_transporte"></td>
                    <td><input type="number" name="horas_extra"></td>
                    <td><input type="number" step="0.01" name="bonificacion"></td>
                    <td><input type="number" step="0.01" name="comisiones"></td>
                    <td><input type="number" step="0.01" name="viaticos"></td>
                    <td><input type="number" step="0.01" name="descuentos"></td>
                    <td><input type="number" step="0.01" name="retencion_fuente"></td>
                    <td><input type="number" step="0.01" name="prestamos_empresa"></td>
                    <td><input type="number" step="0.01" name="embargos_judiciales"></td>
                    <td><input type="number" name="incapacidades_dias"></td>
                    <td><input type="number" name="vacaciones_dias"></td>
                    <td><input type="number" step="0.01" name="cesantias"></td>
                    <td><input type="number" step="0.01" name="intereses_cesantias"></td>
                    <td><input type="number" step="0.01" name="prima_servicios"></td>
                    <td><input type="number" step="0.01" name="total_pagar"></td>
                    <td><button type="submit" class="guardar">Guardar</button></td>
                </form>
            </tr>
        <% } %>
        </tbody>
    </table>
</body>
</html>
