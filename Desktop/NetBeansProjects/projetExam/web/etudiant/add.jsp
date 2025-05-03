<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter un Étudiant</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" rel="stylesheet">
    <style>
        body {
            background-color: #f1f4f9;
        }
        .card {
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.05);
            border-radius: 1rem;
        }
        .form-label {
            font-weight: 500;
        }
    </style>
</head>
<body>
    <div class="container py-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card p-4">
                    <h3 class="text-center text-primary mb-4">
                        <i class="bi bi-person-plus-fill me-2"></i>Ajouter un Étudiant
                    </h3>
                    <form action="../EtudiantController" method="post">
                        <input type="hidden" name="action" value="add" />
                        
                        <div class="mb-3">
                            <label class="form-label">Nom</label>
                            <div class="input-group">
                                <span class="input-group-text"><i class="bi bi-person-fill"></i></span>
                                <input type="text" name="nom" class="form-control" placeholder="Nom complet" required />
                            </div>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Email</label>
                            <div class="input-group">
                                <span class="input-group-text"><i class="bi bi-envelope-fill"></i></span>
                                <input type="email" name="email" class="form-control" placeholder="exemple@mail.com" required />
                            </div>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Mot de passe</label>
                            <div class="input-group">
                                <span class="input-group-text"><i class="bi bi-lock-fill"></i></span>
                                <input type="password" name="motDePasse" class="form-control" placeholder="••••••••" required />
                            </div>
                        </div>

                        <div class="d-flex justify-content-between">
                            <button type="submit" class="btn btn-success">
                                <i class="bi bi-check-circle-fill me-1"></i> Ajouter
                            </button>
                            <a href="list.jsp" class="btn btn-secondary">
                                <i class="bi bi-x-circle-fill me-1"></i> Annuler
                            </a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
