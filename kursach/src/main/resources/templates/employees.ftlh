<!DOCTYPE html>
<html>
<head>
    <title>CAFE</title>
</head>
<body>
<h1>CAFE</h1><hr>
<h4>Работники нашего прекрасного заведения</h4>
<form action="/" method="get">
    Поиск по ФИО <input type="search" id="fio" name="fullName" oninput="form.submit()" value="${searchString}" autofocus onfocus="fio.setSelectionRange(fio.value.length, fio.value.length)"/>
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