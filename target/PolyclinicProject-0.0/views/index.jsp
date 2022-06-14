<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>IPolyclinic</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <style>
        body{
        	min-width: 320px;
        	font-size: 18px;
        	font-family: 'Playfair Display', serif;
        	color: #626262;
        }
        img{
        	max-width: 100%;
        	height: auto;
        }
        a{
        	color: #b4ad9e;
        }
        a:hover{
        	color: #898377;
        }

        header .navbar-light{
        	background-color: #fff;
        }
        header .navbar-brand{
        	font-family: 'Inconsolata', monospace;
        	font-size: 30px;
        	color: #000;
        	text-transform: uppercase;
        }
        header .nav-item{
        	text-transform: uppercase;
        	margin-left: 50px;
        }
        header .nav-item a::after{
        	content: '';
        	display: block;
        	width: 100%;
        	background-color: #ccc;
        	height: 1px;
        	transform: scale(0);
        	transition: all .3s;
        }
        header .nav-item a:hover::after{
        	transform: scale(1);
        }

    </style>

</head>
<header>


    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/">IPolyclinic</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
            <sec:authorize access="isAuthenticated()">
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ">
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/cabinet">Личный кабинет</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/logout">Выйти</a>
                        </li>
                    </ul>
                </div>
            </sec:authorize>
            <sec:authorize access="!isAuthenticated()">
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ">
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/registration">Регистрация</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/signIn">Вход</a>
                        </li>
                    </ul>
                </div>
            </sec:authorize>
        </div>
    </nav>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>

</header>

<body>

</body>

</html>


