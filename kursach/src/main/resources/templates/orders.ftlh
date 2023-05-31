<!DOCTYPE html>
<html>
<head>
    <title>CAFE</title>
</head>
<body>
<a href="/">Вернуться на главную</a>
<h1>CAFE</h1><hr>
<#if !user.isAccountant()>
    <form action="/order/create/start" method="post" enctype="multipart/form-data">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Добавить новый заказ"/>
    </form>
</#if>

<h4>Заказы, сделанные в нашем прекрасном заведении</h4>
<#list orders as order>
    <div>
        <p> ${order.waiter.fullName} ${order.time} | <a href="/order/${order.id}">Подробнее</a></p>
    </div>
    <#else>
    <h3>Что-то у нас ничего не заказывают</h3>
</#list>
<hr>
</body>
</html>