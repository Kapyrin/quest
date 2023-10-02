<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ты ошибся</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h1>Не правильный ответ</h1>
<p>&nbsp;&nbsp;&nbsp;Игрок: ${currentPlayer.nickName}</p>
<p>&nbsp;&nbsp;&nbsp;Количество неправильных попыток: ${incorrectAttempts}</p>

<form action="/javaServlet" method="POST">
    &nbsp;&nbsp;&nbsp; <input type="hidden" name="retryLastIncorrect" value="true">
    &nbsp;&nbsp;&nbsp; <button type="submit">Попробовать еще раз</button>
</form>

</body>
</html>
