package com.poly.controllers.web;

import com.poly.constant.SessionAttri;
import com.poly.entity.History;
import com.poly.entity.User;
import com.poly.entity.Video;
import com.poly.service.HistoryService;
import com.poly.service.VideoService;
import com.poly.service.impl.HistoryServiceImpl;
import com.poly.service.impl.VideoServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(urlPatterns = {"/video"})
public class VideoController extends HttpServlet {
    private VideoService videoService = new VideoServiceImpl();
    private HistoryService historyService = new HistoryServiceImpl();
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionParam = request.getParameter("action");
        request.setAttribute("status", "Create");
        String href = request.getParameter("id");
        HttpSession session = request.getSession();
        switch (actionParam) {
            case "watch":
                doGetWatch(session, href, request, response);
                break;
            case "like":
                doGetLike(session, href, request, response);
                break;
        }
    }
    private void doGetWatch(HttpSession session, String href, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Video video = videoService.findByHref(href);
        request.setAttribute("video", video);
        User currentUser = (User) session.getAttribute(SessionAttri.CURRENT_USER);
        if(currentUser != null){
            History history =historyService.create(currentUser, video);
            request.setAttribute("flagLikeBtn",history.getIsLiked());
        }
        request.setAttribute("videos", videoService.findAll());
        request.getRequestDispatcher("/views/web/VideoDetail.jsp").forward(request, response);

    }

    private void doGetLike(HttpSession session, String href, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        User currentUser = (User) session.getAttribute(SessionAttri.CURRENT_USER);
        boolean result = historyService.updateLikeOrUnLike(currentUser, href);
        if(result){
            response.setStatus(204);//Success but no return data
        }else {
            response.setStatus(400);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
