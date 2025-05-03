<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="entites.Etudiant"%>
<%@page import="services.EtudiantService"%>
<%
    EtudiantService service = new EtudiantService();
    List<Etudiant> etudiants = service.findAll();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Étudiants</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .table thead {
            background: linear-gradient(90deg, #6a11cb, #2575fc);
            color: white;
        }
        .btn-add {
            background: linear-gradient(90deg, #43cea2, #185a9d);
            color: white;
        }
        .btn-add:hover {
            opacity: 0.9;
        }
    </style>
</head>
<body>
    <div class="container py-5">
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h2 class="text-primary"><i class="bi bi-people-fill me-2"></i>Liste des Étudiants</h2>
            <a href="add.jsp" class="btn btn-add">
                <i class="bi bi-plus-circle me-1"></i> Ajouter un étudiant
            </a>
        </div>

        <div class="table-responsive">
            <table class="table table-hover table-bordered align-middle">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nom</th>
                        <th>Email</th>
                        <th style="width: 160px;">Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <% if (etudiants != null && !etudiants.isEmpty()) { 
                        for (Etudiant e : etudiants) { %>
                            <tr>
                                <td><%= e.getId() %></td>
                                <td><%= e.getNom() %></td>
                                <td><%= e.getEmail() %></td>
                                <td>
                                    <a href="edit.jsp?id=<%= e.getId() %>" class="btn btn-warning btn-sm me-1">
                                        <i class="bi bi-pencil-square"></i> Modifier
                                    </a>
                                    <a href="${pageContext.request.contextPath}/EtudiantController?action=delete&id=<%= e.getId() %>" 
                                       class="btn btn-danger btn-sm"
                                       onclick="return confirm('Voulez-vous vraiment supprimer cet étudiant ?');">
                                       <i class="bi bi-trash-fill"></i> Supprimer
                                    </a>
                                </td>
                            </tr>
                    <%  } 
                    } else { %>
                        <tr>
                            <td colspan="4" class="text-center text-muted">Aucun étudiant trouvé.</td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
