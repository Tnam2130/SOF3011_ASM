package com.poly.service.impl;

import com.poly.DAO.VideoDAO;
import com.poly.DAO.impl.VideoDAOimpl;
import com.poly.entity.Video;
import com.poly.service.VideoService;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class VideoServiceImpl implements VideoService {
    private final VideoDAO dao= new VideoDAOimpl();

    @Override
    public Video findByID(Integer id) {
        return dao.findByID(id);
    }

    @Override
    public Video findByHref(String href) {
        return dao.findByHref(href);
    }

    @Override
    public List<Video> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Video> findAll(String column) {
        return dao.findAll(column);
    }

    @Override
    public List<Video> findAll(int pageNumber, int pageSize) {
        return dao.findAll(pageNumber, pageSize);
    }

    @Override
    public List<Video> findAll(int pageNumber, int pageSize, String column) {
        return dao.findAll(pageNumber, pageSize, column);
    }

    @Override
    public Video create(Video entity) {
        return dao.create(entity);
    }

    @Override
    public Video update(Video entity) {
        return dao.update(entity);
    }

    @Override
    public Video delete(String href) {
        Video entity =findByHref(href);
        entity.setIsActive(false);
        return dao.update(entity);
    }
}
