<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Solicitud de Permiso</title>
</head>
<body>
    <h2>Formulario de Solicitud de Permiso</h2>
    <form action="permiso" method="post">
        <label for="id_autor">ID del Autor:</label><br>
        <input type="number" name="id_autor" id="id_autor" required><br><br>

        <label for="id_persona">ID de la Persona:</label><br>
        <input type="number" name="id_persona" id="id_persona" required><br><br>

        <label for="nombre_persona">Nombre de la Persona:</label><br>
        <input type="text" name="nombre_persona" id="nombre_persona" required><br><br>

        <label for="documento_identidad">Documento de Identidad:</label><br>
        <input type="text" name="documento_identidad" id="documento_identidad" required><br><br>

        <label for="razon">Razón del Permiso:</label><br>
        <textarea name="razon" id="razon" rows="4" cols="50" required></textarea><br><br>

        <label for="fecha_solicitud">Fecha de Solicitud:</label><br>
        <input type="date" name="fecha_solicitud" id="fecha_solicitud" required><br><br>

        <label for="fecha_aplicacion">Fecha de Aplicación:</label><br>
        <input type="date" name="fecha_aplicacion" id="fecha_aplicacion" required><br><br>

        <input type="submit" value="Enviar Permiso">
    </form>
</body>
</html>
