<!DOCTYPE html>
<html>
<head>
    <title>CAFE</title>
</head>
<body>
<a href="/">Вернуться на главную</a>
<h1>Дабавление заказа</h1><hr>
    <form action="/order/addProduct" method="post" enctype="multipart/form-data">
    Продукт <select required name="productId">
            <option value="">Выберите продукт</option>
            <#list products as product>
                <option value="${product.id}">${product.name}</option>
            </#list>
        </select><br><br>
    Количество <input type="number" required min="1" step="1" name="productAmount"/>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Добавить в заказ"/><br><br>
    </form>
    <form action="/order/save" method="post" enctype="multipart/form-data">
        Описание <input type="text"  name="description" value="${order.description}"/><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Заказ"/>
    </form>
<#if order.orderComposition??>
    <#list order.orderComposition as orderPosition>
        <p><a href="/product/${orderPosition.product.id}">${orderPosition.product.name}</a> ${orderPosition.amount} шт.
            <a href="/order/deletePosition/${orderPosition_index}">Удалить</a>
        </p>
    </#list>
<#else>
    <h3>Добавьте продукты в заказ</h3>
</#if>
</body>
</html>