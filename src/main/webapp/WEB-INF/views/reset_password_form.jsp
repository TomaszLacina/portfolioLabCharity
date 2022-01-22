<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>

<div>
    <h2>Reset Your Password</h2>
</div>

<form th:action="@{/reset_password}" method="post" style="max-width: 350px; margin: 0 auto;">
    <input type="hidden" name="token" th:value="${token}" />
    <div class="border border-secondary rounded p-3">
        <div>
            <p>
                <input type="password" name="password" id="password" class="form-control"
                       placeholder="Enter your new password" required autofocus />
            </p>
         <%--   <p>
                <input type="password" class="form-control" placeholder="Confirm your new password"
                       required oninput="checkPasswordMatch(this);" />
            </p>--%>
            <p class="text-center">
                <input type="submit" value="Change Password" class="btn btn-primary" />
            </p>
        </div>
    </div>
</form>
<script src="jquery.min.js"></script>
<script type="text/javascript">
    function checkPasswordMatch(fieldConfirmPassword) {
        if (fieldConfirmPassword.value != $("#password").val()) {
            fieldConfirmPassword.setCustomValidity("Passwords do not match!");
        } else {
            fieldConfirmPassword.setCustomValidity("");
        }
    }
</script>