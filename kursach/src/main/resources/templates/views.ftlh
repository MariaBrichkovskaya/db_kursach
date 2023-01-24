<!DOCTYPE html>
<html>
<head>
    <title>CAFE</title>
</head>
<body>
<a href="/">Вернуться на главную</a>
<#if products?has_content>
    <table border="1"><h1>Статус продуктов</h1>
        <tr>
            <th>Название продукта</th>
            <th>Количество на<br>складе, шт.</th>
            <th>Статус</th>
        </tr>
        <#list products as product>
            <tr>
                <td>${product.name}</td>
                <td align="center">${product.amount}</td>
                <td align="center"><#switch (product.amount<20)>
                    <#case true>
                        Допускается поставка
                        <#break>
                    <#default>
                    Поставка не требуется
                </#switch></td>
            </tr>
        </#list>
    </table><br>
<#else>
    <h3>Продуктов нет</h3>
</#if>

<#if employees?has_content>
    <table border="1"><h1>Лучшие работники</h1>
        <tr>
            <th>Работник</th>
            <th>Количество принятых<br>заказов</th>
            <th>Должность</th>
        </tr>
        <#list employees as employee>
            <#if employee.orders?size!=0>
            <tr>
                <td>${employee.fullName}</td>
                <td align="center">${employee.orders?size}</td>
                <td align="center">${employee.position1.name}</td>
            </tr>
            </#if>
        </#list>
    </table><br>
<#else>
    <h3>Таких работников нет</h3>
</#if>

<#if wellPaidEmployees?has_content>
    <table border="1">
        <h1>Работники с зарплатой выше средней</h1>
        <tr>
            <th>ФИО работника</th>
            <th>Должность</th>
            <th>Зарплата</th>
        </tr>
        <#list wellPaidEmployees as employee>
            <tr>
                <td>${employee.fullName}</td>
                <td align="center">${employee.position}</td>
                <td align="center">${employee.salary}</td>
            </tr
        </#list>
    </table><br>
<#else>
    <h3>Таких работников нет</h3>
</#if>

<#if products?has_content>
    <table border="1">
        <h1>Продукты и их типы</h1>
        <tr>
            <th>Название продукта</th>
            <th>Количество на<br>складе, шт.</th>
            <th>Тип продукта</th>
        </tr>
        <#list products as product>
            <tr>
                <td>${product.name}</td>
                <td align="center">${product.amount}</td>
                <td align="center"><#if product.name?lower_case?contains("кофе")>Кофе
                    <#elseif product.name?lower_case?contains("слойка")>Слойка
                    <#elseif product.name?lower_case?contains("молоко")>Молоко
                    <#elseif product.name?lower_case?contains("сироп")>Сироп
                    <#elseif product.name?lower_case?contains("сливки")>Сливки
                    <#else> Тип не определен</#if>
                </td>
            </tr
        </#list>
    </table><br>
<#else>
    <h3>Продуктов нет</h3>
</#if>
</body>
</html>