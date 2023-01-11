<!DOCTYPE html>
<html>
<head>
    <title>CAFE</title>
</head>
<body>
<a href="/">Вернуться на главную</a>
<h1>Наши поставщики</h1><hr>

<#list suppliers as supplier>
    <div>
        <p> ${supplier.name} | <a href="/supplier/${supplier.id}">Подробнее</a></p>
    </div>
<#else>
    <h3>Поставщики отсутствуют, начните же уже работать с кем-то</h3>
</#list>
<hr>
<h3>Добавление нового поставщика</h3>
<form action="/supplier/create" method="post" enctype="multipart/form-data">
    Наименование фирмы-поставщика <input type="text"  name="name"/><br><br>
    Страна <input type="text"  name="country"/><br><br>
    Город <input type="text" name="city"/><br><br>
    Адрес <input type="text" name="address"/><br><br>
    Номер телефона <input type="text" maxlength="13" minlength="13" name="phone"/><br><br>
    <input type="submit" value="Добавить поставщика"/>
</form>
</body>
</html>