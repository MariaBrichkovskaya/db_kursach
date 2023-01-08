<!DOCTYPE html>
<html>
<head>
    <title>CAFE</title>
</head>
<body>
<h1>CAFE</h1><hr>
<h4>Поставки</h4>
<#list deliveries as delivery>
    <div>
        <p><b>${delivery.product.name}</b> ${delivery.date} | <a href="/delivery/${delivery.id}">Подробнее</a></p>
    </div>
<#else>
    <h3>Поставок не наблюдается</h3>
</#list>
<hr>
</body>
</html>