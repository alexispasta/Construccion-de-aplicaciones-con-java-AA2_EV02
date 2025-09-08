<%@ page import="java.util.List" %>
<%@ page import="modelo.Persona" %>
<%@ page import="dao.PersonaDAO" %>

<%
    // ✅ Recuperar usuario logueado
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
    <title>Gestión de Nómina</title>
    <style>
        body { font-family: Arial, sans-serif; background: #eef2f7; margin: 0; padding: 20px; }
        .container { background: #fff; padding: 20px; border-radius: 10px;
                     box-shadow: 0px 4px 10px rgba(0,0,0,0.1); max-width: 95%; margin: auto; }
        h2 { text-align: center; margin-bottom: 20px; }

        table { width: 100%; border-collapse: collapse; margin-top: 15px; font-size: 14px; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: center; }
        th { background: #007bff; color: white; }

        input[type="number"], input[type="text"] {
            width: 110px; padding: 6px; border: 1px solid #ccc; border-radius: 5px;
        }

        .guardar {
            background: #28a745; color: white; border: none;
            padding: 8px 14px; border-radius: 6px; cursor: pointer;
        }
        .guardar:hover { background: #218838; }
    </style>
</head>
<body>
    <div class="container">
        <h2>Gestión de Nómina</h2>

        <table>
            <thead>
                <tr>
                    <th>ID</th><th>Empleado</th><th>Cuenta</th><th>Salario</th><th>Aux. Transp</th>
                    <th>Horas Extra</th><th>Bonificación</th><th>Comisiones</th><th>Viáticos</th>
                    <th>Descuentos</th><th>Retención</th><th>Préstamos</th><th>Embargos</th>
                    <th>Incap.</th><th>Vacaciones</th><th>Cesantías</th><th>Int. Cesantías</th>
                    <th>Prima</th><th>Total</th><th>Acción</th>
                </tr>
            </thead>
            <tbody>
            <% for (Persona emp : empleados) { %>
                <tr>
                    <form action="DetalleNominaServlet" method="post">
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
    </div>
</body>
</html>
