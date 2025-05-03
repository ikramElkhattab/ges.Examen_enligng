<%-- 
    Document   : resetPassword
    Created on : 3 mai 2025, 16:53:07
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Réinitialiser mot de passe - Gestion des Examens</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
    <style>
        :root {
            --primary-color: #0074d9;
            --primary-dark: #005bb5;
            --primary-light: #3498fc;
            --white: #ffffff;
            --dark-text: #333333;
            --light-text: #707070;
        }
        
        body {
            background-color: var(--primary-color);
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            margin: 0;
            padding: 20px;
        }
        
        .reset-card {
            width: 100%;
            max-width: 500px;
            min-height: 450px;
            background: var(--white);
            border-radius: 20px;
            box-shadow: 0 15px 30px rgba(0, 0, 0, 0.1);
            overflow: hidden;
            padding: 40px;
            animation: fadeIn 0.5s;
        }
        
        .reset-header {
            text-align: center;
            margin-bottom: 30px;
        }
        
        .reset-header h3 {
            font-size: 1.8rem;
            font-weight: 600;
            color: var(--dark-text);
            margin-bottom: 10px;
        }
        
        .reset-header p {
            color: var(--light-text);
            font-size: 0.95rem;
        }
        
        .form-group {
            margin-bottom: 25px;
            position: relative;
        }
        
        .form-control {
            height: 55px;
            border-radius: 8px;
            border: 1px solid #e0e0e0;
            padding-left: 45px;
            font-size: 1rem;
            transition: all 0.3s;
        }
        
        .form-control:focus {
            border-color: var(--primary-color);
            box-shadow: 0 0 0 3px rgba(0, 116, 217, 0.15);
        }
        
        .input-icon {
            position: absolute;
            left: 15px;
            top: 50%;
            transform: translateY(-50%);
            color: var(--light-text);
        }
        
        .password-toggle {
            position: absolute;
            right: 15px;
            top: 50%;
            transform: translateY(-50%);
            cursor: pointer;
            color: var(--light-text);
        }
        
        .btn-primary {
            background-color: var(--primary-color);
            border-color: var(--primary-color);
            height: 55px;
            font-size: 1rem;
            font-weight: 500;
            border-radius: 8px;
            transition: all 0.3s;
        }
        
        .btn-primary:hover {
            background-color: var(--primary-dark);
            border-color: var(--primary-dark);
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(0, 116, 217, 0.3);
        }
        
        .back-to-login {
            text-align: center;
            margin-top: 25px;
            color: var(--light-text);
            font-size: 0.95rem;
        }
        
        .back-to-login a {
            color: var(--primary-color);
            text-decoration: none;
            font-weight: 500;
            transition: all 0.3s;
        }
        
        .back-to-login a:hover {
            color: var(--primary-dark);
            text-decoration: underline;
        }
        
        .alert {
            border-radius: 8px;
            padding: 15px;
            margin-bottom: 25px;
            animation: fadeIn 0.5s;
        }
        
        .password-requirements {
            background-color: #f8f9fa;
            border-radius: 8px;
            padding: 15px;
            margin-bottom: 25px;
            font-size: 0.9rem;
            color: var(--light-text);
        }
        
        .password-requirements ul {
            padding-left: 20px;
            margin-bottom: 0;
        }
        
        .password-requirements li {
            margin-bottom: 5px;
        }
        
        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(-10px); }
            to { opacity: 1; transform: translateY(0); }
        }
    </style>
</head>
<body>
    <div class="reset-card">
        <div class="reset-header">
            <h3>Réinitialiser le mot de passe</h3>
            <p>Veuillez créer un nouveau mot de passe</p>
        </div>
        
        <% if (request.getAttribute("erreur") != null) { %>
            <div class="alert alert-danger">
                <i class="fas fa-exclamation-circle me-2"></i>
                <%= request.getAttribute("erreur") %>
            </div>
        <% } %>
        
        <form action="ResetPasswordController" method="post">
            <input type="hidden" name="token" value="<%= request.getParameter("token") %>">
            
            <div class="password-requirements">
                <strong>Exigences du mot de passe :</strong>
                <ul>
                    <li>Au moins 8 caractères</li>
                    <li>Au moins une lettre majuscule</li>
                    <li>Au moins un chiffre</li>
                    <li>Au moins un caractère spécial</li>
                </ul>
            </div>
            
            <div class="form-group">
                <i class="fas fa-lock input-icon"></i>
                <input type="password" class="form-control" id="nouveauMotDePasse" name="nouveauMotDePasse" placeholder="Nouveau mot de passe" required>
                <span class="password-toggle" onclick="togglePassword('nouveauMotDePasse', 'passwordIcon1')">
                    <i id="passwordIcon1" class="fas fa-eye"></i>
                </span>
            </div>
            
            <div class="form-group">
                <i class="fas fa-lock input-icon"></i>
                <input type="password" class="form-control" id="confirmMotDePasse" name="confirmMotDePasse" placeholder="Confirmer le mot de passe" required>
                <span class="password-toggle" onclick="togglePassword('confirmMotDePasse', 'passwordIcon2')">
                    <i id="passwordIcon2" class="fas fa-eye"></i>
                </span>
            </div>
            
            <button type="submit" class="btn btn-primary w-100">Changer le mot de passe</button>
        </form>
        
        <div class="back-to-login">
            <p>Vous vous souvenez de votre mot de passe ? <a href="login.jsp">Retour à la connexion</a></p>
        </div>
    </div>
    
    <script>
        // Animation d'entrée pour la carte de réinitialisation
        document.addEventListener('DOMContentLoaded', function() {
            const resetCard = document.querySelector('.reset-card');
            resetCard.style.opacity = '0';
            resetCard.style.transform = 'translateY(20px)';
            
            setTimeout(function() {
                resetCard.style.opacity = '1';
                resetCard.style.transform = 'translateY(0)';
                resetCard.style.transition = 'all 0.5s ease';
            }, 200);
        });
        
        // Fonction pour afficher/masquer le mot de passe
        function togglePassword(inputId, iconId) {
            const passwordInput = document.getElementById(inputId);
            const passwordIcon = document.getElementById(iconId);
            
            if (passwordInput.type === 'password') {
                passwordInput.type = 'text';
                passwordIcon.classList.remove('fa-eye');
                passwordIcon.classList.add('fa-eye-slash');
            } else {
                passwordInput.type = 'password';
                passwordIcon.classList.remove('fa-eye-slash');
                passwordIcon.classList.add('fa-eye');
            }
        }
    </script>
</body>
</html>
