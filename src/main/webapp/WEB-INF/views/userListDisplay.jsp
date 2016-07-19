<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
    <title> Spring MVC CrudTestTask </title>
   </head>

<body bgcolor=white>

<table  align=center  width=66% border=1>
    <caption align=top>
        <h1>Наши юзеры</h1>
    </caption>

    <tr>
        <th  width=32%>Имя юзера</th>
        <th  width=8%>Возраст</th>
        <th  width=8%>Админ?</th>
        <th  width=18%>Дата создания записи</th>
    </tr>

    <c:forEach items="${userList}" var="user">
    <tr>
        <td>${user.name}</td>
        <td>${user.age}</td>
        <td>${user.admin}</td>
        <td>${user.createdDate}</td>
    </tr>
    </c:forEach>
</table>

    <form align=center>
        <table align=center width=66% border=1>
            <tr>
                <td  width=36%><input type="text"></td>
                <td  width=8%><input type="text"></td>
                <td  width=8%><input type="text"></td>
                <td  width=18%><input type="submit" value="Новый user"></td>
            </tr>
        </table>
    </form>

</body>
</html>