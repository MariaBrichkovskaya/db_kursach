<!DOCTYPE html>
<html>
<head>
    <title>CAFE</title>
</head>
<body>
<a href="/">Вернуться на главную</a>
<h1>CAFE</h1><hr>
<h4>Подробная информация о поставке</h4>
<b>Название продукта </b><a href="/product/${delivery.product.id}">${delivery.product.name}</a><br>
<b>Количество </b>${delivery.amount} шт.<br>
<b>Поставщик </b><a href="/supplier/${delivery.supplier.id}">${delivery.supplier.name}</a><br>
<b>Принимающий работник </b><a href="/employee/${delivery.employee.id}">${delivery.employee.fullName}</a><br>
<b>Дата поставки </b>${delivery.date}<br>
<hr>
</body>
</html>