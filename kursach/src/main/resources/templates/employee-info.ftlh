<!DOCTYPE html>
<html>
<head>
    <title>CAFE</title>
</head>
<body>
<h1>CAFE</h1><hr>
<h4>Подробная информация о работнике</h4>
<#list images as img>
    <b>Фото </b><br><br> <img src="/images/${img.id}" height="80px"/><br><br>
</#list>
<b>ФИО </b>${employee.fullName}<br>
<b>Должность </b>${employee.position1.name}<br>
<b>Опыт работы </b>${employee.experience}<br>
<b>Номер телефона </b>${employee.phone}<br>
<hr>

</body>
</html>