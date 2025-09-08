<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registro de Persona</title>
    <style>
        body { font-family: Arial, sans-serif; background: #eef2f7; margin: 0; padding: 20px; }
        .container { background: #fff; padding: 25px; border-radius: 10px;
                     box-shadow: 0px 4px 10px rgba(0,0,0,0.1); max-width: 600px; margin: auto; }
        h2 { text-align: center; margin-bottom: 20px; }
        form { display: flex; flex-direction: column; }
        label { font-weight: bold; margin-top: 10px; }
        input, select { padding: 10px; margin-top: 5px; border: 1px solid #ccc; border-radius: 6px; }
        input[type="submit"] { 
            background: #007bff; 
            color: white; 
            font-size: 16px;
            border: none; 
            border-radius: 6px; 
            cursor: pointer; 
            margin-top: 20px; 
            padding: 12px;
        }
        input[type="submit"]:hover { background: #0056b3; }
    </style>
</head>
<body>
    <div class="container">
        <h2>Registro de Persona</h2>
        <form method="post" action="PersonaServlet">
            <!-- Campo oculto para indicar que es un INSERT -->
            <input type="hidden" name="accion" value="insertar">

            <label>Nombre:</label>
            <input type="text" name="nombre" placeholder="Nombre" required>

            <label>Apellido:</label>
            <input type="text" name="apellido" placeholder="Apellido" required>

            <label>Correo:</label>
            <input type="email" name="correo" placeholder="Correo">

            <label>Teléfono:</label>
            <input type="text" name="telefono" placeholder="Teléfono">

            <label>Dirección:</label>
            <input type="text" name="direccion" placeholder="Dirección">

            <label>Documento de Identidad:</label>
            <input type="text" name="documento_identidad" placeholder="Documento de Identidad" required>

            <label>Fecha de Nacimiento:</label>
            <input type="date" name="fecha_nacimiento" required>

            <label>Tipo de Contrato:</label>
            <select name="tipo_contrato" required>
                <option value="TERMINO_FIJO">Término fijo</option>
                <option value="TERMINO_INDEFINIDO">Término indefinido</option>
                <option value="PRESTACION_DE_SERVICIOS">Prestación de servicios</option>
            </select>

            <label>Rol:</label>
            <select name="rol" required>
                <option value="empleado">Empleado</option>
                <option value="supervisor">Supervisor</option>
                <option value="RRHH">RRHH</option>
                <option value="gerente">Gerente</option>
            </select>

            <label>Contraseña:</label>
            <input type="password" name="contrasena" placeholder="Contraseña" required>

            <!-- El id_empresa viene del usuario logueado -->
            <input type="hidden" name="id_empresa" value="<%= ((modelo.Persona)session.getAttribute("usuario")).getIdEmpresa() %>">

            <input type="submit" value="Registrar Persona">
        </form>
    </div>
</body>
</html>
