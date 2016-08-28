<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8"%>

<html>
<head>
    <meta charset="utf-8">
    <title> Spring MVC CrudTestTask </title>
   </head>

   <body>

   <table align=center>
   <caption align=top>
                <h2> Редактировать пользователя </h2>
            </caption>
   <tr>
            <th align=center> Фамилия и имя </th>
            <th  align=center> Возраст </th>
            <th  align=center> админ? </th>
   </tr>

   <form method="post" action="../user-module/updateUser" align=center>
       <tr>
            <td><input type="text" name="name" value="${user.name}" required></td>
            <td><input type="text" name="age" value="${user.age}" required pattern="[0-9]{1,3}"></td>
            <td align=center>
                <input type="radio" name="admin" value="true" <c:if test="${user.admin}"> checked </c:if> > да
                <input type="radio" name="admin" value="false" <c:if test="${!user.admin}"> checked </c:if> > нет
              </td>
                <input type="hidden" name="id" value="${user.id}">
                <input type="hidden" name="createdDate" value="${user.createdDate}">
            <td><input type="submit" value="Сохранить"></td>
       </tr>
   </form>
   </table>

   <br>
   <a href="../user-module/getUsers">
    <h3 align=center>Вернуться к списку пользователей</h3>
   </a>
   </body>

 </html>