<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>

<%@include file="../header_footer/header.jsp"%>
<div>
    <h2>Reset hasła</h2>
</div>

<form th:action="@{/reset_password}" method="post" style="max-width: 350px; margin: 0 auto;">
    <input type="hidden" name="token" th:value="${token}" />
    <div class="border border-secondary rounded p-3">
        <div>
            <div class="form-group">
                <label><input type="password" name="password" id="password" class="form-control"
                              placeholder="Enter your new password" /></label>
            </div>
            <div class="form-group">
                <label><input type="password" name="confirmPassword" class="form-control" placeholder="Confirm your new password"/></label>
            </div>
            <div class="form-group form-group--buttons">
                <input type="submit" value="Change Password" class="btn btn-primary" />
            </div>
        </div>
    </div>
</form>
<%@include file="../header_footer/footer.jsp"%>
