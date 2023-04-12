<nav id="sidebarMenu" class="collapse d-lg-block sidebar collapse">
  <div>
    <div class="list-group list-group-flush me-2 mt-4">
      <a href="${pageContext.request.contextPath}/home" class="list-group-item list-group-item-action py-2 ripple sidebar-item ${active == 'home' ? 'active' : ''}"
         aria-current="true">
        <i class="fa-solid fa-house me-3"></i><span>Home</span>
      </a>
      <a href="#" class="list-group-item list-group-item-action py-2 ripple sidebar-item" aria-current="true">
        <i class="fa-regular fa-hand-point-right me-3"></i><span>Recommended</span>
      </a>
      <a href="${pageContext.request.contextPath}/favorites" class="list-group-item list-group-item-action py-2 ripple sidebar-item">
        <i class="fa-sharp fa-solid fa-bookmark me-3"></i><span>My Favourites</span>
      </a>
      <a href="#" class="list-group-item list-group-item-action py-2 ripple sidebar-item">
        <i class="bi bi-camera-video-fill me-3"></i><span>My Videos</span>
      </a>
      <a href="#" class="list-group-item list-group-item-action py-2 ripple sidebar-item"><i
              class="bi bi-hand-thumbs-up me-3"></i><span>Video Liked</span></a>
      <a href="${pageContext.request.contextPath}/history" class="list-group-item list-group-item-action py-2 ripple sidebar-item"><i
              class="fa-solid fa-clock-rotate-left me-3"></i><span>History</span></a>
    </div>
  </div>
</nav>
<script>
    $(`.list-group a`).click(function (){
        // $(`.list-group .sidebar-item .active`).removeClass(`active`);
        // $(this).parent().addClass(`active`);
        $(`a.sidebar-item.active`).each(function (){
          $(this).removeClass(`active`);
        })
        $(this).addClass(`active`);
    });
</script>