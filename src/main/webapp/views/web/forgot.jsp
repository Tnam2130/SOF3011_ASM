<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"
        integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<html>
<head>
    <title>Forgot password</title>
</head>
<body>
<jsp:include page="../common/User/header.jsp"></jsp:include>
<div class="container col-4 p-5 mt-5 shadow rounded-2">
    <h5 class="mb-3 text-center">Forgot Password</h5>
        <div class="form-floating mb-3">
            <input type="email" class="form-control" name="email" id="email" placeholder="email" required>
            <label for="email">Email</label>
        </div>
        <button type="submit"id="sendBtn" class="btn btn-primary mt-2 w-100">Send</button>
        <p class="fs-6 text-danger" id="msg"></p>
        <p class="text-center mt-2">If you don't have account? <a href="${pageContext.request.contextPath}/register" class="text-primary">Register now</a></p>
</div>
</body>
<jsp:include page="../common/head.jsp"></jsp:include>
<script type="text/javascript">
    var $ = jQuery;
    jQuery('#sendBtn').click(function (event){
        event.preventDefault();
        jQuery('#msg').text('')
        let email = jQuery('#email').val();
        let formData={'email':email};
        jQuery.ajax({
            url: 'forgot-password',
            type: 'POST',
            data: formData
        }).then(function (data){
            jQuery('#msg').text('Password is reset, check your email!!!')
            setTimeout(function (){
                window.location.href='http://localhost:8080/asm/home';
            }, 5*1000)
        }).fail(function (error){
            jQuery('#msg').text('Email is not correct, try again!!!')
        })
    })
</script>
</html>
