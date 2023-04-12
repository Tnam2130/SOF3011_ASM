package com.poly.DAO.impl;

import com.poly.DAO.AbstractDAO;
import com.poly.DAO.VideoDAO;
import com.poly.entity.Video;

import java.util.List;

public class VideoDAOimpl extends AbstractDAO<Video> implements VideoDAO {
    @Override
    public Video findByID(Integer id) {
        return super.findById(Video.class, id);
    }

    @Override
    public Video findByHref(String href) {
        String nameQuery="Video.findByHref";
        return super.findOne(nameQuery,Video.class, href);
    }

    @Override
    public List<Video> findAll() {
        return super.findAll(Video.class, true);
    }

    @Override
    public List<Video> findAll(String column) {
        return super.findAll(Video.class, true, true, column);
    }


    @Override
    public List<Video> findAll(int PageNumber, int PageSixe) {
        return super.findAll(Video.class, true, PageNumber, PageSixe);
    }

    @Override
    public List<Video> findAll(int pageNumber, int pageSize, String column) {
        return super.findAll(Video.class, true, pageNumber, pageSize, true, column);
    }

    @Override
    public Video create(Video entity) {
        return super.create(entity);
    }

    @Override
    public Video update(Video entity) {
        return super.update(entity);
    }

    @Override
    public Video delete(Video entity) {
        return super.delete(entity);
    }
}
