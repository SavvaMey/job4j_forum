<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<form  action="<c:url value='/save'/>" method='POST'>
    <table>
        <tr>
            <td>id:</td>
            <td><input type='text' readonly  name='id' value="${post.id}"></td>
        </tr>
        <tr>

            <td>Название:</td>
            <td><input type='text' name='name' value="${post.name}"></td>
        </tr>
        <tr>
            <td>Описание:</td>
            <td><input type='text' size="100" name='desc' value="${post.desc}"></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Save" /></td>
        </tr>
    </table>
</form>
</body>
</html>