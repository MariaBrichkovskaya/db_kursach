<!DOCTYPE html>
<html>
<head>
    <title>CAFE</title>
</head>
<body>
<a href="/">Вернуться на главную</a>
<h1>CAFE</h1><hr>
<h4>Работники нашего прекрасного заведения</h4>
<form action="/employees" method="get">
    Поиск по ФИО <input type="search" id="fio" name="fullName" oninput="form.submit()" value="${searchString}" autofocus onfocus="fio.setSelectionRange(fio.value.length, fio.value.length)"/>
</form>
<#list employees as employee>
    <div>
        <p><b>${employee.fullName}</b> ${employee.position1.name} | <a href="/employee/${employee.id}">Подробнее</a></p>
    </div>
    <#else>
    <h3>Таких сотрудников тут отродясь не наблюдалось</h3>
</#list>
<hr>
<h3>Добавление нового сотрудника</h3>
<form action="/employee/create" method="post" enctype="multipart/form-data">
    ФИО <input type="text" name="fullName"/><br><br>
    Должность <p><select name="position1.id">
            <option value="">Выберите должность</option>
            <option value="2">Менеджер</option>
            <option value="3">Бариста</option>
            <option value="4">Официант</option>
            <option value="5">Бухгалтер</option>
            <option value="6">Управляющий</option>
            <option value="7">Кассир</option></select></p><br>
    Опыт работы <input type="number" min="0" name="experience"/><br><br>
    Заработная плата <input type="number" min="0" name="salary"/><br><br>
    Номер телефона <input type="text" maxlength="13" minlength="13" name="phone"/><br><br>
    Дата приема на работу <input type="date" name="date"/><br><br>
    <input type="submit" value="Добавить сотрудника"/>
</form>
</body>
</html>