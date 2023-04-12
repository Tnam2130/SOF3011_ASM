package com.poly.controllers.web;

import com.poly.DAO.UserDAO;
import com.poly.DAO.impl.UserDAOimpl;
import com.poly.constant.SessionAttri;
import com.poly.entity.User;
import com.poly.service.UserService;
import com.poly.service.impl.UserServiceImpl;
import com.poly.utils.EmailUtils;
import com.poly.utils.RandomNumberUtil;
import jakarta.mail.MessagingException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AccountController", urlPatterns = {"/login", "/register", "/log-out", "/forgot-password", "/changePass"})
public class AccountController extends HttpServlet {
    UserService userService = new UserServiceImpl();
    String rdn = new RandomNumberUtil().getRandomNumberString();
    UserDAO dao = new UserDAOimpl();
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String path = request.getServletPath();
        switch (path) {
            case "/login":
                doGetLogin(request, response);
                break;
            case "/register":
                doGetRegister(request, response);
                break;
            case "/log-out":
                doGetLogout(session, request, response);
                break;
            case "/forgot-password":
                doGetForgotPass(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String path = req.getServletPath();
        switch (path) {
            case "/login":
                doPostLogin(session, req, resp);
                break;
            case "/register":
                doPostRegister(session, req, resp);
                break;
            case "/forgot-password":
                try {
                    doPostForgotPass(req, resp);
                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/changePass":
                doPostChangePass(session, req, resp);
                break;
        }
    }

    private void doGetLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/web/login.jsp").forward(request, response);
    }

    private void doPostLogin(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            User user = userService.login(username, password);
            if (user != null) {
                session.setAttribute(SessionAttri.CURRENT_USER, user);
                response.sendRedirect("home");
            } else {
                request.setAttribute("message", "Đăng nhập thất bại!");
                response.sendRedirect("login");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void doGetRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/web/register.jsp").forward(request, response);
    }

    private void doPostRegister(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        try {
            User user = userService.create(username, password, email);
            if (user != null) {
                session.setAttribute(SessionAttri.CURRENT_USER, user);
                response.sendRedirect("home");
            } else {
                request.setAttribute("message", "Đăng ký thất bại!");
                response.sendRedirect("register");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void doGetLogout(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session.removeAttribute(SessionAttri.CURRENT_USER);
        response.sendRedirect("home");
    }

    private void doGetForgotPass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/web/forgot.jsp").forward(request, response);
    }

    private void doPostForgotPass(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, MessagingException {
        response.setContentType("application/json");
        String email = request.getParameter("email");
        User existUser = userService.findByEmail(email);
        if (existUser != null && email.trim().equals(existUser.getEmail().trim())) {
            existUser.setPassword(rdn);
            EmailUtils.sendPassword(rdn, email);
            System.out.println(rdn);
            dao.update(existUser);
            response.setStatus(204);
        } else {
            response.setStatus(400);
        }
    }

    private void doPostChangePass(HttpSession session, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        String curPass= request.getParameter("currentPass");
        String newPass=request.getParameter("newPass");
        System.out.println(newPass);
        System.out.println(curPass);
        User currentUser= (User) session.getAttribute(SessionAttri.CURRENT_USER);
        if(curPass.equals(currentUser.getPassword())){
            System.out.println(currentUser.getPassword());
            currentUser.setPassword(newPass);
            User updatedUser = userService.update(currentUser);
            if(updatedUser != null){
                session.setAttribute(SessionAttri.CURRENT_USER, updatedUser);
                response.setStatus(204);
            }else{
                response.setStatus(400);
            }
        }else{
            response.setStatus(400);
        }
    }
}
