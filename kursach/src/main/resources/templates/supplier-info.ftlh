<!DOCTYPE html>
<html>
<head>
    <title>CAFE</title>
</head>
<body>
<a href="/">Вернуться на главную</a>
<h1>CAFE</h1><hr>
<h4>Подробная информация о поставщике</h4>
<b>Поставщик </b>${supplier.name}<br>
<b>Страна </b>${supplier.country}<br>
<b>Город </b>${supplier.city}<br>
<b>Адрес </b>${supplier.address}<br>
<b>Номер телефона </b>${supplier.phone}<br>
<hr>
<#if user.isAdministrator() || user.isDirector()>
<h3>Удаление поставщика</h3>
<form action="/supplier/delete/${supplier.id}" method="post" enctype="multipart/form-data">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Удалить поставщика"/>
</form><br>
<a href="/supplier/edit/${supplier.id}">Редактирование информации</a>
</#if>
</body>
</html>