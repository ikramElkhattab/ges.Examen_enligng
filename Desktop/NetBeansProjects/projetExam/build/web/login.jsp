<%-- 
    Document   : login
    Created on : 17 avr. 2025, 16:09:23
    Author     : hp
--%>
<%@page import="entites.Admin, entites.Etudiant, entites.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Connexion - Gestion des Examens</title>
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
        
        .login-card {
            width: 100%;
            max-width: 900px;
            min-height: 500px;
            background: var(--white);
            border-radius: 20px;
            box-shadow: 0 15px 30px rgba(0, 0, 0, 0.1);
            overflow: hidden;
            display: flex;
        }
        
        .login-left {
            width: 45%;
            background: linear-gradient(135deg, var(--primary-color) 0%, var(--primary-dark) 100%);
            color: var(--white);
            padding: 50px 30px;
            position: relative;
            overflow: hidden;
            display: flex;
            flex-direction: column;
            justify-content: center;
        }
        
        .login-left::before,
        .login-left::after {
            content: '';
            position: absolute;
            background: rgba(255, 255, 255, 0.1);
            border-radius: 50%;
        }
        
        .login-left::before {
            width: 300px;
            height: 300px;
            bottom: -100px;
            left: -100px;
        }
        
        .login-left::after {
            width: 150px;
            height: 150px;
            bottom: 50px;
            right: -50px;
        }
        
        .login-welcome {
            position: relative;
            z-index: 10;
        }
        
        .login-welcome h1 {
            font-size: 2.5rem;
            font-weight: 700;
            margin-bottom: 15px;
            letter-spacing: 1px;
        }
        
        .login-welcome h2 {
            font-size: 1.5rem;
            font-weight: 600;
            margin-bottom: 20px;
        }
        
        .login-welcome p {
            font-size: 0.95rem;
            line-height: 1.6;
            opacity: 0.9;
        }
        
        .login-right {
            width: 55%;
            padding: 50px 40px;
            display: flex;
            flex-direction: column;
            justify-content: center;
        }
        
        .login-header {
            margin-bottom: 40px;
        }
        
        .login-header h3 {
            font-size: 1.8rem;
            font-weight: 600;
            color: var(--dark-text);
            margin-bottom: 10px;
        }
        
        .login-header p {
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
        
        .remember-forgot {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 25px;
        }
        
        .remember-me {
            display: flex;
            align-items: center;
        }
        
        .remember-me input {
            margin-right: 8px;
        }
        
        .forgot-password {
            color: var(--primary-color);
            text-decoration: none;
            font-size: 0.9rem;
            transition: all 0.3s;
        }
        
        .forgot-password:hover {
            color: var(--primary-dark);
            text-decoration: underline;
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
        
        .btn-outline {
            border: 1px solid #dddddd;
            background-color: transparent;
            color: var(--dark-text);
            height: 55px;
            font-size: 1rem;
            font-weight: 500;
            border-radius: 8px;
            margin-top: 15px;
            transition: all 0.3s;
        }
        
        .btn-outline:hover {
            border-color: var(--primary-color);
            color: var(--primary-color);
        }
        
        .create-account {
            text-align: center;
            margin-top: 25px;
            color: var(--light-text);
            font-size: 0.95rem;
        }
        
        .create-account a {
            color: var(--primary-color);
            text-decoration: none;
            font-weight: 500;
            transition: all 0.3s;
        }
        
        .create-account a:hover {
            color: var(--primary-dark);
            text-decoration: underline;
        }
        
        .alert {
            border-radius: 8px;
            padding: 15px;
            margin-bottom: 25px;
            animation: fadeIn 0.5s;
        }
        
        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(-10px); }
            to { opacity: 1; transform: translateY(0); }
        }
        
        @media (max-width: 768px) {
            .login-card {
                flex-direction: column;
                max-width: 500px;
            }
            
            .login-left,
            .login-right {
                width: 100%;
                padding: 30px;
            }
            
            .login-left {
                min-height: 200px;
            }
        }
    </style>
</head>
<body>
    <div class="login-card">
        <div class="login-left">
            <div class="login-welcome">
                <h1>BIENVENUE</h1>
                <h2>PLATEFORME D'EXAMENS EN LIGNE</h2>
                <p>Accédez à votre espace personnel pour consulter vos examens, soumettre vos réponses et suivre vos résultats en temps réel.</p>
            </div>
        </div>
        
        <div class="login-right">
            <div class="login-header">
                <h3>Connexion</h3>
                <p>Veuillez vous connecter pour accéder à votre compte</p>
            </div>
            
            <% if (request.getAttribute("erreur") != null) { %>
                <div class="alert alert-danger">
                    <i class="fas fa-exclamation-circle me-2"></i>
                    <%= request.getAttribute("erreur") %>
                </div>
            <% } %>
            
            <% if (request.getParameter("logout") != null) { %>
                <div class="alert alert-success">
                    <i class="fas fa-check-circle me-2"></i>
                    Vous avez été déconnecté avec succès.
                </div>
            <% } %>
            
            <form action="LoginController" method="post">
                <div class="form-group">
                    <i class="fas fa-user input-icon"></i>
                    <input type="email" class="form-control" id="email" name="email" placeholder="Adresse email" required>
                </div>
                
                <div class="form-group">
                    <i class="fas fa-lock input-icon"></i>
                    <input type="password" class="form-control" id="motDePasse" name="motDePasse" placeholder="Mot de passe" required>
                    <span class="password-toggle" onclick="togglePassword()">
                        <i id="passwordIcon" class="fas fa-eye"></i>
                    </span>
                </div>
                
                <div class="remember-forgot">
                    <div class="remember-me">
                        <input type="checkbox" id="remember" name="remember">
                        <label for="remember">Se souvenir de moi</label>
                    </div>
                    <a href="#" class="forgot-password">Mot de passe oublié ?</a>
                </div>
                
                <button type="submit" class="btn btn-primary w-100">Se connecter</button>
                
                <button type="button" class="btn btn-outline w-100">
                    <i class="fas fa-key me-2"></i>Connexion avec un code d'accès
                </button>
            </form>
            
            <div class="create-account">
                <p>Vous n'avez pas de compte ? <a href="register.jsp">S'inscrire</a></p>
            </div>
        </div>
    </div>
    
    <script>
        // Animation d'entrée pour la carte de connexion
        document.addEventListener('DOMContentLoaded', function() {
            const loginCard = document.querySelector('.login-card');
            loginCard.style.opacity = '0';
            loginCard.style.transform = 'translateY(20px)';
            
            setTimeout(function() {
                loginCard.style.opacity = '1';
                loginCard.style.transform = 'translateY(0)';
                loginCard.style.transition = 'all 0.5s ease';
            }, 200);
        });
        
        // Fonction pour afficher/masquer le mot de passe
        function togglePassword() {
            const passwordInput = document.getElementById('motDePasse');
            const passwordIcon = document.getElementById('passwordIcon');
            
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