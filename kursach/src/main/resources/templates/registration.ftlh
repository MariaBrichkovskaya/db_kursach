<!DOCTYPE html>
<html>
<head>
    <title>CAFE</title>
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


        /* стили для формы авторизации */
        form {
            display: flex;
            flex-direction: column;
            align-items: center;
            text-align: center;
        }

        form input[type="email"],
        form input[type="text"],
        form input[type="password"] {
            width: 100%;
            max-width: 400px;
            margin-bottom: 10px;
        }

        form input[type="submit"] {
            margin-top: 30px;
            margin-bottom: 50px;
        }
        .b1 {
            background-color: #e8d4e2; /* Синий цвет фона */
            color: #6c5b7b; /* Белый цвет текста */
            border: none; /* Убираем рамку */
            padding: 1rem 1.5rem; /* Поля вокруг текста */
            margin-bottom: 1rem; /* Отступ снизу */
        }
    </style>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

</head>
<body style="background-color: #E6E6FA">
<h1 style="text-align: center;">CAFE MASHA</h1>
<h4 style="position: relative; left: 50%; transform: translate(-50%,0); text-indent: 45%">Регистрация</h4><br>
<form action="/registration" method="post">
    <p style="text-align: center">Эл.почта: <input type="email" required name="email"><br></p>
    <p style="text-align: center">Логин: <input type="text" required name="login"><br></p>
    <p style="text-align:center">Пароль: <input type="password" required name="password"><br><br></p>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input style="margin-top: 10px;margin-bottom: 20px;" type="submit" class="b1" value="Зарегистрироваться"/>
</form><br>
<#if errorMessage??>
    <h5 style="color:firebrick; position: relative; left: 500px;">Ошибка регистрации. Проверьте указанную почту</h5>
</#if>
</body>
</html>