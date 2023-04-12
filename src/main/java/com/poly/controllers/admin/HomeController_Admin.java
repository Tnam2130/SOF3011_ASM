package com.poly.controllers.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poly.Dto.UserDto;
import com.poly.Dto.VideoLiked;
import com.poly.constant.SessionAttri;
import com.poly.entity.User;
import com.poly.entity.Video;
import com.poly.service.StaticalService;
import com.poly.service.UserService;
import com.poly.service.VideoService;
import com.poly.service.impl.StaticalServiceImpl;
import com.poly.service.impl.UserServiceImpl;
import com.poly.service.impl.VideoServiceImpl;
import com.poly.utils.EmailUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/admin", "/admin/fav", "/CRUD-Video", "/Share"})
public class HomeController_Admin extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StaticalService staticalService = new StaticalServiceImpl();
    private VideoService videoService = new VideoServiceImpl();
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute(SessionAttri.CURRENT_USER);
        if (currentUser != null && currentUser.isAdmin() == Boolean.TRUE) {
            String path = request.getServletPath();
            String href = request.getParameter("id");
            switch (path) {
                case "/admin":
                    doGetAdmin(request, response);
                    break;
                case "/admin/fav":
                    doGetFavorites(request, response);
                    break;
                case "/CRUD-Video":
                    doGetCRUDVideo(session, request, response);
                    break;
                case "Edit":
                    doGetEdit(href, request, response);
                    break;
                case "Delete":
                    doGetDelete(href, request, response);
                    break;
            }
        } else {
            response.sendRedirect("home");
        }
    }

    private void doGetAdmin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<VideoLiked> videoLikes = staticalService.find_VideoLike();
        request.setAttribute("videos", videoLikes);
        request.getRequestDispatcher("/views/admin/Dashboard.jsp").forward(request, response);

    }

    private void doGetFavorites(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        String VideoHref = request.getParameter("Href");
        List<UserDto> users = userService.findUserLikedByVideoHref(VideoHref);
        if (users.isEmpty()) {
            response.setStatus(400);
        } else {
            ObjectMapper mapper = new ObjectMapper();
            String dataResponse = mapper.writeValueAsString(users);
            response.setStatus(200);
            out.print(dataResponse);
            out.flush();
        }

    }

    private void doGetCRUDVideo(HttpSession session, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("videos", videoService.findAll("Id"));
        request.setAttribute("active", "CRUD_video");
        request.setAttribute("status", "Create");
        request.getRequestDispatcher("/views/admin/CRUDVideo.jsp").forward(request, response);
    }

    private void doGetEdit(String href, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        Video editVideo = videoService.findByHref(href);
        request.setAttribute("form", editVideo);
        request.setAttribute("status", "Update");
        request.setAttribute("videos", videoService.findAll("Id"));
        request.setAttribute("active", "CRUD-Video");
        request.getRequestDispatcher("/views/admin/CRUDVideo.jsp").forward(request, response);
    }

    private void doGetDelete(String href, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        videoService.delete(href);
        request.setAttribute("status", "Create");
        request.setAttribute("videos", videoService.findAll("Id"));
        request.setAttribute("active", "CRUD-Video");
        request.getRequestDispatcher("/views/admin/CRUDVideo.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");
            String status = request.getParameter("submitButton");
            if (status != null) {
                switch (status) {
                    case "Create":
                        doPostCreate(request, response);
                        break;
                    case "Update":
                        doPostUpdate(request, response);
                        break;
                }
            }
            request.setAttribute("status", "Create");
            request.setAttribute("videos", videoService.findAll("Id"));
            request.setAttribute("active", "CRUD-Video");
            request.getRequestDispatcher("/views/admin/CRUDVideo.jsp").forward(request, response);

    }

    private void doPostShare(String href, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        String email = request.getParameter("Email");
        response.setStatus(204);
//        emailService.sendMail(getServletContext(), email, href, "shareVideo");

    }

    private void doPostCreate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        videoService.create(GetVideo(request));
    }

    private void doPostUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        videoService.update(GetVideo(request));
    }

    private Video GetVideo(HttpServletRequest request) {
        Video video = new Video();
        video.setHref(request.getParameter("Href"));
        video.setTitle(request.getParameter("Title"));
        video.setDescription(request.getParameter("description"));
        video.setIsActive(Boolean.TRUE);
        video.setViews(0);
        video.setShares(0);
        return video;
    }
}
