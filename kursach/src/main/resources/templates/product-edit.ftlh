<!DOCTYPE html>
<html>
<head>
    <title>CAFE</title>
</head>
<body>
<a href="/">Вернуться на главную</a>
<hr>
<h3>Редактирование продукта</h3>
<form action="/product/editing/${product.id}" method="post" enctype="multipart/form-data">
    Наименование <input type="text" value="${product.name}" name="name"/><br><br>
    Калорийность <input type="number" value="${product.toStringCalories()}" name="calories" Ккал/><br><br>
    Вес <input type="number"  value="${product.toStringWeight()}" step="1" name="unitWeight" г/><br><br>
    Цена за единицу <input type="number" value="${product.toStringPrice()}" step="0.01" name="price" руб./><br><br>
    Количество на складе <input type="number" value="${product.toStringAmount()}" step="1" name="amount" шт./><br><br>
    Описание <input type="text" value="${product.description}"  name="description"/><br><br>
    <input type="submit" value="Изменить продукт"/>
</form>
</body>
</html>