<!DOCTYPE html>
<html>
<head>
    <title>CAFE</title>
</head>
<body>
<a href="/">Вернуться на главную</a>
<h1>Продукты</h1><hr>
<form action="/products" method="get">
    Поиск по названию продукта <input type="search" id="productSearch" size="40" name="name" oninput="form.submit()"
                        value="${searchString}" autofocus onfocus="productSearch.setSelectionRange(productSearch.value.length, productSearch.value.length)"/>
</form><br>
<#if products?has_content>
<table border="1">
    <tr>
        <th>Название продукта</th>
        <th>Количество на<br>складе, шт.</th>
        <th>Цена за<br>единицу, руб.</th>
    </tr>
    <#list products as product>
        <tr>
            <td><a href="/product/${product.id}">${product.name}</a></td>
            <td align="center">${product.amount}</td>
            <td align="center">${product.price}</td>
        </tr>

    </#list>
</table>
<#else>
    <h3>Продуктов нет</h3>
</#if>
<br>
<hr>
<#if !user.isAccountant()>
<h3>Добавление нового продукта</h3>
<form action="/product/create" method="post" enctype="multipart/form-data">
    Наименование <input type="text" required name="name"/><br><br>
    Калорийность <input type="number" required  name="calories" Ккал/><br><br>
    Вес <input type="number" step="1" required name="unitWeight" г/><br><br>
    Цена за единицу <input type="number" required step="0.01" name="price" руб./><br><br>
    Описание <input type="text"  name="description"/><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Добавить продукт"/>
</form>
</#if>
</body>
</html>