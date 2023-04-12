package com.poly.service;

import com.poly.entity.Video;

import java.util.List;

public interface VideoService {
    Video findByID(Integer id);

    Video findByHref(String href);

    List<Video> findAll();
    List <Video> findAll(String column);
    List<Video> findAll(int pageNumber, int pageSize);
    List<Video> findAll(int pageNumber, int pageSize, String column);

    Video create(Video entity);

    Video update(Video entity);

    Video delete(String href);
}
