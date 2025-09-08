<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registrar Certificado</title>
</head>
<body>
    <h2>Registro de Certificado</h2>
    <form action="certificado" method="post">
        <label for="id_persona">ID Persona:</label>
        <input type="number" name="id_persona" id="id_persona" required><br>

        <label for="nombre_persona">Nombre Persona:</label>
        <input type="text" name="nombre_persona" id="nombre_persona" required><br>

        <label for="carrera">Carrera:</label>
        <input type="text" name="carrera" id="carrera" required><br>

        <label for="fecha_inicio">Fecha de Inicio:</label>
        <input type="date" name="fecha_inicio" id="fecha_inicio" required><br>

        <label for="institucion">Institución:</label>
        <input type="text" name="institucion" id="institucion" required><br>

        <button type="submit">Registrar</button>
    </form>
</body>
</html>
