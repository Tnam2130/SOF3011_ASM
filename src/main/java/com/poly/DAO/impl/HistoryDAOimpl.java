package com.poly.DAO.impl;

import com.poly.DAO.AbstractDAO;
import com.poly.DAO.HistoryDAO;
import com.poly.entity.History;
import com.poly.utils.JpaUtils;
import com.poly.utils.QueryParamemter;

import java.util.List;

public class HistoryDAOimpl extends AbstractDAO implements HistoryDAO {
    @Override
    public List<History> findByUser(String username) {
        String nameQuery="History.findByUser";
        List<QueryParamemter> qprt = List.of(
                new QueryParamemter("username",username)
        );
        List<History> history = JpaUtils.excuteQuery(nameQuery, qprt, JpaUtils.NAME_QUERY);
        return history;
    }

    @Override
    public List<History> findByUserAndIsLiked(String username) {
        String nameQuery="History.findByUserAndIsLiked";
        List<QueryParamemter> qprt = List.of(
                new QueryParamemter("username",username)
        );
        List<History> history = JpaUtils.excuteQuery(nameQuery, qprt, JpaUtils.NAME_QUERY);
        return history;
    }

    @Override
    public History findByUserIdAndVideoId(Integer userId, Integer videoId) {
        String nameQuery="History.findByUserIdAndVideoId";
        List<QueryParamemter> qprt = List.of(
                new QueryParamemter("uid", userId),
                new QueryParamemter("vid", videoId)
        );
        List<History> history = JpaUtils.excuteQuery(nameQuery, qprt, JpaUtils.NAME_QUERY);
        return history.size() > 0 ? history.get(0) : null;
//        return (History) super.findOne(nameQuery, History.class, userId, videoId);
    }

    @Override
    public History create(History entity) {
        return (History) super.create(entity);
    }

    @Override
    public History update(History entity) {
        return (History) super.update(entity);
    }
}
