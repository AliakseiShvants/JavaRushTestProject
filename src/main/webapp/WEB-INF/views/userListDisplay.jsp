<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
    <meta charset="utf-8">
    <title> Spring MVC CrudTestTask </title>
   </head>

<body bgcolor=white>

<table  align=center  width=72% border=1>
    <caption align=top>
        <h1>Наши пользователи</h1>
    </caption>

    <tr>
        <th  >Фамилия пользователя</th>
        <th  >Возраст</th>
        <th  >Является ли администратором</th>                             
        <th  >Дата создания учетной записи</th>
    </tr>

    <c:forEach items="${userList}" var="user">
    <tr>
        <td>${user.name}</td>
        <td>${user.age}</td>
        <td>${user.admin}</td>
        <td>${user.createdDate}</td>
        <td><button>Править</button></td>
        <td><button>Удалить</button></td>
    </tr>
    </c:forEach>
</table>

    <form align=center>
        <table align=center width=72% border=1>
            <tr>
                <td width=6%><input type="text" value="Фамилия"></td>
                <td width=6%><input type="text" value="Возраст"></td>
                <td width=6%><input type="text" value="админ?"></td>
                <td width=36%><input type="submit" value="new user"></td>
            </tr>
        </table>
    </form>

</body>
</html>
