<%-- 
    Document   : edit
    Created on : 3 mai 2025, 04:35:41
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="entites.Matiere" %>
<%@ page import="services.MatiereService" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    MatiereService service = new MatiereService();
    Matiere m = service.findById(id);
%>
<!DOCTYPE html>
<html>
<head>
    <title>Modifier Matière</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Modifier Matière</h2>
    <form action="../MatiereController" method="post">
        <input type="hidden" name="action" value="update" />
        <input type="hidden" name="id" value="<%= m.getId() %>" />
        <div class="mb-3">
            <label>Nom</label>
            <input type="text" name="nom" value="<%= m.getNom() %>" class="form-control" required />
        </div>
        <button type="submit" class="btn btn-primary">Enregistrer</button>
        <a href="list.jsp" class="btn btn-secondary">Annuler</a>
    </form>
</div>
</body>
</html>
