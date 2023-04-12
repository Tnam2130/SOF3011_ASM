<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<jsp:include page="../common/User/header.jsp"></jsp:include>
<div class="container col-4 p-5 mt-5 shadow rounded-2">
    <form id="login-form" action="login" method="POST">
    <h5 class="mb-3 text-center">LOGIN</h5>
        <div class="form-floating mb-3">
            <input type="text" class="form-control" name="username" id="username" placeholder="Username" required>
            <label for="username">Username</label>
        </div>
        <div class="form-floating mb-3">
            <input type="password" class="form-control" name="password" id="password" placeholder="password" required>
            <label for="password">Password</label>
        </div>
        <div class="d-flex justify-content-between">
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="" style="border: 0.5px solid #999;">
                <label class="form-check-label" for="">
                    Remember Me?
                </label>
            </div>
            <a href="forgot-password" class="text-primary">Forgot Password</a>
        </div>
        <button type="submit" class="btn btn-primary mt-2 w-100">Sign In</button>
        <p class="fs-2 text-danger">${message}</p>
        <p class="text-center mt-2">If you don't have account? <a href="${pageContext.request.contextPath}/register" class="text-primary">Register now</a></p>
    </form>
</div>
</body>
<jsp:include page="../common/head.jsp"></jsp:include>

</html>
