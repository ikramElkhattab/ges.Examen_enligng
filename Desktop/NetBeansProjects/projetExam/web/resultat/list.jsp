<%-- 
    Document   : list
    Created on : 3 mai 2025, 05:01:39
    Author     : hp
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="entites.Resultat, services.ResultatService" %>
<%
    ResultatService service = new ResultatService();
    List<Resultat> resultats = service.findAll();
%>
<!DOCTYPE html>
<html>
<head>
    <title>Liste des Résultats</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">
    <h2>Liste des Résultats</h2>
    <a href="add.jsp" class="btn btn-success mb-3">Ajouter un résultat</a>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>Étudiant</th>
                <th>Examen</th>
                <th>Note</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="res" items="${resultats}">
            <tr>
                <td>${res.getEtudiant().getNom()}</td>
                <td>${res.getExamen().getMatiere().getNom()}</td>
                <td>${res.getNote()}</td>
                <td>
                    <a href="edit.jsp?id=${res.getId()}" class="btn btn-warning btn-sm">Modifier</a>
                    <a href="../ResultatController?action=delete&id=${res.getId()}" class="btn btn-danger btn-sm" onclick="return confirm('Confirmer la suppression ?')">Supprimer</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
