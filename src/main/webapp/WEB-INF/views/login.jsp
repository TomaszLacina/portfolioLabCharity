<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@include file="header_footer/header.jsp"%>
<section class="login-page">
    <h2>Zaloguj się</h2>
    <form method="post">
        <div class="form-group">
            <label><input type="text" name="username" placeholder="username"/> </label></div>
        <div class="form-group">
            <label><input type="password" name="password" placeholder="Hasło"/> </label></div>
        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Zaloguj się</button>
            <a href="/register/add" class="btn btn--without-border">Załóż konto</a>
        </div>
        <a href="/forgot_password">Forgot your password?</a>
 </form>
</section>
<%@include file="header_footer/footer.jsp"%>
</body>
</html>
