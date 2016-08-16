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
     <table align=center>

        <caption align=top>
            <h2> Добавить нового пользователя </h2>
        </caption>

            <form method="post" action="http://localhost:8080/crudtesttask/user-module/addNewUser" align=center>
                <tr>
                    <td><input type="text" name="name" placeholder="фамилия и имя"></td>
                    <td><input type="text" name="age" placeholder="возраст"></td>
                    <td align=center>
                            <input type="radio" name="admin" value="true"> да
                            <input type="radio" name="admin" value="false" checked> нет
                        </td>
                    <td><input type="submit" value="Новый пользователь"></td>
                </tr>
            </form>
     </table>
     <br>
     <br>

    <table  align=center width=50%  border=1>

        <caption align=top>
             <h2>Наши пользователи</h2>
         </caption>

        <tr>
            <th align=center>Фамилия и имя пользователя</th>
            <th  align=center>Возраст</th>
            <th  align=center>Является ли администратором</th>
            <th  align=center>Дата создания учетной записи</th>
            <th  align=center></th>
            <th  align=center></th>
        </tr>

        <form method="post" action="http://localhost:8080/crudtesttask/user-module/searchUser" align=center>
            <c:set var="searchCriteria" value="${searchCriteria}" scope="session"  />
            <tr>
                <td align=center><input type="text" name="name" value="${sessionScope.searchCriteria.name}" placeholder="фамилия и имя"></td>
                <td align=center><input type="text" name="age" value="${sessionScope.searchCriteria.age}" placeholder="возраст"></td>
                <td align=center>
                    <select name="admin">
                        <option <c:if test="${sessionScope.searchCriteria.admin ==''}"> selected </c:if> value="">Не выбран</option>
                        <option <c:if test="${sessionScope.searchCriteria.admin == 'true'}"> selected </c:if> value="true">да</option>
                        <option <c:if test="${sessionScope.searchCriteria.admin == 'false'}"> selected </c:if> value="false">нет</option>
                   </select>
                </td>
                <td></td>
                <td align=center><input type="submit" value="Найти"></td>
                <td><input type="reset" value="Сбросить"></td>
            </tr>
        </form>


        <c:forEach items="${userList}" var="user">
        <tr>
            <td>${user.name}</td>
            <td align=center>${user.age}</td>
            <td align=center> <input type="checkbox" <c:if test="${user.admin}"> checked </c:if> > </td>
            <td align=center>${user.createdDate}</td>
            <td align=center>

                <form method="post" action="http://localhost:8080/crudtesttask/user-module/editUser">
                    <input type="hidden" name="id" value="${user.id}">
                    <button type="submit" > Править </button>
                </form>
            </td>
            <td align=center>
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
