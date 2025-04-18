<%-- 
    Document   : admin
    Created on : 19 avr. 2025, 00:00:04
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entites.Admin, entites.User" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null || !(user instanceof Admin)) {
        response.sendRedirect(request.getContextPath() + "/login");
        return;
    }
    Admin admin = (Admin) user;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Espace Administrateur</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-danger">
            <div class="container">
                <a class="navbar-brand" href="#">Gestion des Examens</a>
                <div class="navbar-text ms-auto">
                    Bienvenue <strong><%= admin.getNom()%></strong>
                    <a href="${pageContext.request.contextPath}/logout" class="btn btn-sm btn-outline-light ms-3">Déconnexion</a>
                </div>
            </div>
        </nav>

        <div class="container mt-4">
            <h1>Espace Administrateur</h1>
            <div class="card mt-4">
                <div class="card-header">
                    Tableau de bord
                </div>
                <div class="card-body">
                    <p><strong>Email :</strong> <%= admin.getEmail()%></p>
                    <div class="mt-3">
                        <a href="" 
                           class="btn btn-primary">
                            <i class="bi bi-people-fill"></i> Gérer les utilisateurs
                        </a>                    
                        <a href="${pageContext.request.contextPath}/examen/page.jsp" class="btn btn-primary ms-2">Gérer les matiers</a>                </div>
                </div>
            </div>
        </div>
    </body>
</html>
