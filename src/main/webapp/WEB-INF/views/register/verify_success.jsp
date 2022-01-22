<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@include file="../header_footer/header.jsp"%>
<section class="login-page">
    <div class="container text-center">
        <h3>Congratulations <%--<sec:authentication property="principal.username"/>--%>, your account has been verified.</h3>
        <h4><a href="/login">Click here to Login</a></h4>
    </div>
</section>
<%@include file="../header_footer/footer.jsp"%>
</body>
</html>