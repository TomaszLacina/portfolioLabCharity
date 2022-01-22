<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@include file="../header_footer/header.jsp"%>
<section class="login-page">
    <form:form modelAttribute="user">
        <form:hidden path="id"/>
        <form:hidden path="password"/>
        <form:hidden path="enabled"/>
        <form:hidden path="verificationCode"/>
        <h1 class="text-color-darker">Edytuj dane</h1>
        <div class="form-group">
            <form:input path="username"/>
            <form:errors path="username" /><br/>
        </div>
        <div class="form-group">
            <form:input path="email"/>
            <form:errors path="email" /><br/>
        </div>
      <%--  <div class="form-group">
            <form:input type="password" path="password2" class="form-control" id="password" name="password" placeholder="Powtórz hasło"/>
            <form:errors path="password2"/><br>
        </div--%>
        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Wyślij</button>
        </div>
    </form:form>
</section>
<%@include file="../header_footer/footer.jsp"%>
</body>
</html>