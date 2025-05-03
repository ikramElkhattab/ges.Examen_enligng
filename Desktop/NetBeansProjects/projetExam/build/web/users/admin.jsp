<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entites.Admin, entites.User" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null || !(user instanceof Admin)) {
        response.sendRedirect(request.getContextPath() + "/login");
        return;
    }
    Admin admin = (Admin) user;
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Espace Administrateur</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <style>
        body {
            background-color: #f4f6f9;
            font-family: 'Segoe UI', sans-serif;
        }
        .sidebar {
            min-height: 100vh;
            background: linear-gradient(180deg, #6a11cb 0%, #2575fc 100%);
            color: white;
        }
        .sidebar a {
            color: white;
            text-decoration: none;
            display: block;
            padding: 15px 20px;
            border-bottom: 1px solid rgba(255,255,255,0.1);
        }
        .sidebar a:hover {
            background-color: rgba(255,255,255,0.1);
        }
        .dashboard-card {
            border-radius: 15px;
            color: white;
            padding: 20px;
            height: 150px;
        }
        .bg-gradient-primary { background: linear-gradient(135deg, #1d2b64, #f8cdda); }
        .bg-gradient-success { background: linear-gradient(135deg, #43cea2, #185a9d); }
        .bg-gradient-warning { background: linear-gradient(135deg, #f7971e, #ffd200); }
        .bg-gradient-danger { background: linear-gradient(135deg, #e52d27, #b31217); }
    </style>
</head>
<body>
    <div class="d-flex">
        <!-- Sidebar -->
        <div class="sidebar p-3">
            <div class="text-center mb-4">
                <i class="bi bi-person-circle fs-1"></i>
                <h5 class="mt-2">Admin</h5>
            </div>
            <a href="#"><i class="bi bi-house-door-fill me-2"></i>Accueil</a>
            <a href="#"><i class="bi bi-bell-fill me-2"></i>Notifications</a>
            <a href="#"><i class="bi bi-card-checklist me-2"></i>Tâches</a>
            <a href="#"><i class="bi bi-chat-dots-fill me-2"></i>Messages</a>
            <a href="#"><i class="bi bi-bar-chart-line-fill me-2"></i>Graphiques</a>
            <a href="#"><i class="bi bi-gear-fill me-2"></i>Paramètres</a>
            <a href="${pageContext.request.contextPath}/logout"><i class="bi bi-box-arrow-right me-2"></i>Déconnexion</a>
        </div>

        <!-- Main Content -->
        <div class="container-fluid p-4">
            <h2 class="mb-4">Bienvenue, <%= admin.getNom() %></h2>

            <!-- Dashboard Cards -->
            <div class="row g-4 mb-4">
                <div class="col-md-3">
                    <div class="dashboard-card bg-gradient-primary">
                        <h5>Total Étudiants</h5>
                        <h3>120</h3>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="dashboard-card bg-gradient-success">
                        <h5>Total Matières</h5>
                        <h3>8</h3>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="dashboard-card bg-gradient-warning">
                        <h5>Total Examens</h5>
                        <h3>20</h3>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="dashboard-card bg-gradient-danger">
                        <h5>Résultats publiés</h5>
                        <h3>88%</h3>
                    </div>
                </div>
            </div>

            <!-- Gestion Cards -->
            <div class="row row-cols-1 row-cols-md-2 g-4">
                <div class="col">
                    <div class="card h-100 border-primary">
                        <div class="card-body">
                            <h5 class="card-title">Gestion des Étudiants</h5>
                            <p class="card-text">Ajoutez, modifiez ou supprimez les comptes des étudiants.</p>
                            <a href="${pageContext.request.contextPath}/etudiant/list.jsp" class="btn btn-primary">Gérer</a>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card h-100 border-success">
                        <div class="card-body">
                            <h5 class="card-title">Gestion des Matières</h5>
                            <p class="card-text">Organisez les matières disponibles pour les examens.</p>
                            <a href="${pageContext.request.contextPath}/matiere/list.jsp" class="btn btn-success">Gérer</a>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card h-100 border-warning">
                        <div class="card-body">
                            <h5 class="card-title">Gestion des Examens</h5>
                            <p class="card-text">Planifiez, modifiez ou supprimez des examens.</p>
                            <a href="${pageContext.request.contextPath}/examen/list.jsp" class="btn btn-warning">Gérer</a>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card h-100 border-danger">
                        <div class="card-body">
                            <h5 class="card-title">Résultats</h5>
                            <p class="card-text">Consultez les résultats des examens des étudiants.</p>
                            <a href="${pageContext.request.contextPath}/resultat/list.jsp" class="btn btn-danger">Gérer</a>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Graphique -->
            <div class="card mt-5">
                <div class="card-header bg-light">
                    <strong>Statistiques des Examens par Matière</strong>
                </div>
                <div class="card-body">
                    <canvas id="examChart" height="120"></canvas>
                </div>
            </div>
        </div>
    </div>

    <!-- Chart.js -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script>
        const ctx = document.getElementById('examChart').getContext('2d');
        const examChart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: ['Maths', 'Physique', 'Chimie', 'Informatique'],
                datasets: [{
                    label: 'Nombre d\'examens',
                    data: [5, 3, 4, 6],
                    backgroundColor: ['#0d6efd', '#198754', '#ffc107', '#dc3545'],
                    borderRadius: 5
                }]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: { display: false },
                },
                scales: {
                    y: {
                        beginAtZero: true,
                        ticks: { stepSize: 1 }
                    }
                }
            }
        });
    </script>
</body>
</html>
