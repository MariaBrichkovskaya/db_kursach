<!DOCTYPE html>
<html>
<head>
    <title>CAFE</title>
</head>
<body>
<a href="/">Вернуться на главную</a>
<h1>CAFE</h1><hr>
<h4>Подробная информация о работнике</h4>
<#if employee.image_bytes??>
    <br> <img src="/employee/${employee.id}/image" height="100px"/><br><br>
    <#else>
        <br> <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ5c2QCGWIDwM5VfLmcIWkU3aMzzQ18uf2ISQ&usqp=CAU" height="80px"/><br><br>
</#if>
<b>ФИО </b>${employee.fullName}<br>
<b>Должность </b>${employee.position1.name}<br>
<b>Опыт работы </b>${employee.experience}<br>
<b>Номер телефона </b>${employee.phone}<br><br>
<form action="/employee/${employee.id}/trash" method="post" enctype="multipart/form-data">
    <input type="file" name="file"/><br><br>
    <input type="submit" value="Добавить фото"/>
</form>
<hr>
<h3>Добавление нового заказа</h3>
<form action="/order/employee${employee.id}/create" method="post" enctype="multipart/form-data">
    <input type="submit" value="Добавить заказ"/>
</form>
<h3>Удаление работника</h3>
<form action="/employee/delete/${employee.id}" method="post" enctype="multipart/form-data">
    <input type="submit" value="Удалить работника"/>
</form>
</body>
</html>