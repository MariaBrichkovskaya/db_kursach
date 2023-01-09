<!DOCTYPE html>
<html>
<head>
    <title>CAFE</title>
</head>
<body>
<h1>CAFE</h1><hr>
<h4>Подробная информация о работнике</h4>
    <b>Фото </b><br><br> <img src="/employee/${employee.id}/image" height="80px"/><br><br>
<b>ФИО </b>${employee.fullName}<br>
<b>Должность </b>${employee.position1.name}<br>
<b>Опыт работы </b>${employee.experience}<br>
<b>Номер телефона </b>${employee.phone}<br>
<hr>

</body>
</html>