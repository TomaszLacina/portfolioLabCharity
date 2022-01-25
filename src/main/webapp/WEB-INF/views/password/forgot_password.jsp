<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>

<%@include file="../header_footer/header.jsp"%>
<div>
    <h2>Odzyskaj hasło</h2>
</div>

<form th:th:action="@{/forgot_password}" method="post" style="max-width: 420px; margin: 0 auto;">
    <div class="border border-secondary rounded p-3">
        <h1 class="text-color-darker">Link do zmiany hasła prześlemy na maila</h1>
        <div>
            <div class="form-group">
                <label><input type="email" name="email" class="form-control" placeholder="Enter your e-mail" required autofocus/></label>
            </div>
            <div class="form-group form-group--buttons">
                <input type="submit" value="Send" class="btn btn-primary" />
            </div>>
        </div>
    </div>
</form>
<%@include file="../header_footer/footer.jsp"%>