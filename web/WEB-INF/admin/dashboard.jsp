<%-- 
    Document   : dashboard
    Created on : 18 avr. 2025, 15:54:57
    Author     : hp
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tableau de bord Admin</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
        }
        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
        }
        header {
            background-color: #333;
            color: white;
            padding: 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        h1 {
            margin: 0;
        }
        .user-info {
            display: flex;
            align-items: center;
        }
        .user-info p {
            margin-right: 20px;
        }
        .logout {
            background-color: #e74c3c;
            color: white;
            border: none;
            padding: 10px 15px;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
        }
        .content {
            background-color: white;
            padding: 20px;
            margin-top: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .dashboard-title {
            color: #333;
            margin-bottom: 20px;
        }
        .card {
            background-color: white;
            border-radius: 5px;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
            padding: 20px;
            margin-bottom: 20px;
        }
        .card h3 {
            color: #333;
            margin-top: 0;
        }
        .navigation {
            margin-top: 20px;
        }
        .navigation a {
            display: inline-block;
            margin-right: 10px;
            padding: 10px 15px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 4px;
        }
        .navigation a:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <header>
        <h1>Administration</h1>
        <div class="user-info">
            <p>Bienvenue, ${admin.nom} (${admin.role})</p>
            <a href="${pageContext.request.contextPath}/logout" class="logout">Déconnexion</a>
        </div>
    </header>
    
    <div class="container">
        <div class="content">
            <h2 class="dashboard-title">Tableau de bord Administrateur</h2>
            
            <div class="card">
                <h3>Gestion des Étudiants</h3>
                <p>Gérez les comptes étudiants, leurs inscriptions et leurs résultats.</p>
                <div class="navigation">
                    <a href="${pageContext.request.contextPath}/admin/etudiants">Liste des Étudiants</a>
                    <a href="${pageContext.request.contextPath}/admin/etudiants/create">Ajouter un Étudiant</a>
                </div>
            </div>
            
            <div class="card">
                <h3>Gestion des Examens</h3>
                <p>Créez et gérez les examens pour les différentes matières.</p>
                <div class="navigation">
                    <a href="${pageContext.request.contextPath}/admin/examens">Liste des Examens</a>
                    <a href="${pageContext.request.contextPath}/admin/examens/create">Créer un Examen</a>
                </div>
            </div>
            
            <div class="card">
                <h3>Gestion des Matières</h3>
                <p>Ajoutez et modifiez les matières disponibles.</p>
                <div class="navigation">
                    <a href="${pageContext.request.contextPath}/admin/matieres">Liste des Matières</a>
                    <a href="${pageContext.request.contextPath}/admin/matieres/create">Ajouter une Matière</a>
                </div>
            </div>
            
            <div class="card">
                <h3>Gestion des Résultats</h3>
                <p>Consultez et modifiez les résultats des examens.</p>
                <div class="navigation">
                    <a href="${pageContext.request.contextPath}/admin/resultats">Tous les Résultats</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
