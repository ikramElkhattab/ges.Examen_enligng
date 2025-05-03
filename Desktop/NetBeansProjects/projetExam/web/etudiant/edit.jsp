<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="entites.Etudiant" %>
<%@ page import="services.EtudiantService" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    EtudiantService service = new EtudiantService();
    Etudiant e = service.findById(id);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier Étudiant</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .card {
            border-radius: 1rem;
            box-shadow: 0 0 25px rgba(0, 0, 0, 0.05);
        }
    </style>
</head>
<body>
<div class="container py-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card p-4">
                <h3 class="text-center text-primary mb-4">
                    <i class="bi bi-pencil-square me-2"></i>Modifier Étudiant
                </h3>
                <form action="../EtudiantController" method="post">
                    <input type="hidden" name="action" value="update" />
                    <input type="hidden" name="id" value="<%= e.getId() %>" />

                    <div class="mb-3">
                        <label class="form-label">Nom</label>
                        <div class="input-group">
                            <span class="input-group-text"><i class="bi bi-person-fill"></i></span>
                            <input type="text" name="nom" value="<%= e.getNom() %>" class="form-control" required />
                        </div>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Email</label>
                        <div class="input-group">
                            <span class="input-group-text"><i class="bi bi-envelope-fill"></i></span>
                            <input type="email" name="email" value="<%= e.getEmail() %>" class="form-control" required />
                        </div>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Mot de passe</label>
                        <div class="input-group">
                            <span class="input-group-text"><i class="bi bi-lock-fill"></i></span>
                            <input type="password" name="motDePasse" value="<%= e.getMotDePasse() %>" class="form-control" required />
                        </div>
                    </div>

                    <div class="d-flex justify-content-between">
                        <button type="submit" class="btn btn-primary">
                            <i class="bi bi-check-circle-fill me-1"></i> Enregistrer
                        </button>
                        <a href="list.jsp" class="btn btn-secondary">
                            <i class="bi bi-arrow-left-circle-fill me-1"></i> Annuler
                        </a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
