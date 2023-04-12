<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Dash Board</title>
    <jsp:include page="../common/head.jsp"></jsp:include>
    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"
            integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ=="
            crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>

<body id="page-top">
<!-- Page Wrapper -->
<div id="wrapper">
    <jsp:include page="../common/Admin/sideBarsAdmin.jsp"></jsp:include>
    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">
        <!-- Main Content -->
        <div id="content">
            <!-- Topbar -->
            <jsp:include page="../common/Admin/headerAdmin.jsp"></jsp:include>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container-fluid">
                <!-- Page Heading -->
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <h1 class="h3 mb-0 text-gray-800">Home</h1>
                    <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                            class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
                </div>
                <!-- /.container-fluid -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">Favorites Statistical</h6>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                <tr class="text-center">
                                    <th class="text-center"><b>Thumbnail</b></th>
                                    <th class="text-center"><b>Title</b></th>
                                    <th class="text-center"><b>Link</b></th>
                                    <th class="text-center"><b>Total Like</b></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${videos}" var="item">
                                    <tr>
                                        <td><img class="img-fluid"
                                                 src="https://img.youtube.com/vi/${item.href}/sddefault.jpg" alt=""
                                                 style="height: 211px; object-fit: cover; border-radius: 5px"></td>
                                        <td>${item.title}</td>
                                        <td><a href="video?action=watch&id=${item.href}">video?action=watch&id=${item.href}</a></td>
                                        <td>${item.totalLike}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
<%--                <div class="card shadow mb-4">--%>
<%--                    <div class="card-header py-3">--%>
<%--                        <h6 class="m-0 font-weight-bold text-primary">Favorites Info</h6>--%>
<%--                    </div>--%>
<%--                    <div class="card-body">--%>
<%--                        <div class="mb-3">--%>
<%--                            <label class="form-label">List Video</label>--%>
<%--                            <select class="form-select form-select-md" name="selectVideo" id="selectVideo">--%>
<%--                                <option selected disabled>Select one</option>--%>
<%--                                <c:forEach items="${videos}" var="video">--%>
<%--                                    <option value="${video.href}">${video.title}</option>--%>
<%--                                </c:forEach>--%>
<%--                            </select>--%>
<%--                        </div>--%>
<%--                        <div class="table-responsive">--%>
<%--                            <table class="table table-bordered" id="dataTable2" width="100%" cellspacing="0">--%>
<%--                                <thead>--%>
<%--                                <tr>--%>
<%--                                    <th>Username</th>--%>
<%--                                    <th>Email</th>--%>
<%--                                </tr>--%>
<%--                                </thead>--%>
<%--                                <tbody>--%>
<%--                                </tbody>--%>
<%--                            </table>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
                <div class="row">
                    <div class="col-sm-12 col-md-5">
                        <div class="dataTables_info" id="dataTable_info">Showing 1 to 1 of 1 entries</div>
                    </div>
                    <div class="col-sm-12 col-md-7">
                        <div class="d-flex justify-content-end">
                            <ul class="pagination">
                                <li class="page-item disabled"><a href="#" class="page-link">Previous</a></li>
                                <li class="page-item active"><a href="#" class="page-link">1</a></li>
                                <li class="page-item disabled"><a href="#" class="page-link">Next</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End of Main Content -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="js/dataTables.js"></script>
<%--        <script>--%>
<%--            $('#selectVideo').change(function (){--%>
<%--                let videoHref=$(this).val();--%>
<%--                $.ajax({--%>
<%--                    url:'admin/fav?href='+videoHref,--%>
<%--                    type:'GET',--%>
<%--                    contentType: 'application/json'--%>
<%--                }).done(function (data){--%>
<%--                    $('#dataTable2').DataTable({--%>
<%--                        destroy: true,--%>
<%--                        "paging":true,--%>
<%--                        "lengthChange":false,--%>
<%--                        "searching":false,--%>
<%--                        "ordering":true,--%>
<%--                        "info":true,--%>
<%--                        "autoWidth":false,--%>
<%--                        "responsive":true,--%>
<%--                        "aaData":data,--%>
<%--                        "columns":[{"data":"username"},{"data":"email"}]--%>
<%--                    });--%>
<%--                }).fail(function (error){--%>
<%--                    $('#dataTable2').dataTable().fnClearTable();--%>
<%--                })--%>
<%--            });--%>
<%--        </script>--%>
</body>
</html>
