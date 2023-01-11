<!DOCTYPE html>
<html>
<head>
    <title>CAFE</title>
</head>
<body>
<a href="/">Вернуться на главную</a>
<h1>Продукты</h1><hr>
<#list products as product>
    <div>
        <p> ${product.name} | <a href="/product/${product.id}">Подробнее</a></p>
    </div>
<#else>
    <h3>Продукты на складе отсутствуют</h3>
</#list>
<hr>
<h3>Добавление нового сотрудника</h3>
<form action="/product/create" method="post" enctype="multipart/form-data">
    Наименование <input type="text"  name="name"/><br><br>
    Калорийность <input type="number"  name="calories" Ккал/><br><br>
    Вес <input type="number" step="1" name="weight" г/><br><br>
    Цена за единицу <input type="number" step="0.01" name="price" руб./><br><br>
    Описание <input type="text"  name="description"/><br><br>
    <input type="submit" value="Добавить продукт"/>
</form>
</body>
</html>