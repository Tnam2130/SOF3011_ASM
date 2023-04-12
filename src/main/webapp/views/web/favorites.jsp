<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Favorites</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"
            integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ=="
            crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>
<div class="wrapper">
    <jsp:include page="../common/User/header.jsp"></jsp:include>
    <div class="container-fluid">
        <div class="row">
            <%--        <div class="col-2">--%>
            <%--            <jsp:include page="../common/sideBars.jsp"></jsp:include>--%>
            <%--        </div>--%>
            <div class="col-2 ps-1">
                <jsp:include page="../common/User/sideBars.jsp"></jsp:include>
            </div>
            <div class="col-10">
                <div class="row row-cols-lg-3 row-cols-md-2 row-cols-sm-1">
                    <c:forEach var="video" items="${videos}">
                        <div class="col">
                            <div class="card my-1 my-sm-1 border-0 mx-1 p-2 pb-md-5 mb-5">
                                <a href="<c:url value="/video?action=watch&id=${video.href}"/>">
                                    <img class="card-img-top img-fluid"
                                         src="https://img.youtube.com/vi/${video.href}/sddefault.jpg" alt=""
                                         style="height: 211px; object-fit: cover">
                                </a>
                                <div class="card-body d-flex align-content-center px-0 pb-1"
                                     style="border-top: 1px solid var(--bs-card-border-color); position: relative;">
                                    <div class="card-avatar">
                                        <img src="https://yt3.ggpht.com/yti/AHXOFjUYiEO2xjytyR9y49Kylw-fh-2khoCXBexN-NHqdg=s88-c-k-c0x00ffffff-no-rj-mo"
                                             alt=""
                                             style=" border-radius: 50%; object-fit: cover">
                                    </div>
                                    <a href="<c:url value="/video?action=watch&id=${video.href}"/>">
                                        <h5 class=" card-title paragraph ms-2">${video.title}</h5>
                                </div>
                                <div class="card-footer pb-3 p-0 d-block "
                                     style="background-color: transparent; border: none; position: absolute; top: auto; left: 20%;">
                                    <div class="username-title">PHÚC DU - Official</div>
                                    <div class="view">${video.views} lượt xem</div>
                                </div>
                                </a>
                            </div>
                                <%--<i class="bi bi-share-fill text-primary" data-bs-toggle="modal" data-bs-target="#exampleModal3" data-bs-dismiss="modal"></i>--%>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../common/User/pagination.jsp"></jsp:include>
<jsp:include page="../common/User/modal.jsp"></jsp:include>
</div>
</body>
<jsp:include page="../common/head.jsp"></jsp:include>
</html>

