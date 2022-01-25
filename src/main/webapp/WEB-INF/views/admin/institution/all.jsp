<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<a href="/dashboard/index">Menu główne</a>
<a href="add">Dodaj nową instytucje</a>
<hr>

<hr>
<c:forEach items="${institution}" var="i">
    <strong><c:out value="${i.name}"/></strong><br>
    <strong><c:out value="${i.description}"/></strong><br>
    <br />
    <a href="edit?idToEdit=${i.id}">
        Edytuj
    </a>
    </br />
    <a href="remove?toRemoveId=${i.id}">
        Usuń
    </a>
    <hr>
</c:forEach>