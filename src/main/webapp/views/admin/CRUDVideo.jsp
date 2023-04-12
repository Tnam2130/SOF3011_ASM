<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <jsp:include page="../common/head.jsp"></jsp:include>
</head>
<body>
<div>
    <jsp:include page="../common/User/header.jsp"></jsp:include>
    <nav class="container">
        <div class="nav nav-tabs" id="nav-tab" role="tablist">
            <button class="nav-link active" id="nav-home-tab" data-bs-toggle="tab" data-bs-target="#nav-home"
                    type="button" role="tab" aria-controls="nav-home" aria-selected="true">Video Edition
            </button>
            <button class="nav-link" id="nav-profile-tab" data-bs-toggle="tab" data-bs-target="#nav-profile"
                    type="button" role="tab" aria-controls="nav-profile" aria-selected="false">Video List
            </button>
        </div>
    </nav>
    <div class="tab-content container" id="nav-tabContent">
        <div class="tab-pane fade show active mt-3" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
            <form id="form-video" action="CRUD-Video" method="POST"
                  style="background-color: rgba(225, 225, 225, 0.2);"
                  class="row rounded shadow p-3 py-4 mt-2">
                <div class="col-4">
                    <img id="poster" style="width: 100%;" class=" rounded me-3"
                         src="https://innovating.capital/wp-content/uploads/2021/05/placeholder-image-dark.jpg"
                         alt="">
                </div>
                <div class="col-8">
                    <div class="row">
                        <div class="col-3">
                            <div class="mb-3">
                                <label for="Href" class="form-label">Video Href:</label>
                                <input required type="text" name="Href" id="Href" value="${form.href}"
                                       class="form-control border-secondary shadow-none "
                                       placeholder="" aria-describedby="helpId">
                            </div>
                        </div>
                        <div class="col-9">
                            <div class="mb-3">
                                <label for="Title" class="form-label">Title Video:</label>
                                <input required type="text" name="Title" id="Title" value="${form.title}"
                                       class="form-control border-secondary shadow-none "
                                       placeholder="" aria-describedby="helpId">
                            </div>
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="description" class="form-label">Video description:</label>
                        <textarea class="form-control border-secondary shadow-none "
                                  name="description" id="description" rows="2">${form.description}</textarea>
                    </div>
                    <hr>

                    <div class="d-flex gap-2">
                        <c:choose>
                            <c:when test="${status == 'Create'}">
                                <button id="submitButton" name="submitButton" value="Create" type="submit"
                                        class="flex-grow-1 btn btn-danger">Create
                                </button>
                            </c:when>
                            <c:when test="${status == 'Update'}">
                                <button name="submitButton" value="Update" type="submit"
                                        class="flex-grow-1 btn btn-danger">Update
                                </button>
                            </c:when>
                        </c:choose>
                        <a name=""
                           id="reset_form_video" class="btn btn-outline-secondary" href="#" role="button"><i
                                class="bi-arrow-counterclockwise"></i></a>
                    </div>
                </div>
            </form>
        </div>
        <div class="tab-pane fade mt-3" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
            <div class="container mt-3">
                <div style="background-color: rgba(225, 225, 225, 0.2);"
                     class="row rounded shadow p-3 py-4 mt-4">
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                            <tr class="fs-6 fw-bold">
                                <th>Thumbnail</th>
                                <th>Href</th>
                                <th>Video title</th>
                                <th>Description</th>
                                <th>View</th>
                                <th>Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${videos}" var="video">
                                <tr class="align-middle">
                                    <td class="col-2"><a
                                            href="video?action=watch&Id=${video.href}"> <img
                                            style="height: 87px; object-fit: cover;"
                                            src="https://img.youtube.com/vi/${video.href}/mqdefault.jpg"
                                            class="w-100 rounded" alt="">
                                    </a></td>
                                    <td class="col"><a class="link-info"
                                                       href="video?action=watch&Id=${video.href}">${video.href}</a></td>
                                    <td class="col-3">${video.title}</td>
                                    <td class="col-6">${video.description != '' ? video.description : 'Chưa có mô tả'}</td>
                                    <td class="col text-center">0</td>
                                    <td class="col text-center"><a class="text-primary"
                                                                   href="video?action=Edit&Id=${video.href}"
                                                                   role="button"><i
                                            class="h5 bi bi-pencil-square"></i></a>
                                        <a class="text-danger" href="video?action=Delete&Id=${video.href}"
                                           role="button"><i
                                                class="h5 bi bi-trash3"></i></a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script src="js/showPoster.js"></script>
<jsp:include page="../common/head.jsp"></jsp:include>
</html>




