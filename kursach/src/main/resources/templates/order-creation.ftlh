<!DOCTYPE html>
<html>
<head>
    <title>CAFE</title>
</head>
<body>
<a href="/">Вернуться на главную</a>
<h1>Дабавление заказа</h1><hr>
<#if order.orderComposition??>
<#list order.orderComposition as orderPosition>
    <p><a href="/product/${orderPosition.product.id}">${orderPosition.product.name}</a> ${orderPosition.amount} шт.</p>
</#list>
    <#else>
    <h3>Добавьте продукты в заказ</h3>
</#if>
    <form action="/order/addProduct" method="post" enctype="multipart/form-data">
    Продукт <select name="id">
            <option value="">Выберите продукт</option>
            <#list products as product>
                <option value="${product.id}">${product.name}</option>
            </#list>
        </select><br><br>
    Количество <input type="number" min="1" step="1" name="productAmount"/>
        <input type="submit" value="Добавить в заказ"/><br><br>
    </form>
    <form action="/order/save" method="post" enctype="multipart/form-data">
    <input type="submit" value="Заказ"/>
    </form>
</body>
</html>