<%@ page pageEncoding="UTF-8"%>

<html>
<head>
    <meta charset="utf-8">
    <title> Spring MVC CrudTestTask </title>
   </head>

   <body>

   <table align=center>
   <caption align=top>
                <h2>Редактировать пользователя</h2>
            </caption>
   <form method="post" action="http://localhost:8080/crudtesttask/user-module/updateUser" align=center>
   <c:for var="user">
   <tr>
        <td><input type="text" name="name" placeholder=${user.name}></td>
        <td><input type="text" name="age" placeholder=${user.age}></td>
        <td><input type="text" name="admin" list=${user.isAdmin}></td>
        <input type="hidden" name="id" value="${user.id}">
        <td><input type="submit" value="Сохранить"></td>
   </tr>
   </c: for>
   </form>
   </table>

   <br>
   <a href="http://localhost:8080/crudtesttask/user-module/getUsers">
    <h3 align=center>Вернуться к списку пользователей</h3>
   </a>
   </body>

 </html>