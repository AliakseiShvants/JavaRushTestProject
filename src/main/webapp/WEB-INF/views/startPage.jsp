<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8"%>

<html>
<head>
    <meta charset="utf-8">
    <title> Spring MVC CrudTestTask </title>

   </head>

<body bgcolor=white>
     <br>
     <br>
     <br>
     <br>
     <br>
     <br>
     <table align=center width=30% border=2>
            <form method="post" action="http://localhost:8080/crudtesttask/user-module/addNewUser" align=center>
            <tr>
                <td><input type="text" name="name" placeholder="фамилия и имя"></td>
                <td><input type="text" name="age" placeholder="возраст"></td>
                <td><input type="text" name="admin" list="boolean"></td>
                <datalist id="boolean">
                               <option value="да">
                               <option value="нет">
                </datalist>
                <td width=4%><input type="submit" value="Новый пользователь"></td>
            </form>
            </tr>
            </table>
     <br>
     <br>

<table  align=center width=44%  border=2>

<caption align=top>
             <h1>Наши пользователи</h1>
         </caption>

    <tr>
        <th width=15% align=center>Фамилия и имя пользователя</th>
        <th width=5% align=center>Возраст</th>
        <th width=5 align=center>Является ли администратором</th>
        <th width=15% align=center>Дата создания учетной записи</th>
    </tr>

    <c:forEach items="${userList}" var="user">
    <tr>
        <td width=15% >${user.name}</td>
        <td width=5% align=center>${user.age}</td>
        <td width=5% align=center > <input type="checkbox" disabled checked> </td>
        <td width=15% align=center>${user.createdDate}</td>
        <td width=1% height=1%>
            <form method="post" action="http://localhost:8080/crudtesttask/user-module/updateUser">
            <input type="hidden" name="id" value="${user.id}">
                <button type="submit" > Править </button>
            </form>
        </td>
        <td width=1% height=1%>
            <form method="post" action="http://localhost:8080/crudtesttask/user-module/deleteUser">
            <input type="hidden" name="id" value="${user.id}">
                <button type="submit" > Удалить </button>
            </form>
        </td>
    </tr>
    </c:forEach>
</table>
<br>
<br>
<br>

</body>
</html>
