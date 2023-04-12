<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="pagination container d-flex justify-content-center py-5">
    <nav aria-label="...">
        <ul class="pagination">
            <li class="page-item ${currentPage == 1 ? 'disabled' : ''}">
                <a href="home?page=1" class="page-link">Previous</a>
            </li>
            <c:forEach varStatus="i" begin="1" end="${maxPage}">
                <li class="page-item ${currentPage == i.index ? 'active': ''}"><a class="page-link"
                                                                                  href="home?page=${i.index}">${i.index}</a>
                </li>
            </c:forEach>
            <li class="page-item ${currentPage == maxPage ? 'disabled': ''}">
                <a class="page-link" href="home?page=${maxPage}">Next</a>
            </li>
        </ul>
    </nav>
</div>
