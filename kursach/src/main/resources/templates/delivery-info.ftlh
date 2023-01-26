<!DOCTYPE html>
<html>
<head>
    <title>CAFE</title>
</head>
<body>
<a href="/">Вернуться на главную</a>
<h1>CAFE</h1><hr>
<h4>Подробная информация о поставке</h4>
<b>Название продукта </b><#if delivery.product?has_content><a href="/product/${delivery.product.id}">${delivery.product.name}</a><br>
    <b>Количество </b>${delivery.amount} шт.<br></#if>
<#if delivery.supplier?has_content><b>Поставщик </b><a href="/supplier/${delivery.supplier.id}">${delivery.supplier.name}</a><br></#if>
<#if delivery.employee?has_content><b>Принимающий работник </b><a href="/employee/${delivery.employee.id}">${delivery.employee.fullName}</a><br>
<#else> <b>Принимающий работник был уволен, потому что работать не умеет!</b><br></#if>

<b>Дата поставки </b>${delivery.date}<br>
<hr>
<#if !user.isAccountant()>
<h3>Удаление поставки</h3>
<form action="/delivery/delete/${delivery.id}" method="post" enctype="multipart/form-data">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Удалить поставку"/>
</form><br>
<a href="/delivery/edit/${delivery.id}">Редактирование информации</a>
</#if>
</body>
</html>