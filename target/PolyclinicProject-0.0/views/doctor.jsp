<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html lang="ru">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Врачи</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <meta name="theme-color" content="#7952b3">

    <sec:authentication var="user" property="principal" />
    <style>
        label {
            display: block;
            text-align: left;
        }

        .block2 {
            float: right;
            padding: 20px;
        }

        .block3 {
            float: right;
            padding: 20px;
        }

        .block1 {
            padding: 20px;
            width: 50%;
            float: left;
        }

        .input-group {
            float: left;
            padding: 20px;
        }

        .col-md-4 {
            float: left;
            padding: 20px;
        }

        .col-md-6 {
            float: left;
            padding: 20px;
        }
    </style>

</head>

<body class="text-center">
<%@include file="header_cabinet.jsp" %>
    <div class="block">
        <form class="doctor-form" id="doctor-form" name="doctor-form">

            <div class="block1">
                <div class="row-md-4">
                    <div class="col-md-4">
                        <input class="form-control1" list="datalistOptions" id="exDataList"
                            placeholder="Паспортные данные" name="eMail" required>
                        <datalist id="datalistOptions">
                        </datalist>
                    </div>
                    <div class="col-md-4">
                        <button class="btn btn-secondary" type="submit" name="put-info" id="put-info"
                            form="doctor-form">Обновить
                            данные</button>
                    </div>
                    <div class="col-md-4">
                        <button class="btn btn-secondary" type="submit" name="post-info" id="post-info"
                            form="doctor-form">Добавить
                            врача</button>
                    </div>
                </div>

                <div class="col-md-6">
                    <label for="validationDefault20" class="form-label" required>Последнее место работы</label>
                    <input type="text" class="form-control" id="validationDefault20" name="lastPlaceOfWork" required>
                </div>
                <div class="col-md-6">
                    <label for="validationDefault21" class="form-label" required>Занимаемая должность</label>
                    <input type="text" class="form-control" id="validationDefault21" name="lastPosition" required>
                </div>
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text" required>Опыт</span>
                    </div>
                    <input type="text" class="form-control" name="experience" required>
                    <div class="input-group-append">
                        <span class="input-group-text">лет</span>
                    </div>
                </div>

                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Образование</span>
                    </div>
                    <textarea class="form-control" aria-label="With textarea" name="education" required></textarea>
                </div>
                <div class="col-md-4">
                    <label for="validationDefault01" class="form-label"></label>
                </div>
                <input type="text" class="form-hidden" id="userId" name="userId" value="0" hidden>
                <input type="text" class="form-hidden" id="id" name="id" value="0" hidden>

                <div class="block2" name="block2">
                </div>
                <div class="block3" name="block3">
                </div>
            </div>

        </form>
    </div>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>

<script>
                $(document).ready(function() {
                    $.ajax({
                        url: 'http://localhost:8080/passports/doctors_patients',
                        type: 'get',
                        success: function(response) {
                            var len = response.length;
                            for (var i = 0; i < len; i++) {
                                var passportNumber = response[i].passportNumber;
                                var lastName = response[i].lastName;
                                var firstName = response[i].firstName;
                                var id = response[i].id;
                                var str = "<option id=email-id data-id=" + id + " value=" + passportNumber + ">" + lastName + " " + firstName + "</option>";
                                $("#datalistOptions").append(str);
                            }

                        }
                    });

                    $(document).ready(function() {
                        $('#checkBtn').click(function() {

                        });
                    });

                    $.ajax({
                        url: 'http://localhost:8080/departments',
                        type: 'get',
                        success: function(response) {
                            var len = response.length;
                            for (var i = 0; i < len; i++) {

                                var name = response[i].name;
                                var id = response[i].id;

                                var str = "<label class='form-check-label'><input type='checkbox' id='checkDep' name='departments' class='form-check-input' type='checkbox' value=" +
                                    id + ">" + name + "</label>";


                                $(".block3").append(str);
                            }

                        }
                    });

                    $.ajax({
                        url: 'http://localhost:8080/specializations',
                        type: 'get',
                        success: function(response) {
                            var len = response.length;
                            for (var i = 0; i < len; i++) {

                                var name = response[i].name;
                                var id = response[i].id;

                                var str = "<label class='form-check-label'><input type='checkbox' name='specializations' id='checkSpec' class='form-check-input' type='checkbox' value=" +
                                    id + ">" + name + "</label>";


                                $(".block2").append(str);
                            }

                        }
                    });

                });

                document.getElementById('exDataList').addEventListener('input', function() {


                    var g = $('#exDataList').val();
                    var id = $('#datalistOptions').find('option[value="' + g + '"]').attr('data-id');
                    var url = 'http://localhost:8080/users/' + id;
                    $.ajax({
                        url: url,
                        type: 'get',
                        success: function(response) {
                            if (response.doctorInfo != null) {
                                $("[name='lastPlaceOfWork']").val(response.doctorInfo.lastPlaceOfWork);
                                $("[name='lastPosition']").val(response.doctorInfo.lastPosition);
                                $("[name='experience']").val(response.doctorInfo.experience);
                                $("[name='education']").val(response.doctorInfo.education);
                                $("[name='id']").val(response.doctorInfo.id);
                            } else {
                                $("[class='form-control']").val(null);
                                $("[class='form-hidden']").val("0");
                                $("[class='form-select']").val(null);
                                $("[class='form-select']").prop('checked', false);

                            }

                        }

                    })
                });

                function postButton() {
                    document.querySelector('.doctor-form').addEventListener('submit', handleFormSubmit1);
                }

                function putButton() {
                    document.querySelector('.doctor-form').addEventListener('submit', handleFormSubmit2);
                }


                function handleFormSubmit1(event) {
                    event.preventDefault();
                    checked1 = $("input[name=departments]:checked").length;
                    checked2 = $("input[name=specializations]:checked").length;

                    if (!checked1) {
                        alert("Выберите отдел.");
                        return false;
                    }
                    if (!checked2) {
                        alert("Выберите специальность.");
                        return false;
                    }
                    var departments = $("#doctor-form input#checkDep:checked").map(function() {
                        return $(this).val();
                    }).get();
                    var specializations = $("#doctor-form input#checkSpec:checked").map(function() {
                        return $(this).val();
                    }).get();

                    var g = $('#exDataList').val();
                    var patId = $('#datalistOptions').find('option[value="' + g + '"]');
                    var userId = patId.attr('data-id');


                    const data = new FormData(event.target);

                    const formJSON = Object.fromEntries(data.entries());

                    const stringJSON = "{\"lastPlaceOfWork\":\"" + formJSON.lastPlaceOfWork + "\",\"lastPosition\":\"" +
                        formJSON.lastPosition + "\",\"education\":\"" + formJSON.education + "\",\"experience\":\"" +
                        formJSON.experience + "\",\"rating\":\"0\",\"specializations\":[" + specializations + "],\"departments\":[" +
                        departments + "],\"id\":\"" + formJSON.id + "\",\"userId\":\"" + userId + "\"}";
                    const formJSON1 = JSON.parse(stringJSON);
                    var g = $('#exDataList').val();
                    var id = $('#datalistOptions').find('option[value="' + g + '"]').attr('data-id');
                    if (id == null) {
                        alert("Введите e-mail пользователя")
                    } else {
                        var url = 'http://localhost:8080/doctor_info';
                        $("[id='userId']").val(id);



                        const string = JSON.stringify(formJSON);

                        $.ajax({
                            url: url,
                            type: 'POST',
                            data: formJSON1,
                            statusCode: {
                                201: function() {
                                    alert('Доктор добавлен');
                                },
                                406: function() {
                                    alert('Доктор с такой информацией уже существует')
                                }
                            }
                        });
                    }
                }
                document.getElementById('post-info').addEventListener('click', postButton);







                function handleFormSubmit2(event) {
                    event.preventDefault();

                    var g = $('#exDataList').val();
                    var id = $('#datalistOptions').find('option[value="' + g + '"]').attr('data-id');
                    var docInfoId = document.getElementById('id').value;
                    if (id == null) {
                        alert("Введите e-mail пользователя")
                    } else {
                        var url = 'http://localhost:8080/doctor_info/' + docInfoId;
                        $("[name='userId']").val(id);

                        const data = new FormData(event.target);

                        const formJSON = Object.fromEntries(data.entries());

                        const stringJson = JSON.stringify(formJSON);
                        $.ajax({
                            contentType: 'application/json',
                            url: url,
                            type: 'put',
                            dataType: "json",
                            data: stringJson,
                            statusCode: {
                                200: function() {
                                    alert('Информация обновлена');
                                }
                            }
                        });
                    }
                }
                document.getElementById('put-info').addEventListener('click', putButton);

            </script>

</body>

</html>
