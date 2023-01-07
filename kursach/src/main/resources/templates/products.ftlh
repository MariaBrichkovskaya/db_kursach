<!DOCTYPE html>
<html>
<head>
    <title>CAFE</title>
</head>
<body>
<h1>CAFE</h1><hr>
<h4>Продукты на складе</h4>

<#list products as product>
    <div>
        <p> ${product.name} | <a href="/product/${product.id}">Подробнее</a></p>
    </div>
<#else>
    <h3>Sklad pyst</h3>
</#list>
<hr>
</body>
</html>