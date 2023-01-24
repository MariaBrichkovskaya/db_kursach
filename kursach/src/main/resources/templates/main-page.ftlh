<!DOCTYPE html>
<html>
<head>
    <title>CAFE</title>
    <style>
        P { word-spacing: 15px }
    </style>
</head>
<body>
<h1>CAFE | <a href="/login">Войти</a></h1>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Выйти">
</form>
<hr>
<h4><p><a href="/orders">Заказы</a> <a href="/employees">Работники</a> <a href="/products">Продукты</a>
        <a href="/deliveries">Поставки</a> <a href="/suppliers">Поставщики</a> <a href="/views">Представления</a></p></h4>
<hr>
</body>
</html>