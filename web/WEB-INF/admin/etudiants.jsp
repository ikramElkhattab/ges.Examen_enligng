<%-- 
    Document   : etudiants
    Created on : 18 avr. 2025, 16:58:32
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Étudiants</title>
    <style>
        /* Styles similaires à votre dashboard */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        .actions {
            display: flex;
            gap: 10px;
        }
        .actions a {
            padding: 5px 10px;
            text-decoration: none;
            color: white;
            border-radius: 3px;
        }
        .edit {
            background-color: #2196F3;
        }
        .delete {
            background-color: #f44336;
        }
        .add-button {
            display: inline-block;
            margin: 20px 0;
            padding: 10px 15px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 4px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Liste des Étudiants</h2>
        <a href="${pageContext.request.contextPath}/admin/etudiants/create" class="add-button">Ajouter un Étudiant</a>
        
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nom</th>
                    <th>Email</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${etudiants}" var="etudiant">
                    <tr>
                        <td>${etudiant.id}</td>
                        <td>${etudiant.nom}</td>
                        <td>${etudiant.email}</td>
                        <td class="actions">
                            <a href="${pageContext.request.contextPath}/admin/etudiants/edit?id=${etudiant.id}" class="edit">Modifier</a>
                            <a href="${pageContext.request.contextPath}/admin/etudiants/delete?id=${etudiant.id}" class="delete" 
                               onclick="return confirm('Êtes-vous sûr de vouloir supprimer cet étudiant?')">Supprimer</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <div style="margin-top: 20px;">
            <a href="${pageContext.request.contextPath}/admin/dashboard">Retour au tableau de bord</a>
        </div>
    </div>
</body>
</html>