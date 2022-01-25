<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <style>
        .error {
            color: red;
            border: 2px solid;
        }
    </style>
</head>

<form:form modelAttribute="donation">
    <form:hidden path="id"/>
    <form:hidden path="quantity"/>
    <form:hidden path="categories"/>
    <form:hidden path="institutions"/>
    <form:hidden path="street"/>
    <form:hidden path="city"/>
    <form:hidden path="zipCode"/>
    <form:hidden path="phone"/>
    <form:hidden path="pickUpDate"/>
    <form:hidden path="pickUpTime"/>
    <form:hidden path="pickUpComment"/>
    <form:hidden path="user"/>
    Status: <form:select path="statuses" items="${statuses}" itemLabel="name" itemValue="id"/><br>
    <form:errors path="statuses" cssClass="error"/> <br>
    <input type="submit" value="Zapisz">
</form:form>