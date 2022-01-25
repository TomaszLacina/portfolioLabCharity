<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
    <link href='<c:url value="../../../../resources/css/style.css"/>' rel="stylesheet" type="text/css">
</head>
<body>
<header class="header--form-page">
    <nav class="container container--70">
        <ul class="nav--actions">
            <li class="logged-user">
                <%--<sec:authentication property="principal.username"/>--%>
                <ul class="dropdown">
                    <li><a href="/user/user/edit">Profil</a></li>
                    <li><a href="/user/donation/all">Moje zbiórki</a></li>
                    <li><a href="/user/user/edit_password">Zmień hasło</a></li>
                    <li><a href="/">Wyloguj</a></li>
                </ul>
            </li>
        </ul>

        <ul>
            <li><a href="index.html" class="btn btn--without-border active">Start</a></li>
            <li><a href="index.html#steps" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="index.html#about-us" class="btn btn--without-border">O nas</a></li>
            <li><a href="index.html#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="index.html#contact" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>

    <div class="slogan container container--90">
        <h2>
            Edytuj dane
        </h2>
    </div>
</header>
<section class="login-page">
    <form:form modelAttribute="user">
        <form:hidden path="id"/>
        <form:hidden path="password"/>
        <form:hidden path="enabled"/>
        <form:hidden path="verificationCode"/>
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
<%@include file="../../header_footer/footer.jsp"%>
</body>
</html>