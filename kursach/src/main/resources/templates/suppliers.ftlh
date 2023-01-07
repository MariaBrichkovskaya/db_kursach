<!DOCTYPE html>
<html>
<head>
    <title>CAFE</title>
</head>
<body>
<h1>Наши поставщики</h1><hr>

<#list suppliers as supplier>
    <div>
        <p> ${supplier.name} | <a href="/supplier/${supplier.id}">Подробнее</a></p>
    </div>
<#else>
    <h3>Поставщики отсутствуют, начните же уже работать с кем-то</h3>
</#list>
<hr>
</body>
</html>