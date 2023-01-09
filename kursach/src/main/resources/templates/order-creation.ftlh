<!DOCTYPE html>
<html>
<head>
    <title>CAFE</title>
</head>
<body>
<h1>Дабавление заказа</h1><hr>
<#list order.orderComposition as orderPosition>
    <p><a href="/product/${orderPosition.product.id}">${orderPosition.product.name}</a> ${orderPosition.amount} шт.</p>
</#list>
<h3></h3>
<form action="/order/save" method="post" enctype="multipart/form-data">
    <form action="/order/addProduct" method="post" enctype="multipart/form-data">
    Продукт <p><select name="orderComposition.product.id">
            <option value="">Выберите продукт</option>
            <#list products as product>
                <option value="${product.id}">${product.name}</option>
            </#list>
        </select></p>
    Количество <input type="number" min="1" step="1" name="orderComposition.amount"/> <input type="submit" value="Добавить в заказ"/><br><br>
    </form>
<input type="submit" value="Заказ"/>
</form>
</body>
</html>