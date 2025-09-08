<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Formulario Detalle de Nómina</title>
</head>
<body>
    <h2>Detalle de Nómina</h2>
    <form action="detalleNomina" method="post">
        <label>ID Persona:</label><br>
        <input type="number" name="id_persona" required><br>

        <label>Cuenta Bancaria:</label><br>
        <input type="text" name="cuenta_bancaria"><br>

        <label>Salario Base:</label><br>
        <input type="number" step="0.01" name="salario_base"><br>

        <label>Auxilio Transporte:</label><br>
        <input type="number" step="0.01" name="auxilio_transporte"><br>

        <label>Horas Extra:</label><br>
        <input type="number" name="horas_extra"><br>

        <label>Bonificación:</label><br>
        <input type="number" step="0.01" name="bonificacion"><br>

        <label>Comisiones:</label><br>
        <input type="number" step="0.01" name="comisiones"><br>

        <label>Viáticos:</label><br>
        <input type="number" step="0.01" name="viaticos"><br>

        <label>Descuentos:</label><br>
        <input type="number" step="0.01" name="descuentos"><br>

        <label>Retención en la Fuente:</label><br>
        <input type="number" step="0.01" name="retencion_fuente"><br>

        <label>Préstamos Empresa:</label><br>
        <input type="number" step="0.01" name="prestamos_empresa"><br>

        <label>Embargos Judiciales:</label><br>
        <input type="number" step="0.01" name="embargos_judiciales"><br>

        <label>Incapacidades (días):</label><br>
        <input type="number" name="incapacidades_dias"><br>

        <label>Vacaciones (días):</label><br>
        <input type="number" name="vacaciones_dias"><br>

        <label>Cesantías:</label><br>
        <input type="number" step="0.01" name="cesantias"><br>

        <label>Intereses de Cesantías:</label><br>
        <input type="number" step="0.01" name="intereses_cesantias"><br>

        <label>Prima de Servicios:</label><br>
        <input type="number" step="0.01" name="prima_servicios"><br>

        <label>Total a Pagar:</label><br>
        <input type="number" step="0.01" name="total_pagar"><br><br>

        <input type="submit" value="Registrar Detalle">
    </form>
</body>
</html>
