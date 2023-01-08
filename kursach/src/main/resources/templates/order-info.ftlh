<!DOCTYPE html>
<html>
<head>
    <title>CAFE</title>
</head>
<body>
<h1>CAFE</h1><hr>
<h4>Подробная информация о заказе</h4>
<b>Принимающий заказ </b><a href="/employee/${order.waiter.id}">${order.waiter.fullName}</a><br>
<b>Стоимость </b>${order.price} руб.<br>
<b>Состав: </b><#list order.orderComposition as orderPosition>
    <p><a href="/product/${orderPosition.product.id}">${orderPosition.product.name}</a> ${orderPosition.amount} шт.</p>
</#list>
<b>Время приема </b>${order.time}<br>
<b>Описание </b>${order.description}<br>
<hr>

</body>
</html>