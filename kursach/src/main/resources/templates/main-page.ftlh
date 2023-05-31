<!DOCTYPE html>
<html>
<head>
    <title>CAFE MASHA</title>
    <style>
        /* стили для заголовка */
        h1 {
            font-size: 36px;
            text-align: center;
            margin-top: 20px;
            color: #6c5b7b;
        }

        /* стили для параграфов */
        p {
            font-size: 18px;
            line-height: 1.5;
            word-spacing: 15px;
            margin-bottom: 10px;
            color: #6c5b7b;
        }

        /* стили для ссылок */
        a {
            color: #6c5b7b;
            text-decoration: none;
            padding: 5px 10px;
            border-radius: 5px;
            background-color: #e8d4e2;
            transition: background-color 0.3s ease;
        }

        a:hover {
            background-color: #c9b8cc;
        }

        /* стили для разделительной линии */
        hr {
            border: none;
            height: 10px;
            background-color: #6c5b7b;
            margin-top: 20px;
            margin-bottom: 20px;
        }

        /* стили для блока навигации */
        h4 {
            font-size: 24px;
            margin-top: 20px;
            color: #6c5b7b;
        }

        h4 a {
            margin-right: 10px;
        }
        .b1 {
            background-color: #e8d4e2; /* Синий цвет фона */
            color: #6c5b7b; /* Белый цвет текста */
            border: none; /* Убираем рамку */
            padding: 1rem 1.5rem; /* Поля вокруг текста */
            margin-bottom: 1rem; /* Отступ снизу */
        }

    </style>
</head>
<body bgcolor="#E6E6FA">
<h1>CAFE MASHA</h1>

<#if user.login??>
    <form action="/logout" method="post">
        <p>Пользователь: <i>${user.login}</i>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="submit" class="b1" value="Выйти"></p>
    </form>
    <p></p>
<#else>
    <h1><a href="/login">Войти</a></h1>
</#if>

<hr>

<#if user.login??>
    <h4>
        <p>
            <a href="/orders">Заказы</a>
            <a href="/employees">Работники</a>
            <a href="/products">Продукты</a>
            <a href="/deliveries">Поставки</a>
            <a href="/suppliers">Поставщики</a>
            <a href="/views">Представления</a>
            <a href="/user/edit/${user.id}">Аккаунт</a>
        </p>
    </h4>
    <hr>
</#if>


</body>
</html>