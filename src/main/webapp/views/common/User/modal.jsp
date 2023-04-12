<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"--%>
<%--        integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ=="--%>
<%--        crossorigin="anonymous" referrerpolicy="no-referrer"></script>--%>

<%--<div class="modal fade" id="exampleModal3" tabindex="-1" aria-labelledby="exampleModalToggleLabel2"--%>
<%--     aria-hidden="true">--%>
<%--    <div class="modal-dialog">--%>
<%--        <div class="modal-content">--%>
<%--            <div class="modal-header">--%>
<%--                <h5 class="modal-title" id="exampleModal3">SEND VIDEO TO YOUR FRIEND</h5>--%>
<%--                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>--%>
<%--            </div>--%>
<%--            <div class="modal-body">--%>
<%--                <form>--%>
<%--                    <div class="mb-3">--%>
<%--                        <label for="email" class="col-form-label">YOUR FRIEND'S EMAIL?</label>--%>
<%--                        <input type="email" class="form-control" id="email">--%>
<%--                    </div>--%>
<%--                </form>--%>
<%--            </div>--%>
<%--            <div class="modal-footer">--%>
<%--                <button type="button" class="btn btn-primary">Send</button>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<!-- modal Change Password -->
<div class="modal fade" id="ModalChangePass" tabindex="-1" aria-labelledby="exampleModalToggleLabel2"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="ChangePassTitle">Change Password</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="mb-3">
                        <div class="form-floating mb-3">
                            <input type="password" class="form-control" name="currentPass" id="currentPass" placeholder="Current Password" required>
                            <label for="currentPass" class="col-form-label">Current Password</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="password" class="form-control" name="newPass" id="newPass" placeholder="New Password" required>
                            <label for="newPass" class="col-form-label">New Password</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="password" class="form-control" id="confPass" placeholder="Confirm Password" required>
                            <label for="confPass" class="col-form-label">Confirm Password</label>
                        </div>
                    </div>
                </form>
            </div>
            <p class="fs-6 text-danger" id="msgChange"></p>
            <div class="modal-footer">
                <button type="submit" class="btn btn-primary" id="changeBtn">Change</button>
            </div>
        </div>
    </div>
</div>