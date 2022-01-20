<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<head>
    <style>
        .error {
            color: red;
            border: 2px solid;
        }
    </style>
</head>

<h2>Edytuj użytkownika</h2>
<form:form modelAttribute="user">
    <form:hidden path="id"/>
    Nazwa użytkownika: <form:input path="username"/><br>
    <form:errors path="username" cssClass="error"/> <br>
    Email:  <form:input path="email"/><br>
    <form:errors path="email" cssClass="error"/> <br>
    Hasło: <form:password path="password"/><br>
    <form:errors path="password" cssClass="error"/> <br>
    Aktywne: <form:input path="enabled"/><br>
    <form:errors path="enabled" cssClass="error"/> <br>
    Role: <form:checkboxes path="roles" items="${roles}" itemLabel="name" itemValue="id"/><br>
    <form:errors path="roles" cssClass="error"/> <br>
    <input type="submit" value="Zapisz">
</form:form>