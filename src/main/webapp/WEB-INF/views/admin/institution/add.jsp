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

<h2>Dodaj nową instytucje</h2>
<form:form modelAttribute="institution">
    <form:hidden path="id"/>
    Nazwa: <form:input path="name"/><br>
    <form:errors path="name" cssClass="error"/> <br>

    Opis:  <form:textarea path="description"/><br>
    <form:errors path="description" cssClass="error"/> <br>

    <input type="submit" value="Zapisz">
</form:form>