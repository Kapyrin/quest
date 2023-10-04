<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <title>Добро пожаловать в квест!</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<div class="container">
  <h1>Добро пожаловать в квест!</h1>
  <p>${welcomeMessage}</p>
  <form action="${pageContext.request.contextPath}/javaServlet" method="POST">
    <div class="form-group">
      <label for="nickname">Введите свой никнейм:</label>
      <input type="text" class="form-control" id="nickname" name="nickname" required>
    </div>
    <button type="submit" class="btn btn-primary">Начать</button>
  </form>
</div>
</body>
</html>
