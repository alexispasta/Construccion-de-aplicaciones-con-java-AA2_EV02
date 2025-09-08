<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Formulario de Informe</title>
</head>
<body>
    <h2>Registro de Informe</h2>
    <form action="informe" method="post">
        <label for="id_autor">ID del Autor:</label><br>
        <input type="number" name="id_autor" id="id_autor" required><br><br>

        <label for="id_empresa">ID de la Empresa:</label><br>
        <input type="number" name="id_empresa" id="id_empresa" required><br><br>

        <label for="asunto">Asunto:</label><br>
        <input type="text" name="asunto" id="asunto" required><br><br>

        <label for="comentario">Comentario:</label><br>
        <textarea name="comentario" id="comentario" rows="4" cols="50" required></textarea><br><br>

        <input type="submit" value="Enviar Informe">
    </form>
</body>
</html>
