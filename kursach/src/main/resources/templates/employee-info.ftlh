<!DOCTYPE html>
<html>
<head>
    <title>CAFE</title>
</head>
<body>
<a href="/">Вернуться на главную</a>
<h1>CAFE</h1><hr>
<h4>Подробная информация о работнике</h4>
<#if employee.image_bytes??>
    <br> <img src="/employee/${employee.id}/image" height="100px"/><br><br>
    <#else>
        <br> <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ5c2QCGWIDwM5VfLmcIWkU3aMzzQ18uf2ISQ&usqp=CAU" height="80px"/><br><br>
</#if>
<b>ФИО </b>${employee.fullName}<br>
<b>Должность </b>${employee.position1.name}<br>
<b>Опыт работы </b>${employee.experience}<br>
<#if !user.isWaiter()>
<b>Зарплата </b>${employee.salary}<br>
</#if>
<b>Электронная почта </b>${employee.email}<br>
<b>Номер телефона </b>${employee.phone}<br><br>
<hr>
<#if user.isDirector() || user.isAdministrator()>
<h3>Удаление работника</h3>
<form action="/employee/delete/${employee.id}" method="post" enctype="multipart/form-data">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Удалить работника"/>
</form><br></#if>
<#if user.isDirector() && employee.user?? && employee.id!=user.employee.id>
    <h3>Удаление аккаунта</h3>
    <form action="/user/delete/${employee.user.id}" method="post" enctype="multipart/form-data">
        <input type="hidden" name="employeeId" value="${employee.id}">
        <input type="hidden" name="directorId" value="${user.id}">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Удалить аккаунт"/>
    </form><br></#if>
<#if !(user.isWaiter() && (user.employee.id !=employee.id))>
<a href="/employee/edit/${employee.id}">Редактирование информации</a>
</#if>
</body>
</html>