<!DOCTYPE html>
<html>
<head>
    <title>CAFE</title>
</head>
<body>
<a href="/">Вернуться на главную</a>
<hr>
<h3>Редактирование информации о поставках</h3>
<form action="/delivery/editing/${delivery.id}" method="post" enctype="multipart/form-data">
    Дата поставки <input type="date" value="${delivery.date}" name="date"/><br><br>
    Поставщик <p><select name="supplier.id">
            <option value="${delivery.supplier.id}">${delivery.supplier.name}</option>
            <#list suppliers as supplier>
                <option value="${supplier.id}">${supplier.name}</option>
            </#list>
        </select></p><br>
    Продукт <p><select name="product.id">
            <option value="${delivery.product.id}">${delivery.product.name}</option>
            <#list products as product>
                <option value="${product.id}">${product.name}</option>
            </#list>
        </select></p><br>
    Количество <input type="number" min="1" value="${delivery.toStringAmount()}" step="1" name="amount"/><br><br>
    Принимающий поставку работник <p><select name="employee.id">
            <option value="${delivery.employee.id}">${delivery.employee.fullName}</option>
            <#list employees as employee>
                <option value="${employee.id}">${employee.fullName}</option>
            </#list>
        </select></p><br>
    <input type="submit" value="Изменить информацию"/>
</form>
</body>
</html>