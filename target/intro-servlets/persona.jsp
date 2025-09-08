<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulario Persona</title>
</head>
<body>
    <h2>Registro de Persona</h2>
    <form method="post" action="PersonaServlet">
        <input type="text" name="nombre" placeholder="Nombre" required><br>
        <input type="text" name="apellido" placeholder="Apellido" required><br>
        <input type="email" name="correo" placeholder="Correo"><br>
        <input type="text" name="telefono" placeholder="Teléfono"><br>
        <input type="text" name="direccion" placeholder="Dirección"><br>
        <input type="text" name="documento_identidad" placeholder="Documento de Identidad" required><br>
        <input type="date" name="fecha_nacimiento" required><br>
        <input type="date" name="fecha_contratacion" required><br>

        <select name="tipo_contrato" required>
            <option value="termino fijo">Término fijo</option>
            <option value="termino indefinido">Término indefinido</option>
            <option value="prestacion de servicios">Prestación de servicios</option>
        </select><br>

        <select name="rol" required>
            <option value="empleado">Empleado</option>
            <option value="supervisor">Supervisor</option>
            <option value="RRHH">RRHH</option>
            <option value="gerente">Gerente</option>
        </select><br>

        <input type="password" name="contrasena" placeholder="Contraseña" required><br>
        <input type="number" name="id_empresa" placeholder="ID de la Empresa" required><br>

        <input type="submit" value="Registrar Persona">
    </form>
</body>
</html>
