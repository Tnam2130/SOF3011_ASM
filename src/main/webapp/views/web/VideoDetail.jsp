<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>${video.title}</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"
            integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ=="
            crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>
<jsp:include page="../common/User/header.jsp"></jsp:include>

<div class="wrapper">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-md-12 col-sm-12">
                <div class="card border-0">
                    <div class="card-img-top ratio ratio-16x9">
                        <iframe src="https://www.youtube.com/embed/${video.href}?autoplay=1&mute=1" frameborder="0"
                                title="YouTube video" style="border-top-right-radius: 4px; border-top-left-radius: 4px;"
                                allowfullscreen></iframe>
                        <%--                        <input type="hidden" id="vIdHdn" value="${video.href}"/>--%>
                    </div>
                    <div class="card-body">
                        <h4 class="card-title">${video.title}</h4>
                        <div class="desc mt-3">
                            <p class="mt-2">
                                ${video.description}
                            </p>
                        </div>
                    </div>
                    <c:if test="${not empty sessionScope.currentUser}">
                        <div class="card-footer pb-3 border-0" style="background-color: transparent;">
                            <c:choose>
                                <c:when test="${flagLikeBtn == true}">
                                    <a id="likeOrUnLikeBtn" href="video?action=like&id=${video.href}"
                                       class="bi bi-suit-heart-fill text-danger me-2 rounded-4">
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a id="likeOrUnLikeBtn" href="video?action=like&id=${video.href}"
                                       class="bi bi-heart text-danger me-2 rounded-4">
                                    </a>
                                </c:otherwise>
                            </c:choose>
                            <a><i class="bi bi-share-fill text-primary"></i></a>
                        </div>
                    </c:if>
                </div>
            </div>
            <div class="col-lg-4 col-md-12 col-sm-12">
                <c:forEach var="video" items="${videos}">
                    <div class="card p-3 border-0">
                        <div class="row">
                            <div class="col-8"><img class="img-fluid"
                                                    src="https://img.youtube.com/vi/${video.href}/sddefault.jpg"
                                                    alt=""></div>
                            <div class="col-4 ps-0 mt-2">
                                <h5 class="paragraph-text card-text">${video.title}</h5>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <script type="text/javascript">
            var $ = jQuery;
            jQuery('#likeOrUnLikeBtn').click(function (event) {
                event.preventDefault();
                jQuery.ajax(this.href, {
                    success: function (data) {
                        jQuery(`#likeOrUnLikeBtn`).toggleClass('bi bi-heart')
                        jQuery(`#likeOrUnLikeBtn`).toggleClass('bi bi-suit-heart-fill')
                    },
                    error: function (error) {
                        alert("Error")
                    }
                })
            })
        </script>
    </div>
</div>
</body>
<jsp:include page="../common/head.jsp"></jsp:include>
</html>
