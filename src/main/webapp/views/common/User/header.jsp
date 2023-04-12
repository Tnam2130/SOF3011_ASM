<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="mb-3">
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/home"><img
                    src="${pageContext.request.contextPath}/img/youtube.svg"
                    style="max-width: 75px;"
                    alt=""></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <div class="w-100"></div>
                <form class="d-flex w-100" role="search">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
                <ul class="navbar-nav me-auto mb-2 mb-lg-0 d-flex justify-content-end w-100">
                    <c:choose>
                    <c:when test="${empty sessionScope.currentUser}">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                           aria-expanded="false">
                            <i class="fa-solid fa-circle-user" style="font-size: 20px"></i>
                            <div class="fs-5 d-inline ms-1" id="account">Account</div>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="login">Login</a></li>
                            <li><a class="dropdown-item" href="register">Register</a></li>
                            <li><a class="dropdown-item" href="forgot-password">Forgot Password</a></li>
                        </ul>
                        </c:when>
                        <c:otherwise>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                           aria-expanded="false">
                            <i class="fa-solid fa-circle-user" style="font-size: 20px"></i>
                            <div class="fs-5 d-inline ms-1">${sessionScope.currentUser.username}</div>
                        </a>
                        <ul class="dropdown-menu">
                            <li data-bs-toggle="modal" data-bs-target="#ModalChangePass" data-bs-dismiss="modal"
                                style="cursor: pointer">
                                <a class="dropdown-item">Change Password</a>
                            </li>
                            <li data-bs-toggle="modal" data-bs-target="#exampleModal6" data-bs-dismiss="modal"
                                style="cursor: pointer">
                                <a class="dropdown-item" href="#">Edit Profile</a>
                            </li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li style="cursor: pointer"><a class="dropdown-item" href="log-out">Log out</a></li>
                        </ul>
                        </c:otherwise>
                        </c:choose>
                </ul>
                </li>
                <li class="ms-3 nav-item d-flex align-items-center">
                    <input type="checkbox" class="checkbox" id="tonggleTheme">
                    <label for="tonggleTheme" class="label">
                        <i class="bi bi-moon-stars-fill moon"></i>
                        <i class="bi bi-brightness-alt-high sun"></i>
                        <div class='ball'></div>
                    </label>
                </li>
                </ul>
            </div>
        </div>
    </nav>
</header>