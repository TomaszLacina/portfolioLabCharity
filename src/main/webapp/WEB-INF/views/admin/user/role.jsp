<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<a href="/dashboard/index">Menu główne</a>
<a href="/admin/user/add">Dodaj nowego admina</a>
<hr>
<hr>
<c:forEach items="${user}" var="u">
    <strong><c:out value="${u.username}"/></strong><br>
    <c:out value="${u.email}"/><br>
    <c:out value="${u.enabled}"/><br>
    <c:forEach items="${u.roles}" var="r" varStatus="loop">
        <strong><c:out value="${r.name}"/></strong><c:if test="${loop.index + 1 lt b.authors.size()}">; </c:if>
    </c:forEach>
    <br>
    <td class="col-2"><a href="edit?idToEdit=${u.id}">
        Edytuj
    </a>
    <br>
    <a href="remove?toRemoveId=${u.id}">
        Usuń
    </a>
    <hr>
</c:forEach>