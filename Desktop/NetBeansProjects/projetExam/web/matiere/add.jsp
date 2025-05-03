<%-- 
    Document   : add
    Created on : 3 mai 2025, 04:35:12
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Ajouter une Matière</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Ajouter une Matière</h2>
    <form action="../MatiereController" method="post">
        <input type="hidden" name="action" value="add" />
        <div class="mb-3">
            <label>Nom de la matière</label>
            <input type="text" name="nom" class="form-control" required />
        </div>
        <button type="submit" class="btn btn-success">Ajouter</button>
        <a href="list.jsp" class="btn btn-secondary">Annuler</a>
    </form>
</div>
</body>
</html>
