<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login Page</title>
        <link rel="stylesheet" href="styles.css">
        <style>
            /* CSS cho trang ??ng nh?p */
            body {
                font-family: Arial, sans-serif;
                background-color: #000; /* ??t n?n trang thành màu ?en */
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                margin: 0;
            }

            .login-form {
                background-color: white;
                padding: 60px; /* T?ng padding cho khung */
                border-radius: 10px; /* T?ng ?? cong c?a vi?n */
                box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2); /* T?ng ?? bóng */
                max-width: 500px; /* T?ng chi?u r?ng t?i ?a */
                width: 100%;
                text-align: center;
            }

            h2 {
                margin-bottom: 30px;
                font-size: 28px; /* Kích th??c tiêu ?? */
                font-weight: bold;
            }

            .form-group {
                margin-bottom: 20px; /* Kho?ng cách gi?a các ô nh?p */
                text-align: left;
            }

            .form-group label {
                font-weight: bold;
                margin-bottom: 5px;
                font-size: 16px; /* Kích th??c ch? cho nhãn */
            }

            .form-group input {
                width: 100%;
                padding: 15px; /* Padding cho ô nh?p */
                border: 1px solid #ccc;
                border-radius: 5px;
                font-size: 18px; /* Kích th??c ch? cho ô nh?p */
            }

            button[type="submit"] {
                background-color: #007bff;
                color: white;
                border: none;
                padding: 15px 20px; /* Padding cho nút */
                font-size: 18px; /* Kích th??c ch? cho nút */
                cursor: pointer;
                border-radius: 5px;
                width: 100%;
                margin-top: 10px;
            }

            button[type="submit"]:hover {
                background-color: #0056b3;
            }

            .forgot-password {
                margin-top: 10px;
                display: block;
                font-size: 14px;
            }

            .signup-link {
                margin-top: 20px;
                font-size: 14px;
            }
            .google-login-button {
                border-radius: 20px;
                box-sizing: border-box;
                padding: 10px 15px;
                box-shadow: rgba(0, 0, 0, 0.16) 0px 10px 36px 0px,
                    rgba(0, 0, 0, 0.06) 0px 0px 0px 1px;
                cursor: pointer;
                display: flex;
                justify-content: center;
                align-items: center;
                font-family: "Lucida Sans", "Lucida Sans Regular", "Lucida Grande", "Lucida Sans Unicode", Geneva, Verdana, sans-serif;
                font-size: 16px; /* T?ng kích th??c ch? */
                gap: 5px;
                border: 2px solid #747474;
            }

            .google-icon {
                font-size: 18px;
                margin-bottom: 1px;
            }
            .alert-message {
                color: red;
                font-weight: bold;
                text-align: center;
                margin-bottom: 15px;
            }
        </style>
    </head>
    <body>
        <div class="login-form">
            <h2>Welcome TechPhone</h2>
            <!-- Hi?n th? thông báo l?i -->
            <c:if test="${not empty notification}">
                <div class="alert-message ${typeNoti}">
                    ${notification}
                </div>
            </c:if>
            <form action="login" method="POST">
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" required>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" required>
                </div>
                <a a href="forgotpass.jsp" class="forgot-password">Forgot Password?</a>
                <button type="submit">Log in</button>
            </form>

            <div class="signup-link">
                <p>Don't have an account? <a href="signup.jsp">Sign Up</a></p>
            </div>

            <!-- Google Login Button -->
            <div class="google-login-button">

                <svg stroke="currentColor" fill="currentColor" stroke-width="0" version="1.1" x="0px" y="0px" class="google-icon" viewBox="0 0 48 48" height="1em" width="1em" xmlns="http://www.w3.org/2000/svg">
                <path fill="#FFC107" d="M43.611,20.083H42V20H24v8h11.303c-1.649,4.657-6.08,8-11.303,8c-6.627,0-12-5.373-12-12c0-6.627,5.373-12,12-12c3.059,0,5.842,1.154,7.961,3.039l5.657-5.657C34.046,6.053,29.268,4,24,4C12.955,4,4,12.955,4,24c0,11.045,8.955,20,20,20c11.045,0,20-8.955,20-20C44,22.659,43.862,21.35,43.611,20.083z"></path>
                <path fill="#FF3D00" d="M6.306,14.691l6.571,4.819C14.655,15.108,18.961,12,24,12c3.059,0,5.842,1.154,7.961,3.039l5.657-5.657C34.046,6.053,29.268,4,24,4C16.318,4,9.656,8.337,6.306,14.691z"></path>
                <path fill="#4CAF50" d="M24,44c5.166,0,9.86-1.977,13.409-5.192l-6.19-5.238C29.211,35.091,26.715,36,24,36c-5.202,0-9.619-3.317-11.283-7.946l-6.522,5.025C9.505,39.556,16.227,44,24,44z"></path>
                <path fill="#1976D2" d="M43.611,20.083H42V20H24v8h11.303c-0.792,2.237-2.231,4.166-4.087,5.571c0.001-0.001,0.002-0.001,0.003-0.002l6.19,5.238C36.971,39.205,44,34,44,24C44,22.659,43.862,21.35,43.611,20.083z"></path>
                </svg>
                <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:9999/tech/login-google&response_type=code
                   &client_id=147346089567-9rionk6cojq99g9fn5k876v50q7s1coe.apps.googleusercontent.com&approval_prompt=force">Login with Google</a>
                </a
            </div>
        </div>
    </body>


</html>