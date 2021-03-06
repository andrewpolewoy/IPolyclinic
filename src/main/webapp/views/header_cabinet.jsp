<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<header>

    <style>
        .parent {
            margin: 10px;
        }
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


    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/">IPolyclinic</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <sec:authorize access="hasAnyAuthority('PATIENT', 'DOCTOR', 'ADMIN')">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/cabinet/medical_card">??????. ??????????</a>
                    </li>
                </sec:authorize>
                <sec:authorize access="hasAuthority('PATIENT')">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/cabinet/my_tickets">?????? ????????????</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/cabinet/ticket_order_patient">?????????? ????????????</a>
                    </li>
                </sec:authorize>
                <sec:authorize access="hasAnyAuthority('PATIENT', 'DOCTOR')">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/cabinet/users">???????????? ????????????</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/cabinet/redact_user">?????????????????????????? ??????????????</a>
                    </li>
                </sec:authorize>
                <sec:authorize access="hasAnyAuthority('DOCTOR', 'ADMIN')">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/cabinet/ticket_order">?????????? ????????????</a>
                    </li>
                </sec:authorize>

                <sec:authorize access="hasAuthority('ADMIN')">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/cabinet/tickets">?????????? ????????????</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/cabinet/validate">??????????????????</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/cabinet/doctor">??????????</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/cabinet/specializations">??????????????????????????</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/cabinet/departments">??????????????????</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/cabinet/change_user_role">?????????????????????????? ??????????????</a>
                    </li>

                </sec:authorize>
            </ul>
        </div>
 <!--        <div class="parent">
                <sec:authorize access="hasAuthority('PATIENT')">
                    <a>??????????????</a>
                </sec:authorize>
                <sec:authorize access="hasAuthority('ADMIN')">
                    <a>??????????</a>
                </sec:authorize>
                <sec:authorize access="hasAuthority('DOCTOR')">
                    <a>????????????</a>
                </sec:authorize>
                </div>
 -->
        <div class="parent">
            <a>
                <sec:authentication property="principal.username" />
            </a>
            <a hidden id="principalId">
                <sec:authentication property="principal.id" />
            </a>
            <a hidden id="principalRole">
                <sec:authentication property="principal.roles" />
            </a>
        </div>
    </nav></header>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>

