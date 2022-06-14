<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html lang="ru">


<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Талоны</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <meta name="theme-color" content="#7952b3">
    <style>
                .table {
                    width: 40%;
                    float: right;
                }

                .block {
                    width: 55%;
                    float: left;
                }

                .col-md-5 {
                    float: left;
                    padding: 20px;
                }

                .col-md-4 {
                    float: left;
                    padding: 20px;
                }

            </style>

</head>

<body class="text-center">

<%@include file="header_cabinet.jsp" %>

<form class="form" id="form" name="form">
    <div class="block">
        <div class="block0">
            <div class="row-md-4">
                <div class="col-md-4">
                    <input class="form-control" list="datalistOptions" id="exDataList" placeholder="Фамилия врача" required>
                    <datalist id="datalistOptions">
                    </datalist>
                </div>
                <div class="col-md-4">
                    <button class="btn btn-secondary" type="submit" name="post" id="post" form="form">Добавить талоны</button>
                </div>
                <div class="col-md-4">
                    <button class="btn btn-secondary" name="delete-tickets" id="delete-tickets">Удалить талоны</button>
                </div>
                </div>
        </div>

        <div class="block1">
            <div class="col-md-4">
                <label for="startDate" class="form-label">Дата начала приемов</label>
                <input type="date" class="form-control" id="startDate" name="startDate" required>
            </div>
            <div class="col-md-4">
                <label for="endDate" class="form-label">Дата конца приемов</label>
                <input type="date" class="form-control" id="endDate" name="endDate" required>
            </div>
        </div>

        <div class="col-md-4">
            <label for="durationOfAppointment" class="form-label">Длительность приема</label>
            <select class="form-select" name="durationOfAppointment" id="durationOfAppointment">
                <option value="10">10 мин.</option>
                <option value="15">15 мин.</option>
                <option value="20">20 мин.</option>
                <option value="30">30 мин.</option>
            </select>
        </div>

        <div class="block1">
            <div class="col-md-4">
                <label for="startTime" class="form-label">Начало приема</label>
                <select class="form-select" name="startTime" id="startTime">
                    <option value="08:00">08:00</option>
                    <option value="09:00">09:00</option>
                    <option value="10:00">10:00</option>
                    <option value="11:00">11:00</option>
                    <option value="12:00">12:00</option>
                </select>
            </div>

            <div class="col-md-4">
                <label for="startTime" class="form-label">Конец приема</label>
                <select class="form-select" name="endTime" id="endTime">
                    <option value="16:00">16:00</option>
                    <option value="17:00">17:00</option>
                    <option value="18:00">18:00</option>
                    <option value="19:00">19:00</option>
                    <option value="20:00">20:00</option>
                </select>
            </div>
        </div>

        <div class="col-md-4">
            <label for="validationDefault20" class="form-label">Номер кабинета</label>
            <input type="text" class="form-control" id="validationDefault20" name="officeNumber" required>
        </div>


        <div class="block2">
            <div class="col-md-4">
                <label for="startTime" class="form-label">Начало перерыва</label>
                <select class="form-select" name="breakStart" id="breakStart">
                    <option value="11:00">11:00</option>
                    <option value="12:00">12:00</option>
                    <option value="13:00">13:00</option>
                    <option value="14:00">14:00</option>
                    <option value="15:00">15:00</option>
                </select>
            </div>

            <div class="col-md-4">
                <label for="startTime" class="form-label">Конец перерыва</label>
                <select class="form-select" name="breakEnd" id="breakEnd">
                    <option value="12:00">12:00</option>
                    <option value="13:00">13:00</option>
                    <option value="14:00">14:00</option>
                    <option value="15:00">15:00</option>
                    <option value="16:00">16:00</option>
                </select>
            </div>
        </div>

        <input type="text" class="doctorId" name="doctorId" id="doctorId" value="0" hidden>
    </div>
</form>



<div class="container">
    <table class="table" id="table">
        <thead>
        <tr>
            <th>Талон</th>
            <th>Дата</th>
            <th>Время</th>
            <th>Доступен</th>
        </tr>
        </thead>
        <tbody></tbody>
    </table>
</div>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
<script>
                $(document).ready(function() {
                    $.ajax({
                        url: 'http://localhost:8080/passports/doctors',
                        type: 'get',
                        success: function(response) {
                            var len = response.length;
                            for (var i = 0; i < len; i++) {
                                var userId = response[i].id;
                                var lastName = response[i].lastName;
                                var firstName = response[i].firstName;
                                var number = response[i].passportNumber;
                                var str = "<option id='userId' data-id=" + userId + " value=" + number + ">" + lastName + " " + firstName + "</option>";
                                $("#datalistOptions").append(str);
                            }

                        }
                    });
                });

                document.getElementById('exDataList').addEventListener('input', function() {

                    var g = $('#exDataList').val();
                    var doctorId = $('#datalistOptions').find('option[value="' + g + '"]').attr('data-id');
                    const url = 'http://localhost:8080/tickets/' + doctorId;
                    $.ajax({
                        url: url,
                        type: 'get',
                        success: function(response) {
                            var len = response.length;
                            for (var i = 0; i < len; i++) {

                                var number = response[i].number;
                                var date = response[i].date;
                                var time = response[i].time;
                                var available = response[i].available;
                                console.log(date);
                                var tr_str = "<tr>" +
                                    "<th scope='row'>" + number + "</th>" +
                                    "<td align='center'>" + date + "</td>" +
                                    "<td align='center'>" + time + "</td>" +
                                    "<td align='center'>" + available + "</td>" +
                                    "</tr>";

                                $("#table tbody").append(tr_str);
                            }

                        }
                    });
                });




                function handleFormSubmit(event) {
                    event.preventDefault();

                    var url = 'http://localhost:8080/tickets';
                    var g = $('#exDataList').val();
                    var doctorId = $('#datalistOptions').find('option[value="' + g + '"]').attr('data-id');
                    $("[name='doctorId']").val(doctorId);

                    const data = new FormData(event.target);

                    const formJSON = Object.fromEntries(data.entries());
                    console.log(formJSON);
                    $.ajax({
                        url: url,
                        type: 'post',
                        data: formJSON,
                        statusCode: {
                            201: function() {
                                alert('Талоны созданы');
                                window.location.reload();
                            }
                        }
                    });
                }


                document.querySelector('.form').addEventListener('submit', handleFormSubmit);


                document.getElementById("delete-tickets").addEventListener('click', function() {
                    var g = $('#exDataList').val();
                    var doctorId = $('#datalistOptions').find('option[value="' + g + '"]').attr('data-id');
                    var url = 'http://localhost:8080/tickets/' + doctorId;
                    $.ajax({
                        url: url,
                        type: 'delete',
                        statusCode: {
                            200: function() {
                                alert("Талоны удалены");
                                window.location.reload();
                            }
                        }
                    });
                });

            </script>

</body>

</html>
