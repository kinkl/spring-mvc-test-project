<%--
  Created by IntelliJ IDEA.
  User: kkin
  Date: 21.04.2015
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>   
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Adding new cat</title>
</head>
<body>
<sf:form method="post" modelAttribute="funnyCat" enctype="multipart/form-data">
    <fieldset>
        <table cellspacing="0">
            <tr>
                <sf:errors path="*"/>
            </tr>
            <tr>
                <th><label for="kitty_name">Имя котика:</label></th>
                <td>
                    <sf:input path="name" size="15" id="kitty_name"/><%--<br/>
                    <sf:errors path="name"/>--%>
                </td>
            </tr>
            <%--<tr>
                <th><label for="kitty_file">Имя файла:</label></th>
                <td>
                    <sf:input path="filename" size="20" id="kitty_file"/><small>No spaces, please.</small><br/>
                    <sf:errors path="filename" delimiter=", "/>
                </td>
            </tr>--%>
            <tr>
                <th><label for="kitty_image">Аватар котика:</label></th>
                <td>
                    <input name="kitty_image" type="file" />
                </td>
            </tr>
        </table>
        <input type="submit" value="Добавить нового котика!!"/>
    </fieldset>
</sf:form>
    <%--<form action="/validate" method="get">
        <label>Name:</label>
        <input type="text" name="cat_name" placeholder="Введите имя котика"/>
        <label>File</label>
        <input type="text" name="cat_file" placeholder="Введите имя файла"/>
        <input type="submit" value="Validate!"/>
    </form>--%>

</body>
</html>
