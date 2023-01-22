<!DOCTYPE html>
<html>
<head>
    <title>CAFE</title>
</head>
<body>
<a href="/">Вернуться на главную</a>
<hr>
<h3>Редактирование информации о работнике</h3>
<form action="/employee/${employee.id}/trash" method="post" enctype="multipart/form-data">
    <input type="file" name="file"/><br><br>
    <input type="submit" value="Добавить фото"/>
</form><br>
<form action="/employee/editing/${employee.id}" method="post" enctype="multipart/form-data">
    ФИО <input type="text" value="${employee.fullName}" size="40" name="fullName"/><br><br>
    Должность <p><select name="position1.id">
            <option value="${employee.position1.id}">${employee.position1.name}</option>
            <option value="2">Менеджер</option>
            <option value="3">Бариста</option>
            <option value="4">Официант</option>
            <option value="5">Бухгалтер</option>
            <option value="6">Управляющий</option>
            <option value="7">Кассир</option></select></p><br>
    Опыт работы <input type="number" value="${employee.experience}" min="0" name="experience"/><br><br>
    Заработная плата <input type="number" value="${employee.toStringSalary()}" min="0" name="salary"/><br><br>
    Номер телефона <input type="text" value="${employee.phone}" maxlength="13" minlength="13" name="phone"/><br><br>
    Дата приема на работу <input type="date" value="${employee.date}" name="date"/><br><br>
    <input type="submit" value="Изменить информацию"/>
</form>
</body>
</html>