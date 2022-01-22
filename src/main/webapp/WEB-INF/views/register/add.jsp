<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@include file="../header_footer/header.jsp"%>
<section class="login-page">
    <h2>Załóż konto</h2>
    <form:form modelAttribute="user">
        <form:hidden path="id"/>
        <h1 class="text-color-darker">Rejestracja</h1>
        <div class="form-group">
            <form:input path="username" type="text" class="form-control" id="username" name="username" placeholder="Login"/>
            <form:errors path="username"/><br>
        </div>
        <div class="form-group">
            <form:input type="email" path="email" class="form-control" id="email" name="email" placeholder="Email"/>
            <form:errors path="email"/><br>
        </div>
        <div class="form-group">
            <form:input type="password" path="password" class="form-control" id="password" name="password" placeholder="Hasło"/>
            <form:errors path="password"/><br>
        </div>
     <%--   <div class="form-group">
            <form:input type="password" path="confirmPassword" class="form-control" id="password" name="password" placeholder="Powtórz hasło"/>
            <form:errors path="confirmPassword"/><br>
        </div>--%>
        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Załóż konto</button>
            <a href="/login" class="btn btn--without-border">Zaloguj się</a>
        </div>
    </form:form>
</section>
<script type="text/javascript" src="@{/webjars/jquery/3.2.1/jquery.min.js/}"></script>
<script type="text/javascript" src="@{/webjars/bootstrap/3.3.7/js/bootstrap.min.js}"></script>
<%@include file="../header_footer/footer.jsp"%>
</body>
</html>