<!DOCTYPE html>
<html>
<head>
    <title>CAFE</title>
</head>
<body>
<a href="/">Вернуться на главную</a>
<h1>Наши поставщики</h1><hr>
<form action="/suppliers" method="get">
    Поиск по названию поставщика <input type="search" id="supplierSearch" size="40" name="name" oninput="form.submit()"
                                      value="${searchString}" autofocus onfocus="supplierSearch.setSelectionRange(supplierSearch.value.length, supplierSearch.value.length)"/>
</form><br>
<#if suppliers?has_content>
<table border="1">
    <tr>
        <th>Название компании</th>
        <th>Страна</th>
        <th>Город</th>
    </tr>
    <#list suppliers as supplier>
        <tr>
            <td><a href="/supplier/${supplier.id}">${supplier.name}</a></td>
            <td align="center">${supplier.country}</td>
            <td align="center">${supplier.city}</td>
        </tr>
    </#list>
</table>
<#else>
    <h3>Поставщики отсутствуют, начните же уже работать с кем-то</h3>
</#if>
<br><hr>
<#if user.isAdministrator() || user.isDirector()>
<h3>Добавление нового поставщика</h3>
<form action="/supplier/create" method="post" enctype="multipart/form-data">
    Наименование фирмы-поставщика <input type="text" required name="name"/><br><br>
    Страна <input type="text" required name="country"/><br><br>
    Город <input type="text" required name="city"/><br><br>
    Адрес <input type="text" required name="address"/><br><br>
    Номер телефона <input type="text" required maxlength="13" minlength="13" name="phone"/><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Добавить поставщика"/>
</form>
</#if>
</body>
</html>