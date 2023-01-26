<!DOCTYPE html>
<html>
<head>
    <title>CAFE</title>
</head>
<body>
<a href="/">Вернуться на главную</a>
<h1>CAFE</h1><hr>
<h4>Поставки</h4>
<#list deliveries as delivery>
    <div>
        <p><#if delivery.product?has_content><b>${delivery.product.name}</b></#if> ${delivery.date} | <a href="/delivery/${delivery.id}">Подробнее</a></p>
    </div>
<#else>
    <h3>Поставок не наблюдается</h3>
</#list>
<hr>
<#if !user.isAccountant()>
<h3>Добавление новой поставки</h3>
<form action="/delivery/create" method="post" enctype="multipart/form-data">
    Дата поставки <input type="date" pattern="yyyy-MM-dd" name="date"/><br><br>
    Поставщик <p><select name="supplier.id">
            <option value="">Выберите поставщика</option>
            <#list suppliers as supplier>
                <option value="${supplier.id}">${supplier.name}</option>
            </#list>
          </select></p><br>
    Продукт <p><select name="product.id">
            <option value="">Выберите продукт</option>
            <#list products as product>
                <option value="${product.id}">${product.name}</option>
            </#list>
        </select></p><br>
    Количество <input type="number" min="1" step="1" name="amount"/><br><br>
    Принимающий поставку работник <p><select name="employee.id">
            <option value="">Выберите работника</option>
            <#list employees as employee>
                <option value="${employee.id}">${employee.fullName}</option>
            </#list>
        </select></p><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Добавить поставку"/>
</form>
</#if>
</body>
</html>