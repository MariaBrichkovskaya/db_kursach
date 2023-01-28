<!DOCTYPE html>
<html>
<head>
    <title>CAFE</title>
    <style>
        P { word-spacing: 15px }
    </style>
</head>
<body>
<h1>CAFE</h1>
<#if user.email??>
<form action="/logout" method="post">
    <p>Пользователь: <i>${user.login}</i></p>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Выйти">
</form>
<#else>
<h1><a href="/login">Войти</a></h1>
</#if>
<hr>
<#if user.login??>
<h4><p><a href="/orders">Заказы</a> <a href="/employees">Работники</a> <a href="/products">Продукты</a>
        <a href="/deliveries">Поставки</a> <a href="/suppliers">Поставщики</a> <a href="/views">Представления</a></p></h4>
<hr>
</#if>
</body>
</html>