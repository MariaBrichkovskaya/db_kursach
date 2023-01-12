<!DOCTYPE html>
<html>
<head>
    <title>CAFE</title>
</head>
<body>
<a href="/">Вернуться на главную</a>
<h1>CAFE</h1><hr>
<h4>Подробная информация о продукте</h4>
<b>Наименование </b>${product.name}<br>
<b>Цена за единицу </b>${product.price} руб.<br>
<b>Количество на складе </b>${product.amount} шт.<br>
<b>Калорийность </b>${product.calories} Ккал<br>
<b>Вес </b>${product.unitWeight} г<br>
<b>Описание </b>${product.description}<br>
<hr>
<h3>Удаление продукта</h3>
<form action="/product/delete/${product.id}" method="post" enctype="multipart/form-data">
    <input type="submit" value="Удалить продукт"/>
</form><br>
<a href="/product/edit/${product.id}">Редактирование информации</a>
</body>
</html>