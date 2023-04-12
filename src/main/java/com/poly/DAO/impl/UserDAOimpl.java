package com.poly.DAO.impl;

import com.poly.DAO.AbstractDAO;
import com.poly.DAO.UserDAO;
import com.poly.constant.NamedStored;
import com.poly.entity.User;
import com.poly.utils.JpaUtils;
import com.poly.utils.QueryParamemter;

import java.util.List;
import java.util.Map;

public class UserDAOimpl extends AbstractDAO<User> implements UserDAO {

    @Override
    public User findById(Integer id) {
        return super.findById(User.class, id);
    }

    @Override
    public User findByEmail(String email) {
        String nameQuery = "User.findByEmail";
        return super.findOne(nameQuery, User.class, email);
    }

    @Override
    public User findByUsername(String username) {
        String nameQuery = "User.findByUsername";
        return super.findOne(nameQuery, User.class, username);

    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
//        String sql="SELECT o FROM User o WHERE o.username= ?1 AND o.password= ?1";
        String nameQuery = "User.findByUsernameAndPassword";
        List<QueryParamemter> qprt = List.of(
                new QueryParamemter("username", username),
                new QueryParamemter("password", password)
        );
        List<User> users = JpaUtils.excuteQuery(nameQuery, qprt, JpaUtils.NAME_QUERY);
//        return super.findOne(nameQuery, User.class, username, password);
        return users.size() > 0 ? users.get(0) : null;
    }

    @Override
    public List<User> findAll() {
        return super.findAll(User.class, true);
    }

    @Override
    public List<User> findAll(int pageNumber, int pageSize) {
        return super.findAll(User.class, true, pageNumber, pageSize);
    }

    @Override
    public List<User> findUserLikeVideoByVideoHref(Map<String, Object> params) {
        return super.callStore(NamedStored.FIND_USER_LIKE_VIDEO_BY_VIDEO_HREF, params);
    }

    @Override
    public User create(User entity) {
        return super.create(entity);
    }

    @Override
    public User update(User entity) {
        return super.update(entity);
    }

    @Override
    public User delete(User entity) {
        return super.delete(entity);
    }
}
