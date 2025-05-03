<%-- 
    Document   : add
    Created on : 3 mai 2025, 04:41:46
    Author     : hp
    Updated on : 3 mai 2025
    Description: Page d'ajout d'un nouvel examen avec validation des données
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entites.Examen"%>
<%@page import="services.MatiereService"%>
<%@page import="java.util.List"%>
<%@page import="entites.Matiere"%>
<%@page errorPage="error.jsp"%>
<%
    // Récupération du service et des données
    MatiereService matiereService = new MatiereService();
    List<Matiere> matieres = matiereService.findAll();

    // Récupération de l'examen en cas d'échec de validation
    Examen examen = (Examen) request.getAttribute("examen");

    // Récupération des éventuels messages d'erreur
    String errorMessage = (String) request.getAttribute("errorMessage");

    // Déterminer si nous sommes en mode modification
    boolean isEditMode = examen != null && examen.getId() != 0;
    String pageTitle = isEditMode ? "Modifier un Examen" : "Ajouter un Examen";
    String actionLabel = isEditMode ? "Modifier" : "Ajouter";
    String actionValue = isEditMode ? "update" : "add";
%>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title><%= pageTitle%></title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
        <style>
            .required::after {
                content: " *";
                color: red;
            }
        </style>
    </head>
    <body>
        <div class="container mt-5">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    
                    <li class="breadcrumb-item"><a href="list.jsp">Examens</a></li>
                    <li class="breadcrumb-item active" aria-current="page"><%= pageTitle%></li>
                </ol>
            </nav>

            <div class="card">
                <div class="card-header bg-primary text-white">
                    <h2 class="card-title mb-0"><%= pageTitle%></h2>
                </div>
                <div class="card-body">
                    <% if (errorMessage != null && !errorMessage.isEmpty()) {%>
                    <div class="alert alert-danger alert-dismissible fade show" role="alert">
                        <%= errorMessage%>
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>
                    <% }%>

                    <form action="../ExamenController" method="post" class="needs-validation" novalidate>
                        <input type="hidden" name="action" value="<%= actionValue%>" />
                        <% if (isEditMode) {%>
                        <input type="hidden" name="id" value="<%= examen.getId()%>" />
                        <% }%>

                        <div class="mb-3">
                            <label for="duree" class="form-label required">Durée (en minutes)</label>
                            <input type="number" 
                                   class="form-control" 
                                   id="duree" 
                                   name="duree" 
                                   required 
                                   min="15" 
                                   max="240" 
                                   value="<%= (examen != null ? examen.getDurée() : "60")%>"
                                   aria-describedby="dureeHelp">
                            <div class="invalid-feedback">
                                Veuillez saisir une durée valide (entre 15 et 240 minutes)
                            </div>
                            <div id="dureeHelp" class="form-text">
                                La durée de l'examen doit être comprise entre 15 et 240 minutes.
                            </div>
                        </div>

                        <div class="mb-3">
                            <label for="matiereId" class="form-label required">Matière</label>
                            <select name="matiereId" id="matiereId" class="form-select" required>
                                <option value="">-- Sélectionnez une matière --</option>
                                <%

                                    Integer selectedMatiereId = (examen != null && examen.getMatiere() != null)
                                            ? examen.getMatiere().getId()
                                            : null;

                                    for (Matiere m : matieres) {
                                        boolean isSelected = selectedMatiereId != null
                                                && selectedMatiereId.equals(m.getId());
                                %>
                                <option value="<%= m.getId()%>" <%= isSelected ? "selected" : ""%>>
                                    <%= m.getNom()%>
                                </option>
                                <% }%>
                            </select>
                            <div class="invalid-feedback">
                                Veuillez sélectionner une matière
                            </div>
                        </div>

                        <div class="d-flex justify-content-between mt-4">
                            <a href="list.jsp" class="btn btn-secondary">
                                <i class="bi bi-arrow-left"></i> Retour
                            </a>
                            <button type="submit" class="btn btn-success">
                                <i class="bi bi-check-lg"></i> <%= actionLabel%>
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- Bootstrap Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Icons -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
        <!-- Form validation script -->
        <script>
                    // Exemple de validation côté client avec Bootstrap
                            (function() {
                            'use strict';
                                    // Fetch all forms we want to apply validation to
                                    const forms = document.querySelectorAll('.needs-validation');
                                    // Loop over forms and prevent submission if invalid
                                    Array.from(forms).forEach(form = > {
                            form.addEventListener('submit', event = > {
                            if (!form.checkValidity()) {
                            event.preventDefault();
                                    event.stopPropagation();
                            }
                            form.classList.add('was-validated');
                            }, false);
                            });
                            })();
        </script>
    </body>
</html>