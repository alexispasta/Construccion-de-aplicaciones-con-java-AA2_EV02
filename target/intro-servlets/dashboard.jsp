<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="modelo.Persona" %>

<%
    // Recuperar usuario de la sesión
    Persona usuario = (Persona) session.getAttribute("usuario");

    if (usuario == null) {
        // Si no hay sesión, redirigir al login
        response.sendRedirect("login.html");
        return;
    }

    int idEmpresa = usuario.getIdEmpresa();
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Panel - SGRH</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #eef2f7;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .dashboard {
            background: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0px 4px 8px rgba(0,0,0,0.1);
            text-align: center;
            width: 400px;
        }
        h2 {
            margin-bottom: 20px;
            color: #333;
        }
        .btn {
            display: block;
            width: 100%;
            padding: 15px;
            margin: 10px 0;
            font-size: 16px;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            color: white;
            background-color: #007bff;
            text-decoration: none;
            transition: background 0.3s;
        }
        .btn:hover {
            background-color: #0056b3;
        }
        .info {
            margin-bottom: 20px;
            font-size: 14px;
            color: #555;
        }
    </style>
</head>
<body>
    <div class="dashboard">
        <h2>Bienvenido, <%= usuario.getNombre() %> <%= usuario.getApellido() %></h2>
        <div class="info">
            Empresa ID: <%= idEmpresa %> | Rol: <%= usuario.getRol() %>
        </div>

        <a href="asistenciaForm.jsp" class="btn">Asistencia</a>
        <a href="detalleNominaForm.jsp" class="btn">Nómina</a>
        <a href="reporteForm.jsp" class="btn">Reportes</a>        
        <a href="certificadoForm.jsp" class="btn">Certificados</a>
        <a href="personaForm.jsp" class="btn">Empleados</a>
        <a href="permisoForm.jsp" class="btn">Permisos</a>
        <a href="persona.jsp" class="btn">Registra Persona</a>
        <a href="logout.jsp" class="btn">Cerrar Sesión</a>

    </div>
</body>
</html>
