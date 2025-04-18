<%-- 
    Document   : etudiant
    Created on : 19 avr. 2025, 00:00:12
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entites.Etudiant, entites.User" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null || !(user instanceof Etudiant)) {
        response.sendRedirect(request.getContextPath() + "/login");
        return;
    }
    Etudiant etudiant= (Etudiant) user;
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Espace Etudiant</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <div class="container">
            <a class="navbar-brand" href="#">Gestion des Examens</a>
            <div class="navbar-text ms-auto">
                Bienvenue <strong><%= etudiant.getNom() %></strong>
             <a href="${pageContext.request.contextPath}/logout" class="btn btn-sm btn-outline-light ms-3">Déconnexion</a>            </div>
        </div>
    </nav>
    
    <div class="container mt-4">
        <h1>Espace Etudiant</h1>
        <div class="card mt-4">
            <div class="card-header">
                Mon compte
            </div>
            <div class="card-body">
                <p><strong>Email :</strong> <%= etudiant.getEmail() %></p>
                <!-- Ajoutez ici le contenu spécifique au client -->
            </div>
        </div>
    </div>
</body>
</html>