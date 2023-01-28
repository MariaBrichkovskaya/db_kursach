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
    Поиск по ФИО <input type="search" id="fio" size="40" name="fullName" oninput="form.submit()" value="${searchString}" autofocus onfocus="fio.setSelectionRange(fio.value.length, fio.value.length)"/>
</form><br>
<#if employees?has_content>
<table border="1">
    <tr>
        <th>ФИО</th>
        <th>Должность</th>
        <th>Опыт работы</th>
    </tr>
    <#list employees as employee>
        <tr>
            <td><a href="/employee/${employee.id}">${employee.fullName}</a></td>
            <td align="center">${employee.position1.name}</td>
            <td align="center">${employee.experience}</td>
        </tr>
    </#list>
</table>
<#else>
    <h3>Таких сотрудников тут отродясь не наблюдалось</h3>
</#if>
<hr>
<#if user.isDirector() || user.isAdministrator()>
<h3>Добавление нового сотрудника</h3>
<form action="/employee/create" method="post" enctype="multipart/form-data">
    ФИО <input type="text" size="40" name="fullName"/><br><br>
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
    Электронная почта <input type="email" name="email"/><br><br>
    Номер телефона <input type="text" maxlength="13" minlength="13" name="phone"/><br><br>
    Дата приема на работу <input type="date" name="date"/><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Добавить сотрудника"/>
</form>
</#if>
</body>
</html>