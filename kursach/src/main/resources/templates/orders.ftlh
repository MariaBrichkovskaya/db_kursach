<!DOCTYPE html>
<html>
<head>
    <title>CAFE</title>
</head>
<body>
<h1>CAFE</h1><hr>
<h4>Заказы, сделанные в нашем прекрасном заведении</h4>

<#list orders as order>
    <div>
        <p><b>${order.id}</b> ${order.waiter.fullName} | <a href="/order/${order.id}">Подробнее</a></p>
        <#list order.orderComposition as orderPosition>
            <p>${orderPosition.product.name} <b>${orderPosition.amount}</b></p>
        </#list>
    </div>
<#else>
    <h3>Что-то у нас ничего не заказывают</h3>
</#list>
<hr>
</body>
</html>