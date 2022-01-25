<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<a href="/dashboard/index">Menu główne</a>
<hr>

<hr>
<c:forEach items="${donation}" var="d">
    <strong>Liczba oddanych worków: <c:out value="${d.quantity}"/></strong><br>
    <strong><c:out value="${d.institutions.name}"/></strong><br>
    <c:forEach items="${d.statuses}" var="s" varStatus="loop">
        <strong><c:out value="${s.name}"/></strong><c:if test="${loop.index + 1 lt d.statuses.size()}">; </c:if>
    </c:forEach>
    <br />
    <a href="edit?idToEdit=${d.id}">
        Edytuj status
    </a>
    <hr>
</c:forEach>