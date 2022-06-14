<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Медицинская карта</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">


    <meta name="theme-color" content="#7952b3">
    <sec:authentication var="user" property="principal"/>
     <style>
                     .block {
                         width: 30%;
                         padding: 20px;
                         float: left;
                     }

                     .container {
                         width: 70%;
                         padding: 20px;
                         float: right;
                     }


         </style>

</head>
<body class="text-center">

<%@include file="header_cabinet.jsp" %>

<div class="container">
    <table id="medical-note-table" class="table">
        <thead>
        <tr>
            <th width="20%" class="text-center">Дата</th>
            <th width="20%" class="text-center">Запись</th>
            <th width="20%" class="text-center">Название</th>
            <th width="20%" class="text-center">Заболевание</th>
            <th width="40%" class="text-center">Описание</th>
        </tr>
        </thead>
        <tbody></tbody>
    </table>
</div>

<sec:authorize access="hasAnyAuthority('DOCTOR', 'ADMIN')">
    <div class="block">
        <form class="form">
            <div class="form-floating">
                <input type="date" class="form-control" id="floatingInput" name="date" required>
            </div>
            <select class="form-select" aria-label="Тип записи" name="type" id="type">
                <option>Диагноз</option>
                <option>Лечение</option>
                <option>Анализ</option>
                <option>Рецепт</option>
                <option>Больничный</option>
                <option>Прививка</option>
            </select>


            <div class="form-floating">
                <input type="text" class="form-control" id="floatingInput2" name="name" required>
                <label for="floatingInput2">Название записи</label>
            </div>

            <div class="form-floating">
                <input type="text" class="form-control" id="floatingInput1" name="illness" required>
                <label for="floatingInput1">Заболевание</label>
            </div>

            <div class="form-floating">
                <textarea type="text" class="form-control" id="floatingInput3" name="description" required></textarea>
                <label for="floatingInput3">Описание</label>
            </div>
            <label for="exampleDataList" class="form-label">Имя пациента</label>
            <input class="form-control" list="datalistOptions" id="dataList" placeholder="Type to search..."
                   name="passport" required>
            <datalist id="datalistOptions">
            </datalist>

            <button class="w-100 btn btn-sm btn-outline-dark" type="submit">Добавить запись</button>
            <button class="w-100 btn btn-sm btn-outline-secondary" onClick="window.location.reload();">Обновить страницу
            </button>

        </form>
    </div>
</sec:authorize>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
<script>
                $(document).ready(function() {
                    var principalId = $('#principalId').text();
                    var principalRole = $('#principalRole').text();
                    if (principalRole[0] = 'PATIENT') {
                        $.ajax({
                            url: 'http://localhost:8080/medical_card/user/' + principalId,
                            type: 'get',
                            success: function(response) {
                                var len = response.length;
                                for (var i = 0; i < len; i++) {
                                    var id = response[i].id;
                                    console.log(id);
                                    var date = response[i].date;
                                    var type = response[i].type;
                                    var name = response[i].name;
                                    var illness = response[i].illness;
                                    var description = response[i].description;
                                    var tr_str = "<tr>" +
                                        "<td class='id' hidden align='center'>" + id + "</td>" +
                                        "<td align='center'>" + date + "</td>" +
                                        "<td align='center'>" + type + "</td>" +
                                        "<td align='center'>" + name + "</td>" +
                                        "<td align='center'>" + illness + "</td>" +
                                        "<td align='center'>" + description + "</td>" +
                                        "</tr>";

                                    $("#medical-note-table tbody").append(tr_str);
                                }
                            }
                        });
                    }

                    $.ajax({
                        url: 'http://localhost:8080/passports/patients',
                        type: 'get',
                        success: function(response) {
                            var len = response.length;
                            for (var i = 0; i < len; i++) {
                                var lastName = response[i].lastName;
                                var firstName = response[i].firstName;
                                var passportNumber = response[i].passportNumber;
                                var id = response[i].id;

                                var str = "<option data-id=" + id + " value=" + passportNumber + ">" + lastName + " " + firstName + "</option>";
                                $("#datalistOptions").append(str);
                            }
                        }
                    });
                });
                document.getElementById('dataList').addEventListener("input", function() {
                    var g = $('#dataList').val();
                    var patId = $('#datalistOptions').find('option[value="' + g + '"]');
                    var patientId = patId.attr('data-id');
                    $.ajax({
                        url: 'http://localhost:8080/medical_card/user/' + patientId,
                        type: 'get',
                        success: function(response) {
                            var len = response.length;
                            for (var i = 0; i < len; i++) {
                                var id = response[i].id;
                                console.log(id);
                                var date = response[i].date;
                                var type = response[i].type;
                                var name = response[i].name;
                                var illness = response[i].illness;
                                var description = response[i].description;
                                var tr_str = "<tr>" +
                                    "<td class='id' hidden align='center'>" + id + "</td>" +
                                    "<td align='center'>" + date + "</td>" +
                                    "<td align='center'>" + type + "</td>" +
                                    "<td align='center'>" + name + "</td>" +
                                    "<td align='center'>" + illness + "</td>" +
                                    "<td align='center'>" + description + "</td>" +
                                    "<td>" +
                                    "<button id = 'delete' type = 'button' " +
                                    "class = 'btn btn-outline-secondary btn-sm'>Удалить</button>" +
                                    "</td>" +
                                    "</tr>";

                                $("#medical-note-table tbody").append(tr_str);
                            }
                        }
                    });
                });

                function handleFormSubmit(event) {
                    event.preventDefault();
                    var url = 'http://localhost:8080/medical_card';

                    const data = new FormData(event.target);

                    const formJSON = Object.fromEntries(data.entries());
                    console.log(formJSON);
                    $.ajax({
                        url: url,
                        type: 'post',
                        data: formJSON,
                        statusCode: {
                            201: function() {
                                alert('Запись добавлена');
                            },
                        }
                    });
                }

                document.querySelector('.form').addEventListener('submit', handleFormSubmit);


                $('table').on('click', '#delete', function() {
                    var rowEl = $(this).closest('tr');
                    var id = rowEl.find('.id').text();
                    var url = 'http://localhost:8080/medical_card/' + id;

                    $.ajax({
                        url: url,
                        type: 'delete',
                        statusCode: {
                            200: function() {
                                alert("Успешно удалено");
                                window.location.reload();
                            }
                        }
                    });
                });

</script>
</body>
</html>