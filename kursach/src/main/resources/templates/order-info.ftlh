<!DOCTYPE html>
<html>
<head>
    <title>CAFE</title>
</head>
<body>
<h1>CAFE</h1><hr>
<h4>Подробная информация о заказе</h4>
<b>Принимающий заказ </b>${order.waiter.fullName}<br>
<b>Стоимость </b>${order.price}<br>
<b>Состав: </b><#list order.orderComposition as orderPosition>
    <p>${orderPosition.product.name} <b>${orderPosition.amount}</b></p>
</#list>
<b>Время приема </b>${order.time}<br>
<b>Описание </b>${order.description}<br>
<hr>

</body>
</html>