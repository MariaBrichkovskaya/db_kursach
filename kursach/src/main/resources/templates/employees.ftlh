<!DOCTYPE html>
<html>
<head>
    <title>CAFE</title>
</head>
<body>
<h1>CAFE</h1><hr>
<h4>Работники нашего прекрасного заведения</h4>
<form action="/" method="get">
    Поиск по ФИО <input type="text" name="fullName">
    <input type="submit" value="Поиск"/>
</form>
<#list employees as employee>
    <div>
        <p><b>${employee.fullName}</b> ${employee.position1.name} | <a href="/employee/${employee.id}">Подробнее</a></p>
        <form action="/employee/${employee.id}/trash" method="post" enctype="multipart/form-data">
            <input type="file" name="file"/><br><br>
            <input type="submit" value="Добавить фото"/>
        </form>
    </div>
    <#else>
    <h3>Таких сотрудников тут отродясь не наблюдалось</h3>
</#list>
<hr>
</body>
</html>