<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!doctype html>

<html lang="ru">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <meta name="theme-color" content="#7952b3">
    <title>Редактор профиля</title>
    <style>
                .block {
                    width: 250px;
                    height: 200px;
                    position: fixed;
                    top: 50%;
                    left: 50%;
                    margin-top: -100px;
                    margin-left: -100px;
                }

            </style>
</head>

<body>

<%@include file="header_cabinet.jsp" %>

<div class="block">
    <form id="form" name="form">
        <div class="form-floating">
            <input type="email" class="form-control" id="floatingInput" name="eMail" required>
            <label for="floatingInput">e-mail</label>
        </div>

        <div class="form-floating">
            <input type="password" class="form-control" id="floatingPassword" name="password">
            <label for="floatingPassword">Новый пароль</label>
        </div>

        <div class="form-floating">
            <input type="tel" class="form-control" id="floatingTel" name="phoneNumber" required>
            <label for="floatingTel">Телефон</label>
        </div>
        <button class="w-100 btn btn-lg btn-secondary" type="submit" id="put-button" form="form">Сохранить</button>


    </form>




    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
    <script>
                    $(document).ready(function() {
                        var id = $('#principalId').text();

                        $.ajax({
                            url: 'http://localhost:8080/users/' + id,
                            type: 'get',
                            success: function(response) {
                                var phoneNumber = response.user.phoneNumber;
                                $("[name='eMail']").val(response.user.eMail);
                                $("[name='phoneNumber']").val(response.user.phoneNumber);
                            }
                        });
                    });


                    function handleFormSubmit(event) {
                        event.preventDefault();

                        var id = $('#principalId').text();


                        var url = 'http://localhost:8080/users/' + id;
                        var eMail = $("[name='eMail']").val();
                        var password = $("[name='password']").val();
                        var phoneNumber = $("[name='phoneNumber']").val();
                        var roles = $("input[name='roles']:checked").val();

                        const formJSON = {
                            eMail: eMail,
                            password: password,
                            phoneNumber: phoneNumber

                        };

                        const stringJson = JSON.stringify(formJSON);
                        $.ajax({
                            url: url,
                            type: 'put',
                            dataType: "json",
                            data: stringJson,
                            contentType: 'application/json',
                            statusCode: {
                                200: function() {
                                    alert('Аккаунт обновлен');
                                    window.location.reload();
                                }
                            }
                        });
                    }
                    document.getElementById('form').addEventListener('submit', handleFormSubmit);

                </script>
</div>
</body>

</html>
