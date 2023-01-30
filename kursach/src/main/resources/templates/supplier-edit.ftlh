<!DOCTYPE html>
<html>
<head>
    <title>CAFE</title>
</head>
<body>
<a href="/">Вернуться на главную</a>
<hr>
<h3>Редактирование поставщика</h3>
<form action="/supplier/editing/${supplier.id}" method="post" enctype="multipart/form-data">
    Наименование фирмы-поставщика <input type="text" value="${supplier.name}"  name="name"/><br><br>
    Страна <input type="text" value="${supplier.country}" name="country"/><br><br>
    Город <input type="text" value="${supplier.city}" name="city"/><br><br>
    Адрес <input type="text" value="${supplier.address}" name="address"/><br><br>
    Номер телефона <input type="text" value="${supplier.phone}" maxlength="13" minlength="13" name="phone"/><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Изменить поставщика"/>
</form>
</body>
</html>