package com.poly.controllers;

import com.poly.DAO.UserDAO;
import com.poly.DAO.VideoDAO;
import com.poly.DAO.impl.UserDAOimpl;
import com.poly.DAO.impl.VideoDAOimpl;
import com.poly.entity.Video;
import com.poly.service.UserService;
import com.poly.service.impl.UserServiceImpl;
import com.poly.utils.JpaUtils;
import com.poly.utils.QueryParamemter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        VideoDAO vdDao = new VideoDAOimpl();
        UserDAO dao = new UserDAOimpl();
        UserService userService = new UserServiceImpl();

        String username= "admin";
        String password="1234";
//        String email="user@gmail.com";
//        User user = userService.create(username, password, email);
//        System.out.println(user.getUsername());
//        System.out.println(dao.findByUsernameAndPassword(username,password).getUsername());
        String href="-7sISWuTdj0";
//        System.out.println(vdDao.findByHref(href).getHref());
//        System.out.println(test(href));
    }
//    public static boolean test(String href) {
//        EntityManager entityManger = JpaUtils.getEntityManager();
//        String jqpl = " SELECT o FROM o.Video WHERE o.href = :href ";
//        Query query = entityManger.createNamedQuery(jqpl, Video.class);
////        query.setParameter(1, href);
////        List<Video> list = query.getResultList();
////        System.out.println(list.get(0));
//        List<QueryParamemter> queryParamemters= List.of(
//                new QueryParamemter("href", href)
//        );
//        List<Video> list=JpaUtils.excuteQuery(, queryParamemters, JpaUtils.NAME_QUERY);
//        System.out.println(list.get(0));
//        return list.size()>0;
//    }
}
