<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<jsp:include page="../common/User/header.jsp"></jsp:include>

    <div class="container col-4 p-5 mt-5 shadow rounded-2">
        <form id="register-form" action="register" method="POST">
            <h5 class="mb-3 text-center">Register</h5>
            <div class="form-floating mb-3">
                <input type="text" class="form-control" name="username" id="username" placeholder="Username" required>
                <label for="username">Username</label>
            </div>
            <div class="form-floating mb-3">
                <input type="password" class="form-control" name="password" id="password" placeholder="password" required>
                <label for="password">Password</label>
            </div>
            <div class="form-floating mb-3">
                <input type="email" class="form-control" name="email" id="email" placeholder="email" required>
                <label for="email">Email</label>
            </div>
            <button type="submit" class="btn btn-primary mt-2 w-100">Register</button>
            <div>${message}</div>
            <p class="text-center mt-2">If you have account? <a href="${pageContext.request.contextPath}/login" class="text-primary">Login now</a></p>
        </form>
    </div>
</body>
<jsp:include page="../common/head.jsp"></jsp:include>

</html>
