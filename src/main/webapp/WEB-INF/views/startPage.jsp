<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

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
     <caption align=top>
                  <h2> Добавить нового пользователя </h2>
              </caption>

            <form method="post" action="http://localhost:8080/crudtesttask/user-module/addNewUser" align=center>
            <tr>
                <td><input type="text" name="name" placeholder="фамилия и имя"></td>
                <td><input type="text" name="age" placeholder="возраст"></td>
                <td><input type="text" name="admin" list="boolean" placeholder="админ?"></td>
                <datalist id="boolean">
                               <option value="true">
                               <option value="false">
                </datalist>
                <td><input type="submit" value="Новый пользователь"></td>
            </form>
            </tr>
            </table>
     <br>
     <br>

<table  align=center width=50%  border=2>

<caption align=top>
             <h2>Наши пользователи</h2>
         </caption>

    <tr>
        <th align=center>Фамилия и имя пользователя</th>
        <th  align=center>Возраст</th>
        <th  align=center>Является ли администратором</th>
        <th  align=center>Дата создания учетной записи</th>
    </tr>

    <c:forEach items="${userList}" var="user">
    <tr>
        <td  >${user.name}</td>
        <td  align=center>${user.age}</td>
        <td align=center> <input type="checkbox" <c:if test="${user.admin}"> checked </c:if> > </td>
        <td  align=center>${user.createdDate}</td>
        <td  >

            <form method="post" action="http://localhost:8080/crudtesttask/user-module/editUser">
            <input type="hidden" name="id" value="${user.id}">
                <button type="submit" > Править </button>
            </form>

        </td>
        <td >
            <form method="post" action="http://localhost:8080/crudtesttask/user-module/deleteUser">
            <input type="hidden" name="id" value="${user.id}">
                <button type="submit" > Удалить </button>
            </form>
        </td>
    </tr>
    </c:forEach>
</table>
<br>
<!--%@ taglib prefix="r" uri="/WEB-INF/tags" %>-->
<!--<r:pager page="${results}" pageParam="page"/>-->
<br>
<br>
<br>

</body>
</html>
