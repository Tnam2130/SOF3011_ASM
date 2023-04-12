package com.poly.controllers.web;


import com.poly.constant.SessionAttri;
import com.poly.entity.History;
import com.poly.entity.User;
import com.poly.entity.Video;
import com.poly.service.HistoryService;
import com.poly.service.VideoService;
import com.poly.service.impl.HistoryServiceImpl;
import com.poly.service.impl.VideoServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet( urlPatterns = {"/home", "/favorites", "/history"})
public class HomeController extends HttpServlet {
    private final VideoService videoService = new VideoServiceImpl();
    private final HistoryService historyService = new HistoryServiceImpl();
    private final int VIDEO_MAX_PAGE_SIZE=2;
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String path = request.getServletPath();
        switch (path) {
            case "/home":
                doGetHome(request, response);
                break;
            case "/favorites":
                doGetFavorites(session, request, response);
                break;
            case "/history":
                doGetHistory(session, request, response);
                break;
        }

    }

    private void doGetHome(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Video> countVideos= videoService.findAll();
        int maxPage= (int)Math.ceil(countVideos.size() / (double)VIDEO_MAX_PAGE_SIZE);
        request.setAttribute("maxPage",maxPage);
        List<Video> video;
        String pageNumber= request.getParameter("page");
        if(pageNumber==null || Integer.valueOf(pageNumber) > maxPage){
            video = videoService.findAll(1, VIDEO_MAX_PAGE_SIZE);
            request.setAttribute("currentPage", 1);
        }else{
            video=videoService.findAll(Integer.valueOf(pageNumber), VIDEO_MAX_PAGE_SIZE);
            request.setAttribute("currentPage", pageNumber);
        }
        request.setAttribute("active", "home");
        request.setAttribute("videos", video);
        request.getRequestDispatcher("/views/web/home.jsp").forward(request, response);
    }

    private void doGetFavorites(HttpSession session, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user =(User) session.getAttribute(SessionAttri.CURRENT_USER);
        if (user == null){
            request.getRequestDispatcher("/views/web/login.jsp").forward(request,response);
        }else{
            List<History> histories = historyService.findByUserAndIsLiked(user.getUsername());
            List<Video> videos=new ArrayList<>();
            histories.forEach(item -> videos.add(item.getVideo()));
            request.setAttribute("videos", videos);
            request.getRequestDispatcher("/views/web/favorites.jsp").forward(request, response);
        }
    }

    private void doGetHistory(HttpSession session, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user =(User) session.getAttribute(SessionAttri.CURRENT_USER);
        if(user==null){
            request.getRequestDispatcher("/views/web/login.jsp").forward(request,response);
        }else{
            List<History> histories = historyService.findByUser(user.getUsername());
            List<Video> videos = new ArrayList<>();
            histories.forEach(item -> videos.add(item.getVideo()));
            request.setAttribute("videos", videos);
            request.getRequestDispatcher("/views/web/history.jsp").forward(request, response);
        }
    }

}
