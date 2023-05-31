<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>CAFE</title>
    <style>
        h1 {
            font-size: 36px;
            text-align: center;
            margin-top: 20px;
            color: #6c5b7b;
        }

        p {
            font-size: 18px;
            line-height: 1.5;
            word-spacing: 15px;
            margin-bottom: 10px;
            color: #6c5b7b;
        }


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


        hr {
            border: none;
            height: 10px;
            background-color: #6c5b7b;
            margin-top: 20px;
            margin-bottom: 20px;
        }

        h4 {
            font-size: 24px;
            margin-top: 20px;
            color: #6c5b7b;
        }

        h4 a {
            margin-right: 10px;
        }


        form {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
    </style>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body style="background-color: #c9b8cc">
<h1 style="text-align: center;">CAFE MASHA</h1>
<hr>
<h4 style="text-align: center;">Авторизация</h4>
<br>
<form action="/login" method="post" style="">
    <p>Логин: <input type="text" required name="username"></p>
    <p>Пароль: <input type="password" name="password"></p>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input style="margin-top: 10px;margin-bottom: 20px;" type="submit" value="Вход"/>
</form>
<div style="text-align: center;">
    <a href="/registration" class="text-dark">Зарегистрироваться</a>
</div>
</body>
</html>


