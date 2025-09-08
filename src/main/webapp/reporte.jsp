<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Formulario de Reporte</title>
</head>
<body>
    <h2>Formulario de Reporte</h2>
    <form action="reporte" method="post">
        <label for="id_autor">ID del Autor:</label><br>
        <input type="number" name="id_autor" id="id_autor" required><br><br>

        <label for="id_persona">ID de la Persona Reportada:</label><br>
        <input type="number" name="id_persona" id="id_persona" required><br><br>

        <label for="nombre_persona">Nombre de la Persona:</label><br>
        <input type="text" name="nombre_persona" id="nombre_persona" required><br><br>

        <label for="razon">Razón:</label><br>
        <textarea name="razon" id="razon" required></textarea><br><br>

        <label for="fecha_reporte">Fecha del Reporte:</label><br>
        <input type="date" name="fecha_reporte" id="fecha_reporte" required><br><br>

        <label for="comentarios">Comentarios:</label><br>
        <textarea name="comentarios" id="comentarios"></textarea><br><br>

        <input type="submit" value="Enviar Reporte">
    </form>
</body>
</html>
