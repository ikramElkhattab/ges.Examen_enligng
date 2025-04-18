<%-- 
    Document   : etudiant-form
    Created on : 18 avr. 2025, 16:59:26
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${etudiant != null ? 'Modifier' : 'Ajouter'} un Étudiant</title>
    <style>
        /* Styles similaires */
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input[type="text"],
        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }
        .submit-btn {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .back-btn {
            display: inline-block;
            margin-top: 20px;
            text-decoration: none;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>${etudiant != null ? 'Modifier' : 'Ajouter'} un Étudiant</h2>
        
        <form action="${etudiant != null ? pageContext.request.contextPath.concat('/admin/etudiants/edit?id=').concat(etudiant.id) : pageContext.request.contextPath.concat('/admin/etudiants/create')}" method="post">
            <div class="form-group">
                <label for="nom">Nom:</label>
                <input type="text" id="nom" name="nom" value="${etudiant != null ? etudiant.nom : ''}" required>
            </div>
           
            
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" value="${etudiant != null ? etudiant.email : ''}" required>
            </div>
            
            <div class="form-group">
                <label for="motDePasse">Mot de passe:${etudiant != null ? ' (laissez vide pour conserver)' : ''}</label>
                <input type="password" id="motDePasse" name="motDePasse" ${etudiant == null ? 'required' : ''}>
            </div>
            
            <button type="submit" class="submit-btn">Enregistrer</button>
        </form>
        
        <a href="${pageContext.request.contextPath}/admin/etudiants" class="back-btn">Retour à la liste</a>
    </div>
</body>
</html>
