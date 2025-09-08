<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    // Invalidar la sesión
    if (session != null) {
        session.invalidate();
    }

    // Redirigir al login
    response.sendRedirect("login.html");
%>
