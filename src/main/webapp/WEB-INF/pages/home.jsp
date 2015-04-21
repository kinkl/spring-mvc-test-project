<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home title</title>
</head>
<body>
<div>
    <a href="/edit_cat?new">ADD NEW KITTY!</a>
</div>
<h2>Items:</h2>
<div>
    <ol>
    <c:forEach var="spittle" items="${spittles}">
        <li>
            <div><%--<s:url value="/spitters/{spitterName}" var="spitter_url">
                <s:param name="spitterName" value="${spittle.filename}"/>
            </s:url>--%>
            <form action="/funny_cats/gifs/${spittle.name}" method="get">
                <input type="submit" value="Go to ${spittle.name}'s page"/>
            </form>
            <%--<a href="${spitter_url}">${spittle.name}</a>--%>
            <img src="/${spittle.filename}"/></div>
        </li>
    </c:forEach>
    </ol>
</div>
</body>
</html>
