<%-- 
    Document   : edit
    Created on : 3 mai 2025, 05:04:01
    Author     : hp
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="entites.Resultat, services.ResultatService" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    ResultatService service = new ResultatService();
    Resultat r = service.findById(id);
%>
<!DOCTYPE html>
<html>
<head>
    <title>Modifier Résultat</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">
    <h2>Modifier Résultat</h2>
    <form action="../ResultatController" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="<%= r.getId() %>">

        <div class="mb-3">
            <label for="note" class="form-label">Note</label>
            <input type="number" step="0.01" name="note" class="form-control" required value="<%= r.getNote() %>">
        </div>

        <button type="submit" class="btn btn-warning">Modifier</button>
    </form>
</body>
</html>
