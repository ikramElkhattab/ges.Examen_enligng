<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entites.Etudiant, entites.User, java.util.List, entites.Matiere, entites.Examen, entites.Resultat" %>
<%@page import="services.MatiereService, services.ExamenService, services.ResultatService" %>

<%
    User user = (User) session.getAttribute("user");
    if (user == null || !(user instanceof Etudiant)) {
        response.sendRedirect(request.getContextPath() + "/login");
        return;
    }

    Etudiant etudiant = (Etudiant) user;

    MatiereService matiereService = new MatiereService();
    ExamenService examenService = new ExamenService();
    ResultatService resultatService = new ResultatService();

    List<Matiere> matieres = matiereService.findByEtudiant(etudiant);
    List<Examen> examens = examenService.findByEtudiant(etudiant);
    List<Resultat> resultats = resultatService.findResultatsByEtudiant(etudiant);
    
    // Calcul simplifié de la moyenne (avec gestion des erreurs)
    double moyenneNotes = 0;
    int countNotes = 0;
    
    try {
        if (resultats != null && !resultats.isEmpty()) {
            for (Resultat r : resultats) {
                if (r != null && r.getNote() > 0) {
                    moyenneNotes += r.getNote();
                    countNotes++;
                }
            }
            if (countNotes > 0) {
                moyenneNotes = moyenneNotes / countNotes;
            }
        }
    } catch (Exception e) {
        // Ignorer les erreurs de calcul
        moyenneNotes = 0;
    }
    
    String moyenneFormatee = String.format("%.2f", moyenneNotes);
    
    // Date actuelle pour le calendrier
    java.util.Calendar cal = java.util.Calendar.getInstance();
    int currentMonth = cal.get(java.util.Calendar.MONTH);
    int currentYear = cal.get(java.util.Calendar.YEAR);
    int currentDay = cal.get(java.util.Calendar.DAY_OF_MONTH);
    
    // Nombre de jours dans le mois actuel
    cal.set(java.util.Calendar.DAY_OF_MONTH, 1);
    int firstDayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
    int numberOfDays = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
    
    // Noms des mois en français
    String[] monthNames = {"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", 
                          "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"};
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Espace Étudiant</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
        <style>
            :root {
                --primary-color: #6c5ce7;
                --secondary-color: #a29bfe;
                --accent-color: #00cec9;
                --success-color: #00b894;
                --warning-color: #fdcb6e;
                --danger-color: #ff7675;
                --light-bg: #f8f9fa;
            }
            
            body {
                background-color: var(--light-bg);
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            }
            
            .dashboard-container {
                padding: 20px;
            }
            
            .navbar-custom {
                background: linear-gradient(to right, var(--primary-color), var(--secondary-color));
            }
            
            .welcome-header {
                background: linear-gradient(to right, var(--primary-color), var(--secondary-color));
                color: white;
                border-radius: 10px;
                padding: 20px;
                margin-bottom: 20px;
                box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            }
            
            .stats-card {
                background-color: white;
                border-radius: 10px;
                padding: 20px;
                margin-bottom: 20px;
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.05);
                transition: transform 0.3s ease;
                height: 100%;
            }
            
            .stats-card:hover {
                transform: translateY(-5px);
            }
            
            .stats-card .icon {
                font-size: 2rem;
                margin-bottom: 10px;
                color: var(--primary-color);
            }
            
            .stats-card .number {
                font-size: 2rem;
                font-weight: bold;
                color: var(--primary-color);
            }
            
            .card-header {
                border-bottom: none;
                font-weight: 600;
                display: flex;
                align-items: center;
            }
            
            .card-header i {
                margin-right: 10px;
            }
            
            .subject-item, .exam-item {
                background-color: #f8f9fa;
                border-radius: 8px;
                padding: 12px;
                margin-bottom: 10px;
                border-left: 4px solid var(--primary-color);
            }
            
            .exam-item {
                border-left-color: var(--warning-color);
            }
            
            .result-table {
                width: 100%;
                border-collapse: separate;
                border-spacing: 0;
                border-radius: 8px;
                overflow: hidden;
            }
            
            .result-table th {
                background-color: var(--secondary-color);
                color: white;
                padding: 12px;
            }
            
            .result-table td {
                padding: 12px;
                border-top: 1px solid #e9ecef;
            }
            
            .result-table tr:hover {
                background-color: #f8f9fa;
            }
            
            .badge-grade {
                padding: 5px 10px;
                border-radius: 20px;
                font-weight: normal;
            }
            
            .user-avatar {
                width: 40px;
                height: 40px;
                background-color: white;
                border-radius: 50%;
                display: flex;
                align-items: center;
                justify-content: center;
                color: var(--primary-color);
                font-weight: bold;
            }
            
            /* Styles pour le calendrier */
            .calendar {
                background-color: white;
                border-radius: 10px;
                overflow: hidden;
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.05);
            }
            
            .calendar-header {
                background: linear-gradient(to right, var(--primary-color), var(--secondary-color));
                color: white;
                padding: 15px;
                text-align: center;
                font-weight: bold;
            }
            
            .calendar-body {
                padding: 15px;
            }
            
            .calendar-weekdays {
                display: grid;
                grid-template-columns: repeat(7, 1fr);
                text-align: center;
                font-weight: bold;
                margin-bottom: 10px;
                color: #666;
            }
            
            .calendar-days {
                display: grid;
                grid-template-columns: repeat(7, 1fr);
                gap: 5px;
            }
            
            .calendar-day {
                aspect-ratio: 1;
                display: flex;
                align-items: center;
                justify-content: center;
                border-radius: 50%;
                font-size: 0.9rem;
                position: relative;
                cursor: pointer;
            }
            
            .calendar-day.today {
                background-color: var(--primary-color);
                color: white;
                font-weight: bold;
            }
            
            .calendar-day.has-event::after {
                content: '';
                position: absolute;
                bottom: 3px;
                left: 50%;
                transform: translateX(-50%);
                width: 5px;
                height: 5px;
                border-radius: 50%;
                background-color: var(--warning-color);
            }
            
            .calendar-day.has-exam::after {
                background-color: var(--danger-color);
            }
            
            .calendar-day:hover {
                background-color: #f0f0f0;
            }
            
            .event-list {
                margin-top: 15px;
                max-height: 200px;
                overflow-y: auto;
            }
            
            .event-item {
                padding: 10px;
                border-radius: 5px;
                margin-bottom: 5px;
                font-size: 0.9rem;
                display: flex;
                align-items: center;
            }
            
            .event-item.exam {
                background-color: rgba(255, 118, 117, 0.1);
                border-left: 3px solid var(--danger-color);
            }
            
            .event-item.course {
                background-color: rgba(108, 92, 231, 0.1);
                border-left: 3px solid var(--primary-color);
            }
            
            .event-dot {
                width: 8px;
                height: 8px;
                border-radius: 50%;
                margin-right: 8px;
            }
            
            .event-dot.exam {
                background-color: var(--danger-color);
            }
            
            .event-dot.course {
                background-color: var(--primary-color);
            }
            
            /* Style pour les onglets */
            .nav-tabs .nav-link {
                border: none;
                color: #6c757d;
                font-weight: 500;
                padding: 10px 15px;
                border-radius: 0;
            }
            
            .nav-tabs .nav-link.active {
                color: var(--primary-color);
                border-bottom: 3px solid var(--primary-color);
                font-weight: bold;
            }
            
            .nav-tabs .nav-link:hover:not(.active) {
                border-bottom: 3px solid #e9ecef;
            }
        </style>
    </head>
    <body>
        <!-- NAVBAR -->
        <nav class="navbar navbar-dark navbar-custom">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">
                    <i class="fas fa-graduation-cap me-2"></i>
                    Espace Étudiant
                </a>
                <div class="d-flex align-items-center">
                    <div class="text-white me-3">Bienvenue, <%= etudiant.getNom() %></div>
                    <div class="user-avatar">
                        <%= etudiant.getNom().length() > 0 ? etudiant.getNom().substring(0, 1).toUpperCase() : "?" %>
                    </div>
                    <a href="<%= request.getContextPath() %>/logout" class="btn btn-sm btn-outline-light ms-3">
                        <i class="fas fa-sign-out-alt me-1"></i> Déconnexion
                    </a>
                </div>
            </div>
        </nav>

        <div class="container dashboard-container">
            <!-- HEADER DE BIENVENUE -->
            <div class="welcome-header">
                <div class="row align-items-center">
                    <div class="col-md-8">
                        <h2>Bonjour, <%= etudiant.getNom() %></h2>
                        <p class="mb-0">Bienvenue dans votre espace personnel</p>
                    </div>
                    <div class="col-md-4 text-md-end">
                        <span class="small">Aujourd'hui: <%= new java.text.SimpleDateFormat("dd MMMM yyyy").format(new java.util.Date()) %></span>
                    </div>
                </div>
            </div>

            <!-- NAVIGATION PAR ONGLETS -->
            <ul class="nav nav-tabs mb-4">
                <li class="nav-item">
                    <a class="nav-link active" id="dashboard-tab" data-bs-toggle="tab" href="#dashboard">Tableau de bord</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="calendar-tab" data-bs-toggle="tab" href="#calendar-section">Calendrier</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="results-tab" data-bs-toggle="tab" href="#results-section">Résultats</a>
                </li>
            </ul>

            <div class="tab-content">
                <!-- ONGLET TABLEAU DE BORD -->
                <div class="tab-pane fade show active" id="dashboard">
                    <!-- STATISTIQUES -->
                    <div class="row mb-4">
                        <div class="col-md-4 mb-3">
                            <div class="stats-card text-center">
                                <div class="icon">
                                    <i class="fas fa-book-open text-primary"></i>
                                </div>
                                <div class="number"><%= matieres != null ? matieres.size() : 0 %></div>
                                <div class="label">Matières inscrites</div>
                            </div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <div class="stats-card text-center">
                                <div class="icon">
                                    <i class="fas fa-tasks text-warning"></i>
                                </div>
                                <div class="number"><%= examens != null ? examens.size() : 0 %></div>
                                <div class="label">Examens prévus</div>
                            </div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <div class="stats-card text-center">
                                <div class="icon">
                                    <i class="fas fa-chart-line text-success"></i>
                                </div>
                                <div class="number"><%= moyenneFormatee %></div>
                                <div class="label">Moyenne générale</div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <!-- MES MATIÈRES -->
                        <div class="col-md-6 mb-4">
                            <div class="card">
                                <div class="card-header bg-white">
                                    <i class="fas fa-book text-primary"></i>
                                    Mes matières
                                </div>
                                <div class="card-body">
                                    <% if (matieres != null && !matieres.isEmpty()) {
                                        for (Matiere m : matieres) { %>
                                        <div class="subject-item">
                                            <h6 class="mb-0"><%= m.getNom() %></h6>
                                        </div>
                                        <% }
                                    } else { %>
                                        <p class="text-muted">Aucune matière inscrite.</p>
                                    <% } %>
                                </div>
                            </div>
                        </div>

                        <!-- MES EXAMENS -->
                        <div class="col-md-6 mb-4">
                            <div class="card">
                                <div class="card-header bg-white">
                                    <i class="fas fa-clipboard-list text-warning"></i>
                                    Mes examens
                                </div>
                                <div class="card-body">
                                    <% if (examens != null && !examens.isEmpty()) {
                                        for (Examen ex : examens) { %>
                                        <div class="exam-item">
                                            <h6 class="mb-1"><%= ex.getMatiere().getNom() %></h6>
                                            <small class="text-muted">Durée: <%= ex.getDurée() %> minutes</small>
                                        </div>
                                        <% }
                                    } else { %>
                                        <p class="text-muted">Aucun examen prévu.</p>
                                    <% } %>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
                <!-- ONGLET CALENDRIER -->
                <div class="tab-pane fade" id="calendar-section">
                    <div class="row">
                        <div class="col-md-8 mb-4">
                            <div class="calendar">
                                <div class="calendar-header">
                                    <div class="d-flex justify-content-between align-items-center">
                                        <button class="btn btn-sm text-white" onclick="prevMonth()">
                                            <i class="fas fa-chevron-left"></i>
                                        </button>
                                        <span id="currentMonthYear"><%= monthNames[currentMonth] %> <%= currentYear %></span>
                                        <button class="btn btn-sm text-white" onclick="nextMonth()">
                                            <i class="fas fa-chevron-right"></i>
                                        </button>
                                    </div>
                                </div>
                                <div class="calendar-body">
                                    <div class="calendar-weekdays">
                                        <div>Dim</div>
                                        <div>Lun</div>
                                        <div>Mar</div>
                                        <div>Mer</div>
                                        <div>Jeu</div>
                                        <div>Ven</div>
                                        <div>Sam</div>
                                    </div>
                                    <div class="calendar-days" id="calendarDays">
                                        <% 
                                        // Jours vides avant le premier jour du mois
                                        for (int i = 1; i < firstDayOfWeek; i++) { %>
                                            <div></div>
                                        <% }
                                        
                                        // Jours du mois
                                        for (int day = 1; day <= numberOfDays; day++) {
                                            boolean isToday = day == currentDay;
                                            boolean hasEvent = (day % 3 == 0); // Simulation d'événements
                                            boolean hasExam = (day % 7 == 0); // Simulation d'examens
                                            
                                            String classNames = "calendar-day";
                                            if (isToday) classNames += " today";
                                            if (hasEvent) classNames += " has-event";
                                            if (hasExam) classNames += " has-exam";
                                        %>
                                            <div class="<%= classNames %>" 
                                                 onclick="showEvents(<%= day %>, <%= currentMonth %>, <%= currentYear %>)">
                                                <%= day %>
                                            </div>
                                        <% } %>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="col-md-4 mb-4">
                            <div class="card">
                                <div class="card-header bg-white">
                                    <i class="fas fa-calendar-day text-primary"></i>
                                    <span id="selectedDate">Événements du jour</span>
                                </div>
                                <div class="card-body">
                                    <div class="mb-3">
                                        <div class="d-flex align-items-center mb-2">
                                            <div class="event-dot exam"></div>
                                            <span>Examens</span>
                                        </div>
                                        <div class="d-flex align-items-center">
                                            <div class="event-dot course"></div>
                                            <span>Cours</span>
                                        </div>
                                    </div>
                                    
                                    <div class="event-list" id="eventList">
                                        <!-- Les événements seront chargés ici dynamiquement -->
                                        <p class="text-muted">Sélectionnez une date pour voir les événements.</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
                <!-- ONGLET RÉSULTATS -->
                <div class="tab-pane fade" id="results-section">
                    <div class="card mb-4">
                        <div class="card-header bg-white">
                            <i class="fas fa-chart-bar text-danger"></i>
                            Mes résultats
                        </div>
                        <div class="card-body">
                            <% if (resultats != null && !resultats.isEmpty()) { %>
                                <div class="table-responsive">
                                    <table class="result-table">
                                        <thead>
                                            <tr>
                                                <th>Matière</th>
                                                <th>Note</th>
                                                <th>Appréciation</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <% for (Resultat r : resultats) {
                                                String appreciation = "";
                                                String badgeColor = "bg-danger";
                                                
                                                try {
                                                    double note = r.getNote();
                                                    if (note >= 16) {
                                                        appreciation = "Excellent";
                                                        badgeColor = "bg-success";
                                                    } else if (note >= 14) {
                                                        appreciation = "Très bien";
                                                        badgeColor = "bg-primary";
                                                    } else if (note >= 12) {
                                                        appreciation = "Bien";
                                                        badgeColor = "bg-info";
                                                    } else if (note >= 10) {
                                                        appreciation = "Assez bien";
                                                        badgeColor = "bg-warning";
                                                    } else {
                                                        appreciation = "À améliorer";
                                                        badgeColor = "bg-danger";
                                                    }
                                                } catch (Exception e) {
                                                    appreciation = "Non évalué";
                                                    badgeColor = "bg-secondary";
                                                }
                                            %>
                                            <tr>
                                                <td><%= r.getExamen() != null && r.getExamen().getMatiere() != null ? r.getExamen().getMatiere().getNom() : "Matière inconnue" %></td>
                                                <td><%= r.getNote() %>/20</td>
                                                <td><span class="badge <%= badgeColor %> badge-grade"><%= appreciation %></span></td>
                                            </tr>
                                            <% } %>
                                        </tbody>
                                    </table>
                                </div>
                            <% } else { %>
                                <p class="text-muted">Aucun résultat disponible.</p>
                            <% } %>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
        <script>
            // Fonctions pour le calendrier
            let currentMonth = <%= currentMonth %>;
            let currentYear = <%= currentYear %>;
            
            function prevMonth() {
                currentMonth--;
                if (currentMonth < 0) {
                    currentMonth = 11;
                    currentYear--;
                }
                updateCalendar();
            }
            
            function nextMonth() {
                currentMonth++;
                if (currentMonth > 11) {
                    currentMonth = 0;
                    currentYear++;
                }
                updateCalendar();
            }
            
            function updateCalendar() {
                const monthNames = ["Janvier", "Février", "Mars", "Avril", "Mai", "Juin", 
                                   "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"];
                
                document.getElementById('currentMonthYear').textContent = monthNames[currentMonth] + ' ' + currentYear;
                
                const daysInMonth = new Date(currentYear, currentMonth + 1, 0).getDate();
                const firstDay = new Date(currentYear, currentMonth, 1).getDay();
                
                let daysHTML = '';
                
                // Jours vides avant le premier jour du mois
                for (let i = 0; i < firstDay; i++) {
                    daysHTML += '<div></div>';
                }
                
                // Jours du mois
                const today = new Date();
                const isCurrentMonth = today.getMonth() === currentMonth && today.getFullYear() === currentYear;
                const currentDay = today.getDate();
                
                for (let day = 1; day <= daysInMonth; day++) {
                    const isToday = isCurrentMonth && day === currentDay;
                    const hasEvent = (day % 3 === 0); // Simulation d'événements
                    const hasExam = (day % 7 === 0); // Simulation d'examens
                    
                    let classNames = "calendar-day";
                    if (isToday) classNames += " today";
                    if (hasEvent) classNames += " has-event";
                    if (hasExam) classNames += " has-exam";
                    
                    daysHTML += `<div class="${classNames}" onclick="showEvents(${day}, ${currentMonth}, ${currentYear})">${day}</div>`;
                }
                
                document.getElementById('calendarDays').innerHTML = daysHTML;
            }
            
            function showEvents(day, month, year) {
                const monthNames = ["Janvier", "Février", "Mars", "Avril", "Mai", "Juin", 
                               "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"];
                
                document.getElementById('selectedDate').textContent = `Événements du ${day} ${monthNames[month]} ${year}`;
                
                // Générer des événements simulés basés sur le jour
                let eventsHTML = '';
                
                if (day % 7 === 0) {
                    <% if (examens != null && !examens.isEmpty()) {
                        for (int i = 0; i < Math.min(2, examens.size()); i++) { 
                            Examen exam = examens.get(i);
                    %>
                    eventsHTML += `
                        <div class="event-item exam">
                            <div class="event-dot exam"></div>
                            <div>
                                <strong>Examen: <%= exam.getMatiere().getNom() %></strong><br>
                                <small>Durée: <%= exam.getDurée() %> min</small>
                            </div>
                        </div>
                    `;
                    <% } 
                    } %>
                }
                
                if (day % 3 === 0) {
                    <% if (matieres != null && !matieres.isEmpty()) {
                        for (int i = 0; i < Math.min(2, matieres.size()); i++) { 
                            Matiere matiere = matieres.get(i);
                    %>
                    eventsHTML += `
                        <div class="event-item course">
                            <div class="event-dot course"></div>
                            <div>
                                <strong>Cours: <%= matiere.getNom() %></strong><br>
                                <small>9h00 - 12h00, Salle A${day}${Math.floor(Math.random() * 10)}</small>
                            </div>
                        </div>
                    `;
                    <% } 
                    } %>
                }
                
                if (eventsHTML === '') {
                    eventsHTML = '<p class="text-muted">Aucun événement prévu pour cette date.</p>';
                }
                
                document.getElementById('eventList').innerHTML = eventsHTML;
            }
            
            // Initialiser avec les événements du jour actuel
            document.addEventListener('DOMContentLoaded', function() {
                const today = new Date();
                showEvents(today.getDate(), today.getMonth(), today.getFullYear());
            });
        </script>
    </body>
</html>