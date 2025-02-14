<%-- 
    Document   : profile
    Created on : Feb 8, 2025, 2:06:37 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <title>TechPhone</title>

        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>

        <!-- Slick -->
        <link type="text/css" rel="stylesheet" href="css/slick.css"/>
        <link type="text/css" rel="stylesheet" href="css/slick-theme.css"/>

        <!-- nouislider -->
        <link type="text/css" rel="stylesheet" href="css/nouislider.min.css"/>

        <!-- Font Awesome Icon -->
        <link rel="stylesheet" href="css/font-awesome.min.css">

        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="css/style.css"/>

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <style>
            .profile-container {
                display: flex;
                background-color: #f5f5f5;
                min-height: calc(100vh - 60px); /* Adjust based on your header height */
            }

            .sidebar {
                width: 240px;
                background-color: white;
                padding: 20px;
                border-right: 1px solid #eee;
            }

            .profile-header {
                display: flex;
                align-items: center;
                gap: 15px;
                padding-bottom: 20px;
                border-bottom: 1px solid #eee;
                margin-bottom: 20px;
            }

            .profile-avatar {
                width: 50px;
                height: 50px;
                border-radius: 50%;
                background-color: #eee;
            }

            .username {
                font-weight: bold;
            }

            .edit-profile {
                font-size: 0.9em;
                color: #666;
            }

            .sidebar-nav .menu-item {
                display: flex;
                align-items: center;
                gap: 10px;
                padding: 12px 0;
                color: #333;
                cursor: pointer;
            }

            .sidebar-nav .menu-item.active {
                color: #ee4d2d;
            }

            .main-content {
                flex: 1;
                padding: 20px;
            }

            .content-box {
                background-color: white;
                padding: 30px;
                border-radius: 8px;
                max-width: 800px;
                margin: 0 auto;
            }

            h1 {
                font-size: 24px;
                margin-bottom: 10px;
            }

            .subtitle {
                color: #666;
                margin-bottom: 30px;
            }

            .profile-form .form-group {
                margin-bottom: 20px;
                display: grid;
                grid-template-columns: 120px 1fr auto;
                align-items: center;
                gap: 20px;
            }

            .form-label {
                font-weight: 500;
            }

            .form-input {
                padding: 8px 12px;
                border: 1px solid #ddd;
                border-radius: 4px;
                font-size: 14px;
            }

            .change-link {
                color: #05a;
                text-decoration: none;
                font-size: 0.9em;
            }

            .change-link:hover {
                text-decoration: underline;
            }

            .avatar-upload {
                display: flex;
                justify-content: center;
                margin-top: 20px;
                margin-left: 180px;
            }

            .avatar-container {
                text-align: center;
            }

            .large-avatar {
                width: 150px;
                height: 150px;
                border-radius: 50%;
                background-color: #eee;
                margin-bottom: 10px;
                overflow: hidden; /* Ẩn phần ảnh thừa */
                display: flex;
                justify-content: center;
                align-items: center;
            }

            .large-avatar img {
                width: 100%;
                height: 100%;
                object-fit: cover; /* Cắt ảnh để vừa khung tròn */
                border-radius: 50%;
            }

            .upload-button {
                background-color: white;
                border: 1px solid #ddd;
                padding: 8px 16px;
                border-radius: 1px;
                cursor: pointer;
            }

            .save-button {
                background-color: #ee4d2d;
                color: white;
                border: none;
                padding: 10px 24px;
                border-radius: 4px;
                cursor: pointer;
                font-weight: 500;
                margin-top: 20px;
            }

            .file-info {
                color: #666;
                font-size: 12px;
                margin-top: 5px;
                margin-left: -90px;
            }

            @media (max-width: 768px) {
                .profile-container {
                    flex-direction: column;
                }

                .sidebar {
                    width: 100%;
                    border-right: none;
                    border-bottom: 1px solid #eee;
                }

                .profile-form .form-group {
                    grid-template-columns: 1fr;
                    gap: 8px;
                }
            }
        </style>

    </head>

    <body>
        <div class="main-wrapper">
            <%@include file="../component/header.jsp" %>


        </div>
        <div class="profile-container">
            <div class="sidebar">
                <div class="profile-header">
                    
                    <div>
                        <div class="username"></div>

                        <h2>${sessionScope.user.fullName}</h2>

                        <div class="edit-profile">Edit profile</div>
                    </div>
                </div>
                <nav class="sidebar-nav">
                    <div class="menu-item">
                        <span class="icon">🔔</span>
                        <span>Notification</span>
                    </div>
                    <div class="menu-item active">
                        <span class="icon">👤</span>
                        <span>My profile</span>
                    </div>
                    <div class="menu-item">
                        <span class="icon">📄</span>
                        <span>Puchase order</span>
                    </div>
                    <div class="menu-item">
                        <span class="icon">🔒</span>
                        <span>Change password</span>
                    </div>
                </nav>
            </div>

            <main class="main-content">
                <div class="content-box">
                    <h1>My Profile</h1>
                    <p class="subtitle">Quản lý thông tin hồ sơ để bảo mật tài khoản</p>

                    <form class="profile-form">
                        <div class="form-group">
                            <label class="form-label">Full Name</label>
                            <input type="text" class="form-input" value="${sessionScope.user.fullName}">
                            <a href="#" class="change-link">Change</a>
                        </div>

                        <div class="form-group">
                            <label class="form-label">Email</label>
                            <input type="email" class="form-input" value="${sessionScope.user.email}">
                            <a href="#" class="change-link">Change</a>
                        </div>

                        <div class="form-group">
                            <label class="form-label">Phone</label>
                            <input type="tel" class="form-input" value="${sessionScope.user.phone}">
                            <a href="#" class="change-link">Change</a>
                        </div>

                        <div class="form-group">
                            <label class="form-label">Address</label>
                            <input type="text" class="form-input" value="${sessionScope.user.address}">
                            <a href="#" class="change-link">Change</a>
                        </div>

                        <div class="avatar-upload">
                            <div class="avatar-container">
                                <div class="large-avatar" id="choose-image">
                                    <img id="avatar-preview" src="" alt="Avatar Preview" style="display: none;">
                                </div>
                                <input type="file" id="avatar-input" accept="image/jpeg, image/png" hidden>
                                <p class="file-info">Maximum file size: 1 MB</p>
                                <p class="file-info">Formats: JPEG, PNG</p>
                            </div>
                        </div>

                        <button type="submit" class="save-button">Save</button>
                    </form>
                </div>
            </main>
        </div>
        <script>
            document.getElementById("choose-image").addEventListener("click", function () {
                document.getElementById("avatar-input").click();
            });

            document.getElementById("avatar-input").addEventListener("change", function (event) {
                const file = event.target.files[0];
                if (file && file.size <= 1 * 1024 * 1024) { // Kiểm tra dung lượng tối đa 1MB
                    const reader = new FileReader();
                    reader.onload = function (e) {
                        const img = document.getElementById("avatar-preview");
                        img.src = e.target.result;
                        img.style.display = "block";
                    };
                    reader.readAsDataURL(file);
                } else {
                    alert("File size exceeds 1MB or invalid format.");
                }
            });
        </script>                  

    </body>
</html>
