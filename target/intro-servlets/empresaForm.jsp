<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registro de Empresa y Gerente</title>
    <style>
        body { 
            font-family: Arial, sans-serif; 
            background: #eef2f7; 
            margin: 0; 
            padding: 20px; 
        }
        .container { 
            background: #fff; 
            padding: 25px; 
            border-radius: 10px; 
            box-shadow: 0px 4px 10px rgba(0,0,0,0.1); 
            max-width: 800px; 
            margin: auto; 
        }
        h2 { 
            text-align: center; 
            margin-bottom: 20px; 
        }
        form { 
            display: flex; 
            flex-direction: column; 
        }
        .section { 
            margin-bottom: 20px; 
            padding: 15px; 
            border: 1px solid #ddd; 
            border-radius: 8px; 
            background: #f9f9f9; 
        }
        .section h3 { 
            margin-top: 0; 
            margin-bottom: 15px; 
            text-align: center; 
        }

        /* Grid de 2 columnas */
        .grid { 
            display: grid; 
            grid-template-columns: 1fr 1fr; 
            gap: 15px 20px; 
        }

        label { 
            font-weight: bold; 
            display: block; 
            margin-bottom: 5px; 
        }
        input, select { 
            width: 100%; 
            padding: 10px; 
            border: 1px solid #ccc; 
            border-radius: 6px; 
        }
        input[type="submit"] { 
            background: #28a745; 
            color: white; 
            font-size: 16px; 
            border: none; 
            border-radius: 6px; 
            cursor: pointer; 
            margin-top: 20px; 
            padding: 12px; 
        }
        input[type="submit"]:hover { 
            background: #218838; 
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Registrar Empresa y Gerente</h2>
        <form method="post" action="EmpresaServlet">
            <input type="hidden" name="accion" value="registrarEmpresaGerente">

            <!-- Datos Empresa -->
            <div class="section">
                <h3>Datos de la Empresa</h3>
                <div class="grid">
                    <div>
                        <label>Nombre:</label>
                        <input type="text" name="nombre_empresa" required>
                    </div>
                    <div>
                        <label>Teléfono:</label>
                        <input type="text" name="telefono_empresa">
                    </div>
                    <div>
                        <label>Dirección:</label>
                        <input type="text" name="direccion_empresa">
                    </div>
                    <div>
                        <label>Ciudad:</label>
                        <input type="text" name="ciudad_empresa">
                    </div>
                    <div>
                        <label>País:</label>
                        <input type="text" name="pais_empresa">
                    </div>
                </div>
            </div>

            <!-- Datos Gerente -->
            <div class="section">
                <h3>Datos del Gerente</h3>
                <div class="grid">
                    <div>
                        <label>Nombre:</label>
                        <input type="text" name="nombre" required>
                    </div>
                    <div>
                        <label>Apellido:</label>
                        <input type="text" name="apellido" required>
                    </div>
                    <div>
                        <label>Correo:</label>
                        <input type="email" name="correo" required>
                    </div>
                    <div>
                        <label>Teléfono:</label>
                        <input type="text" name="telefono">
                    </div>
                    <div>
                        <label>Dirección:</label>
                        <input type="text" name="direccion">
                    </div>
                    <div>
                        <label>Documento de Identidad:</label>
                        <input type="text" name="documento_identidad" required>
                    </div>
                    <div>
                        <label>Fecha de Nacimiento:</label>
                        <input type="date" name="fecha_nacimiento" required>
                    </div>
                    <div>
                        <label>Tipo de Contrato:</label>
                        <select name="tipo_contrato" required>
                            <option value="TERMINO_INDEFINIDO">Término indefinido</option>
                            <option value="TERMINO_FIJO">Término fijo</option>
                            <option value="PRESTACION_DE_SERVICIOS">Prestación de servicios</option>
                        </select>
                    </div>
                    <div style="grid-column: span 2;">
                        <label>Contraseña:</label>
                        <input type="password" name="contrasena" required>
                    </div>
                </div>
            </div>

            <input type="submit" value="Registrar Empresa y Gerente">
        </form>
    </div>
</body>
</html>
