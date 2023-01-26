<!DOCTYPE html>
<html>
<head>
    <title>CAFE</title>
</head>
<body>
<a href="/">Вернуться на главную</a>
<h1>CAFE</h1><hr>
<h4>Подробная информация о заказе</h4>
<b>Принимающий работник </b><a href="/employee/${order.waiter.id}">${order.waiter.fullName}</a><br>
<b>Стоимость </b>${order.price} руб.<br>
<b>Состав: </b>
<#if order.orderComposition??>
    <#list order.orderComposition as orderPosition>
        <#if orderPosition.id.product?has_content><p><a href="/product/${orderPosition.id.product.id}">${orderPosition.id.product.name}</a> ${orderPosition.amount} шт.</p>
        <#else> Продукт был удален из системы</#if>
    </#list>
</#if>
<b>Время заказа </b>${order.time}<br>
<b>Описание </b>${order.description}<br>
<hr>
<#if !user.isAccountant()>
<h3>Удаление заказа</h3>
<form action="/order/delete/${order.id}" method="post" enctype="multipart/form-data">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Удалить заказ"/>
</form><br>
</#if>
</body>
</html>